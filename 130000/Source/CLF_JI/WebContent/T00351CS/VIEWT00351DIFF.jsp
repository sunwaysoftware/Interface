<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}" /></title>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<link type="text/css" rel="stylesheet"
	href="../css/jquery.autocomplete.css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>

<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/T00351CS/T00351CSWTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00351CS/VIEWT00351DIFF.js"></script>
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
.labelA {
	width: 70px;
}
-->
</style>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0"
	class="table1">
	<tr>
		<td align="left" valign="top">
		<div id="tabs" class="ui-widget-content">
		<ul
			class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
			<li><a href="#INFO"><span><s:property
				value="%{getText('app.xtwh.bzfcs.title.diffarea')}" /></span></a></li>
		</ul>
		<div id="INFO" class="divConect">
		<form id="findForm"><input type="hidden" name="hidSelect"
			id="hidSelect" />
		<table width="450" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td><label class="labelA"> <s:property
					value="%{getText('app.xtwh.t00001.pssd')}" /> </label><input
					name="txtPSSD" id="txtPSSD" type="text"
					value="<s:if test="null!=txtPSSD"><s:text name="app.global.format.date"><s:param value="txtPSSD" /></s:text></s:if>"
					onfocus="WdatePicker({dateFmt:'yyyy-MM'})" class="Wdatefocus" /></td>
				<td><label class="labelA"> <s:property
					value="getText('app.xtwh.info.szqy')" /> </label> <sw:szqy
					classid="txtfocus" items="szqyList" name="ddlSZQY" id="ddlSZQY"
					display="请选择..." /></td>
			</tr>
		</table>
		<table width="800" border="0" cellpadding="0" cellspacing="2">
			<tr>
				<td valign="top">
				<fieldset style="height: 300px;"><legend><span>【无价格小区数据】</span></legend>
				<table width="380" border="0" cellspacing="2" cellpadding="0">
					<tr>
						<td><label class="labelA"><s:property	value="getText('app.xtwh.t00303.xqmc')" /></label>
						<span class="txtInfonm txtfocus"><input
							name="txtXQTIP" id="txtXQTIP" type="text" readonly="readonly" /><span
							id="spXQDM"></span></span><input type="hidden" id="txtXQDM"
							name="txtXQDM"
							value="<s:property value="v00303Bean.cd00352Xqdm" />" /> <input
							name="btnSearch" type="button" id="btnSearch" class="button"
							value="<s:property value="getText('app.button.search')"/>" /></td>
					</tr>
				</table>
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
							<th twidth="130"><s:property
								value="%{getText('app.xtwh.t00303.zcdzl')}" /></th>
							<th twidth="100"><s:property
								value="%{getText('app.xtwh.info.jylx')}" /></th>
							<th twidth="150"><s:property
								value="%{getText('app.xtwh.info.fwlx')}" /></th>
							<th twidth="120"><s:property
								value="%{getText('app.xtwh.info.jzjg')}" /></th>
						</tr>
					</thead>
					<tbody id="divShow">
						<tr id="rowtemplate">
							<td id="no" align="center"></td>
							<td id="chk" align="center"></td>
							<td id="slid" align="center"></td>
							<td id="xqnm"></td>
							<td id="zldz"></td>
							<td id="jylx"></td>
							<td id="fwlx"></td>
							<td id="jzjg"></td>
						</tr>
					</tbody>
				</table>
				</fieldset>
				</td>
				<td valign="top">
				<fieldset><legend><span>【有价格小区数据】</span></legend>
				<div id="YJG"><iframe id="IYJG" width="380px" height="305px"
					frameborder="0" scrolling="auto"
					XQMC="<s:property value="txtXQMC" />"
					PSSD="<s:property value="txtPSSD" />"></iframe></div>
				</fieldset>
				</td>
			</tr>
		</table>
		</form>
		<form id="updForm">
		<table cellpadding="0" cellspacing="5" style="width: 300px;">
			<tr>
				<td>估价时点：</td>
				<td align="left"><span id="spWPssd"></span> <input
					type="hidden" name="hidWPssd" id="hidWPssd" /></td>
			</tr>
			<tr>
				<td>无价格的房产：</td>
				<td align="left"><span id="spWfc"></span> <input type="hidden"
					name="hidWfc" id="hidWfc" /></td>
			</tr>
			<tr>
				<td>有价格的房产：</td>
				<td align="left"><span id="spYfc"></span> <input type="hidden"
					name="hidYfc" id="hidYfc" /></td>
			</tr>
			<tr>
				<td>房产的价格：</td>
				<td><input name="txtFcjg" id="txtFcjg" class="txtNumber"
					type="text" value="0" /></td>
			</tr>
			<tr>
				<td align="left"><input name="btnUpd" type="button" id="btnUpd"
					class="button" value="更新" /></td>
				<td></td>
			</tr>
		</table>
		</form>
		</div>
		</div>
		</td>
	</tr>
</table>
<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
<div id="infoTreeDIV"></div>
</div>
</body>
</html>