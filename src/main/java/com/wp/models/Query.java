package com.wp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Query {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int queryId;
	
	private String transporterEmail;
	private String customerEmail;
	private String query;
	private String response;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Transporter transporter;

	
	// Getters and Setters
	
	public int getQueryId() {
		return queryId;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public String getTransporterEmail() {
		return transporterEmail;
	}

	public void setTransporterEmail(String transporterEmail) {
		this.transporterEmail = transporterEmail;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	
	// Constructors
	
	public Query() {
		super();
	}

	public Query(int queryId) {
		super();
		this.queryId = queryId;
	}
	
	

}
