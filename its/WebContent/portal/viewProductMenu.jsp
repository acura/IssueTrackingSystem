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
                      <td width="100%" align="left" valign="top" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td width="99%" height="7"></td>
                          <td width="1%"><img src="${pageContext.request.contextPath}/images/portalImage/header_img4.jpg" width="34" height="7" /></td>
                        </tr>
                        <tr>
                        </tr>
                      </table>
                        </td>
                     		
                    </tr>
                    <tr>
                      <td colspan="2" align="left" valign="top">
                      <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td width="13" bgcolor="#FFFFFF">&nbsp;</td>
                          <td colspan="2" bgcolor="#FFFFFF">&nbsp;</td>
                          <td height="2" bgcolor="#FFFFFF"></td>
                        </tr>
                        <tr>
                          <td bgcolor="#FFFFFF">&nbsp;</td>
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
                              <td width="962" align="center" background="../images/portalImage/box_top_bg.jpg" class="style65">Applications</td>
                              <td width="17" align="right" background="../images/portalImage/box_top_bg.jpg"><img src="${pageContext.request.contextPath}/images/portalImage/text_box_right_corner.png" width="4" height="34" /></td>
                            </tr>
                            <tr>
                              <td>&nbsp;</td>
                              <td><table width="99%" border="1" cellpadding="0" cellspacing="1" bordercolor="#66C2CF">
                                  
                                  <tr>
                                    <td height="60" colspan="2" align="right" valign="top" class="style57">
                                    <a href="http://www.acura-apps.com/prolab-web">
                                    	<img src="${pageContext.request.contextPath}/images/portalImage/pro_lab_header_img.jpg" width="304" height="60" />
                                   	</a>
                                   	</td>
                                  </tr>
                                  <tr>
                                    <td height="10" colspan="6" background="../images/portalImage/table_bg3.jpg"></td>
                                    </tr>
                                  <tr>
                                    <td height="60" colspan="2" align="right" valign="top"  class="style57">
                                    	<a href="http://www.acura-apps.com/gensoft-web">
                                    		<img src="${pageContext.request.contextPath}/images/portalImage/health-care-plus.jpg" width="304" height="60" />
                                   		</a>
                                   	</td>
                                  </tr>
                                  <tr>
                                    <td height="10" colspan="6" background="../images/portalImage/table_bg3.jpg"></td>
                                    </tr>
                                  <tr>
                                    <td height="60" colspan="2" align="right" class="style57">
                                    	<a href="http://www.acura-apps.com/hms-web">
                                    		<img src="${pageContext.request.contextPath}/images/portalImage/gynosoft_table_img.jpg" width="304" height="60" />
                                    	</a>                                      
                                   	</td>
                                  </tr>
                                  <tr>
                                   <td height="10" colspan="6" background="../images/portalImage/table_bg3.jpg"></td>
                                    </tr>
                                  <tr>
                                    <td height="60" colspan="2" align="right" valign="top" >
                                    	<a href="http://www.acura-apps.com/prescript-web">
                                    		<img src="${pageContext.request.contextPath}/images/portalImage/easy-prescription-img.jpg" width="304" height="60" />
                                    	</a>
                                    </td>
                                   
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
                      </table>
                      </td>
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