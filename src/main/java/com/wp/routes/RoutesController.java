package com.wp.routes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoutesController {
	
// Other Routes
	
	@RequestMapping(value= {"signUp"})
	public String signUp()
	{
		return "other/SignUp";
	}
	
	@RequestMapping(value= {"customerRegistration"})
	public String customerRegistration()
	{
		return "other/CustomerRegistration";
	}
	
	@RequestMapping(value= {"transporterRegistration"})
	public String transporterRegistration()
	{
		return "other/TransporterRegistration";
	}
	
	@RequestMapping("/other/Logout")
	public String logout()
	{
		return "other/Logout";
	}
		
	@RequestMapping(value= {"Login","/other/Login","/admin/Login","/customer/Login","/transporter/Login"})
	public ModelAndView goToLogin()
	{
		//return "other/Login";
		
		ModelAndView modelAndView = new ModelAndView("redirect:/index.jsp");
		
		return modelAndView;
	}
	
	
	@RequestMapping("/other/SessionExpired")
	public String sessionExpired()
	{
		return "other/SessionExpired";
	}
	
	
// Admin Routes
	
	@RequestMapping("/admin/AdmHome")
	
	public String admHome()
	{
		return "admin/AdmHome";
	}
	
	@RequestMapping("/admin/admTransporters")
	
	public String admTransporters()
	{
		return "admin/AdmTransporters";
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
	
	
	
// Customer Routes
	
	@RequestMapping("/customer/CustHome")
	
	public String custHome()
	{
		return "customer/CustHome";
	}
	
	@RequestMapping("/customer/custProfile")
	
	public String custProfile()
	{
		return "customer/CustProfile";
	}
	
	@RequestMapping("/customer/custExploreDeals")
	
	public String custExploreDeals()
	{
		return "customer/CustExploreDeals";
	}

	@RequestMapping("/customer/custQueries")
	
	public String custQueries()
	{
		return "customer/CustQueries";
	}
	
	
// Transporter Routes
	
		@RequestMapping("/transporter/TransHome")
		public String transHome()
		{
			return "transporter/TransHome";
		}
		
		@RequestMapping("/transporter/transProfile")
		public String transProfile()
		{
			return "transporter/TransProfile";
		}
		
		@RequestMapping("/transporter/transVehicles")
		public String transVehicles()
		{
			return "transporter/TransVehicles";
		}

		@RequestMapping("/transporter/transDeals")
		public String transDeals()
		{
			return "transporter/TransDeals";
		}
		
		@RequestMapping("/transporter/transQueries")
		public String transQueries()
		{
			return "transporter/TransQueries";
		}
}
