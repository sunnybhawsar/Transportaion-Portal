package com.wp.dao;

import com.wp.models.Customer;

public interface CustomerDAO {
	
	public String addCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public String updateCustomer(Customer customer);

}
