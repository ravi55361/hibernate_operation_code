package org.jsp.persistenceapp;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory entity=Persistence.createEntityManagerFactory("dev");
		System.out.println(entity);

	}

}
