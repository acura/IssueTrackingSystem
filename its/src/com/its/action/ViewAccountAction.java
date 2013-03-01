package com.its.action;

import com.its.domain.Account;

import java.util.ArrayList;
import java.util.Collection;

public class ViewAccountAction extends AccountAction 
{
	public String execute() throws Exception
	{
		Collection<Account> accountList = getAccountService().getAllPortalAccount();
		
		if (accountList == null)
		{
			accountList = new ArrayList<Account>();
		}
		
		getServletRequest().setAttribute("accountList", accountList);
		return SUCCESS;
	}
}
