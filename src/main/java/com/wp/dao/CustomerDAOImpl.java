package com.wp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.models.Customer;

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

}
