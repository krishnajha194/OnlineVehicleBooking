package com.online.vehicle.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

@Entity
@Table(name = "LoginRegistration")
@Check(constraints = "Role='customer' or Role='admin' ")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRegistration {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int id;
	@Id
	@Column(name = "userid" , length = 20, unique=true)
	private String userId;

	@Column(length = 20)
	private String password;

	@Column(length = 15)
	private String role;// (Role should be either Customer or Branch admin constraint)

	@Column(length = 10)
	private String status;// :Pending/Approved/Rejected

}
