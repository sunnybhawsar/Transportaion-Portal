package com.wp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.models.Customer;
import com.wp.models.Deal;
import com.wp.models.Query;
import com.wp.models.Transporter;

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
	
		session = sessionFactory.openSession();
		
		Customer customer = session.get(Customer.class, id);
	
		session.close();
		
		return customer;
	}

	@Override
	public String updateCustomer(Customer customer) {
	
		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
		
		System.out.println("updateprofile ----------"+customer.getCustomerId());
		
		session.update(customer);
		
		transaction.commit();
		
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

	@Override
	public List<Transporter> getAllTransporters() {
		
		session = sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Transporter.class);
		
		@SuppressWarnings("unchecked")
		List <Transporter> transporters = criteria.list();
		
		session.close();
		
		return transporters;
	}

	
	// Save Query
	
	@Override
	public String saveQuery(Query query) {
		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
		
		session.save(query);
		
		transaction.commit();
		
		return "Success";
	}

	
	// Get all queries by custId
	
	@Override
	public List<Query> getAllQueries(int custId) {

		session = sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Query.class);
		
		Criterion criterion = Restrictions.eq("customer.customerId", custId);
		
		criteria.add(criterion);
	
		@SuppressWarnings("unchecked")
		List<Query> queries = criteria.list();		
		
		return queries;
	}

}
