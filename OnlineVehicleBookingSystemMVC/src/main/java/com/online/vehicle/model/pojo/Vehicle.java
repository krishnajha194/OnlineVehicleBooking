package com.online.vehicle.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vehicle {
	
	private String loginId;
	//private LoginRegistration loginId;
	private String vehicleId;
	private String manufacturerName;
	private double showroomPrice;
	private String color;
	private String status;

	

}
