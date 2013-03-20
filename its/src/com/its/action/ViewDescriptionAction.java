package com.its.action;

import java.util.ArrayList;
import java.util.Collection;

import com.its.domain.Description;


public class ViewDescriptionAction extends DescriptionAction
{
	public String execute() throws Exception 
	{
		String strIssue_No = getServletRequest().getParameter("issue_No");
		if (strIssue_No != null && !strIssue_No.isEmpty())
		{
			Integer issue_No = Integer.parseInt(strIssue_No);
		}
		
		 Collection<Description> descriptionList = getDescriptionService().getAllDescription();
		 if (descriptionList == null)
		{
			 descriptionList = new ArrayList<Description>();
		}
		 getServletRequest().setAttribute("descriptionList",descriptionList);
		 
		return SUCCESS;

	}
}
