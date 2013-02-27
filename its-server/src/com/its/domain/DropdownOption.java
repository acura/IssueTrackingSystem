package com.its.domain;
/**Copyright © 2010 by Acura Softwares, Pune, India.
 * DropdownOption : DropdownOption Class
 */
public class DropdownOption 
{
	private Integer oid;
	private String optionType;
	private String optionId;
	private String optionText;
	
	public DropdownOption()
	{
		
	}
	
	public DropdownOption(String optionId, String optionText)
	{
		this.optionId = optionId;
		this.optionText = optionText;
	}
	
	public Integer getOid()
	{
		return oid;
	}
	
	public void setOid(Integer oid) 
	{
		this.oid = oid;
	}
	
	public String getOptionType() 
	{
		return optionType;
	}

	public void setOptionType(String optionType) 
	{
		this.optionType = optionType;
	}
	
	public String getOptionId() 
	{
		return optionId;
	}
	
	public void setOptionId(String optionId) 
	{
		this.optionId = optionId;
	}
	
	public String getOptionText()
	{
		return optionText;
	}
	
	public void setOptionText(String optionText) 
	{
		this.optionText = optionText;
	}

}
