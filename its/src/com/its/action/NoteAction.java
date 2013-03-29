package com.its.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.app.context.AppContext;

import com.its.service.DeveloperService;
import com.its.service.NoteService;
import com.its.util.GenericUtils;
import com.opensymphony.xwork2.ActionSupport;

public class NoteAction extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
	private Integer oid;
	private Integer issue_No;
	private String note;
	
	private HttpServletRequest servletRequest;
	private HttpServletResponse servletResponse;
	
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
	
	public String getNote()
	{
		return note;
	}
	public void setNote(String note)
	{
		this.note = note;
	}
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
	
	 public boolean hasNote()
	  {
		  return GenericUtils.isNotNullOrEmpty(getNote()); 
	  }
	public NoteService getNoteService()
	{
		return (NoteService)AppContext.getApplicationContext().getBean("noteService");
	}
}
