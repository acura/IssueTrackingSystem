<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="../WEB-INF/tld/custom-functions.tld" prefix="fn" %>



<html>

<head>
  	
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=7" />
	<jsp:include page="include.jsp"></jsp:include>
	
	<style>
	.ui-progressbar .ui-progressbar-value { background: RGB(70,130,180); }
	</style>
	<script type="text/javascript">
		var progressValue;
		var responseText;
		$(function() {
			$( "#progressbar" ).progressbar({
				value: progressValue
			});
		});

		function startProgress(responseText)
		{
			progressValue = 0;
			$("#progressbar").show();
			incrementProgress();
		}	
		function incrementProgress()
		{
			if (progressValue<=100)
			{
				progressValue++;
				$("#progressbar").progressbar('value',progressValue);
				document.getElementById('count').innerHTML = progressValue+'%';
				if (progressValue<100)
				{
					setTimeout('incrementProgress()',100);
				}	
			}
			if (progressValue == 100)
			{
				$("#progressbar").hide('slow');
				updatepageForProgressDiv();
				document.getElementById('count').innerHTML = '';
			}
		}
		function startBackup()
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
		    
		    self.xmlHttpReq.open('POST', '${pageContext.request.contextPath}/its/onDemandBackup.action?isFromMenu=false', true);
		    self.xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		   
		    self.xmlHttpReq.onreadystatechange = function() 
		    {
		    	if (self.xmlHttpReq.readyState == 4) 
			    {
		    		startProgress(self.xmlHttpReq.responseText);
		        }
		    }
		    self.xmlHttpReq.send();
			 
		}

		function updatepageForProgressDiv()
		{
			document.getElementById('backupMessage').innerHTML = '<table width="100%;"><tr><td width="100%;" class="isa_success" id="isa_success" style="font-weight:bold;font-size:13px;text-align:center;">Data Backedup Successfully....</td></tr></table>';
		}

		$(document).ready(function() {
		    $("#isa_success").fadeIn("slow");
		});

		function closeNotice() {
		    $("#isa_success").fadeOut("slow");
		}

		window.setInterval("closeNotice()",10000);
				
						
	</script>
	<sx:head parseContent="true"/>
</head>

<body class="bodyClass">
<jsp:include page="menu.jsp"></jsp:include>
<s:form id="onDemandBackup" name="onDemandBackup" action="">
<table class="mainTable" border="0" cellpadding="0" cellspacing="0" >
	<tr>
	 	<td colspan="2" class="screenHeader"  >
        	<table width="100%">
	        	<tr>
					<td style="width: 39%">
               	    </td>
					  <td class="screenHeader" width="20%" style="text-align:center; background: url(../images/headerback.png); z-index: 100;">        	
		              <span class="screenHeaderSpan">
			              Data Backup
		       	  	  </span>
	       	  	  	</td>
	       	  	  	<td style="width: 39%">
	       	  	  	</td>
       	  	  	</tr>
     	  	 </table>
		</td>
		</tr>
    <tr>
     <td style="text-align:center; height: 350px;">
    <div class="fixedDiv" id="outterDiv" style="background:url(../images/preback.jpg);">
    <table width="100%">
   		<tr>
   		<td width="100%" style="text-align: -moz-center; font-weight:bold;font-size:15px;">
   			<div id="backupMessage"></div>
   		</td>
   		</tr>
   	</table>
   	<table style="width: 100%; padding-top: 12%;">
   		<tr>
   		<td width="100%;">
   		<div style="font-weight:bold;" id="count"></div>
   		<table width="100%;">
   		  <tr>
   		    <td style="text-align: -moz-center; padding-bottom: 10px;">
   		         <div style="width:35%; text-align: center;" id="progressbar"></div>
   		    </td>
   		  </tr>
   		</table>
	   	</td>
	   	</tr>
	   	<tr>
	   	<td>
	   	<table width="100%">	
	   		<tr>
	   		<td width="100%" style="text-align:center; vertical-align: middle;">
				<a href="#"  
					onmouseover="return changeImage('startbackup')" 
					onmouseout= "return changeImageBack('startbackup')" 
					onmousedown="return handleMDown('startbackup')" 
					onclick="startBackup();" 
				><img name="startbackup" src="../images/startbackupbutton.png" alt="Starts Backup Process" /></a>	
			</td>
			</tr>
		</table>
		</td>
		</tr>    	
	</table>
	</div>
	</td>
	</tr>
</table>
</s:form>
</body>

<script type="text/javascript">
	changeWidth(document.getElementById('outterDiv'));
	$("#progressbar").hide();
</script>
</html>
