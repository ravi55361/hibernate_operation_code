package org.jsp.hibernateApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserId {
	public static void main(String[] args) {
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		String qry="select u.id from User u";
		Query<Integer> q=s.createQuery(qry);
		List<Integer> userId=q.getResultList();
		for(int id:userId)
		{
			System.out.println("User Id : "+id);
			System.out.println("---------****************-----------");
		}
		s.close();
	}
}
