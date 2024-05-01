package org.jsp.compositekey.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.compositekey.dto.Person;

public class FindByName {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name to fetch the records!!");
		String name = sc.next();
		String gry = "select p from Person p where p.name=?1";
		Query q = manager.createQuery(gry);
		q.setParameter(1, name);
		@SuppressWarnings("unchecked")
		List<Person> persons = q.getResultList();
		if (persons.size() > 0) {
			for (Person p : persons) {
				System.out.println("Name :" + p.getName());
				System.out.println("Email-Id :" + p.getId().getEmail());
				System.out.println("Phone Number :" + p.getId().getPhone());
				System.err.println("----------***************----------");
			}
		} else
			System.err.println("Invalid Name!!!");
		sc.close();
		manager.close();
	}
}
