package org.jsp.compositekey.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.compositekey.dto.Person;

public class findByEmailAndPassword {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Email-Id to fetch the records!!");
		String email = sc.next();
		System.out.println("Enter Password to fetch the records!!");
		String password = sc.next();
		String gry = "select p from Person p where p.id.email=?1 and p.password=?2";
		Query q = manager.createQuery(gry);
		q.setParameter(1, email);
		q.setParameter(2, password);
		System.err.println("----------***************----------");
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println("Name :" + p.getName());
			System.out.println("Email-Id :" + p.getId().getEmail());
			System.out.println("Phone Number :" + p.getId().getPhone());
		} catch (Exception e) {
			System.err.println("Invalid Phone Number Or Email-Id Or Password!!!");
		}
		sc.close();
		manager.close();
	}
}
