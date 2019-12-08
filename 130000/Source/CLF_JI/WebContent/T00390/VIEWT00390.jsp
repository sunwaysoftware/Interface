<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<link rel="stylesheet" type="text/css" href="../css/screen.css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>


<script type="text/javascript" src="../scripts/T00390/VIEWT00390.js"></script>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
	<tr>
		<td align="left" valign="top">
		<div id="tabs" class="tabs" style="display: none">
			<ul>
				<li><a href="#DY"><span><s:property
					value="%{getText('app.jsrdcl.qstzd.title')}" /></span></a></li>
				<li><a href="#CL"><span><s:property
					value="%{getText('app.jsrdcl.rdcl.title')}" /></span></a></li>
			</ul>
			<div id="DY">
				<iframe id="IDY" width="100%" height="470px" frameborder="0" scrolling="no"></iframe>
			</div>
			<div id="CL">
				<iframe id="ICL" width="100%" height="470px" frameborder="0" scrolling="no"></iframe>
			</div>
		</div>
		</td>
	</tr>
</table>
</body>
</html>