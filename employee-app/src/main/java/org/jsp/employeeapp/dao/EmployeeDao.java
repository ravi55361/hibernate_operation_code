package org.jsp.employeeapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.employeeapp.dto.Employee;

public class EmployeeDao {
	Session s = new Configuration().configure().buildSessionFactory().openSession();

	// Save Employee
	public Employee saveEmployee(Employee emp) {
		s.save(emp);
		Transaction t = s.beginTransaction();
		t.commit();
		return emp;

	}

	// Update Employee
	public Employee updateEmployee(Employee emp) {
		s.saveOrUpdate(emp);
		Transaction t = s.beginTransaction();
		t.commit();
		return emp;

	}

	// Find employee by id
	public Employee findById(int id) {
		return s.get(Employee.class, id);
	}

	// verify by phone and password
	public Employee verifyEmployee(long phone, String password) {
		String sql = "select e from Employee e where e.emp_phone=?1 and e.emp_password=?2";
		Query<Employee> q = s.createQuery(sql);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	// verify by id and password
	public Employee verifyEmployee(int id, String password) {
		String sql = "select e from Employee e where e.emp_id=:id and e.emp_password=:password";
		Query<Employee> q = s.createQuery(sql);
		q.setParameter("id", id);
		q.setParameter("password", password);
		try {
			return q.uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}

	// delete employee
	public boolean deleteUser(int id) {
		Employee e = findById(id);
		if (e != null) {
			Transaction t = s.beginTransaction();
			s.delete(e);
			t.commit();
			return true;
		}
		return false;
	}

	// find employee by designation
	public List<Employee> findUserByDesignation(String designation) {
		String qry = "select e from Employee e where e.emp_designation=?1";
		Query<Employee> q = s.createQuery(qry);
		q.setParameter(1, designation);
		return q.getResultList();
	}
	
	public List<Employee> details() {
		String qry="select e from Employee e";
		Query<Employee> q=s.createQuery(qry);
		return q.getResultList();
	}
	
	public Employee verifyEmployee(String email,int id) {
		String sql = "select e from Employee e where e.emp_id=:id and e.emp_email=:email";
		Query<Employee> q = s.createQuery(sql);
		q.setParameter("id", id);
		q.setParameter("email", email);
		try {
			return q.uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}
}
