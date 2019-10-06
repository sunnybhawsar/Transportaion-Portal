package com.wp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Vehicle {
	
	@Id
	private String registrationNumber;
	private String vehicleType;
	private String brand;
	private int capacity;
	private String insurance;
	private String fitness;
	
	@org.hibernate.annotations.Type(type="true_false")
	private boolean approval;
	
	@ManyToOne
	private Transporter transporter;
	
	@OneToMany(mappedBy="vehicle", cascade = CascadeType.ALL)
	private List<Deal> deals = new ArrayList<Deal>();
	


// Getters and Setters
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getFitness() {
		return fitness;
	}

	public void setFitness(String fitness) {
		this.fitness = fitness;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}
	
	public List<Deal> getDeals() {
		return deals;
	}

	public void setDeals(List<Deal> deals) {
		this.deals = deals;
	}
	
	
// Constructors
	
	public Vehicle(String registrationNumber) {
		super();
		this.registrationNumber = registrationNumber;
	}

	public Vehicle() {
		super();
	}
	
}
