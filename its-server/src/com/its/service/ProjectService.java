package com.its.service;
//sss
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import com.its.dao.DeveloperDAO;
import com.its.dao.ProjectDAO;
import com.its.domain.Account;
import com.its.domain.Developer;
import com.its.domain.DropdownOption;
import com.its.domain.PortalConstant;
import com.its.domain.Project;

import com.its.exception.DAOException;

public class ProjectService 
{

	@Autowired
	private ProjectDAO projectDAO;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer saveProject(Project project)
	throws DAOException
	{
		return projectDAO.saveProject(project);
	}
	

	
	
	@Transactional(readOnly=true)
	public Project getProjectByOid(Integer oid)
	throws DAOException
	{
		//return developerDAO .getDeveloperByOid(oid);
		return projectDAO.getProjectByOid(oid);
	}
	

	@Transactional(readOnly=true)
	public Collection<Project> getAllProject()
	throws DAOException
	{
		return projectDAO.getAllProject();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean deleteProject(Integer oid)
	throws DAOException
	{
		return projectDAO.deleteProject(oid);
	}
	
	@Transactional(readOnly=true)
	public List<DropdownOption> getAllProjectList()
	throws DAOException
	{
		List<Project> projectsList = projectDAO.getAllProjectList();
		
		List<DropdownOption> projectDropdownOptions = new ArrayList<DropdownOption>();
		projectDropdownOptions.add(new DropdownOption(PortalConstant.BLANK_STRING, PortalConstant.BLANK_STRING));
		if (projectsList != null) 
		{
		   for (Project project : projectsList)
		   {
			  DropdownOption dropdownOption = new DropdownOption();
			  
			  dropdownOption.setOptionId(project.getProjectName());
			  dropdownOption.setOptionText(project.getProjectName());
			  
			  projectDropdownOptions.add(dropdownOption);
			  
		    }	
		}
		
		return projectDropdownOptions;
	}
}
