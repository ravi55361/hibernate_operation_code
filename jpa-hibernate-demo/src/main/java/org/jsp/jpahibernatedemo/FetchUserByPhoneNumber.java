package org.jsp.jpahibernatedemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchUserByPhoneNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter your mobile number to print details!!!");
        Long phoneNum=sc.nextLong();
        String qry="select u from User u where u.phone=:ph";
        EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
        Query q=manager.createQuery(qry);
        q.setParameter("ph",phoneNum);
        try {
        	User u =(User)q.getSingleResult();
        	System.out.println("Id : "+u.getId());
    		System.out.println("Name : "+u.getName());
    		System.out.println("Phone Number : "+u.getPhone());
        }
        catch(NoResultException e)
        { 
        	System.err.println("You have entered invalid phone number!!!");
        	
        }
        sc.close();
	}
}
