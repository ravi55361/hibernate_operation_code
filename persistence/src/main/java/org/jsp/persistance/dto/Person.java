package org.jsp.persistance.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "VerifyByAge", query = "select p from Person p where p.age=?1")
@NamedQueries(value = {
		@NamedQuery(name = "VerifyById", query = "select p from Person p where p.id=?1 and p.password=?2"),
		@NamedQuery(name = "VerifyByPhone", query = "select p from Person p where p.phone=?1and p.password=?2"),
		@NamedQuery(name = "VerifyByEmail", query = "select p from Person p where p.email=?1and p.password=?2"),
		@NamedQuery(name = "VerifyByPhoneOnly", query = "select p from Person p where p.phone=?1"),
		@NamedQuery(name = "VerifyByEmailId", query = "select p from Person p where p.email=?1"),
		@NamedQuery(name = "VerifyByIdAndName", query = "select p from Person p where p.id=?1and p.name=?2"),
		@NamedQuery(name = "VerifyByAgeAndName", query = "select p from Person p where p.age=?1 and p.name=?2"),
		@NamedQuery(name = "VerifyByPhoneAndName", query = "select p from Person p where p.phone=?1and p.name=?2"),
		@NamedQuery(name = "VerifyByEmailAndName", query = "select p from Person p where p.email=?1and p.name=?2")})
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	private long phone;

	@Column(nullable = false, unique = true)
	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public long getPhone() {
		return phone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
}
