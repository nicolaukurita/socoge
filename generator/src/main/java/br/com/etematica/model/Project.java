package br.com.etematica.model;

import java.util.List;

public class Project {
	Long id;
	String name;
	String directory;
	List<Entity> entities;
	Long frontLanguage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}

	public Long getFrontLanguage() {
		return frontLanguage;
	}

	public void setFrontLanguage(Long frontLanguage) {
		this.frontLanguage = frontLanguage;
	}

}
