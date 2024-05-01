package org.jsp.onetooneuni.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false,unique = true)
	private long phone;
	@OneToOne(cascade = {CascadeType.ALL})
	private PanCard card;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public long getPhone() {
		return phone;
	}
	public PanCard getCard() {
		return card;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public void setCard(PanCard card) {
		this.card = card;
	}

}
