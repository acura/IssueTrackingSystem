var separator= "-";
var minYear=1900;
var maxYear=2500;

function formatDate(obj)
{
	var regex = /[0-9]/;

	if (regex.test(obj.value) == false)
	{
		obj.value='';
		return;
	}

	if (event.keyCode != 8 && event.keyCode != 46 && event.keycode !=16 && event.keycode !=17 && event.keycode !=18 )
	{
		if (obj != null && obj.value.length == 2)
		{
			obj.value +='-';
		}
		if (obj != null && obj.value.length == 5)
		{
			obj.value +='-';
		}
	}
	
	return ; 
}

function validateDate(dtObj, messageFieldName, centuryType)
{
	if(dtObj.value == '')
	{
		return true;
	}
	else
	{
		var dtFormatted = formatDateForCentury(dtObj, centuryType);
		dtObj.value = dtFormatted;
	
		if (isDate(dtObj, messageFieldName) == false)
		{
			dtObj.value = '';
			return false;
		}
		return true;
   }
}

function formatDateForCentury(dtObj, centuryType)
{
	if (dtObj.value.length == 8)
	{
		var yearPart;
		var monthPart;
		var dayPart;
		
		yearPart = dtObj.value.substring(6,9);
		monthPart = dtObj.value.substring(3,6);
		dayPart = dtObj.value.substring(0, 3);
		
		var d = new Date();
		var current_year=d.getYear().toString();
		var curr_year= current_year.substring(0,2);
		
		if(centuryType == 'TWIN_CENTURIES')
		{
			if (yearPart >= 00 && yearPart<= curr_year)
			{
				yearPart = curr_year + yearPart;
			//	alert(dayPart + monthPart + yearPart);
			}
			else
			{
				yearPart = (curr_year - 1) + yearPart;
			}
		}
		else if(centuryType == 'CURRENT_CENTURY')
		{
				yearPart = curr_year + yearPart;
			
			//	alert(dayPart + monthPart + yearPart);
		}
		else
		{
			return dtObj.value;
		}
		return (dayPart + monthPart + yearPart);
	}
	else
	{
		return dtObj.value;
	}
}

function setValidationFailedMessage(dtObj, messageFieldName, message)
{
	document.getElementById(messageFieldName).innerHTML = '<font color="red">' + message + '</font>';
	
	//document.getElementById(messageFieldName).innerHTML = '<a class="spch-bub-inside" href="#"><span class="point"></span><em>' + message + '</em></a>';

	dtObj.style.background = 'yellow';
}

function setValidationPassedStyles(dtObj, messageFieldName)
{
	document.getElementById(messageFieldName).innerHTML = '';
	dtObj.style.background = 'white';
}

function isDate(dtObj, messageFieldName)
{
	var dtStr = dtObj.value;
	var daysInMonth = daysArray(12);
	var pos1=dtStr.indexOf("-");
	var pos2=dtStr.indexOf("-",pos1+1);
	var strDay=dtStr.substring(0,pos1);
	var strMonth=dtStr.substring(pos1+1,pos2);
	var strYear=dtStr.substring(pos2+1);
	strYr=strYear;
	
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1);
	
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1);
	for (var i = 1; i <= 3; i++)
	{
		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1);
	}
	if(strYr == null || strYr =='' )
	{
		strYr='0';
	}
	
	month=parseInt(strMonth);
	day=parseInt(strDay);
	year=parseInt(strYr);
	if (pos1==-1 || pos2==-1)
	{
		setValidationFailedMessage(dtObj, messageFieldName, 'Entered Value: ' + dtObj.value + '. The date format should be dd-mm-yyyy.');
		//alert("The date format should be : DD-MM-YYYY");
		return false;
	}
	if (strMonth.length<1 || month<1 || month>12)
	{
		setValidationFailedMessage(dtObj, messageFieldName, 'Entered Value: ' + dtObj.value + '. Please enter a valid month.');
		//alert("Please enter a valid month");
		return false;
	}

	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month])
	{
		setValidationFailedMessage(dtObj, messageFieldName, 'Entered Value: ' + dtObj.value + '. Please enter a valid day.');
		//alert("Please enter a valid day");
		return false;
	}
	
	if (year == 0 || year<minYear || year>maxYear)
	{
		setValidationFailedMessage(dtObj, messageFieldName, 'Entered Value: ' + dtObj.value + '. Please enter a valid year between ' + minYear + ' and ' + maxYear + '.');
		//alert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear);
		return false;
	}

	if (dtStr.indexOf("-",pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr,"-"))==false)
	{
		setValidationFailedMessage(dtObj, messageFieldName, 'Entered Value: ' + dtObj.value + '. Please enter a valid date.');
		//alert("Please enter a valid date");
		return false;
	}
	setValidationPassedStyles(dtObj, messageFieldName);
	return true;
}

function daysInFebruary (year)
{
	// February has 29 days in any year evenly divisible by four,
	// EXCEPT for centurial years which are not also divisible by 400.
	return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}

function daysArray(n) 
{
	var daysInMonth = new Array();
	for (var i = 1; i <= n; i++)
	{
		daysInMonth[i] = 31;
		if (i==4 || i==6 || i==9 || i==11) 
		{
			daysInMonth[i] = 30;
		}
		if (i==2)
		{
			daysInMonth[i] = 29;
		}
    } 
	return daysInMonth;
}

function isInteger(s)
{
	var i;
	for (i = 0; i < s.length; i++)
	{ 
		// Check that current character is a number or not.
		var c = s.charAt(i);
		if (((c < "0") || (c > "9"))) return false;
	}
	
	// All characters are numbers.
	return true;
}

function stripCharsInBag(s, bag)
{
	var i;
	var returnString = "";
	// Search through string's characters one by one.
	// If character is not in bag, append to returnString.
	for (i = 0; i < s.length; i++)
	{ 
		var c = s.charAt(i);
		if (bag.indexOf(c) == -1) returnString += c;
	}
	return returnString;
}


