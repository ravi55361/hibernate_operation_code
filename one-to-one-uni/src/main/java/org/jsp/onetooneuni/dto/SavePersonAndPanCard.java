package org.jsp.onetooneuni.dto;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePersonAndPanCard {

	public static void main(String[] args) {
		EntityManager manager= Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		Person p=new Person();
		p.setName("Ravi");
		p.setPhone(7004666465l);
		
		PanCard pc=new PanCard();
		pc.setNumber("JRWPS6144H");
		pc.setDob(LocalDate.parse("2001-10-21"));
		pc.setPincode(845438);
		
		p.setCard(pc);
		
		manager.persist(p);
		transaction.begin();
		transaction.commit();
		System.out.println("Person Saved With Id :"+p.getId());

	}

}
