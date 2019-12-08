<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>通过的检验标准</title>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />
</head>
<body>
<table width="600" border="0" cellpadding="2" cellspacing="1"
	bgcolor="#999999" align="center">
	<tr>
		<th style="background-color: #E0E0E0"><s:property value="%{getText('app.xtwh.t00001.pssd')}" /></th>
		<th style="background-color: #E0E0E0"><s:property value="%{getText('app.xtwh.t00054.bzbm')}" /></th>
		<th style="background-color: #E0E0E0"><s:property value="%{getText('app.xtwh.t00054.bzmc')}" /></th>
		<th style="background-color: #E0E0E0"><s:property value="%{getText('app.xtwh.t00054.jzqs')}" /></th>
		<th style="background-color: #E0E0E0"><s:property value="%{getText('app.xtwh.t00054.lsxs')}" /></th>
		<th style="background-color: #E0E0E0"><s:property value="%{getText('app.xtwh.t00054.jgxgc')}" /></th>
		<th style="background-color: #E0E0E0"><s:property value="%{getText('app.note')}" /></th>
	</tr>
	<s:iterator id="v00054Entity" value="v00054List" status="index">
		<tr>
			<td style="background-color: #FFFFFF"><s:property value="cd00002Pssd" /></td>
			<td style="background-color: #FFFFFF"><s:property value="bzbm" /></td>
			<td style="background-color: #FFFFFF"><s:property value="bzmc" /></td>
			<td style="background-color: #FFFFFF"><s:property value="jzqsMin" />~<s:property value="jzqsMax" /></td>
			<td style="background-color: #FFFFFF"><s:property value="lsxsMin" />~<s:property value="lsxsMax" /></td>
			<td style="background-color: #FFFFFF"><s:property value="jgxgcMin" />~<s:property value="jgxgcMax" /></td>
		    <td style="background-color: #FFFFFF"><s:property value="note"/></td>
		</tr>
	</s:iterator>
</table>
</body>
</html>
