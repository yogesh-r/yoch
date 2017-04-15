package com.mumat.dao.core;

import com.mumat.model.PasswordResetToken;
import com.mumat.model.CandidateProfile;

public interface PasswordResetTokenDao {
	void saveToken(CandidateProfile candidateProfile, String token); 
	PasswordResetToken getPasswordResetToken(String profileNumber, String token);
}
