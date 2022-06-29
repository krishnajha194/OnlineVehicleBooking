package com.online.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.online.vehicle.model.pojo.BookVehicle;
import com.online.vehicle.model.pojo.BranchAdmin;
import com.online.vehicle.model.pojo.Customer;
import com.online.vehicle.model.pojo.LoginRegistration;
import com.online.vehicle.model.pojo.Vehicle;

@Controller
@SessionAttributes({ "str", "branchAdminObject" ,"branchAdminObject1","allvehicle","CustomerObject1"})
public class LoginRegController {

	public static String baseUrl = "http://localhost:7070/";

  static String msg;
  static   int count;

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/home")
	public String home() {
		return "BranchAdmin";
	}

	@RequestMapping("profile")
	public String profile(Model m, SessionStatus status) {
		String s = (String) m.getAttribute("str");
		BranchAdmin branchAdminObject = (BranchAdmin) m.getAttribute("branchAdminObject");
		BranchAdmin branchAdminObject1 = (BranchAdmin) m.getAttribute("branchAdminObject1");
		Vehicle[] vehicle2=(Vehicle[])m.getAttribute("allvehicle");

		//status.setComplete();
		return "profile";
	}

	@RequestMapping("vehicle")
	public String vehicle(Model m, SessionStatus status) {
		
		Vehicle[] vehicle1 = restTemplate.getForObject(baseUrl + "listofvehicle", Vehicle[].class);
		
//		for (int i = 0; i < vehicle1.length; i++) {
//		if(vehicle1[i].getLoginId().equals((String) m.getAttribute("str"))) {
//			m.addAttribute("allvehicle", vehicle1[i]);
//		}
//		
//}
		
		System.out.println(vehicle1);
		String s = (String) m.getAttribute("str");
		m.addAttribute("allvehicle", vehicle1);
		
		BranchAdmin branchAdminObject = (BranchAdmin) m.getAttribute("branchAdminObject");
		BranchAdmin branchAdminObject1 = (BranchAdmin) m.getAttribute("branchAdminObject1");
		
		return "vehicle";
	}

	@RequestMapping("Booking")
	public String booking() {
		return "Booking";
	}
	
	@RequestMapping("logout")
	public String logout(Model m, SessionStatus status) {
		BranchAdmin branchAdminObject1 = (BranchAdmin) m.getAttribute("branchAdminObject1");
		status.setComplete();
		return "login";
	}

	@RequestMapping("/login")
	public String login(Model m, @ModelAttribute("L") LoginRegistration lr) {
		Vehicle[] vehicle2=(Vehicle[])m.getAttribute("allvehicle");

		
		if (lr.getUserId().equalsIgnoreCase("admin") && lr.getPassword().equalsIgnoreCase("admin")) {
			return "admin";
		    } 
		else {
			//BranchAdmin[] listBranchAdmin = restTemplate.getForObject(baseUrl + "getBranchAdmin", BranchAdmin[].class);
			BranchAdmin user=restTemplate.getForObject(baseUrl+"getBranchAdminById/"+lr.getUserId(), BranchAdmin.class);
			System.out.println("user :"+user);
			if(user!=null) {
				System.out.println("user :"+user);
				m.addAttribute("branchAdminObject1", user);
			}else {
			m.addAttribute("branchAdminObject1", null);
			}
			
			
			LoginRegistration loginRegistration = restTemplate.getForObject(
					baseUrl + "doLogin/" + lr.getUserId() + "/" + lr.getPassword(), LoginRegistration.class);
			
            System.out.println(loginRegistration+"============================");
		
			m.addAttribute("str", loginRegistration.getUserId());

			m.addAttribute("loginDetails", loginRegistration);

			if ("customer".equalsIgnoreCase(loginRegistration.getRole())&& "Approved".equalsIgnoreCase(loginRegistration.getStatus()))
			{
				m.addAttribute("str", loginRegistration.getUserId());
				Customer user1=restTemplate.getForObject(baseUrl+"getCustomernById/"+loginRegistration.getUserId(), Customer.class);
				System.out.println("user1 :"+user1);              
				if(user1!=null) {
					System.out.println("user1 :"+user1);
					m.addAttribute("CustomerObject1", user1);
				}else {
				m.addAttribute("Customer", null);
				}
				
				return "customer";
			}
			else if ("admin".equalsIgnoreCase(loginRegistration.getRole())&& "Approved".equalsIgnoreCase(loginRegistration.getStatus()))
			{
				return "BranchAdmin";
			}
		}
		m.addAttribute("smsg","invalid credentials");
		return "login";
	}
	

	

	@RequestMapping("/addBranchAdmin")
	public String addBranchAdmin(@ModelAttribute("c") BranchAdmin branchAdmin, Model m) {
	
				BranchAdmin branchAdminObject = restTemplate.postForObject(baseUrl + "addBranch", branchAdmin,
						BranchAdmin.class);
				m.addAttribute("branchAdminObject1", branchAdminObject);
				return "profile";
	}

	
	
	@RequestMapping("/addVehicle")
	public String addVehicle(@ModelAttribute("vehicle") Vehicle vehicle,Model m) {
		Vehicle vehicleObject = restTemplate.postForObject(baseUrl + "addVehicle", vehicle,
				Vehicle.class);
		m.addAttribute("vehicleObject", vehicleObject);
		System.out.println(vehicle.toString());
		 
		
		 return "vehicle";
	}
	
	
	@RequestMapping("/doRegister")
	public String doRegister(@ModelAttribute("/loginreg") LoginRegistration loginRegistration){
		 try {
			restTemplate.postForObject(baseUrl + "doRegistration", loginRegistration,
					LoginRegistration.class);
		} catch (RestClientException e) {
			
			e.printStackTrace();
		}
		return "login";
	}
	
	@RequestMapping("/account")
	public String account(Model m) {
		System.out.println(baseUrl+"getRegistration");
		LoginRegistration[] registration=restTemplate.getForObject(baseUrl+"getRegistration", LoginRegistration[].class);
		
		m.addAttribute("reg", registration);
		
		return "account";
	}
	@RequestMapping("/newAccountStatusUpdate")
	public String newAccountStatusUpdate(@RequestParam("userId") String userId, Model m) {
		System.out.println(baseUrl+"getRegistration");
		LoginRegistration[] registration=restTemplate.getForObject(baseUrl+"getRegistration", LoginRegistration[].class);
		
		m.addAttribute("reg", registration);
		String str=restTemplate.exchange(baseUrl+"newAccountStatusUpdate/"+userId,HttpMethod.PUT,new HttpEntity<>(userId),String.class).getBody();
		System.out.println(userId+str);
		m.addAttribute("newAccountStatusUpdate", str);
		return "account";
	}
	
	@RequestMapping("/newVehicleStatusUpdate")
	public String newVehicleStatusUpdate(@RequestParam("vehicleId") String vehicleId, Model m) {
		LoginRegistration[] registration=restTemplate.getForObject(baseUrl+"getRegistration", LoginRegistration[].class);
		
		m.addAttribute("reg", registration);
		System.out.println(vehicleId);
		String str=restTemplate.exchange(baseUrl+"newVehicleStatusUpdate/"+vehicleId,HttpMethod.PUT,new HttpEntity<>(vehicleId),String.class).getBody();
		System.out.println(vehicleId+str);
		m.addAttribute("newVehicleStatusUpdate", str);
		return "VehicleRequest";
	}
	
	@RequestMapping("customer")
	public String getBranchAdmin(Model m) {
		String s = (String) m.getAttribute("str");
		return "customer";
	}

//	@RequestMapping("/customer")
//	public String getcusto(@ModelAttribute("loginreg") LoginRegistration loginRegistration, Model m) {
//	String name = loginRegistration.getUserId();
//	m.addAttribute("obj", name);
//    System.out.println("welcome" + name);
//	return "customer";
//	}
//	
	
	@RequestMapping("/AddCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer customer1, Model m) {
	System.out.println(baseUrl + "addCustomer");
//	DateTimeFormatter d=DateTimeFormatter.ofPattern("dd-MMM-yyyy");

//	LocalDate s =customer1.getDateOfBirth();
	//DateTimeFormatter D=DateTimeFormatter.ofPattern("dd-MM-yyyy");
    //DateTimeFormatter D1=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	System.out.println("customer profile : "+customer1);
	
	Customer cust = restTemplate.postForObject(baseUrl + "addCustomer/", customer1, Customer.class);
	m.addAttribute("cust", cust);
	System.out.println(customer1.toString());
	return "custProfile";
	}
	
	
	
	
	@RequestMapping("/customerProfile")
	public String getcust(Model m ){
		m.getAttribute("CustomerObject1");
		   return "custProfile";
	}
	
	@RequestMapping("/searchVehicle")
	public String searchVehicle(Model m) {
		 Vehicle[] vehicle1 = restTemplate.getForObject(baseUrl + "listofvehicle", Vehicle[].class);
		 m.addAttribute("veh1",vehicle1);
		 String customerId = (String) m.getAttribute("str");
		return "searchVehicle";
	}
	

	@RequestMapping("/selectedVehicle")
	public String selectedVehicle(@RequestParam("vehicleId") String VehicleId, Model m)
	{
		System.out.println(VehicleId);
		Vehicle vehicle=restTemplate.getForObject(baseUrl+"getVehicleById/"+VehicleId, Vehicle.class);

		System.out.println(baseUrl+"getVehicleById/"+VehicleId);
		//BookVehicle vehicle=restTemplate.getForObject(baseUrl+"getBookVehicleById/"+VehicleId, BookVehicle.class);
		//System.out.println("oneVehicle"+vehicle);
		m.addAttribute("oneVehicle", vehicle);
	   return "selectedVehicle";
	}
	
	
	
	@RequestMapping("/BookingStatus")
	public String bookedVehicle(@ModelAttribute("bookVehicle") BookVehicle bookVehicle,Model m)
	{
		m.getAttribute("str");
		System.out.println(bookVehicle.toString());
		BookVehicle bookVehicle2 = restTemplate.postForObject(baseUrl + "bookVehicle/", bookVehicle, BookVehicle.class);
		m.addAttribute("bookVehicle2", bookVehicle2);
		
		BookVehicle[] bookVehicles = restTemplate.getForObject(baseUrl + "getBookVehicle", BookVehicle[].class);
		
		return "bookingStatus";
	}
	@RequestMapping("/AllBookingStatus")
	public String AllBookingStatus(Model m)
	{
		m.getAttribute("str");
		
		BookVehicle[] bookVehicles = restTemplate.getForObject(baseUrl + "getBookVehicle", BookVehicle[].class);
		m.addAttribute("AllBookingStatus", bookVehicles);
		return "bookingStatus";
	}
	
	@RequestMapping("VehicleRequest")
	public String VehicleRequest(Model m ) {
Vehicle[] vehicle1 = restTemplate.getForObject(baseUrl + "listofvehicle", Vehicle[].class);
		
		System.out.println(vehicle1);
		String s = (String) m.getAttribute("str");
		m.addAttribute("allvehicle", vehicle1);
		return "VehicleRequest";
	}
	
	@RequestMapping("BookingRequest")
	public String BookingRequest() {
		return "BookingRequest";
	}
	
}
