package org.jsp.compositekey.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.compositekey.dto.Person;
import org.jsp.compositekey.dto.PersonId;

public class SavePerson {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person Name!!!");
		String name = sc.next();
		System.out.println("Enter Person Phone Number!!!");
		long phone = sc.nextLong();
		System.out.println("Enter Person Email-Id!!!");
		String email = sc.next();
		System.out.println("Enter Password!!!");
		String password = sc.next();
		Person p = new Person();
		p.setName(name);
		p.setPassword(password);
		PersonId id = new PersonId();
		id.setEmail(email);
		id.setPhone(phone);
		p.setId(id);
		manager.persist(p);
		transaction.begin();
		transaction.commit();
		System.out.println("Save Records Sucessfully!!!");
		sc.close();
		manager.close();

	}

}
