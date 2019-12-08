<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/T00305/VIEWT00305.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
	<div id="tt" class="easyui-tabs" style="width:500px;height:250px;">
		<div title="<s:property value="%{getText('app.xtwh.t00305w.title')}" />" style="padding:20px;">
		<iframe id="IWCZ" width="100%" height="540px" frameborder="0" scrolling="no"></iframe>
		</div>
		<div title="<s:property value="%{getText('app.xtwh.t00305y.title')}" />" style="padding:20px;">
		<iframe id="IYCZ" width="100%" height="540px" frameborder="0" scrolling="no"></iframe>
		</div>
	</div>    
    </td>
  </tr>
</table>
</body>
</html>
