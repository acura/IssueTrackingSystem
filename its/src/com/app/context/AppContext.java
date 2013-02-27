package com.app.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContext 
{
	private static ApplicationContext ctx;
	
	public static void setApplicationContext(ApplicationContext context)
	{
		ctx = context;
	}
	
	public static ApplicationContext getApplicationContext()
	{
		return ctx;
	}
	
	public static boolean hasApplicationContext()
	{
		return getApplicationContext() != null;
	}
	
	public static ApplicationContext loadApplicationContext() 
	{
		if (!hasApplicationContext())
		{
			ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("applicationContext.xml");
			setApplicationContext(appCtx);
		}
		
		return ctx;
	}
}
