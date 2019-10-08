package com.wp.services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wp.dao.TransporterDAO;
import com.wp.models.Deal;
import com.wp.models.Login;
import com.wp.models.Query;
import com.wp.models.Transporter;
import com.wp.models.Vehicle;

@Service
public class TransporterServicesImpl implements TransporterServices {
	
	@Autowired
	private TransporterDAO transporterDAO;

	@Override
	public String addTransporter(Transporter transporter, int loginId, MultipartFile picture, MultipartFile idProof) {
		
		
		String img= "img_"+transporter.getName()+".jpg";
		
		String doc= "document_"+transporter.getName()+".pdf";
		
		try {
			
			// Image Uploading
			
			byte b[] = picture.getBytes();
			
			String directory = "/home/yuvi/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Transportation/assets/transporter/images/";
			
			File obj = new File(directory+img);
			
			@SuppressWarnings("resource")
			FileOutputStream fileOutputStream = new FileOutputStream(obj);
			
			fileOutputStream.write(b);
			
			
			// Pdf Uploading
			
			byte byt[] = idProof.getBytes();
			
			String docDirectory = "/home/yuvi/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Transportation/assets/transporter/documents/";
			
			File docObj = new File(docDirectory+doc);
			
			@SuppressWarnings("resource")
			FileOutputStream fileOutputStream2 = new FileOutputStream(docObj);
			
			fileOutputStream2.write(byt);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		transporter.setPancard(img);
		
		transporter.setIdProof(doc);
		
		Transporter transporterWithLogin = transporter;
		transporterWithLogin.setLogin(new Login(loginId));
		
		String response = transporterDAO.addTransporter(transporterWithLogin);
		
		return response;
	}
	
	
// Get Transporter

	@Override
	public Transporter getTransporter(int id) {
		
		Transporter transporter = transporterDAO.getTransporter(id);
		return transporter;
	}
	
	
// Get all transporter

	@Override
	public List<Transporter> getAllTransporters() {
		List <Transporter> transporters = transporterDAO.getAllTransporters();
		return transporters;
	}
	
	
// Update Transporter

	@Override
	public String updateTransporter(Transporter transporter) {
		
		return null;
	}


	@Override
	public String saveVehicle(Vehicle vehicle, MultipartFile vInsurance, MultipartFile vFitness, int transId) {
		

		
		String insurance= "insurance_"+vehicle.getRegistrationNumber()+".jpg";
		
		String fitness= "fitness_"+vehicle.getRegistrationNumber()+".jpg";
		
		try {
			
			// Insurance Doc Uploading
			
			byte b[] = vInsurance.getBytes();
			
			String directory = "/home/yuvi/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Transportation/assets/transporter/vehicle/insurance/";
			
			File obj = new File(directory+insurance);
			
			@SuppressWarnings("resource")
			FileOutputStream fileOutputStream = new FileOutputStream(obj);
			
			fileOutputStream.write(b);
			
			
			// Fitness Doc Uploading
			
			byte byt[] = vFitness.getBytes();
			
			String docDirectory = "/home/yuvi/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Transportation/assets/transporter/vehicle/fitness/";
			
			File docObj = new File(docDirectory+fitness);
			
			@SuppressWarnings("resource")
			FileOutputStream fileOutputStream2 = new FileOutputStream(docObj);
			
			fileOutputStream2.write(byt);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		vehicle.setInsurance(insurance);
		
		vehicle.setFitness(fitness);
		
		vehicle.setApproval(false);
		
		vehicle.setTransporter(new Transporter(transId));
		
		String response = transporterDAO.saveVehicle(vehicle);
		
		return response;
	}


	
	// Get transid by loginid
	
	@Override
	public int getTransporterId(int loginId) {
		int transId = transporterDAO.getTransporterId(loginId);
		
		return transId;
	}


	
// Vehicles List by transporter id
	
	@Override
	public List<Vehicle> getAllVehicles(int transId) {
		
		List <Vehicle> vehicles = transporterDAO.getAllVehicles(transId);
		
		return vehicles;
	}


	
// Post deal
	
	@Override
	public String saveDeal(Deal deal, String selectedVehicle, int transId) {
		
		deal.setVehicle(new Vehicle(selectedVehicle));
		
		deal.setTransporter(new Transporter(transId));
		
		String response = transporterDAO.saveDeal(deal);
		
		return response;
	}


// Get all deals
	
	@Override
	public List<Deal> getAllDeals(int transId) {
		
		List <Deal> deals = transporterDAO.getAllDeals(transId);
		
		return deals;
	}


// Get deal by id
	
	@Override
	public Deal fetchDeal(int dealId) {
		
		Deal deal = transporterDAO.fetchDeal(dealId);
		return deal;
	}

	
// Get all queries of specific transporter

	@Override
	public List<Query> getAllQueries(int transId) {
		
		List <Query> queries = transporterDAO.getAllQueries(transId);
		
		return queries;
	}


// Save Reply
	
	@Override
	public String saveReply(Query query) {
		
		String res = transporterDAO.saveReply(query);
		
		return res;
	}


// Get rating
	
	@Override
	public String getRating(Transporter transporter) {
		
		String res = transporterDAO.getRating(transporter);
		
		return res;
	}



}
