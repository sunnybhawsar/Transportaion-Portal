package com.wp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wp.models.Customer;
import com.wp.models.Deal;
import com.wp.models.Login;
import com.wp.models.Query;
import com.wp.models.Transporter;
import com.wp.services.CustomerServices;
import com.wp.services.OtherServices;

@Controller
public class CustomerController {
	
	@Autowired
	private OtherServices otherServices;
	
	@Autowired
	private CustomerServices customerServices;
	
	public List <Deal> deals;
	
	public List <Transporter> transporters;
	
	public List <Query> queries;
	
	
	// Routes
	
	
	@RequestMapping("/customer/custProfile")
	
	public String custProfile()
	{
		return "customer/CustProfile";
	}
	
	@RequestMapping("/customer/custExploreDeals")
	public ModelAndView custExploreDeals()
	{
		deals = customerServices.getAllDeals();
		
		ModelAndView modelAndView = new ModelAndView("customer/CustExploreDeals");
		modelAndView.addObject("deals",deals);
		return modelAndView;
	}

	@RequestMapping("/customer/custQueries")
	public ModelAndView custQueries(@SessionAttribute("id") int loginId)
	{
		int customerId = otherServices.getLoginDetails(loginId).getCustomer().getCustomerId();
		
		queries = customerServices.getAllQueries(customerId);
		
		ModelAndView modelAndView = new ModelAndView("customer/CustQueries");
		
		modelAndView.addObject("queries", queries);
		
		return modelAndView;
	}
	
	@RequestMapping("/customer/askQuery")
	public ModelAndView custAskQuery()
	{
		transporters = customerServices.getAllTransporters();
		
		List <String> transporterNames = new ArrayList<String>();
		
		for (Transporter transporter : transporters)
		{
			if(transporter.getLogin().isApproval())
			{
				transporterNames.add(transporter.getName());
			}
		}
		
		ModelAndView modelAndView = new ModelAndView("customer/CustAskQuery");
		modelAndView.addObject("transporterNames",transporterNames);
		return modelAndView;
	}
	
	
	
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
	
	
// Save Query
	
	@RequestMapping("customer/saveQuery")
	public ModelAndView saveQuery (
			@ModelAttribute("query") Query query,
			@RequestParam("selectedTransporter") String selectedTransporter,
			@RequestParam("queryData") String queryData,
			@SessionAttribute("id") int loginId			
			)
	{
		
		Transporter transporter = null;
		
		  if(transporters!=null) 
		  {
			  for(Transporter t : transporters)
			  {
				  if(t.getName().equals(selectedTransporter)) 
				  { 
					  transporter = t; 
				  }
			}
		}
		  
		int transId = transporter.getTransporterId();
		String transporterEmail = transporter.getEmail();
		
		int custId = otherServices.getLoginDetails(loginId).getCustomer().getCustomerId();
		String customerEmail = otherServices.getLoginDetails(loginId).getCustomer().getEmail();
		
		
		queryData = queryData.trim();
		
		query.setQuery(queryData);
		
		String res = customerServices.saveQuery(query,transId,transporterEmail,custId,customerEmail);
		
		String status;
		
		if(res.equals("Success"))
		{
			status = "Query sent successfully!";
		}
		else
		{
			status = "Something went wrong, Try again later!";
		}
		
		
		ModelAndView modelAndView = new ModelAndView("customer/CustAskQuery");
		
		modelAndView.addObject("status",status);
		
		return modelAndView;
	}

}
