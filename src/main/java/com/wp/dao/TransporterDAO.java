package com.wp.dao;

import java.util.List;

import com.wp.models.Deal;
import com.wp.models.Query;
import com.wp.models.Transporter;
import com.wp.models.Vehicle;

public interface TransporterDAO {
	
	public String addTransporter(Transporter transporter);
	
	public Transporter getTransporter(int id);
	
	public int getTransporterId(int loginId);
	
	public List<Transporter> getAllTransporters();
	
	public String updateTransporter(Transporter transporter);
	
	
	public String saveVehicle(Vehicle vehicle);
	public List <Vehicle> getAllVehicles(int transId);
	public String deleteVehicle(String regNo);
	
	public String saveDeal(Deal deal);
	public List <Deal> getAllDeals(int transId);
	public Deal fetchDeal(int dealId);
	public String deleteDeal(int dealId);
	
	public List <Query> getAllQueries(int transId);
	public String saveReply(Query query);
	public String deleteQuery(int queryId);
	
	public String getRating(Transporter transporter);

}
