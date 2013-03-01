			function captureEnterKeyForSubmit()
			{
			if ((event.which && event.which == 13) || 
			    (event.keyCode && event.keyCode == 13))
			    {
			    	document.getElementById('loginButton').onclick();
				    return false;
			    } 
			    else return true;
			}
			
			function proLabLogin()
			{
				var ht = screen.height - 103;
				var wd = screen.width - 8;
				window.openWins[window.curWin++] = window.open(contextPath + '/hms/viewProLabHomePage','ProLabHomePage' + window.curWin,'addressbar=1,menubar=0,resizable=0,location=1,status=1,scrollbars=1,width=' + wd + ',height=' + ht);
				var cnt = window.curWin - 1;
				window.openWins[cnt].moveTo(0, 0);
			}
			
			function xmlhttpPostValidateProLab(strURL) 
		   	{
			   	    var xmlHttpReq = false;
			   	    var self = this;
			   	    // Mozilla/Safari
			   	    if (window.XMLHttpRequest) 
			   		{
			   	        self.xmlHttpReq = new XMLHttpRequest();
			   	    }
			   	    // IE
			   	    else if (window.ActiveXObject) 
			   		{
			   	        self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
			   	    }
			   	    self.xmlHttpReq.open('POST', strURL, true);
			   	    self.xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			   	    self.xmlHttpReq.onreadystatechange = function() 
			   	    {
			   	        if (self.xmlHttpReq.readyState == 4) 
			   		    {
							updatepageLogin(self.xmlHttpReq.responseText, document.getElementById('prolabLogonForm_username').value);
			   	        }
			   	    };

			   	var username = document.getElementById('prolabLogonForm_username').value;
			   	var password = document.getElementById('prolabLogonForm_password').value;
			   	    self.xmlHttpReq.send(getquerystringsignon(username, password));

			   	    return;
		   	}

			function getquerystringsignon(user, password) 
			{
				// NOTE: no '?' before querystring
			    qstr = 'username=' + user + '&password=' + password + '&signon=true'; 
			    return qstr;
			}
			
			function proLabLogoutfun()
			{
				if (document.prolabLogoutForm)
				{
					document.prolabLogoutForm.action= "prolabLogout?logout=true";
					document.prolabLogoutForm.submit();
					
				}
				
				return;
			}
			
			function updatepageLogin(str, userId)
		   	{	//alert(str);
		   		if (str == 'true')
		   		{
		   			var factor1 = 103;
		   			var factor2 = 0;
		   			if(screen.height == 819)
		   			{
		   				factor2 = 2;
		   			}
		   			else 
		   			{
		   				factor2 = 8;
		   			}
		   			var ht = screen.height - factor1;
		   			var wd = screen.width - factor2;

		   			window.openWins[window.curWin++] = window.open(contextPath + '/hms/viewProLabHomePage','ProLabHomePageForm' + window.curWin,'addressbar=1,menubar=0,resizable=0,location=1,status=1,scrollbars=1,width=' + wd + ',height=' + ht);
					var cnt = window.curWin - 1;
					window.openWins[cnt].moveTo(0, 0);
		   			document.getElementById("loginPageDiv").innerHTML="<table><tr><td>" +
		   															"<a href=\"#\" onmouseover=\"return changeImage('logout')\" onmouseout=\"return changeImageBack('logout')\" onmousedown=\"return handleMDown('logout')\" onclick=\"window.closeAll();proLabLogoutfun();\" ><img id=\"logoutButton\" name=\"logout\" src=\"../images/logoutbutton.png\" alt=\"Log out here\" /></a>" +
		   															"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
		   			
		   															"<a href=\"#\" onmouseover=\"return changeImage('opennewwindow')\" onmouseout=\"return changeImageBack('opennewwindow')\" onmousedown=\"return handleMDown('opennewwindow')\" onclick=\"proLabLogin();\" ><img id=\"opennewwindowbutton\" name=\"opennewwindow\" src=\"../images/opennewwindowbutton.png\" alt=\"Open new window\" /></a>" +
		   															"</td></tr></table>" +
		   															"<script type=\"text/javascript\">" +
		   															"window.onunload = function() {" +
		   															"	if (document.prolabLogoutForm)" +
		   															"	{" +
		   															"		document.prolabLogoutForm.action= \"prolabLogout?logout=true\";" +
		   															"		document.prolabLogoutForm.submit();" +
		   															"		closeAll();" +
		   															"	}" +
		   															"	return;" +
		   															"}" +
		   															"</script>";
		   			return;
		   		}
		   		else if (str == 'onlineLogin')
		   		{
		   			window.location.href = 'viewTestRecordsByUser.action?userId=' + userId;
		   		}
		   		else 
	   			{
		   			document.getElementById("userNameDiv").innerHTML="";
	   				document.getElementById("passwordDiv").innerHTML="";
	   				document.getElementById("errorDiv").innerHTML="";
		   			if (str == 'invalid')
		   			{	document.getElementById("userNameDiv").innerHTML="<font color=\"red\">User Id is required </font>";
		   				document.getElementById("passwordDiv").innerHTML="<font color=\"red\">Password is required </font>";
		   				document.getElementById('username').focus();
		   			}
		   			else if (str == '1')
		   			{
		   				document.getElementById("userNameDiv").innerHTML="<font color=\"red\">User Id is required</font> ";
		   				document.getElementById('username').focus();
		   			}
		   			else if (str == '2')
		   			{
		   				document.getElementById("passwordDiv").innerHTML="<font color=\"red\">Password is required </font>";
		   				document.getElementById('password').focus();
		   			}
			   		else if (str == '3')
			   		{
			   			document.getElementById("errorDiv").innerHTML="<font color=\"red\">Invalid User Id or Password.</font>";
		   				document.getElementById('username').focus();
			   		}
			   		else if (str == '4')
			   		{
			   			document.getElementById("errorDiv").innerHTML="<font color=\"red\">User's Role has no permissions assigned </font>";
			   		}
			   		else if (str == '5')
			   		{
			   			document.getElementById("errorDiv").innerHTML="<font color=\"red\">User has no Role assigned </font>";
			   		}
		   		}
		   		return;
		   	}