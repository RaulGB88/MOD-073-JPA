package com.empresa.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

	protected static PersistenceManager me = null;
	private EntityManagerFactory emf = null;
	
	private PersistenceManager() {
		if(emf==null) {
			emf = Persistence.createEntityManagerFactory("associations");
		}
	}
	
	public static PersistenceManager getInstance() {
		if(me==null) {
			me = new PersistenceManager();
		}
		return me;
	}
	
	public EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
}
