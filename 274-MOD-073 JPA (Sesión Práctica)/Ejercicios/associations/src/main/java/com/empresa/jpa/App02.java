package com.empresa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.empresa.jpa.entity.Email;
import com.empresa.jpa.entity.Employee;
import com.empresa.jpa.util.PersistenceManager;

/*
 * Trabajando con asociaciones bidireccionales 1 to many
 * Tengo que resolver los dos extremos de la asociacion.
 */

public class App02 {
	public static void main(String[] args) {
		EntityTransaction tx = null;
		try {

			EntityManager em = PersistenceManager.getInstance().createEntityManager();

			tx = em.getTransaction();
			tx.begin();

			Employee employee = new Employee("Carmen García", 222220);
			
			Email companyEmail = new Email("cgarcia@empresa.com", employee);
			Email personalEmail = new Email("cgarcia@gmail.com", employee);

			employee.getMails().add(personalEmail);
			employee.getMails().add(companyEmail);			
			
			tx.commit();

			em.close();

		} catch (Exception e) {
			tx.rollback();
		}
	}
}
