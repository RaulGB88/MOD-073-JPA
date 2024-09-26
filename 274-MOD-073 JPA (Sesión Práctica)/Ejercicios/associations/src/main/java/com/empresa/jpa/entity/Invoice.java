package com.empresa.jpa.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Invoice {

	@Id
	@GeneratedValue
	private long id;

	private String cif;
	private double amount;

	@Temporal(TemporalType.DATE)
	private Date issueDate;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "invoice_id")
	private List<InvoiceLine> lines = new ArrayList<>();

	public Invoice(String cif, double amount, Date issueDate) {
		super();
		this.cif = cif;
		this.amount = amount;
		this.issueDate = issueDate;
	}

	public Invoice() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public List<InvoiceLine> getLines() {
		return lines;
	}

	public void setLines(List<InvoiceLine> lines) {
		this.lines = lines;
	}
}
