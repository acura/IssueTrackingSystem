package com.its.action;

import com.its.domain.Developer;

public class SaveDeveloperAction extends DeveloperAction
{

	public String execute() throws Exception
	{
	  saveDeveloper();	
    return SUCCESS;		
	}
	
	private void saveDeveloper() throws Exception
	{
		Developer developer=populateDeveloper();	
	
	   getDeveloperService().saveDeveloper(developer);
	}
    private Developer populateDeveloper()
	 {
    	Developer developerobj = new Developer();
    	developerobj.setOid(this.getOid());
    	developerobj.setDeveloperName(this.getDeveloperName());
    	return developerobj; 
	 }
	
	public void validate()
	{
	
	
	if(!hasName())
	{
    addFieldError("developerName","developerName is Required");		
	}
	}		
}    
