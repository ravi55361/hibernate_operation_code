package org.jsp.persistance.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.persistance.dto.Person;

public class DeletePerson {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.println("Enter Person id to delete the records!!!");
		int id = sc.nextInt();
		Person p = manager.find(Person.class, id);
		if (p != null) {
			manager.remove(p);
			EntityTransaction t = manager.getTransaction();
			t.begin();
			t.commit();
		}
		else
			System.err.println("You have entered invalid id!!!");
		sc.close();
		manager.close();
	}

}
