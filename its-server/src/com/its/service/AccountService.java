package com.its.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.its.dao.AccountDAO;
import com.its.domain.Account;
import com.its.exception.DAOException;

import java.util.Collection;

public class AccountService
{
	@Autowired
	private AccountDAO accountDAO;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer saveAccount(Account account)
	throws DAOException
	{
		return accountDAO.saveAccount(account);
	}
	
	@Transactional(readOnly=true)
	public Collection<Account> getAllPortalAccount()
	throws DAOException
	{
		return accountDAO.getAllPortalAccount();
	}
	
	@Transactional(readOnly=true)
	public Account getAccountByAccountId(String accountId)
	throws DAOException
	{
		return accountDAO.getAccountByAccountId(accountId);
	}
	@Transactional(readOnly=true)
	public Account checkValidUser(String accountId, String password)
	throws DAOException
	{
		return accountDAO.checkValidUser(accountId, password);
	}
	
	@Transactional(readOnly=true)
	public Integer getLatestSrNoForAccountId()
	throws DAOException
	{
		return accountDAO.getLatestSrNoForAccountId();
	}
}
