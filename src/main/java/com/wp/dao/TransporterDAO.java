package com.wp.dao;

import com.wp.models.Transporter;

public interface TransporterDAO {
	
	public String addTransporter(Transporter transporter);
	
	public Transporter getTransporter(int id);
	
	public String updateTransporter(Transporter transporter);

}
