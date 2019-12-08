<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/T00004/EDITT00004.js"></script>
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
	
    <s:property value="%{getText('app.xtwh.t00004.title')}" />
<hr/>

<form id="editForm" action="EDITT00004.action" method="post">
	<input type="hidden" name="ACT" value="<s:property value="ACT"/>" />
	<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00003Bean.upddate"/></s:text>" />
	 
	<s:if test='%{ACT!="C"}'>
		<input name="txtRIGHTID" type="hidden" id="txtRIGHTID" value="<s:property value="t00004Dao.rightid" />" />
	</s:if>
	
	<s:property value="%{getText('app.xtwh.t00004.rightid')}" />
		<input name="txtRIGHTID" id="txtRIGHTID" type="text" 
		value="<s:property value="t00004Dao.rightid" />" <s:if test='%{ACT!="C"}'>disabled="disabled"</s:if> />
	<br/>
	<s:property value="%{getText('app.xtwh.t00004.rightnm')}" />
		<input name="txtRIGHTNM" id="txtRIGHTNM" type="text" 
		value="<s:property value="t00004Dao.rightnm" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
		
	<s:property value="%{getText('app.note')}" />
		<input name="txtNOTE" id="txtNOTE" type="text" 
		value="<s:property value="t00004Dao.note" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
		 
	<script type="text/javascript">
	getUser('<s:property value="t00004Dao.rightid" />','<s:property value="ACT"/>');	
	getRole('<s:property value="t00004Dao.rightid" />','<s:property value="ACT"/>');
	</script>			
	<div id="divUser"></div>
	<div id="divRole"></div>
	 
	<hr/>
	
	<s:if test='%{ACT=="U"}'>
		<a href="javascript:AppSubmit();">
		<img src="../images/ico/Edit.gif" width="16" height="16" title="更新后返回列表" alt="更新后返回列表" />更新后返回列表</a>
	</s:if> 
	<s:elseif test='%{ACT=="C"}'>
		<a href="javascript:AppSubmit();">
		<img src="../images/ico/Update.gif" width="16" height="16" title="保存后返回到列表" alt="保存后返回到列表" />保存后返回到列表</a>
	</s:elseif> 
	<s:elseif test='%{ACT=="D"}'>
		<a href="javascript:AppSubmit();">
		<img src="../images/ico/Delete.gif" width="16" height="16" title="删除后返回列表" alt="删除后返回列表" />删除后返回列表</a>
	</s:elseif> 
	<a href="VIEWT00003.action"><img src="../images/ico/Cancel.gif" width="16" height="16" title="返回到明细列表" alt="返回到明细列表" />返回到明细列表</a>
</form>
    </td>
  </tr>
</table>
</body>
</html>
