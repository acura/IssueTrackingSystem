package com.its.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




import com.its.dao.NewIssueDAO;
import com.its.dao.UpdateDAO;
import com.its.domain.Account;
import com.its.domain.Developer;
import com.its.domain.Issue;
import com.its.domain.NewIssue;

import com.its.exception.DAOException;

public class UpdateService 
{

	@Autowired
	private UpdateDAO updateDAO;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer saveNewIssues(NewIssue newIssue)
	throws DAOException
	{
		return updateDAO.saveNewIssues(newIssue);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer saveIssues(Issue issue)
	throws DAOException
	{
		return updateDAO.saveIssues(issue);
	}

		
	/*
	@Transactional(readOnly=true)
	public NewIssue getNewIssueByOid(Integer oid)
	throws DAOException
	{
		//return developerDAO .getDeveloperByOid(oid);
		return newIssueDAO.getNewIssueByOid(oid);
	}*/
	

	@Transactional(readOnly=true)
	public Collection<NewIssue> getAllNewIssue()
	throws DAOException
	{
		return updateDAO.getAllNewIssue();
	}
	
	@Transactional(readOnly=true)
	public Collection<Issue> getAllIssue()
	throws DAOException
	{
		return updateDAO.getAllIssue();
	}
	
	
	/*@Transactional(propagation=Propagation.REQUIRED)
	public boolean deleteNewIssue(Integer oid)
	throws DAOException
	{
		return newIssueDAO.deleteNewIssues(oid);
	}*/
}
