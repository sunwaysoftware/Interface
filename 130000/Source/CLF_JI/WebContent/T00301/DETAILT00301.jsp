<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
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
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.swid')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00301Bean.zjhm" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.nsrmc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00301Bean.nsrmc" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.zjlx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00301Bean.zjlx" /></td>
  </tr>
  <!--
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.zz')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00301Bean.zz" /></td>
  </tr>
  -->
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.lxdh')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00301Bean.lxdh" /></td>
  </tr>
<!-- 
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.yddh')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00301Bean.yddh" /></td>
  </tr>
-->
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.ssgx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00301Bean.ssgx" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.upddate')" /></td>
    <td height="18" bgcolor="#FFFFFF">
      <s:if test="null!=v00301Bean.upddate">
        <s:text name="app.global.format.datetime"><s:param value="v00301Bean.upddate" /></s:text>
      </s:if>
    </td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.czr')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00301Bean.czr" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.note')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00301Bean.note" /></td>
  </tr>
</table>
</body>
</html>