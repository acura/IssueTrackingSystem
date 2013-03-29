package com.its.action;

import com.its.domain.Developer;
import com.its.domain.Note;
import com.its.util.GenericUtils;

public class RetrieveNoteAction extends NoteAction
{
	public String execute() throws Exception
	{
		
		String oid = getServletRequest().getParameter("oid");
		
		if (GenericUtils.isNotNullOrEmpty(oid))
		{
			
			Note noteObj = getNoteService().getNoteByOid(Integer.parseInt(oid));	
			this.setOid(noteObj.getOid());
			this.setNote(noteObj.getNote());
		
			
		}
		else
		{
	      getServletRequest().getSession().removeAttribute("noteSearchObject");
		}
		//int oid1=Integer.parseInt(oid);
		//getIssueService().deleteIssuesBy(5);
	 return SUCCESS;	
	 }
	}
