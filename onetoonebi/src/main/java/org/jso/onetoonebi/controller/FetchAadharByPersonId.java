package org.jso.onetoonebi.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jso.onetoonebi.dto.AadharCard;

public class FetchAadharByPersonId {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person Id To Fetch Records!!!!");
		int id = sc.nextInt();
//		String qry1="select a from AadharCard a where a.person.id=?1";
		String qry2="select p.card from Person p where p.id=?1";
		Query qry=manager.createQuery(qry2);
		qry.setParameter(1, id);
		try {
			AadharCard card=(AadharCard)qry.getSingleResult();
			System.out.println("Id: " + card.getId());
			System.out.println("Aadhar Number: " + card.getNumber());
			System.out.println("Date Of Birth Of Person: " + card.getDob());
			System.out.println("Person Pincode: " + card.getPincode());
		} catch (Exception e) {
			System.err.println("Invalid Id!!!!");
		}
		sc.close();
	}
}
