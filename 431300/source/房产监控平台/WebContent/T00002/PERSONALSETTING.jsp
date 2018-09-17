<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/easyui/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00002/PERSONALSETTING.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});    
</script>
<style type="text/css">
<!--
.ssgx {
	width:220px;
}
-->
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">	
	 <div id="tabs" class="easyui-tabs" style="height:300px">
		<div id="XGMM" title="<s:property value="%{getText('app.xtwh.t00002.xgmm')}" />">
			<form action="#" method="post" id="XGMMForm">
				<table>
					<tr>
						<td colspan="1"><div id="statusTip1" style="color:red;"></div></td>
					</tr>
					<tr>
						<td><s:property value="getText('app.xtwh.t00002.olduserpwd')"/></td>
						<td><input type="password"	name="txtUSEROLDPWD" id="txtUSEROLDPWD"  class="txtfocus" /></td>
					</tr>
					<tr>
						<td><s:property value="getText('app.xtwh.t00002.newuserpwd')"/></td>
						<td><input type="password" name="txtUSERNEWPWD1" id="txtUSERNEWPWD1"  class="txtfocus" /></td>
					</tr>
					<tr>
						<td><s:property value="getText('app.xtwh.t00002.confirmpwd')"/></td>
						<td><input type="password" name="txtUSERNEWPWD2" id="txtUSERNEWPWD2"  class="txtfocus" /></td>
					</tr>
					<tr >
						<td ></td>
						<td><input type="button" name="btnUpdPwd" id="btnUpdPwd" value="更新密码" class="button"/></td>
					</tr>
				</table>
			</form>
		</div>	
		</div>
    </td>
  </tr>
</table>
</body>
</html>
