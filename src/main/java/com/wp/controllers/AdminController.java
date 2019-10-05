package com.wp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wp.models.Login;
import com.wp.models.Transporter;
import com.wp.models.Vehicle;
import com.wp.services.AdminServices;
import com.wp.services.OtherServices;
import com.wp.services.TransporterServices;

@Controller
public class AdminController {
	
	@Autowired
	private TransporterServices transporterServices;
	
	@Autowired
	private OtherServices otherServices;
	
	@Autowired
	private AdminServices adminServices;
	
	public List <Transporter> transporters;
	public List <Vehicle> vehicles;
	
	public Transporter transporter;
	
// Admin Routes

		@RequestMapping("/admin/admTransporters")
		public ModelAndView admTransporters()
		{
			transporters = transporterServices.getAllTransporters();
			
		//	System.out.println(transporters);
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmTransporters");
			modelAndView.addObject("transporters",transporters);
			return modelAndView;
		}
		
		@RequestMapping("/admin/admVehicles")
		public ModelAndView admVehicles()
		{
			vehicles = adminServices.getAllVehicles();
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmVehicles");
			
			modelAndView.addObject("vehicles", vehicles);
			
			return modelAndView;
		}
		
		
		@RequestMapping("/admin/admCustomers")
		public String admCustomers()
		{
			return "admin/AdmCustomers";
		}
		
		
		@RequestMapping("/admin/admDeals")
		public String admDeals()
		{
			return "admin/AdmDeals";
		}
		

// Actions
	
		// Fetch Transporter by id
		
		@RequestMapping("/admin/fetchTransporter")
		public ModelAndView admFetchTransporter(@RequestParam("id") int id)
		{
			transporter = transporterServices.getTransporter(id);
			
			//System.out.println(transporter);
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmTransporterDetails");
	
			modelAndView.addObject("transporter",transporter);
			return modelAndView;
		}
		
		
		// Approve Transporter
		
		@RequestMapping("/admin/approveTransporter")
		public ModelAndView admApproveTransporter(@RequestParam("id") int transId)
		{
			Transporter transporter = transporterServices.getTransporter(transId);
			
			int loginId = transporter.getLogin().getLoginId();
		
			Login login = otherServices.getLoginDetails(loginId);
			
			//System.out.println(login);
			
			String response = adminServices.approveTransporter(login);
			
			//System.out.println(response);
			
			transporters = transporterServices.getAllTransporters();
			
			//System.out.println(transporters);
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmTransporters");
			modelAndView.addObject("transporters",transporters);
			return modelAndView;
			
		}
		
		
		// Decline Transporter Request
		
		@RequestMapping("/admin/declineTransporter")
		public ModelAndView admDeclineTransporter(@RequestParam("id") int transId)
		{
			Transporter transporter = transporterServices.getTransporter(transId);
			
			int loginId = transporter.getLogin().getLoginId();
		
			Login login = otherServices.getLoginDetails(loginId);
		
			
			//System.out.println(login);
			
			String response = adminServices.declineTransporter(login);
			
			System.out.println(response);
			
			transporters = transporterServices.getAllTransporters();
			
			//System.out.println(transporters);
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmTransporters");
			modelAndView.addObject("transporters",transporters);
			return modelAndView;
			
		}
		
		
		// Fetch Vehicle by regno
		
		@RequestMapping("/admin/fetchVehicle")
		public ModelAndView admFetchVehicle(@RequestParam("regNo") String regNo)
		{
			Vehicle vehicle=null;
			
			if(vehicles!=null)
			{
			for(Vehicle v : vehicles)
			{
				if(v.getRegistrationNumber().equals(regNo))
				{
					vehicle = v;
				}
			}
			}
			
			//System.out.println(transporter);
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmVehicleDetails");
	
			modelAndView.addObject("vehicle",vehicle);
			return modelAndView;
		}

}
