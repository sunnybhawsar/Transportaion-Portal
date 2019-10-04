package com.wp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.dao.AdminDAO;
import com.wp.models.Login;

@Service
public class AdminServicesImpl implements AdminServices {
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public String approveTransporter(Login login) {
		
		login.setApproval(true);
		
		String response = adminDAO.approveTransporter(login);
		
		return response;
	}

	@Override
	public String declineTransporter(Login login) {
		
		login.setApproval(false);
		
		String response = adminDAO.approveTransporter(login);
		
		return response;
	}

}
