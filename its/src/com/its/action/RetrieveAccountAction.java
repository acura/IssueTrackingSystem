package com.its.action;

import com.its.domain.Account;

import com.its.util.DateUtils;
import com.its.util.GenericUtils;

public class RetrieveAccountAction extends AccountAction
{
	public String execute() throws Exception
	{
		
		String accountId = getServletRequest().getParameter("accountId");
		
		if (GenericUtils.isNotNullOrEmpty(accountId))
		{
			Account account = getAccountService().getAccountByAccountId(accountId);
			
			setOid(account.getOid());
			setAccountId(account.getAccountId());
			setPassword(account.getPassword());
			setOwnerName(account.getOwnerName());
			setAccountType(account.getAccountType());
			setTitle(account.getTitle());
			setAddress(account.getAddress());
			setPhoneNumber(account.getPhoneNumber());
			setMobileNumber(account.getMobileNumber());
			setEmailId(account.getEmailId());
			setAlterNateEmailId(account.getAlterNateEmailId());
			setSubcriptionStartDate(DateUtils.getDateAsString(account.getSubcriptionStartDate()));
			setSubscriptionEndDate(DateUtils.getDateAsString(account.getSubscriptionEndDate()));
			setAmountPaid(account.getAmountPaid());
			setCreatedBy(account.getCreatedBy());
			setCreatedDate(DateUtils.getDateAsString(account.getCreatedDate()));
			setLastUpdatedBy(account.getLastUpdatedBy());
			setLastUpdatedDate(DateUtils.getDateAsString(account.getLastUpdatedDate()));
			
		}
		
		return SUCCESS;
	}
}
