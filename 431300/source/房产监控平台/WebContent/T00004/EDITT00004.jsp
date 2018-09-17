<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/easyui/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00004/EDITT00004.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
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
	width: 120px;
}
-->
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
	<tr>
		<td align="left" valign="top">
		<div id="tabs" class="ui-tabs ui-widget ui-widget-content ui-corner-all">
		<div class="datagrid-title">
				<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00004.title')}" /></span>
			</div>
		<div id="INFO" class="divConect">
		<div style="min-height: 400px">
		<form action="EDITT00004.action" method="post" id="editForm">
			<input type="hidden" name="ACT" id="ACT" value='<s:property value="ACT"/>' />			
			<input type="hidden" name="txtID" id="txtID" value='<s:property value="t00004Bean.id"/>' />
			<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00004Bean.upddate"/></s:text>" />
			
		<table width="500" border="0" cellspacing="3" cellpadding="0">			
			
            <tr>
				<td><label class="labelA"> <s:property
					value="getText('app.xtwh.t00004.js')" /> </label> <input type="text"
					class="txtfocus" id="txtJS" name="txtJS"
					 value="<s:property value="t00004Bean.js"  />"
					<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>  /></td>
			</tr>
			        <tr>
				<td><label class="labelA"> <s:property
					value="getText('app.xtwh.t00004.xs')" /> </label>
					<textarea name="txtXS" cols="30" rows="5" class="txtfocus" id="txtXS" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>><s:property value="t00004Bean.xs"  /></textarea>
					</td>
			</tr>
			
		</table>
		</form>
		</div>
		<div class="divbottom">
		<div><a href="#" id="btnUpd" name="btnUpd" <s:if test='%{ACT!="U"}'>style="display:none"</s:if> class="easyui-linkbutton" plain="true" iconCls="icon-edit"><s:property value="getText('app.button.upd')" /></a> 
			<a href="#" id="btnDel" name="btnDel" <s:if test='%{ACT!="D"}'>style="display:none"</s:if> class="easyui-linkbutton" plain="true" iconCls="icon-delete"><s:property value="getText('app.button.del')" /></a> 
			<a href="#" id="btnAdd" name="btnAdd" <s:if test='%{ACT!="C"}'>style="display:none"</s:if> class="easyui-linkbutton" plain="true" iconCls="icon-save"><s:property value="getText('app.button.save')" /></a>
			<a href="VIEWT00004.action" class="easyui-linkbutton" plain="true" iconCls="icon-back"><s:property value="getText('app.button.back')" /></a></div>
		</div>
		</div>
		</div>
		</td>
	</tr>
</table>
</body>
</html>