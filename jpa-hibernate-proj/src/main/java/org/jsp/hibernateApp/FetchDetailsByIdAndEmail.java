package org.jsp.hibernateApp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchDetailsByIdAndEmail {
	public static void main(String[] args) {
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User Id to fetch the details!!!");
		int id=sc.nextInt();
		System.out.println("Enter Email-id to verify the details!!!");
		String email=sc.next();
		String qry="select u from User u where u.id=?1 and u.email=?2";
		Query<User> q=s.createQuery(qry);
		q.setParameter(1, id);
		q.setParameter(2, email);
		try {
			User u=q.getSingleResult();
			System.out.println("---------------*****************-----------");
			System.out.println("User Id :"+u.getId());
			System.out.println("User Name :"+u.getName());
			System.out.println("User Phone Number :"+u.getPhone());
			System.out.println("User Email Id :"+u.getEmail());
			System.out.println("User Address :"+u.getAddress());
			System.out.println("---------------*****************-----------");
		} catch (Exception e) {
			System.err.println("Invalid Id and Email-Id!!!");
		}
		s.close();
		sc.close();
	}
}
