package com.wp.services;

import com.wp.models.Login;

public interface OtherServices {
	
	public Login addLoginDetails(Login login);
	
	public Login getLoginDetails(int id);	
	
	public Login getLoginDetails(Login login);
	
	public Login updateLoginDetails(Login login);
	
	public Login removeLoginDetails(Login login);

}