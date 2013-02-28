package com.its.dao;
<<<<<<< HEAD
//updated 28feb 
=======

//update on 28 feb

//updated 28feb

>>>>>>> 0325604ed5ca1b8282899e99ece598c1371341a6
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

import com.its.domain.Account;
import com.its.domain.Issue;
import com.its.domain.IssueDO;
import com.its.exception.DAOException;
import com.its.util.DateUtils;
import com.its.util.GenericUtils;
@Transactional(propagation=Propagation.MANDATORY)
public class IssueDAO 
{
	//message//
	@Autowired
	private SessionFactory sessionFactory;
	
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
				issueDB.setDeveloper(issue.getDeveloper());
				System.out.println("issue.getDeveloper()"+issue.getDeveloper());
				issueDB.setProject(issue.getProject());
				System.out.println("issue.getProject()"+issue.getProject());
				issueDB.setIssueNo(issue.getIssueNo()!=null?issue.getIssueNo():"");
				System.out.println("issue.getIssueNo()"+issue.getIssueNo());
				issueDB.setIssueDate(issue.getIssueDate());
				System.out.println("issue.getDate()"+issue.getIssueDate());
				issueDB.setHours(issue.getHours());
				System.out.println("issue.getHour()"+issue.getHours());
				issueDB.setActivity(issue.getActivity());
				System.out.println("issue.getActivity()"+issue.getActivity());
				issueDB.setComment(issue.getComment());
				System.out.println("issue.getComment()"+issue.getComment());
				System.out.println("issueDB"+issueDB);
				issueDB.setLastUpdatedDate(issue.getLastUpdatedDate());
				issueDB.setCreatedDate(issue.getCreatedDate());
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

	public Collection<Issue> getTodaysIssues()
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from Issue issue  where(date(issue.createdDate)=  ' " +DateUtils.getDateAsYYYYMMDD(new Date())+"'"+
							"and date(issue.lastUpdatedDate)= "   + null  + " ) or( date(issue.lastUpdatedDate)= ' " + DateUtils.getDateAsYYYYMMDD(new Date())+ " ')"+
							"order by IFNULL(issue.lastUpdatedDate,issue.createdDate) desc");
					
			List<Issue> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list : null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
		}
	public Issue getIssueByOid(Integer oid)
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from Issue issue " +
										"where issue.oid = " + oid );
			List<Issue> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list.get(0): null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
	
	
	public boolean deleteIssuesBy(Integer oid)
	throws DAOException
	{
	  try
	  {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("delete from Issue issue where issue.oid="+oid);
			query.executeUpdate();
			session.flush();
			return true;
	 }
	 catch(Exception e)
	 {
		throw new DAOException("Exception in IssueDAO.DeleteIssue()"+e.getMessage(),e);
	 }
    }
	public Collection<Issue> getAllIssue(IssueDO issueDO)throws DAOException
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Date today = new Date();
			
			String strSQL = "from Issue issue " +
							"where 1=1 ";
					
							if(issueDO.getDeveloper() != null && !issueDO.getDeveloper().isEmpty())
							{
								strSQL +=" and issue.developer like  '"+ issueDO.getDeveloper() +"%' ";
							}
							
							if(issueDO.getIssueNo() != null && !issueDO.getIssueNo().isEmpty())
							{
								/*System.out.println("inside issue DAO");
								Issue issueobj=new Issue();	
								String issueno=issueobj.getIssueNo();
								String issue[]=issueno.split("-");
								System.out.println("issue[0]"+issue[0]);
								System.out.println("issue[1]"+issue[1]);*/
								strSQL +=" and issue.issueNo like '"+ issueDO.getIssueNo() +"'";
							}
							
							if(issueDO.getDateSign() != null && !issueDO.getDateSign().isEmpty())
							{
								Calendar calOfMonth = Calendar.getInstance();
								calOfMonth.setTime(today);
								Date startDateOfMonth = null;
								Date endDateOfMonth = null;
								int currentYear = calOfMonth.get(Calendar.YEAR);
								int currentMonth = calOfMonth.get(Calendar.MONTH);
								
								int numOfDaysInMonth = calOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
								
								if(issueDO.getDateSign().equals("="))
								{
									strSQL += " and date(issue.issueDate) = '" + DateUtils.getDateAsYYYYMMDD(DateUtils.getStringAsDate(issueDO.getSearchFromDate()))+ "' ";
								}
								if(issueDO.getDateSign().equals("<"))
								{
									strSQL += " and date(issue.issueDate) < '" + DateUtils.getDateAsYYYYMMDD(DateUtils.getStringAsDate(issueDO.getSearchFromDate()))+ "' ";
								}
								if(issueDO.getDateSign().equals(">"))
								{
									strSQL += " and date(issue.issueDate) > '" + DateUtils.getDateAsYYYYMMDD(DateUtils.getStringAsDate(issueDO.getSearchFromDate()))+ "' ";
								}
								if(issueDO.getDateSign().equals(">="))
								{
									strSQL += " and date(issue.issueDate) >= '" + DateUtils.getDateAsYYYYMMDD(DateUtils.getStringAsDate(issueDO.getSearchFromDate()))+ "' ";
								}
								if(issueDO.getDateSign().equals("<="))
								{
									strSQL += " and date(issue.issueDate) <= '" + DateUtils.getDateAsYYYYMMDD(DateUtils.getStringAsDate(issueDO.getSearchFromDate()))+ "' ";
								}
								if(issueDO.getDateSign().equals("<>"))
								{
									strSQL += " and date(issue.issueDate) >= '" + DateUtils.getDateAsYYYYMMDD(DateUtils.getStringAsDate(issueDO.getSearchFromDate()))+ "' ";
									strSQL += " and date(issue.issueDate) <= '" + DateUtils.getDateAsYYYYMMDD(DateUtils.getStringAsDate(issueDO.getSearchToDate()))+ "' ";
								}  
								    						
							}
							strSQL +=" order by issue.issueDate desc";
							
							/*if (issueDO.getPatientId() != null && !issueDO.getPatientId().isEmpty())
							{
								strSQL += " and issue.user.userId = '" + issueDO.getPatientId() + "'";
							}*/
						    
							
							/*strSQL += " order by issue.issueNo";*/
							
							//strSQL += " order by IFNULL(issue.lastUpdatedDate, issue.createdDate) desc ";
			
			Query fromQuery = session.createQuery(strSQL);
			fromQuery.setCacheable(false);
			
			Collection<Issue> list = fromQuery.list();
		
			return list != null && !list.isEmpty() ? list : null;
		}
		catch (Exception e)
		{
			throw new DAOException("Exception in IssueDAO : getAllIssue "+ e.getMessage(), e);
		}
	}
	


}
