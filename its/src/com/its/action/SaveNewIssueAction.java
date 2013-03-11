package com.its.action;

import java.util.Date;

import com.its.domain.Issue;
import com.its.domain.NewIssue;
import com.its.util.DateUtils;

public class SaveNewIssueAction extends NewIssueAction
{

	public String execute() throws Exception
	{
		//Integer oid=
			saveNewIssues();	
	//System.out.println("Oid"+oid);	
    return SUCCESS;		
	}
	
	private void saveNewIssues() throws Exception
	{
		NewIssue newIssue=populateNewIssues();	
	
		 getNewIssueService().saveNewIssues(newIssue);
	}
    private NewIssue populateNewIssues()
	 {
    	NewIssue newIssueobj=new NewIssue();
    	newIssueobj.setOid(this.getOid());
    	newIssueobj.setIssueNo(this.getIssueNo() != null ? 
    			this.getIssueNo().contains("Acura") ? 
    			this.getIssueNo() : 
    			"Acura-" + this.getIssueNo() : null);

    	newIssueobj.setSummary(this.getSummary());
    	newIssueobj.setDetail(this.getDetail());
    	newIssueobj.setSystem(this.getSystem());
    	newIssueobj.setSeverity(this.getSeverity());
    	newIssueobj.setPriority(this.getPriority());
    	newIssueobj.setEstimatedHours(this.getEstimatedHours());
    	/*newIssueobj.setEstimatedStartDate(new Date());
    	newIssueobj.setEstimatedEndDate(new Date());
    	newIssueobj.setActualStartDate(new Date());
    	newIssueobj.setActualEndDate(new Date());*/
    	newIssueobj.setEstimatedStartDate(DateUtils.getStringAsDate(this.getEstimatedStartDate()));
    	newIssueobj.setEstimatedEndDate(DateUtils.getStringAsDate(this.getEstimatedEndDate()));
    	newIssueobj.setActualStartDate(DateUtils.getStringAsDate(this.getActualStartDate()));
    	newIssueobj.setActualEndDate(DateUtils.getStringAsDate(this.getActualEndDate()));
    	/*newIssueobj. setEstimatedStartDate(DateUtils.getStringAsDate(this.getEstimatedStartDate()));
    	newIssueobj.setEstimatedEndDate(DateUtils.getStringAsDate(this.getEstimatedEndDate()));
    	newIssueobj.setActualStartDate(DateUtils.getStringAsDate(this.getActualStartDate()));
    	newIssueobj.setActualEndDate(DateUtils.getStringAsDate(this.getActualEndDate()));*/
    	newIssueobj.setLoggedBy(this.getLoggedBy());
    	newIssueobj.setTargetVersion(this.getTargetVersion());
    	newIssueobj.setAssignedTo(this.getAssignedTo());
    	//newIssueobj.setCreatedDate(new Date());
    	//newIssueobj.setLastUpdatedDate(new Date());
		return newIssueobj; 
	 }
	
	public void validate()
	{
	if(!hasSummary())	
	{
	addFieldError("summary","Summary is Required");	
	}
	
	if(!hasIssueNo())
	{
    addFieldError("issueNo","IssueNo is Required");		
	}
	
	if(hasDetail())
	{
    addFieldError("detail","Detail is Required");		
	}
	if(!hasSystem())
	{
    addFieldError("system","System is Required");		
	}
	
	if(!hasEstimatedHours())
	{
    addFieldError("estimatedHours","hasEstimatedHours is Required");		
	}
	
	if(!hasPriority())
	{
    addFieldError("priority","Priority is Required");		
	}
	if(hasSeverity())
	{
    addFieldError("severity","Severity is Required");		
	}
	if(!hasEstimatedStartDate())
	{
    addFieldError("estimatedStartDate","EstimatedStartDate is Required");		
	}
	else if (DateUtils.getStringAsDate(getEstimatedStartDate()).after(new Date()))
	{
		addFieldError("estimatedStartDate", "Estimated Start Date should not be in future");
	}
	
	if(!hasEstimatedEndDate())
	{
    addFieldError("estimatedEndDate","EstimatedEndDate is Required");		
	}
	else if (DateUtils.getStringAsDate(getEstimatedEndDate()).after(new Date()))
	{
		addFieldError("estimatedEndDate", "Estimated End Date should not be in future");
	}
	
	if(!hasActualStartDate())
	{
    addFieldError("actualStartDate","ActualStartDate is Required");		
	}
	else if (DateUtils.getStringAsDate(getActualStartDate()).after(new Date()))
	{
		addFieldError("actualStartDate", "Actual Start Date should not be in future");
	}
	
	if(!hasActualEndDate())
	{
    addFieldError("actualEndDate","ActualEndDate is Required");		
	}
	else if (DateUtils.getStringAsDate(getActualEndDate()).after(new Date()))
	{
		addFieldError("actualEndDate", "Actual End Date should not be in future");
	}
	
	if(!hasLoggedBy())
	{
    addFieldError("loggedBy","LoggedBy is Required");		
	}
	if(!hasTargetVersion())
	{
    addFieldError("targetVersion","TargetVersion is Required");		
	}
	if(!hasAssignedTo())
	{
    addFieldError("AssignedTo","AssignedTo is Required");		
	}
	}
}
