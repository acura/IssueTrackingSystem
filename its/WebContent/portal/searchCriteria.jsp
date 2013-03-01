
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table style="width:100%">
 <tr>
		<td style="text-align: center;">
		<div class="searchFieldsDiv">
		<table width="100%">
		 <c:if test="${not empty isFromSearch}">
		 	<tr>
			 	<td width="100%;" style="text-align: center;">
			 	<table width="100%;" style="text-align: -moz-center;">
			 		<s:textfield key="searchFieldError" cssStyle="visibility:hidden;" label="" labelSeparator="" />
			 	</table>
			 	</td>
			 </tr>
		 </c:if>
		 
		 <c:if test="${recoreNotFoundToDay eq \"true\"}">
            		<tr>
            			<td colspan="4" style="text-align:center;">
            				<span style="font-size:small; font-weight:bold; color: red;text-align: left;">
                                No Records Present for Today	
           					</span>
            			</td>
            			
            		</tr>
            </c:if>
           
		  <c:if test="${recoreNotFound eq \"true\"}">
            		<tr>
            			<td colspan="4" style="text-align:center;">
            				<span style="font-size:small; font-weight:bold; color: red;text-align: left;">
            				  No Records For Given Search Criteria
          					 </span>
            			</td>
            		</tr>
            </c:if>
		 
		 <tr>
			<td style="text-align:center;">
			<table width="100%">
				<tr>
				        
				<td style="width: 30%;">
					<table style="width:100%;">
							<tr>
							<td style="width:40%;font-weight:bold;text-align:right;nowrap:nowrap;"><i>Developer:</i></td>
							<td style="width:60%;text-align: left;">
							
							<table >
								<s:select list="#{'':'','Amol Gadre':'Amol Gadre', 'Mahesh Kalshetty':'Mahesh Kalshetty', 'Mahesh Shivarkar':'Mahesh Shivarkar', 'Ashok Kale':'Ashok Kale','Swati Malode':'Swati Malode','Dolly Bisen':'Dolly Bisen','Mayur kamte':'Mayur kamte','Nutan Chougale':'Nutan Chougale','Supriya Jadhav':'Supriya Jadhav','Pooja Palekar':'Pooja Palekar'}"  key="developer" label="" labelSeparator=""    
									/>
							</table>
							</td>
							</tr>
					</table>
				</td> 
				<td style="width: 28%;">
					<table style="width:100%;">
							<tr>
							<td style="width:30%;font-weight:bold;text-align:right;"><i>Issue No:</i></td>
							<td style="width:70%;text-align: left;">
							<table>
						     <s:textfield key="issueNo" label="" labelSeparator="" maxlength="10" size="13" onkeyup="" />
						    </table>
						    </td>
						    </tr>
					</table>
				</td>
	  		</tr>
	  		<tr>
				<td  style="width: 30%;">
   		  			<table style="width:100%;">
					<tr>
						<td style="width:40%;font-weight:bold;text-align:right;"><i>Issue Date:</i></td>
						<td style="width:60%;text-align: left;">
						<table>
					    	<s:select list="#{'':'' , '=':'Equal To', '<':'Less Than' , '>':'Greater Than', '<=':'Less Than Equal To', '>=':'Greater Than Equal To', '<>':'Between'}" 
					    	name="dateSign" id="dateSign" onchange="toggleToDate(this, 'searchToDate');"></s:select>
					    </table>
					    </td>
				    </tr>
					</table>
				</td>
				
				<td style="width: 22%;">
					<table style="width:100%;">
					<tr>
					<span id="fromDateValMessage"></span>
						<td style="width:28%;text-align:right;font-weight:bold;vertical-align: super;"><i>From:</i></td>
				     	<td style="width:72%;text-align:left;" >
					      <table>
					        <tr>
					          <td style="">
					          <table>
					              <tr>
					                  <s:textfield key="searchFromDate"  name="searchFromDate" id="fromDate" label="" labelSeparator="" maxlength="10" size="13" onkeyup="formatDate(this);" onblur="validateDate(this, 'fromDateValMessage','TWIN_CENTURIES'); " />
					              </tr>
					          </table>
					          </td>
					          
					         </tr>
					      </table>
				        </td>
					</tr>
			    </table>
				</td>
				<td style="width: 48%;" colspan="2">
					<table style="width: 100%">
						<tr>
							<span id="toDateValMessage"></span>
					     	<td width="12%" style="font-weight:bold;text-align:right;"><i>To:</i></td>
					     	<td width="88%" style="text-align:left;">
						      <table>
						        <tr>
						          <td>
						          <table>
						              <tr>
						                  <s:textfield key="searchToDate" id="toDate"  label="" labelSeparator="" maxlength="10" size="13" onkeyup="formatDate(this);" onblur="validateDate(this, 'fromDateValMessage','TWIN_CENTURIES'); " />
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
			</td>
		</tr>
			<tr>
				<td width="100%;" style="text-align: center;">
				<table width="100%;" style="text-align: center;">
						<tr>
						<td colspan="2" style="text-align: center;">
						<a href="#"  onmouseover="return changeImage('search')" 
									 onmouseout= "return changeImageBack('search')" 
									 onmousedown="return handleMDown('search')" 
									 onclick="commonSearch();"
						><img name="search" src="../images/searchbutton.png" alt="Search Records" /></a>
						<a href="#"  onmouseover="return changeImage('cancelonsearch')" 
									 onmouseout= "return changeImageBack('cancelonsearch')" 
									 onmousedown="return handleMDown('cancelonsearch')" 
									 onclick="goToViewPage();"
						><img name="cancelonsearch" src="../images/cancelonsearchbutton.png" alt="Cancel This Form & go to HomePage" /></a>
						<a href="#"  onmouseover="return changeImage('clear')" 
									 onmouseout= "return changeImageBack('clear')" 
									 onmousedown="return handleMDown('clear')" 
									 onclick="clearSearch();"
						><img name="clear" src="../images/clearbutton.png" alt="Clear All Search Field" /></a>
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
    <script type="text/javascript">
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
	$(function() {
		$( "#toDate" ).datepicker({ 
				dateFormat: 'dd-mm-yy', 
				showAnim: "drop",
				changeMonth: true,
				changeYear: true
		 });
		$.datepicker.setDefaults($.datepicker.regional['']);     
		$("#toDate").datepicker($.datepicker.regional['']); 
	    });

	$(function() {
		$( "#fromDate" ).datepicker({ 
				dateFormat: 'dd-mm-yy', 
				showAnim: "drop",
				changeMonth: true,
				changeYear: true
		 });
		$.datepicker.setDefaults($.datepicker.regional['']);     
		$("#fromDate").datepicker($.datepicker.regional['']); 
	    });
	

	
	toggleToDate(document.getElementById('dateSign'),'searchToDate');
	</script>

