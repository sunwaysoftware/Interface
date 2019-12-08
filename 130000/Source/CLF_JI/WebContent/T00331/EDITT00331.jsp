<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
	<style>
		.toolbar{
			height:30px;
			padding:5px;
		}
	</style>
	<script>
		function enable(){
			$('a.easyui-linkbutton').linkbutton('enable');
		}
		function disable(){
			$('a.easyui-linkbutton').linkbutton('disable');
		}
		function changetext(){
			$('#add').linkbutton({text:'new add'});
		}
		
	</script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/T00331/EDITT00331.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
      <div class="ui-widget-content">
		<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.sjpg.pg30000g.title')}" /></span>
		</div>
		<div id="INFO" class="divConect">
	    	<table width="500" border="0" cellpadding="2" cellspacing="0">
	          <tr>
	            <td><s:property value="%{getText('app.sjcj.t00301.swid')}" />：<a href=javascript:Show('../sjcj/DETAILT00301.action?SWID=<s:property value="t00331Bean.cd00301Swid" />',300,420,'登记详细信息'); title='点击查看详细信息' ><s:property value="t00331Bean.zjhm" /></a></td>
	            <td><s:property value="%{getText('app.sjcj.t00301.nsrmc')}" />：<s:property value="t00331Bean.nsrmc" /></td>
	            <td><s:property value="%{getText('app.sjpg.t00331.fcid')}" />:<a href=javascript:Show('../xtwh/DETAILT00305Y.action?FCID=<s:property value="t00331Bean.cd00302Fcid" />',300,420,'详细信息'); title='点击查看详细信息' ><s:property value="t00331Bean.cd00302Fcid" /></a></td>
	          </tr>
	          <tr>
	            <td></td>
	            <td></td>
	            <td></td>
	          </tr>
	        </table>
	        <div id="PG" style="display:none">
	            <iframe id="IPG" width="100%" height="350" frameborder="0" scrolling="auto" FCID="<s:property value="t00331Bean.cd00302Fcid" />" PSSD="<s:property value="t00331Bean.cd00002Pssdy" />"></iframe>
	        </div>	
	        <div id="GPG" >
	            <iframe id="IGPG" width="900" height="200" frameborder="0" scrolling="no" FCID="<s:property value="t00331Bean.cd00302Fcid" />" PSSD="<s:property value="t00331Bean.cd00002Pssdy" />" SWID="<s:property value="t00331Bean.cd00301Swid" />"></iframe>
	        </div>
        </div>
        <div class="divbottom">
        <a href="VIEWPG30001G.action">
        <img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
		</div>
</div>        
</td>
  </tr>
</table>
</body>
</html>