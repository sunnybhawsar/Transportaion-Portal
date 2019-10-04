package com.wp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.models.Login;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	private Transaction transaction;
	
	@Override
	public String approveTransporter(Login login) {
		
		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
		
		session.update(login);
		
		transaction.commit();
		
		return "Success";
		
	}

}
