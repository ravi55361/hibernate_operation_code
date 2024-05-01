package org.jsp.jpahibernatedemo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchNames {

	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
        Query q=manager.createNamedQuery("fetchNames");
        List<String> names=q.getResultList();
       	for(String nm:names)
       	{
       		System.out.println("Name : "+nm);
       	}
	}

}
