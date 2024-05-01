package org.jso.onetoonebi.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jso.onetoonebi.dto.AadharCard;
import org.jso.onetoonebi.dto.Person;

public class FetchPersonAndAadharById {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person Id To Fetch Records!!!!");
		int id = sc.nextInt();
		Person person = manager.find(Person.class, id);
		if (person != null) {
			AadharCard card = person.getCard();
			if (card != null) {
				System.out.println("Id: " + card.getId());
				System.out.println("Aadhar Number: " + card.getNumber());
				System.out.println("Date Of Birth Of Person: " + card.getDob());
				System.out.println("Person Pincode: " + card.getPincode());
			}
		} else {
			System.err.println("Invalid Person Id!!!");
		}
		sc.close();
	}

}
