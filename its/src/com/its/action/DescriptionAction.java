package com.its.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.app.context.AppContext;
import com.its.service.DescriptionService;
import com.its.service.DeveloperService;
import com.opensymphony.xwork2.ActionSupport;

public class DescriptionAction extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
	private Integer oid;
	private Integer issue_No;
	private String description;
	public Integer getOid() 
	{
		return oid;
	}
	public void setOid(Integer oid)
	{
		this.oid = oid;
	}
	public Integer getIssue_No()
	{
		return issue_No;
	}
	public void setIssue_No(Integer issueNo)
	{
		issue_No = issueNo;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	private HttpServletRequest servletRequest;
	private HttpServletResponse servletResponse;
	public HttpServletRequest getServletRequest()
	{
		return servletRequest;
	}
	public void setServletRequest(HttpServletRequest servletRequest) 
	{
		this.servletRequest = servletRequest;
	}
	public HttpServletResponse getServletResponse()
	{
		return servletResponse;
	}
	public void setServletResponse(HttpServletResponse servletResponse)
	{
		this.servletResponse = servletResponse;
	}
	
	public DescriptionService getDescriptionService()
	{
		return (DescriptionService)AppContext.getApplicationContext().getBean("descriptionService");
	}
}
