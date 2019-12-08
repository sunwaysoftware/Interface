<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/T00051/VIEWT00051.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>



<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});    
</script>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0"
	class="table1">
	<tr>
		<td align="left" valign="top">
		<div id="tabs" class="ui-widget-content">
        <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
            <li><a href="#INFO"><span><s:property value="%{getText('app.xtwh.t00051.title')}" /></span></a></li>                    
        </ul>
		<div id="INFO" class="divConect">
<form id="findForm" action="#" method="post">
 <div id="apDiv1">
 
 <table width="300" border="0" cellspacing="0" cellpadding="0">
 	<tr>
 		<td>&nbsp;<s:property value="getText('app.xtwh.info.szqy')"/></td>
		<td>&nbsp;<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/>
		</td>
	</tr>
	<tr>
		<td>&nbsp;<s:property value="getText('app.xtwh.t00001.pssd')"/></td>
		<td>&nbsp;<input type="text" id="txtPSSD" name="txtPSSD" value="<s:property value="t00051Bean.cd00002Pssd"/>" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd', maxDate:'%y'})" class="Wdatefocus txtfocus" />	
		</td>
	</tr>	
</table>
</div>
<input name="btnSearch" type="button" id="btnSearch" class="button" value="<s:property value="getText('app.button.search')"/>" /><input name="btnConditions" type="button" title="显示搜索条件" id="btnConditions" class="button" value="↓" />
</form>
		<table id="scroll1" class="scroll" cellpadding="0" cellspacing="0" style="width: 100%; height: 350px">
			<thead>
				<tr>
					<th twidth="40">No</th>
					<th twidth="50">操作</th>
					<th twidth="80"><s:property value="%{getText('app.xtwh.t00001.pssd')}" /></th>
					<th twidth="120"><s:property value="%{getText('app.xtwh.info.szqy')}" /></th>
					<th twidth="170"><s:property value="%{getText('app.xtwh.info.fwlx')}" /></th>
					<th twidth="170"><s:property value="%{getText('app.xtwh.info.jylx')}" /></th>
					<th twidth="150"><s:property value="%{getText('app.xtwh.t00051.jsbl')}" /></th>
					<th twidth="80"><s:property value="%{getText('app.xtwh.t00051.sl')}" /></th>
					<th twidth="150"><s:property value="%{getText('app.upddate')}" /></th>
					<th twidth="80"><s:property value="%{getText('app.czr')}" /></th>
					<th twidth="150"><s:property value="%{getText('app.note')}" /></th>
				</tr>
			</thead>
			<tbody id="divShow">
				<tr id="rowtemplate">
					<td id="no" align="center"></td>
					<td id="edit" align="center"></td>
					<td id="pssd" align="center"></td>
					<td id="szqy"></td>
					<td id="fwlx"></td>
					<td id="jylx"></td>
					<td align="right" id="jsbl"></td>
					<td align="right" id="sl"></td>
					<td id="upddate" align="center"></td>
					<td id="czr"></td>
					<td id="note"></td>
				</tr>
			</tbody>
		</table>
		<div class="divbottom">
		<div><s:url id="urlAdd" action="ADDT00051">
			<s:param name="ACT">C</s:param>
		</s:url> <s:a href="%{urlAdd}">
			<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>"
				alt="<s:property value="getText('app.button.add')"/>" />
			<s:property value="getText('app.button.add')" />
		</s:a></div>
		</div>
		</div>
		</div>
		</td>
	</tr>
</table>
</body>

</html>
