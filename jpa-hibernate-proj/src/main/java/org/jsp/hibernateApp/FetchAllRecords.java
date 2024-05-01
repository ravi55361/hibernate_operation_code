 package org.jsp.hibernateApp;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchAllRecords {
	public static void main(String[] args) {
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		String qry="select u from User u";
		Query<User> q=s.createQuery(qry);
		List<User> users=q.getResultList();
		for(User u:users)
		{
			System.out.println("User Id :"+u.getId());
			System.out.println("User Name :"+u.getName());
			System.out.println("User Phone Number :"+u.getPhone());
			System.out.println("User Email Id :"+u.getEmail());
			System.out.println("User Address :"+u.getAddress());
			System.out.println("---------------*****************-----------");
		}
		s.close();
	}
}
