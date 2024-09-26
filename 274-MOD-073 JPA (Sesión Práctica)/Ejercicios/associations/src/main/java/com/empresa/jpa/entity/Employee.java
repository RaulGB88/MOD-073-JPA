package com.empresa.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Employee {
		
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private double salary;
	
	@Basic(fetch = FetchType.LAZY)
	@Lob
	private byte[] photo;
	
	@OneToMany(mappedBy = "employee")
	private List<Email> mails = new ArrayList<>();

	public void addMail(Email mail) {
		mails.add(mail);
		mail.setEmployee(this);
	}
	
	public void removeMail(Email mail) {
		mails.remove(mail);
		mail.setEmployee(null);
	}	
	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Employee() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public List<Email> getMails() {
		return mails;
	}

	public void setMails(List<Email> mails) {
		this.mails = mails;
	}
}
