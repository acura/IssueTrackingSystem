package com.util.tags;

import java.util.List;

public class ListContainsFunction 
{
	public static boolean contains(List list, Object o) 
	{ 
		return list != null && !list.isEmpty() && list.contains(o);    
	} 
}
