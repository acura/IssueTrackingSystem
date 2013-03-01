
package com.its.action;

import com.app.context.AppContext;
import com.its.service.AccountService;
import com.its.util.GenericUtils;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

public class AccountAction extends ActionSupport
implements ServletRequestAware, ServletResponseAware 
{
	private Integer oid;
	private String accountId;
	private String password;
	private String ownerName;
	private String accountType;
	private String title;
	private String address;
	private String phoneNumber;
	private String mobileNumber;
	private String emailId;
	private String alterNateEmailId;
	private String subcriptionStartDate;
	private String subscriptionEndDate;
	private Double amountPaid;
	private String createdBy;
	private String createdDate;
	private String lastUpdatedBy;
	private String lastUpdatedDate;
	
	private HttpServletResponse servletResponse;
	private HttpServletRequest servletRequest;
	
	public AccountService getAccountService()
	{
		return (AccountService)AppContext.getApplicationContext().getBean("accountService");
	}
	
	public Integer getOid()
	{
		return oid;
	}
	public void setOid(Integer oid)
	{
		this.oid = oid;
	}
	public String getAccountId()
	{
		return accountId;
	}
	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getOwnerName()
	{
		return ownerName;
	}
	public void setOwnerName(String ownerName)
	{
		this.ownerName = ownerName;
	}
	public String getAccountType()
	{
		return accountType;
	}
	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public String getMobileNumber()
	{
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber)
	{
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId()
	{
		return emailId;
	}
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}
	public String getAlterNateEmailId()
	{
		return alterNateEmailId;
	}
	public void setAlterNateEmailId(String alterNateEmailId)
	{
		this.alterNateEmailId = alterNateEmailId;
	}
	public String getSubcriptionStartDate()
	{
		return subcriptionStartDate;
	}
	public void setSubcriptionStartDate(String subcriptionStartDate)
	{
		this.subcriptionStartDate = subcriptionStartDate;
	}
	public String getSubscriptionEndDate()
	{
		return subscriptionEndDate;
	}
	public void setSubscriptionEndDate(String subscriptionEndDate)
	{
		this.subscriptionEndDate = subscriptionEndDate;
	}
	public Double getAmountPaid()
	{
		return amountPaid;
	}
	public void setAmountPaid(Double amountPaid)
	{
		this.amountPaid = amountPaid;
	}
	public String getCreatedBy()
	{
		return createdBy;
	}
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}
	public String getCreatedDate()
	{
		return createdDate;
	}
	public void setCreatedDate(String createdDate)
	{
		this.createdDate = createdDate;
	}
	public String getLastUpdatedBy()
	{
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy)
	{
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public String getLastUpdatedDate()
	{
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(String lastUpdatedDate)
	{
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public boolean hasOid()
	{
		return GenericUtils.isNotNull(getOid());
	}
	public boolean hasAccountId()
	{
		return GenericUtils.isNotNullOrEmpty(getAccountId());
	}
	
	public boolean hasPassword()
	{
		return GenericUtils.isNotNullOrEmpty(getPassword());
	}
	
	public boolean hasAccountType()
	{
		return GenericUtils.isNotNullOrEmpty(getAccountType());
	}
	
	public boolean hasOwnerName()
	{
		return GenericUtils.isNotNullOrEmpty(getOwnerName());
	}
	
	public boolean hasEmailId()
	{
		return GenericUtils.isNotNullOrEmpty(getEmailId());
	}
	
	public boolean hasAlterNateEmailId()
	{
		return GenericUtils.isNotNullOrEmpty(getAlterNateEmailId());
	}
	
	public boolean hasSubcriptionStartDate()
	{
		return GenericUtils.isNotNullOrEmpty(getSubcriptionStartDate());
	}
	
	public boolean hasSubscriptionEndDate()
	{
		return GenericUtils.isNotNullOrEmpty(getSubscriptionEndDate());
	}

	public HttpServletResponse getServletResponse() 
	{
		return servletResponse;
	}

	public void setServletResponse(HttpServletResponse servletResponse) 
	{
		this.servletResponse = servletResponse;
	}

	public HttpServletRequest getServletRequest() 
	{
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) 
	{
		this.servletRequest = servletRequest;
	}
	
	
}
