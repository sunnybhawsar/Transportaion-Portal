package com.wp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wp.models.Customer;
import com.wp.models.Login;
import com.wp.services.CustomerServices;
import com.wp.services.OtherServices;

@Controller
public class CustomerController {
	
	@Autowired
	private OtherServices otherServices;
	
	@Autowired
	private CustomerServices customerServices;
	
	
	// Add new customer
	
	@RequestMapping("addCustomer")
	public ModelAndView addCustomer(@ModelAttribute("customerDetails") Customer customer, @ModelAttribute("loginDetails") Login login, @RequestParam("picture") MultipartFile file)
	{
		login.setRole("Customer");
		login.setApproval(true);
		
		Login loginDetails = otherServices.addLoginDetails(login);
		
		int loginId = loginDetails.getLoginId();
		
		//System.out.println("addController: loginId - "+loginId);
		
		
		
		String response = customerServices.addCustomer(customer,loginId, file);
		
		//System.out.println("addcontroller: Status - "+response);
		
		ModelAndView modelAndView = new ModelAndView("other/Registered");
		
		return modelAndView;
	}

}
