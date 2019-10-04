package com.wp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wp.models.Login;
import com.wp.models.Transporter;
import com.wp.services.OtherServices;
import com.wp.services.TransporterServices;

@Controller
public class TransporterController {
	
	@Autowired
	private OtherServices otherServices;
	
	@Autowired
	private TransporterServices transporterServices;
	
	
	// Add new transporter
	
	@RequestMapping("addTransporter")
	public ModelAndView addTransporter(
			@ModelAttribute("transporterDetails") Transporter transporter,
			@ModelAttribute("loginDetails") Login login,
			@RequestParam("picture") MultipartFile picture,
			@RequestParam("identityProof") MultipartFile identityProof
			)
	{
		login.setRole("Transporter");
		login.setApproval(false);
		
		Login loginDetails = otherServices.addLoginDetails(login);
		
		int loginId = loginDetails.getLoginId();
		
		System.out.println("addController: loginId - "+loginId);
		
		
		String response = transporterServices.addTransporter(transporter,loginId, picture, identityProof);
		
		System.out.println("addcontroller: Status - "+response);
		
		ModelAndView modelAndView = new ModelAndView("other/Registered");
		
		return modelAndView;
	}
	
}
