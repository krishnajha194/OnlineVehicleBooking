package com.online.vehicle.model.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable{
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int id;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(referencedColumnName  = "userid",unique = true ,name = "loginId")
//	@JsonBackReference
	@Id
	@Column(length = 25)
	private String loginId;
	
	@Column(length = 20)
	private String customerName;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MMM-dd")
	private String dateOfBirth;
	
	@Column(length = 20)
	private String address;
	
	@Column(length = 14)
	private String phoneNumber;
	
	@Column(length = 20)
	private String mailId;
	
	@Column(length = 20)
	private String occupation;

}
