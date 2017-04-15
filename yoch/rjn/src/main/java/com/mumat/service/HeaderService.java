package com.mumat.service;

import com.mumat.model.Account;
import com.mumat.model.PasswordResetToken;
import com.mumat.model.CandidateProfile;

public interface HeaderService { 

	void saveCandidateRegistration(CandidateProfile candidateProfile);
	public CandidateProfile getCandidateProfileByEmail(String contactEmailId);
	void saveToken(CandidateProfile CandidateProfile, String token);
	PasswordResetToken getPasswordResetToken(String profileNumber, String token);
	Account findByRegId(String regId);
}