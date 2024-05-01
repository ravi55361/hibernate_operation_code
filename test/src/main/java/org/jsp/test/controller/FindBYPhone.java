package org.jsp.test.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.test.dto.Student;

public class FindBYPhone {

	public static void main(String[] args) {
		EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t = m.getTransaction();
		System.out.println("enter student phone to find details!!");
		Scanner sc=new Scanner(System.in);
		long phone=sc.nextLong();
		String qry="select s from Student s where s.phone=?1";
		Query q=m.createQuery(qry);
		q.setParameter(1, phone);
		try {
			Student s=(Student) q.getSingleResult();
			System.out.println("Student Name:"+s.getName());
			System.out.println("Student Phone:"+s.getPhone());
		} catch (Exception e) {
			System.err.println("Invalid Phone!!!");
		}
        
        
	}

}
