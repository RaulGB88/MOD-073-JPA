package com.empresa.jpa.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
@NamedQuery(name = "Employee.getEmployeesByName", query = "SELECT e FROM Employee e WHERE e.name=:employeeName")
public class Employee {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "SALARY", nullable = false)
	private double salary;
	
	@Column(name = "USER_PHOTO")
	@Basic(fetch = FetchType.LAZY)
	@Lob
	private byte[] photo;
	
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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
}
