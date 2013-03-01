<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Sign On</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=7" />
	<sx:head parseContent="true"/>
<style type="text/css">

body,td,th {
	font-size: 11pt;
	font-weight: 300;
	font-style: normal;
	font-family: "Times New Roman", Times, serif;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(file:///C|/Documents and Settings/Reshu/Desktop/images/body-bg.jpg);
	background-repeat: repeat;
	background-image: url();
	background-color: #E9E9E9;
}
a:link {
	text-decoration: none;
	color: #222942;
}
a:visited {
	text-decoration: none;
	color: #222942;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
.style57 {font-size: 10pt; font-weight: normal; color: #333333; font-family: Verdana, Arial, Helvetica, sans-serif; }
.style58 {font-size: 13px; font-weight: 600; color: #666666; font-family: Verdana, Arial, Helvetica, sans-serif; }
.style65 {font-size: 16px; font-weight: bold; color: #FFFFFF; font-family: Verdana, Arial, Helvetica, sans-serif; }
.style66 {font-size: 13px; font-weight: 600; color: #FFFFFF; font-family: Verdana, Arial, Helvetica, sans-serif; }
.style70 {font-size: 10pt; font-weight: bold; color: #333333; font-family: Verdana, Arial, Helvetica, sans-serif; }
.style71 {
	color: #40537B;
	font-weight: bold;
}

</style>

<script type="text/javascript">

function changeWidthHomePage(srcElement)
	{
		var wd = parseInt(srcElement.style.width);
		if (screen.width == 1024)
			srcElement.style.width = wd - ((screen.width/1250)*30);
		else if (screen.width == 800)
			srcElement.style.width = wd - ((screen.width/1250)*70);
		else
			srcElement.style.width = wd - ((screen.width/1250)*6);

	}

	function changeWidth(srcElement)
	{
		srcElement.style.width = screen.width - ((screen.width/1250)*43);
	}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function goToLogin() 
{
	document.forms["loginPage"].submit();
}
</script>
</head>

<body onload="document.all.userId.focus();MM_preloadImages('file:///E|/acura_html/images/blue_over_but.png');">

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <th align="center" scope="col"><table width="100%" border="0" cellspacing="0" cellpadding="0">

      <tr>
        <th align="left" valign="bottom" scope="col"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <th align="left" valign="bottom" scope="col"><table width="1000" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#E9E9E9">
                <tr>
                  <td width="1023"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td><img src="${pageContext.request.contextPath}/images/portalImage/header_img1.jpg" width="397" height="359" /></td>
                      <td><img src="${pageContext.request.contextPath}/images/portalImage/header_img2.jpg" width="626" height="359" /></td>
                    </tr>
                    <tr>
                      <td bgcolor="#FFFFFF"><span class="style71">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Contact Us Call: 020-3267 0355 , 94230 04767<br />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email: amol.gadre@acurasoftwares.com</span></td>
                      <td><img src="${pageContext.request.contextPath}/images/portalImage/header2_img2.jpg" width="626" height="40" /></td>
                    </tr>
                  </table></td>
                </tr>
                <tr>
                  <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="72%" align="left" valign="top" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td width="99%" height="7"></td>
                          <td width="1%"><img src="${pageContext.request.contextPath}/images/portalImage/header_img4.jpg" width="34" height="7" /></td>
                        </tr>
                        <tr>
                          <td colspan="2"><table width="99%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="12">&nbsp;</td>
                              <td width="714"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="../images/portalImage/blue_text_box_bg.jpg">
                                <tr>
                                  <td colspan="2" background="../images/portalImage/box_top_bg.jpg"><img src="${pageContext.request.contextPath}/images/portalImage/text_box_left_corner.png" width="3" height="34" /></td>
                                  <td colspan="2" align="center" background="../images/portalImage/box_top_bg.jpg"><span class="style65">Features of our Applications </span></td>
                                  <td width="17" align="right" background="../images/portalImage/box_top_bg.jpg"><img src="${pageContext.request.contextPath}/images/portalImage/text_box_right_corner.png" width="4" height="34" /></td>
                                </tr>
                                <tr>
                                  <td colspan="2">&nbsp;</td>
                                  <td colspan="2">&nbsp;</td>
                                  <td>&nbsp;</td>
                                </tr>
                                <tr>
                                  <td colspan="2" align="right"><img src="${pageContext.request.contextPath}/images/portalImage/bullet_img1.png" width="19" height="20" /></td>
                                  <td>&nbsp;</td>
                                  <td align="left" valign="middle" class="style57">No more waiting for support for software or hardware issues.</td>
                                  <td>&nbsp;</td>
                                </tr>
                                <tr>
                                  <td height="7" colspan="2"></td>
                                  <td height="7"></td>
                                  <td height="7" class="style57"></td>
                                  <td height="7"></td>
                                </tr>
                                <tr>
                                  <td colspan="2" align="right"><img src="${pageContext.request.contextPath}/images/portalImage/bullet_img1.png" width="19" height="22" /></td>
                                  <td>&nbsp;</td>
                                  <td align="left" valign="middle" class="style57">Use our online applications to conduct daily operations of your clinic, hospital or pathological lab.</td>
                                  <td>&nbsp;</td>
                                </tr>
                                <tr>
                                 <td height="7" colspan="2"></td>
                                  <td height="7"></td>
                                  <td height="7" class="style57"></td>
                                  <td height="7"></td>
                                </tr>
                                <tr>
                                  <td colspan="2" align="right"><img src="${pageContext.request.contextPath}/images/portalImage/bullet_img1.png" width="19" height="22" /></td>
                                  <td>&nbsp;</td>
                                  <td align="left" valign="middle" class="style57">Our applications include formats provided by doctors and healthcare experts.</td>
                                  <td>&nbsp;</td>
                                </tr>
                                <tr>
                                  <td height="7" colspan="2"></td>
                                  <td height="7"></td>
                                  <td height="7" class="style57"></td>
                                  <td height="7"></td>
                                </tr>
                                <tr>
                                  <td colspan="2" align="right" valign="top"><img src="${pageContext.request.contextPath}/images/portalImage/bullet_img1.png" width="19" height="22" /></td>
                                  <td>&nbsp;</td>
                                  <td align="left" valign="middle" class="style57">Billing, Recording of Patient's Information, Surgeries, Lab Tests, Printing Invoices, Email Reports to Patients and More.</td>
                                  <td>&nbsp;</td>
                                </tr>
                                <tr>
                                  <td height="7" colspan="2"></td>
                                  <td height="7"></td>
                                  <td height="7" class="style57"></td>
                                  <td height="7"></td>
                                </tr>
                                <tr>
                                  <td colspan="2" align="right"><img src="${pageContext.request.contextPath}/images/portalImage/bullet_img1.png" width="19" height="22" /></td>
                                  <td width="7">&nbsp;</td>
                                  <td width="668" align="left" valign="middle" class="style57"> Online reports availiability for patients with lifetime free accounts for patients.</td>
                                  <td>&nbsp;</td>
                                </tr>

                                <tr>
                                  <td width="17" bgcolor="#FFFFFF"><img src="${pageContext.request.contextPath}/images/portalImage/blue_text_box_left_corner.png" width="17" height="19" /></td>
                                  <td width="10">&nbsp;</td>
                                  <td colspan="2">&nbsp;</td>
                                  <td bgcolor="#FFFFFF"><img src="${pageContext.request.contextPath}/images/portalImage/blue_text_box_right_corner.png" width="17" height="19" align="right" /></td>
                                </tr>
                              </table></td>
                              <td width="10">&nbsp;</td>
                            </tr>
                          </table></td>
                        </tr>

                        <tr>
                         
                        </tr>

                      </table>
                        </td>
                      <td align="left" valign="top" bgcolor="#FFFFFF">
                      <s:form id="loginPage" name="loginPage" action="login">
                      <table width="275" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td colspan="3"><img src="${pageContext.request.contextPath}/images/portalImage/login_box_top_img.jpg" width="275" height="24" align="right" /></td>
                        </tr>
                        <tr>
                          <td colspan="3"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="1" bgcolor="#EFC695">&nbsp;</td>
                              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                <tr>
                                  <td width="11%">&nbsp;</td>
                                  <td width="33%">&nbsp;</td>
                                  <td width="56%">&nbsp;</td>
                                </tr>
                                <tr>
                                	<td style="text-align: center;" colspan="3">
                                		<table style="text-align: center;">
                                			<s:textfield key="loginValidation" label="" labelSeparator="" cssStyle="visibility:hidden; height:0px;" size="0"/>	
                                		</table>
                                	</td>
                                	<s:hidden key="signon" value="true"/>
                                </tr>
                                <tr>
                                  <td height="40" align="center" background="../images/portalImage/table_bg5.jpg" class="style58"><img src="${pageContext.request.contextPath}/images/portalImage/userid_img.png" width="15" height="16" /></td>
                                  <td background="../images/portalImage/table_bg5.jpg"><span class="style58">USER ID</span></td>
                                  <td background="../images/portalImage/table_bg5.jpg">
                                  <table>
                                  		<s:textfield key="userId" label="" labelSeparator="" maxlength="20" size="20" required="true" />
                                  </table>
                                  </td>
                                </tr>
                                <tr>
                                  <td>&nbsp;</td>
                                  <td>&nbsp;</td>
                                  <td>&nbsp;</td>
                                </tr>
                                <tr>
                                  <td height="40" align="center" background="../images/portalImage/table_bg5.jpg" class="style58"><img src="${pageContext.request.contextPath}/images/portalImage/password_img.png" width="15" height="9" /></td>
                                  <td background="../images/portalImage/table_bg5.jpg"><span class="style58">PASSWORD</span></td>
                                  <td background="../images/portalImage/table_bg5.jpg">
                                    <table>
                                  		<s:password key="password" label="" labelSeparator="" maxlength="20" size="20" required="true"/>
                               		</table>
                                  </td>
                                </tr>
                                <tr>
                                  <td>&nbsp;</td>
                                  <td>&nbsp;</td>
                                  <td>&nbsp;</td>
                                </tr>
                                <tr>
                                  <td colspan="3" align="center"><a href="#" onclick="goToLogin();"><img src="${pageContext.request.contextPath}/images/portalImage/log-in_but.png" width="125" height="40" /></a></td>
                                  </tr>
                              </table></td>
                              <td width="1" bgcolor="#EFC695">&nbsp;</td>
                            </tr>
                          </table></td>
                          </tr>
                        
                        <tr>
                          <td width="28"><img src="${pageContext.request.contextPath}/images/portalImage/login_left_corner.png" width="26" height="20" align="left" /></td>
                          <td width="221">&nbsp;</td>
                          <td width="26"><img src="${pageContext.request.contextPath}/images/portalImage/login_right_corner.png" width="26" height="20" align="right" /></td>
                        </tr>
                      </table>
                      </s:form>    
                      </td>
                    </tr>
                    <tr>
                      <td colspan="2" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td width="13" bgcolor="#FFFFFF">&nbsp;</td>
                          <td colspan="2" bgcolor="#FFFFFF">&nbsp;</td>
                          <td height="2" bgcolor="#FFFFFF"></td>
                        </tr>
                        <tr>
                          <td bgcolor="#FFFFFF">&nbsp;</td>
                          <td colspan="2" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="0%"></td>
                              <td width="98%"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="../images/portalImage/blue_text_box_bg2.jpg">
                                <tr>
                                  <td colspan="2" background="../images/portalImage/box_top_bg.jpg"><img src="${pageContext.request.contextPath}/images/portalImage/text_box_left_corner.png" width="3" height="34" /></td>
                                  <td colspan="2" align="center" background="../images/portalImage/box_top_bg.jpg" class="style65">What are we offering? </td>
                                  <td width="17" align="right" background="../images/portalImage/box_top_bg.jpg"><img src="${pageContext.request.contextPath}/images/portalImage/text_box_right_corner.png" width="4" height="34" /></td>
                                </tr>
                                <tr>
                                  <td colspan="2">&nbsp;</td>
                                  <td colspan="2">&nbsp;</td>
                                  <td>&nbsp;</td>
                                </tr>
                                <tr>
                                  <td colspan="2" align="center" valign="top">&nbsp;</td>
                                  <td width="8">&nbsp;</td>
                                  <td width="938" align="left" valign="middle" class="style58">We are currently offering online applications on cloud based environment for:</td>
                                  <td>&nbsp;</td>
                                </tr>
                                <tr>
                                  <td height="7" colspan="2"></td>
                                  <td height="7"></td>
                                  <td height="7" class="style57"></td>
                                  <td height="7"></td>
                                </tr>
                                <tr>
                                  <td colspan="2" align="right" valign="top"><img src="${pageContext.request.contextPath}/images/portalImage/bullet_img1.png" width="19" height="22" /></td>
                                  <td>&nbsp;</td>
                                  <td align="left" valign="middle" class="style57">Pathological Labs</td>
                                  <td>&nbsp;</td>
                                </tr>
                                <tr>
                                  <td height="7" colspan="2"></td>
                                  <td height="7"></td>
                                  <td height="7" class="style57"></td>
                                  <td height="7"></td>
                                </tr>
                                <tr>
                                  <td colspan="2" align="right" valign="top"><img src="${pageContext.request.contextPath}/images/portalImage/bullet_img1.png" width="19" height="22" /></td>
                                  <td>&nbsp;</td>
                                  <td align="left" valign="middle" class="style57">Clinics and Hospitals</td>
                                  <td>&nbsp;</td>
                                </tr>
                                <tr>
                                  <td height="7" colspan="2"></td>
                                  <td height="7"></td>
                                  <td height="7" class="style57"></td>
                                  <td height="7"></td>
                                </tr>
                                <tr>
                                  <td colspan="2" align="right" valign="top"><img src="${pageContext.request.contextPath}/images/portalImage/bullet_img1.png" width="19" height="22" /></td>
                                  <td>&nbsp;</td>
                                  <td align="left" valign="middle" class="style57">Gynaecological Hospitals</td>
                                  <td>&nbsp;</td>
                                </tr>
                                <tr>
                                  <td height="7" colspan="2"></td>
                                  <td height="7"></td>
                                  <td height="7" class="style57"></td>
                                  <td height="7"></td>
                                </tr>
                                <tr>
                                  <td height="7" colspan="2">&nbsp;</td>
                                  <td height="7">&nbsp;</td>
                                  <td class="style57">With applications hosted on our cloud based servers, you don't have to worry about software or hardware issues occurring on your laptop or PC to stop you from working on your applications.<br />
For any application related issue, you just need to give us a call, and we will solve your problem within no time with an able technical support team resolving your issues on the server.<br />
No more AMC or per visit cost for your software. If your PC or Laptop gives you hard time, your work won't stop. Access the online application from a different laptop or PC. </td>
                                  <td height="7">&nbsp;</td>
                                </tr>
                                <tr>
                                  <td height="7" colspan="2"></td>
                                  <td height="7"></td>
                                  <td class="style57"></td>
                                  <td height="7"></td>
                                </tr>
                                <tr>
                                  <td height="7" colspan="2">&nbsp;</td>
                                  <td height="7">&nbsp;</td>
                                  <td class="style57">There is no installation required at your end. You pay only a mere amount of Rs. 1,000.00 on annual basis for using our applications. Your data is secure on our servers. </td>
                                  <td height="7">&nbsp;</td>
                                </tr>
                                <tr>
                                  <td height="7" colspan="2"></td>
                                  <td height="7"></td>
                                  <td class="style57"></td>
                                  <td height="7"></td>
                                </tr>
                                <tr>
                                  <td height="7" colspan="2">&nbsp;</td>
                                  <td height="7">&nbsp;</td>
                                  <td class="style57">If you are computerizing your clinic, hospital or lab for the first time, you do not incur any hardware cost. Just use a minimum configuration PC or latop to get the best of services.<br />
Contact us on 020-3267 0355 or 94230 04767 to book your order now</td>
                                  <td height="7">&nbsp;</td>
                                </tr>
                                <tr>
                                  <td width="17" bgcolor="#FFFFFF"><img src="${pageContext.request.contextPath}/images/portalImage/blue_text_box_left_corner.png" width="17" height="19" align="left" /></td>
                                  <td width="9">&nbsp;</td>
                                  <td colspan="2">&nbsp;</td>
                                  <td bgcolor="#FFFFFF"><img src="${pageContext.request.contextPath}/images/portalImage/blue_text_box_right_corner.png" width="17" height="19" align="right" /></td>
                                </tr>
                              </table></td>
                              <td>&nbsp;</td>
                            </tr>
                          </table></td>
                          <td height="2" bgcolor="#FFFFFF"></td>
                        </tr>
                        <tr>
                          <td bgcolor="#FFFFFF">&nbsp;</td>
                          <td colspan="2" bgcolor="#FFFFFF">&nbsp;</td>
                          <td height="2" bgcolor="#FFFFFF"></td>
                        </tr>
                        <tr>
                          <td bgcolor="#FFFFFF">&nbsp;</td>
                          <td width="996" bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="../images/portalImage/blue_text_box_bg3.jpg">
                            <tr>
                              <td width="17" background="../images/portalImage/box_top_bg.jpg"><img src="${pageContext.request.contextPath}/images/portalImage/text_box_left_corner.png" width="3" height="34" /></td>
                              <td width="962" align="center" background="../images/portalImage/box_top_bg.jpg" class="style65">Subscription Plans</td>
                              <td width="17" align="right" background="../images/portalImage/box_top_bg.jpg"><img src="${pageContext.request.contextPath}/images/portalImage/text_box_right_corner.png" width="4" height="34" /></td>
                            </tr>
                            <tr>
                              <td>&nbsp;</td>
                              <td><table width="99%" border="1" cellpadding="0" cellspacing="1" bordercolor="#66C2CF">
                                  <tr>
                                    <td height="50" colspan="2" align="center" background="../images/portalImage/bg7.jpg" class="style66">Applications</td>
                                    <td width="251" align="center" background="../images/portalImage/bg7.jpg" class="style66">Description</td>
                                    <td align="center" background="../images/portalImage/bg7.jpg" class="style66">Registration Charges </td>
                                    <td width="91" align="center" background="../images/portalImage/bg7.jpg" class="style66">Monthly Hosting Charges</td>
                                    <td width="91" align="center" background="../images/portalImage/bg7.jpg" class="style66">Annual Hosting Charges</td>
                                  </tr>
                                  <tr>
                                    <td height="40" colspan="3" background="../images/portalImage/table_bg3.jpg">&nbsp;</td>
                                    <td width="104" align="center" valign="middle" background="../images/portalImage/table_bg3.jpg" class="style70">(Rs.)</td>
                                    <td align="center" background="../images/portalImage/table_bg3.jpg" class="style70">(Rs.)</td>
                                    <td align="center" background="../images/portalImage/table_bg3.jpg" class="style70">(Rs.)</td>
                                  </tr>
                                  
                                  <tr>
                                    <td height="60" colspan="2" align="left" valign="top" background="../images/portalImage/table_cel_bg.jpg" class="style57"><img src="${pageContext.request.contextPath}/images/portalImage/pro_lab_header_img.jpg" width="304" height="60" /></td>
                                    <td background="../images/portalImage/table_bg1.jpg"><span class="style70">&nbsp; Pro-Lab - A soultion for &nbsp;&nbsp;Pathological  Labs. </span></td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">3,000.00&nbsp;</td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">950.00&nbsp; &nbsp;</td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">10,000.00&nbsp;</td>
                                  </tr>
                                  <tr>
                                    <td height="10" colspan="6" background="../images/portalImage/table_bg3.jpg"></td>
                                    </tr>
                                  <tr>
                                    <td height="60" colspan="2" align="left" valign="top" background="../images/portalImage/table_cel_bg.jpg" class="style57"><img src="${pageContext.request.contextPath}/images/portalImage/health-care-plus.jpg" width="377" height="60" /></td>
                                    <td background="../images/portalImage/table_bg1.jpg"><span class="style70">&nbsp;&nbsp;HealthCare-Plus- Software for &nbsp;&nbsp;General                                                                        Practioners 
and smaller &nbsp;&nbsp;hospitals. </span></td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">2,000.00&nbsp;</td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">750.00&nbsp;</td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">8,000.00&nbsp;</td>
                                  </tr>
                                  <tr>
                                    <td height="10" colspan="6" background="../images/portalImage/table_bg3.jpg"></td>
                                    </tr>
                                  <tr>
                                    <td height="60" colspan="2" background="../images/portalImage/table_cel_bg.jpg" class="style57"><img src="${pageContext.request.contextPath}/images/portalImage/gynosoft_table_img.jpg" width="355" height="60" />                                      </td>
                                    <td background="../images/portalImage/table_bg1.jpg"><span class="style70">&nbsp;&nbsp;Gynosoft -Gynaecological <br />
&nbsp;&nbsp;Hospital Management.</span></td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">2,000.00&nbsp;</td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">750.00&nbsp;</td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">8,000.00&nbsp;</td>
                                  </tr>
                                  <tr>
                                    <td height="10" colspan="6" background="../images/portalImage/table_bg3.jpg"></td>
                                    </tr>
                                  <tr>
                                    <td width="208" height="60" valign="top" background="../images/portalImage/table_cel_bg.jpg" class="style57"><img src="${pageContext.request.contextPath}/images/portalImage/health-care-small.jpg" width="173" height="60" /></td>
                                    <td width="186" valign="top" background="../images/portalImage/table_cel_bg.jpg" class="style57"><img src="${pageContext.request.contextPath}/images/portalImage/pro-lab-small.jpg" width="155" height="60" align="right" /></td>
                                    <td background="../images/portalImage/table_bg1.jpg"><span class="style57">&nbsp;&nbsp;</span><span class="style70">HealthCare-Plus + Pro-Lab.</span></td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg"><span class="style70">4,000.00</span>&nbsp;</td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">1,500.00&nbsp;</td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">16,000.00&nbsp;</td>
                                  </tr>
                                  <tr>
                                   <td height="10" colspan="6" background="../images/portalImage/table_bg3.jpg"></td>
                                    </tr>
                                  <tr>
                                    <td height="60" align="left" valign="top" background="../images/portalImage/table_cel_bg.jpg" class="style57"><img src="${pageContext.request.contextPath}/images/portalImage/gynosoft-small.jpg" width="173" height="60" align="left" /><br />
                                        <br /></td>
                                    <td height="60" valign="top" background="../images/portalImage/table_cel_bg.jpg" class="style57"><img src="${pageContext.request.contextPath}/images/portalImage/pro-lab-small.jpg" width="155" height="60" align="right" /></td>
                                    <td background="../images/portalImage/table_bg1.jpg"><span class="style57">&nbsp;&nbsp;</span><span class="style70">Gynosoft + Pro-Lab.</span></td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">4,000.00&nbsp;</td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">1,500.00&nbsp;</td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">16,000.00&nbsp;</td>
                                  </tr>
                                  <tr>
                                   <td height="10" colspan="6" background="../images/portalImage/table_bg3.jpg"></td>
                                    </tr>
                                  <tr>
                                    <td height="60" colspan="2" align="left" valign="top" background="../images/portalImage/easy-prescription-bg.jpg"><img src="${pageContext.request.contextPath}/images/portalImage/easy-prescription-img.jpg" width="334" height="60" /></td>
                                    <td background="../images/portalImage/table_bg1.jpg"><span class="style57">&nbsp;&nbsp;</span><span class="style70">Easy Prescription.</span></td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">1,000.00&nbsp;</td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">5,00.00&nbsp;</td>
                                    <td align="right" background="../images/portalImage/table_bg1.jpg" class="style70">5,000.00&nbsp;</td>
                                  </tr>
                              </table></td>
                              <td>&nbsp;</td>
                            </tr>
                            <tr>
                              <td bgcolor="#FFFFFF"><img src="${pageContext.request.contextPath}/images/portalImage/blue_text_box_left_corner.png" width="17" height="19" /></td>
                              <td>&nbsp;</td>
                              <td bgcolor="#FFFFFF"><img src="${pageContext.request.contextPath}/images/portalImage/blue_text_box_right_corner.png" width="17" height="19" /></td>
                            </tr>
                          </table></td>
                          <td align="right" bgcolor="#FFFFFF">&nbsp;</td>
                          <td height="2" bgcolor="#FFFFFF"></td>
                        </tr>
                        <tr>
                          <td bgcolor="#FFFFFF">&nbsp;</td>
                          <td colspan="2" bgcolor="#FFFFFF">&nbsp;</td>
                          <td height="2" bgcolor="#FFFFFF"></td>
                        </tr>
                        <tr>
                          <td bgcolor="#FFFFFF">&nbsp;</td>
                          <td colspan="2" bgcolor="#FFFFFF">&nbsp;</td>
                          <td height="2" bgcolor="#FFFFFF"></td>
                        </tr>
                        <tr>
                          <td colspan="3"><img src="${pageContext.request.contextPath}/images/portalImage/bottom_img.png" width="1023" height="171" /></td>
                          <td width="1" height="2" bgcolor="#FFFFFF"></td>
                        </tr>
                      </table></td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                </tr>
              </table>
              </th>
            </tr>
            <tr>
              <td></td>
            </tr>
        </table></th>
      </tr>
    </table></th>
  </tr>
</table>
</body>

<script type="text/javascript">


	changeWidth(document.getElementById('imageTable'));
	changeWidthHomePage(document.getElementById('header_img_01'));
	changeWidthHomePage(document.getElementById('header_img_02'));
	changeWidthHomePage(document.getElementById('header_img_03'));
	changeWidthHomePage(document.getElementById('header_img_04'));
	changeWidthHomePage(document.getElementById('header_img_05'));
	changeWidthHomePage(document.getElementById('header_img_06'));
	changeWidthHomePage(document.getElementById('header_img_07'));
	changeWidthHomePage(document.getElementById('header_img_08'));
	changeWidthHomePage(document.getElementById('header_img_09'));
	changeWidthHomePage(document.getElementById('header_img_10'));
	changeWidthHomePage(document.getElementById('header_img_11'));
	changeWidthHomePage(document.getElementById('header_img_12'));
	changeWidthHomePage(document.getElementById('header_img_13'));
	changeWidthHomePage(document.getElementById('header_img_14'));
	changeWidthHomePage(document.getElementById('header_img_15'));
	changeWidthHomePage(document.getElementById('header_img_16'));
	changeWidthHomePage(document.getElementById('header_img_17'));
	changeWidthHomePage(document.getElementById('header_img_18'));
	changeWidthHomePage(document.getElementById('header_img_19'));
	changeWidthHomePage(document.getElementById('header_img_20'));
	changeWidthHomePage(document.getElementById('header_img_21'));
	changeWidthHomePage(document.getElementById('header_img_22'));
	changeWidthHomePage(document.getElementById('header_img_23'));
	changeWidthHomePage(document.getElementById('header_img_24'));
	changeWidthHomePage(document.getElementById('header_img_25'));
	changeWidthHomePage(document.getElementById('header_img_26'));
	changeWidthHomePage(document.getElementById('header_img_27'));
	changeWidthHomePage(document.getElementById('header_img_28'));
	changeWidthHomePage(document.getElementById('header_img_29'));
	changeWidthHomePage(document.getElementById('header_img_30'));
	changeWidthHomePage(document.getElementById('header_img_31'));
	changeWidthHomePage(document.getElementById('header_img_32'));
	changeWidthHomePage(document.getElementById('header_img_33'));

</script>

</html>