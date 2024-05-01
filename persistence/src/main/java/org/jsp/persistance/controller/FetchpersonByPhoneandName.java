package org.jsp.persistance.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.persistance.dto.Person;

public class FetchpersonByPhoneandName {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Phone to display the details");
		long phone = sc.nextLong();
		System.out.println("Enter Name to verify the details");
		String name = sc.next();
		Query qry = manager.createNamedQuery("VerifyByPhoneAndName");
		qry.setParameter(1, phone);
		qry.setParameter(2, name);
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
			System.err.println("Invalid Phone number or password!!!");
		}
		sc.close();
		manager.close();

	}
}