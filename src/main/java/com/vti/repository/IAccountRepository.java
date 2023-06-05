package com.vti.repository;

import java.util.List;

import com.vti.entity.Account;

public interface IAccountRepository {

	void addNewAccount(Account ac);
	
	List<Account> getListAccounts();

}
