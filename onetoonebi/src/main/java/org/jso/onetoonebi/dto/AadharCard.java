package org.jso.onetoonebi.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AadharCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true, nullable = false)
	private long number;
	private LocalDate dob;
	private int pincode;
	@OneToOne(mappedBy = "card")
	private Person person;

	public int getId() {
		return id;
	}

	public long getNumber() {
		return number;
	}

	public LocalDate getDob() {
		return dob;
	}

	public int getPincode() {
		return pincode;
	}

	public Person getPerson() {
		return person;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
