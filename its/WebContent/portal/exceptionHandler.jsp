<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" import="java.io.*" %>
<%@ page import="java.lang.Throwable" %>
<%@ page import="org.jmesa.web.HttpServletRequestWebContext"%>
<%@ taglib uri="/WEB-INF/tld/jmesa.tld" prefix="jmesa" %>
<html>

<head>
  	<title>Unanticipated Error Condition Occurred</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=7" />
	<jsp:include page="include.jsp"></jsp:include>
</head>

<body class="bodyClass">
<jsp:include page="menu.jsp" />
<table width="100%"> 
<tr>
<td width="100%">
<table class="mainTable" border="0" cellpadding="0" cellspacing="0" >
	<tr>
       	<td colspan="2" class="screenHeader" align="center">
        	<span class="screenHeaderSpan">Unanticipated Error Condition Occurred</span>
		</td>
	</tr>
    <tr>
    	<td style="text-align:center;">
    		<div class="fixedDiv" id="outterDiv">
				<table>
            		<tr>
						<td valign="top">
	            			<table >
								  	<tr>
								  	<td style="text-align:center;"><b><i>Contact  Information: </i></b></td>
			                        <td style="width:92%;text-align:center;">
			                        <div class="subComponentDiv">
			                        	<font color="black">
										<u><%= "System Error. Please contact us at Acura Softwares to resolve this error." %></u>
					    				<br />
					   					<u><%= "Contact Name : Mr. Amol Gadre <br/> Mobile Number: 9423004767 <br/> Phone Number: 020-32670355" %></u>
										</font>
										<br />
										<a href="#" onclick="window.opener.logoutForm.submit(); window.close();"><font color="red"><b>Sign On Again</b></font></a>
			                   	    </div>
			                   	    </td>
									</tr>

                       				
		            				
		            				<tr>
		            				<td style="width:8%;vetical-align:top;text-align:center;"><b><i>Exception Information<font color="red">*</font>: </i></b></td>
		            				<td style="width:92%;">
		            				<div class="subComponentDiv">
		            				<table>
		            				
                       				 <tr>
                       				 	<td style="width:50%; text-align:center; vertical-align:top;">
							  				<table>
							  				<tr>
							  				<%
											//out.println("<!--");
											if (exception != null)
											{
												out.print("<br /><textarea readonly=\"true\" cols=\"80\" rows=\"24\">"+exception.getMessage()+ "\n" );
												StackTraceElement[] stackArray = exception.getStackTrace();
												for (StackTraceElement element : stackArray)
												{
													out.println(element.toString());
												}
												out.println("</textarea><br /><br />");
											}
											//out.println("-->");
											%>
							  				</tr>
							  			        
							  				</table>
						  				</td>
									</tr>
                   				</table>
                   				</div>
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
</td>
</tr>
</table>
<script>
	changeWidth(document.getElementById('outterDiv'));
</script>
</body>
</html>

