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

import com.wp.models.Deal;
import com.wp.models.Query;
import com.wp.models.Transporter;
import com.wp.models.Vehicle;

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
		
		session.close();
		
		return "Success";
	}

	@Override
	public Transporter getTransporter(int id) {
		
		session = sessionFactory.openSession();
		
		Transporter transporter = session.get(Transporter.class, id);
	
		session.close();
		
		return transporter;
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
	
	@Override
	public String updateTransporter(Transporter transporter) {
		
		return null;
	}

	
	
	@Override
	public String saveVehicle(Vehicle vehicle) {
		
		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
		
		session.save(vehicle);
		
		transaction.commit();
		
		session.close();
		
		return "Success";
	}

	
// Get trans id from loginid
	
	@Override
	public int getTransporterId(int loginId) {
		
		session = sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		Criteria cr=session.createCriteria(Transporter.class);
		
		Criterion cri=Restrictions.eq("login.loginId", loginId);
		
	//	Projection projection=Projections.property("transporterId");
		cr.add(cri);
		@SuppressWarnings("unchecked")
		List<Transporter> idlist=cr.list();
		
		//System.out.println(idlist);
		
		int transId = 0;
		
		if(idlist!= null)
		{
			transId = idlist.get(0).getTransporterId();
		}
		
		
		return transId;
	}

	
// Get all vehicles by transId
	
	@Override
	public List<Vehicle> getAllVehicles(int transId) {
		
		session = sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Vehicle.class);
		
		Criterion criterion = Restrictions.eq("transporter.transporterId", transId);
		
		criteria.add(criterion);
	
		@SuppressWarnings("unchecked")
		List<Vehicle> vehicles = criteria.list();		
		
		return vehicles;
	}

	
// post deal
	
	@Override
	public String saveDeal(Deal deal) {
		
		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
		
		session.save(deal);
		
		transaction.commit();
		
		session.close();
		
		return "Success";
	}

	
// Get all vehicles
	
	@Override
	public List<Deal> getAllDeals(int transId) {
		
		session = sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Deal.class);
		
		Criterion criterion = Restrictions.eq("transporter.transporterId", transId);
		
		criteria.add(criterion);
	
		@SuppressWarnings("unchecked")
		List<Deal> deals = criteria.list();		
		
		return deals;
	}

	
// Get deal by id
	
	@Override
	public Deal fetchDeal(int dealId) {
		
		session = sessionFactory.openSession();
		
		Deal deal = session.get(Deal.class, dealId);
		
		session.close();
		
		return deal;
	}

	
// Get all queries of transporter by id
	
	@Override
	public List<Query> getAllQueries(int transId) {
		
		session = sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Query.class);
		
		Criterion criterion = Restrictions.eq("transporter.transporterId", transId);
		
		criteria.add(criterion);
	
		@SuppressWarnings("unchecked")
		List<Query> queries = criteria.list();		
		
		return queries;
	}

// Update Response
	
	@Override
	public String saveReply(Query query) {
		
		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
		
		session.update(query);
		
		transaction.commit();
		
		session.close();
		
		return "Success";
		
	}

	
// Get rating
	
	@Override
	public String getRating(Transporter transporter) {

		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
		
		session.update(transporter);
		
		transaction.commit();
		
		session.close();
		
		return "Success";
	}

	
// Delete Query
	
	@Override
	public String deleteQuery(int queryId) {
		
		session = sessionFactory.openSession();
		
		Query query = session.get(Query.class, queryId);
		
		transaction = session.beginTransaction();
		
		session.delete(query);
		
		transaction.commit();
		
		return "Success";
	}
	
// Delete Vehicle
	
	@Override
	public String deleteVehicle(String regNo) {

		session = sessionFactory.openSession();
		
		Vehicle vehicle = session.get(Vehicle.class, regNo);
		
		transaction = session.beginTransaction();
		
		session.delete(vehicle);
		
		transaction.commit();
		
		return "Success";
	}

	
// Delete Deal
	
	@Override
	public String deleteDeal(int dealId) {
		
		session = sessionFactory.openSession();
		
		Deal deal = session.get(Deal.class, dealId);
		
		transaction = session.beginTransaction();
		
		session.delete(deal);
		
		transaction.commit();
		
		return "Success";
	}

	

}
