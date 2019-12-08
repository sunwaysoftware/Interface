<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="refresh" content="3;url=<s:url includeParams='all'/> " />
<title></title>
</head>
<body>
<table align="center" style="height: 100%" id="tabMain">
	<tr style="height: 45%">
		<td></td>
	</tr>
	<tr>
		<td>
<!-- 			
		<div id="ProgressBarSide"
			style="width: 300px; color: Silver; border-width: 1px; border-style: Solid;">
		<div id="ProgressBar" align="center"
			style="height: 20px; width: <s:property value="processCent" default="0" />%; background-color: #316AC5;"></div>
		</div>
 -->
		
		<div id="Msg2" style="height: 16px;"><font
			face="Verdana, Arial, Helvetica" size="2" color="#ea9b02"><b><s:property
			value="processMsg" /></b>(<s:property value="processCent" default="0" />%)</font></div>
		<div style="vertical-align: middle;"><img src="../images/ProgressBar.gif"/></div>
		<div id="Msg1" style="height: 16px;"><font
			face="Verdana, Arial, Helvetica" size="2" color="#ea9b02"><b>正在处理数据，请稍等...</b></font></div>			
		</td>
	</tr>
	<tr style="height: 50%">
		<td></td>
	</tr>
</table>
</body>
</html>