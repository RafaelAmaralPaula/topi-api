package com.example.topi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.topi.model.Items;
import com.example.topi.service.RepositorioService;

@Controller
@RequestMapping("/topi")
public class RepositorioController {
	
	@Autowired
	private RepositorioService repositorioService;

	@PostMapping("/pesquisa")
	public String pesquisarLinguagem(@RequestParam("linguagem") String linguagem) {
		repositorioService.setLinguagem(linguagem);
		return "redirect:/topi/repositorios";
	}
	
	@GetMapping("/pesquisa")
	public String paginaPesquisa() {
		return "pesquisa.html";
	}
	

	@GetMapping("/repositorios")
	public ModelAndView getRepositorio() {
		ModelAndView modelAndView = new ModelAndView("listar");
		List<Items> items = repositorioService.listar();
		for (Items items2 : items) {
			System.out.println(items2.getOwner().getAvatar_url());
		}
		modelAndView.addObject("repositorios", items);
		
		return modelAndView;
	}
	
}
