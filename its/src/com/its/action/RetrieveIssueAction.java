package com.its.action;

import com.its.domain.Issue;
import com.its.domain.PortalConstant;
import com.its.util.DateUtils;
import com.its.util.GenericUtils;

import java.util.ArrayList;
import java.util.List;
//
//modified
public class RetrieveIssueAction extends IssueAction
{
public String execute() throws Exception
  {
	String issueNumber = getServletRequest().getParameter("issueNumber");
	
	PortalConstant.setAllProjectList();
	setProjectList(PortalConstant.getProjectList());
	
	PortalConstant.setAllDeveloperList();
	setDeveloperList(PortalConstant.getDeveloperList());
	
	
	if(GenericUtils.isNotNullOrEmpty(issueNumber))
	{
		Issue issueObj = getIssueService().getIssueByOid(Integer.parseInt(issueNumber));	
		this.setOid(issueObj.getOid());
		this.setIssueNumber(issueObj.getNewIssue().getIssueNumber());
		//this.setDeveloper(issueObj.getDeveloper());
		
		if (issueObj.getProject() != null &&
				!issueObj.getProject().isEmpty())
		{
			String projectNameLst = issueObj.getProject();
			String prNameLst[] = projectNameLst.split(",");
			String selectedProjectNameSelectTag = "";
			selectedProjectNameSelectTag += 
				"<tr>" +
				"<select name=\"project\" multiple=\"multiple\" >" +
				"<option></option>";
			List<String> projectNameList = new ArrayList<String>();	
			projectNameList.add("GynoSoft");
			projectNameList.add("Prolab");
			projectNameList.add("GenSoft");
			projectNameList.add("Prescription");
			projectNameList.add("VBS");
			projectNameList.add("UAS");
			projectNameList.add("ITS");
			for (String s : prNameLst)
			{	
				s = s.trim();
				if (s.equalsIgnoreCase("GynoSoft"))
				{	
					selectedProjectNameSelectTag += "<option value=\"GynoSoft\" selected >GynoSoft</option>";
					projectNameList.remove(s);
				}
				if (s.equalsIgnoreCase("Prolab"))
				{	
					selectedProjectNameSelectTag += "<option value=\"Prolab\" selected >Prolab</option>";
					projectNameList.remove(s);
				}
				if (s.equalsIgnoreCase("GenSoft"))
				{	
					selectedProjectNameSelectTag += "<option value=\"GenSoft\" selected >GenSoft</option>";
					projectNameList.remove(s);
				}
				if (s.equalsIgnoreCase("Prescription"))
				{	
					selectedProjectNameSelectTag += "<option value=\"Prescription\" selected >Prescription</option>";
					projectNameList.remove(s);
				}
				if (s.equalsIgnoreCase("VBS"))
				{	
					selectedProjectNameSelectTag += "<option value=\"VBS\" selected >VBS</option>";
					projectNameList.remove(s);
				}
				if (s.equalsIgnoreCase("UAS"))
				{	
					selectedProjectNameSelectTag += "<option value=\"UAS\" selected >UAS</option>";
					projectNameList.remove(s);
				}
				if (s.equalsIgnoreCase("ITS"))
				{	
					selectedProjectNameSelectTag += "<option value=\"ITS\" selected >ITS</option>";
					projectNameList.remove(s);
				}
			}
			
			for (String s : projectNameList)
			{	
				s = s.trim();
				if (s.equalsIgnoreCase("GynoSoft"))
				{	
					selectedProjectNameSelectTag += "<option value=\"GynoSoft\" >GynoSoft</option>";
				}
				if (s.equalsIgnoreCase("Prolab"))
				{	
					selectedProjectNameSelectTag += "<option value=\"Prolab\" >Prolab</option>";
				}
				if (s.equalsIgnoreCase("GenSoft"))
				{	
					selectedProjectNameSelectTag += "<option value=\"GenSoft\" >GenSoft</option>";
				}
				if (s.equalsIgnoreCase("Prescription"))
				{	
					selectedProjectNameSelectTag += "<option value=\"Prescription\" >Prescription</option>";
				}
				if (s.equalsIgnoreCase("VBS"))
				{	
					selectedProjectNameSelectTag += "<option value=\"VBS\" >VBS</option>";
				}
				if (s.equalsIgnoreCase("UAS"))
				{	
					selectedProjectNameSelectTag += "<option value=\"UAS\" >UAS</option>";
				}
				if (s.equalsIgnoreCase("ITS"))
				{	
					selectedProjectNameSelectTag += "<option value=\"ITS\" >ITS</option>";
				}
			}
			selectedProjectNameSelectTag +="</select>" +
				"</tr>";
			getServletRequest().setAttribute("selectedProjectNameList", selectedProjectNameSelectTag);
		}
		
		//this.setProject(issueObj.getProject());
		
		this.setIssueDate(DateUtils.getDateAsDDMMYYYYFromMysqlDate(issueObj.getIssueDate()));
		this.setHours(issueObj.getHours());
		this.setComment(issueObj.getComment());
		this.setActivity(issueObj.getActivity());
	}
	else
	{
      getServletRequest().getSession().removeAttribute("issueSearchObject");
	}
	//int oid1=Integer.parseInt(oid);
	//getIssueService().deleteIssuesBy(5);
 return SUCCESS;	
 }
}
