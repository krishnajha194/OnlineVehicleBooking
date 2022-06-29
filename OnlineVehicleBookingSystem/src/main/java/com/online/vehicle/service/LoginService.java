package com.online.vehicle.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.online.vehicle.model.pojo.BookVehicle;
import com.online.vehicle.model.pojo.BranchAdmin;
import com.online.vehicle.model.pojo.Customer;
import com.online.vehicle.model.pojo.LoginRegistration;
import com.online.vehicle.model.pojo.Vehicle;
import com.online.vehicle.repo.BookVehicleRepo;
import com.online.vehicle.repo.BranchAdminRepo;
import com.online.vehicle.repo.CustomerRepo;
import com.online.vehicle.repo.LoginRegistrationRepo;
import com.online.vehicle.repo.VehicleRepo;

@Service
@Qualifier("loginService")
public class LoginService implements ILoginService{
	
	@Autowired
	@Qualifier("login")
	LoginRegistrationRepo registrationRepo;
	
	@Autowired
	@Qualifier("CustomerRepo")
	CustomerRepo customerRepo;
	
	@Autowired
	@Qualifier("BranchAdminRepo")
	BranchAdminRepo adminRepo;
	
	@Autowired
	@Qualifier("VehicleRepo")
	VehicleRepo vehicleRepo; 
	
	
	@Autowired
	@Qualifier("bookVehicleRepo")
	BookVehicleRepo bookVehicleRepo; 
	
	
	@Override
	public LoginRegistration validateLogin(String userId,String password) {
		
		if(userId ==null && password ==null) 
		{
			
			return null;
		}
		List<LoginRegistration> list=registrationRepo.findAll();
		System.out.println(list.toString());
		

		for(LoginRegistration ln: list) {
			
			
			if(ln.getUserId().equalsIgnoreCase(userId) && ln.getPassword().equalsIgnoreCase(password)) {
				
			System.out.println(ln.getRole());
				return ln;
			}
			
		}
		
		return null;
	}

	@Override
	public String doRegistration(LoginRegistration registration) {
		Optional<LoginRegistration> r = registrationRepo.findById(registration.getUserId());
		
		 if (r.isPresent())
			return "user already exist";
		else {
			LoginRegistration registration1= registrationRepo.save(registration);
			if(registration1!=null) {
		return "1 user inserted";
			}
		}
		 
		
		return null;
		}
	

	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public List<BranchAdmin> getAllBranchAdmin() {
		
		return adminRepo.findAll();
	}

	public Optional<BranchAdmin> getBranchAdminById(String loginId) {
		return adminRepo.findById(loginId);
		
	}

	public Vehicle addVehicle(Vehicle vehicle) {
		
		
		return vehicleRepo.save(vehicle);
	}

	public List<Vehicle> allVehicle() {
		
		return vehicleRepo.findAll();
	}

	public List<LoginRegistration> getRegistration() {
		
		return registrationRepo.findAll();
	}

	public String updateUserStatus(String id) {
		Optional<LoginRegistration> u = registrationRepo.findById(id);
		if (u.isPresent())
		{
			LoginRegistration l =u.get();
			l.setStatus("Approved");
			registrationRepo.save(l);
			return "updated";
		}
		else
			return "not available";
		
	}

	public Optional<Customer> getCustomerById(String loginId) {
		return customerRepo.findById(loginId);
		
	}

	public BookVehicle addBookVehicle(BookVehicle book) {
		return bookVehicleRepo.save(book);
	}

	public Optional<BookVehicle> getBookVehicleById(String vehicleId) {
		return bookVehicleRepo.findById(vehicleId);
	}

	public Optional<Vehicle> getVehicleById(String vehicleId) {
		return vehicleRepo.findById(vehicleId);
	}

	public List<BookVehicle> getBookVehicle() {
		return bookVehicleRepo.findAll();
	}
}