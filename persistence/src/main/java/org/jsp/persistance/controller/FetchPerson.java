package org.jsp.persistance.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.persistance.dto.Person;

public class FetchPerson {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.println("Enter person id to fetch the records!!!!");
		int id = sc.nextInt();
		Person p = manager.find(Person.class, id);
		if (p != null) {
			System.out.println("Person Id : " + p.getId());
			System.out.println("Person Name : " + p.getName());
			System.out.println("Person Email-Id : " + p.getEmail());
			System.out.println("Person Phone Number : " + p.getPhone());
			System.out.println("Person Age : " + p.getAge());
			System.out.println("-----**********-----");

		} else {
			System.err.println("You have entered invalid id!!");
		}
		sc.close();
		manager.close();
	}

}
