<%@page import="org.jmesa.web.HttpServletRequestWebContext"%>
<%@ taglib uri="/WEB-INF/tld/jmesa.tld" prefix="jmesa" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="../WEB-INF/tld/custom-functions.tld" prefix="fn" %>

<html>
	<head>
    	<title>Issue</title>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=7" />
		<jsp:include page="include.jsp"></jsp:include>
		<script type="text/javascript">	

		function getIssues(issueNumber)
		{
			pleaseWait('window.location.href = \'editIssue?issueNumber=' + issueNumber +'&isInvoked=true\'');
			
		}

		function confirmDelete(delUrl)
		{
			
			 pleaseWait('document.location = \'' +delUrl+ '\'');
				        
		}
       
       function addNewIssueFunction()
		{
			window.location.href = 'editIssue.action';
		}
		


		function commonSearch()
		{
			//pleaseWait('document.location = contextPath + \'/its/viewIssues.action\'');
			pleaseWait('document.forms[0].submit();');
			
		}

		function changePassword(userIdValue)
		{
			pleaseWait('window.location.href = \'editChangePassword?userId=' + userIdValue + '&calledFrom=userDetails \''); 
		}
	
		
		function clearSearch()
		{
			pleaseWait('document.location = contextPath + \'/its/viewIssues.action?clear=true\'');
		}

		function goToViewPage()
		{
			pleaseWait('document.location = contextPath + \'/its/viewIssues.action?cancel=true\'');
		
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

		function toggleToDate(obj, field)
		{
			var fieldCalender = field+'Calender';
			if (obj.value == '<>')
			{
				document.issueSearch.elements[field].disabled=false;
				document.issueSearch.elements[field].style.backgroundColor = 'white';
				document.issueSearch.elements[field].style.visibility='visible';
			}
			else
			{
				document.issueSearch.elements[field].disabled=true;
				document.issueSearch.elements[field].style.backgroundColor = 'lightgray';
			}
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
		
		
		</script>
    </head>
    
    <body class="bodyClass">
		<table width="100%;">
	         <tr>
	           <td width="100%;">
	 	            <jsp:include page="menu.jsp" />
	 	      </td>
	 	    </tr>
	 	</table>
       
		 <table width="100%;">
        <tr>
          <td width="100%;">
		<form name="issueSearch" action="${pageContext.request.contextPath}/its/viewIssues.action">
            <table class="mainTable" border="0" cellpadding="0" cellspacing="0" width="100%;" align="center">
            <tr>
            	<td class="screenHeader">
            	<input type="hidden" name="isInvokedFromIssueSearch" value="true">
            	<input type="hidden" name="fromJmesa" value="">
	            	<table  style="width:100%">
		            	<tr>
		            		<td colspan="35%">
		            		</td>
			               <td class="screenHeader" width="25%" style="text-align:center; background: url(../images/headerback.png); z-index: 100;" >
			         		      	
			         		      	<span class="screenHeaderSpan">View Issues</span>
         			        
         			        </td>
			                <td width="35%;" style="text-align:right;">
		
           		            		
			                  	<%-- <span><a style="color:white;font-weight:bold;font-size:13px;" href="${pageContext.request.contextPath}/hms/editDoctorInformation.action">Add New Doctor</a></span>--%>
			                	<a href="#"  
									onmouseover="return changeImage('addnewentryheader')" 
									onmouseout= "return changeImageBack('addnewentryheader')" 
									onmousedown="return handleMDown('addnewentryheader')" 
									onclick="setTimeout('addNewIssueFunction();',1000); document.getElementById('pleasewaitDiv').style.visibility = 'visible';" 
							><img name="addnewlocationheader" 
								  src="../images/addnewentryheaderbutton.png" 
								  alt="Allows you to Add New Entry " /></a>
			                </td>
			             </tr>
	                </table>
	                 </td>
                 </tr>
             
          
           <tr>    
            <td align="center">
            <table  border="1" bordercolor="red" style="width:100%;" align="center">
             <tr>
            	<td style=" width: 100%; margin: 0%;" align="center">
             	     
             	     <div class="fixedDiv" id="outterDiv" align="center">
               		<table>
               		<jsp:include page="searchCriteria.jsp"/>
            		 </table>
            		</div>
            		           		
            	</td>
            </tr>
            
              
           
            <c:if test="${issueList != null && not empty issueList}">
            <tr>
            <td style="text-align: -moz-center; width:100%">
            <input type="hidden" name="type" value="issueSearch"/>
             <div class="divForJmesa"style="vertical-align: top;">
            <jmesa:tableModel
               id="issueSearch" 
               items="${issueList}"
               maxRows="15"
               maxRowsIncrements="15,30,50,100"
               stateAttr="restore"
               var="bean"
               exportTypes="excel"
               >
               <jmesa:htmlTable caption="" width="100%" style="background-color:white;">               
                   <jmesa:htmlRow> 
                       <jmesa:htmlColumn property="issueNumber" title="Issue Number" width="10%"><div style="text-align:left; margin-left:20px;"> ${bean.newIssue.issueNumber} </div></jmesa:htmlColumn>
                       <jmesa:htmlColumn property="issueDate"
							          	pattern="dd-MM-yyyy" 
							           	cellEditor="org.jmesa.view.editor.DateCellEditor"
							           	title="Issue Date"
							           	filterable="true"
							           	width="11%"
			  		  />  
                         <jmesa:htmlColumn property="developer" title="Developer" width="10%"><div style="text-align:left; margin-left:20px;"> ${bean.developer} </div></jmesa:htmlColumn>
                         <jmesa:htmlColumn property="project" title="Project" width="12%"><div style="text-align:left; margin-left:20px;"> ${bean.project} </div></jmesa:htmlColumn>
                       <jmesa:htmlColumn property="hours" title="Hours" width="8%"><div style="text-align:left; margin-left:20px;"> ${bean.hours} </div></jmesa:htmlColumn>
                         <jmesa:htmlColumn property="activity" title="Activity" width="10%"><div style="text-align:left; margin-left:20px;"> ${bean.activity} </div></jmesa:htmlColumn>
                          <jmesa:htmlColumn property="comment" title="Comment" width="30%"><div style="text-align:left; margin-left:20px;"> ${bean.comment} </div></jmesa:htmlColumn>
                         
                       <jmesa:htmlColumn sortable="false" property="" title="Action" filterable="false" width="20%">
                       <a href="#" onclick="getIssues('${bean.newIssue.issueNumber}');">Edit</a>
                         <a href="javascript:confirmDelete('deleteIssues?delete=true&issueNumber=${bean.newIssue.issueNumber}')">Delete</a>
                       </jmesa:htmlColumn>
                   </jmesa:htmlRow>
               </jmesa:htmlTable> 
            </jmesa:tableModel>
            </div>
             </td>
            </tr>
            </c:if>
		</table>
		 </td>
	 </tr>
	 </table>
     </form>
	  </td>
	 </tr>
	</table>	
	</body>

	<script type="text/javascript">
	function onInvokeAction(id) 
  	 {
      	document.forms[0].elements['fromJmesa'].value = true;
      	document.forms[0].elements['isInvokedFromIssueSearch'].value = false;
      	$.jmesa.setExportToLimit(id, '');
      	$.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
    }

       	function onInvokeExportAction(id) 
       	{
        	var parameterString = $.jmesa.createParameterStringForLimit(id);
        	parameterString += '&developer=' +
        	document.forms[0].elements['developer'].value +
			   '&issueNo=' +
			   document.forms[0].elements['issueNo'].value +
			   '&searchFromDate=' +
			   document.forms[0].elements['searchFromDate'].value +
			   '&searchToDate=' +
			   document.forms[0].elements['searchToDate'].value +
			   '&dateSign=' +
			   document.forms[0].elements['dateSign'].value;

        	location.href = '${pageContext.request.contextPath}/its/viewIssues.action?type=basicExport&' + parameterString;
        }
       	//changeWidthForJMesaOutterDiv(document.getElementById('outterDiv'));
		//setJmesaTableWidth('#issueSearch');
    </script>

</html>
    