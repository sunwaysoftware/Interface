<%@ page contentType="text/html; charset=utf-8" language="java" isErrorPage="true" %>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="main.ico" /> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="getText('app.global.title')"/></title>
<link href="css/screen.css" rel="stylesheet" type="text/css" />
<link href="css/<s:property value="%{getText('app.global.name')}" />.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/easyui/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="scripts/jquery.validate.js"></script>
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/messages_cn1.js"></script>
<script language="javascript" type="text/javascript">
$(document).ready(function() {

	$.notifyBar({cls: "error1", html: '<s:property value="actionErrors.get(0)"/>' });	
	
	//FROM验证信息
	$("#frmLogin").validate({
		rules: {
			txtUserID: {required: true},
			txtUserPwd: {required: true}
		}
	});
});

</script>
<style type="text/css">
<!--
body {
	background-image: url();
	background-repeat: repeat-y;
	background-color: #226ac8;
}
.bgfont {	font-size: 13pt;
	font-weight: bold;
	color: #000;
}
input{
	border: 1px solid #000000;
	height:20px;
	font-family: "宋体";
	font-size: 14px;
	
}
-->
</style>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="bj04" height="100" align="center" valign="top"><table width="1000" border="0" cellspacing="0" cellpadding="0">
      <tr></tr>
      <tr>
        <td colspan="4" class="default_1" width="1000" height="95"></td>
      </tr>
      <tr>
        <td class="default_2" width="260" height="145"></td>
        <td class="default_3" width="304" height="145"></td>
        <td class="default_4" width="286" height="145"></td>
        <td class="default_5" width="150" height="145"></td>
      </tr>
      <tr>
        <td class="default_6" width="260" height="154"></td>
        <td class="default_7" width="304" height="154"></td>
        <td class="default_8">
        <form id="frmLogin" action="LOGIN.action" method="post"><table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="bottom">&nbsp;</td>
    <td>&nbsp;</td>
    <td><input type="text" name="txtUserID" id="txtUserID" style="width: 120px"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td width="35%" valign="bottom">&nbsp;</td>
    <td width="33%">&nbsp;</td>
    <td width="21%"><input type="password" name="txtUserPwd" id="txtUserPwd" style="width: 120px"/></td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td width="20%"><label>
                <input name="button" type="submit" class="button" id="button" value="登录" />&nbsp;
                <input name="button2" type="reset" class="button" id="button2" value="重置" />
                </label></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  
</table>         
        </form></td>
        <td class="default_9" width="150" height="154"></td>
      </tr>
      <tr>
        <td class="default_10" width="260" height="166"></td>
        <td class="default_11" width="304" height="166"></td>
        <td class="default_12" width="286" height="166"></td>
        <td class="default_13" width="150" height="166"></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="4" bgcolor="#FFFFFF"></td>
  </tr>
  <tr>
    <td align="center" valign="top" class="bj04"><br/><s:property value="getText('app.global.foot')" escape="false" />&nbsp;<a href="javascript:Show('version.jsp',600,400,'VersionInfo');" title="版本更新信息">version</a></td>
  </tr>
</table>
</body>
</html>
