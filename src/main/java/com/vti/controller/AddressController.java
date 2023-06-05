package com.vti.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Address;
import com.vti.service.AddressService;
import com.vti.service.IAddressService;

@RestController
@RequestMapping(value="/api/v1/addresses")
public class AddressController {
	private IAddressService addService;
	
	public AddressController() {
		addService = new AddressService();
	}
	
	@PostMapping
	public ResponseEntity<?> addNewAddress(@RequestBody Address address) {
		System.out.println(address);
		addService.addNewAddress(address);
		return ResponseEntity.status(HttpStatus.OK).body("Create new Address successfully");
	}
}

