package org.jsp.jpahibernatedemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdeteUser {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your id to update");
		int id=s.nextInt();
		System.out.println("Enter your name,phone,and password to update");
		String name=s.next();
		long phone=s.nextLong();
		String password=s.next();
		User u=new User();
		u.setId(id);
		u.setName(name);
		u.setPhone(phone);
		u.setPassword(password);
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		manager.merge(u);
		transaction.begin();
		transaction.commit();
		s.close();	
	}	
}
