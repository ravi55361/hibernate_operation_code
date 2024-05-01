package org.jsp.hibernateApp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserChoiceDelete {

    public static void main(String[] args) {
        Session s = new Configuration().configure().buildSessionFactory().openSession();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user id to delete the specfic record!!!");
        int id = sc.nextInt();
        User existingUser = s.get(User.class, id);

        if (existingUser != null) {
            System.out.println("Enter your choice to delete:\n1. Name :\n2. Phone :\n3. Email :\n4. Password :\n5. Address :");
            System.out.println("-----************-----------");
            int choice = sc.nextInt();

            Transaction t = s.beginTransaction();
            try
            {
            	switch (choice) {
            	case 1:
            		existingUser.setName(null); 
            		break;
            	case 2:
            		existingUser.setPhone(0L); 
            		break;
            	case 3:
            		existingUser.setEmail(null);
            		break;
            	case 4:
            		existingUser.setPassword(null); 
            		break;
            	case 5:
            		existingUser.setAddress(null); 
            		break;
            	default:
            		t.rollback(); 
            		break;
            	}
            	s.update(existingUser);
                t.commit();
                System.out.println("User details updated successfully.");
            }
            catch (Exception e) {
            	System.err.println("Invalid choice!!!");
            }
        }
        else {
            System.err.println("User not found with ID: " + id);
        }
        sc.close();
        s.close();
    }
}

