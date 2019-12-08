<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>

<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/SS30000/SS30001Y.js"></script>
<script type="text/javascript" src="../scripts/SS30000/VIEWSS30001Y.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />

<style type="text/css">
<!--

-->
</style>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
    <div id="tabs" class="ui-widget-content">
        <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
            <li><a href="#INFO"><span><s:property value="%{getText('app.psjgcl.notice.title3')}" /></span></a></li>                    
        </ul>
		<div id="INFO" class="divConect">
    
    <form id="findForm" action="#" method="post">
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
	  <tr>
          <td>&nbsp;<s:property value="getText('app.sjcj.t00301.fcslh')"/></td>
          <td>&nbsp;<input type="text" class="txtFCSLH" id="txtFCSLHFind" name="txtFCSLHFind"/></td>
      </tr>
	</table>
	</div>
      <input name="btnSearch" type="button" id="btnSearch" class="button" value="<s:property value="getText('app.button.search')"/>" /><input name="btnConditions" type="button" title="显示搜索条件" id="btnConditions" class="button" value="↓" />
	  <s:actionerror/><s:actionmessage/>
      <%@ include file="../T00041/VIEWT00041.jsp" %>
    </form>
    
    <div class="divbottom">
    <div>
	  <s:property value="getText('app.psjgcl.notice.qx')"/>
	    <input type="text" id="txtQIXIAN" name="txtQIXIAN" class="txtNumber" value="1" /><s:property value="getText('app.psjgcl.notice.t')"/>
	  <a href="javascript:void(0)" id="print"><img src="../images/ico/print.gif" width="16" height="16" /><s:property value="getText('app.psjgcl.notice.print')"/></a>
    </div>
    </div>
    </div>
    </div>
    </td>
  </tr>
</table>
</body>
</html>
