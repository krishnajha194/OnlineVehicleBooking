package com.online.vehicle.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookVehicle {
	@Id
	@Column(length = 25)
	private String vehicleId;
	@Column(length = 25)
	private String manufacturerName;
	@Column(length = 25)
	private String loginId;
	@Column(length = 15)
	private String color;
	@Column(length = 25)
	private String showroomPrice;

}
