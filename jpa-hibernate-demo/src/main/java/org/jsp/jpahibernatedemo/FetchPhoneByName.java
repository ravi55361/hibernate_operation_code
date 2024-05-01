package org.jsp.jpahibernatedemo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchPhoneByName {

	public static void main(String[] args) 
	{
		 Scanner sc=new Scanner(System.in);
	     System.out.println("Enter your name to fetch phone number!!!");
	     String name=sc.next();
         EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
         Query q=manager.createNamedQuery("fetchPhoneByName");
         q.setParameter(1, name);
	     List<Long> phone=q.getResultList();
         if(phone.size()>0)
         {
	      	 for(long ph:phone)
	         {
	       		System.out.println("Phone Number :"+ph);
	       	 }
	     }
         else
         {
        	 System.err.println("No phone number present for enterd name!!!");
         }
	     sc.close(); 
	 }
}
