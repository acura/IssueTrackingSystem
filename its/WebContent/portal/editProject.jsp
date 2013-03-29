<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
  	<title>Developer</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=7" />
	<sx:head parseContent="true"/>
	<jsp:include page="include.jsp"></jsp:include>
	<script type="text/javascript">

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
	
	function acceptOnlyCharacter(obj)
	{
		var regex = /^[ÒA-Za-z _]*[ÒA-Za-z][ÒA-Za-z _]*$/;

		if (regex.test(obj.value) == false)
		{
			obj.value='';
			return;
		}
		return; 
	}


	function formatForNumeric(obj)
	{
		var regex = /^\d\d*\.?\d*$/;

		if (regex.test(obj.value) == false)
		{
			obj.value='';
			return;
		}
		return; 
	}



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



	$(function() {
		$( "#issueDate" ).datepicker({ 
				dateFormat: 'dd-mm-yy', 
				showAnim: "drop",
				changeMonth: true,
				changeYear: true
		 });
		$.datepicker.setDefaults($.datepicker.regional['']);     
		$("#issueDate").datepicker($.datepicker.regional['']); 
	    });
		
	</script>
</head>

<body onload="">
<jsp:include page="menu.jsp" />

<s:form id="editProject" name="editProject" action="saveProject.action">

<table class="mainTable" border="0" cellpadding="0" cellspacing="0" style="width: 100%;">
	<tr>
        <td  class="screenHeader" align="center">
              <span class="screenHeaderSpan">Add New Developer</span>
		</td>
	</tr>
   <tr>
    	<td style="width: 100%;">
    		<table style="width: 100%;">
           			<tr>
						<td style="width: 100%;" valign="top">
						<input type="hidden" name="oid" value="${oid}"/>
	            			<table style="width: 100%;">
	            				
		                         
		                         <tr>
		                         	<td style="width: 49%;font-weight:bold;text-align:right;"><i>Developer Name<font color="red">*</font>:</i></td>
		                         	<td style="width: 51%;">
		                         		<table>
											<s:textfield key="projectName" label="" labelSeparator="" maxlength="14" size="20"  onkeyup="acceptOnlyCharacter(this)"/>		                         		
		                         		</table>
		                         	</td>
		                        </tr>
		                        
		                                    
                        	</table>      
	    				</td>
					</tr>
				</table>
		</td>
	</tr>
	<tr>
   		<td style="text-align: center;">
   			<%--<input  type="submit" value="SAVE"/> --%>
			  <jsp:include page="commonSubmit.jsp"></jsp:include> 
   		</td>
   	</tr>
</table>
</s:form>
</body>
</html>
   		
		      