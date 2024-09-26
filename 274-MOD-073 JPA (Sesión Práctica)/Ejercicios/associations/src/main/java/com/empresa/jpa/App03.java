package com.empresa.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.empresa.jpa.entity.Email;
import com.empresa.jpa.entity.Employee;
import com.empresa.jpa.util.PersistenceManager;

/*
 * Trabajando con asociaciones bidireccionales 1 to many con metodo add y remove
 * Se resuelven los dos extremos de la asociacion gracias a un metodo auxiliar
 */

public class App03 {
	public static void main(String[] args) {
		EntityTransaction tx = null;
		try {

			EntityManager em = PersistenceManager.getInstance().createEntityManager();

			tx = em.getTransaction();
			tx.begin();

			Employee employee = new Employee("Carmen García", 222220);
			
			Email companyEmail = new Email("cgarcia@empresa.com");
			Email personalEmail = new Email("cgarcia@gmail.com");

			employee.addMail(personalEmail);
			employee.addMail(companyEmail);		
			
			em.persist(employee);
			
			tx.commit();
			
			em.clear();
			
			Employee e = em.find(Employee.class, 1L);
			List<Email> mails = e.getMails();
			for (Email email : mails) {
				System.out.println(email.getMail());
			}
			
			em.close();

		} catch (Exception e) {
			tx.rollback();
		}
	}
}
