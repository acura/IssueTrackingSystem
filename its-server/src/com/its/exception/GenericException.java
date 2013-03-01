package com.its.exception;

public class GenericException extends Exception 
{
	private String message;
	private boolean isHandledException;
	
	/**
	 * 
	 */
	public GenericException() 
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public GenericException(String arg0, boolean isHandledException) 
	{
		super(arg0);
		this.message = arg0;
		this.isHandledException = isHandledException;
	}

	/**
	 * @param arg0
	 */
	public GenericException(Throwable arg0) 
	{
		super(arg0);
		this.isHandledException = false;
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public GenericException(String arg0, Throwable arg1) 
	{
		super(arg0, arg1);
		this.message = arg0;
		this.isHandledException = false;
	}

	public String getMessage() 
	{
		return message;
	}

	public void setMessage(String message) 
	{
		this.message = message;
	}

	public boolean isHandledException() 
	{
		return isHandledException;
	}

	public void setHandledException(boolean isHandledException) 
	{
		this.isHandledException = isHandledException;
	}
}
