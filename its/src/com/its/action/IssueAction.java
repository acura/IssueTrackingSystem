package com.its.action;


import com.app.context.AppContext;
import com.its.domain.DropdownOption;
import com.its.service.IssueService;
import com.its.service.NewIssueService;
import com.its.service.ProjectService;
import com.its.util.GenericUtils;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

public class IssueAction extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
	
	private Integer oid;
	private String developer;
	private Integer issueNumber;
	private String project;
    private String issueDate;
    private Double hours;
    private String comment;
    private String activity;
    private Date   createdDate;
    private Date   lastUpdatedDate;
    
    private HttpServletRequest servletRequest;
	private HttpServletResponse servletResponse;
	
	 
    private List<DropdownOption> projectList = new ArrayList<DropdownOption>();
    private List<DropdownOption> developerList = new ArrayList<DropdownOption>();
    
    public ProjectService getProjectService()
	{
		return (ProjectService)AppContext.getApplicationContext().getBean("projectService");
	}
    
	public List<DropdownOption> getProjectList() 
	{
		return projectList;
	}
	
	public void setProjectList(List<DropdownOption> projectList) 
	{
		this.projectList = projectList;
	}
	
	public List<DropdownOption> getDeveloperList() 
	{
		return developerList;
	}
	
	public void setDeveloperList(List<DropdownOption> developerList) 
	{
		this.developerList = developerList;
	}
	
	public IssueService getIssueService()
	{
		return (IssueService)AppContext.getApplicationContext().getBean("issueService");
	}
	
	public NewIssueService getNewIssueService()
	{
		return (NewIssueService)AppContext.getApplicationContext().getBean("newIssueService");
	}
	
	public Integer getOid()
	{
		return oid;
	}

	public void setOid(Integer oid)
	{
		this.oid = oid;
	}

	public String getDeveloper()
	{
		return developer;
	}

	public void setDeveloper(String developer)
	{
		this.developer = developer;
	}

	public Integer getIssueNumber()
	{
		return issueNumber;
	}

	public void setIssueNumber(Integer issueNumber)
	{
		this.issueNumber = issueNumber;
	}

	public String getProject()
	{
		return project;
	}

	public void setProject(String project)
	{
		this.project = project;
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
   
   public boolean hasIssueNumber()
   {
   return GenericUtils.isNotNull(getIssueNumber());
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
