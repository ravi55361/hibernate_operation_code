package org.jsp.assignment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.assignment.dto.Department;
import org.jsp.assignment.dto.Employee;

public class Employeedao {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

	public Employee saveEmployee(Employee emp, int deptId) {
		Department dept = manager.find(Department.class, deptId);
		if (dept != null) {
			emp.setDepartment(dept);
			dept.getEmployess().add(emp);
			manager.persist(emp);
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
			return emp;
		}
		return null;
	}

	public Employee updateEmployee(Employee emp, int dept_id) {
		Department dept = manager.find(Department.class, dept_id);
		if (dept != null) {
			emp.setDepartment(dept);
			dept.getEmployess().add(emp);
			manager.persist(emp);
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
			return emp;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findByDeptId(int id) {
		String qry = "select e from Employee e where e.department.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findByDeptname(String name) {
		String qry = "select e from Employee e where e.department.name=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		return q.getResultList();
	}

	public Employee verifyEmployee(int id, String password) {
		String qry = "select e from Employee e where e.id=?1 and e.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			return (Employee) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public Employee verifyEmployee(long phone, String password) {
		String qry = "select e from Employee e where e.phone=?1 and e.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (Employee) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public Employee verifyEmployee(String email, String password) {
		String qry = "select e from Employee e where e.email=?1 and e.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return (Employee) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
