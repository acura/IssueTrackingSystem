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
import com.its.domain.NewIssue;
import com.its.exception.DAOException;
import com.its.util.DateUtils;
import com.its.util.GenericUtils;
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
			
			if (newIssue.getOid()!=null)
			{
				//Account accountDB = (Account)session.get(Account.class, account.getOid());
				NewIssue newIssueDB = (NewIssue)session.get(NewIssue.class, newIssue.getOid());
				//issueDB.setOid(issue.getOid());
				System.out.println("oid"+newIssue.getOid());
				newIssueDB.setIssueNo(newIssue.getIssueNo()!=null?newIssue.getIssueNo():"");
				System.out.println("newIssue.getIssueNo()"+newIssue.getIssueNo());
				
				newIssueDB.setSummary(newIssue.getSummary());
				System.out.println("newIssue.getSummary()"+newIssue.getSummary());
				newIssueDB.setDetail(newIssue.getDetail());
				System.out.println("newIssue.getDetail()"+newIssue.getDetail());
				newIssueDB.setSystem(newIssue.getSystem());
				System.out.println("newIssue.getSystem()"+newIssue.getSystem());
				newIssueDB.setDetail(newIssue.getSeverity());
				System.out.println("newIssue.getSeverity()"+newIssue.getSeverity());
				newIssueDB.setSystem(newIssue.getPriority());
				System.out.println("newIssue.getPriority()"+newIssue.getPriority());
				newIssueDB.setEstimatedStartDate(newIssue.getEstimatedStartDate());
				System.out.println("newIssue.getEstimatedStartDate()"+newIssue.getEstimatedStartDate());
				newIssueDB.setEstimatedEndDate(newIssue.getEstimatedEndDate());
				System.out.println("newIssue.getEstimatedEndDate()"+newIssue.getEstimatedEndDate());
				newIssueDB.setEstimatedHours(newIssue.getEstimatedHours());
				System.out.println("newIssue.getEstimatedHours()"+newIssue.getEstimatedHours());
				System.out.println("newIssueDB"+newIssueDB);
				newIssueDB.setActualStartDate(newIssue.getActualStartDate());
				newIssueDB.setActualEndDate(newIssue.getActualEndDate());
				newIssueDB.setLoggedBy(newIssue.getLoggedBy());
				newIssueDB.setTargetVersion(newIssue.getTargetVersion());
				newIssueDB.setAssignedTo(newIssue.getAssignedTo());
				session.update(newIssueDB);
			}
			else
			{
				txnOid = (Integer)session.save(newIssue);
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
		


}
