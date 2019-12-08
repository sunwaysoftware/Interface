<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/T00305/DETAILT00305Y.js"></script>
</head>
<body>
	<div id="tt" class="easyui-tabs" style="height:700px;">
		<div title="详细" style="padding:0px;">
		<iframe id="IXX" height="650px" frameborder="0" scrolling="no" FCID='<s:property value="v00305Bean.cd00302Fcid" />'></iframe>
		</div>
		<div title="状态" style="padding:0px;">
		<iframe id="IZT" height="250px" frameborder="0" scrolling="no" FCID='<s:property value="v00305Bean.cd00302Fcid" />'></iframe>
		</div>
	</div>
</body>
</html>
