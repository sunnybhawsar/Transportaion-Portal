package com.wp.dao;

import java.util.List;

import com.wp.models.Deal;
import com.wp.models.Login;
import com.wp.models.Vehicle;

public interface AdminDAO {
	
	public String approveTransporter(Login login);
	
	public String approveVehicle(Vehicle vehicle);
	
	public List<Vehicle> getAllVehicles();

	public List<Deal> getAllDeals();
	
	public String declineDeal(int dealId);
}
