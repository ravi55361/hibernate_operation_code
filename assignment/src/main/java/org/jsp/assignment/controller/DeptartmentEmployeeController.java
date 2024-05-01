package org.jsp.assignment.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.assignment.dao.DepartmentDao;
import org.jsp.assignment.dao.Employeedao;
import org.jsp.assignment.dto.Department;
import org.jsp.assignment.dto.Employee;

public class DeptartmentEmployeeController {
	static DepartmentDao deptDao = new DepartmentDao();
	static Employeedao empDao = new Employeedao();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(
				"1.Save Department! \n2.Save Employee! \n3.Update Department! \n4.Update Employee! \n5.Find Employees by Depratment id! \n6.Find Employees by Depratment name! \n7.Verify Employee By Id and password! \n8.Verify Employee By phone and password! \n9.Verify Employee By email and password!\n10.Find Department By Id!");
		System.out.println("---------**********----------");
		System.out.println("Enter your choice!!");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			saveDepartment();
			break;
		case 2:
			saveEmployee();
			break;
		case 3:
			updateDept();
			break;

		case 4:
			updateEmployee();
			break;
		case 5:
			findEmpByDeptId();
			break;
		case 6:
			findEmpByDeptName();
			break;
		case 7:
			verifyEmpByIdAndPassword();
			break;
		case 8:
			verifyEmpByPhoneAndPassword();
			break;
		case 9:
			verifyEmpByEmailAndPassword();
			break;
		case 10:
			findDeptById();
			break;
		default:
			System.err.println("Invalid Choice!!");
			break;
		}
		sc.close();
	}

	private static void findDeptById() {
		System.out.println("Enter Department Id to find the record!!");
		int id = sc.nextInt();
		Department dept = deptDao.findById(id);
		if (dept != null) {
			System.out.println("Department Id :" + dept.getId());
			System.out.println("Department Name :" + dept.getName());
			System.out.println("Department Location :" + dept.getLocation());
		} else
			System.err.println("Invalid department id!!");

	}

	private static void verifyEmpByEmailAndPassword() {
		System.out.println("Enter Employee Email-Id!!");
		String email = sc.next();
		System.out.println("Enter Employee Password!!");
		String pass = sc.next();
		Employee e = empDao.verifyEmployee(email, pass);
		if (e != null) {
			display(e);
		} else {
			System.err.println("Invalid Email-Id or password");
		}
	}

	// case 8
	private static void verifyEmpByPhoneAndPassword() {
		System.out.println("Enter Employee Phone number!!");
		long phone = sc.nextLong();
		System.out.println("Enter Employee Password!!");
		String pass = sc.next();
		Employee e = empDao.verifyEmployee(phone, pass);
		if (e != null) {
			display(e);
		} else {
			System.err.println("Invalid Phone Number or password");
		}

	}

	private static void verifyEmpByIdAndPassword() {
		System.out.println("Enter Employee Id!!");
		int id = sc.nextInt();
		System.out.println("Enter Employee Password!!");
		String pass = sc.next();
		Employee e = empDao.verifyEmployee(id, pass);
		if (e != null) {
			display(e);
		} else {
			System.err.println("Invalid Id or password");
		}

	}

	private static void findEmpByDeptName() {
		System.out.println("Enter Department Name to fetch the record!!!");
		String dept_name = sc.next();
		List<Employee> emps = empDao.findByDeptname(dept_name);
		if (emps.size() > 0) {
			for (Employee e : emps) {
				display(e);
			}
		} else
			System.err.println("Invalid Department Name!!!");
	}

	private static void findEmpByDeptId() {
		System.out.println("Enter Department Id to fetch the Employee record!!");
		int dept_id = sc.nextInt();
		List<Employee> emps = empDao.findByDeptId(dept_id);
		if (emps.size() > 0) {
			for (Employee e : emps) {
				display(e);
			}
		} else
			System.err.println("Invalid Department Id!!!");

	}

	private static void updateEmployee() {
		System.out.println("Enter the department id to add Employee");
		int dept_id = sc.nextInt();
		System.out.println("Enter Employee Id to update the record!");
		int id = sc.nextInt();
		Employee e = inputEmployee();
		e.setId(id);
		e = empDao.updateEmployee(e, dept_id);
		if (e != null)
			System.out.println("Employee Update with id " + id);
		else
			System.err.println("Invalid Department Id!!");
	}

	private static void updateDept() {
		System.out.println("Enter Department Id To update the records!!!");
		int id = sc.nextInt();
		Department d = inputDepartment();
		d.setId(id);
		d = deptDao.updateDept(d);
		System.out.println("Department Updated!!!");
	}

	private static void saveEmployee() {

		Employee emp = inputEmployee();
		System.out.println("Enter Department Id to add empoyee!!!");
		int id = sc.nextInt();
		emp = empDao.saveEmployee(emp, id);
		System.out.println("Employee saved with id!!!" + emp.getId());

	}

	public static void saveDepartment() {
		Department dept = inputDepartment();
		dept = deptDao.saveDepartment(dept);
		System.out.println("Department saved with id!!!" + dept.getId());
	}

	public static Department inputDepartment() {
		Department dept = new Department();
		System.out.println("Enter Department Name!!!");
		dept.setName(sc.next());
		System.out.println("Enter Department Location!!!");
		dept.setLocation(sc.next());
		return dept;

	}

	public static Employee inputEmployee() {
		Employee emp = new Employee();
		System.out.println("Enter Employee Name!!");
		emp.setName(sc.next());
		System.out.println("Enter Employee Designation!!");
		emp.setDesignation(sc.next());
		System.out.println("Enter Employee Salary!!!");
		emp.setSalary(sc.nextDouble());
		System.out.println("Enter Employee Phone Number!!!");
		emp.setPhone(sc.nextLong());
		System.out.println("Enter Employee Email-Id!!!");
		emp.setEmail(sc.next());
		System.out.println("Enter Employee Password!!!");
		emp.setPassword(sc.next());
		return emp;
	}

	public static void display(Employee e) {
		System.out.println("Employee Id:" + e.getId());
		System.out.println("Employee name:" + e.getName());
		System.out.println("Designation:" + e.getDesignation());
		System.out.println("Phone Number:" + e.getPhone());
		System.out.println("Email Id:" + e.getEmail());
		System.out.println("Salary :" + e.getSalary());
		System.out.println("------------------------------");
	}
}
