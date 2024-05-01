package org.jsp.jpahibernatedemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUser {
   public static void main(String[] args) {
	  User u=new User();
	  u.setName("Priti");
	  u.setPhone(7068880845l);
	  u.setPassword("abc@123");
	  System.out.println("id before saving:"+u.getId());
	  EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	  EntityManager manager=factory.createEntityManager();
	  manager.persist(u);
	  EntityTransaction transaction=manager.getTransaction();
	  transaction.begin();
	  transaction.commit();
	  System.out.println("User saved with id:"+u.getId());	
   }
}
