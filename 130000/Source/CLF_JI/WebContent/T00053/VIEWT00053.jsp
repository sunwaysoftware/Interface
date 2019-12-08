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


<script type="text/javascript" src="../scripts/T00053/VIEWT00053.js"></script>



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
            <li><a href="#INFO"><span><s:property value="%{getText('app.xtwh.t00053.title')}" /></span></a></li>
        </ul>
		<div id="INFO" class="divConect">
<form id="findForm" action="#" method="post">
<div id="apDiv1">
<table width="300" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>&nbsp;<s:property value="getText('app.xtwh.info.szqy')"/></td>
    <td>&nbsp;<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/></td>
  </tr>
  <tr>
    <td>&nbsp;<s:property value="getText('app.xtwh.t00053.xzlx')"/></td>
    <td>&nbsp;<select name="ddlXZLXFind" id="ddlXZLXFind">
      <option value="">全部</option>
      <s:iterator id="XzlxEntity" value="xzlxList" status="index">
        <s:if test="%{ddlXZLXFind==xzlx}">
          <option selected="selected" value=xzlx><s:property value="xzmc" /></option>
        </s:if>
        <s:else>
          <option value="<s:property value="xzlx" />"><s:property value="xzmc" /></option>
        </s:else>
      </s:iterator>
    </select></td>
  </tr>
  <tr>
    <td>&nbsp;<s:property value="getText('app.xtwh.t00053.dxmc')"/></td>
    <td>&nbsp;<input type="text" name="txtQtxzmcFind" id="txtQtxzmcFind" value="<s:property value="txtQtxzmcFind" />" /></td>
  </tr>
</table>
</div>
  <input name="btnSearch" type="button" id="btnSearch" class="button" value="<s:property value="getText('app.button.search')"/>" /><input name="btnConditions" type="button" title="显示搜索条件" id="btnConditions" class="button" value="↓" />
  <div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
    <div id="infoTreeDIV"></div>
  </div>
</form>
<table id="scroll1" class="scroll" cellpadding="0" cellspacing="0" style="width:100%;height:350px">
	<thead>
		<tr>
			<th twidth="50">No</th>
			<th twidth="50">操作</th>
			<th twidth="80"><s:property value="getText('app.xtwh.info.szqy')"/></th>
			<th twidth="120"><s:property value="getText('app.xtwh.t00053.dxmc')"/></th>
			<th twidth="150"><s:property value="getText('app.xtwh.t00053.parentid')"/></th>
			<th twidth="100"><s:property value="getText('app.xtwh.t00053.xzlx')"/></th>
			<th twidth="80"><s:property value="getText('app.xtwh.t00053.xzxs')"/></th>
			<th twidth="80"><s:property value="getText('app.xtwh.t00353.yslb')"/></th>
			<th twidth="80"><s:property value="getText('app.xtwh.t00001.isdir')"/></th>
			<th twidth="150"><s:property value="getText('app.upddate')"/></th>
			<th twidth="80"><s:property value="getText('app.czr')"/></th>
			<th twidth="150"><s:property value="getText('app.note')"/></th>
		</tr>
	</thead>
	<tbody id="divShow">
		<tr id="rowtemplate">
			<td id="no" align="center"></td>
			<td id="edit" align="center"></td>
			<td id="szqy"></td>
			<td id="qtxznm"></td>
			<td id="parentnm"></td>
			<td id="xzmc"></td>
			<td align="right" id="xzxs"></td>
			<td id="yslb" align="center"></td>
			<td id="dir" align="center"></td>
			<td id="upddate" align="center"></td>
			<td id="czr"></td>
			<td id="note"></td>
		</tr>
	</tbody>
</table>

<div class="divbottom">
<div>
	<s:url id="urlAdd" action="ADDT00053"><s:param name="ACT">C</s:param></s:url>
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
