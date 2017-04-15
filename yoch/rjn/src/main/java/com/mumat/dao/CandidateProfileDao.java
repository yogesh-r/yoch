package com.mumat.dao;

import java.util.List;

import com.mumat.model.CandidateProfile;

public interface CandidateProfileDao {
	void saveCandidateRegister(CandidateProfile candidateProfile ); 
	List<CandidateProfile> getAllCustomerCompany();
	public CandidateProfile getCandidateProfileByprofileNumber(String profileNumber);
	public CandidateProfile getCandidateProfileByEmail(String contactEmailId);
	public void saveOrUpdateCandidate(CandidateProfile candidateProfile);
	
}