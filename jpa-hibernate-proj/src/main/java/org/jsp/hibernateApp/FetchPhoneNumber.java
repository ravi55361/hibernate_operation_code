package org.jsp.hibernateApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchPhoneNumber {

	public static void main(String[] args) {
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		String qry="select u.phone from User u";
		Query<Long> q=s.createQuery(qry);
		List<Long> phoneNumber=q.getResultList();
		for(long ph:phoneNumber)
		{
			System.out.println("---------------*****************-----------");
			System.out.println("User Phone Number :"+ph);
		}
		s.close();
	}
}
