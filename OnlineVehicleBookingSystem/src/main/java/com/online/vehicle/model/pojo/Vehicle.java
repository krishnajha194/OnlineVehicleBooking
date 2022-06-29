package com.online.vehicle.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Check(constraints = "status='Pending' or status='Approved' or status='Rejected' ")
public class Vehicle {
	@Id
	@Column(length = 20)
	private String vehicleId; 
	@Column(length = 20)
	private String manufacturerName; 
	@Column(length = 20)
	private double showroomPrice;
	@Column(length = 20)
	private String color ;
	@Column(length = 10)
	private String status;
	@Column(length = 20)
	private String loginId;

}
