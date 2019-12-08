<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<table width="400" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
   <tr>
    	<td width="150">
     		税种名称
    	</td>
    	<td>
     		税额
    	</td>
  </tr>
   <s:iterator value="resList">
   <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="sz"/></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="se"/></td>
  </tr>
  </s:iterator> 
  <tr>
    	<td width="150">
     		<s:property value="%{getText('app.xtwh.t00370.fpid')}" />
    	</td>
    	<td>
     		<s:property value="txtFPID" />
    	</td>
  </tr>
  <tr>
    	<td width="150">
     		<s:property value="%{getText('app.xtwh.t00370.spid')}" />
    	</td>
    	<td>
     		<s:property value="txtSPID" />
    	</td>
  </tr>
  <tr>
    	<td width="150">
     		<s:property value="%{getText('app.xtwh.t00370.dfspid')}" />
    	</td>
    	<td>
     		<s:property value="txtDFSPID" />
    	</td>
  </tr>
</table>
</body>
</html>