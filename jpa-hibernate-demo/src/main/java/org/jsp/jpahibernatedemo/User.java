package org.jsp.jpahibernatedemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name="user")
@NamedQuery(name="verifyById",query="select u from User u where u.id=?1 and u.password=?2")
@NamedQueries(value= {@NamedQuery(name="fetchNames",query="select u.name from User u"),
@NamedQuery(name="fetchPhoneByName",query="select u.phone from User u where u.name=?1"),
@NamedQuery(name="fetchIdByName",query="select u.id from User u where u.name=?1"),
@NamedQuery(name="fetchNameByPhoneAndPassword",query="select u.name from User u where u.phone=?1 and u.password=?2")})
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name",length=45,nullable=false)
	private  String name;
	@Column(name="phone",nullable=false,unique=true,length=30)
	private long phone;
	@Column(nullable=false,name="password",length=45)
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password =password;
	}

}
