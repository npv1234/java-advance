package com.vti.service;

import com.vti.entity.Address;
import com.vti.repository.AddressRepository;
import com.vti.repository.IAddressRepository;

public class AddressService implements IAddressService{
	private IAddressRepository addRepository;
	
	public AddressService() {
		addRepository = new AddressRepository();
	}
	
	public void addNewAddress(Address address) {
		addRepository.addNewAddress(address);
	}

}
