package org.jsp.jpahibernatedemo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchAllUser {
public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q=manager.createQuery("select u from User u");
	List<User> Users=q.getResultList();
	for (User u : Users) {
		System.out.println("Id:"+u.getId());
		System.out.println("Name:"+u.getName());
		System.out.println("Phone number:"+u.getPhone());
		System.out.println("-------------");
	}	
  }
}
