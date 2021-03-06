package com.its.dao;
 
import com.its.domain.NewIssue;
import com.its.exception.DAOException;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(propagation=Propagation.MANDATORY)
public class NewIssueDAO 
{
	//message//
	@Autowired
	private SessionFactory sessionFactory;
	
	public Integer saveNewIssues(NewIssue newIssue)
	throws DAOException
	{
		Integer txnOid = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			if (newIssue.getIssueNumber() != null)
			{
				NewIssue newIssueDB = (NewIssue)session.get(NewIssue.class, newIssue.getIssueNumber());
				if (newIssueDB != null)
				{
					//Account accountDB = (Account)session.get(Account.class, account.getOid());
					
					//issueDB.setOid(issue.getOid());
					newIssueDB.setIssueNumber(newIssue.getIssueNumber());
					
					newIssueDB.setSummary(newIssue.getSummary());
					newIssueDB.setDetail(newIssue.getDetail());
					newIssueDB.setSystem(newIssue.getSystem());
					newIssueDB.setDetail(newIssue.getSeverity());
					newIssueDB.setSystem(newIssue.getPriority());
					newIssueDB.setEstimatedStartDate(newIssue.getEstimatedStartDate());
					newIssueDB.setEstimatedEndDate(newIssue.getEstimatedEndDate());
					newIssueDB.setEstimatedHours(newIssue.getEstimatedHours());
					System.out.println("newIssue.getEstimatedHours()"+newIssue.getEstimatedHours());
					System.out.println("newIssueDB"+newIssueDB);
					newIssueDB.setActualStartDate(newIssue.getActualStartDate());
					newIssueDB.setActualEndDate(newIssue.getActualEndDate());
					newIssueDB.setLoggedBy(newIssue.getLoggedBy());
					newIssueDB.setStatus(newIssue.getStatus());
					newIssueDB.setTargetVersion(newIssue.getTargetVersion());
					newIssueDB.setAssignedTo(newIssue.getAssignedTo());
					newIssueDB.setIssue(newIssue.getIssue());
					session.update(newIssueDB);
				}
				else
				{
					txnOid = (Integer)session.save(newIssue);
				}
			}
			
			session.flush();
			return txnOid;
		}
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	

	/*public NewIssue getNewIssueByOid(int oid)
		throws DAOException
		{
			try
			{
				NewIssue newIssueDomain = (NewIssue)sessionFactory.getCurrentSession().get(NewIssue.class, oid);
				return newIssueDomain;
			}
			catch (Exception e)
			{
				throw new DAOException("Exception in NewIssueDAO.getNewIssueByOid(): "
										+e.getMessage(),e);
			}
		}*/

	public Collection<NewIssue> getAllNewIssue()
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from NewIssue newIssue " +
										"order by newIssue.issueNumber");
			List<NewIssue> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list : null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
	public NewIssue getNewIssueByOid(Integer issueNumber)
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from NewIssue newIssue " +
										"where newIssue.issueNumber = " +issueNumber );
			List<NewIssue> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list.get(0): null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
	public NewIssue getNewIssueByissueNumber(Integer issueNumber)
	throws DAOException
	{
		NewIssue newIssueObject = null;
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			
			newIssueObject = (NewIssue)session.get(NewIssue.class, issueNumber);
			return newIssueObject;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
	
	public boolean deleteNewIssues(Integer issueNumber)
	throws DAOException
	{
	  try
	  {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("delete from NewIssue newIssue where newIssue.issueNumber="+issueNumber);
			query.executeUpdate();
			session.flush();
			return true;
	 }
	 catch(Exception e)
	 {
		throw new DAOException("Exception in NewIssueDAO.DeleteIssue()"+e.getMessage(),e);
	 }
    }
	
	public Collection<NewIssue> getAllProjectList()
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from NewIssue newIssue " +
										"order by newIssue.issueNumber");
			List<NewIssue> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list : null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
	public Collection<NewIssue> getAllDeveloperList()
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from NewIssue newIssue " +
										"order by newIssue.issueNumber");
			List<NewIssue> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list : null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	


}
