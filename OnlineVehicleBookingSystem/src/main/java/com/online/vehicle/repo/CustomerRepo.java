package com.online.vehicle.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.online.vehicle.model.pojo.Customer;

@Qualifier("CustomerRepo")
public interface CustomerRepo extends JpaRepository<Customer, String>{
}
