package com.wp.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.models.Login;

@Repository
public class OtherDAOImpl implements OtherDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	private Transaction transaction;

	
// Add Login Details
	
	@Override
	public Login addLoginDetails(Login login) {
		
		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
		
		session.save(login);
		
		transaction.commit();
		
		session.close();
			
		return login;
	}

	
// Get Login Details
	
	@Override
	public Login getLoginDetails(int id) {
		
		
		return null;
	}


// Get Login Details by username
	
	@Override
	public Login getLoginDetails(Login login) {
		
		session = sessionFactory.openSession();
		
		/*
		 * String hql = "from Login where username=:uname";
		 * 
		 * Query query = session.createQuery(hql);
		 * 
		 * query.setParameter("uname", username);
		 * 
		 * List <Login> loginDetails = query.getResultList();
		 * 
		 * System.out.println(loginDetails);
		 */
		
		String hql = "from Login where username='"+login.getUsername()+"' ";
		
		@SuppressWarnings("unchecked")
		List <Login> list = session.createQuery(hql).list();
		
		Login loginDetails;
		
		if(list!=null)
			loginDetails = list.get(0);
		
		else
			loginDetails = null;
		
		
		return loginDetails;
	}

	@Override
	public Login updateLoginDetails(Login login) {
		
		return null;
	}

	@Override
	public Login removeLoginDetails(Login login) {
		
		return null;
	}

}
