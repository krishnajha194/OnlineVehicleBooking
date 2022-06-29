package com.online.vehicle.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchAdmin{
	
	private String loginId;

	private String branchLocation;

	private String address;

	private String mailId;

	private String phone;

}
