package com.wp.services;

import org.springframework.web.multipart.MultipartFile;

import com.wp.models.Customer;

public interface CustomerServices {
	
	public String addCustomer(Customer customer, int loginId, MultipartFile file);
	
	public Customer getCustomer(int id);
	
	public String updateCustomer(Customer customer);

}
