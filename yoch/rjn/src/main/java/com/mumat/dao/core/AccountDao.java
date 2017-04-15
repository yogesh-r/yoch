package com.mumat.dao.core;

import com.mumat.model.Account;

public interface AccountDao {
	public Account findByUserName(String username);
	public void save(Account account, String role);
	public Account getLoggedInUser();
	void updateAccount(Account account);
	public Account findByRegId(String regId);
}
