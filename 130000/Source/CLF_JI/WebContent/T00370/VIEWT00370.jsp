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

<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../scripts/T00370/VIEWT00370.js"></script>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
	<div class="ui-widget-content">
	<div class="datagrid-title">
		<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00370.title')}" /></span>
	</div>
	<div id="INFO" class="divConect">
			<div>
		    	<table width="800" border="0" cellpadding="2" cellspacing="0">
		          <thead>
		          	<tr>
		          		<td><s:property value="%{getText('app.sjcj.t12003.fcid')}" />:<s:property value="txtFCID" /></td>
		          	</tr>
		          </thead>
		        </table>
	        </div>
	        <div id="GPG">
	            <iframe id="IGPG" width="100%" height="600px" frameborder="0" scrolling="no" FCID="<s:property value="txtFCID" />" ></iframe>
	        </div>
        </div>
	</div>        

	</td>
  </tr>
</table>
</body>
</html>