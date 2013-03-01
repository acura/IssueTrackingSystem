package com.its.service;

/**Copyright © 2010 by Acura Softwares, Pune, India.
 * RoleService : RoleService Class
 */

import com.its.dao.RoleDAO;
import com.its.domain.Role;
import com.its.exception.DAOException;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class RoleService 
{
	@Autowired
	private RoleDAO roleDAO;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean saveHMSRole(Role user)
	throws DAOException
	{
		return roleDAO.saveHMSRole(user);
	}

	@Transactional(readOnly=true)
	public Role getRoleByOid(Integer oid)
	throws DAOException
	{
		return roleDAO.getRoleByOid(oid);
	}
	
	@Transactional(readOnly=true)
	public Collection<Role> getRoles()
	throws DAOException
	{
		return roleDAO.getRoles();
	}

	@Transactional(readOnly=true)
	public List<String> getSelectedPermissionListByOid(Integer oid)
	throws DAOException
	{
		return roleDAO.getSelectedPermissionListByOid(oid);
	}

}
