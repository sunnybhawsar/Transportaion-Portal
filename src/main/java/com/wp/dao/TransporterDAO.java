package com.wp.dao;

import java.util.List;

import com.wp.models.Deal;
import com.wp.models.Transporter;
import com.wp.models.Vehicle;

public interface TransporterDAO {
	
	public String addTransporter(Transporter transporter);
	
	public Transporter getTransporter(int id);
	
	public int getTransporterId(int loginId);
	
	public List<Transporter> getAllTransporters();
	
	public String updateTransporter(Transporter transporter);
	
	public String saveVehicle(Vehicle vehicle);
	
	public List <Vehicle> getAllVehicles (int transId);
	
	public String saveDeal(Deal deal);
	
	public List <Deal> getAllDeals (int transId);

}
