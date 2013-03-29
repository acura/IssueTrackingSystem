<%@page import="org.jmesa.web.HttpServletRequestWebContext"%>
<%@ taglib uri="/WEB-INF/tld/jmesa.tld" prefix="jmesa" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    
    <head>
    	<title>Issue Description</title>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=7" />
		<jsp:include page="include.jsp"></jsp:include>
		<script type="text/javascript">	
		
			function getIssueDescription(issueNumber)
			{
				pleaseWait('window.location.href = \'viewIssueDescription?issueNumber=' + issueNumber + '&isInvokedFromViewIssues=true\'');
				
			}

			function getupdateDetails(issueNumber)
			{
				pleaseWait('window.location.href = \'editUpdate?issueNumber=' + issueNumber +'&isInvoked=true\'');
				
			}
			
			 

			function confirmDelete(delUrl)
			{
				alert(delUrl);
				 pleaseWait('document.location = \'' +delUrl+ '\'');
					        
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
		<form name="IssueDescriptionForm" action="${pageContext.request.contextPath}/its/viewIssues.action">
		<table class="mainTable" border="0" cellpadding="0" cellspacing="0" >
            <tr>
            	<td class="screenHeader">
	            	<table style="width:98%">
		            	<tr>
		            		<td colspan="37">
		            		</td>
			                <td style="text-align:center; width: 100%; ">
			                	<span class="screenHeaderSpan">Issue Details</span>
			                </td>
			                
			                 <td width="35%;" style="text-align:right;">
		
           		            	<a href="#" onclick="getupdateDetails('${bean.newIssue.issueNumber}');">Update</a>	
			                  	<%-- <span><a style="color:white;font-weight:bold;font-size:13px;" href="${pageContext.request.contextPath}/hms/editDoctorInformation.action">Add New Doctor</a></span>--%>
			                	 	<%--<a href="#"  
									onmouseover="return changeImage('addnewentryheader')" 
									onmouseout= "return changeImageBack('addnewentryheader')" 
									onmousedown="return handleMDown('addnewentryheader')" 
									onclick="setTimeout('updateDetailsFunction();',1000); document.getElementById('pleasewaitDiv').style.visibility = 'visible';" 
							><img name="addnewlocationheader" 
								  src="../images/addnewentryheaderbutton.png" 
								  alt="Allows you to Update Entry " /></a>--%>
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
               		<table style=" width: 100%" >
               		<jsp:include page="issueDetails.jsp"/>
               		</table>
            		</div>
            	</td>
            </tr>
            
         
            <tr>
            <td style="text-align:center; vertical-align: top;">
            <input type="hidden" name="type" value="IssueDescription"/>
            <div class="divForJmesa" style="vertical-align: top;" id="outterDiv">
            <jmesa:tableModel
               id="IssueDescription" 
               items="${issueList}"
               maxRows="15"
               maxRowsIncrements="15,30,50,100"
               stateAttr="restore"
               var="bean"
               exportTypes="excel"
               >
               <jmesa:htmlTable caption="" width="100%;" style="background-color:white;">               
                   <jmesa:htmlRow> 
                       <jmesa:htmlColumn property="comment" title="Comment" width="80%"><div style="text-align:left; margin-left:20px;"> ${bean.comment} </div></jmesa:htmlColumn>
                      <jmesa:htmlColumn sortable="false" property="" title="Action" filterable="false" width="20%">
                       <a href="#" onclick="getIssueDescription('${bean.newIssue.issueNumber}');">Edit</a> 
                       </jmesa:htmlColumn>
                   </jmesa:htmlRow>
               </jmesa:htmlTable> 
            </jmesa:tableModel>
            </div>
            </td>
            </tr>
            
            <tr>
            	<td style=" width: 100%; margin: 0%;" align="center">
             	     <div class="fixedDiv" id="outterDiv" align="center">
               		<table style=" width: 100%" >
               		<jsp:include page="editUpdate.jsp"/>
               		</table>
            		</div>
            	</td>
            </tr>
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
    	$.jmesa.setExportToLimit(id, '');
        $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}

    function onInvokeExportAction(id) 
    {
    	var parameterString = $.jmesa.createParameterStringForLimit(id);
       	location.href = '${pageContext.request.contextPath}/its/viewIssues.action?type=basicExport&' + parameterString;
	}
    changeWidthForJMesaOutterDiv(document.getElementById('outterDiv'));
    setJmesaTableWidth('#IssueDescription');
</script>

</html>
