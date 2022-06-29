package com.online.vehicle.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.online.vehicle.model.pojo.BookVehicle;


@Qualifier("bookVehicleRepo")
public interface BookVehicleRepo extends JpaRepository<BookVehicle, String> {
	
	
}
