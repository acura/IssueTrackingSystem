package com.its.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.its.dao.IssueDAO;
import com.its.domain.Account;
import com.its.domain.Issue;
import com.its.domain.IssueDO;
import com.its.exception.DAOException;

public class IssueService 
{

	@Autowired
	private IssueDAO issueDAO;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer saveIssues(Issue issue)
	throws DAOException
	{
		return issueDAO.saveIssues(issue);
	}
	
	@Transactional(readOnly=true)
	public Collection<Issue> getTodaysIssues()
	throws DAOException
	{
		return issueDAO.getTodaysIssues();
	}
	
	
	@Transactional(readOnly=true)
	public Issue getIssueByOid(Integer oid)
	throws DAOException
	{
		return issueDAO.getIssueByOid(oid);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean deleteIssuesBy(Integer oid)
	throws DAOException
	{
		return issueDAO.deleteIssuesBy(oid);
	}
	@Transactional(readOnly=true)
	public Collection<Issue> getAllIssue( IssueDO issueDO )
	throws DAOException
	{
		return  issueDAO.getAllIssue(issueDO);
	}
	
	
}
