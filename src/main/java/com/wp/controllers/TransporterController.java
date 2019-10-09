package com.wp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wp.models.Deal;
import com.wp.models.Login;
import com.wp.models.Query;
import com.wp.models.Transporter;
import com.wp.models.Vehicle;
import com.wp.services.OtherServices;
import com.wp.services.TransporterServices;

@Controller
public class TransporterController {
	
	@Autowired
	private OtherServices otherServices;
	
	@Autowired
	private TransporterServices transporterServices;
	
	public List <Vehicle> vehicles;
	
	public List <Deal> deals;
	
	public List <Query> queries;
	
	
// Routes
	
	@RequestMapping("/transporter/transProfile")
	public String transProfile()
	{
		return "transporter/TransProfile";
	}
	
	@RequestMapping("/transporter/transVehicles")
	public ModelAndView transVehicles(@SessionAttribute("id") int loginId)
	{
		
		//System.out.println("loginId: "+loginId);
		
		int transId = transporterServices.getTransporterId(loginId);
		
		//System.out.println("tranId:"+transId);

		
		 //Transporter transporter=transporterServices.getTransporter(transId);
		 // System.out.println(transporter);
		  
		/*
		 * List <Vehicle> vehicles = transporter.getVehicles();
		 * 
		 * System.out.println(vehicles);
		 */
		 
		  
		vehicles  = transporterServices.getAllVehicles(transId);
		
		ModelAndView modelAndView = new ModelAndView("transporter/TransVehicles");
		modelAndView.addObject("vehicles",vehicles);
		return modelAndView;
	}

	@RequestMapping("/transporter/transDeals")
	public ModelAndView transDeals(@SessionAttribute("id") int loginId)
	{
		
		int transId = transporterServices.getTransporterId(loginId);
		  
		deals  = transporterServices.getAllDeals(transId);
		
		ModelAndView modelAndView = new ModelAndView("transporter/TransDeals");
		
		modelAndView.addObject("deals",deals);
		
		return modelAndView;
	}
	
	@RequestMapping("/transporter/transQueries")
	public ModelAndView transQueries(@SessionAttribute("id") int loginId)
	{
		int transporterId = otherServices.getLoginDetails(loginId).getTransporter().getTransporterId();
		
		queries = transporterServices.getAllQueries(transporterId);
		
		ModelAndView modelAndView = new ModelAndView("transporter/TransQueries");
		
		modelAndView.addObject("queries", queries);
		
		return modelAndView;
	}
	
	@RequestMapping("/transporter/addVehicle")
	public ModelAndView addVehicle(@ModelAttribute("vehicle") Vehicle vehicle)
	{
		List <String> vehicleTypes = new ArrayList<String>();
		vehicleTypes.add("Select vehicle type");
		vehicleTypes.add("Truck");
		vehicleTypes.add("Trolley");
		vehicleTypes.add("Pickup");
		
		List <String> brands = new ArrayList<String>();
		brands.add("Brand");
		brands.add("TATA");
		brands.add("Mahindra");
		brands.add("Chevrolet");
		brands.add("Suzuki");
		
		
		ModelAndView modelAndView = new ModelAndView("transporter/TransAddVehicle");
		modelAndView.addObject("vehicleTypes",vehicleTypes);
		modelAndView.addObject("brands",brands);
		return modelAndView;
	}
	
	
	@RequestMapping("/transporter/addDeal")
	public ModelAndView addDeal(@ModelAttribute("deal") Deal deal,@SessionAttribute("id") int loginId)
	{
		int transId = transporterServices.getTransporterId(loginId);
		List <Vehicle> vehicles = transporterServices.getAllVehicles(transId);
		
		List <String> availableVehicles = new ArrayList<String>();
		
		for (Vehicle vehicle : vehicles)
		{
			if(vehicle.isApproval())
			{
				availableVehicles.add(vehicle.getRegistrationNumber());
			}
		}
		
		
		List <String> sourceCities = new ArrayList<String>();
		sourceCities.add("Indore");
		sourceCities.add("Ujjain");
		sourceCities.add("Dewas");
		sourceCities.add("Ratlam");
		sourceCities.add("Kota");
		
		List <String> destinationCities = new ArrayList<String>();
		destinationCities.add("Japalpur");
		destinationCities.add("Satna");
		destinationCities.add("Khargone");
		destinationCities.add("Udaipur");
		destinationCities.add("Jaipur");
		
		ModelAndView modelAndView = new ModelAndView("transporter/TransAddDeal");
		modelAndView.addObject("availableVehicles",availableVehicles);
		modelAndView.addObject("sourceCities",sourceCities);
		modelAndView.addObject("destinationCities",destinationCities);
		
		return modelAndView;
	}
	
	

// Actions
	
	// Add new transporter
	
	@RequestMapping("addTransporter")
	public ModelAndView addTransporter(
			@ModelAttribute("transporterDetails") Transporter transporter,
			@ModelAttribute("loginDetails") Login login,
			@RequestParam("picture") MultipartFile picture,
			@RequestParam("identityProof") MultipartFile identityProof
			)
	{
		login.setRole("Transporter");
		login.setApproval(false);
		
		Login loginDetails = otherServices.addLoginDetails(login);
		
		int loginId = loginDetails.getLoginId();
		
		//System.out.println("addController: loginId - "+loginId);
		
		
		String response = transporterServices.addTransporter(transporter,loginId, picture, identityProof);
		
		//System.out.println("addcontroller: Status - "+response);
		
		ModelAndView modelAndView = new ModelAndView("other/Registered");
		
		return modelAndView;
	}
	
	
//  Add new Vehicle
	
	@RequestMapping("transporter/saveVehicle")
	public ModelAndView saveVehicle(
			@ModelAttribute("vehicle") Vehicle vehicle,
			@RequestParam("vInsurance") MultipartFile vInsurance,
			@RequestParam("vFitness") MultipartFile vFitness,
			@SessionAttribute("id") int loginId
			)
	{
		
		int transId = transporterServices.getTransporterId(loginId);
		
		String response = transporterServices.saveVehicle(vehicle, vInsurance, vFitness, transId);
		
		String status;
		
		if(response.equals("Success"))
		{
			status = "Vehicle added successfully!";
		}
		else
		{
			status = "Something went wrong, Try again later!";
		}
		
		//System.out.println("savevehicleController: Status - "+response);
		
		ModelAndView modelAndView = new ModelAndView("transporter/TransAddVehicle");
		
		modelAndView.addObject("status",status);
		
		return modelAndView;
	}
	
	
// fetch a vehicle details
	
	@RequestMapping("/transporter/fetchVehicle")
	public ModelAndView admFetchVehicle(@RequestParam("regNo") String regNo)
	{
		
		Vehicle vehicle=null;
		
		if(vehicles!=null)
		{
		for(Vehicle v : vehicles)
		{
			if(v.getRegistrationNumber().equals(regNo))
			{
				vehicle = v;
			}
		}
		}
		
		//System.out.println(vehicle);
		
		ModelAndView modelAndView = new ModelAndView("transporter/TransVehicleDetails");

		modelAndView.addObject("vehicle",vehicle);
		return modelAndView;
	
	}
	
	
// Save a deal
	
	
	@RequestMapping("transporter/saveDeal")
	public ModelAndView saveDeal(
			@ModelAttribute("deal") Deal deal,
			@RequestParam("selectedVehicle") String selectedVehicle,
			@SessionAttribute("id") int loginId
			)
	{
		
		
		int transId = transporterServices.getTransporterId(loginId);
		
		String response = transporterServices.saveDeal(deal, selectedVehicle, transId);
		
		String status;
		
		if(response.equals("Success"))
		{
			status = "Deal posted successfully!";
		}
		else
		{
			status = "Something went wrong, Try again later!";
		}
		
		//System.out.println("savevehicleController: Status - "+response);
		
		ModelAndView modelAndView = new ModelAndView("transporter/TransAddDeal");
		
		modelAndView.addObject("status",status);
		
		return modelAndView;
	}
	
	
// fetch a deal details
	
		@RequestMapping("/transporter/fetchDeal")
		public ModelAndView transFetchDeal(@RequestParam("dealId") int dealId)
		{
			
			//Deal deal= transporterServices.fetchDeal(dealId);
			Deal deal=null;
		
		  if(deals!=null) 
		  {
			  for(Deal d : deals)
			  {
				  if(d.getDealId() == dealId) 
				  { deal = d; 
				  }
			}
		}
		 
			
			//System.out.println(deal);
			
			ModelAndView modelAndView = new ModelAndView("transporter/TransDealDetails");

			modelAndView.addObject("deal",deal);
			return modelAndView;
		
		}
		
		
// fetch a query details
		
			@RequestMapping("/transporter/queryReply")
			public ModelAndView transReplyQuery(@RequestParam("queryId") int queryId)
			{
				
			Query query = null;
			
			  if(queries!=null) 
			  {
				  for(Query q : queries)
				  {
					  if(q.getQueryId() == queryId) 
					  { 
						  query = q; 
					  }
				}
			}
			 
				ModelAndView modelAndView = new ModelAndView("transporter/TransQueryReply");

				modelAndView.addObject("query",query);
				return modelAndView;
			
			}
			
			
 // save Query Reply
			
			@RequestMapping("/transporter/saveReply")
			public ModelAndView transSaveReply(@RequestParam("qId") int qId, @RequestParam("reply") String reply )
			{
				Query updatedQuery = null;
				
				  if(queries!=null) 
				  {
					  for(Query q : queries)
					  {
						  if(q.getQueryId() == qId) 
						  { 
							  updatedQuery = q; 
						  }
					}
				}
				  
				reply = reply.trim();
				
				updatedQuery.setResponse(reply);
				
				String res = transporterServices.saveReply(updatedQuery);
				
				String status;
				if(res.equals("Success"))
				{
					status = "Reply sent successfully!";
				}
				else
				{
					status = "Something went wrong, Try again later!";
				}
				
				
				ModelAndView modelAndView = new ModelAndView("transporter/TransQueryReply");
				
				modelAndView.addObject("status",status);
				
				return modelAndView;
			}
			
			
	// Delete Query
			
			@RequestMapping("transporter/deleteQuery")
			public ModelAndView deleteQuery(@RequestParam("queryId") int queryId, @SessionAttribute("id") int loginId)
			{
				String res = transporterServices.deleteQuery(queryId);
				
				String status="";
				if(res.equals("Success"))
				{
					status = "Query Deleted!";
				}
				else
				{
					status = "Try again later!";
				}
				

				int transporterId = otherServices.getLoginDetails(loginId).getTransporter().getTransporterId();
				
				queries = transporterServices.getAllQueries(transporterId);
				
				ModelAndView modelAndView = new ModelAndView("transporter/TransQueries");
				
				modelAndView.addObject("queries", queries);
				modelAndView.addObject("status",status);
				
				return modelAndView;
			}	
			
			
		// Delete Vehicle
			
						@RequestMapping("transporter/deleteVehicle")
						public ModelAndView deleteVehicle(@RequestParam("regNo") String regNo, @SessionAttribute("id") int loginId)
						{
							String res = transporterServices.deleteVehicle(regNo);
							
							String status="";
							if(res.equals("Success"))
							{
								status = "Vehicle Deleted!";
							}
							else
							{
								status = "Try again later!";
							}
							

							int transId = otherServices.getLoginDetails(loginId).getTransporter().getTransporterId();
							
							vehicles  = transporterServices.getAllVehicles(transId);
							
							ModelAndView modelAndView = new ModelAndView("transporter/TransVehicles");
							modelAndView.addObject("vehicles",vehicles);
							modelAndView.addObject("status",status);
							return modelAndView;
						}	
		
						
						@RequestMapping("transporter/deleteDeal")
						public ModelAndView deleteDeal(@RequestParam("dealId") int dealId, @SessionAttribute("id") int loginId)
						{
							String res = transporterServices.deleteDeal(dealId);
							
							String status="";
							if(res.equals("Success"))
							{
								status = "Deal Deleted!";
							}
							else
							{
								status = "Try again later!";
							}
							

							int transId = transporterServices.getTransporterId(loginId);
							  
							deals  = transporterServices.getAllDeals(transId);
							
							ModelAndView modelAndView = new ModelAndView("transporter/TransDeals");
							
							modelAndView.addObject("deals",deals);
							modelAndView.addObject("status",status);
							
							return modelAndView;
						}	
		
}
