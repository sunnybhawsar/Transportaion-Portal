package com.wp.services;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wp.dao.CustomerDAO;
import com.wp.models.Customer;
import com.wp.models.Login;

@Service
public class CustomerServicesImpl implements CustomerServices {
	
	@Autowired
	private CustomerDAO customerDAO;

	
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

}
