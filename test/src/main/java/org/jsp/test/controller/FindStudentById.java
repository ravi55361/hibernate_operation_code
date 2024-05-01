package org.jsp.test.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.test.dto.Student;

public class FindStudentById {

	public static void main(String[] args) {
		EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t = m.getTransaction();
		System.out.println("enter student id to find details!!");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		Student s=m.find(Student.class, id);
		if(s!=null)
		{
			System.out.println("Student Name:"+s.getName());
			System.out.println("Student Phone:"+s.getPhone());
		}else
			System.err.println("Invalid Id!!!");

	}

}
