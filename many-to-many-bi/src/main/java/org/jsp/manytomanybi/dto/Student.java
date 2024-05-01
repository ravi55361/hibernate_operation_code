package org.jsp.manytomanybi.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true, nullable = false)
	private long phone;
	private double percentage;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "students")
	private List<Batch> batches;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getPhone() {
		return phone;
	}

	public double getPercentage() {
		return percentage;
	}

	public List<Batch> getBatches() {
		return batches;
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

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}
}
