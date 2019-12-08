<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>


<script type="text/javascript" src="../scripts/T00009/VIEWT00009.js"></script>



<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});    
</script>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
    <div id="tabs" class="ui-widget-content">
        <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
            <li><a href="#INFO"><span><s:property value="%{getText('app.xtwh.t00009.title')}" /></span></a></li>                    
        </ul>
		<div id="INFO" class="divConect">

<form id="findForm" action="#" method="post">
<div id="apDiv1">
<table width="300" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>&nbsp;<s:property value="getText('app.xtwh.t00002.userid')"/></td>
    <td>&nbsp;<input type="text" id="txtUSERIDFind" name="txtUSERIDFind" /></td>
  </tr>
  <tr>
    <td>&nbsp;<s:property value="getText('app.xtwh.t00002.usernm')"/></td>
    <td>&nbsp;<input type="text" id="txtUSERNMFind" name="txtUSERNMFind" /></td>
  </tr>
</table>
</div>    
	<input name="btnSearch" type="button" id="btnSearch" class="button" value="<s:property value="getText('app.button.search')"/>" /><input name="btnConditions" type="button" title="显示搜索条件" id="btnConditions" class="button" value="↓" />
</form>
<table id="scroll1" class="scroll" cellpadding="0" cellspacing="0" style="width:100%;height:350px">
        	<thead>
			<tr>
				<th twidth="50">No</th>
				<th twidth="50">操作</th>
				<th twidth="150"><s:property value="getText('app.xtwh.t00002.userid')"/></th>
				<th twidth="150"><s:property value="getText('app.xtwh.t00002.usernm')"/></th>
				<th twidth="150"><s:property value="%{getText('app.xtwh.t00009.ssgx')}" /></th>
				<th twidth="150"><s:property value="%{getText('app.upddate')}" /></th>
				<th twidth="150"><s:property value="%{getText('app.czr')}" /></th>
				<th twidth="150"><s:property value="%{getText('app.note')}" /></th>
			</tr>
           </thead>
	<tbody id="divShow">
		<tr id="rowtemplate">
		    <td id="no" align="center"></td>
		    <td id="edit" align="center"></td>
		    <td id="userid"></td>
			<td id="usernm"></td>
			<td id="ssgx"></td>
			<td id="upddate" align="center"></td>
			<td id="czr"></td>
			<td id="note"></td>
		</tr>
	</tbody>
</table>
<div class="divbottom">
<div>
	<s:url id="urlAdd" action="ADDT00009"><s:param name="ACT">C</s:param></s:url>
	<s:a href="%{urlAdd}">
		<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>" alt="<s:property value="getText('app.button.add')"/>" /><s:property value="getText('app.button.add')"/>
	</s:a>
</div>
</div>
</div>
</div>
    </td>
  </tr>
</table>
</body>
</html>
