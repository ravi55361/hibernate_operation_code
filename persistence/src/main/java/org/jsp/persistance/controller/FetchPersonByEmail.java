package org.jsp.persistance.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.persistance.dto.Person;

public class FetchPersonByEmail {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person Email to fetch details!!!");
		String email = sc.next();
		Query qry = manager.createNamedQuery("VerifyByEmailId");
		qry.setParameter(1, email);

		try {
			Person p = (Person) qry.getSingleResult();
			System.out.println("Person Id : " + p.getId());
			System.out.println("Person Name : " + p.getName());
			System.out.println("Person Email-Id : " + p.getEmail());
			System.out.println("Person Phone Number : " + p.getPhone());
			System.out.println("Person Age : " + p.getAge());
			System.out.println("-----**********-----");

		} catch (Exception e) {
			System.err.println("You have entered invalid email-id!!!");
		}

		sc.close();
		manager.close();
	}
}
