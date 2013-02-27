package com.its.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.its.domain.Account;
import com.its.exception.DAOException;
import com.its.util.DateUtils;
import com.its.util.GenericUtils;

import java.util.Collection;
import java.util.Date;
import java.util.List;
@Transactional(propagation=Propagation.MANDATORY)
public class AccountDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public Integer saveAccount(Account account)
	throws DAOException
	{
		Integer txnOid = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			
			if (GenericUtils.isNotNull(account.getOid()))
			{
				Account accountDB = (Account)session.get(Account.class, account.getOid());
				
				accountDB.setAccountId(account.getAccountId());
				accountDB.setPassword(account.getPassword());
				accountDB.setOwnerName(account.getOwnerName());
				accountDB.setAccountType(account.getAccountType());
				accountDB.setTitle(account.getTitle());
				accountDB.setAddress(account.getAddress());
				accountDB.setPhoneNumber(account.getPhoneNumber());
				accountDB.setMobileNumber(account.getMobileNumber());
				accountDB.setEmailId(account.getEmailId());
				accountDB.setAlterNateEmailId(account.getAlterNateEmailId());
				accountDB.setSubcriptionStartDate(account.getSubcriptionStartDate());
				accountDB.setSubscriptionEndDate(account.getSubscriptionEndDate());
				accountDB.setAmountPaid(account.getAmountPaid());
				
				accountDB.setLastUpdatedBy(account.getLastUpdatedBy());
				accountDB.setLastUpdatedDate(new Date());
				
				session.update(accountDB);
			}
			else
			{
				account.setCreatedDate(new Date());
				account.setLastUpdatedDate(null);
				txnOid = (Integer)session.save(account);
			}
			session.flush();
			
			return txnOid;
		}
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
	public Collection<Account> getAllPortalAccount()
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from Account account " +
										"order by account.accountId");
			List<Account> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list : null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
	public Account getAccountByAccountId(String accountId)
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from Account account " +
										"where account.accountId = '" + accountId + "'");
			List<Account> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list.get(0): null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
	public Account checkValidUser(String accountId, String password)
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			
			Query fromClauseQuery = 
					session.createQuery("from Account account " +
										"where account.accountId = '" + accountId +"' " +
										"and account.password = '"+ password +"' ");
			
			List<Account> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list.get(0) : null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
	public Integer getLatestSrNoForAccountId()
	throws DAOException
	{
		Integer serialNumber = 1001;
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("select max(account.oid) " +
										"from Account account ");
			List<Integer> list = fromClauseQuery.list();
			if (list != null)
			{
				serialNumber = list.get(0) + 1;
			}

			return serialNumber;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
}
