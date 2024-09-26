package com.empresa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.empresa.jpa.entity.Employee;

public class App01 {

	public static void main(String[] args) {
		
		// Paso 1: Recuperar una factoria de gestores de entidades
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");
		
		// Paso 2: Recuperar un manager de entidades
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		// Paso 3: Se inicia una transaccion
		tx.begin();
		
		// Estado new
		Employee employee1 = new Employee("Pedro García", 40000);
		Employee employee2 = new Employee("Ana Sol", 12345.87);
		
		em.persist(employee1);
		em.persist(employee2);
		
		// Paso 4: Se hace un commit de la transaccion
		tx.commit();
		
		// Los dos objetos se encuentra en estado MANAGE
		
		Employee aux = em.find(Employee.class, 1L);
		
		tx.begin();
		
		
		
		aux.setName("Antonio García");
		
		System.out.println(aux.getName());
		tx.commit();

	}

}
