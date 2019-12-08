<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>

<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/SS30000/SS30001Y.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />


<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});
</script>
<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
}
-->
</style>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">

		<form id="editForm" action="EXECSS30002.action" method="post">
        <div id="apDiv1">
        <table width="300" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;<s:property value="getText('app.psjgcl.t00041.swid')"/></td>
            <td>&nbsp;<input type="text" class="txtID" id="txtSWIDFind" name="txtSWIDFind" value="<s:property value="txtSWIDFind"/>" /></td>
          </tr>
          <tr>
            <td>&nbsp;<s:property value="getText('app.psjgcl.t00041.nsrmc')"/></td>
            <td>&nbsp;<input type="text" class="txtNSRMC" id="txtNSRMCFind" name="txtNSRMCFind" value="<s:property value="txtNSRMCFind"/>" /></td>
          </tr>
        </table>
        </div>
		<input name="btnSearch" type="button" id="btnSearch" class="button" value="<s:property value="getText('app.button.search')"/>" /><input name="btnConditions" type="button" title="显示搜索条件" id="btnConditions" class="button" value="↓" />
		<input type="hidden" id="hidFlag" name="hidFlag" />
		<%@ include file="../T00041/VIEWT00041.jsp" %>
		</form>
		
		<div class="divbottom">
			<a href="javascript:document.getElementById('hidFlag').value='1';AppSubmit();">
				<img src="../images/ico/Add.gif" width="16" height="16"/><s:property value="getText('app.psjgcl.ss00000.button.rSs')"/>
			</a>
			<a href="javascript:document.getElementById('hidFlag').value='2';AppSubmit();">
				<img src="../images/ico/Add.gif" width="16" height="16"/><s:property value="getText('app.psjgcl.ss00000.button.rSsAll')"/>
			</a>
		</div>
</td>
  </tr>
</table>
</body>
</html>