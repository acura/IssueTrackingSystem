function confirmPortalCancel() 
{
 if (confirm("Do you want to cancel?")) 
	 {
	 	goToHomePage();
	 }
}
function goToHomePage()
{
	pleaseWait('document.forms[0].action = contextPath + \'/its/viewIssues.action\';document.forms[0].submit();');
	return;
}

function getUserInfo(userId)
{
	try
	{
		opener.openWins[opener.curWin++] = window.open(contextPath + '/hms/getUserInfo?userId=' +userId,'userPopUpWindow','addressbar=0,menubar=0,resizable=0,location=0,status=0,scrollbars=0,width=468,height=280');
	}
	catch(e)
	{
		opener.opener.openWins[opener.opener.curWin++] = window.open(contextPath + '/hms/getUserInfo?userId=' +userId,'userPopUpWindow','addressbar=0,menubar=0,resizable=0,location=0,status=0,scrollbars=0,width=468,height=280');
	}
}
function initialsInCapital(value,name)
{
	document.getElementById(name).value=value.substring(0,1).toUpperCase()+value.substring(1,value.length);
	return -1;
}

function capWords(str,name)
{
	   words = str.split(" "); 
	   for (i=0 ; i < words.length ; i++)
	   {
	      testwd = words[i];
	      firLet = testwd.substr(0,1); //lop off first letter
	      rest = testwd.substr(1, testwd.length -1);
	      words[i] = firLet.toUpperCase() + rest;   
	   }         
	  document.getElementById(name).value = words.join(" ");
	   //document.forms[0].element[name].value = words.join(" ");
}

function decimalFormat(amount)
{
	var i = parseFloat(amount);
	if(isNaN(i)) { i = 0.00; }
	var minus = '';
	if(i < 0) { minus = '-'; }
	i = Math.abs(i);
	i = parseInt((i + .005) * 100);
	i = i / 100;
	s = new String(i);
	if(s.indexOf('.') < 0) { s += '.00'; }
	if(s.indexOf('.') == (s.length - 2)) { s += '0'; }
	s = minus + s;
	return s;
}

function acceptOnlyCharacter(obj)
{
	var regex = /^[ñA-Za-z _]*[ñA-Za-z][ñA-Za-z _]*$/;

	if (regex.test(obj.value) == false)
	{
		obj.value='';
		return;
	}
	return; 
}