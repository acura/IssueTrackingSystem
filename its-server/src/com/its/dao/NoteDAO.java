package com.its.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.its.domain.Description;
import com.its.domain.Note;
import com.its.domain.Project;
import com.its.exception.DAOException;

public class NoteDAO 
{
private SessionFactory sessionFactory;
	
	public Integer saveNote(Note note)
	throws DAOException
	{
		Integer txnOid = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			
			if (note.getOid()!=null)
			{
				//Account accountDB = (Account)session.get(Account.class, account.getOid());
				Note noteDB = (Note)session.get(Note.class, note.getOid());
				noteDB.setOid(note.getOid());
				System.out.println("oid"+note.getOid());
				
				noteDB.setIssueNumber(note.getIssueNumber());
				System.out.println("oid"+note.getIssueNumber());
				
				noteDB.setNote(note.getNote());
				System.out.println("oid"+note.getNote());
				
				session.update(noteDB);
			}
			else
			{
				txnOid = (Integer)session.save(note);
			}
			session.flush();
			return txnOid;
		}
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}

	
	public Note getNoteByOid(Integer oid)
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from Note note " +
										"where note.oid = " + oid);
			List<Note> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list.get(0): null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
	public Collection<Note> getAllNote()
	throws DAOException
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query fromClauseQuery = 
					session.createQuery("from Note note " +
										"order by note.oid");
			List<Note> list = fromClauseQuery.list();
			return list != null && !list.isEmpty() ? list : null;
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
	
		
}
