package org.jso.onetoonebi.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.jso.onetoonebi.dto.AadharCard;
import org.jso.onetoonebi.dto.Person;
import org.jsp.onetoonebi.dao.PersonAndAadharDao;

public class PersonAndAadhardController {
	static Scanner sc = new Scanner(System.in);
	static PersonAndAadharDao dao = new PersonAndAadharDao();

	public static void main(String[] args) {
		System.out.println(
				"\n1.Person By Id!\n2.Person By Name!\n3.Person By Phone!\n4.Person By AadharCard Id!\n5.Person By AadharCard Number!\n6.AadharCard By Id!\n7.AadharCard By Number!\n8.AadharCard By DOB(yyyy-mm-dd)\n9.AadharCrad By Pincode!\n10.AadharCard By Person Id!\n11.AadharCard By Person Phone\n12.AadharCard By Person Name!");
		System.out.println("choose your choise to fetch the details!!!");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			findById();
			break;
		case 2:
			findByName();
			break;
		case 3:
			findByPhone();
			break;
		case 4:
			findByAadharId();
			break;
		case 5:
			findByAadharNumber();
			break;
		case 6:
			findAadharById();
			break;
		case 7:
			findAadharByNumber();
			break;
		case 8:
			findAadharByDOB();
			break;
		case 9:
			findAadharByPincode();
			break;
		case 10:
			findAadharByPersonId();
			break;
		case 11:
			findAadharByPersonPhone();
			break;
		case 12:
			findAadharByPersonName();
			break;
		default:
			System.err.println("Invalid Choice Plese choose valid choice!!!!");
			break;
		}
	}

	private static void findAadharByPersonName() {
		System.out.println("Enter Person Name To display The AadharCard Details!!");
		String name = sc.next();
		List<AadharCard> cards = dao.fetchAadhardetailsByPersonName(name);
		if (cards.size() > 0) {
			for (AadharCard card : cards) {
				displayAadhar(card);
			}
		} else {
			System.err.println("Invalid Person Name!!!");
		}
	}

	private static void findAadharByPersonPhone() {
		System.out.println("Enter Person Phone Number To display The AadharCard Details!!");
		long phone = sc.nextLong();
		AadharCard card = dao.fetchAadhardetailsByPersonPhone(phone);
		if (card != null) {
			displayAadhar(card);
		} else {
			System.err.println("Invalid Person Phone!!!");
		}

	}

	private static void findAadharByPersonId() {
		System.out.println("Enter Person Id To display The AadharCard Details!!");
		int id = sc.nextInt();
		AadharCard card = dao.fetchAadhardetailsByPersonid(id);
		if (card != null) {
			displayAadhar(card);
		} else {
			System.err.println("Invalid Person Id!!!");
		}
	}

	private static void findAadharByPincode() {
		System.out.println("Enter Pincode to Display The AadharCard Records!!!");
		int pincode = sc.nextInt();
		List<AadharCard> cards = dao.fetchAadhardetailsByPincode(pincode);
		if (cards.size() > 0) {
			for (AadharCard card : cards) {
				displayAadhar(card);
			}
		} else {
			System.err.println("Invalid DOB!!!");
		}

	}

	private static void findAadharByDOB() {
		System.out.println("Enter DOB(yyyy-mm-dd) to Display The AadharCard Records!!!");
		LocalDate dob = LocalDate.parse(sc.next());
		List<AadharCard> cards = dao.fetchAadhardetails(dob);
		if (cards.size() > 0) {
			for (AadharCard card : cards) {
				displayAadhar(card);
			}
		} else {
			System.err.println("Invalid DOB!!!");
		}
	}

	private static void findAadharByNumber() {
		System.out.println("Enter AadharCard Number to Display The Records!!!");
		long number = sc.nextLong();
		AadharCard card = dao.fetchAadhardetails(number);
		if (card != null) {
			displayAadhar(card);
		} else {
			System.err.println("Invalid AadharCard Id!!!");
		}

	}

	private static void findAadharById() {
		System.out.println("Enter AadharCard Id to Display The Records!!!");
		int id = sc.nextInt();
		AadharCard card = dao.fetchAadhardetails(id);
		if (card != null) {
			displayAadhar(card);
		} else {
			System.err.println("Invalid AadharCard Id!!!");
		}

	}

	private static void findByAadharNumber() {
		System.out.println("Enter AadharCard Number  To Display The Person Records!!!");
		long number = sc.nextLong();
		Person person = dao.fetchPerson(number);
		if (person != null) {
			displayPerson(person);
		} else {
			System.err.println("Invalid AadharCard Id!!!");
		}

	}

	private static void findByAadharId() {
		System.out.println("Enter AadharCard Id  To Display The Person Records!!!");
		int id = sc.nextInt();
		Person person = dao.fetchPerson(id);
		if (person != null) {
			displayPerson(person);
		} else {
			System.err.println("Invalid AadharCard Id!!!");
		}

	}

	private static void findByPhone() {
		System.out.println("Enter Person Phone To Display The Records!!!");
		long phone = sc.nextLong();
		Person person = dao.fetch(phone);
		if (person != null) {
			displayPerson(person);
		} else {
			System.err.println("Invalid Person Phone!!!");
		}
	}

	private static void findByName() {
		System.out.println("Enter Person Name To Display The Records!!!");
		String name = sc.next();
		List<Person> persons = dao.fetch(name);
		if (persons.size() > 0) {
			for (Person person : persons) {
				displayPerson(person);
			}
		}
	}

	private static void findById() {
		System.out.println("Enter Person Id To Display The Records!!!");
		int id = sc.nextInt();
		Person person = dao.fetch(id);
		if (person != null) {
			displayPerson(person);
		} else {
			System.err.println("Invalid Person Id!!!");
		}

	}

	private static void displayPerson(Person person) {
		System.out.println("Person Id: " + person.getId());
		System.out.println("Person Name: " + person.getName());
		System.out.println("Person Phone: " + person.getPhone());
		System.err.println("--------********************-----------");
	}

	private static void displayAadhar(AadharCard card) {
		System.out.println("Id: " + card.getId());
		System.out.println("Aadhar Number: " + card.getNumber());
		System.out.println("Date Of Birth Of Person: " + card.getDob());
		System.out.println("Person Pincode: " + card.getPincode());
		System.err.println("--------********************-----------");
		System.err.println("--------********************-----------");
	}

}
