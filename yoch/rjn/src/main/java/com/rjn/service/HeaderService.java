package com.rjn.service;

import com.rjn.model.Account;
import com.rjn.model.PasswordResetToken;
import com.rjn.model.CandidateProfile;

public interface HeaderService { 

	void saveCandidateRegistration(CandidateProfile candidateProfile);
	public CandidateProfile getCandidateProfileByEmail(String contactEmailId);
	void saveToken(CandidateProfile CandidateProfile, String token);
	PasswordResetToken getPasswordResetToken(String profileNumber, String token);
	Account findByRegId(String regId);
}