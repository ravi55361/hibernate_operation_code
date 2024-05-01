package org.jsp.test.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.test.dto.Batch;

public class BatchbySubject {
public static void main(String[] args) {
	EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction t = m.getTransaction();
	System.out.println("enter batch  subject to find details!!");
	Scanner sc = new Scanner(System.in);
	String sub = sc.next();
	String qry = "select b from Batch b where b.subject=?1";
	Query q = m.createQuery(qry);
	q.setParameter(1, sub);
	List<Batch> batchs = q.getResultList();
	if (batchs.size() > 0) {
		for (Batch b : batchs) {
			System.out.println("batch id:" + b.getId());
			System.out.println("batch code:" + b.getCode());
			System.out.println("batch subject:" + b.getSubject());
			System.out.println("batch trainer" + b.getTrainer());
		}
	} else
		System.err.println("Invalid Name!!!");
}
}
