package com.example.topi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.topi.model.Items;
import com.example.topi.model.Repositorio;

@Service
public class RepositorioService {

	private RestTemplate restTemplate;

	private String linguagem;


	public RepositorioService(){
		this.restTemplate = new RestTemplate();
	}

	public UriComponents uri() {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.set("q", "language:"+getLinguagem());
		params.set("&sort", "stars");
		params.add("&page", "1");
		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("https").host("api.github.com")
				.path("/search/repositories").queryParams(params).build();
		return uriComponents;
	}

	public List<Items> listar() {
		UriComponents uri = uri();
		
		ResponseEntity<Repositorio> repositorioResponseEntity = restTemplate.getForEntity(uri.toUriString(), Repositorio.class);
		
		List<Items> items = repositorioResponseEntity.getBody().getItems();
		
		
		return items;
	}

	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
	
	public String getLinguagem() {
		return linguagem;
	}

}