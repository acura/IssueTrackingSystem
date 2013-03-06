package com.its.action;


import com.its.domain.Developer;

import java.util.ArrayList;
import java.util.Collection;

public class ViewDeveloperAction extends DeveloperAction 
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
				getDeveloperService().deleteDeveloper(oid);
			}
		}
		 Collection<Developer> developerList = getDeveloperService().getAllDeveloper();
		 if (developerList == null)
		{
			developerList = new ArrayList<Developer>();
		}
		 getServletRequest().setAttribute("developerList",developerList);
		 
		return SUCCESS;
	
	}
	
}
