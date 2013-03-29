package com.its.service;

import java.util.Collection;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.its.dao.NoteDAO;
import com.its.domain.Description;
import com.its.domain.Note;
import com.its.domain.Project;
import com.its.exception.DAOException;

public class NoteService
{
private NoteDAO noteDAO;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer saveNote(Note noteobj)
	throws DAOException
	{
		return noteDAO.saveNote(noteobj);
	}
	@Transactional(readOnly=true)
	public Note getNoteByOid(Integer oid)
	throws DAOException
	{
	  return noteDAO.getNoteByOid(oid);
	}
	
	@Transactional(readOnly=true)
	public Collection<Note> getAllNote()
	throws DAOException
	{
		return noteDAO.getAllNote();
	}
}
