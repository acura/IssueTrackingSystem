package com.its.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




import com.its.dao.NewIssueDAO;
import com.its.domain.Account;
import com.its.domain.Developer;
import com.its.domain.NewIssue;

import com.its.exception.DAOException;

public class NewIssueService 
{

	@Autowired
	private NewIssueDAO newIssueDAO;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer saveNewIssues(NewIssue newIssue)
	throws DAOException
	{
		return newIssueDAO.saveNewIssues(newIssue);
	}
	
	@Transactional(readOnly=true)
	public NewIssue getNewIssueByOid(Integer issueNumber)
	throws DAOException
	{
		//return developerDAO .getDeveloperByOid(oid);
		return newIssueDAO.getNewIssueByOid(issueNumber);
	}

	@Transactional(readOnly=true)
	public Collection<NewIssue> getAllNewIssue()
	throws DAOException
	{
		return newIssueDAO.getAllNewIssue();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean deleteNewIssue(Integer issueNumber)
	throws DAOException
	{
		return newIssueDAO.deleteNewIssues(issueNumber);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public NewIssue  getNewIssueByissueNumber(Integer issueNumber)
	throws DAOException
	{
		return newIssueDAO.getNewIssueByissueNumber(issueNumber);
	}

}
