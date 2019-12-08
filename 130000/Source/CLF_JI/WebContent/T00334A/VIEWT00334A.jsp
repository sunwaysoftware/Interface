<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="../scripts/T00334A/VIEWT00334A.js"></script>



</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td height="300" align="left" valign="top">
	
		<div id="tabs" class="ui-widget-content">
        <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
            <li><a href="#INFO"><span><s:property value="%{getText('app.sjpg.t00334a.title')}" /></span></a></li>                    
        </ul>
		<div id="INFO" class="divConect">
		<table id="scroll1" class="scroll" cellpadding="0" cellspacing="0" style="width:100%;height:250px">
			<thead>
				<tr>
					<th twidth="150"><s:property value="%{getText('app.sjpg.t00334a.fcid')}" /></th>
					<th twidth="150"><s:property value="%{getText('app.sjpg.t00334a.slid')}" /></th>
					<th twidth="150"><s:property value="%{getText('app.sjpg.t00334a.pssd')}" /></th>
					<th twidth="100"><s:property value="%{getText('app.sjpg.t00334a.qtxznm')}" /></th>
					<th twidth="120"><s:property value="%{getText('app.sjpg.t00334a.qtxz')}" /></th>
					<th twidth="120"><s:property value="%{getText('app.sjpg.t00334a.slqtxz')}" /></th>					
					<th twidth="180"><s:property value="%{getText('app.czr')}" /></th>
					<th twidth="150"><s:property value="%{getText('app.upddate')}" /></th>
				</tr>
			</thead>
			<tbody>
			<s:iterator value="tabList">
			<tr>
				<td><s:property value="cd00302Fcid" /></td>
				<td><s:property value="cdSlid" /></td>
				<td><s:property value="cd00002Pssd" /></td>
				<td><s:property value="qtxzNm" /></td>
				<td align="right"><s:text name="app.global.format.double"><s:param value="cd00053Qtxz" /></s:text></td>
				<td align="right"><s:text name="app.global.format.double"><s:param value="cd00053Slqtxz" /></s:text></td>				
				<td><s:property value="czr" /></td>
				<td><s:text name="app.global.format.datetime"><s:param value="upddate" /></s:text></td>
			</tr>
			</s:iterator>
			</tbody>
		</table>
		</div>
</div> 
</td>
  </tr>
</table>
</body>
</html>