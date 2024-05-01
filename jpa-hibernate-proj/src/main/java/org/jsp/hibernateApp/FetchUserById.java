package org.jsp.hibernateApp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchUserById {
	public static void main(String[] args) {
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the user id to display details!!!");
		int id=sc.nextInt();
		User u=s.get(User.class,id);
		if(u!=null)
		{
			System.out.println("User id :"+u.getId());
			System.out.println("User Name :"+u.getName());
			System.out.println("User Email :"+u.getEmail());
			System.out.println("User Phone :"+u.getPhone());
			System.out.println("User Address :"+u.getAddress());
		}
		else {
			System.err.println("You entered Invalid Id!!! :"+id);
		}
		sc.close();
		s.close();
	}
}
