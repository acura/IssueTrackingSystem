package com.its.dao;
 
import java.util.Calendar;
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
import com.its.domain.Issue;
import com.its.domain.NewIssue;
import com.its.exception.DAOException;
import com.its.util.DateUtils;
import com.its.util.GenericUtils;
@Transactional(propagation=Propagation.MANDATORY)
public class UpdateDAO 
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
			if (newIssue.getIssueNumber() !=null)
			{
				NewIssue newIssueDB = (NewIssue)session.get(NewIssue.class, newIssue.getIssueNumber());
				
				if (newIssueDB != null)
				{
					//Account accountDB = (Account)session.get(Account.class, account.getOid());
					
					newIssueDB.setSystem(newIssue.getPriority());
					newIssueDB.setEstimatedHours(newIssue.getEstimatedHours());
					newIssueDB.setActualStartDate(newIssue.getActualStartDate());
					newIssueDB.setActualEndDate(newIssue.getActualEndDate());
					newIssueDB.setTargetVersion(newIssue.getTargetVersion());
					newIssueDB.setAssignedTo(newIssue.getAssignedTo());
					
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
	
	public Integer saveIssues(Issue issue)
	throws DAOException
	{
		Integer txnOid = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			
			if (issue.getOid()!=null)
			{
				//Account accountDB = (Account)session.get(Account.class, account.getOid());
				Issue issueDB = (Issue)session.get(Issue.class, issue.getOid());
				//issueDB.setOid(issue.getOid());
				System.out.println("oid"+issue.getOid());
				issueDB.setHours(issue.getHours());
				System.out.println("issue.getHour()"+issue.getHours());
				issueDB.setActivity(issue.getActivity());
				System.out.println("issue.getActivity()"+issue.getActivity());
				issueDB.setComment(issue.getComment());
				System.out.println("issue.getComment()"+issue.getComment());
				System.out.println("issueDB"+issueDB);
				session.update(issueDB);
			}
			else
			{
				txnOid = (Integer)session.save(issue);
			}
			session.flush();
			return txnOid;
		}
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}


	public Collection<NewIssue> getAllNewIssue()
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from NewIssue newIssue " +
										"order by newIssue.oid");
			List<NewIssue> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list : null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
	public Collection<Issue> getAllIssue()
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from Issue issue " +
										"order by issue.oid");
			List<Issue> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list : null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
	
	public NewIssue getNewIssueByOid(Integer oid)
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from NewIssue newIssue " +
										"where newIssue.oid = " +oid );
			List<NewIssue> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list.get(0): null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
	
	
	public boolean deleteNewIssues(Integer oid)
	throws DAOException
	{
	  try
	  {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("delete from NewIssue newIssue where newIssue.oid="+oid);
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
										"order by newIssue.oid");
			List<NewIssue> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list : null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
		


}
