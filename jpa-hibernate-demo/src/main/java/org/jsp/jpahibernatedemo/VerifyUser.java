package org.jsp.jpahibernatedemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyUser {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter your mobile number and password to verify your account!!!");
        Long phoneNum=sc.nextLong();
        String password=sc.next();
        String qry="select u from User u where u.phone=?1 and password=?2";
        EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
        Query q=manager.createQuery(qry);
        q.setParameter(1,phoneNum);
        q.setParameter(2,password);
        try {
        	User u =(User)q.getSingleResult();
        	System.out.println("Your account is verified!!");
        	System.out.println("Id : "+u.getId());
    		System.out.println("Name : "+u.getName());
    		System.out.println("Phone Number : "+u.getPhone());
        }
        catch(NoResultException e)
        { 
        	System.err.println("You have entered invalid phone number or password!!!");
        	
        }
        sc.close();
	}

}
