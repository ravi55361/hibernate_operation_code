package org.jso.onetoonebi.controller;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jso.onetoonebi.dto.AadharCard;
import org.jso.onetoonebi.dto.Person;

public class SavePersonAndAadhar {

	public static void main(String[] args) {
		Person person = new Person();
		AadharCard card = new AadharCard();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person Name!!");
		person.setName(sc.next());
		System.out.println("Enter Person Phone Number!!!");
		person.setPhone(sc.nextLong());
		System.err.println("-----------***************---------");
		System.out.println("Enter Aadhar Card Number!!!");
		card.setNumber(sc.nextLong());
		System.out.println("Enter Date Of Birth!!!\nThis Format (yyyy-mm-dd)");
		String dob = sc.next();
		card.setDob(LocalDate.parse(dob));
		System.out.println("Enter PinCode!!!");
		person.setCard(card);
		card.setPerson(person);
		card.setPincode(sc.nextInt());
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(person);
		transaction.begin();
		transaction.commit();
        System.out.println("Person Saved With Id: "+person.getId());
        System.err.println("-----***************---------");
        System.out.println("Aadhar Card Saved with Id: "+card.getId());
        sc.close();
		manager.close();
	}

}
