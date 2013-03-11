<%@page import="org.jmesa.web.HttpServletRequestWebContext"%>
<%@ taglib uri="/WEB-INF/tld/jmesa.tld" prefix="jmesa" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    
    <head>
    	<title>Account Search Entries</title>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=7" />
		<jsp:include page="include.jsp"></jsp:include>
		<script type="text/javascript">	
		
			function getDeveloper(oid)
			{
				pleaseWait('window.location.href = \'editNewIssue?oid=' + oid + '&isInvokedFromViewNewIssue=true\'');
				
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
		<form name="NewIssueSearchEntriesForm" action="${pageContext.request.contextPath}/its/viewNewIssue.action">
		<table class="mainTable" border="0" cellpadding="0" cellspacing="0" >
            <tr>
            	<td class="screenHeader">
	            	<table style="width:98%">
		            	<tr>
		            		<td colspan="37">
		            		</td>
			                <td style="text-align:center; width: 100%; ">
			                	<span class="screenHeaderSpan">New Issue Details</span>
			                </td>
			               
		                </tr>
	                </table>
                </td>
            </tr>
            
            <tr>
            <td style="text-align:center; vertical-align: top;">
            <input type="hidden" name="type" value="NewIssueSearch"/>
            <div class="divForJmesa" style="vertical-align: top;" id="outterDiv">
            <jmesa:tableModel
               id="NewIssueSearch" 
               items="${newIssueList}"
               maxRows="15"
               maxRowsIncrements="15,30,50,100"
               stateAttr="restore"
               var="bean"
               exportTypes="excel"
               >
               <jmesa:htmlTable caption="" width="100%;" style="background-color:white;">               
                   <jmesa:htmlRow> 
                       <jmesa:htmlColumn property="oid" title=" Oid" width="2%" >
                              <div align="center" style="text-align: center;">
                                  ${bean.oid}
                              </div>
                       </jmesa:htmlColumn>

                       <jmesa:htmlColumn property="issueNo" title="Issue No" width="2%"/>
                       <jmesa:htmlColumn property="summary" title="Summary" width="15%"/>
                       <jmesa:htmlColumn property="detail" title="Detail" width="27%"/>
                       <jmesa:htmlColumn property="system" title="System" width="5%"/>
                       <jmesa:htmlColumn property="severity" title="Severity" width="5%"/>
                       <jmesa:htmlColumn property="priority" title="Priority" width="5%"/>
                       <jmesa:htmlColumn property="estimatedStartDate" title="Estimated Start Date" width="5%"/>
                       <jmesa:htmlColumn property="estimatedEndDate" title="Estimated End Date" width="5%"/>
                       <jmesa:htmlColumn property="estimatedHours" title="Estimated Hours" width="2%"/>
                       <jmesa:htmlColumn property="actualStartDate" title="Actual Start Date" width="5%"/>
                       <jmesa:htmlColumn property="actualEndDate" title="Actual End Date" width="5%"/>
                       <jmesa:htmlColumn property="loggedBy" title="Logged By" width="5%"/>
                       <jmesa:htmlColumn property="targetVersion" title="Target Version" width="5%"/>
                       <jmesa:htmlColumn property="assignedTo" title="Assinged To" width="5%"/>
                
                       <jmesa:htmlColumn sortable="false" property="" title="Action" filterable="false" width="2%" >
                       
                       <a href="#" onclick="getNewIssue('${bean.oid}');">Edit</a>
                       <a href="javascript:confirmDelete('deleteNewIssue?delete=true&oid=${bean.oid}')">Delete</a>
                        
                       </jmesa:htmlColumn>
                   </jmesa:htmlRow>
               </jmesa:htmlTable> 
            </jmesa:tableModel>
            </div>
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
       	location.href = '${pageContext.request.contextPath}/hms/viewDeveloper.action?type=basicExport&' + parameterString;
	}
    changeWidthForJMesaOutterDiv(document.getElementById('outterDiv'));
    setJmesaTableWidth('#DeveloperSearch');
</script>

</html>
