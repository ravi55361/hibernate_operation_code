package org.jsp.persistance.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.persistance.dto.Person;

public class SavePerson {

	public static void main(String[] args) {
		Person p = new Person();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction t= manager.getTransaction();
		p.setAge(23);
		p.setName("Gunjan");
		p.setPhone(9501918061l);
		p.setEmail("gunjan@gmail.com");
		p.setPassword("amisha@2000");		
		manager.persist(p);
		t.begin();
		t.commit();
		System.out.println("Saved record with id " + p.getId());
		manager.close();
		factory.close();
	}
}
