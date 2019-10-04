package com.wp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wp.models.Login;
import com.wp.models.Transporter;
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
	
	public Transporter transporter;
	
// Admin Routes

		@RequestMapping("/admin/admTransporters")
		public ModelAndView admTransporters()
		{
			transporters = transporterServices.getAllTransporters();
			
			System.out.println(transporters);
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmTransporters");
			modelAndView.addObject("transporters",transporters);
			return modelAndView;
		}
		
		@RequestMapping("/admin/admVehicles")
		public String admVehicles()
		{
			return "admin/AdmVehicles";
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
		
		@RequestMapping("/admin/fetchTransporter")
		public ModelAndView admFetchTransporter(@RequestParam("id") int id)
		{
			transporter = transporterServices.getTransporter(id);
			
			System.out.println(transporter);
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmTransporterDetails");
	
			modelAndView.addObject("transporter",transporter);
			return modelAndView;
		}
		
		
		
		@RequestMapping("/admin/approveTransporter")
		public ModelAndView admApproveTransporter(@RequestParam("id") int id)
		{
		
			Login login = otherServices.getLoginDetails(id);
			
			System.out.println(login);
			
			String response = adminServices.approveTransporter(login);
			
			System.out.println(response);
			
			transporters = transporterServices.getAllTransporters();
			
			System.out.println(transporters);
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmTransporters");
			modelAndView.addObject("transporters",transporters);
			return modelAndView;
			
		}
		
		
		@RequestMapping("/admin/declineTransporter")
		public ModelAndView admDeclineTransporter(@RequestParam("id") int id)
		{
		
			Login login = otherServices.getLoginDetails(id);
			
			System.out.println(login);
			
			String response = adminServices.declineTransporter(login);
			
			System.out.println(response);
			
			transporters = transporterServices.getAllTransporters();
			
			System.out.println(transporters);
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmTransporters");
			modelAndView.addObject("transporters",transporters);
			return modelAndView;
			
		}

}
