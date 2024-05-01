package org.jsp.hibernateApp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserChoiceUpdate {

	public static void main(String[] args) {
	    Session s = new Configuration().configure().buildSessionFactory().openSession();
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter user id to update the record!!!");
	    int id = sc.nextInt();
	    User existingUser = s.get(User.class, id);

	    if (existingUser != null) {
	        System.out.println("Enter your choice to edit:\n1. Name :\n2. Phone :\n3. Email :\n4. Password :\n5. Address :");
	        int choice = sc.nextInt();
	        switch (choice) {
	            case 1:
	                System.out.println("Enter new name:");
	                existingUser.setName(sc.next());
	                break;
	            case 2:
	                System.out.println("Enter new phone:");
	                existingUser.setPhone(sc.nextLong());
	                break;
	            case 3:
	                System.out.println("Enter new email:");
	                existingUser.setEmail(sc.next());
	                break;
	            case 4:
	                System.out.println("Enter new password:");
	                existingUser.setPassword(sc.next());
	                break;
	            case 5:
	                System.out.println("Enter new address:");
	                existingUser.setAddress(sc.next());
	                break;
	            default:
	                System.out.println("Invalid choice!!!");
	                break;
	        }
	        Transaction t = s.beginTransaction();
	        s.update(existingUser); 
	        t.commit();
	        System.out.println("User record updated successfully.");
	    } else {
	        System.err.println("User not found with ID: " + id);
	    }
	    sc.close();
	    s.close();
	}
}