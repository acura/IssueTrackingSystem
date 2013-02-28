package com.its.action;
//modified on 28 feb
import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.its.util.DateUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.support.StaticApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.util.mail.EmailUtils;

// updated

//updated on 28
public class onDemandBackUpAction
extends ActionSupport
implements ServletRequestAware, ServletResponseAware
{
	public HttpServletRequest servletRequest;
	public HttpServletResponse servletResponse;


	public String execute()throws Exception
	{
		if (servletRequest.getParameter("isFromMenu") != null &&
			!servletRequest.getParameter("isFromMenu").isEmpty() &&
			servletRequest.getParameter("isFromMenu").equals("true"))
		{
			return SUCCESS;
		}
		else
		{
			Runtime r = Runtime.getRuntime();
			String backupFilePath=null;
			//String="C:/acura/backup/";
			
			backupFilePath = getServletRequest().getSession().getServletContext().getInitParameter("backupFilePath");
			
			if (!new File(backupFilePath).isDirectory())
		    {
				new File(backupFilePath).mkdirs();
				System.out.println("new File(backupFilePath).mkdirs() value"+new File(backupFilePath).mkdirs());
		    }
		     
			String recipients[]= {"amol.gadre@gmail.com","dalee.bisenmca@gmail.com"};
			String subject="Back Up";
			String bodyMessage="Back Up of Day";
			String from="Developer";
			//String attachment="acura-backup.sql.";
			Runtime rt = Runtime.getRuntime();
			String date = DateUtils.getDateAsDDMMYYYYWithTimestamp(new Date());
			date = date.replace("-","");
			date = date.replace(" ","");
			date = date.replace(":","");
			String attachment=backupFilePath+"its-backup-"+date+".sql";
			System.out.println("####### date: "+date);
			rt.exec("/C:/Program Files/MySQL/MySQL Server 5.1/bin/mysqldump -uroot -pjava its_system -r "+ attachment);
			//rt.exec("cmd /c mysqldump -uroot -pjava its_system > "+backupFilePath+"its-backup-"+date+".sql");
			getServletResponse().setContentType("text/html");
	        getServletResponse().setHeader("Cache-Control", "no-cache");
			
	        try
	        {
	        	
	            System.out.println("####### attachment:"+attachment);
	            EmailUtils.sendSSLMessage(recipients, subject,bodyMessage,from,attachment);
	        	getServletResponse().getWriter().write("");
	        }
	        catch (Exception e)
	        {
	        	e.printStackTrace();
	        	return ERROR;
	        }
	        
	      return SUCCESS;
		}
	}


	public HttpServletRequest getServletRequest() 
	{
		return servletRequest;
	}


	public void setServletRequest(HttpServletRequest servletRequest) 
	{
		this.servletRequest = servletRequest;
	}


	public HttpServletResponse getServletResponse() 
	{
		return servletResponse;
	}


	public void setServletResponse(HttpServletResponse servletResponse) 
	{
		this.servletResponse = servletResponse;
	}
	
}
