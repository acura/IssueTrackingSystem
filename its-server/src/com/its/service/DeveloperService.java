package com.its.service;
//sss
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import com.its.dao.DeveloperDAO;
import com.its.domain.Developer;

import com.its.exception.DAOException;

public class DeveloperService 
{

	@Autowired
	private DeveloperDAO developerDAO;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer saveDeveloper(Developer developer)
	throws DAOException
	{
		return developerDAO.saveDeveloper(developer);
	}
	
	
	
	@Transactional(readOnly=true)
	public Developer getDeveloperByOid(Integer oid)
	throws DAOException
	{
		//return developerDAO .getDeveloperByOid(oid);
		return developerDAO.getDeveloperByOid(oid);
	}
	

	@Transactional(readOnly=true)
	public Collection<Developer> getAllDeveloper()
	throws DAOException
	{
		return developerDAO.getAllDeveloper();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean deleteDeveloper(Integer oid)
	throws DAOException
	{
		return developerDAO.deleteDeveloper(oid);
	}
}
