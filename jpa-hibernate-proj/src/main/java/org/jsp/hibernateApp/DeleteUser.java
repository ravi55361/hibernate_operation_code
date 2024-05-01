package org.jsp.hibernateApp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class DeleteUser {

	public static void main(String[] args) {
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user id to delete the records!!!");
		int id=sc.nextInt();
		User user=s.get(User.class, id);
		Transaction t=s.beginTransaction();
		if(user!=null)
		{
			s.delete(user);
			t.commit();
			System.out.println("Record Delete Sucessfully!!!");
		}
		else
			System.err.println("You Have Entered Invalid User Id!!!");
		s.close();
		sc.close();
	}
}
