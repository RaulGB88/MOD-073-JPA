package com.empresa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.empresa.jpa.entity.Passport;
import com.empresa.jpa.entity.Person;
import com.empresa.jpa.util.PersistenceManager;

/*
 * Trabajando con asociaciones bidireccionales 1 to 1 con metodo add y remove
 * Se resuelven los dos extremos de la asociacion gracias a un metodo auxiliar
 */

public class App04 {
	public static void main(String[] args) {
		EntityTransaction tx = null;
		try {

			EntityManager em = PersistenceManager.getInstance().createEntityManager();

			tx = em.getTransaction();
			tx.begin();

			Person person = new Person("Francisco García");
			Passport passport = new Passport("8678262862828");
			
			person.addPassport(passport);
			
			em.persist(person);
			
			tx.commit();

			em.close();

		} catch (Exception e) {
			tx.rollback();
		}
	}
}
