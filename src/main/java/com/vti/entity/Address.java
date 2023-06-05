package com.vti.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="street", length = 150, nullable = false)
	private String street;
	
	@Column(name="city", length = 50, nullable = false)
	private String city;
	
//	@OneToOne(mappedBy="address")
//	private Account account;
	
	@OneToMany(mappedBy="address")
	private List<Account> accounts;
	
	public Address() {
		
	}
	
//	public Address(String street, String city, Account account) {
//		super();
//		this.street = street;
//		this.city = city;
//		this.account = account;
//	}
	
	public Address(String street, String city, List<Account> accounts) {
		super();
		this.street = street;
		this.city = city;
		this.accounts = accounts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

//	public Account getAccount() {
//		return account;
//	}
//
//	public void setAccount(Account account) {
//		this.account = account;
//	}
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
		
	@Override
	public String toString() {
		return "[id=" + id + "; street=" + street + "; city=" + city + "]";
	}

}
