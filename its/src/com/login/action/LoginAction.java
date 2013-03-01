package com.login.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.its.action.AccountAction;
import com.its.domain.Account;
import com.its.domain.PortalConstant;
import com.its.util.GenericUtils;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends AccountAction
implements ServletRequestAware,ServletResponseAware, ServletContextAware
{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ServletContext servletContext;
	
	private String userId;
	private String password;
	private String loginValidation;
	private String signon;
	
	
	public String execute() throws Exception
	{
        if (getServletRequest().getParameter("signon") != null)	
        {
        	if (!hasUserId())
    		{
    			addFieldError("userId", "UserId is Required");
    		}
    		if (!hasPassword())
    		{
    			addFieldError("password", "Password is Required");
    		}
    		if (hasUserId() && hasPassword())
    		{
    			Account account = getAccountService().checkValidUser(getUserId(), getPassword());
    			
    			if (account != null)
    			{
    				getServletRequest().getSession().setAttribute(PortalConstant.ACCOUNT_ID, account.getAccountId());
    				getServletRequest().getSession().setAttribute("password", account.getPassword());
    			}
    			else
    			{
    				setUserId("");
    				addFieldError("loginValidation", "Invalid UserId OR Password");
    				return INPUT;
    			}
    			
    			return SUCCESS;
    		}
        }
        
		return INPUT;
	}
	
	/*public void validate()
	{
		if (!hasUserId())
		{
			addFieldError("userId", "UserId is Required");
		}
		if (!hasPassword())
		{
			addFieldError("password", "Password is Required");
		}
		if (hasUserId() && hasPassword())
		{
			if ()
			{
				
			}
			else
			{
				addFieldError("userId", "Invalid UserId OR Password");
			}
		}
	}*/
	
	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getLoginValidation()
	{
		return loginValidation;
	}

	public void setLoginValidation(String loginValidation) 
	{
		this.loginValidation = loginValidation;
	}
	
	public String getSignon()
	{
		return signon;
	}

	public void setSignon(String signon) 
	{
		this.signon = signon;
	}

	public boolean hasUserId()
	{
		return GenericUtils.isNotNullOrEmpty(getUserId());
	}
	public boolean hasPassword()
	{
		return GenericUtils.isNotNullOrEmpty(getPassword());
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
	
    public ServletContext getServletContext() 
    {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) 
	{
		this.servletContext = servletContext;
	}
	
	
	
}
