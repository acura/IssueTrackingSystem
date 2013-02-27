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

	</script>
</head>

<body onload="document.getElementById('accountType').focus();">
<jsp:include page="menu.jsp" />

<s:form id="editAccount" name="editAccount" action="saveAccount">

<table class="mainTable" border="0" cellpadding="0" cellspacing="0" style="width: 100%;">
	<tr>
        <td  class="screenHeader" align="center">
              <span class="screenHeaderSpan">Account</span>
		</td>
	</tr>
    <tr>
    	<td style="width: 100%;">
    		<div class="scrollableDiv" id="outterDiv">
				<table style="width: 98%;">
           			<tr>
						<td style="width: 100%;" valign="top">
	            			<table style="width: 100%;">
	            				<tr>
            						<s:hidden key="oid" value="%{oid}"/>
            						<s:hidden key="accountId"  value="%{accountId}"/>
									<s:hidden name="password" value="%{password}"/>
	            				</tr>
       							<c:if test="${not empty oid}">
			                        <tr>
			                        	<td style="width: 50%;font-weight:bold;text-align:right;"><i>Account Id<font color="red">*</font>:</i></td>
			                        	<td style="width: 50%;">
			                        		<table>
		                        				<s:textfield key="dummyAccountId" label="" labelSeparator="" maxlength="50" size="30" value="%{accountId}" disabled="true" />
			                        		</table>
			                        	</td>
			                        </tr>
		                         </c:if>
		                         <tr>
		                         	<td style="width: 50%;font-weight:bold;text-align:right;"><i>Account Type<font color="red">*</font>:</i></td>
		                         	<td style="width: 50%;">
		                         		<table>
		                         			<s:select list="#{'':'', 'Individual':'Individual', 'Hospital':'Hospital', 'Lab':'Lab'}"
			                        		key="accountType" label="" labelSeparator=""></s:select>	
		                         		</table>
		                         	</td>
		                        	
		                        </tr>
		                         <tr>
		                         	<td style="width: 50%;font-weight:bold;text-align:right;"><i>Owner Name:</i></td>
		                         	<td style="width: 50%;">
		                         		<table>
											<s:textfield key="ownerName" label="" labelSeparator="" maxlength="50" size="30"  onkeyup="acceptOnlyCharacter(this);" onchange="capWords(this.value, this.name);"/>		                         		
		                         		</table>
		                         	</td>
		                        </tr>
		                        <tr>
		                        	<td style="width: 50%;font-weight:bold;text-align:right;"><i>Title:</i></td>
		                        	<td style="width: 50%;">
		                        		<table>
		                        			<s:textfield key="title" label="" labelSeparator="" maxlength="50" size="30" />	
		                        		</table>
		                        	</td>
		                        </tr>
		                        <tr>
		                        	<td style="width: 50%;font-weight:bold;text-align:right;"><i>Address:</i></td>
		                        	<td style="width: 50%;">
		                        		<table>
		                        			<s:textarea key="address" label="" labelSeparator="" rows="3" cols="22" cssClass="textAreaFontFamily" />	
		                        		</table>
		                        	</td>
		                        </tr>
		                        <tr>
		                        	<td style="width: 50%;font-weight:bold;text-align:right;"><i>Phone Number:</i></td>
		                        	<td style="width: 50%;">
		                        		<table>
		                        			<s:textfield key="phoneNumber" label="" labelSeparator="" maxlength="50" size="15" />	
		                        		</table>
		                        	</td>
		                        </tr>
		                        <tr>
		                        	<td style="width: 50%;font-weight:bold;text-align:right;"><i>Mobile Number:</i></td>
		                        	<td style="width: 50%;">
		                        		<table>
		                        			<s:textfield key="mobileNumber" label="" labelSeparator="" maxlength="50" size="15" />	
		                        		</table>
		                        	</td>
		                        </tr>
		                        <tr>
		                        	<td style="width: 50%;font-weight:bold;text-align:right;"><i>Email Id<font color="red">*</font>:</i></td>
		                        	<td style="width: 50%;">
		                        		<table>
		                        			<s:textfield key="emailId" label="" labelSeparator="" maxlength="50" size="30" />	
		                        		</table>
		                        	</td>
		                        </tr>
		                        <tr>
		                        	<td style="width: 50%;font-weight:bold;text-align:right;"><i>AlterNate Email Id:</i></td>
		                        	<td style="width: 50%;">
		                        		<table>
		                        			<s:textfield key="alterNateEmailId" label="" labelSeparator="" maxlength="50" size="30" />	
                        				</table>
		                        	</td>
		                            
		                        </tr>
		                        <tr>
		                        	<td style="width: 100%;" colspan="2">
			                      	<table style="width: 100%;">
			                      		<tr>
			                      			<td style="text-align: center;" colspan="2">
				                      			<span id="startDateValMessage"></span>
			                      				<s:textfield key="startDateValidationMessage" label="" labelSeparator="" cssStyle="visibility:hidden; height:0px;" size="1" ></s:textfield>	
				                      		</td>
			                      		</tr>
			                      		<tr>
				                      		<td style="width: 50%;font-weight:bold;text-align:right;"><i>Subscription Start Date <font color="red">*</font>:</i></td>
											<td style="text-align:left;width: 50%;">
						                       <table>
						                       		<tr>
						                       			<td>
					                       				<table>
						                       				<s:textfield key="subcriptionStartDate" label="" labelSeparator="" maxlength="10" size="10" onkeyup="formatDate(this);" onblur="validateDate(this, 'startDateValMessage','CURRENT_CENTURY'); " />		
					                       				</table>
						                       			</td>
						                       			<td style="text-align:left;">
								                    	   <script type="text/javascript"> new tcal ({'formname': 'editAccount', 'controlname': 'subcriptionStartDate'});</script> 	
								                        </td>
						                       		</tr>
		     			                      </table>
											</td>
					                    </tr>
			                      	</table>
			                      	</td>
		                        </tr>
		                        <tr>
		                        	<td style="width: 100%;" colspan="2">
			                      	<table style="width: 100%;">
			                      		<tr>
			                      			<td style="text-align: center;" colspan="2">
				                      			<span id="endDateValMessage"></span>
			                      				<s:textfield key="endDateValidationMessage" label="" labelSeparator="" cssStyle="visibility:hidden; height:0px;" size="1" ></s:textfield>	
				                      		</td>
			                      		</tr>
			                      		<tr>
				                      		<td style="width: 50%;font-weight:bold;text-align:right;"><i>Subscription End Date <font color="red">*</font>:</i></td>
											<td style="text-align:left;width: 50%;">
						                       <table>
						                       		<tr>
						                       			<td>
					                       				<table>
						                       				<s:textfield key="subscriptionEndDate" label="" labelSeparator="" maxlength="10" size="10" onkeyup="formatDate(this);" onblur="validateDate(this, 'endDateValMessage','CURRENT_CENTURY'); " />		
					                       				</table>
						                       			</td>
						                       			<td style="text-align:left;">
								                    	   <script type="text/javascript"> new tcal ({'formname': 'editAccount', 'controlname': 'subscriptionEndDate'});</script> 	
								                        </td>
						                       		</tr>
		     			                      </table>
											</td>
					                    </tr>
			                      	</table>
			                      	</td>
		                        </tr>
		                        <tr>
		                        	<td style="width: 50%;font-weight:bold;text-align:right;"><i>Amount Paid:</i></td>
		                            <td style="width: 50%;">
		                            	<table>
		                            		<s:textfield key="amountPaid" label="" labelSeparator="" maxlength="10" size="30" onkeypress="formatForNumeric(this);" onchange="this.value = decimalFormat(this.value);"/>	
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

