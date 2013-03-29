package com.its.domain;

import java.util.Date;

public class NewIssue 
{
	private Integer issueNumber;
	private String summary;
	private String detail;
	private String system;
	private String severity;
	private String priority;
    private Date estimatedStartDate;
    private Date estimatedEndDate;
    private Double estimatedHours;
    private Date actualStartDate;
    private Date actualEndDate;
    private String loggedBy;
    private String status;
    private String targetVersion;
    private String assignedTo;
    private Issue issue;
     
	
	public Issue getIssue() 
	{
		return issue;
	}
	public void setIssue(Issue issue)
	{
		this.issue = issue;
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
	
	
	public Double getEstimatedHours() 
	{
		return estimatedHours;
	}
		
	public Date getEstimatedStartDate()
	{
		return estimatedStartDate;
	}
	public void setEstimatedStartDate(Date estimatedStartDate) 
	{
		this.estimatedStartDate = estimatedStartDate;
	}
	public Date getEstimatedEndDate()
	{
		return estimatedEndDate;
	}
	public void setEstimatedEndDate(Date estimatedEndDate)
	{
		this.estimatedEndDate = estimatedEndDate;
	}
	public Date getActualStartDate() 
	{
		return actualStartDate;
	}
	public void setActualStartDate(Date actualStartDate)
	{
		this.actualStartDate = actualStartDate;
	}
	public Date getActualEndDate() 
	{
		return actualEndDate;
	}
	public void setActualEndDate(Date actualEndDate)
	{
		this.actualEndDate = actualEndDate;
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
	
    
}