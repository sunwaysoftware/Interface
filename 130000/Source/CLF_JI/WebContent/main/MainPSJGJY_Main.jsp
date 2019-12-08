<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<style type="text/css">
body {
	background-color: #FFFFFF;
}
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
            <div style="padding-left:30px;padding-right:30px">
    <fieldset>
		<legend>功能导航</legend>
			    <h3><img src="../images/ico/cj.gif" width="24" height="24" style="padding-right:5px"/>市场法</h3>
                <s:if test="%{userRole.contains('00000016')}">
                <blockquote>
			    <img src="../images/ico/xx.gif" alt="" width="16" height="16" style="padding-right:5px"/><a href="../psjgjy/VIEWSCPSJGJY.action" target="mainFrame"><s:property value="%{getText('app.psjgjy.sc.title')}" /></a>&nbsp;&nbsp;
				</blockquote>
				</s:if>
	</fieldset>
	</div>
    </td>
  </tr>
</table>
</body>
</html>
