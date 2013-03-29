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
import com.its.service.ProjectService;
import com.its.util.GenericUtils;
import com.opensymphony.xwork2.ActionSupport;

public class NewIssueAction extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
	private Integer issueNumber;
	private String summary;
	private String detail;
	private String system;
	private String severity;
	private String priority;
    private String estimatedStartDate;
    private String estimatedEndDate;
    private Double estimatedHours;
	private String actualStartDate;
    private String actualEndDate;
    private String loggedBy;
    private String status;
    private String targetVersion;
    private String assignedTo;
    
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
	
	public Integer getIssueNumber()
	{
		return issueNumber;
	}

	public void setIssueNumber(Integer issueNumber)
	{
		this.issueNumber = issueNumber;
	}

	public String getSummary() 
	{
		return summary;
	}
	public void setSummary(String summary) 
	{
		this.summary = summary;
	}
	public String getDetail() 
	{
		return detail;
	}
	public void setDetail(String detail) 
	{
		this.detail = detail;
	}
	public String getSystem() 
	{
		return system;
	}
	public void setSystem(String system) 
	{
		this.system = system;
	}
	
	public String getSeverity()
	{
		return severity;
	}
	public void setSeverity(String severity)
	{
		this.severity = severity;
	}
	public String getPriority() 
	{
		return priority;
	}
	public void setPriority(String priority)
	{
		this.priority = priority;
	}
	
	public String getEstimatedStartDate() 
	{
		return estimatedStartDate;
	}
	public void setEstimatedStartDate(String estimatedStartDate) 
	{
		this.estimatedStartDate = estimatedStartDate;
	}
	public String getEstimatedEndDate() 
	{
		return estimatedEndDate;
	}
	public void setEstimatedEndDate(String estimatedEndDate) 
	{
		this.estimatedEndDate = estimatedEndDate;
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

	
	public Double getEstimatedHours() 
	{
		return estimatedHours;
	}
	public void setEstimatedHours(Double estimatedHours) 
	{
		this.estimatedHours = estimatedHours;
	}
		public String getLoggedBy() 
	{
		return loggedBy;
	}
	public void setLoggedBy(String loggedBy) 
	{
		this.loggedBy = loggedBy;
	}
	
	
	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
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
	

	public NewIssueService getNewIssueService()
	{
		return (NewIssueService)AppContext.getApplicationContext().getBean("newIssueService");
	}
	
   public boolean hasSummary()
   {
	  return GenericUtils.isNotNullOrEmpty(getSummary()); 
   }
   
   public boolean hasIssueNumber()
   {
   return GenericUtils.isNotNull(getIssueNumber());
   }
    
   public boolean hasDetail()
   {
	return GenericUtils.isNullOrEmpty(getDetail());   
   }

	  public boolean hasSystem()
	  {
		return GenericUtils.isNotNullOrEmpty(getSystem());  
	  }
	  
	  public boolean hasPriority()
	  {
		  return GenericUtils.isNotNullOrEmpty(getPriority()); 
	  }
	   
	  public boolean hasSeverity()
	  {
		return GenericUtils.isNullOrEmpty(getSeverity()); 
	  }
	  
	
	  public boolean hasEstimatedHours()
	  {
		return GenericUtils.isNotNull(getEstimatedHours()); 
	  }
	  
	  public boolean hasEstimatedStartDate()
	  {
		return GenericUtils.isNotNullOrEmpty(getEstimatedStartDate()); 
	  }
	
	  public boolean hasEstimatedEndDate()
	  {
		return GenericUtils.isNotNullOrEmpty(getEstimatedEndDate()); 
	  }
	
	
	  public boolean hasActualStartDate()
	  {
		return GenericUtils.isNotNullOrEmpty(getActualStartDate()); 
	  }
	
	  public boolean hasActualEndDate()
	  {
		return GenericUtils.isNotNullOrEmpty(getActualEndDate()); 
	  }
	  public boolean hasLoggedBy()
	  {
		return GenericUtils.isNotNullOrEmpty(getLoggedBy()); 
	  }
	
	  public boolean hasTargetVersion()
	  {
		return GenericUtils.isNotNullOrEmpty(getTargetVersion()); 
	  }
	
	  public boolean hasAssignedTo()
	  {
		return GenericUtils.isNotNullOrEmpty(getAssignedTo()); 
	  }
	



}