package com.mumat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mumat.dao.core.AccountDao;
import com.mumat.model.Account;
import com.mumat.service.AccountService;

@Service("accounteService")
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao dao;
	
	public Account findByUserName(String username) {
		return dao.findByUserName(username);
	}
	
	@Override
	public void updatePassword(Account account) {
		dao.updateAccount(account);
	}
} 