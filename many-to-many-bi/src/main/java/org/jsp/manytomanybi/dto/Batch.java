package org.jsp.manytomanybi.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String subject, trainer;
	@Column(unique = true, nullable = false)
	private String code;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "batch_student", joinColumns = {
			@JoinColumn(name = "batch_id") }, inverseJoinColumns = {
					@JoinColumn(name = "student_id") })
	private List<Student> students;

	public int getId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public String getTrainer() {
		return trainer;
	}

	public String getCode() {
		return code;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
