package org.jsp.persistance.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.persistance.dto.Person;

public class FetchPersonByPhone {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person Phone to fetch details!!!");
		long phone = sc.nextLong();
		Query qry = manager.createNamedQuery("VerifyByPhoneOnly");
		qry.setParameter(1, phone);
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
			System.err.println("Invalid Phone Number!!!");
		}
		sc.close();
		manager.close();
	}
}
