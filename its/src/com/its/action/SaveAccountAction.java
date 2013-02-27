package com.its.action;

import com.its.domain.Account;
import com.its.domain.PasswordGenerator;
import com.its.domain.PortalConstant;
import com.its.util.DateUtils;
import com.util.mail.EmailUtils;
import java.util.Date;

public class SaveAccountAction extends AccountAction
{
	public String execute() throws Exception
	{
		Integer oid = savePortalAccount();
		System.out.println("Oid : "+oid);
		return SUCCESS;
	}
	
	private Integer savePortalAccount() 
	throws Exception
	{
		Account account = populatePortalAccount();
		return getAccountService().saveAccount(account);
	}
	
	private Account populatePortalAccount()
	{
		Account accountObject = new Account();
		
		accountObject.setOid(getOid());
		if (getOid() == null)
		{
			accountObject.setAccountId(getEmailId());
			accountObject.setPassword(PasswordGenerator.getNewPassword());
		}
		else
		{
			accountObject.setAccountId(getAccountId());
			accountObject.setPassword(getPassword());
		}
			
		accountObject.setAccountType(getAccountType());
		accountObject.setOwnerName(getOwnerName());
		accountObject.setTitle(getTitle());
		accountObject.setAddress(getAddress());
		accountObject.setPhoneNumber(getPhoneNumber());
		accountObject.setMobileNumber(getMobileNumber());
		accountObject.setEmailId(getEmailId());
		accountObject.setAlterNateEmailId(getAlterNateEmailId());
		accountObject.setSubcriptionStartDate(DateUtils.getStringAsDate(getSubcriptionStartDate()));
		accountObject.setSubscriptionEndDate(DateUtils.getStringAsDate(getSubscriptionEndDate()));
		accountObject.setAmountPaid(getAmountPaid());
		
		if (getServletRequest().getSession() != null &&
			getServletRequest().getSession().getAttribute(PortalConstant.ACCOUNT_ID) != null)
		{
			accountObject.setCreatedBy(getServletRequest().getSession().getAttribute(PortalConstant.ACCOUNT_ID).toString());
			accountObject.setLastUpdatedBy(getServletRequest().getSession().getAttribute(PortalConstant.ACCOUNT_ID).toString());
		}
		
		return accountObject;
	}
	
	private String getUniqueAccountId(Integer latestSrNoForAccountId, String ownerName, String accountType)
	{
		String	userId = (ownerName.substring(0,1).toUpperCase() +
				accountType.substring(0, 1).toUpperCase()).
						  concat(latestSrNoForAccountId.toString()); 
		return userId;
	}
	
	public void validate()
	{
		if (hasOid())
		{
			if (!hasAccountId())
			{
				addFieldError("accountId", "Account Id is Required");
			}
			
			if (!hasPassword())
			{
				addFieldError("password", "Password is Required");
			}
		}
		
		if (!hasAccountType())
		{
			addFieldError("accountType", "Account Type is Required");
		}
		
		if (!hasOwnerName())
		{
			addFieldError("ownerName", "Owner Name is Required");
		}

		if (!hasEmailId())
		{
			addFieldError("emailId", "Email Id is Required");
		}
		/*else if (EmailUtils.validateEmailId(getEmailId()))
		{
			if (!hasOid())
			{
				String recipients[] = {getEmailId()};
				String from = "amol.acura@gmail.com";
				String subject = "Checking Email Id exist";
				String bodyMessage = "Testing Email ID";
				
				try 
				{
					EmailUtils.sendSSLMessage(recipients, subject, bodyMessage, from, "");
				}
				catch (Exception e) 
				{
					addFieldError("emailId", "Email Id does not exist");
				}
			}
		}*/
		else
		{
			addFieldError("emailId", "Invalid Email Id");
		}
		
	/*	if (hasEmailId() && 
			hasAlterNateEmailId() && 
			! EmailUtils.validateEmailId(getAlterNateEmailId()))
		{
			addFieldError("alterNateEmailId", "Invalid Email Id");
		}*/
		
		if (!hasSubcriptionStartDate())
		{
			addFieldError("subcriptionStartDate", "Subcription Start Date is Required");
		}
		else if (DateUtils.getStringAsDate(getSubcriptionStartDate()).after(new Date()))
		{
			addFieldError("subcriptionStartDate", "Subcription Start Date should not be in future");
		}
		
		if (!hasSubscriptionEndDate())
		{
			addFieldError("subcriptionEndDate", "Subscription End Date is Required");
		}
		else if (DateUtils.getStringAsDate(getSubscriptionEndDate()).after(new Date()))
		{
			addFieldError("subcriptionEndDate", "Subcription End Date should not be in future");
		}
		
	}
}
