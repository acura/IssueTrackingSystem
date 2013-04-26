package com.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.app.context.AppContext;
import com.its.domain.Developer;
import com.its.exception.DAOException;
import com.its.service.DeveloperService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport 
implements ServletRequestAware, ServletResponseAware 
{
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	
	public DeveloperService getDeveloperService()
	{
		return (DeveloperService)AppContext.getApplicationContext().getBean("developerService");
	}

	public String execute() throws DAOException
	{
		if (getServletRequest().getParameter("signOn") != null &&
			!getServletRequest().getParameter("signOn").isEmpty() &&
			getServletRequest().getParameter("signOn").equalsIgnoreCase("true"))
		{
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			Developer developer = getDeveloperService().checkValidlogin(userName,password);
			
			if(developer != null && 
			   (developer.getDeveloperName().equals(userName)&&developer.getPassword().equals(password)))
				{
					System.out.println("login successfully");
					return SUCCESS;
				}
			else
    			{
    				setuserName("");
    				addFieldError("loginValidation", "Invalid UserId OR Password");
    				return INPUT;
    			}
			
		}
		return INPUT;
	}
	                                                      
	private String userName;
	private String password;
	
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	private boolean hasUsername()
	{
		return getUserName() != null && !getUserName().isEmpty();
	}
	
	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	private boolean hasPassword()
	{
		return getPassword()!= null && !getPassword().isEmpty();
	}

	public void validate()
	{
		
		if (getServletRequest().getParameter("signOn") != null) 
		{
		   if (!hasUsername()) 
		   {
			  addFieldError("userName", "User Name required");
		   }	
		   if (!hasPassword()) 
		   {
			  addFieldError("password", "Password is required");
		   }
		}
		
 	}

		private void setuserName(String string)
		{
		// TODO Auto-generated method stub
		
	     }

		public void setServletRequest(HttpServletRequest request)
    {
        this.request = request;
    }

    public HttpServletRequest getServletRequest()
    {
        return request;
    }

    public void setServletResponse(HttpServletResponse response)
    {
        this.response = response;
    }

    public HttpServletResponse getServletResponse()
    {
        return response;
    } 
	
}
