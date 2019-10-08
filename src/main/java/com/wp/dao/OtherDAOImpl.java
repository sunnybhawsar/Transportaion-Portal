package com.wp.dao;

import java.util.List;

import org.hibernate.Query;
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
		
		session = sessionFactory.openSession();
		
		Login login = session.get(Login.class, id);
		
		session.close();
		
		return login;
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
		
		Login loginDetails=null;
		
		
		String hql = "from Login where username='"+login.getUsername()+"' ";
		
		Query query = session.createQuery(hql);
		
		
		if(query!=null)
		{
		@SuppressWarnings("unchecked")
		List <Login> list = query.list();
		
		if(list!=null)
		{
			if(list.size()!=0)
				loginDetails = list.get(0);
			
			else
				loginDetails = null;
		}
		else
			loginDetails = null;
		}
		
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
