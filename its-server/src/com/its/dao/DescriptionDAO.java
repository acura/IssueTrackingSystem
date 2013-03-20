package com.its.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.its.domain.Description;
import com.its.domain.Project;
import com.its.exception.DAOException;

public class DescriptionDAO 
{
private SessionFactory sessionFactory;
	
	public Integer saveDescription(Description descriptionobj)
	throws DAOException
	{
		Integer txnOid = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			
			if (descriptionobj.getOid()!=null)
			{
				//Account accountDB = (Account)session.get(Account.class, account.getOid());
				Description descriptionDB = (Description)session.get(Description.class, descriptionobj.getOid());
				descriptionDB.setOid(descriptionobj.getOid());
				System.out.println("oid"+descriptionobj.getOid());
				
				descriptionDB.setIssue_No(descriptionobj.getIssue_No());
				System.out.println("oid"+descriptionobj.getIssue_No());
				
				descriptionDB.setDescription(descriptionobj.getDescription());
				System.out.println("oid"+descriptionobj.getDescription());
				
				session.update(descriptionDB);
			}
			else
			{
				txnOid = (Integer)session.save(descriptionobj);
			}
			session.flush();
			return txnOid;
		}
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}

	
	public Description getDescriptionByIssue_No(Integer issue_No)
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from Description descriptionobj " +
										"where descriptionobj.issue_No = " + issue_No);
			List<Description> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list.get(0): null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
	public Collection<Description> getAllDescription()
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from Description description " +
										"order by description.issue_No");
			List<Description> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list : null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
		
}
