package com.its.util;
import java.io.DataInputStream;

public class NumberToWord 
{ 
	NumberToWord numberToWord = new NumberToWord(); 
	@SuppressWarnings("deprecation")
	private void test() 
	{ 
		int num;
		  	   
		   System.out.println("Enter a decimal number:");
		   try
		   {
			   DataInputStream dis=new DataInputStream(System.in);
			   num =Integer.parseInt(dis.readLine());
		       System.out.println(conversion(num));	       
		   }
		   catch(Exception e)
		   {
			   System.out.println(e);
		   }
	} 
	
	static String ten[] = { "", " Ten", " Twenty", " Thirty", " Fourty", 
							" Fifty", " Sixty", " Seventy", " Eighty", " Ninety"
						  }; 
	
	static String one[] = { "", " One", " Two", " Three", " Four", 
							" Five", " Six", " Seven", " Eight", " Nine", 
							" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", 
							" Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen" 
						  }; 
		
	public static String conversion(int a) 
	{ 
		return conversion9(a).substring(1);
	}
	
	static String conversion9(int a)
	{
		return (a>=10000000 ? conversion7(a/10000000)+ " Crore" : "")+conversion7(a%10000000);
	}
	
	static String conversion7(int a)
	{
		return (a>=100000 ? conversion5(a/100000)+ " Lakh" : "")+conversion5(a%100000);
	}	
	
	static String conversion5(int a) 
	{ 
		return (a >= 1000 ? conversion3(a / 1000) + " Thousand" : "") + conversion3(a % 1000); 
	}
		
	static String conversion3(int a)
	{ 
		return (a >= 100 ? conversion2((a / 100)%10) + " Hundred" : "") + conversion2(a % 100);
	}
	
	static String conversion2(int a)
	{
		return a < 20 ? one[a] : (ten[a / 10] + one[a % 10]);
	} 
	
}
