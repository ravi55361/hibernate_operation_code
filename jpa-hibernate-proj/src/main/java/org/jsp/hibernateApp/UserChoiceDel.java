package org.jsp.hibernateApp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserChoiceDel {

    public static void main(String[] args) {
        Session s = new Configuration().configure().buildSessionFactory().openSession();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user id to delete the record!!!");
        int id = sc.nextInt();
        User existingUser = s.get(User.class, id);

        if (existingUser != null) {
            System.out.println("User found.!!!");
            System.out.println("----------*****************-----------");
            System.out.println("User Id :"+existingUser.getId());
			System.out.println("User Name :"+existingUser.getName());
			System.out.println("User Phone Number :"+existingUser.getPhone());
			System.out.println("User Email Id :"+existingUser.getEmail());
			System.out.println("User Address :"+existingUser.getAddress());
			System.out.println("----------*****************-----------");
			System.out.println("Do you want to delete this user? (yes/no)");
            String choice = sc.next().toLowerCase();

            if (choice.equals("yes")) {
                Transaction t = s.beginTransaction();
                s.delete(existingUser);
                t.commit();
                System.out.println("User record deleted successfully.");
            } else {
                System.out.println("User record was not deleted.");
            }
        } else {
            System.err.println("User not found with ID: " + id);
        }
        sc.close();
        s.close();
    }
}

