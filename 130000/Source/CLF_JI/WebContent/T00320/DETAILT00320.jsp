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
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.szqy')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.szqy" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.fczh')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.fczh" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.zcdzl')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.zcdzl" /></td>
  </tr>
  <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.zh')" /></td>
  	<td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.zh" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.dyh')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.dyh" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.fh')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.fh" /></td>
  </tr>
  <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.xqnm')" /></td>
  	<td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.xqnm" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.sffs')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:if test="%{v00320Bean.sffs == 0}">
    									否
    								  </s:if>
    								  <s:else>
    								  	是
    								  </s:else></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.fwlx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.fwlx" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.zlc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.zlc" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.szlc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.szlc" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.jcnf')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.jcnf" /></td>
  </tr>  
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.jzjg')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.jzjg" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.zhxz')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.zhxz" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.jzmj')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.double"><s:param value="v00320Bean.jzmj" /></s:text></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.hdjg')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.moneyZh"><s:param value="v00320Bean.hdjg" /></s:text></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.jysj')" /></td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00320.pgjg')" /></td>
  </tr>
  <s:if test='%{v00320Bean.outList.size > 0}'>
  <s:iterator  value="v00320Bean.outList" status="index"> 
  <tr>
	<td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.date"><s:param value="jysj" /></s:text></td>
	<td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.moneyZh"><s:param value="pgjg" /></s:text></td>  
  </tr>
  </s:iterator>
  </s:if>
</table>
</body>
</html>