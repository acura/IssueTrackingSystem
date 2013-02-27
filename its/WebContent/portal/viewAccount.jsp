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
		
			function getPortalAccount(accountId)
			{
				pleaseWait('window.location.href = \'editAccount?accountId=' + accountId + '&isInvokedFromViewAccount=true\'');
				
			}

			function changePassword(userIdValue)
			{
				pleaseWait('window.location.href = \'editChangePassword?userId=' + userIdValue + '&calledFrom=userDetails \''); 
			}
			function addNewAccount()
			{
				window.location.href = 'editAccount.action?isInvokedFromViewAccount=false'; 
				 
			}
			
		</script>
    </head>
    
    <body class="bodyClass">
 	<jsp:include page="menu.jsp" />
		<form name="PortalAccountSearchEntriesForm" action="${pageContext.request.contextPath}/hms/viewPortalAccount.action">
		<table class="mainTable" border="0" cellpadding="0" cellspacing="0" >
            <tr>
            	<td class="screenHeader">
	            	<table style="width:98%">
		            	<tr>
		            		<td colspan="37">
		            		</td>
			                <td style="text-align:right; width: 28%;">
			                	<span class="screenHeaderSpan">Account Details</span>
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
            	<c:if test="${sessionScope.isFromChangePassword eq true}">
	            	<td style="text-align:center;border: 1px dotted white;">
           			<p><font face="Arial" color="red" size="2" style="font-weight: Bold">Password has been changed successfully...</font></p>
           			</td>
           			<% request.getSession().removeAttribute("isFromChangePassword"); %>
	            </c:if>
            </tr>
            <tr>
            <td style="text-align:center; vertical-align: top;">
            <input type="hidden" name="type" value="PortalAccountSearch"/>
            <div class="divForJmesa" style="vertical-align: top;" id="outterDiv">
            <jmesa:tableModel
               id="PortalAccountSearch" 
               items="${accountList}"
               maxRows="15"
               maxRowsIncrements="15,30,50,100"
               stateAttr="restore"
               var="bean"
               exportTypes="excel"
               >
               <jmesa:htmlTable caption="" width="950px" style="background-color:white;">               
                   <jmesa:htmlRow> 
                       <jmesa:htmlColumn property="accountId" title="Account Id" width="15%" >
                              <div align="center" style="text-align: center;">
                                  ${bean.accountId}
                              </div>
                       </jmesa:htmlColumn>
                       <%--<jmesa:htmlColumn property="accountType" title="Account Type"  width="10%"/>--%>
                       <jmesa:htmlColumn property="ownerName" title="Owner Name" width="20%"/>
                       <jmesa:htmlColumn property="title" title="Title"  width="10%"/>
					   <jmesa:htmlColumn property="emailId" title="Email Id" width="15%" />
                       <jmesa:htmlColumn property="mobileNumber" title="Mobile Number" width="15%">
	                            <div align="right" style="text-align: right;">
									${bean.mobileNumber}
                               </div>
		              </jmesa:htmlColumn>
                       <jmesa:htmlColumn property="amountPaid" title="Amount Paid" width="15%">
                              <div align="right" style="text-align: right;">
                                 <fmt:formatNumber value="${bean.amountPaid}" pattern="#,##0.00"/>
                              </div>
                       </jmesa:htmlColumn>
                       
                       <jmesa:htmlColumn sortable="false" property="" title="Action" filterable="false" width="10%" >
                       
                       <a href="#" onclick="getPortalAccount('${bean.accountId}');">Edit</a>
                      <%--  <a href="#" onclick="changePassword('${bean.userId}');">Change Password</a>
                        --%>
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
       	location.href = '${pageContext.request.contextPath}/hms/viewHMSUser.action?type=basicExport&' + parameterString;
	}
    changeWidthForJMesaOutterDiv(document.getElementById('outterDiv'));
    setJmesaTableWidth('#PortalAccountSearch');
</script>

</html>
