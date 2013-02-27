package com.its.dao;

import com.its.util.DateUtils;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateUtil 
{
	private static SessionFactory sessionFactory;
	private static Calendar serverDateCalendar;
	private static ApplicationContext context;
	
	static
	{
		serverDateCalendar = Calendar.getInstance();
		serverDateCalendar.setTime(new Date());
		serverDateCalendar.set(serverDateCalendar.get(Calendar.YEAR), 
								serverDateCalendar.get(Calendar.MONTH), 
								 serverDateCalendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
	}
	
	public static void setApplicationContext(ApplicationContext ctx)
	{
		context = ctx;
	}
	
	public static ApplicationContext getApplicationContext()
	{
		return context;
	}
	
	public static boolean hasApplicationContext()
	{
		return getApplicationContext() != null;
	}

	public static SessionFactory getSessionFactory() 
	{
		Calendar todaysCal = Calendar.getInstance();
		todaysCal.setTime(new Date());
		todaysCal.set(todaysCal.get(Calendar.YEAR), todaysCal.get(Calendar.MONTH), todaysCal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		
		if (!hasApplicationContext() || !(DateUtils.equalDates(todaysCal, serverDateCalendar)))
		{
			serverDateCalendar.setTime(todaysCal.getTime());
			//configure();
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//			ctx.refresh();
			setApplicationContext(ctx);
			sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		}
		
		if (sessionFactory == null)
		{
			sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		}
		
		return sessionFactory;
	}
	
	/**
	 * This is old code being kept for reference.
	 * It may be removed after some days... Amol.
	 */
	// Create the initial SessionFactory from the default configuration files
	/*public static void configure()
	{
		try 
		{
//			String path_properties = appHome+File.separatorChar+"hibernate.cfg.xml";
			Configuration configuration = new Configuration();
//			configuration.addFile(path_properties);
			sessionFactory = configuration.configure().buildSessionFactory();
		} 
		catch (Throwable ex) 
		{
			System.out.println("**************** ERROR In Hibernate Initialization ******************");
			System.out.println("ex: " + ex);
			System.out.println("***************************************");
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static Session getSession()
	{
		Session s = (Session) threadSession.get();
		// logger.debug("session"+s);
		if (s == null) 
		{
			s = getSessionFactory().openSession();
			threadSession.set(s);
			// logger.debug("session 1 $"+s);
		}
		return s;
		return getNewSession();
	}
	
	public static Session getNewSession()
	{
//		return getSessionFactory().getCurrentSession();
		return getSessionFactory().openSession();
	}
	
	public static void closeSession(Session s)
	{
		if (s != null && s.isOpen())
		{
			s.close();
			s = null;
		}
	}*/
	
}
