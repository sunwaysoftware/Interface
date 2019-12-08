<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}" /></title>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/T00351CS/T00351CSYTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00351CS/VIEWT00351DIFFY.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar( {
			cls : "success",
			html : '<s:property value="actionMessages.get(0)"/>'
		});
		$.notifyBar( {
			cls : "error",
			html : '<s:property value="actionErrors.get(0)"/>'
		});
	});
</script>
<style type="text/css">
<!--
body {
	background-color: #ffffff;
}
.labelA {
	width: 70px;
}
-->
</style>
</head>
<body>
<input type="hidden" name="hidSelect" id="hidSelect" />
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
	<tr>
		<td align="left" valign="top">
		<table width="300" border="0" cellspacing="2" cellpadding="0">
			<tr>
				<td><label class="labelA"><s:property
					value="getText('app.xtwh.t00303.xqmc')" /></label><span
					class="txtInfonm txtfocus"><input name="txtXQTIP"
					id="txtXQTIP" type="text" readonly="readonly" /><span id="spXQDM"></span></span><input
					type="hidden" id="txtXQDM" name="txtXQDM"
					value="<s:property value="v00303Bean.cd00352Xqdm" />" /> <input
					name="btnSearch" type="button" id="btnSearch" class="button"
					value="<s:property value="getText('app.button.search')"/>" /></td>
			</tr>
		</table>
		<input name="ddlSZQY" id="ddlSZQY" type="hidden"
			value="<s:property value='ddlSZQY'/>" /> <input name="txtPSSD"
			id="txtPSSD" type="hidden" value="<s:property value='txtPSSD'/>" />
		<table id="scroll1" class="scroll" cellpadding="0" cellspacing="0"
			style="width: 380px; height: 230px">
			<thead>
				<tr>
					<th twidth="50">No</th>
					<th twidth="50">操作</th>
					<th twidth="150"><s:property
						value="%{getText('app.xtwh.t00351.slid')}" /></th>
					<th twidth="100"><s:property
						value="%{getText('app.xtwh.t00303.xqmc')}" /></th>
					<th twidth="100"><s:property
						value="%{getText('app.xtwh.info.jylx')}" /></th>
					<th twidth="150"><s:property
						value="%{getText('app.xtwh.info.fwlx')}" /></th>
					<th twidth="120"><s:property
						value="%{getText('app.xtwh.info.jzjg')}" /></th>
					<th twidth="180"><s:property
						value="%{getText('app.xtwh.t00351.pfmjg')}" /></th>
				</tr>
			</thead>
			<tbody id="divShow">
				<tr id="rowtemplate">
					<td id="no" align="center"></td>
					<td id="chk" align="center"></td>
					<td id="slid" align="center"></td>
					<td id="xqnm"></td>
					<td id="jylx"></td>
					<td id="fwlx"></td>
					<td id="jzjg"></td>
					<td id="pfmjg"></td>
				</tr>
			</tbody>
		</table>
		
		<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
		</div>
		</td>
	</tr>
</table>
</body>
</html>