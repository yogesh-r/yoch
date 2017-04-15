package com.rjn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjn.dao.CandidateProfileDao;
import com.rjn.model.CandidateProfile;
import com.rjn.service.CandidateService;

@Service("candidateService")
@Transactional 
public class CandidateServiceImpl implements CandidateService{

	@Autowired
	CandidateProfileDao candidateProfileDao;
	
	@Override
	public CandidateProfile getCandidateByProfileNumber(String profileNumber) {
		return candidateProfileDao.getCandidateProfileByprofileNumber(profileNumber);
	}
	
	@Override
	public void saveCandidateDetails(CandidateProfile candidateProfile ) {
		 candidateProfileDao.saveCandidateRegister(candidateProfile);
	}
	
	@Override
	public void saveOrUpdateCandidate(CandidateProfile candidateProfile) {
		candidateProfileDao.saveOrUpdateCandidate(candidateProfile);
		
	}
}
