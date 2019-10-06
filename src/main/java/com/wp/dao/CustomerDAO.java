package com.wp.dao;

import java.util.List;

import com.wp.models.Customer;
import com.wp.models.Deal;

public interface CustomerDAO {
	
	public String addCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public String updateCustomer(Customer customer);
	
	public List<Deal> getAllDeals();

}
