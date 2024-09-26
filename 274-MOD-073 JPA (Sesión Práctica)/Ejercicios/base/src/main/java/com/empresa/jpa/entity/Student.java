package com.empresa.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "NAME", columnDefinition = "varchar(255) default 'Santos'")
	private String firstName;
	
	@Column(name="LAST_NAME", columnDefinition = "varchar(255) default 'Santos'")
	private String lastName;
	
	@Column(name = "ADDRESS", columnDefinition = "varchar(255) default 'Calle de la espiga, 34'")
	private String address;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Transient
	private String fullName;
	
	@Transient
	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student(String firstName, String lastName, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public Student() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullName() {
		return (firstName+ " "+ lastName).toUpperCase();
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
