package com.app.context;

import com.its.dao.HibernateUtil;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ServerApplicationContextProvider 
implements ApplicationContextAware 
{


	public void setApplicationContext(ApplicationContext arg0)
	throws BeansException 
	{
		HibernateUtil.setApplicationContext(arg0);
	}

}
