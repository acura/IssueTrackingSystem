package com.its.domain;
import java.util.*;
public class PasswordGenerator 
{
	public static String getNewPassword() 
	{  
		char[] symbols = new char[36];  
		for(int i=0; i<26; ++i)  
			symbols[i] = (char)('A' + i);  
		for(int i=0; i<10; ++i)  
			symbols[26+i] = (char)('0' + i);  
		Random rnd = new Random();  
		StringBuffer b = new StringBuffer();  
		for(int i=0; i<8; ++i)  
			b.append(symbols[rnd.nextInt(36)]);  
		String password = b.toString();
		System.out.println(password);
		return password;
	             
	}  
	     
}
