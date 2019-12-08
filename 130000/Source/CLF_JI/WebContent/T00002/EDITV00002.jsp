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
    <td height="18" bgcolor="#E0ECFF"><s:property value="getText('app.xtwh.t00002.userid')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00002Bean.userid" /></td>
  </tr>
   <tr>
    <td height="18" bgcolor="#E0ECFF"><s:property value="getText('app.xtwh.t00002.usernm')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00002Bean.usernm" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#E0ECFF"><s:property value="getText('app.xtwh.t00002.userip')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00002Bean.userip" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#E0ECFF"><s:property value="getText('app.xtwh.info.ssgx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00002Bean.ssgx" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#E0ECFF"><s:property value="getText('app.xtwh.t00002.phone')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00002Bean.phone" /></td>
  </tr>

  <tr>
    <td height="18" bgcolor="#E0ECFF"><s:property value="getText('app.xtwh.t00002.isadmin')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00002Bean.isadmin" /></td>
  </tr>
 <tr>
    <td height="18" bgcolor="#E0ECFF"><s:property value="getText('app.xtwh.t00002.islocked')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00002Bean.islocked" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#E0ECFF"><s:property value="getText('app.xtwh.t00002.failedcount')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00002Bean.failedcount" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#E0ECFF"><s:property value="getText('app.xtwh.t00002.lastlockedoutdate')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00002Bean.lastlockedoutdate" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#E0ECFF"><s:property value="getText('app.xtwh.t00002.lastlogindate')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00002Bean.lastlogindate" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#E0ECFF"><s:property value="getText('app.czr')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00002Bean.czr" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#E0ECFF"><s:property value="getText('app.upddate')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00002Bean.upddate" /></td>
  </tr>
</table>
</body>
</html>