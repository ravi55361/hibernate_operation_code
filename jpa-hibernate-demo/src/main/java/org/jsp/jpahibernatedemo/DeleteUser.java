package org.jsp.jpahibernatedemo;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteUser {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter your id to delete the record");
	int id =sc.nextInt();
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
     User u=manager.find(User.class, id);
     if (u!=null) {
    	 manager.remove(u);
    	 transaction.begin();
    	 transaction.commit();	
	}
    else {
		System.out.println("you have entered an invalid id");
	}
    sc.close();
 }
}
