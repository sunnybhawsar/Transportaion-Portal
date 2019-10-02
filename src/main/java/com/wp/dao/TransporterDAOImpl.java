package com.wp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wp.dao.TransporterDAO;
import com.wp.models.Transporter;

@Repository
public class TransporterDAOImpl implements TransporterDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	private Transaction transaction;

	@Override
	public String addTransporter(Transporter transporter) {
		
		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
		
		session.save(transporter);
		
		transaction.commit();
		
		return "Success";
	}

	@Override
	public Transporter getTransporter(int id) {
		
		return null;
	}

	@Override
	public String updateTransporter(Transporter transporter) {
		
		return null;
	}

}
