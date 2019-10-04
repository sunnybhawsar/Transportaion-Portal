package com.wp.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wp.models.Transporter;

public interface TransporterServices {
	
	public String addTransporter(Transporter transporter, int loginId, MultipartFile picture, MultipartFile idProof);
	
	public Transporter getTransporter(int id);
	
	public List<Transporter> getAllTransporters();
	
	public String updateTransporter(Transporter transporter);

}
