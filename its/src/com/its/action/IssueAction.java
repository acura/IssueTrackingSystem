package com.its.action;
<<<<<<< HEAD
//28 feb
=======
//sss
>>>>>>> c425fb3c0084799144be7138930bfc807b6105b1
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.app.context.AppContext;
import com.its.service.AccountService;
import com.its.service.IssueService;
import com.its.util.GenericUtils;
import com.opensymphony.xwork2.ActionSupport;

public class IssueAction extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
	
	private Integer oid;
	private String developer;
	private String issueNo;
	private String project;
    private String issueDate;
    private Double hours;
    private String comment;
    private String activity;
    private Date   createdDate;
    private Date   lastUpdatedDate;
    
    public Date getCreatedDate() 
    {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) 
	{
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() 
	{
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) 
	{
		this.lastUpdatedDate = lastUpdatedDate;
	}

	private HttpServletRequest servletRequest;
	private HttpServletResponse servletResponse;
	
	public IssueService getIssueService()
	{
		return (IssueService)AppContext.getApplicationContext().getBean("issueService");
	}
    
	public Integer getOid()
     {
		return oid;
	}

	public void setOid(Integer oid)
	{
		this.oid = oid;
	}

	public String getProject() 
	{
		return project;
	}

	public String getDeveloper() 
	{
		return developer;
	}

	public void setDeveloper(String developer) 
	{
		this.developer = developer;
	}

	public String getIssueDate() 
	{
		return issueDate;
	}

	public void setIssueDate(String issueDate) 
	{
		this.issueDate = issueDate;
	}

	public Double getHours() 
	{
		return hours;
	}

	public void setHours(Double hours) 
	{
		this.hours = hours;
	}

	public void setProject(String project) 
	{
		this.project = project;
	}

	public String getIssueNo() 
	{
		
		return issueNo;
	}

	public void setIssueNo(String issueNo) 
	{
		//String sb =new String("Acura-");
		//s.append("Acura-");
		this.issueNo =issueNo;
	}

	public String getComment() 
	{
		return comment;
	}

	public void setComment(String comment) 
	{
		this.comment = comment;
	}

	public String getActivity() 
	{
		return activity;
	}

	public void setActivity(String activity) 
	{
		this.activity = activity;
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

   public boolean hasOid()
   {
	return GenericUtils.isNotNull(getOid()); 
   }	 
   
   public boolean hasDeveloper()
   {
	  return GenericUtils.isNotNullOrEmpty(getDeveloper()); 
   }
   
   public boolean hasIssueNo()
   {
   return GenericUtils.isNullOrEmpty(getIssueNo());
   }
    
   public boolean hasProject()
   {
	return GenericUtils.isNullOrEmpty(getProject());   
   }

  public boolean hasIssueDate()
  {
	return GenericUtils.isNotNullOrEmpty(getIssueDate());  
  }
  
  public boolean hasHours()
  {
	  return GenericUtils.isNotNull(getHours()); 
  }
   
  public boolean hasActivity()
  {
	return GenericUtils.isNullOrEmpty(getActivity()); 
  }
  
}
