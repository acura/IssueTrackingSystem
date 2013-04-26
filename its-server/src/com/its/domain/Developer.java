package com.its.domain;


public class Developer
{
	private Integer oid;
	public String developerName;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getOid() 
	{
		return oid;
	}
	public void setOid(Integer oid)
	{
		this.oid = oid;
	}
	public String getDeveloperName() 
	{
		return developerName;
	}
	public void setDeveloperName(String developerName) 
	{
		this.developerName = developerName;
	}
	
}