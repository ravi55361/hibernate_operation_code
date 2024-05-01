package org.jsp.hibernateApp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserByEmail {

	public static void main(String[] args) {
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Email-Id to fetch the user deatils!!!");
		String email=sc.next();
		String qry="select u from User u where u.email=:email";
		Query<User> q=s.createQuery(qry);
		q.setParameter("email", email);
		List<User> users=q.getResultList();
		if(users.size()>0)
		{
			for(User u:users)
			{
				System.out.println("---------------*****************-----------");
				System.out.println("User Id :"+u.getId());
				System.out.println("User Name :"+u.getName());
				System.out.println("User Phone Number :"+u.getPhone());
				System.out.println("User Email Id :"+u.getEmail());
				System.out.println("User Address :"+u.getAddress());
				System.out.println("---------------*****************-----------");
			}
		}
		else
			System.err.println("You have entered invalid email-id");
		s.close();
		sc.close();

	}

}
