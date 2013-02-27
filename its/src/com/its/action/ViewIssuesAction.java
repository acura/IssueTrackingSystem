package com.its.action;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jmesa.limit.ExportType;
import org.jmesa.model.TableModel;
import org.jmesa.view.component.Column;
import org.jmesa.view.component.Row;
import org.jmesa.view.component.Table;

import com.its.domain.Issue;
import com.its.domain.IssueDO;



public class ViewIssuesAction extends IssueAction 
{
	private String dateSign;
	private String developer;
	private String issueNo;
	private String searchFromDate;
	private String searchToDate;
	
	public String execute() throws Exception
	{
		
		String isFromSearch = getServletRequest().getParameter("isFromSearch");
		
		Collection<Issue> issueList = null; 
		
		if (getServletRequest().getParameter("isFromMenu") != null && 
				getServletRequest().getParameter("isFromMenu").equals("true"))
		{
			if (getServletRequest().getSession().getAttribute("issueSearchObject") != null);
			
				getServletRequest().getSession().removeAttribute("issueSearchObject");
					
				issueList = getIssueService().getTodaysIssues();
				
				if (issueList == null)
				{
					boolean recoreNotFoundToDay = true;
					getServletRequest().setAttribute("recoreNotFoundToDay", recoreNotFoundToDay);
					issueList = new ArrayList<Issue>();
				}
				else 
				{
					getServletRequest().setAttribute("todaysRecords", "todaysRecords");
				}
				
				
				getServletRequest().setAttribute("issueList", issueList);
		
		return SUCCESS;
		
		}
		else if (getServletRequest().getParameter("clear") != null && 
				!getServletRequest().getParameter("clear").isEmpty() &&
				getServletRequest().getParameter("clear").equals("true"))
		{
			if (getServletRequest().getSession().getAttribute("issueSearchObject") != null)
				getServletRequest().getSession().removeAttribute("issueSearchObject");
			
			return SUCCESS;
		}
		
		else if (getServletRequest().getParameter("cancel") != null && 
				!getServletRequest().getParameter("cancel").isEmpty() &&
				getServletRequest().getParameter("cancel").equals("true"))
		{
			if (getServletRequest().getSession().getAttribute("issueSearchObject") != null)
				getServletRequest().getSession().removeAttribute("issueSearchObject");
			
			return SUCCESS;
		}
		else
		{
			IssueDO issueDO = new IssueDO();
		   if (getServletRequest().getParameter("delete") != null && 
				getServletRequest().getParameter("delete").equals("true"))
			{
				String strOid = getServletRequest().getParameter("oid");
				if (strOid != null && !strOid.isEmpty())
				{
					Integer oid = Integer.parseInt(strOid);
					getIssueService().deleteIssuesBy(oid);
			
					if (getServletRequest().getSession().getAttribute("issueSearchObject") != null)
					{
						issueDO = (IssueDO) getServletRequest().getSession().getAttribute("issueSearchObject");
					}
					else
					{
						issueList = getIssueService().getTodaysIssues();
						
						if (issueList == null)
						{
							boolean recoreNotFoundToDay = true;
							getServletRequest().setAttribute("recoreNotFoundToDay", recoreNotFoundToDay);
							issueList = new ArrayList<Issue>();
						}
						getServletRequest().setAttribute("issueList", issueList);
						return SUCCESS;
					}
				
				}
				
		}
		else
		{
			if (getServletRequest().getParameter("isInvokedFromIssueSearch")!= null &&
					getServletRequest().getParameter("isInvokedFromIssueSearch").equals("true"))
			{
				issueDO = populateIssueDO();
			}
			else if (getServletRequest().getSession().getAttribute("issueSearchObject") != null &&
					getServletRequest().getSession().getAttribute("issueSearchObject") instanceof IssueDO)
			{
				issueDO = (IssueDO) getServletRequest().getSession().getAttribute("issueSearchObject");
			}
			
		}
		
		if ((getServletRequest().getParameter("type") != null && 
				 !getServletRequest().getParameter("type").isEmpty() &&
				 getServletRequest().getParameter("type").equalsIgnoreCase("basicExport")) &&
				getServletRequest().getSession().getAttribute("issueSearchObject") == null)
			{
			issueList =getIssueService().getTodaysIssues();
			}
		else if( getServletRequest().getParameter("type") != null &&
				!getServletRequest().getParameter("type").isEmpty() &&
				!getServletRequest().getParameter("type").equalsIgnoreCase("basicExport") &&
				issueDO.getDateSign() != null &&
				issueDO.getDateSign().isEmpty() && 
				issueDO.getDeveloper().isEmpty()&&  
				issueDO.getIssueNo().isEmpty() &&  
				issueDO.getSearchToDate()!= null && 
				issueDO.getSearchToDate().isEmpty() && 
				issueDO.getSearchFromDate().isEmpty() &&
				getServletRequest().getParameter("fromJmesa") != null)
			{
			issueList =getIssueService().getTodaysIssues();
			}
		else
			{
			issueList = getIssueService().getAllIssue(issueDO);
				getServletRequest().getSession().setAttribute("issueSearchObject", issueDO);
			}
	
	
		setDeveloper(issueDO.getDeveloper());
		setIssueNo(issueDO.getIssueNo());
		setDateSign(issueDO.getDateSign());
		setSearchFromDate(issueDO.getSearchFromDate());
		setSearchToDate(issueDO.getSearchToDate());
		
		if (issueList==null)
		{
			issueList=new ArrayList<Issue>();
			boolean recoreNotFound = true;
			getServletRequest().setAttribute("recoreNotFound", recoreNotFound);
		}
		
		getServletRequest().setAttribute("issueList", issueList);
		
		String type = getServletRequest().getParameter("type");
		if (type != null && type.equals("basicExport"))
		{
			TableModel tableModel = new TableModel("issueSearch", getServletRequest(), getServletResponse());
			tableModel.setExportTypes(ExportType.JEXCEL);
			tableModel.setItems(issueList);
			Table table = new Table();
			Row row = new Row(); 
			table.setRow(row); 
			
			Column issueNo = new Column("issueNo"); 
			issueNo.setTitle("IssueNo");
			row.addColumn(issueNo);
			
			Column issueDate = new Column("issueDate"); 
			issueDate.setTitle("IssueDate");
			row.addColumn(issueDate);
			
			Column project  = new Column("project");
			project.setTitle("project");
			row.addColumn(project);  
			
			Column hours = new Column("hours"); 
			hours.setTitle("Hours");
			row.addColumn(hours);
			
			Column activity = new Column("activity"); 
			activity.setTitle("Activity");
			row.addColumn(activity);
			
			
			
			tableModel.setTable(table); 
			tableModel.render();
			return null;
		}
		
		//getServletRequest().getSession().removeAttribute("searchCriteria");
		//getServletRequest().getSession().removeAttribute("issueSearchObject");
		return SUCCESS;
	}
	}
	public void validate() 
	{
		if (getServletRequest().getParameter("isInvokedFromIssueSearch")!= null &&
			getServletRequest().getParameter("isInvokedFromIssueSearch").equals("true"))
		{
			 if (getDeveloper() != null &&
				 getDeveloper().isEmpty() &&
			     getIssueNo() != null &&
			     getIssueNo().isEmpty() &&
				 getDateSign() != null &&
				 getDateSign().isEmpty())
			 {
				getServletRequest().setAttribute("isFromSearch", "isFromSearch");
				addFieldError("searchFieldError","Atleast one search field is required");
			 }
		}
	}
	
	
	private IssueDO populateIssueDO() 
	{
		IssueDO issueDO = new IssueDO();
		
		issueDO.setDeveloper(getDeveloper());
		issueDO.setIssueNo(getIssueNo());
		issueDO.setDateSign(getDateSign());
		issueDO.setSearchFromDate(getSearchFromDate());
		issueDO.setSearchToDate(getSearchToDate());
		
		
		return issueDO;
		
	}

	public String getDateSign() {
		return dateSign;
	}

	public void setDateSign(String dateSign) {
		this.dateSign = dateSign;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public String getSearchFromDate() {
		return searchFromDate;
	}

	public void setSearchFromDate(String searchFromDate) {
		this.searchFromDate = searchFromDate;
	}

	public String getSearchToDate() {
		return searchToDate;
	}

	public void setSearchToDate(String searchToDate) {
		this.searchToDate = searchToDate;
	}
}
