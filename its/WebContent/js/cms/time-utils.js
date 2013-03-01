var separator= ":";
		var minYear=1900;
		var maxYear=2500;

		function formatTime(obj)
		{
			var regex = /^\d\d*\:?\d*$/;
			//var regex = /[0-9]/;

			if (regex.test(obj.value) == false)
			{
				obj.value='';
				return;
			}

			if (event.keyCode != 8 && event.keyCode != 46 && event.keycode !=16 && event.keycode !=17 && event.keycode !=18 )
			{
				if (obj != null && obj.value.length == 2)
				{
					obj.value +=':';
				}
			}
			return ; 
		}

		function validateTime(timeObj, messageFieldName)
		{
			var timeFormatted = formatTimeForHrsAndMin(timeObj, messageFieldName);
			timeObj.value = timeFormatted; 
		}

		function formatTimeForHrsAndMin(timeObj, messageFieldName)
		{
			if (timeObj.value.length!=''&& timeObj.value.length <= 5)
			{
				var hrsPart;
				var minPart;
				
				if(timeObj.value.length==1)		
				{
					hrsPart= '0' + timeObj.value;
					minPart='00';
				}
				else if(timeObj.value.length==3)		
				{
					hrsPart=timeObj.value.substring(0,2);
					minPart='00';
				}
				else if(timeObj.value.length==4)
				{
					hrsPart=timeObj.value.substring(0,2);	
					minPart='0'+ timeObj.value.substring(3,5);
				}
				else
				{
					hrsPart = timeObj.value.substring(0,2);
					minPart = timeObj.value.substring(3,6);
				}
				if (hrsPart == 0 || hrsPart==00 || hrsPart > 12 || hrsPart.search(':')!= -1) 
				{
					setValidationFailedMessage(timeObj, messageFieldName, 'Entered Value: ' + timeObj.value + '. Invalid Hours.');
					return '';
				}
				 if(minPart >59 || minPart.search(':')!= -1)
				{
					setValidationFailedMessage(timeObj, messageFieldName, 'Entered Value: ' + timeObj.value + '. Invalid Minutes.');
					return '';	
				}
				 setValidationPassedStyles(timeObj, messageFieldName);
						 
			return (hrsPart +':'+ minPart);	
			}
			else
			{
				return timeObj.value;
			}
	 }
		
		/*
	    function setValidationFailedMessage(timeObj, messageFieldName, message)
		{
			document.getElementById(messageFieldName).innerHTML = '<font color="red">' + message + '</font>';
			
			//document.getElementById(messageFieldName).innerHTML = '<a class="spch-bub-inside" href="#"><span class="point"></span><em>' + message + '</em></a>';

			timeObj.style.background = 'yellow';
		}

	    function setValidationPassedStyles(timeObj, messageFieldName)
	    {
	    	document.getElementById(messageFieldName).innerHTML = '';
	    	timeObj.style.background = 'white';
	    }
	    */
	   