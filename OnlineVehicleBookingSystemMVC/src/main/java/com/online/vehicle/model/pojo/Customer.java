package com.online.vehicle.model.pojo;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private String loginId;
	
	private String customerName;
	
	private String dateOfBirth;
	
	private String address;
	
	private String phoneNumber;
	
	private String mailId;
	
	private String occupation;

}
