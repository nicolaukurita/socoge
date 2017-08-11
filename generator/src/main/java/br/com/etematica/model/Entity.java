package br.com.etematica.model;

import java.util.List;

public class Entity {
	Long id;
	String entitySinglular;
	String entityPlural;
	List<Attribute> attributes;
	List<Attribute> attributesList;
	List<Attribute> keys;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEntitySinglular() {
		return entitySinglular;
	}

	public void setEntitySinglular(String nameSinglular) {
		this.entitySinglular = nameSinglular;
	}

	public String getEntityPlural() {
		return entityPlural;
	}

	public void setEntityPlural(String namePlural) {
		this.entityPlural = namePlural;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> atributes) {
		this.attributes = atributes;
	}

	public List<Attribute> getAttributesList() {
		return attributesList;
	}

	public void setAtributesList(List<Attribute> attributesList) {
		this.attributesList = attributesList;
	}

	public List<Attribute> getKeys() {
		return keys;
	}

	public void setKeys(List<Attribute> keys) {
		this.keys = keys;
	}
}
