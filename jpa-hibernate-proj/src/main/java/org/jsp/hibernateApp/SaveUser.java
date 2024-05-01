package org.jsp.hibernateApp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveUser {

	public static void main(String[] args) {
		User u=new User();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name!!!");
		String name=sc.nextLine();
		System.out.println("Enter your email!!!");
		String email=sc.nextLine();
		System.out.println("Enter your address!!!");
		String address=sc.nextLine();
		System.out.println("Enter your password!!!");
		String password=sc.nextLine();
		System.out.println("Enter your phone!!!");
		long phone=sc.nextLong();
		sc.close();
		u.setName(name);
		u.setPhone(phone);
		u.setEmail(email);
		u.setAddress(address);
		u.setPassword(password);
		Configuration cfg=new Configuration();
		cfg.configure();
	    SessionFactory factory = cfg.buildSessionFactory();
	    Session s = factory.openSession();
	    int id = (Integer) s.save(u);
	    s.close(); // Close the session after saving
	    System.out.println("User registered with Id: " + id);
	}

}
