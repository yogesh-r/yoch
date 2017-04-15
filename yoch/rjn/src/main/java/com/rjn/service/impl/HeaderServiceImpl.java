 package com.rjn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rjn.dao.CandidateProfileDao;
import com.rjn.dao.core.AccountDao;
import com.rjn.dao.core.PasswordResetTokenDao;
import com.rjn.model.Account;
import com.rjn.model.PasswordResetToken;
import com.rjn.model.CandidateProfile;
import com.rjn.service.HeaderService;
import com.rjn.utils.Constant;

@Service("headerService")
@Transactional 
public class HeaderServiceImpl implements HeaderService  { 

	@Autowired
	private CandidateProfileDao candidateProfiledao;
	
	@Autowired
	private AccountDao accountDao;

	@Autowired
	private PasswordResetTokenDao passwordResetTokenDao;

	@Override
	public void saveCandidateRegistration(CandidateProfile candidateMaster) {
		candidateProfiledao.saveCandidateRegister(candidateMaster);
		Account account = new Account();
		account.setMy_user_name(candidateMaster.getContactEmailId());
		account.setPassword(candidateMaster.getPassword()); 
		account.setReg_id(candidateMaster.getProfileNumber());
		accountDao.save(account, Constant.ROLE_CANDIDATE);
	}

	@Override
	public CandidateProfile getCandidateProfileByEmail(String contactEmailId) {
		return candidateProfiledao.getCandidateProfileByEmail(contactEmailId);
	}

	@Override
	public void saveToken(CandidateProfile candidateProfile, String token) {
		 passwordResetTokenDao.saveToken(candidateProfile, token);
	}

	@Override
	public PasswordResetToken getPasswordResetToken(String profileNumber, String token) {
		return passwordResetTokenDao.getPasswordResetToken(profileNumber, token);
	}

	@Override
	public Account findByRegId(String regId) {
		return accountDao.findByRegId(regId);
	}
}
