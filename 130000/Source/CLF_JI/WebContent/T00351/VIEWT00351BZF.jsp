<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="../scripts/T00351/VIEWT00351BZF.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<link type="text/css" rel="stylesheet" href="../css/jquery.autocomplete.css" />



<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});
</script>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0"
	class="table1">
	<tr>
		<td align="left" valign="top">
		<div id="tabs"
			class="ui-widget-content">
		<ul
			class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
			<li><a href="#INFO"><span><s:property
				value="%{getText('app.xtwh.t00351.scbzf')}" /></span></a></li>
		</ul>
		<div id="INFO" class="divConect">
		<form id="findForm" action="#" method="post">
		<input type="hidden" name="hidSelect" id="hidSelect" />
		<table width="400" border="0" cellspacing="2" cellpadding="0">
			 <tr>
			    <td>&nbsp;<s:property value="getText('app.xtwh.info.szqy')"/></td>
			    <td>&nbsp;<sw:szqy items="szqyList" name="ddlSZQYFind"id="ddlSZQYFind" classid="txtfocus" display="全部"/></td>
			  </tr>
			  <tr>
			    <td>&nbsp;<s:property value="%{getText('app.xtwh.t00303.xqmhcx')}" /></td>
			    <td>&nbsp;<input name="txtXQCX"  id="txtXQCX" type="text" /></td>
			  </tr>
			  <tr>
			    <td>&nbsp;<s:property value="getText('app.xtwh.t00303.xqmc')"/></td>
			    <td>&nbsp;<span class="txtInfonm"><input name="txtXQTIP" id="txtXQTIP" type="text" readonly="readonly"/><span id="spXQDM"></span></span>
			    <input type="hidden" id="txtXQFind" name="txtXQFind" value="<s:property value="txtXQFind" />"/></td>
			  </tr>
<!--			  <tr>-->
<!--			    <td>&nbsp;<s:property	value="%{getText('app.xtwh.info.fwlx')}" /></td>-->
<!--			    <td>&nbsp;<span class="txtInfonm"><input name="txtFWLXTIP" id="txtFWLXTIP" type="text" readonly="readonly" /><span id="spFWLX"></span></span>-->
<!--			    <input type="hidden" id="txtFWLXFind" name="txtFWLXFind" value="<s:property value="txtFWLXFind" />"/></td>-->
<!--			  </tr>-->
		</table>
		<input name="btnScbzf" type="button" id="btnScbzf" class="button" value="<s:property value="getText('app.xtwh.t00351.scbzf.f')"/>" />
		<input name="btnDrbzf" type="button" id="btnDrbzf" class="button" value="<s:property value="getText('app.xtwh.t00351.scbzf.t')"/>" />
		<input name="btnSearch" type="button" id="btnSearch" class="button" value="<s:property value="getText('app.button.search')"/>" />
		</form>
		<table id="scroll1" class="scroll" cellpadding="0" cellspacing="0"
			style="width: 100%; height: 350px">
			<thead>
				<tr>
					<th twidth="50">No</th>
					<th twidth="50">操作</th>
					<th twidth="150"><s:property value="%{getText('app.xtwh.t00351.slid')}" /></th>
					<th twidth="100"><s:property value="%{getText('app.xtwh.info.szqy')}" /></th>
					<th twidth="100"><s:property value="%{getText('app.xtwh.t00303.xqmc')}" /></th>	
					<th twidth="200"><s:property value="%{getText('app.xtwh.t00303.zcdzl')}" /></th>						
					<th twidth="120"><s:property value="%{getText('app.xtwh.info.jzjg')}" /></th>						
					<th twidth="150"><s:property value="%{getText('app.xtwh.info.fwlx')}" /></th>
					<th twidth="80"><s:property value="%{getText('app.xtwh.t00303.ywdt')}" /></th>										
					<th twidth="80"><s:property value="%{getText('app.xtwh.t00351.szlc')}" /></th>	
					<!--  		
					<th twidth="80"><s:property value="%{getText('app.xtwh.info.fwcx')}" /></th>
					<th twidth="80"><s:property value="%{getText('app.xtwh.info.cgzk')}" /></th>
					-->					
					<th twidth="100"><s:property value="%{getText('app.xtwh.info.jylx')}" /></th>	
					<th twidth="150"><s:property value="%{getText('app.upddate')}" /></th>
					<th twidth="100"><s:property value="%{getText('app.czr')}" /></th>
					<th twidth="150"><s:property value="%{getText('app.note')}" /></th>
				</tr>
			</thead>
			<tbody id="divShow">
				<tr id="rowtemplate">
					<td id="no" align="center"></td>
					<td id="edit" align="center"></td>
					<td id="slid" align="center"></td>
					<td id="szqy"></td>
					<td id="xqnm"></td>						
					<td id="zldz"></td>						
					<td id="jzjg"></td>						
					<td id="fwlx"></td>
					<td id="ywdt" align="center"></td>									
					<td align="right" id="szlc"></td>
					<!--  		
					<td id="fwcx"></td>
					<td id="cgzk"></td>	
					-->								
					<td id="jylx"></td>		
					<td id="upddate" align="center"></td>
					<td id="czr"></td>
					<td id="note"></td>
				</tr>
			</tbody>
		</table>
		<div class="divbottom">
		<div>
			<a href="VIEWT00351.action"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
		</div>
		</div>
		</div>
		</div>
		</td>
	</tr>
</table>
<input type="hidden" name="chkT" id="chkT" value="<s:property value="getText('app.global.checkbox.true')"/>">
<input type="hidden" name="chkF" id="chkF" value="<s:property value="getText('app.global.checkbox.false')"/>">
<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
	<div id="infoTreeDIV"></div>
</div>
</body>

</html>
