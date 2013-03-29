package com.its.action;

import java.util.Date;

import com.its.domain.Issue;
import com.its.domain.NewIssue;
import com.its.domain.PortalConstant;
import com.its.exception.DAOException;
import com.its.util.DateUtils;

public class SaveIssueAction extends IssueAction
{

	public String execute() throws Exception
	{
	Integer oid=saveIssues();	
	System.out.println("Oid"+oid);	
    return SUCCESS;		
	}
	
	private Integer saveIssues() throws Exception
	{
	Issue issue = populateIssues();	
	
	return getIssueService().saveIssues(issue);
	}
    private Issue populateIssues()throws DAOException
	 {
    	Issue issueobj= new Issue();
    	issueobj.setNewIssue(getNewIssueService().getNewIssueByissueNumber(getIssueNumber()));
    	issueobj.setOid(this.getOid());
    	issueobj.setDeveloper(this.getDeveloper());
    	issueobj.setProject(this.getProject());
    	issueobj.setIssueNumber(this.getIssueNumber());
    	/*issueobj.setIssueNo(this.getIssueNo() != null ? 
    			this.getIssueNo().contains("Acura") ? 
    			this.getIssueNo() : 
    			"Acura-" + this.getIssueNo() : null);*/
    	issueobj.setIssueDate(DateUtils.getStringAsDate(this.getIssueDate()));
    	issueobj.setHours(this.getHours());
    	issueobj.setComment(this.getComment());
    	issueobj.setActivity(this.getActivity());
    	issueobj.setCreatedDate(new Date());
    	issueobj.setLastUpdatedDate(new Date());
    
		return issueobj; 
	 }
	
	public void validate()
	{
	setProjectList(PortalConstant.getProjectList());
	setDeveloperList(PortalConstant.getDeveloperList());

	if(hasActivity())	
	{
	addFieldError("activity","Activity is Required");	
	}
	
	if(!hasIssueNumber())
	{
    addFieldError("issueNumber","IssueNumber is Required");		
	}
	
	if(hasProject())
	{
    addFieldError("project","project is Required");		
	}
	if(!hasIssueDate())
	{
    addFieldError("issueDate","issueDate Date is Required");		
	}
	
	/*if(!hasHours())
	{
    addFieldError("hours","Hour is Required");		
	}*/
	
	if(!hasDeveloper())
	{
    addFieldError("developer","Developer Name is Required");		
	}
	}
}
