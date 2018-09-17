<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<!-- InstanceBegin template="/Templates/templateLeft.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title><s:property value="%{getText('app.menu')}" /></title>
<!-- InstanceEndEditable -->
<!--[if ie]>
<style type="text/css" media="screen">
	.menu a {zoom:1;}
</style>
<![endif]-->
<link href="../css/screen.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../scripts/togglemenu.js"></script>
<!-- InstanceBeginEditable name="head" -->
<style type="text/css">
<!--
body {
	background-color: #eaedf2;
}
-->
</style><!-- InstanceEndEditable -->
</head>
<body>
<!-- InstanceBeginEditable name="body" -->
<ul class="menu">
		<li><a href="#" class="rootMenu">数据查询</a>
	<ul>
		<s:if test="%{userRole.contains('00000024')}">
		<li><a href="../sjcx/VIEWV003025.action" target="mainFrame" title="数据查询"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle">数据查询</a></li>
		</s:if>
	</ul>
	</li>
<%--		<li><a href="#" class="rootMenu">历史数据查询</a>--%>
<%--	<ul>--%>
<%--		<s:if test="%{userRole.contains('00000025')}">--%>
<%--		<li><a href="../sjcx/VIEWV00302A.action" target="mainFrame" title="数据变更查询"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle">数据变更查询</a></li>--%>
<%--		</s:if>--%>
<%--	</ul>--%>
<%--	</li>--%>
</ul>
<!-- InstanceEndEditable -->
</body>
<!-- InstanceEnd -->
</html>
