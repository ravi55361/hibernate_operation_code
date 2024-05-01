package org.jsp.test.controller;

import javax.persistence.*;

import org.jsp.test.dto.Student;

import java.util.List;
import java.util.Scanner;

public class FindByBatchCode {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter batch code to find student details:");
		String batchCode = sc.next();
		String qry = "select b.students from Batch b where b.code=?1";
		Query q = em.createQuery(qry);
		q.setParameter(1, batchCode);
		@SuppressWarnings("unchecked")
		List<Student> students = q.getResultList();
		if (students.size() > 0) {
			System.out.println("Students in Batch " + batchCode);
			System.out.println("----------***************----------");
			for (Student student : students) {
				System.out.println("Student Id: " + student.getId());
				System.out.println("Student Name: " + student.getName());
				System.out.println("Student Phone Number: " + student.getPhone());
				System.out.println("----------***************----------");
			}
		} else
			System.err.println("Batch with code " + batchCode + " not found.");
		sc.close();
		em.close();
	}
}
