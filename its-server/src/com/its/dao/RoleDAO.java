package com.its.dao;

import com.its.domain.Role;
import com.its.exception.DAOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



/**Copyright © 2010 by Acura Softwares, Pune, India.
 * RoleDAO : RoleDAO DAO
 */
@Transactional(propagation=Propagation.MANDATORY) 
public class RoleDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public RoleDAO() 
	{
		System.out.println("::: RoleDAO");
	}
	
	public Collection<Role> getRoles()
	throws DAOException
	{
		Session session = null;
		try 
		{
			session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
				session.createQuery("from Role role order by role.oid");
			List<Role> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list : null;
		}
		catch (Exception e)
		{
			throw new DAOException("Exception in RoleDAO.getRoles(): "+e.getMessage(),e);
		}
	}
	
	public Role getRoleByOid(Integer oid)
	throws DAOException
	{
		try 
		{
			Role role = (Role)sessionFactory.getCurrentSession().get(Role.class, oid);
			return role;
		}
		catch (Exception e)
		{
			throw new DAOException("Exception in RoleDAO.getRoleByOid(): "+e.getMessage(),e);
		}
	}
	
	public Role getRoleByRoleName(String roleName)
	throws DAOException
	{
		Session session = null;
		try 
		{
			session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = session.createQuery("from Role role " +
								"where role.roleName = '" + roleName + "'");
			List<Role> roleList = fromClauseQuery.list();
			return roleList != null && !roleList.isEmpty() ? roleList.get(0) : null;
		}
		catch (Exception e)
		{
			throw new DAOException("Exception in RoleDAO.getRoleByRoleName(): "+e.getMessage(),e);
		}
	}
	
	public boolean saveHMSRole(Role role)
	throws DAOException
	{
		Session session = null;
		try 
		{
			
			session = sessionFactory.getCurrentSession();
	
			if (role.getOid() != null)
			{
				Query deleteQuery = 
					session.createQuery("delete from RolePermission rolePermission " +
							"where rolePermission.role = " + role.getOid()+"");
				deleteQuery.executeUpdate();
				
				session.flush();
				// existing record. Only update
				Role roleDBObj = (Role)session.get(Role.class, new Integer(role.getOid()));
				roleDBObj.setOid(role.getOid());
				roleDBObj.setRoleName(role.getRoleName());
				roleDBObj.setRoleDescription(role.getRoleDescription());
				roleDBObj.setRolePermission(role.getRolePermission());
				session.update(roleDBObj);
			}	
			else
			{
				// new record. Insert.
				session.save(role);
			}
			session.flush();
			
			return true;
		}
		catch (Exception e)
		{
			throw new DAOException("Exception in RoleDAO.saveHMSRole(): "+e.getMessage(),e);
		}
	}

	public List<String> getSelectedPermissionListByOid(Integer oid)
	throws DAOException
	{
		Session session = null;
		List<String> rolePermissionsList = null;
		try
		{
			session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
				session.createQuery("select rolePermission.permissionName " +
									"from RolePermission rolePermission " +
									"where rolePermission.role = " + oid + "");
			fromClauseQuery.setCacheable(false);
			List<String> list = fromClauseQuery.list();
			if (list != null && !list.isEmpty())
			{
				rolePermissionsList = new ArrayList<String>(list);
			}
			return rolePermissionsList;
		}
		catch (Exception e)
		{
			throw new DAOException("Exception in RoleDAO.getSelectedPermissionListByOid(): "+e.getMessage(),e);
		}
	}
}
