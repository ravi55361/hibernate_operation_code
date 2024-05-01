package org.jsp.hibernateApp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchPhoneByUserInteredName {
	public static void main(String[] args) {
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User name to display to User Phone Number!!!");
		String name=sc.next();
		String qry="select u.phone from User u where u.name=?1";
		Query<Long> q=s.createQuery(qry);
		q.setParameter(1, name);
		List<Long> phone=q.getResultList();
		if(phone.size()>0)
		{
			for(long ph:phone)
			{
				System.out.println("User Phone Number : "+ph);
				System.out.println("----------***************-----------");
			}
		}
		else
			System.err.println("You Have entered invalid name!!!");
		s.close();
		sc.close();

	}
}
