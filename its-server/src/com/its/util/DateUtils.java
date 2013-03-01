package com.its.util;

import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang.StringUtils;

import com.its.domain.PortalConstant;


public class DateUtils 
{
	public static final String DATE_SEPARATOR_CHAR = "-";

	public static boolean equalDates(Calendar cal1, Calendar cal2)
	{
		int year1 = cal1.get(Calendar.YEAR);
		int month1 = cal1.get(Calendar.MONTH);
		int day1 = cal1.get(Calendar.DAY_OF_MONTH);
		
		int year2 = cal2.get(Calendar.YEAR);
		int month2 = cal2.get(Calendar.MONTH);
		int day2 = cal2.get(Calendar.DAY_OF_MONTH);
		
		if (year1 == year2 && month1 == month2 && day1 == day2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static Calendar getTodaysCalendarInstance(boolean considerTime)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		if (!considerTime)
		{
			cal.set(cal.get(cal.YEAR), cal.get(cal.MONTH), cal.get(cal.DAY_OF_MONTH), 0, 0, 0);
		}
		else
		{
			cal.setTime(new Date());
		}
		return cal;
	}
	
	public static Calendar getCalendarInstance(String dateAsString, boolean considerTime)
	{
		if (GenericUtils.isNotNullOrEmpty(dateAsString))
		{
			String strTmp = dateAsString.replaceAll(DATE_SEPARATOR_CHAR, PortalConstant.COLON);
			String []dmyArray = strTmp.split(PortalConstant.COLON);
			
			if (!considerTime)
			{
				if (dmyArray != null && dmyArray.length == 3)
				{
					int day = new Integer(dmyArray[0]);
					int mm = new Integer(dmyArray[1]) - 1;
					int year = new Integer(dmyArray[2]);
					Calendar cal = Calendar.getInstance();
					cal.set(year, mm, day, 0, 0, 0);
					return cal;
				}
			}
			else
			{
				Calendar cal = Calendar.getInstance();
				cal.setTime(getStringAsDate(dateAsString));
				return cal;
			}
		}
		
		return null;
	}
	
	public static Date getStringAsDate(String dateAsString)
	{
		if (GenericUtils.isNotNullOrEmpty(dateAsString))
		{
			String strTmp = dateAsString.replaceAll(DATE_SEPARATOR_CHAR, PortalConstant.COLON);
			String []dmyArray = strTmp.split(PortalConstant.COLON);
			
			if (dmyArray != null && dmyArray.length == 3)
			{
				int day = new Integer(dmyArray[0]);
				int mm = new Integer(dmyArray[1]) - 1;
				int year = new Integer(dmyArray[2]);
				
				Calendar cal = Calendar.getInstance();
				cal.set(year, mm, day);
				
				return cal.getTime();
			}
		}
		
		return null;
	}
	
	public static Date getStringAsDateWithTimestamp(String dateAsString)
	{
		System.out.println("*****In DateUtils*** " + dateAsString);
		if (GenericUtils.isNotNullOrEmpty(dateAsString))
		{
			String strTmp = dateAsString.replaceAll(DATE_SEPARATOR_CHAR, PortalConstant.COLON);
			String []dmyArray = strTmp.split(PortalConstant.COLON);
			
			if (dmyArray != null && dmyArray.length == 3)
			{
				int day = new Integer(dmyArray[0]);
				int mm = new Integer(dmyArray[1]) - 1;
				int year = new Integer(dmyArray[2]);
				
				Calendar cal = Calendar.getInstance();
				cal.set(year, mm, day);
				
				return cal.getTime();
			}
		}
		
		return null;
	}

	
	public static String getDateAsString(Date inputDate) 
	{
		if (GenericUtils.isNotNull(inputDate))
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(inputDate);
			String day = new Integer(cal.get(Calendar.DATE)).toString();
			String mm = new Integer(cal.get(Calendar.MONTH) + 1).toString();
			String year = new Integer(cal.get(Calendar.YEAR)).toString();
			
			return StringUtils.leftPad(day, 2, "0") + 
				   DateUtils.DATE_SEPARATOR_CHAR + 
				   StringUtils.leftPad(mm, 2, "0") + 
				   DateUtils.DATE_SEPARATOR_CHAR + year; 
		}
		
		return PortalConstant.BLANK_STRING;
	}
	
	public static String getDateAsStringWithTimestamp(Date inputDate) 
	{
		if (GenericUtils.isNotNull(inputDate))
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(inputDate);
			String day = new Integer(cal.get(Calendar.DATE)).toString();
			String mm = new Integer(cal.get(Calendar.MONTH) + 1).toString();
			String year = new Integer(cal.get(Calendar.YEAR)).toString();
			String hours = new Integer(cal.get(Calendar.HOUR_OF_DAY)).toString();
			String minutes = new Integer(cal.get(Calendar.MINUTE)).toString();
			String seconds = new Integer(cal.get(Calendar.SECOND)).toString();
			
			return StringUtils.leftPad(day, 2, "0") + 
				   DateUtils.DATE_SEPARATOR_CHAR + 
				   StringUtils.leftPad(mm, 2, "0") + 
				   DateUtils.DATE_SEPARATOR_CHAR + year + 
				   PortalConstant.SINGLE_SPACE + hours + PortalConstant.COLON + 
				   minutes +PortalConstant.COLON + seconds; 
		}
		
		return PortalConstant.BLANK_STRING;
	}
	
	public static String getDateAsYYYYMMDD(Date inputDate) 
	{
		if (GenericUtils.isNotNull(inputDate))
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(inputDate);
			String day = new Integer(cal.get(Calendar.DATE)).toString();
			String mm = new Integer(cal.get(Calendar.MONTH) + 1).toString();
			String year = new Integer(cal.get(Calendar.YEAR)).toString();
			return year +  
			   DateUtils.DATE_SEPARATOR_CHAR + 
			   StringUtils.leftPad(mm, 2, "0") +
			   DateUtils.DATE_SEPARATOR_CHAR + 
			   StringUtils.leftPad(day, 2, "0");
		}
		
		return PortalConstant.BLANK_STRING;
	}

	public static String getDateAsYYYYMMDDWithTimestamp(Date inputDate) 
	{
		if (GenericUtils.isNotNull(inputDate))
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(inputDate);
			String day = new Integer(cal.get(Calendar.DATE)).toString();
			String mm = new Integer(cal.get(Calendar.MONTH) + 1).toString();
			String year = new Integer(cal.get(Calendar.YEAR)).toString();
			String hours = new Integer(cal.get(Calendar.HOUR_OF_DAY)).toString();
			String minutes = new Integer(cal.get(Calendar.MINUTE)).toString();
			String seconds = new Integer(cal.get(Calendar.SECOND)).toString();

			return year +  
			   DateUtils.DATE_SEPARATOR_CHAR + 
			   StringUtils.leftPad(mm, 2, "0") +
			   DateUtils.DATE_SEPARATOR_CHAR + 
			   StringUtils.leftPad(day, 2, "0")+
			   PortalConstant.SINGLE_SPACE + hours + PortalConstant.COLON + 
			   minutes +PortalConstant.COLON + seconds; 
		}
		
		return PortalConstant.BLANK_STRING;
	}
	
	public static String getDateAsDDMMYYYYWithTimestamp(Date inputDate) 
	{
		if (GenericUtils.isNotNull(inputDate))
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(inputDate);
			String day = new Integer(cal.get(Calendar.DATE)).toString();
			String mm = new Integer(cal.get(Calendar.MONTH) + 1).toString();
			String year = new Integer(cal.get(Calendar.YEAR)).toString();
			String hours = new Integer(cal.get(Calendar.HOUR_OF_DAY)).toString();
			String minutes = new Integer(cal.get(Calendar.MINUTE)).toString();
			String seconds = new Integer(cal.get(Calendar.SECOND)).toString();

			return StringUtils.leftPad(day, 2, "0") +  
			   DateUtils.DATE_SEPARATOR_CHAR + 
			   StringUtils.leftPad(mm, 2, "0") +
			   DateUtils.DATE_SEPARATOR_CHAR + 
			   year+ 
			   PortalConstant.SINGLE_SPACE + StringUtils.leftPad(hours, 2, "0") + PortalConstant.COLON + 
			   StringUtils.leftPad(minutes, 2, "0")+ PortalConstant.COLON + StringUtils.leftPad(seconds, 2, "0"); 
		}
		
		return PortalConstant.BLANK_STRING;
	}

	public static String getDateAsDDMMYYYYFromMysqlDate(String yyyymmdd)
	{
		if (GenericUtils.isNotNullOrEmpty(yyyymmdd))
		{
			String strTmp = yyyymmdd.replaceAll(DATE_SEPARATOR_CHAR, PortalConstant.COLON);
			String []ymdArray = strTmp.split(PortalConstant.COLON);
			
			if (ymdArray != null && ymdArray.length == 3)
			{
				int day = new Integer(ymdArray[2]);
				int mm = new Integer(ymdArray[1]) - 1;
				int year = new Integer(ymdArray[0]);
				
				Calendar cal = Calendar.getInstance();
				cal.set(year, mm, day);
				
				return getDateAsString(cal.getTime());
			}
		}
		
		return PortalConstant.BLANK_STRING;
	}
	
	public static String getDateAsDDMMYYYYFromMysqlDate(Date yyyymmdd)
	{
		if (GenericUtils.isNotNull(yyyymmdd))
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(yyyymmdd);
			String day = new Integer(cal.get(Calendar.DATE)).toString();
			String mm = new Integer(cal.get(Calendar.MONTH) + 1).toString();
			String year = new Integer(cal.get(Calendar.YEAR)).toString();
			return StringUtils.leftPad(day, 2, "0") +  
			   DateUtils.DATE_SEPARATOR_CHAR + 
			   StringUtils.leftPad(mm, 2, "0") +
			   DateUtils.DATE_SEPARATOR_CHAR + 
			   year ;
		}
		
		return PortalConstant.BLANK_STRING;
	}
	
	 public static Integer calculateAgeFromDateOfBirth(Date dateOfBirth)
	    {
	    	 int userAge = 0;
	         int factor = 0; 
	    	
	    	Calendar cal1 = Calendar.getInstance();
	    	cal1.setTime(new Date());
	    	
	    	Calendar cal2 = Calendar.getInstance();
	    	cal2.setTime(dateOfBirth);
	    	
	    	boolean isCal1LeapYear = false;
	    	int cal1Year = cal1.get(Calendar.YEAR);
	    	if (cal1Year % 400 == 0 || (cal1Year % 100 != 0 && cal1Year % 4 == 0))
	    	{
	    		isCal1LeapYear = true;
	    	}
	    	
	    	boolean isCal2LeapYear = false;
	    	int cal2Year = cal2.get(Calendar.YEAR);
	    	if (cal2Year % 400 == 0 || (cal2Year % 100 != 0 && cal2Year % 4 == 0))
	    	{
	    		isCal2LeapYear = true;
	    	}
	    	
	    	if ((isCal1LeapYear && isCal2LeapYear) || (!isCal1LeapYear && !isCal2LeapYear))
	    	{
		    	if (cal1.get(Calendar.DAY_OF_YEAR) < cal2.get(Calendar.DAY_OF_YEAR)) 
		    	{
		            factor = -1; 
		    	}
	    	}
	    	else if (isCal1LeapYear && !isCal2LeapYear)
	    	{
		    	if (cal1.get(Calendar.DAY_OF_YEAR) < (cal2.get(Calendar.DAY_OF_YEAR) + 1)) 
		    	{
		            factor = -1; 
		    	}
	    	}
	    	else if (!isCal1LeapYear && isCal2LeapYear)
	    	{
		    	if ((cal1.get(Calendar.DAY_OF_YEAR) + 1) < cal2.get(Calendar.DAY_OF_YEAR)) 
		    	{
		            factor = -1; 
		    	}
	    	}
	    		
	    	userAge = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR) + factor;
	    	System.out.println("Your age is: "+ userAge);
	    	return userAge;
	    	
	    }
}
