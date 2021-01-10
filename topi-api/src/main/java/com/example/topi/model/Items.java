package com.example.topi.model;

public class Items {

	private String name;

	private String html_url;

	private Long forks_count;

	private Owner owner;

	private Long stargazers_count;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getForks_count() {
		return forks_count;
	}

	public void setForks_count(Long forks_count) {
		this.forks_count = forks_count;
	}

	public Long getStargazers_count() {
		return stargazers_count;
	}

	public void setStargazers_count(Long stargazers_count) {
		this.stargazers_count = stargazers_count;
	}

	public String getHtml_url() {
		return html_url;
	}

	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}
