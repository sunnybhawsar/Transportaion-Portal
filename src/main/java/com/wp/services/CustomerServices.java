package com.wp.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wp.models.Customer;
import com.wp.models.Deal;
import com.wp.models.Query;
import com.wp.models.Transporter;

public interface CustomerServices {
	
	public String addCustomer(Customer customer, int loginId, MultipartFile file);
	
	public Customer getCustomer(int id);
	
	public String updateCustomer(Customer customer);
	
	public List<Deal> getAllDeals();
	
	public List<Query> getAllQueries(int custId);
	
	public List<Transporter> getAllTransporters();
	
	public String saveQuery(Query query,int transId, String transEmail, int custId, String custEmail);
	
	public String rateTransporter(int rating, int transId);

}
