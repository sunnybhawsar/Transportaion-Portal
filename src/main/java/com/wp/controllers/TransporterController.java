package com.wp.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
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
	
	@Autowired
	private JavaMailSender mailSender;
	
	public List <Vehicle> vehicles;
	
	public List <Deal> deals;
	
	public List <Query> queries;
	
	public Transporter transporter;
	public List <String> cities;
	
	
// Routes
	
	@RequestMapping("/transporter/transProfile")
	public ModelAndView transProfile(@SessionAttribute("id") int loginId)
	{
		int transId = otherServices.getLoginDetails(loginId).getTransporter().getTransporterId();
		
		transporter = transporterServices.getTransporter(transId);
		
		cities = new ArrayList<String>();
		cities.add("Indore");
		cities.add("Ujjain");
		cities.add("Dewas");
		cities.add("Rau");
		
		ModelAndView modelAndView = new ModelAndView("transporter/TransProfile");
		
		modelAndView.addObject("transporter",transporter);
		modelAndView.addObject("cities",cities);
		
		return modelAndView;
	}
	
	@RequestMapping("/transporter/transVehicles")
	public ModelAndView transVehicles(@SessionAttribute("id") int loginId)
	{		
		int transId = transporterServices.getTransporterId(loginId);
		  
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
		
		vehicleTypes.add("Truck");
		vehicleTypes.add("Trolley");
		vehicleTypes.add("Pickup");
		
		List <String> brands = new ArrayList<String>();
		
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
	

	
	// Open File
	
		@RequestMapping("/transporter/viewFile")
		public void viewFile(@RequestParam("fileName") String fileName, HttpServletResponse response) throws IOException
		{
			
			String directory = "/home/yuvi/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Transportation/assets/";
			
			String folder="";
			
			if((fileName.substring(fileName.length()-3)).equals("pdf"))
			
				folder = "transporter/documents/";
			
			else
				folder = "transporter/images/";
				
		
			FileInputStream fileInputStream = new FileInputStream(directory+folder+fileName);
			
			byte bytes[] = new byte[fileInputStream.available()];
			
			fileInputStream.read(bytes);
			
			ServletOutputStream out = response.getOutputStream();
			
			out.write(bytes);
			
			fileInputStream.close();
		}
		
		
		@RequestMapping("/transporter/vehicleFile")
		public void vehicleFile(@RequestParam("fileName") String fileName, HttpServletResponse response) throws IOException
		{
			
			String directory = "/home/yuvi/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Transportation/assets/";
			
			String folder="";
			
			if((fileName.substring(0,3)).equals("fit"))
			
				folder = "transporter/vehicle/fitness/";
			
			else
				folder = "transporter/vehicle/insurance/";
				
		
			FileInputStream fileInputStream = new FileInputStream(directory+folder+fileName);
			
			byte bytes[] = new byte[fileInputStream.available()];
			
			fileInputStream.read(bytes);
			
			ServletOutputStream out = response.getOutputStream();
			
			out.write(bytes);
			
			fileInputStream.close();
		}
	
	
//  Add new Vehicle
	
	@RequestMapping("transporter/saveVehicle")
	public ModelAndView saveVehicle(
			/* @Valid */ @ModelAttribute("vehicle") Vehicle vehicle,
			@RequestParam("vInsurance") MultipartFile vInsurance,
			@RequestParam("vFitness") MultipartFile vFitness,
			@SessionAttribute("id") int loginId
			//,BindingResult bindingResult
			)
	{
	
		/*
		 * if(bindingResult.hasErrors()) { ModelAndView modelAndView = new
		 * ModelAndView("transporter/TransAddVehicle"); return modelAndView; }
		 * 
		 * else {
		 */
		
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
	//}
	
	
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
		String action = "";
		String caption = "";
		
		if(response.equals("Success"))
		{
			status = "Deal posted successfully!";
			action = "Deal posted successfully!";
			
			String to = "customer.in.00@gmail.com";
			
			String subject = "New Deal Posted - Transportation";
			String message = "New Deal posted on our portal by Transporter : "+transId+" \nCheck out now! \n\nContact us for more information.";
			
			int statusCode = sendEmail(to, subject, message);
			
			
			
			  if(statusCode == 200) 
			  {
				  caption = "Email has been sent to all customers!"; 
			  }
			  else
			  {
				  caption = ""; 
			  }
			 
			
		}
		else
		{
			status = "Something went wrong, Try again later!";
			action = "Something went wrong, Try again later!";
		}
		
		
		ModelAndView modelAndView = new ModelAndView("transporter/TransStatus");
		
		modelAndView.addObject("status",status);
		modelAndView.addObject("action",action);
		modelAndView.addObject("caption",caption);
		modelAndView.addObject("nextView","transDeals");
		
		
		return modelAndView;
	}
	
	
			// Save Deal         	####### Automation########
	/*
	 * @RequestMapping("transporter/saveDeal") public ModelAndView saveDeal(
	 * 
	 * @ModelAttribute("deal") Deal deal,
	 * 
	 * @RequestParam("selectedVehicle") String selectedVehicle,
	 * 
	 * @SessionAttribute("id") int loginId ) {
	 * 
	 * 
	 * int transId = transporterServices.getTransporterId(loginId);
	 * 
	 * String response = transporterServices.saveDeal(deal, selectedVehicle,
	 * transId);
	 * 
	 * String status;
	 * 
	 * if(response.equals("Success")) { status = "Deal posted successfully!"; } else
	 * { status = "Something went wrong, Try again later!"; }
	 * 
	 * //System.out.println("savevehicleController: Status - "+response);
	 * 
	 * ModelAndView modelAndView = new ModelAndView("transporter/TransAddDeal");
	 * 
	 * modelAndView.addObject("status",status);
	 * 
	 * return modelAndView; }
	 */

	
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
			
			
	// Update Profile
			
			@RequestMapping("transporter/updateProfile")
			public ModelAndView updateProfile(
					@ModelAttribute("transporter") Transporter transporter,
					@RequestParam("picture") MultipartFile picture,
					@RequestParam("identityProof") MultipartFile identityProof)
			{
				
				transporter.setTransporterId(this.transporter.getTransporterId());
				transporter.setLogin(new Login(this.transporter.getLogin().getLoginId()));
				
				//String response = transporterServices.updateTransporter(transporter, file, identityProof);
				String response = "Success";
				
				String status="";
				
				if(response.equals("Success"))
				{
					status = "Profile Updated!";
				}
				else
				{
					status = "Try again later!";
				}
			
				ModelAndView modelAndView = new ModelAndView("transporter/TransProfile");
				
				modelAndView.addObject("transporter",transporter);
				modelAndView.addObject("cities",cities);
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
			
		
			// Send Email
			
			public int sendEmail(String to, String subject, String message)
			{
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				
				mailMessage.setTo(to);
				
				mailMessage.setSubject(subject);
				
				String header = "Hello,\n\n";
				String footer = "\n\n\nThanks & Regards \nAdmin - Transportation Portal \nIndore, India (452010) \n\nDisclaimer: Feel free to reply!";
				String text = header+message+footer;
				
				mailMessage.setText(text);
				
				mailSender.send(mailMessage);
				
				return 200;
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
