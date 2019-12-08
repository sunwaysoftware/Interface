<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>

<script type="text/javascript" src="../scripts/T00370/VIEWT003701.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
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
	width: 190px;
}
body {
	background-color: #FFFFFF;
}
-->
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0">	
	<tr>
		<td valign="top">
		<fieldset style="width: 450px;">
		<legend>【<s:property value="%{getText('app.xtwh.t00370.title')}" />】</legend>
		
		【<s:property value="%{getText('app.xtwh.t00370.cs')}" />】
		<div id="JBXX">
		<form id="editForm" action="../xtwh/EDITT00370.action" method="post">	
		<input type="hidden" id="hidSelect" name="hidSelect" />
		<input type="hidden" id="txtFCID" name="txtFCID" value="<s:property value="txtFCID" />" />
		<input type="hidden" id="txtFCSLHSign" name="txtFCSLHSign" value="<s:property value='txtFCSLHSign' />"/>
		<input type="hidden" name="ACT" id="ACT" value="C" />
		
		<table width="100%" border="0" cellspacing="0" cellpadding="3">
			<s:iterator value="resList" status="dex" id="szList" >
            <tr>
	      		<td>
		      		<label class="labelA"><s:property value="sz" /></label>														
				    <input type="text" class="txtfocus txtNumber" id="txt<s:property value="#dex.getIndex()+1" />" name="txt<s:property value="#dex.getIndex()+1" />" value="<s:property value="se" />"/>
			    </td>
		   </tr>
		   </s:iterator> 
		    <tr>
				<td>
					<input type="hidden" readonly="readonly" id="txtFPID" name="txtFPID" value="<s:property value="txtFPID" />" />
				</td>
			</tr> 
			<tr>
				<td>
					<input type="hidden" readonly="readonly" id="txtSPID" name="txtSPID" value="<s:property value="txtSPID" />" />
				</td>
			</tr>	
			<tr>
				<td>
					<input type="hidden" readonly="readonly" id="txtDFSPID" name="txtDFSPID" value="<s:property value="txtDFSPID" />" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="button" id="btnDJZSe" name="btnDJZSe" value="获取金三征管完税信息" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" class="button"	id="btnSave" name="btnSave"	value="保存信息" />
					<s:if test="%{isAdd}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" class="button"	id="btnhx" name="btnhx"	value="完税确认" />
					</s:if>
				</td>
			</tr>
		</table>
		      </form>		      
		</div>	
		</fieldset>
		</td>
	</tr>
</table>
</body>
</html>