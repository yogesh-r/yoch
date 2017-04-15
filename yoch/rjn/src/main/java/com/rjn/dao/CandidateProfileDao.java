package com.rjn.dao;

import java.util.List;

import com.rjn.model.CandidateProfile;

public interface CandidateProfileDao {
	void saveCandidateRegister(CandidateProfile candidateProfile ); 
	List<CandidateProfile> getAllCustomerCompany();
	public CandidateProfile getCandidateProfileByprofileNumber(String profileNumber);
	public CandidateProfile getCandidateProfileByEmail(String contactEmailId);
	public void saveOrUpdateCandidate(CandidateProfile candidateProfile);
	
}