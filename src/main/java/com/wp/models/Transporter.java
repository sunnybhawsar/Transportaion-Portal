package com.wp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Transporter {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int transporterId;
	
	private String name;
	private String email;
	private String mobile;
	private String address;
	private String city;
	private String pancard;
	private String idProof;
	private int rating;
	private int ratedBy;

	@OneToOne
	private Login login;
	
	@OneToMany(mappedBy="transporter", cascade = CascadeType.ALL)
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	@OneToMany(mappedBy="transporter", cascade = CascadeType.ALL)
	private List<Deal> deals = new ArrayList<Deal>();
	
	@OneToMany(mappedBy="transporter", cascade = CascadeType.ALL)
	private List<Query> queries = new ArrayList<Query>();
	
	
	// Getters and Setters
	
	public int getTransporterId() {
		return transporterId;
	}

	public void setTransporterId(int transporterId) {
		this.transporterId = transporterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}	
	
	
	public List<Deal> getDeals() {
		return deals;
	}

	public void setDeals(List<Deal> deals) {
		this.deals = deals;
	}

	public List<Query> getQueries() {
		return queries;
	}

	public void setQueries(List<Query> queries) {
		this.queries = queries;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getRatedBy() {
		return ratedBy;
	}

	public void setRatedBy(int ratedBy) {
		this.ratedBy = ratedBy;
	}
	
	// Constructors
	

	public Transporter(int transporterId) {
		super();
		this.transporterId = transporterId;
	}

	public Transporter(Login login) {
		super();
		this.login = login;
	}

	public Transporter() {
		super();
	}
	
}
