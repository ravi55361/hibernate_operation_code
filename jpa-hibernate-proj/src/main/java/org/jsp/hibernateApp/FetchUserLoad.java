package org.jsp.hibernateApp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchUserLoad {

	public static void main(String[] args) {
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the UserId to print details!!!");
		int id=sc.nextInt();
		User u=s.load(User.class,id);
		try {
			System.out.println("User id :"+u.getId());
			System.out.println("User Name :"+u.getName());
			System.out.println("User Phone :"+u.getPhone());
			System.out.println("User Email :"+u.getEmail());
			System.out.println("User Address :"+u.getAddress());
		}
		catch (Exception e) {
			System.out.println("You have entered invalid id!!!");
		}
		sc.close();
		s.close();
	}

}
