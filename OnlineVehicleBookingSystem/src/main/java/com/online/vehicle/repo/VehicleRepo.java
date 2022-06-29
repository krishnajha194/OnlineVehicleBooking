package com.online.vehicle.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.online.vehicle.model.pojo.Vehicle;

@Qualifier("VehicleRepo")
public interface VehicleRepo extends JpaRepository<Vehicle, String>{

}
