package com.its.service;

import java.util.Collection;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.its.dao.DescriptionDAO;
import com.its.domain.Description;
import com.its.domain.Project;
import com.its.exception.DAOException;

public class DescriptionService
{
private DescriptionDAO descriptionDAO;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer saveDescription(Description descriptionobj)
	throws DAOException
	{
		return descriptionDAO.saveDescription(descriptionobj);
	}
	@Transactional(readOnly=true)
	public Description getDescriptionByIssue_No(Integer issue_No)
	throws DAOException
	{
	  return descriptionDAO.getDescriptionByIssue_No(issue_No);
	}
	
	@Transactional(readOnly=true)
	public Collection<Description> getAllDescription()
	throws DAOException
	{
		return descriptionDAO.getAllDescription();
	}
}
