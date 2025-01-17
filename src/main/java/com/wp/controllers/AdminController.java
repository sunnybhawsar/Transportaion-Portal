package com.wp.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wp.models.Deal;
import com.wp.models.Login;
import com.wp.models.Transporter;
import com.wp.models.Vehicle;
import com.wp.services.AdminServices;
import com.wp.services.OtherServices;
import com.wp.services.TransporterServices;

@Controller
public class AdminController {
	
	@Autowired
	private TransporterServices transporterServices;
	
	@Autowired
	private OtherServices otherServices;
	
	@Autowired
	private AdminServices adminServices;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public List <Transporter> transporters;
	public List <Vehicle> vehicles;
	public List <Deal> deals;
	
	public Transporter transporter;
	
// Admin Routes
	

		@RequestMapping("/admin/admTransporters")
		public ModelAndView admTransporters()
		{
			transporters = transporterServices.getAllTransporters();
			
		//	System.out.println(transporters);
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmTransporters");
			modelAndView.addObject("transporters",transporters);
			return modelAndView;
		}
		
		@RequestMapping("/admin/admVehicles")
		public ModelAndView admVehicles()
		{
			vehicles = adminServices.getAllVehicles();
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmVehicles");
			
			modelAndView.addObject("vehicles", vehicles);
			
			return modelAndView;
		}
		
		
		@RequestMapping("/admin/admCustomers")
		public String admCustomers()
		{
			return "admin/AdmCustomers";
		}
		
		
		@RequestMapping("/admin/admDeals")
		public ModelAndView admDeals()
		{
			deals = adminServices.getAllDeals();
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmDeals");
			
			modelAndView.addObject("deals",deals);
			
			return modelAndView;
		}
		

// Actions
	
	// Fetch Transporter by id
		
		@RequestMapping("/admin/fetchTransporter")
		public ModelAndView admFetchTransporter(@RequestParam("id") int id)
		{
			transporter = transporterServices.getTransporter(id);
			
			//System.out.println(transporter);
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmTransporterDetails");
	
			modelAndView.addObject("transporter",transporter);
			return modelAndView;
		}
		
		
	// See Documents
		
		@RequestMapping("/admin/openDocument")
		public void openImage(@RequestParam("fileName") String fileName, HttpServletResponse response) throws IOException
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
		
		
		@RequestMapping("/admin/vehicleDocument")
		public void vehicleDocument(@RequestParam("fileName") String fileName, HttpServletResponse response) throws IOException
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
		
		
	// Approve Transporter
		
		@RequestMapping("/admin/approveTransporter")
		public ModelAndView admApproveTransporter(@RequestParam("id") int transId)
		{
			Transporter transporter = transporterServices.getTransporter(transId);
			
			int loginId = transporter.getLogin().getLoginId();
		
			Login login = otherServices.getLoginDetails(loginId);
			
			String response = adminServices.approveTransporter(login);
			
			String action = "";
			String caption = "";
			
			if(response.equals("Success"))
			{
				String to = transporter.getEmail();
				String subject = "Account Activated - Transportation";
				String message = "Your account has been successfully activated after checking your details and documents. \nNow you can Login to the portal using your registered credentials and can use the services. \n\nContact us for more information.";
				
				int status = sendEmail(to, subject, message);
				
				action = "Transporter Approved!";
				if(status == 200)
				{
					caption = "Email has been sent to transporter!";
				}
				else
				{
					caption = "";
				}
			}
			else
			{
				action="Something went wrong!";
			}
			
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmStatus");
			modelAndView.addObject("action",action);
			modelAndView.addObject("caption",caption);
			modelAndView.addObject("nextView","admTransporters");
			return modelAndView;
			
		}
		
		
	// Decline Transporter Request
		
		@RequestMapping("/admin/declineTransporter")
		public ModelAndView admDeclineTransporter(@RequestParam("id") int transId)
		{
			Transporter transporter = transporterServices.getTransporter(transId);
			
			int loginId = transporter.getLogin().getLoginId();
		
			Login login = otherServices.getLoginDetails(loginId);
		
			
			
			
			String response = adminServices.declineTransporter(login);
			
			String action = "";
			String caption = "";
			
			if(response.equals("Success"))
			{
				String to = transporter.getEmail();
				String subject = "Account Deactivated - Transportation";
				String message = "Your account has been deactivated due to some reasons. You can't Login to the portal using your registered credentials. \n\nContact us for more information.";
				
				int status = sendEmail(to, subject, message);
				
				action = "Transporter Account Deactivated!";
				if(status == 200)
				{
					caption = "Email has been sent to transporter!";
				}
				else
				{
					caption = "";
				}
			}
			else
			{
				action="Something went wrong!";
			}
			
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmStatus");
			modelAndView.addObject("action",action);
			modelAndView.addObject("caption",caption);
			modelAndView.addObject("nextView","admTransporters");
			return modelAndView;
			
		}
		
		
	// Fetch Vehicle by regno
		
		@RequestMapping("/admin/fetchVehicle")
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
			
			//System.out.println(transporter);
			
			ModelAndView modelAndView = new ModelAndView("admin/AdmVehicleDetails");
	
			modelAndView.addObject("vehicle",vehicle);
			return modelAndView;
		}
		
		
	// Approve Vehicle
		
				@RequestMapping("/admin/approveVehicle")
				public ModelAndView admApproveVehicle(@RequestParam("regNo") String regNo)
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
					
					String response = adminServices.approveVehicle(vehicle);
			
					
					vehicles = adminServices.getAllVehicles();
					
					ModelAndView modelAndView = new ModelAndView("admin/AdmVehicles");
					modelAndView.addObject("vehicles",vehicles);
					return modelAndView;
					
				}
				
				
		// Decline Transporter Request
				
				@RequestMapping("/admin/declineVehicle")
				public ModelAndView admDeclineVehicle(@RequestParam("regNo") String regNo)
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
					
					String response = adminServices.declineVehicle(vehicle);
					//System.out.println(response);
					
					vehicles = adminServices.getAllVehicles();
					//System.out.println(vehicles);
					
					ModelAndView modelAndView = new ModelAndView("admin/AdmVehicles");
					modelAndView.addObject("vehicles",vehicles);
					return modelAndView;
					
				}
				
				
	// fetch a deal details
				
				@RequestMapping("/admin/fetchDeal")
				public ModelAndView admFetchDeal(@RequestParam("dealId") int dealId)
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
					
					ModelAndView modelAndView = new ModelAndView("admin/AdmDealDetails");

					modelAndView.addObject("deal",deal);
					return modelAndView;
				
				}
				
	// Decline Reasone for deal
				
				@RequestMapping("admin/declineReason")
				public ModelAndView declineReason(@RequestParam("dealId") String dealId, @RequestParam("transEmail") String transEmail)
				{
					
					ModelAndView modelAndView = new ModelAndView("admin/AdmDeclineDeal");
					
					modelAndView.addObject("dealId",dealId);
					modelAndView.addObject("transEmail",transEmail);
					
					return modelAndView;
				}
				
	// Declie a Deal
				
				@RequestMapping("/admin/declineDeal")
				public ModelAndView admDeclineDecline(
						@RequestParam("dealId") int dealId,
						@RequestParam("reason") String reason,
						@RequestParam("transEmail") String transEmail
						)
				{
				
					
					String response = adminServices.declineDeal(dealId);
					
					String action = "";
					String caption = "";
					
					if(response.equals("Success"))
					{
						String to = transEmail;
						String subject = "Deal "+dealId+" Declined - Transportation";
						String message = "Your Deal (Deal id = "+dealId+") has been declined! \n"+reason+" \n\nContact us for more information.";
						
						int status = sendEmail(to, subject, message);
						
						action = "Deal Declined!";
						if(status == 200)
						{
							caption = "Email has been sent to transporter!";
						}
						else
						{
							caption = "";
						}
					}
					else
					{
						action="Something went wrong!";
					}
					
					
					ModelAndView modelAndView = new ModelAndView("admin/AdmStatus");
					modelAndView.addObject("action",action);
					modelAndView.addObject("caption",caption);
					modelAndView.addObject("nextView","admDeals");
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

}
