package com.its.action;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.app.context.AppContext;
import com.its.service.DeveloperService;
import com.its.service.ProjectService;
import com.its.util.GenericUtils;
import com.opensymphony.xwork2.ActionSupport;

public class ProjectAction extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
	
	private Integer oid;
	private String projectName;
	

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	


	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
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

	public ProjectService getProjectService()
	{
		return (ProjectService)AppContext.getApplicationContext().getBean("projectService");
	}
	
    public boolean hasOid()
   {
	return GenericUtils.isNotNull(getOid()); 
   }	 
   
   public boolean hasProjectName()
   {
	  return GenericUtils.isNotNullOrEmpty(getProjectName()); 
   }
   
    
}
