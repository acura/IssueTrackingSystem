package com.its.action;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.app.context.AppContext;
import com.its.domain.DropdownOption;
import com.its.service.AccountService;
import com.its.service.DeveloperService;
import com.its.service.IssueService;
import com.its.service.NewIssueService;
import com.its.service.NoteService;
import com.its.util.GenericUtils;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
	private Integer oid;
	private String priority;
    private Double estimatedHours;
	private String actualStartDate;
    private String actualEndDate;
    private String targetVersion;
    private String assignedTo;
    private String status;
    private Double hours;
    private String comment;
    private String activity;
    private Integer issueNumber;
    private String note;

	private HttpServletRequest servletRequest;
	private HttpServletResponse servletResponse;
    
    
    private List<DropdownOption> projectList = new ArrayList<DropdownOption>();
    private List<DropdownOption> developerList = new ArrayList<DropdownOption>();
    
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
	
	
	
	public Integer getOid() 
	{
		return oid;
	}

	public void setOid(Integer oid)
	{
		this.oid = oid;
	}

	public String getPriority() 
	{
		return priority;
	}

	public void setPriority(String priority)
	{
		this.priority = priority;
	}

	public Double getEstimatedHours()
	{
		return estimatedHours;
	}

	public void setEstimatedHours(Double estimatedHours)
	{
		this.estimatedHours = estimatedHours;
	}

	public String getActualStartDate()
	{
		return actualStartDate;
	}

	public void setActualStartDate(String actualStartDate)
	{
		this.actualStartDate = actualStartDate;
	}

	public String getActualEndDate()
	{
		return actualEndDate;
	}

	public void setActualEndDate(String actualEndDate)
	{
		this.actualEndDate = actualEndDate;
	}

	public String getTargetVersion() 
	{
		return targetVersion;
	}

	public void setTargetVersion(String targetVersion)
	{
		this.targetVersion = targetVersion;
	}

	public String getAssignedTo() 
	{
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo)
	{
		this.assignedTo = assignedTo;
	}
	
	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
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
	
	public IssueService getIssueService()
	{
		return (IssueService)AppContext.getApplicationContext().getBean("issueService");
	}

	public NewIssueService getNewIssueService()
	{
		return (NewIssueService)AppContext.getApplicationContext().getBean("newIssueService");
	}
	
	public NoteService getNoteService()
	{
		return (NoteService)AppContext.getApplicationContext().getBean("noteService");
	}

	
	  public boolean hasOid()
	   {
		return GenericUtils.isNotNull(getOid()); 
	   }	 
	   
		  
	  public boolean hasPriority()
	  {
		  return GenericUtils.isNotNullOrEmpty(getPriority()); 
	  }
	   
	   

	  public boolean hasEstimatedHours()
	  {
		return GenericUtils.isNotNull(getEstimatedHours()); 
	  }
	  
	  
	  public boolean hasActualStartDate()
	  {
		return GenericUtils.isNotNullOrEmpty(getActualStartDate()); 
	  }
	
	  public boolean hasActualEndDate()
	  {
		return GenericUtils.isNotNullOrEmpty(getActualEndDate()); 
	  }
	  
	
	  public boolean hasTargetVersion()
	  {
		return GenericUtils.isNotNullOrEmpty(getTargetVersion()); 
	  }
	
	  public boolean hasAssignedTo()
	  {
		return GenericUtils.isNotNullOrEmpty(getAssignedTo()); 
	  }
	
	  public boolean hasHours()
	  {
		  return GenericUtils.isNotNull(getHours()); 
	  }
	   
	  public boolean hasActivity()
	  {
		return GenericUtils.isNullOrEmpty(getActivity()); 
	  }

	public Integer getIssueNumber()
	{
		return issueNumber;
	}

	public void setIssueNumber(Integer issueNumber)
	{
		this.issueNumber = issueNumber;
	}
	  
}