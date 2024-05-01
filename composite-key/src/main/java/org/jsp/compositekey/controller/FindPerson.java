package org.jsp.compositekey.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.compositekey.dto.Person;
import org.jsp.compositekey.dto.PersonId;

public class FindPerson {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.println("Enter Person Phone to finsd the details!!1");
		Scanner sc=new Scanner(System.in);
		long phone=sc.nextLong();
		System.out.println("Enter Person email to finsd the details!!1");
		String email=sc.next();
		PersonId id=new PersonId();
		id.setEmail(email);
		id.setPhone(phone);
		Person p=manager.find(Person.class, id);
		System.err.println("----------***************----------");
		if(p!=null) {
			System.out.println("Name :"+p.getName());
			System.out.println("Email-Id :"+p.getId().getEmail());
			System.out.println("Phone Number :"+p.getId().getPhone());
		}else
			System.err.println("Invalid Phone Or Email-Id");
		sc.close();
		manager.close();
	}

}
