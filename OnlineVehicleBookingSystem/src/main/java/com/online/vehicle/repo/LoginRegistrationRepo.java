package com.online.vehicle.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import com.online.vehicle.model.pojo.LoginRegistration;

@Qualifier("login")
public interface LoginRegistrationRepo extends JpaRepository<LoginRegistration, String> {
	//Optional<LoginRegistration> findByUserId(String userId);
	//Optional<LoginRegistration> findByPassword(String password);
	
}
