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
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t12001.swid')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00304Bean.swid" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t12001.nsrmc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00304Bean.nsrmc" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.jylx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00304Bean.jylx" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.jzjg')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00304Bean.jzjg" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.fwcx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00304Bean.fwcx" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.cgzk')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00304Bean.cgzk" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.fwlx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00304Bean.fwlx" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjpg.t00331.szlc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00304Bean.szlc" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjpg.t00331.zlc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00304Bean.zlc" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjpg.t00331.fwtdzl')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00304Bean.fwtdzl" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.xqmc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00304Bean.xqmc" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00304.hx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00304Bean.hx" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00304.gpsj')" /></td>
    <td height="18" bgcolor="#FFFFFF">
    	<s:if test="null!=v00304Bean.gpsj">
        <s:text name="app.global.format.date"><s:param value="v00304Bean.gpsj" /></s:text>
      </s:if>
    </td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.upddate')" /></td>
    <td height="18" bgcolor="#FFFFFF">
      <s:if test="null!=v00304Bean.upddate">
        <s:text name="app.global.format.datetime"><s:param value="v00304Bean.upddate" /></s:text>
      </s:if>
    </td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.czr')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00304Bean.czr" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.note')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00304Bean.note" /></td>
  </tr>
</table>
</body>
</html>