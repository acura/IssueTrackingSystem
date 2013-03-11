package com.its.action;

import com.its.domain.Developer;
import com.its.domain.NewIssue;
import com.its.util.DateUtils;
import com.its.util.GenericUtils;

public class RetrieveNewIssueAction extends NewIssueAction
{
	public String execute() throws Exception
	{
		
		String oid = getServletRequest().getParameter("oid");
		
		if (GenericUtils.isNotNullOrEmpty(oid))
		{
			
			NewIssue newIssueObj = getNewIssueService().getNewIssueByOid(Integer.parseInt(oid));	
			this.setOid(newIssueObj.getOid());
			this.setIssueNo(newIssueObj.getIssueNo());
			this.setSummary(newIssueObj.getSummary());
			this.setDetail(newIssueObj.getDetail());
			this.setSystem(newIssueObj.getSystem());
			this.setSeverity(newIssueObj.getSeverity());
			this.setPriority(newIssueObj.getPriority());
			this.setEstimatedStartDate(DateUtils.getDateAsString(newIssueObj.getEstimatedStartDate()));
			this.setEstimatedEndDate(DateUtils.getDateAsString(newIssueObj.getEstimatedEndDate()));
			this.setEstimatedHours(newIssueObj.getEstimatedHours());
			this.setActualStartDate(DateUtils.getDateAsString(newIssueObj.getActualStartDate()));
			this.setActualEndDate(DateUtils.getDateAsString(newIssueObj.getActualEndDate()));
			this.setLoggedBy(newIssueObj.getLoggedBy());
			this.setTargetVersion(newIssueObj.getTargetVersion());
			this.setAssignedTo(newIssueObj.getAssignedTo());
			
		
			
		}
		else
		{
	      getServletRequest().getSession().removeAttribute("developerSearchObject");
		}
		//int oid1=Integer.parseInt(oid);
		//getIssueService().deleteIssuesBy(5);
	 return SUCCESS;	
	 }
	}
