package org.jsp.test.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.test.dto.Batch;

public class FindBatchById {

	public static void main(String[] args) {
		EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t = m.getTransaction();
		System.out.println("enter batch id to find details!!");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		Batch b = m.find(Batch.class, id);
		if (b != null) {
			System.out.println("batch id:" + b.getId());
			System.out.println("batch code:" + b.getCode());
			System.out.println("batch subject:" + b.getSubject());
			System.out.println("batch trainer" + b.getTrainer());
		} else
			System.err.println("Invalid Id!!!");

	}

}
