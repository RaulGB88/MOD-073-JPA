package com.empresa.jpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company {

	@Id
	private int id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "ADDRESS", nullable = false)
	private String address;
	
	@Column(name = "TELEPHONE_NUMBER", nullable = false)
	private String phone;
	
	@Embedded
	@AttributeOverrides({
		  @AttributeOverride( name = "firstName", column = @Column(name = "contact_first_name")),
		  @AttributeOverride( name = "lastName", column = @Column(name = "contact_last_name")),
		  @AttributeOverride( name = "phone", column = @Column(name = "contact_phone"))
	})
	private Contact contact;
	
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
