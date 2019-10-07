package com.wp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.models.Deal;
import com.wp.models.Login;
import com.wp.models.Vehicle;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	private Transaction transaction;
	
	
	// Approve Transporter
	
	@Override
	public String approveTransporter(Login login) {
		
		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
		
		session.update(login);
		
		transaction.commit();
		
		session.close();
		
		return "Success";
		
	}
	
	
	// Get all vehicles

	@Override
	public List<Vehicle> getAllVehicles() {
		
		session = sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Vehicle.class);
		
		@SuppressWarnings("unchecked")
		List <Vehicle> vehicles = criteria.list();
		
		session.close();
		
		return vehicles;
	}


	// Approve Vehicle
	
	@Override
	public String approveVehicle(Vehicle vehicle) {
		
		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
		
		session.update(vehicle);
		
		transaction.commit();
		
		session.close();
		
		return "Success";
	}


	// Get all deals
	
	@Override
	public List<Deal> getAllDeals() {
	
		session = sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Deal.class);
		
		@SuppressWarnings("unchecked")
		List <Deal> deals = criteria.list();
		
		session.close();
		
		return deals;
	}

}
