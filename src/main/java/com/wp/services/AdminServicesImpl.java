package com.wp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.dao.AdminDAO;
import com.wp.models.Deal;
import com.wp.models.Login;
import com.wp.models.Vehicle;

@Service
public class AdminServicesImpl implements AdminServices {
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public String approveTransporter(Login login) {
		
		login.setApproval(true);
		
		String response = adminDAO.approveTransporter(login);
		
		return response;
	}

	@Override
	public String declineTransporter(Login login) {
		
		login.setApproval(false);
		
		String response = adminDAO.approveTransporter(login);
		
		return response;
	}

	
	@Override
	public List<Vehicle> getAllVehicles() {
		
		List <Vehicle> vehicles = adminDAO.getAllVehicles();
		
		return vehicles;
	}

	// Approve/Decline Vehicle 

	@Override
	public String approveVehicle(Vehicle vehicle) {
		
		vehicle.setApproval(true);
		
		String response = adminDAO.approveVehicle(vehicle);
		
		return response;
	}

	@Override
	public String declineVehicle(Vehicle vehicle) {
		
		vehicle.setApproval(false);
		
		String response = adminDAO.approveVehicle(vehicle);
		
		return response;
	}

	
	// Get all deals
	
	@Override
	public List<Deal> getAllDeals() {
		
		List <Deal> deals = adminDAO.getAllDeals();
		
		return deals;
	}

}
