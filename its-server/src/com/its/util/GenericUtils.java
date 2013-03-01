package com.its.util;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class GenericUtils 
{
	public static String buildMonthOptions(String ctrl)
	{
		String strBuff = "<select name=\"" + ctrl + "\">" +
							"<option value=\"\"></option>" +
							"<option value=\"Jan\">Jan</option>" +
							"<option value=\"Feb\">Feb</option>" +
							"<option value=\"Mar\">Mar</option>" +
							"<option value=\"Apr\">Apr</option>" +
							"<option value=\"May\">May</option>" +
							"<option value=\"Jun\">Jun</option>" +
							"<option value=\"Jul\">Jul</option>" +
							"<option value=\"Aug\">Aug</option>" +
							"<option value=\"Sep\">Sep</option>" +
							"<option value=\"Oct\">Oct</option>" +
							"<option value=\"Nov\">Nov</option>" +
							"<option value=\"Dec\">Dec</option>" +
						  "</select>";
	    System.out.println("Month :"+strBuff);
		return strBuff;
	}
	
	public static String buildNumericMonthOptions(String ctrl)
	{
		String strBuff = "<select name=\""+ ctrl +"\">" +
							"<option value=></option>" +
							"<option value=\"1\">Jan</option>" +
							"<option value=\"2\">Feb</option>" +
							"<option value=\"3\">Mar</option>" +
							"<option value=\"4\">Apr</option>" +
							"<option value=\"5\">May</option>" +
							"<option value=\"6\">Jun</option>" +
							"<option value=\"7\">Jul</option>" +
							"<option value=\"8\">Aug</option>" +
							"<option value=\"9\">Sep</option>" +
							"<option value=\"10\">Oct</option>" +
							"<option value=\"11\">Nov</option>" +
							"<option value=\"12\">Dec</option>" +
						  "</select>";
		System.out.println("Month :"+strBuff);
		return strBuff;
	}
	
	public static String buildYearsOptions(String ctrl, String onfocus)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int yyyy = cal.get(Calendar.YEAR);
		String tmp = "<select name=\"" + ctrl + "\" " + onfocus + ">" +
						"<option value=\"\"></option>";
		for (int year=yyyy; year >= yyyy-1; year --)
		{
			tmp += "<option value=\"" + year + "\">" + year + "</option>";
		}
		tmp += "</select>";
	    System.out.println("Year :"+tmp);	
		return tmp;
	}
		
	/*public static String buildYearsOptions(String ctrl, String selectedOption, String onfocus)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int yyyy = cal.get(Calendar.YEAR);
		String tmp = "<select name=\"" + ctrl + "\" " + onfocus + ">" +
						"<option value=\"\"></option>";
		if (selectedOption != null && !selectedOption.isEmpty())
		{
			for (int year=yyyy; year >= yyyy-1; year --)
			{
				if (selectedOption.trim().equals(new Integer(year).toString()))
					tmp += "<option value=\"" + year + "\" selected=\"selected\">" + year + "</option>";
				else
					tmp += "<option value=\"" + year + "\">" + year + "</option>";
			}
		}
		else
		{
			for (int year=yyyy; year >= yyyy-1; year --)
			{
				tmp += "<option value=\"" + year + "\">" + year + "</option>";
			}
		}
		tmp += "</select>";
		
		return tmp;
	}
	*/
	public static boolean isNotNull(Date inputDate)
	{
		return inputDate != null;
	}
	
	public static boolean isNotNullOrEmpty(String inputString)
	{
		return isNotNullOrEmptyPostTrim(inputString);
	}
	
	public static boolean isNotNullOrEmptyPostTrim(String inputString)
	{
		return inputString != null && !inputString.trim().isEmpty();
	}
	
	public static boolean isNullOrEmpty(String inputString)
	{
		return inputString == null || (inputString != null && inputString.isEmpty());
	}
	
	public static boolean isNotNull(Double inputValue)
	{
		return inputValue != null;
	}
	
	public static boolean isNotNull(Integer inputValue)
	{
		return inputValue != null;
	}
	
	public static double roundToDecimals(double d, int c) 
	{
		int temp=(int)((d*Math.pow(10,c)));
		return (((double)temp)/Math.pow(10,c));
	}
	
	public static String getInitialInCaps(String inputString)
	{
		if (inputString != null && !inputString.isEmpty() && !inputString.trim().isEmpty())
		{
			String initial = inputString.substring(0, 1);
			initial = initial.toUpperCase();
			return initial + inputString.substring(1, inputString.length());
		}
		return "";
	}

	public static boolean isNullOrEmpty(Collection collection)
	{
		if (collection == null || (collection != null && collection.isEmpty()))
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean isNullOrEmpty(List list)
	{
		if (list != null && !list.isEmpty())
		{
			return true;
		}
		
		return false;
	}
}
