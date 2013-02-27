<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
  	<title>Role Admin</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=7" />
	<jsp:include page="include.jsp"></jsp:include>
	<sx:head parseContent="true"/>
	<script type="text/javascript">
	
	function goToOnclickFunction()
	{
		listbox_selectAllForSubmit('availablePermissions', true);
		listbox_selectAllForSubmit('selectedPermissions', true);
		setTimeout('document.forms[0].submit();',1000);
		document.getElementById('pleasewaitDiv').style.visibility = 'visible';
	}

	function acceptOnlyCharacterPatient(obj)
	{
		var regex = /^[ÒA-Za-z _]*[ÒA-Za-z][ÒA-Za-z _]*$/;

		if (regex.test(obj.value) == false)
		{
			obj.value='';
			return;
		}
		return; 
	}
	
	
	</script> 
</head>

<body onload="document.all.roleName.focus();" class="bodyClass">
<jsp:include page="menu.jsp" />

<s:form id="editHMSRole" name="editHMSRole" action="saveRole">
<% request.setAttribute("oid", request.getParameter("oid")); %>

<table class="mainTable" border="0" cellpadding="0" cellspacing="0" >
	<tr>
       	<td colspan="2" class="screenHeader" align="center">
           <span class="screenHeaderSpan">Role Admin</span>
		</td>
	</tr>
    <tr>
    	<td>
    		<div class="fixedDiv" id="outterDiv">
				<table>
		            <tr>
						<td style="padding-left: 250px; " valign="top">
		            		<table>
			            		<tr>
			            			 <input type="hidden" name="oid" value="${oid}" />
		                        </tr>
		                         <tr>
		                            <s:textfield key="roleName" label="Role Name" maxlength="50" size="30" required="true" onkeyup="acceptOnlyCharacterPatient(this);" onchange="initialsInCapital(this.value, this.name);"/>
		                        </tr>
		                         <tr>
		                            <s:textfield key="roleDescription" label="Role Description" maxlength="50" size="30" required="true" onchange="initialsInCapital(this.value, this.name);"/>
		                        </tr>
		                    <tr>
				     		<td style="vertical-align:top;text-align:right;">
				     		<table>
							<tr>
								<td style="width:150px;height:0px;nowrap:wrap;">
      									<table>
       									<tr>
        									<td>
        										<span id="availablePermissionsNotFoundMessage"></span>
								 				<s:textfield label="" labelSeparator="" cssStyle="visibility:hidden;width:0px;height:0px" size="1" name="selectedPermissionsMessage" />
								 			</td>
							 			</tr>
						 			</table>
						 		</td>
							</tr>
				     		<tr>
				     			<td style="font-weight:bold;text-align:right;"><i>Select Permission<font style="font-weight:bold;" color="red">*</font>:</i></td>
				     		</tr>
                   			
				     		</table>
				     		</td>
					    	<td style="text-align:left;" colspan="1">
					     		<table>
					     			<tr>
		        						<td>
		        							<table>
		        								<tr>
			        								<td>
											  			<s:select cssStyle="width:210px;height:210px" list="availablePermissionList" listKey="optionId" listValue="optionText" multiple="true" name="availablePermissions" emptyOption="false" ondblclick="listbox_moveacross('availablePermissions', 'selectedPermissions', false);"></s:select>
											  		</td>
										  		</tr>
										  	</table>
										</td>
		                			    <td> 
		                			    	<table>
		                			    		<tr>
				                        			<td style="text-align:center;"><a href="#" onclick="listbox_moveacross('availablePermissions', 'selectedPermissions', false);" >ADD</a></td>
				                        		</tr>
				                        		<tr>
				                        			<td style="text-align:center;"><a href="#" onclick="listbox_moveacross('selectedPermissions','availablePermissions', false);">REMOVE</a></td>
				                        		</tr>
				                        		<tr>
				                        			<td style="text-align:center;"><a href="#" onclick="listbox_selectall('availablePermissions', true, 'availablePermissions', 'selectedPermissions', false);">ADD ALL</a></td>
				                        		</tr>
				                        		<tr>
				                        			<td style="text-align:center;"><a href="#" onclick="listbox_removeall('selectedPermissions', true , 'selectedPermissions' , 'availablePermissions', false);">REMOVE  ALL</a></td>
				                        		</tr>
				                        	</table>
	            			           	</td>
				                        <td>
				                        	<table>
		        								<tr>
			        								<td>
			        								 	<s:select required="true" cssStyle="width:210px;height:210px" list="selectedPermissionList" listKey="optionId" listValue="optionText" multiple="true" name="selectedPermissions" emptyOption="false" ondblclick="listbox_moveacross('selectedPermissions','availablePermissions', false );"></s:select>
					 								</td>
											 	</tr>
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
   		<td>
   			<div class="buttonDiv" id="submitDiv">
			 	<table>
					<tr>
						<td colspan="2" style="text-align:center;">
						<%-- <input type="button" onclick="listbox_selectAllForSubmit('availablePermissions', true); listbox_selectAllForSubmit('selectedPermissions', true); document.forms[0].submit();" style="width:60px;" value="Save" />--%>
						<a href="#"  onmouseover="return changeImage('save')" 
									 onmouseout= "return changeImageBack('save')" 
									 onmousedown="return handleMDown('save')" 
									 onclick="goToOnclickFunction();" 	 
						><img name="save" src="../images/savebutton.png" alt="Saves This Form" /></a>
						<%-- <input id="cencelButton" type="button" style="width:60px;"  onclick="goToHomePage();" value="Cancel" />--%>
						<a href="#"  onmouseover="return changeImage('cancel')" 
									 onmouseout= "return changeImageBack('cancel')" 
									 onmousedown="return handleMDown('cancel')"
									 <c:choose>
									 <c:when test="${sessionScope.moduleName eq \"Gynosoft\"}">
									 	onclick="goToHomePage();"
									 </c:when>
									 <c:otherwise>
										onclick="confirmLabTestCancel();"										 	
									 </c:otherwise>
									 </c:choose>
						><img name="cancel" src="../images/cancelbutton.png" alt="Cancel This Form & go to HomePage" /></a>
						</td>
			        </tr>
			 	</table>
			</div>
   		</td>
   	</tr>
</table>

</s:form>

<script type="text/javascript">
	changeWidth(document.getElementById('outterDiv'));
	changeWidthInSubmit(document.getElementById('submitDiv'));
</script>

</body>
</html>

