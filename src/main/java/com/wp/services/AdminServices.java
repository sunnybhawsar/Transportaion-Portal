package com.wp.services;

import java.util.List;

import com.wp.models.Deal;
import com.wp.models.Login;
import com.wp.models.Vehicle;

public interface AdminServices {
	
	public String approveTransporter(Login login);
	
	public String declineTransporter(Login login);
	
	public String approveVehicle(Vehicle vehicle);
	
	public String declineVehicle(Vehicle vehicle);
	
	public List<Vehicle> getAllVehicles();
	
	public List<Deal> getAllDeals();
	
	public String declineDeal(int dealId);

}
