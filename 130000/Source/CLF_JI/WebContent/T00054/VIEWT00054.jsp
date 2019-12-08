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


<script type="text/javascript" src="../scripts/T00054/VIEWT00054.js"></script>
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
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
    <div id="tabs" class="ui-widget-content">
        <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
            <li><a href="#INFO"><span><s:property value="%{getText('app.xtwh.t00054.title')}" /></span></a></li>                    
        </ul>
		<div id="INFO" class="divConect">

<form id="findForm" action="#" method="post">
<div id="apDiv1">
	<s:property value="getText('app.xtwh.info.szqy')"/>
	<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/>
</div>  	
	<input name="btnSearch" type="button" id="btnSearch" class="button" value="<s:property value="getText('app.button.search')"/>" /><input name="btnConditions" type="button" title="显示搜索条件" id="btnConditions" class="button" value="↓" />
</form>
	<table id="scroll1" class="scroll" cellpadding="0" cellspacing="0" style="width:100%;height:350px">
         	<thead>
				<tr>
					<th twidth="50">操作</th>
					<th twidth="80"><s:property value="%{getText('app.xtwh.info.szqy')}" /></th>
					<th twidth="80"><s:property value="getText('app.xtwh.t00054.bzbm')"/></th>
					<th twidth="150"><s:property value="getText('app.xtwh.t00054.bzmc')"/></th>
					<th twidth="150"><s:property value="getText('app.xtwh.t00054.jzqs')"/></th>
					<th twidth="150"><s:property value="getText('app.xtwh.t00054.lsxs')"/></th>
					<th twidth="150"><s:property value="getText('app.xtwh.t00054.jgxgc')"/></th>
					<th twidth="150"><s:property value="getText('app.upddate')"/></th>
					<th twidth="150"><s:property value="getText('app.czr')"/></th>
					<th twidth="150"><s:property value="getText('app.note')"/></th>
				</tr>
            </thead>
		<tbody id="divShow">
			<tr id="rowtemplate">
			    <td id="edit"></td>
			    <td id="szqy"></td>
				<td id="bzbm"></td>
				<td id="bzmc"></td>
				<td align="right" id="jzqs"></td>
				<td align="right" id="lsxs"></td>
				<td align="right" id="jgxgc"></td>
				<td id="upddate"></td>
				<td id="czr"></td>
				<td id="note"></td>
			</tr>
		</tbody>
	</table>
	<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>
	<div class="divbottom">
<div>
	<s:url id="urlAdd" action="ADDT00054"><s:param name="ACT">C</s:param></s:url>
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
