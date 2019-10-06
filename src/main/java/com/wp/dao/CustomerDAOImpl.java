package com.wp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.models.Customer;
import com.wp.models.Deal;
import com.wp.models.Vehicle;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	private Transaction transaction;

	@Override
	public String addCustomer(Customer customer) {
		
		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
		
		session.save(customer);
		
		transaction.commit();
		
		return "Success";
	}

	@Override
	public Customer getCustomer(int id) {
	
		return null;
	}

	@Override
	public String updateCustomer(Customer customer) {
	
		return null;
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
