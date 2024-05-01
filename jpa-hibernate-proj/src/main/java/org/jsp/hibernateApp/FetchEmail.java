package org.jsp.hibernateApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchEmail {
	public static void main(String[] args) {
		String qry="select u.email from User u";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<String> q=s.createQuery(qry);
		List<String> emailId=q.getResultList();
		for(String email:emailId)
		{
			System.out.println("User Email-Id : "+email);
			System.out.println("----------****************----------");
		}
		s.close();
	}
}
