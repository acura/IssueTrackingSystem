	function pleaseWait(url)
	{
		setTimeout(url,1000);
		document.getElementById('pleasewaitDiv').style.visibility = 'visible';
	}
	
	function pleaseWaitForEmail(url)
	{
		setTimeout(url,1000);
		document.getElementById('progressDiv').style.visibility = 'visible';
	}
	
	function changeImage(name)  
	{  
		document.images[name].src = contextPath + '/images/'+name+'buttonhover.png';
		return true;  
	}  
	
	function changeImageBack(name)  
	{  
		document.images[name].src = contextPath+'/images/'+name+'button.png';  
		return true;  
	}  
	
	function handleMDown(name)  
	{  
		 document.images[name].src = contextPath+'/images/'+name+'buttonclick.png';  
		 return true;  
	}
	
	function changeImageByIndex(name, formIndex, buttonIndex)  
	{  
		document.forms[formIndex].elements[name][buttonIndex].src = contextPath + '/images/'+name+'buttonhover.png';
		return true;  
	}  
	
	function changeImageBackByIndex(name, formIndex, buttonIndex)  
	{  
		document.forms[formIndex].elements[name][buttonIndex].src = contextPath+'/images/'+name+'button.png';
		return true;  
	}  
	
	function handleMDownByIndex(name, formIndex, buttonIndex)  
	{  
		document.forms[formIndex].elements[name][buttonIndex].src = contextPath+'/images/'+name+'buttonclick.png';
		 return true;  
	}
	
	function changeImageAddNewRowAndGroup(name)  
	
	{  
		
		document.getElementById(name).src = contextPath + '/images/'+name+'buttonhover.png';
		return true;  
	
	}  
	
	function changeImageBackAddNewRowAndGroup(name)  
	
	{  
		
		document.getElementById(name).src = contextPath+'/images/'+name+'button.png';  
		return true;  
	
	}  
	
	function handleMDownAddNewRowAndGroup(name)  
	
	{  
	
		 document.getElementById(name).src = contextPath+'/images/'+name+'buttonclick.png';  
		 return true;  
		
	}