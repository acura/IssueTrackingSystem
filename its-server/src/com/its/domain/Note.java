package com.its.domain;

public class Note 
{
	private Integer oid;
	private Integer issueNumber;
	private String note;
	private NewIssue newIssue;
	public Integer getOid()
	{
		return oid;
	}
	public void setOid(Integer oid) 
	{
		this.oid = oid;
	}
	
	public Integer getIssueNumber()
	{
		return issueNumber;
	}
	public void setIssueNumber(Integer issueNumber)
	{
		this.issueNumber = issueNumber;
	}
	public String getNote()
	{
		return note;
	}
	public void setNote(String note)
	{
		this.note = note;
	}
	public NewIssue getNewIssue()
	{
		return newIssue;
	}
	public void setNewIssue(NewIssue newIssue)
	{
		this.newIssue = newIssue;
	}
	
	
	
}
