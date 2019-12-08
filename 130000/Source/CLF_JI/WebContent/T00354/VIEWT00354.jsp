<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>

<script type="text/javascript" src="../scripts/T00354/VIEWT00354.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>

<style type="text/css">
<!--

-->
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
    <div id="tabs" class="ui-widget-content">
        <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
            <li><a href="#INFO"><span><s:property value="%{getText('app.xtwh.t00354.title')}" /></span></a></li>                    
        </ul>
		<div id="INFO" class="divConect">
<form id="findForm" action="#" method="post">
<div id="apDiv1">
<table width="400" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>&nbsp;<s:property value="getText('app.xtwh.info.szqy')"/></td>
    <td>&nbsp;<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/></td>
  </tr>
  <tr>
    <td>&nbsp;<s:property value="getText('app.xtwh.info.fwcx')"/></td>
    <td>&nbsp;<input type="text" class="txtCode" id="txtFWCXFind" name="txtFWCXFind" value="<s:property value="txtFWCXFind" />"/>	
	<input name="txtFWCXTIP" class="txtInfonm" id="txtFWCXTIP" type="text" readonly="readonly"/>
	<input name="btnFWCX" class="button" id="btnFWCX" type="button" value="..."/></td>
  </tr>
  <tr>
	<td>&nbsp;<s:property value="getText('app.xtwh.t00001.pssd')"/></td>
	<td>&nbsp;<input type="text" id="txtPSSDFind" name="txtPSSDFind" onfocus="WdatePicker({dateFmt:'yyyy'})" class="Wdate" /></td>
  </tr>
</table>
	</div>
	<input name="btnSearch" type="button" id="btnSearch" class="button" value="<s:property value="getText('app.button.search')"/>" /><input name="btnConditions" type="button" title="显示搜索条件" id="btnConditions" class="button" value="↓" />
	<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>
</form>
<s:actionerror/><s:actionmessage/>
	<table id="scroll1" class="scroll" cellpadding="0" cellspacing="0" style="width:100%;height:400px">
         	<thead>
				<tr>
					<th twidth="50">No</th>
					<th twidth="50">操作</th>
					<th twidth="60"><s:property value="%{getText('app.xtwh.t00001.pssd')}" /></th>
					<th twidth="80"><s:property value="%{getText('app.xtwh.info.szqy')}" /></th>
					<th twidth="80"><s:property value="%{getText('app.xtwh.info.fwcx')}" /></th>
					<th twidth="80"><s:property value="%{getText('app.xtwh.sywh.xzxs')}" /></th>
					<th twidth="150"><s:property value="%{getText('app.upddate')}" /></th>
					<th twidth="80"><s:property value="%{getText('app.czr')}" /></th>
					<th twidth="150"><s:property value="%{getText('app.note')}" /></th>
				</tr>
            </thead>
		<tbody id="divShow">
			<tr id="rowtemplate">
			    <td id="no"></td>
			    <td id="edit"></td>
				<td id="pssd"></td>
				<td id="szqy"></td>
				<td id="fwcx"></td>
				<td align="right" id="xzxs"></td>
				<td id="upddate"></td>
				<td id="czr"></td>
				<td id="note"></td>
			</tr>
		</tbody>
	</table>

<div class="divbottom">
<div>
	<s:url id="urlAdd" action="ADDT00354"><s:param name="ACT">C</s:param></s:url>
	<s:a href="%{urlAdd}">
		<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>" alt="<s:property value="getText('app.button.add')"/>" /><s:property value="getText('app.button.add')"/>
	</s:a>
	<a href="VIEWT00354COPY.action">
 	    <img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.copy')"/>" alt="<s:property value="getText('app.button.copy')"/>" /><s:property value="getText('app.button.copy')"/>
    </a>
</div>
</div>
</div>
</div>
    </td>
  </tr>
</table>
</body>
</html>