package com.rjn.dao.core;

import com.rjn.model.PasswordResetToken;
import com.rjn.model.CandidateProfile;

public interface PasswordResetTokenDao {
	void saveToken(CandidateProfile candidateProfile, String token); 
	PasswordResetToken getPasswordResetToken(String profileNumber, String token);
}
