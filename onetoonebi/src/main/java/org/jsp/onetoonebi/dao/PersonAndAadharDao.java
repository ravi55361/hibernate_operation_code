package org.jsp.onetoonebi.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jso.onetoonebi.dto.AadharCard;
import org.jso.onetoonebi.dto.Person;

public class PersonAndAadharDao {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

	// find person by person id
	public Person fetch(int id) {
		Person person = manager.find(Person.class, id);
		return person;
	}

	// find person by person name
	public List<Person> fetch(String name) {
		String qry = "select p from Person p where p.name=?1 ";
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		return q.getResultList();
	}

	// find person by person phone
	public Person fetch(long phone) {
		String qry = "select p from Person p where p.phone=?1 ";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		try {
			return (Person) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	// find person by aadharcard id
	public Person fetchPerson(int id) {
		String qry = "select p from Person p where p.card.id=?1 ";
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		try {
			return (Person) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	// find person by aadharcard number
	public Person fetchPerson(long number) {
		String qry = "select p from Person p where p.card.number=?1 ";
		Query q = manager.createQuery(qry);
		q.setParameter(1, number);
		try {
			return (Person) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	// find aadhar by aadhar id
	public AadharCard fetchAadhardetails(int id) {
		AadharCard card = manager.find(AadharCard.class, id);
		return card;
	}

	// find aadhar by aadhar number
	public AadharCard fetchAadhardetails(long number) {
		String qry = "select a from AadharCard a where a.number=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, number);
		try {
			return (AadharCard) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	// find aadhar by dob
	public List<AadharCard> fetchAadhardetails(LocalDate dob) {
		String qry = "select a from AadharCard a where a.dob=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, dob);
		return q.getResultList();
	}

	// find aadhar by pin code
	public List<AadharCard> fetchAadhardetailsByPincode(int pincode) {
		String qry = "select a from AadharCard a where a.pincode=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, pincode);
		return q.getResultList();
	}

	// find aadhar by person id
	public AadharCard fetchAadhardetailsByPersonid(int id) {
		String qry = "select a from AadharCard a where a.person.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		try {
			return (AadharCard) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	// find aadhar by person phone
	public AadharCard fetchAadhardetailsByPersonPhone(long phone) {
		String qry = "select a from AadharCard a where a.person.phone=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		try {
			return (AadharCard) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	// find aadhar by person name
	public List<AadharCard> fetchAadhardetailsByPersonName(String name) {
		String qry = "select a from AadharCard a where a.person.name=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		return q.getResultList();
	}
}
