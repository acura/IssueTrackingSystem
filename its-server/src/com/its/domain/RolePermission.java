package com.its.domain;

public class RolePermission 
{
	private Integer oid;
	private String permissionName;
	private Role role;
	
	public Integer getOid() 
	{
		return oid;
	}
	
	public void setOid(Integer oid) 
	{
		this.oid = oid;
	}
	
	public String getPermissionName() 
	{
		return permissionName;
	}
	
	public void setPermissionName(String permissionName) 
	{
		this.permissionName = permissionName;
	}
	
	public Role getRole() 
	{
		return role;
	}
	
	public void setRole(Role role) 
	{
		this.role = role;
	}
	
	
}

