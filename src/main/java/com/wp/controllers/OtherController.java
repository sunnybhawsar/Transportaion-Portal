package com.wp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wp.models.Login;
import com.wp.services.OtherServices;

@Controller
public class OtherController {
	
	@Autowired
	private OtherServices otherServices;
	
	@RequestMapping("login")
	public ModelAndView login(@ModelAttribute("loginData") Login login)
	{
		Login loginDetails = otherServices.getLoginDetails(login);
		
		System.out.println("controller: "+loginDetails);
		
		if(loginDetails==null)
		{
			ModelAndView modelAndView = new ModelAndView("other/Login");
			modelAndView.addObject("invalid", "Invalid Username/Password");
			return modelAndView;
		}
		else
		{
			if(loginDetails.getRole().equals("Admin"))
			{
				ModelAndView modelAndView = new ModelAndView("admin/AdmHome");
				return modelAndView;
			}
			
			else if(loginDetails.getRole().equals("Customer"))
			{
				ModelAndView modelAndView = new ModelAndView("customer/CustHome");
				return modelAndView;
			}
			
			else
			{
				if(!loginDetails.isApproval())
				{
					ModelAndView modelAndView = new ModelAndView("transporter/TransHome");
					return modelAndView;
				}
				else
				{
					ModelAndView modelAndView = new ModelAndView("other/Login");
					modelAndView.addObject("invalid", "Invalid Username/Password");
					return modelAndView;
				}
			}
			
		}
		
	}

}
