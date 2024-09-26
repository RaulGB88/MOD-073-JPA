package com.empresa.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String fullName;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Passport passport;
	
	public void addPassport(Passport passport) {
		setPassport(passport);
		passport.setPerson(this);
	}
	
	public void removePassport(Passport passport) {
		setPassport(null);
		passport.setPerson(null);
	}

	public Person(String fullName) {
		super();
		this.fullName = fullName;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
}
