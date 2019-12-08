<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
  <tr>
    <td height="18" width="100" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00357.slid')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.slid" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.szqy')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.szqy" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.xqmc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.xqnm" /></td>
  </tr>  
  <tr>
  	<td height="18" width="100" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00357.clh')" /></td>
  	<td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.clh" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00357.fwtdzl')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.fwtdzl" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00357.bwjfh')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.bwjfh" /></td>
  </tr>
  <tr>
  	<td height="18" width="100" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00357.zjhm')" /></td>
  	<td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.cd00301Swid" /></td>
  </tr>
  <tr>
  	<td height="18" width="100" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00357.cqr')" /></td>
  	<td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.nsrmc" /></td>
  </tr>  
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.fwlx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.fwlx" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.jylx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.jylx" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.jzjg')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.jzjg" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00357.szlc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.szlc" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.zlc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.zlc" /></td>
  </tr>  
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcx.v003025.zhxz')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.zhxz" /></td>
  </tr>
  <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property	value="%{getText('app.sjcj.t12003.jcnf')}" /></td>
  	<td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.jcsj" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00357.jzmj')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.double"><s:param value="v00357Bean.jzmj" /></s:text></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00357.pgjg_dj')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.moneyZh"><s:param value="v00357Bean.pgjg" /></s:text></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00357.jysj')" /></td>
    <td height="18" bgcolor="#FFFFFF">
      <s:if test="null!=v00357Bean.jysj">
        <s:text name="app.global.format.date"><s:param value="v00357Bean.jysj" /></s:text>
      </s:if>
    </td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.upddate')" /></td>
    <td height="18" bgcolor="#FFFFFF">
      <s:if test="null!=v00357Bean.upddate">
        <s:text name="app.global.format.datetime"><s:param value="v00357Bean.upddate" /></s:text>
      </s:if>
    </td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.czr')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.czr" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.note')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00357Bean.note" /></td>
  </tr>
</table>
</body>
</html>