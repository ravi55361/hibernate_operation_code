package org.jsp.onetooneuni.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PanCard {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String number;
private LocalDate dob;
private int pincode;
public int getId() {
	return id;
}
public String getNumber() {
	return number;
}
public LocalDate getDob() {
	return dob;
}
public int getPincode() {
	return pincode;
}
public void setId(int id) {
	this.id = id;
}
public void setNumber(String number) {
	this.number = number;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
}
