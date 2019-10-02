package com.wp.services;

import org.springframework.web.multipart.MultipartFile;

import com.wp.models.Transporter;

public interface TransporterServices {
	
	public String addTransporter(Transporter transporter, int loginId, MultipartFile picture, MultipartFile idProof);
	
	public Transporter getTransporter(int id);
	
	public String updateTransporter(Transporter transporter);

}
