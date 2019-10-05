package com.wp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private String state;
	private String city;
	private String image;
	private String idProof;
	
	@OneToOne
	private Login login;
	
	@OneToMany(mappedBy="transporter", cascade = CascadeType.ALL)
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	
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
	

	
	// Constructors
	
	public Transporter(int transporterId, String name, String email, String mobile, String address, String state,
			String city, String image, String idProof, Login login, List<Vehicle> vehicles) {
		super();
		this.transporterId = transporterId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.state = state;
		this.city = city;
		this.image = image;
		this.idProof = idProof;
		this.login = login;
		this.vehicles = vehicles;
	}

	public Transporter(int transporterId, String name, String email, String mobile, String address, String state,
			String city, String image, String idProof, Login login) {
		super();
		this.transporterId = transporterId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.state = state;
		this.city = city;
		this.image = image;
		this.idProof = idProof;
		this.login = login;
	}
	
	
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
	
	
	// ToString Method

	@Override
	public String toString() {
		return "Transporter [transporterId=" + transporterId + ", name=" + name + ", email=" + email + ", mobile="
				+ mobile + ", address=" + address + ", state=" + state + ", city=" + city + ", image=" + image
				+ ", idProof=" + idProof + ", login=" + login + " ]";
	}


}
