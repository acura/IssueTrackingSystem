<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
//committed by supriya
<html>

<head>
  	<title>User</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=7" />
	<sx:head parseContent="true"/>
	<jsp:include page="include.jsp"></jsp:include>
	<script type="text/javascript">

	function validateDate(dtObj, messageFieldName, centuryType)
	{
//
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
		var regex = /^[�A-Za-z _]*[�A-Za-z][�A-Za-z _]*$/;

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

<s:form id="editIssue" name="editIssue" action="saveIssue">

<table class="mainTable" border="0" cellpadding="0" cellspacing="0" style="width: 100%;">
	<tr>
        <td  class="screenHeader" align="center">
              <span class="screenHeaderSpan">Add New Issue</span>
		</td>
	</tr>
   <tr>
    	<td style="width: 100%;">
    		<div class="scrollableDiv" id="outterDiv" align="center">
				<table style="width: 100%;">
				<s:hidden key="oid" value="%{oid}"/>
           			<tr>
						<td style="width: 100%;" valign="top">
	            			<table style="width: 100%;">
	            				
		                         <tr>
		                         	<td style="width: 50%;font-weight:bold;text-align:right;"><i>Developer<font color="red">*</font>:</i></td>
		                         	<td style="width: 50%;">
		                         		<table>
		                         		    
		                         			<s:select list="#{'':'','Amol Gadre':'Amol Gadre', 'Mahesh Kalshetty':'Mahesh Kalshetty', 'Mahesh Shivarkar':'Mahesh Shivarkar', 'Ashok Kale':'Ashok Kale','Swati Malode':'Swati Malode','Dolly Bisen':'Dolly Bisen','Mayur kamte':'Mayur kamte','Nutan Chougale':'Nutan Chougale','Supriya Jadhav':'Supriya Jadhav','Pooja Palekar':'Pooja Palekar'}"
			                        		key="developer" label="" labelSeparator="" ></s:select>	
		                         		</table>
		                         	</td>
		                        </tr>
		                        
		                       <tr>
		                        <td  style="width:50%;font-weight:bold;text-align:right;"><i>Project<font color="red">*</font>:</i></td>
		                        <td style="width: 50%;">
		                         		<table>
		                         			
		                         			<c:choose>
		                         			<c:when test="${not empty oid}">
		                         				${selectedProjectNameList}
			                        		</c:when>
			                        		<c:otherwise>
			                        			<s:select list="#{'':'', 'GynoSoft':'GynoSoft', 'Prolab':'Prolab', 'GenSoft':'GenSoft','prescription':'Prescription','VBS':'VBS','UAS':'UAS','ITS':'ITS'}"
			                        			key="project" label="" labelSeparator="" multiple="true" ></s:select>
			                        		</c:otherwise>
			                        		</c:choose>
			                        		
			                        		 
							            
							            
							            
							                	
		                         		</table>
		                         	</td>
		                        
		                        </tr>
		                        
		                         <tr>
		                         	<td style="width: 49%;font-weight:bold;text-align:right;"><i> Issue No<font color="red">*</font>:</i></td>
		                         	<td style="width: 51%;">
		                         		<table>
											<s:textfield key="issueNo" label="" labelSeparator="" maxlength="14" size="20"  onkeyup=""/>		                         		
		                         		</table>
		                         	</td>
		                        </tr>
		                        
		                        <tr>
		                         	<td style="width: 50%;font-weight:bold;text-align:right;"><i>Date<font color="red">*</font>:</i></td>
		                         	<td style="width: 50%;">
		                         	<table>
		                         	  <tr>
		                         	   <td>
		                         		<table>
											<s:textfield key="issueDate" id="issueDate" label="" labelSeparator="" maxlength="10" size="20" onkeyup="formatDate(this);" onblur="validateDate(this, 'fromDateValMessage','TWIN_CENTURIES'); " />		                         		
		                         		</table>
		                         		</td>
								   </tr>
		                         </table>
		                         </td>
		                        </tr>
		                        <tr>
		                         	<td style="width: 50%;font-weight:bold;text-align:right;"><i>Hour<font color="red"></font>:</i></td>
		                         	<td style="width: 50%;">
		                         		<table>
											<s:textfield key="hours" label="" labelSeparator="" maxlength="50" size="20"  onchange="capWords(this.value, this.name);" onkeyup="formatForNumeric(this)"/>		                         		
		                         		</table>
		                         	</td>
		                        </tr>
		                        
		                        
		                       <tr>
		                         	<td style="width: 50%;font-weight:bold;text-align:right;"><i>Comment<font color="red" ></font>:</i></td>
		                         	<td style="width: 50%;">
		                         		<table>
		                         		    <s:textarea name="comment" cols="40" rows="5"></s:textarea>
		                         		</table>
		                         	</td>
		                        </tr>
		                        
		                        
		                        <tr>
		                        <td  style="width:50%;font-weight:bold;text-align:right;"><i>Activity<font color="red">*</font>:</i></td>
		                        <td style="width: 50%;">
		                         		<table>
		                         			<s:select list="#{'':'', 'Testing':'Testing', 'Coding':'Coding', 'Deployment':'Deployment','Demo':'Demo','Design':'Design','Document':'Document'}"
			                        		key="activity" label="" labelSeparator="" ></s:select>	
		                         		</table>
		                         	</td>
		                        
		                        </tr>
		                        
                        	</table>      
	    				</td>
					</tr>
				</table>
			</div>
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
   		
		      