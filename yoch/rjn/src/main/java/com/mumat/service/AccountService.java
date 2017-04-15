package com.mumat.service;

import com.mumat.model.Account;

public interface AccountService {
	Account findByUserName(String username);
	void updatePassword(Account account);
}
  