package org.jso.onetoonebi.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true, nullable = false)
	private long phone;
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aadharcrad_id")
	private AadharCard card;

	public int getId() {
		return id;
	}

	public long getPhone() {
		return phone;
	}

	public String getName() {
		return name;
	}

	public AadharCard getCard() {
		return card;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCard(AadharCard card) {
		this.card = card;
	}
}
