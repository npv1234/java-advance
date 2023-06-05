package com.vti.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;

public class AccountRepository implements IAccountRepository {
	
private HibernateUtils hibernateUtils;
	
	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	public void addNewAccount(Account ac) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = hibernateUtils.openSession();
			
			transaction = session.getTransaction();
			transaction.begin();
			
			session.save(ac);
			
			transaction.commit();
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<Account> getListAccounts() {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			Query<Account> query = session.createQuery("FROM Account");
			return query.list();
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

}
