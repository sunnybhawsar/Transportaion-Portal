package com.wp.services;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wp.dao.TransporterDAO;
import com.wp.models.Login;
import com.wp.models.Transporter;

@Service
public class TransporterServicesImpl implements TransporterServices {
	
	@Autowired
	private TransporterDAO transporterDAO;

	@Override
	public String addTransporter(Transporter transporter, int loginId, MultipartFile picture, MultipartFile idProof) {
		

		
		String img= "img_"+transporter.getName()+".jpg";
		
		String doc= "document_"+transporter.getName()+".pdf";
		
		try {
			
			// Image Uploading
			
			byte b[] = picture.getBytes();
			
			String directory = "/home/yuvi/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Transportation/assets/transporter/images/";
			
			File obj = new File(directory+img);
			
			@SuppressWarnings("resource")
			FileOutputStream fileOutputStream = new FileOutputStream(obj);
			
			fileOutputStream.write(b);
			
			
			// Pdf Uploading
			
			byte byt[] = idProof.getBytes();
			
			String docDirectory = "/home/yuvi/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Transportation/assets/transporter/documents/";
			
			File docObj = new File(docDirectory+doc);
			
			@SuppressWarnings("resource")
			FileOutputStream fileOutputStream2 = new FileOutputStream(docObj);
			
			fileOutputStream2.write(byt);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		transporter.setImage(img);
		
		transporter.setIdProof(doc);
		
		Transporter transporterWithLogin = transporter;
		transporterWithLogin.setLogin(new Login(loginId));
		
		String response = transporterDAO.addTransporter(transporterWithLogin);
		
		return response;
	}
	
	
// Get Transporter

	@Override
	public Transporter getTransporter(int id) {
		
		return null;
	}
	
	
// Update Transporter

	@Override
	public String updateTransporter(Transporter transporter) {
		
		return null;
	}

}
