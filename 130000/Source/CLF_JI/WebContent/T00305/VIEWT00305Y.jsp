<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/T00305/VIEWT00305Y.js"></script>


<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});
</script>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
      <form id="editForm" action="EXECT00305Y.action" method="post">
      <input type="hidden" name="chkTrue" id="chkTrue" value="<s:property value="%{getText('app.global.checkbox.true')}" />"/>
      <input type="hidden" name="chkFalse" id="chkFalse" value="<s:property value="%{getText('app.global.checkbox.false')}" />"/>
      <div id="apDiv1">
      <table width="300" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;<s:property value="getText('app.sjcj.t00301.swid')"/></td>
            <td>&nbsp;<input type="text" class="txtID" id="txtSWIDFind" name="txtSWIDFind" value="<s:property value="txtSWIDFind"/>" /></td>
          </tr>
          <tr>
            <td>&nbsp;<s:property value="getText('app.sjcj.t00301.nsrmc')"/></td>
            <td>&nbsp;<input type="text" class="txtNSRMC" id="txtNSRMCFind" name="txtNSRMCFind" value="<s:property value="txtNSRMCFind"/>" /></td>
          </tr>
          <tr>
            <td>&nbsp;<s:property value="getText('app.sjcx.v003015.sczt')"/></td>
            <td>&nbsp;<select name="ddlSCZTFind" id="ddlSCZTFind">
        	  <jsp:include page="../common/status.jsp"></jsp:include>
      </select></td>
          </tr>
        </table>
      </div>
      <input name="btnSearch" type="button" id="btnSearch" class="button" value="<s:property value="getText('app.button.search')"/>" /><input name="btnConditions" type="button" title="显示搜索条件" id="btnConditions" class="button" value="↓" />
		状态符号说明：
		<jsp:include page="../common/statusImg.jsp"></jsp:include>
		<input type="hidden" id="hidFlag" name="hidFlag" />
		<table id="scroll1" class="scroll" cellpadding="0" cellspacing="0" style="width:100%;height:350px">
		    <thead>
				<tr>
					<th twidth="50"><input type="checkbox" name="chkSelAll" id="chkSelAll" class="rootCheck radio" value="true"/></th>
					<th twidth="50">No</th>
					<th twidth="150"><s:property value="%{getText('app.sjcj.t00302.fcid')}" /></th>
					<th twidth="150"><s:property value="%{getText('app.sjcj.t00301.swid')}" /></th>
					<th twidth="100"><s:property value="%{getText('app.sjcj.t00301.nsrmc')}" /></th>
					<th twidth="80"><s:property value="%{getText('app.sjcx.v003015.sczt')}" /></th>
					<th twidth="200"><s:property value="%{getText('app.xtwh.t00305.scdycs')}" /></th>
				</tr>
		    </thead>
			<tbody id="divShow">
				<tr id="rowtemplate">
					<td id="chk"></td>
				    <td align="center" id="no"></td>
				    <td id="fcid"></td>
					<td id="swid"></td>
					<td id="nsrmc"></td>
					<td align="center" id="sczt"></td>
					<td align="right" id="scdycs"></td>
				</tr>
			</tbody>
		</table>
		</form>
		
		<div>
			<a href="javascript:void(0)" id="rTjLink">
				<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.xtwh.t00305.button.rTj')"/>" alt="<s:property value="getText('app.xtwh.t00305.button.rTj')"/>"/><s:property value="getText('app.xtwh.t00305.button.rTj')"/>
			</a>
			<a href="javascript:void(0)" onClick="document.getElementById('hidFlag').value='2';AppSubmit();">
				<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.xtwh.t00305.button.rTjAll')"/>" alt="<s:property value="getText('app.xtwh.t00305.button.rTjAll')"/>"/><s:property value="getText('app.xtwh.t00305.button.rTjAll')"/>
			</a>
		</div>
</td>
  </tr>
</table>
</body>
</html>