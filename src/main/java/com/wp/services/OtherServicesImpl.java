package com.wp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.wp.dao.OtherDAO;
import com.wp.models.Login;

@Service
public class OtherServicesImpl implements OtherServices {
	
	@Autowired
	private OtherDAO otherDAO;

	public static String hashingPassword(String password) {
		String salt = BCrypt.gensalt(5);
		String hashPassword = BCrypt.hashpw(password, salt);

		return(hashPassword);
	}
	
	public static boolean checkPassword(String password, String storedHash) {
		
		boolean passwordVerified = false;

		if(null == storedHash || !storedHash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		passwordVerified = BCrypt.checkpw(password, storedHash);

		return(passwordVerified);
	}

	
// Add Login Details

	@Override
	public Login addLoginDetails(Login login) {
		
		String password = login.getPassword();
		
		String hashPassword = hashingPassword(password);;
		
		login.setPassword(hashPassword);
		
		Login loginDetails = otherDAO.addLoginDetails(login);
		
		return loginDetails;
	}

	
// Get Login Details
	
	@Override
	public Login getLoginDetails(int transid) {
		
		Login login = otherDAO.getLoginDetails(transid);
		
		return login;
	}

	@Override
	public Login getLoginDetails(Login login) {
		
		String password = login.getPassword();
		
		Login loginDetails = otherDAO.getLoginDetails(login);
		
		if(loginDetails!=null)
		{
			String storedPassword = loginDetails.getPassword();
			
			boolean match = checkPassword(password,storedPassword);
			
			if(!match)
			{
				loginDetails=null;
			}
			
		}
		
		return loginDetails;
	}

	@Override
	public Login updateLoginDetails(Login login) {
		
		return null;
	}

	@Override
	public Login removeLoginDetails(Login login) {
		
		return null;
	}

}
