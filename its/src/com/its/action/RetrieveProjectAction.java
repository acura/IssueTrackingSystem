package com.its.action;

import com.its.domain.Developer;
import com.its.domain.Project;
import com.its.util.GenericUtils;

public class RetrieveProjectAction extends ProjectAction
{
	public String execute() throws Exception
	{
		
		String oid = getServletRequest().getParameter("oid");
		
		if (GenericUtils.isNotNullOrEmpty(oid))
		{
			
			Project projectObj = getProjectService().getProjectByOid(Integer.parseInt(oid));	
			this.setOid(projectObj.getOid());
			this.setProjectName(projectObj.getProjectName());
		
			
		}
		else
		{
	      getServletRequest().getSession().removeAttribute("projectSearchObject");
		}
		//int oid1=Integer.parseInt(oid);
		//getIssueService().deleteIssuesBy(5);
	 return SUCCESS;	
	 }
	}
