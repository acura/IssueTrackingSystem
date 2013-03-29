package com.its.action;

import java.util.Date;

import com.its.domain.Issue;
import com.its.domain.NewIssue;
import com.its.domain.Note;
import com.its.util.DateUtils;

public class SaveUpdateAction extends UpdateAction
{

	public String execute() throws Exception
	{
		//Integer oid=
			saveUpdate();
			
	//System.out.println("Oid"+oid);	
    return SUCCESS;		
	}
	
	private void saveUpdate() throws Exception
	{
		NewIssue newIssue= populateNewIssues();	
		Issue issue = populateIssues();
		Note note = populateNote(); 
		
		
		getNewIssueService().saveNewIssues(newIssue);
		getIssueService().saveIssues(issue);
		getNoteService().saveNote(note);
	}
    private NewIssue populateNewIssues()
	 {
    	NewIssue newIssueobj=new NewIssue();
    	newIssueobj.setPriority(this.getPriority());
    	newIssueobj.setEstimatedHours(this.getEstimatedHours());
    	newIssueobj.setActualStartDate(DateUtils.getStringAsDate(this.getActualStartDate()));
    	newIssueobj.setActualEndDate(DateUtils.getStringAsDate(this.getActualEndDate()));
    	newIssueobj.setTargetVersion(this.getTargetVersion());
    	newIssueobj.setAssignedTo(this.getAssignedTo());
    	return newIssueobj; 
	 }
	
    
    private Issue populateIssues()
	 {
    	Issue issueobj=new Issue();
    	issueobj.setOid(this.getOid());
    	issueobj.setHours(this.getHours());
    	issueobj.setComment(this.getComment());
    	issueobj.setActivity(this.getActivity());
    	//issueobj.setNissue(this.getNissue());
    	return issueobj;
	 }
    private Note populateNote()
    {
    
    	 Note note=new Note();
    	 note.setOid(this.getOid());
    	 note.setIssueNumber(this.getIssueNumber());
    	 return note;
    }
    
 public void validate()
 {	

   if(!hasEstimatedHours())
	{
    addFieldError("estimatedHours","hasEstimatedHours is Required");		
	}
	
	if(!hasPriority())
	{
    addFieldError("priority","Priority is Required");		
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
