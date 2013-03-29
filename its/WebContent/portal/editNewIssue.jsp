<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		$( "#estimatedStartDate" ).datepicker({ 
				dateFormat: 'dd-mm-yy', 
				showAnim: "drop",
				changeMonth: true,
				changeYear: true
		 });
		$.datepicker.setDefaults($.datepicker.regional['']);     
		$("#estimatedStartDate").datepicker($.datepicker.regional['']); 
	    });

	$(function() {
		$( "#estimatedEndDate" ).datepicker({ 
				dateFormat: 'dd-mm-yy', 
				showAnim: "drop",
				changeMonth: true,
				changeYear: true
		 });
		$.datepicker.setDefaults($.datepicker.regional['']);     
		$("#estimatedEndDate").datepicker($.datepicker.regional['']); 
	    });

	$(function() {
		$( "#actualStartDate" ).datepicker({ 
				dateFormat: 'dd-mm-yy', 
				showAnim: "drop",
				changeMonth: true,
				changeYear: true
		 });
		$.datepicker.setDefaults($.datepicker.regional['']);     
		$("#actualStartDate").datepicker($.datepicker.regional['']); 
	    });

	$(function() {
		$( "#actualEndDate" ).datepicker({ 
				dateFormat: 'dd-mm-yy', 
				showAnim: "drop",
				changeMonth: true,
				changeYear: true
		 });
		$.datepicker.setDefaults($.datepicker.regional['']);     
		$("#actualEndDate").datepicker($.datepicker.regional['']); 
	    });
	
		
	</script>
</head>

<body onload="">
<jsp:include page="menu.jsp" />

<s:form id="editNewIssue" name="editNewIssue" action="saveNewIssue" >

<table class="mainTable" border="0" cellpadding="0" cellspacing="0" style="width: 100%;">
	<tr>
        <td  class="screenHeader" align="center">
              <span class="screenHeaderSpan">Add New Issue</span>
		</td>
	</tr>
   <tr>
    	<td style="width: 100%;">
    		<div class="scrollableDiv" id="outterDiv" align="left">
				<table style="width: 100%;">
				<!--<s:hidden key="oid" value="%{oid}"/>-->
           			<tr>
						<td style="width: 100%;" valign="top">
	            			<table style="width: 100%;">
	            			 <tr>
	            					<td style="width: 100%;">
									<table style="width:100%;">
	            					 <tr>
		                         	<td style="width: 10%;font-weight:bold;text-align:right;"><i>Issue Number<font color="red">*</font>:</i></td>
		                         	 <td style="width: 90%;">
		                         		<table>
											<s:textfield key="issueNumber" label="" labelSeparator="" maxlength="10" size="20"  onchange="capWords(this.value, this.name);" onkeyup="formatForNumeric(this)"/>		                         		
		                         		</table>
		                             </td>
		                        </tr>
		                         </table>
		                             </td>
		                        </tr>
		                      	<tr>
		                        <td style="width: 100%;">
		                          <table style="width:100%;">
	            					 <tr>
		                         	<td style="width: 10%;font-weight:bold;text-align:right;"><i>Summary<font color="red">*</font>:</i></td>
		                         	 <td style="width: 90%;">
		                         		<table>
							
		                         			<s:textarea name="summary" cols="80" rows="2"></s:textarea>
		                         		</table>
		                             </td>
		                        </tr>
		                        </table>
		                         	</td>
		                        </tr>
		                         
		                        
		                        <tr>
		                        <td style="width: 100%;">
		                          <table style="width:100%;">
		                        <tr>
		                         	<td style="width: 10%;font-weight:bold;text-align:right;"><i>Detail<font color="red">*</font>:</i></td>
		                         	<td style="width: 90%;">
		                         		<table>
		                         			<s:textarea name="detail" cols="80" rows="5"></s:textarea>
		                         		</table>
		                         	</td>
		                        </tr>
		                       </table>
		                         	</td>
		                        </tr>
		                       <tr>  
		                       <td style="width: 50%;">
					             <table style="width:100%;">
					             <tr>
		                        <td  style="width:10%;font-weight:bold;text-align:right;"><i>System<font color="red">*</font>:</i></td>
		                        <td style="width: 90%;">
		                         		<table>
		                         		<%-- --<s:select list="projectList" listKey="optionId" listValue="optionText"
			                        			key="system" label="" labelSeparator="" multiple="true" ></s:select>--!>--%>
		                         		<s:select list="projectList" listKey="optionId" listValue="optionText"
			                        		key="system" label="" labelSeparator="" ></s:select>	
		                         
		                         		</table>
		                         	</td>
		                        
		                        </tr>
		                      </table>
						</td>
						
				<td style="width: 50%;">
					<table style="width:100%;">
							<tr>
							<td style="width:10%;font-weight:bold;text-align:right;nowrap:nowrap;"><i>Severity:</i></td>
							<td style="width:90%;text-align: left;">
							<table>
		                         <s:select list="#{'':'','Fatal':'Fatal', 'Medium':'Medium', 'Minor':'Minor'}"
			                  		key="severity" label="" labelSeparator="" ></s:select>	
		                    </table>
							</td>
							</tr>
					</table>
				</td> 
				</tr>
				
				<tr>
				 <td style="width: 50%;">
		                         <table style="width:100%;">
		                           <tr>
		                         	<td style="width: 10%;font-weight:bold;text-align:right;"><i>Estimated Start Date<font color="red">*</font>:</i></td>
		                         	<td style="width: 90%;">
		                         	<table>
		                         	  <tr>
		                         	   <td>
		                         		<table>
											<s:textfield key="estimatedStartDate" id="estimatedStartDate" label="" labelSeparator="" maxlength="10" size="20" onkeyup="formatDate(this);" onblur="validateDate(this, 'fromDateValMessage','TWIN_CENTURIES'); " />		                         		
		                         		</table>
		                         		</td>
								   </tr>
								   </table>
								  </td> 
								</tr>
							    </table>
				            </td>
				
				<td style="width: 50%;">
					<table style="width:100%;">
						<tr>
							<td style="width:10%;font-weight:bold;text-align:right;"><i>Priority:</i></td>
							<td style="width:90%;text-align: left;">
							<table>
								<s:select list="#{'':'','High':'High', 'Medium':'Medium', 'Lower':'Lower'}"
									key="priority" label="" labelSeparator=""></s:select>			                         		
		               		</table>
						    </td>
						   </tr> 
					</table>
				</td>
	  			</tr>
		                 <tr>	 
							<td style="width: 100%;">
		                         <table style="width:100%;">
		                             <tr>
		                         	<td style="width: 10%;font-weight:bold;text-align:right;"><i>Estimated End Date<font color="red">*</font>:</i></td>
		                         	<td style="width: 90%;">
		                         	<table>
		                         	  <tr>
		                         	   <td>
		                         		<table>
											<s:textfield key="estimatedEndDate" id="estimatedEndDate" label="" labelSeparator="" maxlength="10" size="20" onkeyup="formatDate(this);" onblur="validateDate(this, 'fromDateValMessage','TWIN_CENTURIES'); " />		                         		
		                         		</table>
		                         		</td>
								  	   </tr>
		                        	</table>
		                         	</td>
								 </tr>
		                        </table>
				            </td> 
								 
		                        <td style="width: 50%;">
		                         <table style="width:100%;">
		                        <tr>
		                         	<td style="width: 20%;font-weight:bold;text-align:right;"><i>Estimated Hours<font color="red">*</font>:</i></td>
		                         	<td style="width: 80%;">
		                         		<table>
											<s:textfield key="estimatedHours" label="" labelSeparator="" maxlength="20" size="20"  onchange="capWords(this.value, this.name);" onkeyup="formatForNumeric(this)"/>		                         		
		                         		</table>
		                         	</td>
		                        </tr>
		                        </table>
		                         	</td>
		                   </tr>
		                       
		                       <tr>
		                       <td style="width: 100%;">
		                         <table style="width:100%;">
		                           <tr>
		                         	<td style="width: 10%;font-weight:bold;text-align:right;"><i>Actual Start Date<font color="red">*</font>:</i></td>
		                         	<td style="width: 90%;">
		                         	<table>
		                         	  <tr>
		                         	   <td>
		                         		<table>
											<s:textfield key="actualStartDate" id="actualStartDate" label="" labelSeparator="" maxlength="10" size="20" onkeyup="formatDate(this);" onblur="validateDate(this, 'fromDateValMessage','TWIN_CENTURIES'); " />		                         		
		                         		</table>
		                         		</td>
								   </tr>
								   </table>
		                         	</td>
								 </tr>
								     </table>
		                         	</td>
								     
								     <td style="width: 100%;">
		                            <table style="width:100%;">
								    <tr>
		                         	<td style="width: 10%;font-weight:bold;text-align:right;"><i>Logged By<font color="red">*</font>:</i></td>
		                         	<td style="width: 90%;">
		                         		<table>
		                         		    
		                         			<s:select list="developerList" listKey="optionId" listValue="optionText"
			                        		key="loggedBy" label="" labelSeparator="" ></s:select>	
		                         		</table>
		                         	</td>
		                        </tr>
		                       </table>
		                      </td>
		              	    </tr>
								    
								    
							    <tr>
								   <td style="width: 100%;">
		                            <table style="width:100%;">
								     <tr>
		                         		<td style="width: 10%;font-weight:bold;text-align:right;"><i>Actual End Date<font color="red">*</font>:</i></td>
		                         		<td style="width: 90%;">
		                         	<table>
		                         	  <tr>
		                         		 <td>
		                         		<table>
											<s:textfield key="actualEndDate" id="actualEndDate" label="" labelSeparator="" maxlength="10" size="20" onkeyup="formatDate(this);" onblur="validateDate(this, 'fromDateValMessage','TWIN_CENTURIES'); " />		                         		
		                         		</table>
		                         		</td>
								   	 </tr>
								   </table>
		                         		</td>
								    </tr>
								   </table>
		                         </td>
							
		                      	  <td style="width: 100%;">
		                          <table style="width:100%;">
		                        	<tr>
		                           		<td style="width: 10%;font-weight:bold;text-align:right;"><i>Status<font color="red">*</font>:</i></td>
		                         		<td style="width: 90%;">
		                         		<table>
											<s:textfield key="status" label="" labelSeparator="" maxlength="10" size="20"  onchange="capWords(this.value, this.name);" onkeyup=""/>		                         		
		                         		</table>
		                         	   </td>
		                           </tr>
		                       	 </table>
		                       </td>
		                     </tr>
		                        
		                     <tr>
		                         <td style="width: 100%;">
		                          <table style="width:100%;">
		                          <tr>
		                        	<td style="width: 10%;font-weight:bold;text-align:right;"><i>Target Version<font color="red">*</font>:</i></td>
		                         	<td style="width: 90%;">
		                         	<table>
		                         	  <tr>
		                         	   <td>
		                         		<table>
											<s:textfield key="targetVersion" id="targetVersion" label="" labelSeparator="" maxlength="50" size="20" onkeyup="" onblur="validateDate(this, 'fromDateValMessage','TWIN_CENTURIES'); " />		                         		
		                         		</table>
		                         		</td>
								   	 </tr>
								   </table>
		                         </td>
								 </tr>
		                        </table>
		                       </td>
		                        
		                        <td style="width: 50%;">
		                          <table style="width:100%;">
		                           <tr>
		                         	<td style="width: 20%;font-weight:bold;text-align:right;"><i>Assigned To<font color="red">*</font>:</i></td>
		                         	<td style="width: 80%;">
		                         		<table>
		                         		    
		                         			<s:select list="developerList" listKey="optionId" listValue="optionText"
			                        		key="assignedTo" label="" labelSeparator="" ></s:select>	
		                         		</table>
		                         	</td>
		                          </tr>
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
   		
		      