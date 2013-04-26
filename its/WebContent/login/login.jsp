<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
      <title>login here..!</title>
      <style type="text/css">
<!--
body {
	background-color: #FFFFFF;
}
.style2 {
	font-family: Geneva, Arial, Helvetica, sans-serif;
	color: #FF8040;
}
#Layer1 {
	position:absolute;
	width:384px;
	height:244px;
	z-index:1;
	left: 363px;
	top: 291px;
}
.style3 {font-family: Geneva, Arial, Helvetica, sans-serif; color: #0000FF; }
.style5 {
	color: #FF0000;
	font-size: 16px;
}
.style6 {color: #000000; font-size: 16px; }
-->
</style></head>

<body bgcolor="fffcc###">
<s:form id="loginform" name="loginform" action="login">
<h1 align="center" class="style2">Welcome To Login page </h1>
<p align="center" class="style3">Registered users please login below. </p>
<!-- <table  border="1" align="center cellpadding="0" cellspacing="0" style="width: 100%;"> -->
<!--<table class="mainTable" border="0" cellpadding="0" cellspacing="0" style="width: 100%;">-->
<!--<table width="476" height="224" border="1" align="center">-->

	<% if (request.getAttribute ("errorMsg")!=null)
	{ %>
      <h3 align="center">
	   <font color="red">
	<%=request.getAttribute("errorMsg")%></font>
	</h3>
<% } %>         
                <table align="center" style="text-align:center; color:red;border:thin solid black;" width="40%" height="40%">
                <tr>
                	<td colspan="2" align="center">
                	<table>
                		<s:textfield name="loginValidation" cssStyle="visibility:hidden" />
                	</table>
                	</td>
                </tr>
                  <tr>
                  <td>User Name</td>
                  <td>
                  	<table>
						<s:hidden key="signOn" value="true"/>
		              	<s:textfield  key="userName" label=""/>                  	
                  	</table>
                  </td>
		         </tr>
		          <tr>
		          	<td>Password</td>
		          	<td>
		          	<table>
						<s:password  key="password" label="" />		          	
		          	</table>
		          	</td>
		          </tr>
		         <tr align="center">
		         <td colspan="2">
		         <input type="submit" value="Login" />
		         </td>
		         </tr>
                
               </table>
                
               
</s:form>
</body>
</html>