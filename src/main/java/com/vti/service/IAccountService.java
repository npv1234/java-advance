package com.vti.service;

import java.util.List;

import com.vti.entity.Account;

public interface IAccountService {

	void addNewAccount(Account ac);
	
	List<Account> getListAccounts();

}
