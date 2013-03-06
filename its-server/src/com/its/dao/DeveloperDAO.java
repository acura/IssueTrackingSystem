package com.its.dao;


import java.util.Collection;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.its.domain.Developer;
import com.its.exception.DAOException;
import com.its.util.DateUtils;
import com.its.util.GenericUtils;
@Transactional(propagation=Propagation.MANDATORY)
public class DeveloperDAO 
{
	//message//
	@Autowired
	private SessionFactory sessionFactory;
	
	public Integer saveDeveloper(Developer developer)
	throws DAOException
	{
		Integer txnOid = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			
			if (developer.getOid()!=null)
			{
				//Account accountDB = (Account)session.get(Account.class, account.getOid());
				Developer developerDB = (Developer)session.get(Developer.class, developer.getOid());
				//issueDB.setOid(issue.getOid());
				//System.out.println("oid"+developer.getOid());
				developerDB.setDeveloperName(developer.getDeveloperName());
				System.out.println("developer.getName()"+developer.getDeveloperName());
				session.update(developerDB);
			}
			else
			{
				txnOid = (Integer)session.save(developer);
			}
			session.flush();
			return txnOid;
		}
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}

	
	public Developer getDeveloperByOid(Integer oid)
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from Developer developer " +
										"where developer.oid = " + oid );
			List<Developer> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list.get(0): null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	

	public Collection<Developer> getAllDeveloper()
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from Developer developer " +
										"order by developer.oid");
			List<Developer> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list : null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
	public boolean deleteDeveloper(Integer oid)
	throws DAOException
	{
	  try
	  {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("delete from Developer developer where developer.oid="+oid);
			query.executeUpdate();
			session.flush();
			return true;
	 }
	 catch(Exception e)
	 {
		throw new DAOException("Exception in DeveloperDAO.DeleteDeveloper()"+e.getMessage(),e);
	 }
    }
		


}
