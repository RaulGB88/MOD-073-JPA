package com.empresa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.empresa.jpa.entity.Student;

public class App02 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = null;
		
		try {
	
			tx = em.getTransaction();
			tx.begin();

			Student estudiante = new Student("Ana", "Saez", "Calle del Sol 20");
			em.persist(estudiante);
			tx.commit();
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
		}
	}
}
