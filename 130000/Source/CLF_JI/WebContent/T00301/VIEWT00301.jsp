<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/T00301/VIEWT00301.js"></script>
<style type="text/css">
<!--

-->
</style>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">

<form id="findForm" action="#" method="post">
	<input type="hidden" name="ACT" id="ACT" value="<s:property value="ACT" />" />
    <div id="apDiv1">
    <table width="300" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;<s:property value="getText('app.sjcj.t00301.swid')"/></td>
        <td>&nbsp;<input type="text" class="txtID" id="txtSWIDFind" name="txtSWIDFind" /></td>
      </tr>
      <tr>
        <td>&nbsp;<s:property value="getText('app.sjcj.t00301.nsrmc')"/></td>
        <td>&nbsp;<input type="text" class="txtNSRMC" id="txtNSRMCFind" name="txtNSRMCFind" /></td>
      </tr>
    </table>
    </div>
	<input name="btnSearch" class="button" type="button" id="btnSearch" value="<s:property value="getText('app.button.search')"/>" /><input name="btnConditions" type="button" title="显示搜索条件" id="btnConditions" class="button" value="↓" />
</form>
<s:actionerror/><s:actionmessage/>
<table id="scroll1" class="scroll" cellpadding="0" cellspacing="0" style="width:100%;height:350px">
    <thead>
		<tr>
			<th twidth="40">No</th>
			<th twidth="60">操作</th>
			<th twidth="150"><s:property value="%{getText('app.sjcj.t00301.swid')}" /></th>
			<th twidth="80"><s:property value="%{getText('app.sjcj.t00301.nsrmc')}" /></th>
			<th twidth="80"><s:property value="%{getText('app.xtwh.info.zjlx')}" /></th>
			<th twidth="150"><s:property value="%{getText('app.sjcj.t00301.zz')}" /></th>
			<th twidth="150"><s:property value="%{getText('app.sjcj.t00301.lxdh')}" /></th>
		</tr>
    </thead>
	<tbody id="divShow">
		<tr id="rowtemplate">
		    <td id="no"></td>
		    <td id="edit"></td>
			<td id="swid"></td>
			<td id="nsrmc"></td>
			<td id="zjlx"></td>
			<td id="zz"></td>
			<td id="lxdh"></td>
			
		</tr>
	</tbody>
</table>

<s:if test='%{ACT!="M"}'>
<div>
	<s:url id="urlAdd" action="ADDT00301"><s:param name="ACT"><s:property value="getText('app.global.ctrlmode.create')"/></s:param></s:url>
	<s:a href="%{urlAdd}">
	<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>" alt="<s:property value="getText('app.button.add')"/>" /><s:property value="getText('app.button.add')"/>
	</s:a>
</div>
</s:if>
    </td>
  </tr>
</table>
</body>
</html>
