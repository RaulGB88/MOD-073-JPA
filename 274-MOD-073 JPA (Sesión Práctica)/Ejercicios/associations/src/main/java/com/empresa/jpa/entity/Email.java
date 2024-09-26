package com.empresa.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Email {

	@Id
	@GeneratedValue
	private long id;
	
	private String mail;
	
	@ManyToOne
	private Employee employee;

	public Email(String mail, Employee employee) {
		super();
		this.mail = mail;
		this.employee = employee;
	}

	public Email(String mail) {
		super();
		this.mail = mail;
	}

	public Email() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
