package com.its.action;

import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

public class ViewProductAction extends ActionSupport
implements ServletRequestAware, ServletResponseAware 
{

	private HttpServletResponse servletResponse;
	private HttpServletRequest servletRequest;
	
	public String execute() throws Exception
	{
		return SUCCESS;
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
