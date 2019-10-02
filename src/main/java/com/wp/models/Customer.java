package com.wp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Customer {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int customerId;
	
	private String name;
	private String email;
	private	String mobile;
	private String state;
	private String city;
	private String image;
	
	@OneToOne
	private Login login;

	
	// Getters and Setters
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	
	// Constructors
	
	public Customer(int customerId, String name, String email, String mobile, String state, String city, String image,
			Login login) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.state = state;
		this.city = city;
		this.image = image;
		this.login = login;
	}

	public Customer(int customerId) {
		super();
		this.customerId = customerId;
	}

	public Customer(Login login) {
		super();
		this.login = login;
	}

	public Customer() {
		super();
	}

	
	// ToString Method
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", state=" + state + ", city=" + city + ", image=" + image + ", login=" + login + "]";
	}
	
	
}
