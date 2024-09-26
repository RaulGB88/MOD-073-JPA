package com.empresa.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.empresa.jpa.entity.Invoice;
import com.empresa.jpa.entity.InvoiceLine;
import com.empresa.jpa.util.PersistenceManager;

/*
 * Trabajando con asociaciones unidireccionales 1 to many
 */

public class App01 {

	public static void main(String[] args) {
		EntityTransaction tx = null;
		try {

			EntityManager em = PersistenceManager.getInstance().createEntityManager();

			tx = em.getTransaction();
			tx.begin();

			Invoice invoice = new Invoice("A98897655", 200L, new Date());
			
			InvoiceLine l1 = new InvoiceLine("A", 100);
			InvoiceLine l2 = new InvoiceLine("B", 100);
			
			invoice.getLines().add(l1);
			invoice.getLines().add(l2);
			
			em.persist(invoice);
			
			tx.commit();

			Invoice aux = em.find(Invoice.class, 1L);
			
			System.out.println(aux.getAmount());
			
			em.close();

		} catch (Exception e) {
			tx.rollback();
		}
	}
}
