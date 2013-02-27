package com.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthenticationFilter implements Filter
{	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
	throws IOException, ServletException 
	{           
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		//Get the IP address of client machine.         
		String ipAddress = request.getRemoteAddr();           
		//Log the IP address and current timestamp.         
		System.out.println("IP "+ipAddress + ", Time "  + new Date().toString());           
		
		System.out.println("::::: AuthenticationFilter Request URI: " + request.getRequestURI());
		
		/*if (request.getSession() != null && request.getSession().getAttribute(HMSConstants.USER_OBJECT) != null)
		{
			chain.doFilter(req, res);	
		}		
		else
		{
			if (!request.getRequestURI().contains("hms/prolabLogin") && 
				!request.getRequestURI().contains("viewTestRecordsByUser") &&
				!request.getRequestURI().contains("hms/prolabLogout"))
				response.sendRedirect("../.." + request.getContextPath() + "/login/login.action");
			else
				chain.doFilter(req, res);
		}*/
		chain.doFilter(req, res);
	}     
	
	public void init(FilterConfig config) throws ServletException 
	{           
		//Get init parameter         
		String testParam = config.getInitParameter("test-param");           
		//Print the init parameter         
		System.out.println("Test Param: " + testParam);     
	}     
	
	public void destroy() 
	{         
		//add code to release any resource     
	}

}
