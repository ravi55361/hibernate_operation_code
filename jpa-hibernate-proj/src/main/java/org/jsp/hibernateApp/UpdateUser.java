package org.jsp.hibernateApp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateUser {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the user id to update!!!");
		int id=sc.nextInt();
		User u=new User();
		u.setId(id);
		System.out.println("Enter new name!!");
		u.setName(sc.next());
		System.out.println("Enter new phone!!");
		u.setPhone(sc.nextLong());
		System.out.println("Enter new email!!");
		u.setEmail(sc.next());
		System.out.println("Enter new password!!");
		u.setPassword(sc.next());
		System.out.println("Enter new address!!");
		u.setAddress(sc.next());
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		s.saveOrUpdate(u);
		Transaction t=s.beginTransaction();
		t.commit();
		sc.close();
		s.close();
	}

}
