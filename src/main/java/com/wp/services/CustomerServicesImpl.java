package com.wp.services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wp.dao.CustomerDAO;
import com.wp.models.Customer;
import com.wp.models.Deal;
import com.wp.models.Login;
import com.wp.models.Query;
import com.wp.models.Transporter;

@Service
public class CustomerServicesImpl implements CustomerServices {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private TransporterServices transporterServices;

	
// Add Customer
	
	@Override
	public String addCustomer(Customer customer,int loginId, MultipartFile file) {
		
		String fileName= "img_"+customer.getName()+".jpg";
		
		try {
			
			byte b[] = file.getBytes();
			
			String directory = "/home/yuvi/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Transportation/assets/customer/images/";
			
			File obj = new File(directory+fileName);
			
			@SuppressWarnings("resource")
			FileOutputStream fileOutputStream = new FileOutputStream(obj);
			
			fileOutputStream.write(b);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		customer.setImage(fileName);
		
		Customer customerWithLogin = customer;
		customerWithLogin.setLogin(new Login(loginId));
		
		String response = customerDAO.addCustomer(customerWithLogin);
		
		return response;
	
	}

	
// Get Customer
	
	@Override
	public Customer getCustomer(int id) {
		
		return null;
	}
	
// Update Customer

	@Override
	public String updateCustomer(Customer customer) {
		
		return null;
	}


// Get all deals
	
	@Override
	public List<Deal> getAllDeals() {
		
		List <Deal> deals = customerDAO.getAllDeals();
		
		return deals;
	}


// Get all transporters
	
	@Override
	public List<Transporter> getAllTransporters() {
		
		List <Transporter> transporters = customerDAO.getAllTransporters();
		
		return transporters;
	}


// Save Query
	
	@Override
	public String saveQuery(Query query, int transId, String transEmail, int custId, String custEmail) {
		
		query.setCustomer(new Customer(custId));
		query.setCustomerEmail(custEmail);
		
		query.setTransporter(new Transporter(transId));
		query.setTransporterEmail(transEmail);
		
		query.setResponse("(No Response)");
		
		String res = customerDAO.saveQuery(query);
		
		return res;
	}

// Get all queries

	@Override
	public List<Query> getAllQueries(int custId) {
		
		List<Query> queries = customerDAO.getAllQueries(custId);
		return queries;
	}


// Rate Transporter
	
	@Override
	public String rateTransporter(int rating, int transId) {
		
		Transporter transporter = transporterServices.getTransporter(transId);
		
		int currentRating = transporter.getRating();
		int ratedBy = transporter.getRatedBy();
		
		int updatedRating = ((currentRating*ratedBy)+rating)/(ratedBy+1);
		
		transporter.setRating(updatedRating);
		transporter.setRatedBy(ratedBy+1);
		
		String res = transporterServices.getRating(transporter);

		return res;
	}

}
