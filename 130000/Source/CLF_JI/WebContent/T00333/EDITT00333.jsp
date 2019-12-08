<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/T00333/EDITT00333.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});
</script>
<style type="text/css">
<!--
.labelA {
	width: 80px;
}
body {
	background-color: #FFFFFF;
}
-->
</style>

</head>
<body>
<table>
	<tr>
		<td valign="top">
		<fieldset style="width: 600px;">
		<form id="editForm" action="../pg/UPDT00333.action" method="post">
		<input type="hidden" id="txtFCID" name="txtFCID" value="<s:property value="txtFCID" />" />
		<input type="hidden" id="txtPSSD" name="txtPSSD" value="<s:property value="txtPSSD" />" />
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="20%">评估价格</td>
				<td>
					<span class="txtRed">
					<a href="javascript:Show('../pg/VIEWT00334.action?signG=G&ACT=C&txtFCID=<s:property value="txtFCID"/>&txtPSSD=<s:property value="txtPSSD"/>',350,800,'估价信息');"><img src='../images/info.png' height='16' width='16' /></a>
					<s:if test="%{null==t00332Bean}"><s:text name="app.global.format.moneyZh"><s:param value="t00331Bean.pgjg" /></s:text></s:if><s:else><s:text name="app.global.format.moneyZh"><s:param value="t00332Bean.pgjg" /></s:text></s:else>
					<s:else><s:text name="app.global.format.integerZH"><s:param value="t00331Bean.pgjg" /></s:text></s:else></span>（元）
				</td>
			</tr>
			<tr>
				<td width="20%"><s:property value="getText('app.sjpg.t00332.title')" /></td>
				<td><span class="lab"></span><input type="text" id="txtGAJG" name="txtGAJG" value="<s:if test="%{null==t00332Bean}"><s:property value="t00331Bean.gapgjg"/></s:if><s:else><s:property value="t00332Bean.gbpgjg"/></s:else>" class="txtfocus txtNumber labelA"/>（元）</td>
			</tr>
			<tr>
			<td><s:property value="getText('app.note')" /></td>
			 <td>
				<span class="lab"></span><textarea class="txtfocus" name="txtNOTE" id="txtNOTE" cols="70" rows="10" ><s:property value="t00331Bean.gaNote" /></textarea>
			</td>
			</tr>
			<tr>
				<td></td>
				<td><span><input type="submit" class="button" id="btnSave" name="btnSave"	value="<s:property value="%{getText('app.button.update')}" />" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="button"	id="btnDle" name="btnDle" value="删除" /></span></td>
			</tr>
		</table>
		</form>
		</fieldset>
		</td>
	</tr>
</table>
</body>
</html>