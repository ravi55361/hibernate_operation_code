package org.jsp.hibernateApp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchIdByUserInputName {

	public static void main(String[] args) {
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User name to display to User Id!!!");
		String name=sc.next();
		String qry="select u.id from User u where u.name=?1";
		Query<Integer> q=s.createQuery(qry);
		q.setParameter(1, name);
		List<Integer> userId=q.getResultList();
		if(userId.size()>0)
		{
			for(int id:userId)
			{
				System.out.println("User Id: "+id);
				System.out.println("----------***************-----------");
			}
		}
		else
			System.err.println("You Have entered invalid name!!!");
		s.close();
		sc.close();

	}

}
