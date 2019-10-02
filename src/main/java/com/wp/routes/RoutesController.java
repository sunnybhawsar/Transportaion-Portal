package com.wp.routes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoutesController {
	
	@RequestMapping("signUp")
	public String signUp()
	{
		return "other/SignUp";
	}
	
	@RequestMapping("customerRegistration")
	public String customerRegistration()
	{
		return "other/CustomerRegistration";
	}
	
	@RequestMapping("transporterRegistration")
	public String transporterRegistration()
	{
		return "other/TransporterRegistration";
	}
	
}
