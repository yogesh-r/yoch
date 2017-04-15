package com.rjn.service;

import com.rjn.model.CandidateProfile;

public interface CandidateService {

	public CandidateProfile getCandidateByProfileNumber(String candidateProfileNumber);
	public void saveCandidateDetails(CandidateProfile candidateProfile);
	public void saveOrUpdateCandidate(CandidateProfile candidateProfile);
}
