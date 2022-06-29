package com.online.vehicle.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginRegistration {
	private String userId;

	private String password;

	private String role;// (Role should be either Customer or Branch admin constraint)

	private String status;// :Pending/Approved/Rejected

}
