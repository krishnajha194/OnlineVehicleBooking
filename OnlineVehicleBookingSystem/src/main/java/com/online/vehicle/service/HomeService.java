package com.online.vehicle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.online.vehicle.model.pojo.BranchAdmin;
import com.online.vehicle.repo.BranchAdminRepo;

@Service
@Qualifier("homeService")
public class HomeService {
	
	@Autowired
	@Qualifier("BranchAdminRepo")
	BranchAdminRepo branchAdminRepo;
	
	public BranchAdmin addBranchAdmin(BranchAdmin branchAdmin){
		return branchAdminRepo.save(branchAdmin);
	}
	
	
	

}
