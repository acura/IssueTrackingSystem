package com.its.domain;

import java.util.List;

public class Role 
{
	private Integer oid;
	private String  roleName;
	private String roleDescription;
	
	private List<RolePermission> rolePermission;
	
	public Integer getOid() 
	{
		return oid;
	}
	
	public void setOid(Integer oid) 
	{
		this.oid = oid;
	}

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName(String roleName) 
	{
		this.roleName = roleName;
	}

	public String getRoleDescription() 
	{
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) 
	{
		this.roleDescription = roleDescription;
	}

	public List<RolePermission> getRolePermission()
	{
		return rolePermission;
	}

	public void setRolePermission(List<RolePermission> rolePermission) 
	{
		this.rolePermission = rolePermission;
	}
	
	
	
}
