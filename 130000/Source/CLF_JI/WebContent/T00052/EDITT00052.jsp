<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/T00052/EDITT00052.js"></script>
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
	
	<div class="ui-widget-content">
	<div class="datagrid-title">
		<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00052.title')}" /></span>
	</div>
<table width="100%" border="0" cellspacing="2" cellpadding="0">
	 <tr>
	     <td width="300">	    	        
	                     当前税收管辖：<a href="javascript:void(0)" onclick="GetData(<s:property value="SSGXId"/>)"><s:property value="SSGXNm"/></a>
	        <fieldset>
			<legend>下级税收管辖</legend>
			<div id="ddlQTXZ" style="width:300px;height:400px;overflow:auto;border: 0px inset #FFFFFF;">
				<ul id="ssgxTree"></ul>
			</div>
			</fieldset>
		</td>
		<td>	
			<form id="editForm" action="EDITT00052.action" method="post">
			<input type="hidden" name="SSGXId" id="SSGXId" value="<s:property value="SSGXId"/>" />
				<table width="100" border="0" cellspacing="0" cellpadding="0">
			      <tr>
			        <td>
			    		<div id="ddlSZQY" style="width:200px;height:400px;overflow:auto;border: 2px inset #FFFFFF;">
							<s:iterator value="szqyList" status="index" id="szqyEntity">
			                       <span class="qtxz"><s:property value="szqy"/> <a href="javascript:;" SZQY="<s:property value="cd00001Szqy"/>" onclick="szqyClick(this);">[删]</a></span>
			                   </s:iterator>
				        </div>
			        </td>
			        <td align="left"><input type="button" class="button" id="btnAddSZQY" name="btnAddSZQY" value="添加"/>
			    		<input type="hidden" id="hidSZQY" name="hidSZQY" value="<s:iterator value="szqyList" status="index" id="szqyEntity"><s:property value='cd00001Szqy'/>,</s:iterator>" />
			       </td>
			      </tr>              
			    </table>
			</form>
		</td>
	 </tr>
	</table> 
	<div class="divbottom">
	<a href="javascript:void(0)" id="btnSave" name="btnSave" ><img src="../images/ico/Update.gif" width="16" height="16"/><s:property value="getText('app.button.set')"/></a>
	</div>

</div>
<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
    <div id="infoTreeDIV"></div>	
</div>
    </td>
  </tr>
</table>
</body>
</html>
