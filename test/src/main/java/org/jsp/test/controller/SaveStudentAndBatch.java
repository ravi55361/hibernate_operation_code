package org.jsp.test.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.service.spi.Manageable;
import org.jsp.test.dto.Batch;
import org.jsp.test.dto.Student;

public class SaveStudentAndBatch {

	public static void main(String[] args) {

		EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t = m.getTransaction();
		Batch b1 = new Batch();
		b1.setCode("hnt-hnb-1");
		b1.setSubject("Hibernate");
		b1.setTrainer("Satish");
		Batch b2 = new Batch();
		b2.setCode("hnt-j2ee-2");
		b2.setSubject("J2EE");
		b2.setTrainer("GURU");
		Batch b3 = new Batch();
		b3.setCode("hnt-js-2");
		b3.setSubject("React js");
		b3.setTrainer("Prajawl");

		Student s1 = new Student();
		s1.setName("Ravi");
		s1.setPhone(7004666465l);

		Student s2 = new Student();
		s2.setName("Ravishankar");
		s2.setPhone(7004666454l);
		Student s3 = new Student();
		s3.setName("Rohit");
		s3.setPhone(7414666454l);

		b1.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2, s3)));
		b2.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2)));
		b3.setStudents(new ArrayList<Student>(Arrays.asList(s1, s3)));

		m.persist(b1);
		m.persist(b2);
		m.persist(b3);
		t.begin();
		t.commit();

	}

}
