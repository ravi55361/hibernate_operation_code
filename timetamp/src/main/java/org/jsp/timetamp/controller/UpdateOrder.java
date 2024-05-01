package org.jsp.timetamp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.timetamp.dto.FoodOrder;

public class UpdateOrder {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to Update the food order!!!");
		int id = sc.nextInt();
		FoodOrder order = manager.find(FoodOrder.class, id);
		System.out.println("Enter Food Name!!");
		order.setFoodName(sc.next());
		System.out.println("Enter Food Cost!!");
		order.setCost(sc.nextDouble());
		manager.persist(order);
		transaction.begin();
		transaction.commit();
		sc.close();
		manager.close();
		System.out.println("Food Order is Updated!!!");
	}
}
