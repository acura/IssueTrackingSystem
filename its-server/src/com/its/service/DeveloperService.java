package com.its.service;
//sss
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import com.its.dao.DeveloperDAO;
import com.its.domain.Account;
import com.its.domain.Developer;
import com.its.domain.DropdownOption;
import com.its.domain.PortalConstant;
import com.its.domain.Project;

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
	
	public Developer checkValidUser(String oid, String password)
	throws DAOException
	{
		return developerDAO.checkValidUser(oid, password);
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
	@Transactional(readOnly=true)
	public List<DropdownOption> getAllDeveloperList()
	throws DAOException
	{
		List<Developer> developersList = developerDAO.getAllDeveloperList();
		
		List<DropdownOption> developerDropdownOptions = new ArrayList<DropdownOption>();
		developerDropdownOptions.add(new DropdownOption(PortalConstant.BLANK_STRING, PortalConstant.BLANK_STRING));
		if (developersList != null) 
		{
		   for (Developer developer : developersList)
		   {
			  DropdownOption dropdownOption = new DropdownOption();
			  
			  dropdownOption.setOptionId(developer.getDeveloperName());
			  dropdownOption.setOptionText(developer.getDeveloperName());
			  
			  developerDropdownOptions.add(dropdownOption);
			  
		    }	
		}
		
		return developerDropdownOptions;
	}

	
}
