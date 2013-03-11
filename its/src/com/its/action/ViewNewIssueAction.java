package com.its.action;


import com.its.domain.Developer;
import com.its.domain.NewIssue;

import java.util.ArrayList;
import java.util.Collection;

public class ViewNewIssueAction extends NewIssueAction 
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
				getNewIssueService().deleteNewIssue(oid);
			}
		}
		 Collection<NewIssue> newIssueList = getNewIssueService().getAllNewIssue();
		 if (newIssueList == null)
		{
			 newIssueList = new ArrayList<NewIssue>();
		}
		 getServletRequest().setAttribute("newIssueList",newIssueList);
		 
		return SUCCESS;
	
	}
	
}
