package com.wp.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

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
	
	public Customer customer;
	public List <String> cities;
	
	public List <String> dealIds = new ArrayList<String>();
	public List <String> sourceList = new ArrayList<String>();
	public List <String> destinationList = new ArrayList<String>();
	
	// Routes
	
	
	@RequestMapping("/customer/custProfile")
	
	public ModelAndView custProfile(@SessionAttribute("id") int loginId)
	{
		int customerId = otherServices.getLoginDetails(loginId).getCustomer().getCustomerId();
		
		customer = customerServices.getCustomer(customerId);
		
		cities = new ArrayList<String>();
		cities.add("Indore");
		cities.add("Ujjain");
		cities.add("Dewas");
		cities.add("Rau");
		
		ModelAndView modelAndView = new ModelAndView("customer/CustProfile");
		
		modelAndView.addObject("customer",customer);
		modelAndView.addObject("cities",cities);
		
		return modelAndView;
	}
	
	@RequestMapping("/customer/custExploreDeals")
	public ModelAndView custExploreDeals()
	{
		deals = customerServices.getAllDeals();
		
		dealIds.add("Select");
		sourceList.add("Select");
		destinationList.add("Select");
		
		for(Deal d : deals)
		{
			dealIds.add(String.valueOf(d.getDealId()));
			sourceList.add(d.getSourceCity());
			destinationList.add(d.getDestinationCity());
			
		}
		
		
		
		ModelAndView modelAndView = new ModelAndView("customer/CustExploreDeals");
		
		modelAndView.addObject("deals",deals);
		modelAndView.addObject("dealIds",dealIds);
		modelAndView.addObject("sourceList",sourceList);
		modelAndView.addObject("destinationList",destinationList);
		
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
	
	
// Rate Transporter
	
	@RequestMapping("customer/rateTransporter")
	public ModelAndView rateTransporter(
			@SessionAttribute("id") int loginId,
			@RequestParam("rate") String rate,
			@RequestParam("transId") int transId,
			@RequestParam("transName") String transName
			)
	{
		int rating = Integer.parseInt(rate);
		
		String res = customerServices.rateTransporter(rating,transId);
		
		String status;
		
		if(res.equals("Success"))
		{
			status = "Transporter ("+transName+") Rated!";
		}
		else
		{
			status = "Try again later!";
		}
		
		deals = customerServices.getAllDeals();
		
		ModelAndView modelAndView = new ModelAndView("customer/CustExploreDeals");
		
		modelAndView.addObject("status",status);
		modelAndView.addObject("deals",deals);
		modelAndView.addObject("dealIds",dealIds);
		modelAndView.addObject("sourceList",sourceList);
		modelAndView.addObject("destinationList",destinationList);
			
		return modelAndView;
	}
	
	
	// Update Profile
	
	@RequestMapping("customer/updateProfile")
	public ModelAndView updateProfile(@ModelAttribute("customer") Customer customer, @RequestParam("picture") MultipartFile file)
	{
		customer.setCustomerId(this.customer.getCustomerId());
		customer.setLogin(new Login(this.customer.getLogin().getLoginId()));
		
		String response = customerServices.updateCustomer(customer, file);
	//	String response = "Success";
		
		String status="";
		
		if(response.equals("Success"))
		{
			status = "Profile Updated!";
		}
		else
		{
			status = "Try again later!";
		}
	
		ModelAndView modelAndView = new ModelAndView("customer/CustProfile");
		
		modelAndView.addObject("customer",customer);
		modelAndView.addObject("cities",cities);
		modelAndView.addObject("status",status);
		
		return modelAndView;
	}
	
	
	// Open File
	
	@RequestMapping("/customer/viewFile")
	public void viewFile(@RequestParam("fileName") String fileName, HttpServletResponse response) throws IOException
	{
		
		String directory = "/home/yuvi/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Transportation/assets/";
		
		String folder="customer/images/";
	
		FileInputStream fileInputStream = new FileInputStream(directory+folder+fileName);
		
		byte bytes[] = new byte[fileInputStream.available()];
		
		fileInputStream.read(bytes);
		
		ServletOutputStream out = response.getOutputStream();
		
		out.write(bytes);
		
		fileInputStream.close();
	}

	
	// Delete Query
	
	@RequestMapping("customer/deleteQuery")
	public ModelAndView deleteQuery(@RequestParam("queryId") int queryId, @SessionAttribute("id") int loginId)
	{
		String response = customerServices.deleteQuery(queryId);
		
		String status="";
		if(response.equals("Success"))
		{
			status = "Query Deleted!";
		}
		else
		{
			status = "Try again later!";
		}
		

		int customerId = otherServices.getLoginDetails(loginId).getCustomer().getCustomerId();
		
		queries = customerServices.getAllQueries(customerId);
		
		ModelAndView modelAndView = new ModelAndView("customer/CustQueries");
		
		modelAndView.addObject("queries", queries);
		modelAndView.addObject("status",status);
		
		return modelAndView;
	}
	
	
	// Apply filter
	
	@RequestMapping("customer/applyFilter")
	public ModelAndView applyFiler(
			@RequestParam("dealId") String dealId,
			@RequestParam("source") String source,
			@RequestParam("destination") String destination
			)
	{
		
		this.deals = customerServices.getAllDeals();
		
		List <Deal> deals = new ArrayList<Deal>();
		
		if(dealId.equals("Select") && source.equals("Select") && destination.equals("Select"))
		{
			deals = this.deals;
		}
		
		else if(!dealId.equals("Select"))
		{
			for(Deal d : this.deals)
			{
				
				if(String.valueOf(d.getDealId()).equals(dealId)) 
				  { 
					  deals.add(d); 
				  }
				 
			}
		}
		
		else if(!source.equals("Select"))
		{
			for(Deal d : this.deals)
			{
				
				if(d.getSourceCity().equals(source)) 
				  { 
					  deals.add(d); 
				  }
				 
			}
		}
		
		else if(!destination.equals("Select"))
		{
			for(Deal d : this.deals)
			{
				
				if(d.getDestinationCity().equals(destination)) 
				  { 
					  deals.add(d); 
				  }
				 
			}
		}
		
		else
		{
			deals = this.deals;
		}
		
		
		
		
		
		ModelAndView modelAndView = new ModelAndView("customer/CustExploreDeals");
		
		modelAndView.addObject("deals",deals);
		modelAndView.addObject("dealIds",dealIds);
		modelAndView.addObject("sourceList",sourceList);
		modelAndView.addObject("destinationList",destinationList);
		
		return modelAndView;
	}

}
  