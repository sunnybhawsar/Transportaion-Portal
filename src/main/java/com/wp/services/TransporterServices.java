package com.wp.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wp.models.Deal;
import com.wp.models.Transporter;
import com.wp.models.Vehicle;

public interface TransporterServices {
	
	public String addTransporter(Transporter transporter, int loginId, MultipartFile picture, MultipartFile idProof);
	
	public Transporter getTransporter(int id);
	
	public int getTransporterId(int loginId);
	
	public List<Transporter> getAllTransporters();
	
	public String updateTransporter(Transporter transporter);
	
	public String saveVehicle(Vehicle vehicle, MultipartFile vInsurance, MultipartFile vFitness, int transId);

	public List <Vehicle> getAllVehicles (int transId);
	
	public String saveDeal(Deal deal, String vehicles, int transId);
	
	public List <Deal> getAllDeals (int transId);
	
	public Deal fetchDeal(int dealId);
}
