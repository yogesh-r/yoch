package com.rjn.dao;

import java.util.List;

import com.rjn.model.Branch.BranchProfile;

public interface BranchProfileDao {
	
	BranchProfile getBranchByUniqueId(String uniqueId);
	List<BranchProfile> getBranchByVendor(String vendorId);
	List<BranchProfile> getLocationByCity(String cityId, String vendorId);
	List<BranchProfile> getBranchList(String cityId, String vendorId, String location);
	void updateBranch(BranchProfile branchMasterDetails);
	BranchProfile getBranchData(int branchId);
	List<BranchProfile> getBranchDetails();
	BranchProfile getBranchDetails(String uniqueID);
	void saveBranch(BranchProfile branchMasterDetails);
	
}


