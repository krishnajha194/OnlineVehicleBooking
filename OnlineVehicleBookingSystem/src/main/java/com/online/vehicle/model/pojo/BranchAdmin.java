package com.online.vehicle.model.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchAdmin implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true,length = 20)
	private String loginId;

	@Column(length = 15)
	private String branchLocation;

	@Column(length = 15)
	private String address;

	@Column(length = 15)
	private String mailId;

	@Column(length = 15)
	private String phone;

}
