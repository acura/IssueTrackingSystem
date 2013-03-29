package com.its.action;

import java.util.ArrayList;
import java.util.List;

import com.its.domain.Developer;
import com.its.domain.NewIssue;
import com.its.domain.PortalConstant;
import com.its.util.DateUtils;
import com.its.util.GenericUtils;

public class RetrieveNewIssueAction extends NewIssueAction
{
	public String execute() throws Exception
	{
		
		String issueNumber = getServletRequest().getParameter("issueNumber");
		
		PortalConstant.setAllProjectList();
		setProjectList(PortalConstant.getProjectList());
		
		PortalConstant.setAllDeveloperList();
		setDeveloperList(PortalConstant.getDeveloperList());
		

		/*if (opdRegister.getReferral() != null)
		{
						
			Referral referral = getReferralService().getReferralByOid(opdRegister.getReferral().getOid());

			this.setReferredByOid(referral.getOid());

			this.setRefBy(referral.getOid().toString() + ":"+ referral.getName());

		}*/

		
		if (GenericUtils.isNotNull(getIssueNumber()))
		{
			
			NewIssue newIssueObj = getNewIssueService().getNewIssueByOid(getIssueNumber());	
			this.setIssueNumber(newIssueObj.getIssueNumber());
			this.setSummary(newIssueObj.getSummary());
			this.setDetail(newIssueObj.getDetail());
			this.setSystem(newIssueObj.getSystem());
			/*if (newIssueObj.getSystem() != null) {
				
			}
			//this.setSystem(newIssueObj.getSystem());
			if (newIssueObj.getSystem() != null &&
					!newIssueObj.getSystem().isEmpty())
			{
				String projectNameLst = newIssueObj.getSystem();
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
			}*/

			this.setSeverity(newIssueObj.getSeverity());
			this.setPriority(newIssueObj.getPriority());
			this.setEstimatedStartDate(DateUtils.getDateAsString(newIssueObj.getEstimatedStartDate()));
			this.setEstimatedEndDate(DateUtils.getDateAsString(newIssueObj.getEstimatedEndDate()));
			this.setEstimatedHours(newIssueObj.getEstimatedHours());
			this.setActualStartDate(DateUtils.getDateAsString(newIssueObj.getActualStartDate()));
			this.setActualEndDate(DateUtils.getDateAsString(newIssueObj.getActualEndDate()));
			this.setLoggedBy(newIssueObj.getLoggedBy());
			this.setStatus(newIssueObj.getStatus());
			this.setTargetVersion(newIssueObj.getTargetVersion());
			this.setAssignedTo(newIssueObj.getAssignedTo());
			
		
			
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
