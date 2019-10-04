package com.wp.dao;

import java.util.List;

import com.wp.models.Transporter;

public interface TransporterDAO {
	
	public String addTransporter(Transporter transporter);
	
	public Transporter getTransporter(int id);
	
	public List<Transporter> getAllTransporters();
	
	public String updateTransporter(Transporter transporter);

}
