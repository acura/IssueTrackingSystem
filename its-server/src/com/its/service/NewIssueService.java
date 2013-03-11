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
	public NewIssue getNewIssueByOid(Integer oid)
	throws DAOException
	{
		//return developerDAO .getDeveloperByOid(oid);
		return newIssueDAO.getNewIssueByOid(oid);
	}
	

	@Transactional(readOnly=true)
	public Collection<NewIssue> getAllNewIssue()
	throws DAOException
	{
		return newIssueDAO.getAllNewIssue();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean deleteNewIssue(Integer oid)
	throws DAOException
	{
		return newIssueDAO.deleteNewIssues(oid);
	}
}
