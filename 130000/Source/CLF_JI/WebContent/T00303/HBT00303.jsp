<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00303/HBT00303.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<link href="../css/jquery.autocomplete.css" rel="stylesheet" type="text/css" />



<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
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
	
	<div id="tabs" class="ui-widget-content">
        <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
            <li><a href="#INFO"><span><s:property value="%{getText('app.xtwh.t00303.title')}" /></span></a></li>
        </ul>
		<div id="INFO" class="divConect">
		<div style="min-height:400px">
	<form id="editForm" action="HBEDITT00303.action" method="post">
	<input type="hidden" name="hbLfidList" value='<s:property value="hbLfidList"/>' />
	<input type="hidden" name="hidSelect" id="hidSelect" />
	<input type="hidden" name="ACT" id="ACT" value='<s:property value="ACT"/>'/>
		<input type="hidden" name="FWTDZL" id="FWTDZL"/>
		<table id="scroll1" class="scroll" cellpadding="0" cellspacing="0" style="width:100%;height:300px">
		  <thead>
		    <tr>
		      <th twidth="40">操作</th>
		      <th twidth="80"><s:property value="%{getText('app.xtwh.t00303.xqmc')}" /></th>
		      <th twidth="80"><s:property value="%{getText('app.xtwh.info.szqy')}" /></th>
		      <th twidth="80"><s:property value="%{getText('app.xtwh.t00303.ywdt')}" /></th>
		      <th twidth="80"><s:property value="%{getText('app.xtwh.t00303.zlc')}" /></th>
		      <th twidth="150"><s:property value="%{getText('app.xtwh.t00303.zcdzl')}" /></th>
		      <th twidth="150"><s:property value="%{getText('app.upddate')}" /></th>
		      <th twidth="80"><s:property value="%{getText('app.czr')}" /></th>
		      <th twidth="150"><s:property value="%{getText('app.note')}" /></th>
		    </tr>
		  </thead>
		  <tbody>
		    <s:iterator id="HbInitEntity" value="hbInitList" status="index">
		      <tr>
		        <td align="center"><input name="rdoUnite" id="rdoUnite" type="radio" class="radio" value='<s:property value="lfid"/>'/></td>
		        <td><s:property value="xqnm" /></td>
		        <td><s:property value="szqy" /></td>
		        <td align="center"><s:if test='%{ywdt}'>&nbsp;<s:property value="%{getText('app.global.checkbox.true')}" />&nbsp;</s:if><s:else>&nbsp;<s:property value="%{getText('app.global.checkbox.false')}" />&nbsp;</s:else></td>
		        <td align="right"><s:property value="zlc" /></td>
		        <td><s:property value="fwtdzl" /></td>
		        <td align="center"><s:if test="null!=upddate"><s:text name="app.global.format.datetime"><s:param value="upddate" /></s:text></s:if></td>
		        <td><s:property value="czr" /></td>
		        <td><s:property value="note"/></td>
		      </tr>
		    </s:iterator>
		  </tbody>
		</table>
	<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
	  <div id="infoTreeDIV"></div>
	</div>
	</form>
	</div>
	<div class="divbottom">
	<a href="javascript:void(0)" onClick="AppSubmit();"><img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.xtwh.t00303.unite')"/>" alt="<s:property value="getText('app.xtwh.t00303.unite')"/>"/><s:property value="getText('app.xtwh.t00303.unite')"/></a>
	<a href="VIEWT00303.action"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
	</div>
	</div>
	</div>
</td>
  </tr>
</table>
</body>
</html>