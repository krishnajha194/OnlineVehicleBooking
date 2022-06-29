package com.online.vehicle.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.online.vehicle.model.pojo.BranchAdmin;

@Qualifier("BranchAdminRepo")
public interface BranchAdminRepo extends JpaRepository<BranchAdmin, String>{
	
	Optional<BranchAdmin> findById(String loginId);

}
