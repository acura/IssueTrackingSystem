package com.its.action;

import com.its.domain.Developer;
import com.its.domain.Project;

public class SaveProjectAction extends ProjectAction
{

	public String execute() throws Exception
	{
	  saveProject();	
    return SUCCESS;		
	}
	
	private void saveProject() throws Exception
	{
		Project project=populateProject();	
	
	   getProjectService().saveProject(project);
	}
    private Project populateProject()
	 {
    	Project projectobj = new Project();
    	projectobj.setOid(this.getOid());
    	projectobj.setProjectName(this.getProjectName());
    	return projectobj; 
	 }
	
	public void validate()
	{
	
	
	if(!hasProjectName())
	{
    addFieldError("project","projectName is Required");		
	}
	}		
}    
