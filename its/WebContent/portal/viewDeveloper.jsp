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
				pleaseWait('window.location.href = \'editDeveloper?oid=' + oid + '&isInvokedFromViewDeveloper=true\'');
				
			}

			
			function addNewDeveloper()
			{
				window.location.href = 'editDeveloper.action?isInvokedFromViewDeveloper=false'; 
				 
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
		<form name="DeveloperSearchEntriesForm" action="${pageContext.request.contextPath}/its/viewDeveloper.action">
		<table class="mainTable" border="0" cellpadding="0" cellspacing="0" >
            <tr>
            	<td class="screenHeader">
	            	<table style="width:98%">
		            	<tr>
		            		<td colspan="37">
		            		</td>
			                <td style="text-align:right; width: 28%;">
			                	<span class="screenHeaderSpan">Developer Details</span>
			                </td>
			                <td style="text-align:right;">
		                	<%-- <span><a style="color:white;font-weight:bold;font-size:13px;" href="${pageContext.request.contextPath}/hms/editHMSUser.action?isInvokedFromViewHmsUser=false&isFromProLab=${sessionScope.moduleName}">Add New User</a></span> --%>
		                	<a href="#"  
								onmouseover="return changeImage('addnewuserheader')" 
								onmouseout= "return changeImageBack('addnewuserheader')" 
								onmousedown="return handleMDown('addnewuserheader')" 
								onclick="setTimeout('addNewAccount();',1000); document.getElementById('pleasewaitDiv').style.visibility = 'visible';" 
							><img name="addnewuserheader" 
							  src="../images/addnewuserheaderbutton.png" 
							  alt="Allows you to Add New User..." /></a>
			                </td>
		                </tr>
	                </table>
                </td>
            </tr>
            
            <tr>
            <td style="text-align:center; vertical-align: top;">
            <input type="hidden" name="type" value="DeveloperSearch"/>
            <div class="divForJmesa" style="vertical-align: top;" id="outterDiv">
            <jmesa:tableModel
               id="DeveloperSearch" 
               items="${developerList}"
               maxRows="15"
               maxRowsIncrements="15,30,50,100"
               stateAttr="restore"
               var="bean"
               exportTypes="excel"
               >
               <jmesa:htmlTable caption="" width="100%;" style="background-color:white;">               
                   <jmesa:htmlRow> 
                       <jmesa:htmlColumn property="oid" title=" Oid" width="15%" >
                              <div align="center" style="text-align: center;">
                                  ${bean.oid}
                              </div>
                       </jmesa:htmlColumn>

                       <jmesa:htmlColumn property="developerName" title="Developer Name" width="20%"/>
                
                       <jmesa:htmlColumn sortable="false" property="" title="Action" filterable="false" width="10%" >
                       
                       <a href="#" onclick="getDeveloper('${bean.oid}');">Edit</a>
                       <a href="javascript:confirmDelete('deleteDeveloper?delete=true&oid=${bean.oid}')">Delete</a>
                        
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
