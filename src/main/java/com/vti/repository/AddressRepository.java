package com.vti.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vti.entity.Address;
import com.vti.utils.HibernateUtils;

public class AddressRepository implements IAddressRepository{
	private HibernateUtils hibernateUtils;
	
	public AddressRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	public void addNewAddress(Address address) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = hibernateUtils.openSession();
			
			transaction = session.getTransaction();
			transaction.begin();
			
			session.save(address);
			
			transaction.commit();
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
