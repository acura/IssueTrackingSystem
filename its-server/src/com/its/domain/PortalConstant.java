package com.its.domain;


import java.util.List;

import com.its.dao.HibernateUtil;
import com.its.exception.DAOException;
import com.its.service.DeveloperService;
import com.its.service.ProjectService;

public class PortalConstant
{
	public static final String BLANK_STRING = "";
	public static final String SINGLE_SPACE = " ";
	public static final String DOT = ".";
	public static final String COLON = ":";
	public static final String COMMA_SPACE = ", ";
	public static final String SINGLE_QUOTE = "'";
	public static final String SPACE_HYPHEN_SPACE = " - ";
	public static final String HYPHEN = "-";
	public static final String ACCOUNT_ID = "accountId"; 
	public static final String DEVELOPER_ID = "oid";
	
	public static List<DropdownOption> projectList;
	
	public static ProjectService getProjectService()
	{
		return (ProjectService)HibernateUtil.getApplicationContext().getBean("projectService");
	}
	
	
	public static List<DropdownOption> getProjectList() 
	{
		return projectList;
	}

	public static void setProjectList(List<DropdownOption> projectList) 
	{
		PortalConstant.projectList = projectList;
	}

	public static void setAllProjectList() throws DAOException
	{
		List<DropdownOption> allProjectList = getProjectService().getAllProjectList();
		setProjectList(allProjectList);
	}
	
public static List<DropdownOption> developerList;
	
	public static DeveloperService getDeveloperService()
	{
		return (DeveloperService)HibernateUtil.getApplicationContext().getBean("developerService");
	}
	
	
	public static List<DropdownOption> getDeveloperList() 
	{
		return developerList;
	}

	public static void setDeveloperList(List<DropdownOption> developerList) 
	{
		PortalConstant.developerList = developerList;
	}

	public static void setAllDeveloperList() throws DAOException
	{
		List<DropdownOption> allDeveloperList = getDeveloperService().getAllDeveloperList();
		setDeveloperList(allDeveloperList);
	}
	
	

	
	
}
