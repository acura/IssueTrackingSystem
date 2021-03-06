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
			String strIssueNumber = getServletRequest().getParameter("issueNumber");
			if (strIssueNumber != null && !strIssueNumber.isEmpty())
			{
				Integer issueNumber = Integer.parseInt(strIssueNumber);
				getNewIssueService().deleteNewIssue(issueNumber);
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
