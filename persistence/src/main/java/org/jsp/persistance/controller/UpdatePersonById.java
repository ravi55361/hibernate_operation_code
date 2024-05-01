package org.jsp.persistance.controller;

import java.util.Scanner;

import javax.persistence.*;

import org.jsp.persistance.dto.Person;

public class UpdatePersonById {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter person id to update the records!!!");
		int id = sc.nextInt();
		Person p = new Person();
		p.setId(id);
		System.out.println("Enter Person Name");
		p.setName(sc.next());
		System.out.println("Enter Person Email-Id");
		p.setEmail(sc.next());
		System.out.println("Enter Person Age");
		p.setAge(sc.nextInt());
		System.out.println("Enter Person Phone Number");
		p.setPhone(sc.nextLong());
		System.out.println("Enter Person Password");
		p.setPassword(sc.next());
		manager.merge(p);
		EntityTransaction transation = manager.getTransaction();
		transation.begin();
		transation.commit();
		sc.close();
		manager.close();
		System.out.println("Person updated!!!");
	}

}
