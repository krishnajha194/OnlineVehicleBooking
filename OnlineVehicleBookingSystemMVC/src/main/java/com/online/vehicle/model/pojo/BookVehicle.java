package com.online.vehicle.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookVehicle {
	private String loginId;
	private String manufacturerName;
	private String vehicleId;
	private String color;
	private String showroomPrice;

}
