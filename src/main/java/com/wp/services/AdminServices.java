package com.wp.services;

import com.wp.models.Login;

public interface AdminServices {
	
	public String approveTransporter(Login login);
	
	public String declineTransporter(Login login);

}
