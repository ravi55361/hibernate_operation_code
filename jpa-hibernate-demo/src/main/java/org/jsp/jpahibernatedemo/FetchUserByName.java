package org.jsp.jpahibernatedemo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchUserByName {

	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name to print details!!!");
        String name=sc.next();
        String qry="select u from User u where u.name=?1";
        EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
        Query q=manager.createQuery(qry);
        q.setParameter(1, name);
        List<User> users=q.getResultList();
        if(users.size()>0)
        {
        	for(User u:users)
        	{
        		System.out.println("Id : "+u.getId());
        		System.out.println("Name : "+u.getName());
        		System.out.println("Phone Number : "+u.getPhone());
        	}
        }
        else
        {
        	System.err.println("No user found with the entered name "+name+".");
        }
        sc.close();
	}

}
