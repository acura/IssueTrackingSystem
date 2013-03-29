package com.its.dao;


import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.its.domain.Project;
import com.its.exception.DAOException;
@Transactional(propagation=Propagation.MANDATORY)
public class ProjectDAO 
{
	//message//
	@Autowired
	private SessionFactory sessionFactory;
	
	public Integer saveProject(Project project)
	throws DAOException
	{
		Integer txnOid = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			
			if (project.getOid()!=null)
			{
				//Account accountDB = (Account)session.get(Account.class, account.getOid());
				Project projectDB = (Project)session.get(Project.class, project.getOid());
				//issueDB.setOid(issue.getOid());
				//System.out.println("oid"+developer.getOid());
				projectDB.setProjectName(project.getProjectName());
				System.out.println("project.getProjectName()"+project.getProjectName());
				session.update(projectDB);
			}
			else
			{
				txnOid = (Integer)session.save(project);
			}
			session.flush();
			return txnOid;
		}
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}

	
	public Project getProjectByOid(Integer oid)
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from Project project " +
										"where project.oid = " + oid );
			List<Project> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list.get(0): null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	

	public Collection<Project> getAllProject()
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from Project project " +
										"order by project.oid");
			List<Project> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list : null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
	
	
	public boolean deleteProject(Integer oid)
	throws DAOException
	{
	  try
	  {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("delete from Project project where project.oid="+oid);
			query.executeUpdate();
			session.flush();
			return true;
	 }
	 catch(Exception e)
	 {
		throw new DAOException("Exception in ProjectDAO.DeleteProject()"+e.getMessage(),e);
	 }
    }
	
	public List<Project> getAllProjectList()
	throws DAOException
	{
		Session session = null;
		try 
		{
			session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = session.createQuery("from Project project order by project.projectName");
			fromClauseQuery.setCacheable(false);
			List<Project> list = fromClauseQuery.list();
			
			return list != null && !list.isEmpty() ? list : null;
		} 
		
		catch (Exception e) 
		{
			throw new DAOException("Exception in ProjectDAO :"+ e.getMessage(), e);
		}
	}
		


}
