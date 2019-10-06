package com.wp.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wp.models.Customer;
import com.wp.models.Deal;

public interface CustomerServices {
	
	public String addCustomer(Customer customer, int loginId, MultipartFile file);
	
	public Customer getCustomer(int id);
	
	public String updateCustomer(Customer customer);
	
	public List<Deal> getAllDeals();

}
