package org.jsp.hibernateApp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserByIdAndPhone {
	public static void main(String[] args) {
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User Id to fetch the details!!!");
		int id=sc.nextInt();
		System.out.println("Enter Phone number to verify the details!!!");
		long phone=sc.nextLong();
		String qry="select u from User u where u.id=?1 and u.phone=?2";
		Query<User> q=s.createQuery(qry);
		q.setParameter(1, id);
		q.setParameter(2, phone);
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
			System.err.println("Invalid id and phone number!!!");
		}
		s.close();
		sc.close();
	}
}
