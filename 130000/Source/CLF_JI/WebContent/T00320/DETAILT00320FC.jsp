<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<table width="440" border="0" cellpadding="1" cellspacing="1">
  <tr>
  	<td colspan="4" align="center">
  		<span class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.fczh')" /></span>
  		<s:property value="v00320Bean.fczh" />
  		<hr />
  	</td>
  </tr>
  <tr>
    <td width="68" height="18" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.szqy')" /></td>
    <td width="150" height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.szqy" /></td>
    <td width="69" bgcolor="#FFFFFF" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.xqnm')" /></td>
    <td width="117" bgcolor="#FFFFFF">&nbsp;<s:property value="v00320Bean.xqnm" /></td>
  </tr>
  <tr>
    <td height="18" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.zcdzl')" /></td>
    <td height="18" colspan="3" bgcolor="#FFFFFF"><s:property value="v00320Bean.zcdzl" />&nbsp;&nbsp;<s:property value="getText('app.sjcj.t00320.zh')" />
    <s:property value="v00320Bean.zh" /></td>
  </tr>
  <tr>
    <td height="18" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.dyh')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.dyh" /></td>
    <td bgcolor="#FFFFFF" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.fh')" /></td>
    <td bgcolor="#FFFFFF">&nbsp;<s:property value="v00320Bean.fh" /></td>
  </tr>
  <tr>
    <td height="18" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.zlc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.zlc" /></td>
    <td bgcolor="#FFFFFF" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.szlc')" /></td>
    <td bgcolor="#FFFFFF">&nbsp;<s:property value="v00320Bean.szlc" /></td>
  </tr>
  <tr>
    <td height="18" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.sffs')" /></td>
<td height="18" bgcolor="#FFFFFF"><s:if test="%{v00320Bean.sffs == 0}">
    									否
    								  </s:if>
    								  <s:else>
    								  	是
    								  </s:else></td>
<td bgcolor="#FFFFFF" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.fwlx')" /></td>
<td bgcolor="#FFFFFF">&nbsp;<s:property value="v00320Bean.fwlx" /></td>
  </tr>
  <tr>
    <td height="18" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.jcnf')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.jcnf" /></td>
    <td bgcolor="#FFFFFF" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.jzjg')" /></td>
    <td bgcolor="#FFFFFF"><s:property value="v00320Bean.jzjg" /></td>
  </tr>
  <tr>
    <td height="18" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.fwcx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.fwcx" /></td>
    <td bgcolor="#FFFFFF" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.dywz')" /></td>
    <td bgcolor="#FFFFFF">&nbsp;<s:property value="v00320Bean.dywz" /></td>
  </tr>
  <tr>
    <td height="18" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.fqwz')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00320Bean.fqwz" /></td>
    <td bgcolor="#FFFFFF" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.qdh')" /></td>
    <td bgcolor="#FFFFFF">&nbsp;<s:property value="v00320Bean.qdh" /></td>
  </tr>
  <tr>
    <td height="18" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.zhxz')" /></td>
    <td height="18" colspan="3" bgcolor="#FFFFFF"><s:property value="v00320Bean.zhxz" /></td>
  </tr>
  <tr>
    <td height="18" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.hdjg')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.moneyZh"><s:param value="v00320Bean.hdjg" /></s:text></td>
    <td bgcolor="#FFFFFF" class="datagrid-title-text">&nbsp;<s:property value="getText('app.sjcj.t00320.jzmj')" /></td>
    <td bgcolor="#FFFFFF">&nbsp;<s:text name="app.global.format.double"><s:param value="v00320Bean.jzmj" /></s:text></td>
  </tr>
</table>
<table width="440" border="0" align="center" cellpadding="1" cellspacing="1">
<tr>
    <td width="195" height="18" bgcolor="#EBEADB" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.jysj')" /></td>
    <td width="198" height="18" bgcolor="#EBEADB" class="datagrid-title-text"><s:property value="getText('app.sjcj.t00320.pgjg')" /></td>
  </tr>
  <s:if test='%{v00320Bean.outList.size > 0}'>
  <s:iterator  value="v00320Bean.outList" status="index"> 
  <tr>
	<td height="18"><s:text name="app.global.format.date"><s:param value="jysj" /></s:text></td>
	<td height="18"><s:text name="app.global.format.moneyZh"><s:param value="pgjg" /></s:text></td>
  </tr>
  </s:iterator>
  </s:if>
</table>
</body>
</html>