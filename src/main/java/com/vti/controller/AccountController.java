package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.service.AccountService;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value="/api/v1/accounts")
public class AccountController {
	
private IAccountService acService;
	
	public AccountController() {
		acService = new AccountService();
	}
	
	@PostMapping
	public ResponseEntity<?> addNewAccount(@RequestBody Account ac) {
		System.out.println("role: " + ac.getRole().toString());
		acService.addNewAccount(ac);
		return ResponseEntity.status(HttpStatus.OK).body("Create new Account successfully");
	}
	
	@GetMapping
	public List<AccountDTO> getListAccounts() {
		List<Account> accounts = acService.getListAccounts();
		
		List<AccountDTO> listAcDTO = new ArrayList<AccountDTO>();
		
		for (Account account : accounts) {
			AccountDTO acDTO = new AccountDTO(
					account.getId(),
					account.getUsername()
			);
			listAcDTO.add(acDTO);
		}
		
		return listAcDTO;
		
	}
	
}
