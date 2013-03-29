package com.its.action;


import com.its.domain.Developer;
import com.its.domain.Project;

import java.util.ArrayList;
import java.util.Collection;

public class ViewProjectAction extends ProjectAction 
{
	public String execute() throws Exception
	{
		
		 if (getServletRequest().getParameter("delete") != null && 
			getServletRequest().getParameter("delete").equals("true"))
		{
			String strOid = getServletRequest().getParameter("oid");
			if (strOid != null && !strOid.isEmpty())
			{
				Integer oid = Integer.parseInt(strOid);
				getProjectService().deleteProject(oid);
			}
		}
		 Collection<Project> projectList = getProjectService().getAllProject();
		 if (projectList == null)
		{
			 projectList = new ArrayList<Project>();
		}
		 getServletRequest().setAttribute("projectList",projectList);
		 
		return SUCCESS;
	
	}
	
}
