package org.jsp.persistance.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.persistance.dto.Person;

public class FetchByIdAndPassword {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to display the details");
		int id = sc.nextInt();
		System.out.println("Enter Password to verify the details");
		String ps = sc.next();
		Query qry = manager.createNamedQuery("VerifyById");
		qry.setParameter(1, id);
		qry.setParameter(2, ps);
		try {
			Person p = (Person) qry.getSingleResult();
			System.err.println();
			System.out.println("Person Id : " + p.getId());
			System.out.println("Person Name : " + p.getName());
			System.out.println("Person Email-Id : " + p.getEmail());
			System.out.println("Person Phone Number : " + p.getPhone());
			System.out.println("Person Age : " + p.getAge());
			System.out.println("---------**********---------");
		} catch (Exception e) {
			System.err.println("Invalid id or password!!!");
		}
		sc.close();
		manager.close();

	}
}
