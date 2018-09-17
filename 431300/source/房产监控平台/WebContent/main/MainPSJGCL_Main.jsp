<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/template.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title><s:property value="%{getText('app.global.title')}" /></title>
<!-- InstanceEndEditable -->
<script type="text/javascript" src="../scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<!-- InstanceBeginEditable name="head" -->
<style type="text/css">
body {
	background-color: #FFFFFF;
}
</style>
<!-- InstanceEndEditable -->
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	<!-- InstanceBeginEditable name="body" -->
        <div style="padding-left:30px;padding-right:30px">
    <fieldset>
		<legend>功能导航</legend>
                <h3><img src="../images/ico/cj.gif" width="24" height="24" style="padding-right:5px"/><s:property value="getText('app.psjgcl.ss00000.title')" /></h3>
                <blockquote>
			    <s:if test="%{userRole.contains('00000019')}">
			    <img src="../images/ico/xx.gif" alt="" width="16" height="16" style="padding-right:5px"/><a href="../SS30000/SS30000.jsp" target="mainFrame" title="<s:property value="getText('app.psjgcl.ss30000.title')" />"><s:property value="getText('app.psjgcl.ss30000.title')" /></a>
			    </s:if>
                </blockquote>
                <h3><img src="../images/ico/cj.gif" width="24" height="24" style="padding-right:5px"/><s:property value="getText('app.psjgcl.notice.title')" /></h3>
                <blockquote>
			    <s:if test="%{userRole.contains('00000022')}">
			    <img src="../images/ico/xx.gif" alt="" width="16" height="16" style="padding-right:5px"/><a href="../psjgcl/VIEWNSSC.action" target="mainFrame" title="<s:property value="getText('app.psjgcl.notice.title3')" />"><s:property value="getText('app.psjgcl.notice.title3')" /></a>
			    </s:if>
                </blockquote>
	</fieldset>
	</div>
    <!-- InstanceEndEditable --></td>
  </tr>
</table>
</body>
<!-- InstanceEnd --></html>
