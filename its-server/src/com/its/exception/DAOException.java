/**
 * 
 */
package com.its.exception;


/**
 * @author Amolg.
 *
 */
public class DAOException extends GenericException 
{
	public DAOException() 
	{
		super();
	}

	public DAOException(String arg0, boolean isHandledException) 
	{
		super(arg0, isHandledException);
	}

	public DAOException(Throwable arg0) 
	{
		super(arg0);
		super.setHandledException(false);
	}

	public DAOException(String arg0, Throwable arg1) 
	{
		super(arg0, arg1);
		super.setHandledException(false);
	}
}
