package org.jsp.employeeapp.controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory s = cfg.buildSessionFactory();
		System.out.println(s);
	}
}
