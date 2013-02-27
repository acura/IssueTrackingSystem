package com.servlet;

import com.app.context.AppContext;
import com.its.dao.HibernateUtil;

import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;


public class DBStartUpServlet extends HttpServlet 
{
	/** Initialising the Logger */
	protected static final Logger logger=Logger.getLogger("com.servlet.DBStartUpServlet");

	public void init(ServletConfig config) throws ServletException 
	{
		try
		{
			System.out.println("\n**** Initializing Hibernate Init Servlet ********** \n");
			super.init(config);
	
			ApplicationContext ctx = AppContext.getApplicationContext();
			HibernateUtil.setApplicationContext(ctx);
			//HMSConstants.setHMSParameters();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	/** Handles the requests from http client.
	* @param request servlet requestge
	* @param response servlet response
	*/
	protected void service(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, java.io.IOException 
	{
	
	}

}
