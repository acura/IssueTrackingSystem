<%@page import="org.jmesa.web.HttpServletRequestWebContext"%>
<%@ taglib uri="/WEB-INF/tld/jmesa.tld" prefix="jmesa" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    
    <head>
    	<title>HMS Role Search Entries</title>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=7" />
		<jsp:include page="include.jsp"></jsp:include>
		<script type="text/javascript">	
		
			function getHMSRole(oidValue)
			{
				pleaseWait('window.location.href = \'editRole?oid=' + oidValue + '&moduleName=' + 
			  			'<%=session.getAttribute("moduleName")%>' + '\''); 
			}
			function AddNewRoll()
			{
				window.location.href = 'editRole.action?moduleName=' + 
				'<%=session.getAttribute("moduleName")%>'; 
			}
					
		</script>
    </head>
    
    <body class="bodyClass">
    	<jsp:include page="menu.jsp" />
		<form name="HMSRoleSearchEntriesForm" action="${pageContext.request.contextPath}/hms/viewRole.action">
		<table class="mainTable" border="0" cellpadding="0" cellspacing="0" >
            <tr>
            	<td class="screenHeader">
	            	<table style="width:98%">
		            	<tr>
		            		<td colspan="37">
		            		</td>
			                <td style="text-align:right; width: 35%;"">
			                	<span class="screenHeaderSpan">Role Search Entries</span>
			                </td>
			                <td style="text-align:right;">
			                	<%-- <span><a style="color:white;font-weight:bold;font-size:13px;" href="${pageContext.request.contextPath}/hms/editRole.action">Add New Role</a></span>--%>
			                	<a href="#"  
									onmouseover="return changeImage('addnewroleheader')" 
									onmouseout= "return changeImageBack('addnewroleheader')" 
									onmousedown="return handleMDown('addnewroleheader')" 
									onclick="setTimeout('AddNewRoll();',1000); document.getElementById('pleasewaitDiv').style.visibility = 'visible';" 
							><img name="addnewroleheader" 
								  src="../images/addnewroleheaderbutton.png" 
								  alt="Allows you to Add New Roll..." /></a>
			                </td>
		                </tr>
	                </table>
                </td>
            </tr>
            <tr>
	            <td style="text-align:center;">
		            <input type="hidden" name="type" value="RoleSearch"/>
			            <div class="divForJmesa" id="outterDiv" style="vertical-align: top;">
				            <jmesa:tableModel
				               id="RoleSearch" 
				               items="${roleList}"
				               maxRows="15"
				               maxRowsIncrements="15,30,50,100"
				               stateAttr="restore"
				               var="bean"
				               exportTypes="excel"
				               >
				               <jmesa:htmlTable caption="" width="950px" style="background-color:white;">               
				                   <jmesa:htmlRow> 
				                       <jmesa:htmlColumn property="roleName" title="Role Name" width="45%"/>
				          			<jmesa:htmlColumn property="roleDescription" title="Role Description" width="45%" />
				                       <jmesa:htmlColumn sortable="false" property="" title="Action" filterable="false" width="10%">
				                       <a href="#" onclick="getHMSRole(${bean.oid});">Edit</a>
				                       </jmesa:htmlColumn>
				                   </jmesa:htmlRow>
				               </jmesa:htmlTable> 
				            </jmesa:tableModel>
			            </div>
	             </td>
            </tr>
		</table>
        </form>
		
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
        	location.href = '${pageContext.request.contextPath}/hms/viewRole.action?type=basicExport&' + parameterString;
        }
       	changeWidthForJMesaOutterDiv(document.getElementById('outterDiv'));
       	setJmesaTableWidth('#RoleSearch');
    </script>

</html>
