package com.wp.dao;

import java.util.List;

import com.wp.models.Customer;
import com.wp.models.Deal;
import com.wp.models.Query;
import com.wp.models.Transporter;

public interface CustomerDAO {
	
	public String addCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public String updateCustomer(Customer customer);
	
	public List<Deal> getAllDeals();
	
	public List<Transporter> getAllTransporters();
	
	public String saveQuery(Query query);
	
	public List <Query> getAllQueries (int custId);
	
	public String deleteQuery(int queryId);
	
}
