package com.vti.service;

import java.util.List;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;
import com.vti.repository.IAccountRepository;

public class AccountService implements IAccountService{
	private IAccountRepository acRepository;
	
	public AccountService() {
		acRepository = new AccountRepository();
	}
	
	public void addNewAccount(Account ac) {
		acRepository.addNewAccount(ac);
	}
	
	public List<Account> getListAccounts() {
		return acRepository.getListAccounts();
	}


}
