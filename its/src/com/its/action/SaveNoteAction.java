package com.its.action;

import com.its.domain.Developer;
import com.its.domain.Note;

public class SaveNoteAction extends NoteAction
{

	public String execute() throws Exception
	{
	  saveNote();	
    return SUCCESS;		
	}
	
	private void saveNote() throws Exception
	{
		Note note=populateNote();	
	
	   getNoteService().saveNote(note);
	}
    private Note populateNote()
	 {
    	Note noteobj = new Note();
    	noteobj.setOid(this.getOid());
    	noteobj.setNote(this.getNote());
    	return noteobj; 
	 }
	
	public void validate()
	{
	
	
	if(!hasNote())
	{
    addFieldError("note","note is Required");		
	}
	}		
}    
