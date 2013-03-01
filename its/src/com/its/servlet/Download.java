package com.its.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Download
 */
public class Download extends HttpServlet 
{

	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Download() 
    {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		downloadFiles(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		downloadFiles(request, response);
	}
	private void downloadFiles(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
	{
		System.out.println("IN SIDE THE DOWNLOAD SERVLET");
	
		String filePath = request.getSession().getServletContext().getInitParameter("fileUploadPath");
		filePath = filePath + "\\";
		System.out.println("Source Folder Path :: "+filePath);
		FileInputStream fileToDownload = null;
		String fileName = request.getParameter("fileName");
		System.out.println("file Name ::::" + fileName);
		try
		{
			byte[] data = new byte[1024];
			System.out.println("File Folder Path::"+filePath);
			
			int countOfSelectedFiles = 0;
			List<String> selectedFilesList = new ArrayList<String>();
			if (fileName != null && !fileName.isEmpty() )
			{
				response.setContentType("application/text/plain");
				response.setHeader("Content-Disposition","attachment; filename=" + fileName); 
			}
			
			if (fileName != null && !fileName.isEmpty())
			{
				fileToDownload = new FileInputStream(filePath + fileName);
			}
			
			int c;
			while((c=fileToDownload.read()) != -1)
			{
				response.getOutputStream().write(c);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			fileToDownload.close();
		}
	}
}


