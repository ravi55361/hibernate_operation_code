package org.jsp.compositekey.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Person {
	private String name;
	private String password;
	@EmbeddedId
	private PersonId id;

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public PersonId getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(PersonId id) {
		this.id = id;
	}
}
