package com.its.action;

import com.its.domain.Developer;
import com.its.util.GenericUtils;

public class RetrieveDeveloperAction extends DeveloperAction
{
	public String execute() throws Exception
	{
		
		String oid = getServletRequest().getParameter("oid");
		
		if (GenericUtils.isNotNullOrEmpty(oid))
		{
			
			Developer developerObj = getDeveloperService().getDeveloperByOid(Integer.parseInt(oid));	
			this.setOid(developerObj.getOid());
			this.setDeveloperName(developerObj.getDeveloperName());
		
			
		}
		else
		{
	      getServletRequest().getSession().removeAttribute("developerSearchObject");
		}
		//int oid1=Integer.parseInt(oid);
		//getIssueService().deleteIssuesBy(5);
	 return SUCCESS;	
	 }
	}
