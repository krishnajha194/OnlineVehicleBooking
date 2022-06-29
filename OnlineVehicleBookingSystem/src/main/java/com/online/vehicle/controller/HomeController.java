package com.online.vehicle.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.vehicle.model.pojo.BookVehicle;
import com.online.vehicle.model.pojo.BranchAdmin;
import com.online.vehicle.model.pojo.Customer;
import com.online.vehicle.model.pojo.LoginRegistration;
import com.online.vehicle.model.pojo.Vehicle;
import com.online.vehicle.service.HomeService;
import com.online.vehicle.service.LoginService;

@RestController
@CrossOrigin
public class HomeController {

	@Autowired
	@Qualifier("loginService")
	LoginService service;

	@Autowired
	@Qualifier("homeService")
	HomeService homeService;

	@GetMapping("/doLogin/{userId}/{password}")
	public LoginRegistration login(@PathVariable("userId") String userId, @PathVariable("password") String Password) {
		LoginRegistration l;
		l=service.validateLogin(userId, Password);
		return l;
	}

	@PostMapping("/doRegistration")
	public String Registration(@RequestBody LoginRegistration registration) {
		return service.doRegistration(registration);
	}
	@GetMapping("/getRegistration")
	public List<LoginRegistration> getRegistration() {
		return service.getRegistration();
	}

	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		System.out.println(customer);
	   // LocalDate L2=LocalDate.parse(customer.getDateOfBirth(),D);
	    
		return service.addCustomer(customer);
	}

	@PostMapping("/addBranch")
	public BranchAdmin addBranchAdmin(@RequestBody BranchAdmin admin) {
		return homeService.addBranchAdmin(admin);
	}
	@GetMapping("/getBranchAdmin")
	public List<BranchAdmin> listOfBranchAdmin(){
		return service.getAllBranchAdmin();
	}
	@GetMapping("/getBranchAdminById/{loginId}")
	public Optional<BranchAdmin> getBranchAdminById(@PathVariable("loginId")String loginId){
		return 	service.getBranchAdminById(loginId);
	}
	@PostMapping("/addVehicle")
	public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
		return service.addVehicle(vehicle);
	}

	@GetMapping("/listofvehicle")
	public List<Vehicle> listofvehicle(){
		return service.allVehicle();
	}
	@PutMapping("/newAccountStatusUpdate/{userId}")
	public String newAccountStatus(@PathVariable("userId") String userId)
	{
		String st = service.updateUserStatus(userId);
		System.out.println(st);
		return st;
	}
	@GetMapping("/getCustomernById/{loginId}")
	public Optional<Customer> getCustomerById(@PathVariable("loginId")String loginId){
		return 	service.getCustomerById(loginId);
	}
	
	@GetMapping("/getVehicleById/{vehicleId}")
	public Optional<Vehicle> getVehicleById(@PathVariable("vehicleId")String vehicleId){
		return 	service.getVehicleById(vehicleId);
	}
	
	@PostMapping("/bookVehicle")
	public BookVehicle addVehicles(@RequestBody BookVehicle  book ) {
		System.out.println(book);
		return service.addBookVehicle(book);
	}
	@GetMapping("/getBookVehicleById/{vehicleId}")
	public Optional<BookVehicle> getBookVehicleById(@PathVariable("vehicleId")String vehicleId){
		return 	service.getBookVehicleById(vehicleId);
	}
	@GetMapping("/getBookVehicle")
	public List<BookVehicle> getBookVehicle(){
		return 	service.getBookVehicle();
	}
	
}
