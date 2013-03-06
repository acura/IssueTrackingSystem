package com.its.action;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.app.context.AppContext;
import com.its.service.DeveloperService;
import com.its.util.GenericUtils;
import com.opensymphony.xwork2.ActionSupport;

public class DeveloperAction extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
	
	private Integer oid;
	private String developerName;
	
	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	
	
	public String getDeveloperName() 
	{
		return developerName;
	}

	public void setDeveloperName(String developerName) 
	{
		this.developerName = developerName;
	}



	private HttpServletRequest servletRequest;
	private HttpServletResponse servletResponse;
	

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	public HttpServletResponse getServletResponse() {
		return servletResponse;
	}

	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
	}


	public DeveloperService getDeveloperService()
	{
		return (DeveloperService)AppContext.getApplicationContext().getBean("developerService");
	}
	
    public boolean hasOid()
   {
	return GenericUtils.isNotNull(getOid()); 
   }	 
   
   public boolean hasName()
   {
	  return GenericUtils.isNotNullOrEmpty(getDeveloperName()); 
   }
   
    
}
