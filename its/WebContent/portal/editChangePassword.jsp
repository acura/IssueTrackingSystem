<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page import="com.portal.domain.HMSConstants"%><html>

<head>
  	<title>Change Password</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=7" />
	<jsp:include page="include.jsp"></jsp:include>
	<sx:head parseContent="true"/>
	   <jsp:scriptlet> 
   		String userIdFromSession = session.getAttribute(HMSConstants.USER_ID) != null ? session.getAttribute("userId").toString() : "";
      	if((userIdFromSession.isEmpty())||(session.getAttribute("calledFrom").toString().equals("userDetails")))
        {
         	request.setAttribute(HMSConstants.USER_ID, request.getParameter(HMSConstants.USER_ID));	
         	System.out.println("UserId From Request: "+request.getParameter(HMSConstants.USER_ID));
        }
        else
        {
        	request.setAttribute(HMSConstants.USER_ID, userIdFromSession);
        	System.out.println("UserId From Session: "+userIdFromSession);
        }
  </jsp:scriptlet>
	
	<script type="text/javascript">

		function changeHeight(srcElement)
		{
			srcElement.style.height = screen.height - 420;
		}
	
	</script>
	
</head>

<body onload="document.all.oldPassword.focus();" class="bodyClass">

<jsp:include page="menu.jsp" />

<% String saveAction = session.getAttribute("calledFrom") != null && session.getAttribute("calledFrom").toString().equals("userDetails") ? "saveChangePassword" : "saveChangePasswordOnline"; %>
<form id="editChangePassword" name="editChangePassword" action="<%=saveAction%>">

<table class="mainTable" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="2" class="screenHeader" align="center">
			<span class="screenHeaderSpan">Change Password</span>
		</td>
	</tr>
    <tr>
    	<td style="text-align: center;">
			<div class="fixedDiv" id="outterDiv">
				<table>
		           	
		            <tr>
		             	<td colspan="2" style="padding-right: 0px; ">
		             		<hr style="background: #BD1F2D" />
		             	</td>
		            </tr>
		            <c:if test="${sessionScope.isFromChangePassword eq true}">
		            	<td style="text-align:center">
            			<p><font face="Arial" color="red" size="2" style="font-weight: Bold">Password has been changed successfully...</font></p>
            			</td>
            			<% request.getSession().removeAttribute("isFromChangePassword"); %>
		            </c:if>
					<tr>
						<td  valign="top">
			            	<table>
			            		<tr>
			            			<input type="hidden" name="isFromOnlineUser" id="isFromOnlineUser" value="<%=request.getParameter("isFromOnlineUser") %>"/>
			            			 <input type="hidden" name="userId" value="${userId}" />
		                        </tr>
		                        <tr>
		                         <s:password key="oldPassword" label="Old Password" maxlength="15" size="30" required="true"  />
		                        </tr>
		                        <tr>
		                         <s:password key="newPassword" label="New Password" maxlength="15" size="30" required="true"  />
		                        </tr>
		                        <tr>
		                         <s:password key="confirmPassword" label="Confirm Password" maxlength="15" size="30" required="true"  />
		                        </tr>
		                  </table>      
			    		</td>
			    		</tr>
						<tr>
				        	<td colspan="2" style="padding-right: 0px; height:60px">
				            	<hr />
				            </td>
				        </tr>
				        <tr>
				        	<td colspan="2" style="padding-right: 0px; height:195px">
				        		<hr />
				        	</td>
				        </tr>
				</table>
			</div>
		</td>
	</tr>
	<tr>
   		<td>
   			<c:choose>
			<c:when test="${sessionScope.userType ne \"Online_User\" &&  sessionScope.moduleName eq \"Gynosoft\"}">
				<jsp:include page="commonSubmit.jsp"></jsp:include>
			</c:when>
			<c:when test="${sessionScope.userType ne \"Online_User\" && sessionScope.moduleName eq \"ProLab\"}">
				<jsp:include page="commonLabTestSubmit.jsp"></jsp:include>
			</c:when>
			<c:when test="${sessionScope.userType eq \"Online_User\"}">
				<jsp:include page="submitForOnLineUser.jsp"></jsp:include>
			</c:when>
			</c:choose>
   		</td>
   	</tr>
   	
   	<c:if test="${param.isFromOnlineUser eq \"true\"}">
   	
   		<script type="text/javascript">
			if (document.getElementById('isFromOnlineUser').value == 'true')
			{
				changeHeight(document.getElementById('outterDiv'));
			}
   			changeWidthOnlineUserHeaderDiv(document.getElementById('onlineUserHeaderDiv'));
   		</script>
   	
   	</c:if>
   	
</table>

</form>
</body>
<script type="text/javascript">
    //changeWidthInOnlineUserHeader(document.getElementById('headerDiv'));
    setJmesaTableWidth('#TestRecordsByUserSearch');
    
</script>
</html>

