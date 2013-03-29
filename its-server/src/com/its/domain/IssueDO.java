package com.its.domain;

public class IssueDO
{
	private String developer;
	private Integer issueNumber;
	private String issueDate;
	private String dateSign;
	private String searchFromDate;
	private String searchToDate;
	
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
	public String getIssueDate()
	{
		return issueDate;
	}
	public void setIssueDate(String issueDate)
	{
		this.issueDate = issueDate;
	}
	public String getDateSign()
	{
		return dateSign;
	}
	public void setDateSign(String dateSign)
	{
		this.dateSign = dateSign;
	}
	public String getSearchFromDate()
	{
		return searchFromDate;
	}
	public void setSearchFromDate(String searchFromDate)
	{
		this.searchFromDate = searchFromDate;
	}
	public String getSearchToDate() 
	{
		return searchToDate;
	}
	public void setSearchToDate(String searchToDate)
	{
		this.searchToDate = searchToDate;
	}
	
}
