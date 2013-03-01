package com.its.dao;


import com.its.exception.DAOException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**Copyright © 2010 by Acura Softwares, Pune, India.
 *AuthenticationDAO : DAO 
 */

@Transactional(propagation=Propagation.MANDATORY) 
public class AuthenticationDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public AuthenticationDAO()
	{
		System.out.println("::: AuthenticationDAO");
	}
	
	/*public HMSUser authenticateCredentials(String userName, String password)
	throws DAOException
	{
		Session session = null;
		try 
		{
			session = sessionFactory.getCurrentSession();	
			Query fromClauseQuery = 
			session.createQuery("from HMSUser user where user.userId ='" + userName + "' and user.password = '" + password + "'");
			List<HMSUser> list = fromClauseQuery.list();
			
			if (list != null && !list.isEmpty())
			{
				return list.get(0);	
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			throw new DAOException("Exception in AuthenticationDAO.authenticateCredentials(): "+e.getMessage(),e);
		}
	}*/
	
	/*public HMSUser validateUserCredentials (String userId, String password)
	throws DAOException
	{
		Session session = null;
		try 
		{
			session = sessionFactory.getCurrentSession();	
			Query fromClauseQuery = 
			session.createQuery("from HMSUser hmsUser where hmsUser.userId ='" + userId + "' and hmsUser.password = '" + password + "'");
			List<HMSUser> list = fromClauseQuery.list();
			
			if (list != null && !list.isEmpty())
			{
				return list.get(0);	
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			throw new DAOException("Exception in AuthenticationDAO.validateUserCredentials(): "+e.getMessage(),e);
		}
	}*/
}
