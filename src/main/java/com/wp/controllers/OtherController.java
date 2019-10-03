package com.wp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wp.models.Login;
import com.wp.services.OtherServices;

@Controller
//@SessionAttributes(names= {"id"})
public class OtherController {
	
	@Autowired
	private OtherServices otherServices;
	
// Login Process
	
	@RequestMapping(value= {"login","other/login","admin/login","customer/login","transporter/login"})
	public ModelAndView login(@ModelAttribute("loginData") Login login, HttpServletRequest request)
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
			request.getSession().setAttribute("id", loginDetails.getLoginId());
			request.getSession().setAttribute("user", loginDetails.getUsername());
			
			if(loginDetails.getRole().equals("Admin"))
			{
				ModelAndView modelAndView = new ModelAndView("redirect:/admin/AdmHome");
				//modelAndView.addObject("id", loginDetails.getLoginId());
				return modelAndView;
			}
			
			else if(loginDetails.getRole().equals("Customer"))
			{
				ModelAndView modelAndView = new ModelAndView("redirect:/customer/CustHome");
				//modelAndView.addObject("id", loginDetails.getLoginId());
				return modelAndView;
			}
			
			else
			{
				if(!loginDetails.isApproval())
				{
					ModelAndView modelAndView = new ModelAndView("redirect:/transporter/TransHome");
					//modelAndView.addObject("id", loginDetails.getLoginId());
					return modelAndView;
				}
				else
				{
					ModelAndView modelAndView = new ModelAndView("other/Login");
					modelAndView.addObject("invalid", "Admin approval needed!");
					return modelAndView;
				}
			}
			
		}
		
	}
	
	
// Logout Process
	
	@RequestMapping(value= {"admin/logout","customer/logout","transporter/logout"})
	public ModelAndView adminLogout(HttpServletRequest request)
	{
		request.getSession().setAttribute("id", null);
		
		request.getSession().invalidate();
		
		ModelAndView modelAndView = new ModelAndView("redirect:/other/Logout");
		return modelAndView;
	}
	
	
// Session Expired
	
	@RequestMapping(value={"admin/sessionExpired","customer/sessionExpired","transporter/sessionExpired"})
	
	public ModelAndView sessionExpired()
	{
		ModelAndView modelAndView = new ModelAndView("other/SessionExpired");
		return modelAndView;
	}

}
