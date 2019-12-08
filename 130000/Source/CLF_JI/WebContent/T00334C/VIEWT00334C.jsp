<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:property value="%{getText('app.global.title')}" /></title>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/T00334C/VIEWT00334C.js"></script>
</head>
<body>
<table border="1">
	<thead>
		<tr>
			<th><s:property value="%{getText('app.xtwh.t00001.rootnm')}" /></th>
			<th><s:property value="%{getText('app.xtwh.t00001.infonm')}" /></th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="tabList">
			<tr>
				<td><s:property value="rootnm" /></td>
				<td><s:property value="infonm" /></td>
			</tr>
		</s:iterator>
	</tbody>
</table>
</body>
</html>