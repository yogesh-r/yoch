package com.mumat.dao.core.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.mumat.dao.core.AbstractDao;
import com.mumat.dao.core.PasswordResetTokenDao;
import com.mumat.model.PasswordResetToken;
import com.mumat.model.CandidateProfile;

@Repository("passwordResetTokenDao")
public class PasswordResetTokenDaoImpl extends AbstractDao<Integer, PasswordResetToken> implements PasswordResetTokenDao {

	@Override
	public void saveToken(CandidateProfile candidateProfile, String token) {
		PasswordResetToken passwordResetToken = new PasswordResetToken();
		passwordResetToken.setToken(token);
		passwordResetToken.setProfileNumber(candidateProfile.getProfileNumber());
		
		persist(passwordResetToken);
	}

	@Override
	public PasswordResetToken getPasswordResetToken(String profileNumber, String token) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("profileNumber", profileNumber));
		criteria.add(Restrictions.eq("token", token));
		return (PasswordResetToken) criteria.uniqueResult();
	}
}
