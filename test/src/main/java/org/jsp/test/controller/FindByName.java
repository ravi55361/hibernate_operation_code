package org.jsp.test.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.test.dto.Student;

public class FindByName {

	public static void main(String[] args) {
		EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t = m.getTransaction();
		System.out.println("enter student name to find details!!");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		String qry="select s from Student s where s.name=?1";
		Query q=m.createQuery(qry);
		q.setParameter(1, name);
		List<Student> students=q.getResultList();
		if(students.size()>0)
		{
			for(Student s:students)
			{
				System.out.println("Student Name:"+s.getName());
				System.out.println("Student Phone:"+s.getPhone());
			}
		}else
			System.err.println("Invalid Name!!!");

	}

}
