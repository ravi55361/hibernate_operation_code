package org.jsp.persistance.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.persistance.dto.Person;

public class FetchPersonbyAgeandName {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person Age to fetch details!!!");
		int age = sc.nextInt();
		System.out.println("Enter Name to verify the details!!!");
		String name=sc.next();
		Query qry = manager.createNamedQuery("VerifyByAgeAndName");
		qry.setParameter(1, age);
		qry.setParameter(2, name);
		List<Person> ps = qry.getResultList();
		if (ps.size() > 0) {
			for (Person p : ps) {
				System.out.println("Person Id : " + p.getId());
				System.out.println("Person Name : " + p.getName());
				System.out.println("Person Email-Id : " + p.getEmail());
				System.out.println("Person Phone Number : " + p.getPhone());
				System.out.println("Person Age : " + p.getAge());
				System.out.println("-----**********-----");
			}
		} else
			System.err.println("You have entered invalid age or name!!!");
		sc.close();
		manager.close();
	}
}
