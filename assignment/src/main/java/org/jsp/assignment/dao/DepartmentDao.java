package org.jsp.assignment.dao;

import java.security.PublicKey;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.assignment.dto.Department;

public class DepartmentDao {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

	public Department saveDepartment(Department dept) {

		manager.persist(dept);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
		return dept;
	}

	public Department updateDept(Department dept) {

		manager.merge(dept);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
		return dept;

	}

	public Department findById(int id) {
		return manager.find(Department.class, id);
	}
}
