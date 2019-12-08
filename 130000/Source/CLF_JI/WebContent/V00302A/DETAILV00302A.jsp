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
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcx.czh')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.czh" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.fcid')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.fcid" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.swid')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.cd00301aSwid" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.nsrmc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.nsrmc" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.xqdm')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.cd00352Xqdm" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.szqy')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.szqy" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.xqmc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.xqnm" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.zcdzl')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.fwtdzl" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.ywdt')" /></td>
    <td height="18" bgcolor="#FFFFFF">
      <s:if test="%{v00302aBean.ywdt}">
        <s:property value="getText('app.global.checkbox.true')" />
      </s:if><s:else>
        <s:property value="getText('app.global.checkbox.false')" />
      </s:else>
    </td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.zlc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.zlc" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.fwlx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.fwlx" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.jylx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.jylx" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.jzjg')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.jzjg" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.jzmj')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.double"><s:param value="v00302aBean.jzmj" /></s:text></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.fwcx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.fwcx" /></td>
  </tr>
  <!--
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.zxzk')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.zxzk" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.wyzk')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.wyzk" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.jtzk')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.jtzk" /></td>
  </tr>
  -->
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.szlc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.szlc" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.bwjfh')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.bwjfh" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.jyjg')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.moneyZh"><s:param value="v00302aBean.jyjg" /></s:text></td>
  </tr>
  <!--
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.tdsyqmj')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.double"><s:param value="v00302aBean.tdsyqmj" /></s:text></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.rjl')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.double"><s:param value="v00302aBean.rjl" /></s:text></td>
  </tr>
  -->
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.jysj')" /></td>
    <td height="18" bgcolor="#FFFFFF">
      <s:if test="null!=v00302aBean.jysj">
        <s:text name="app.global.format.date"><s:param value="v00302aBean.jysj" /></s:text>
      </s:if>
    </td>
  </tr>
  <!--
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.fdcdat')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.fdcdat" /></td>
  </tr>
  -->
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.upddate')" /></td>
    <td height="18" bgcolor="#FFFFFF">
      <s:if test="null!=v00302aBean.upddate">
        <s:text name="app.global.format.datetime"><s:param value="v00302aBean.upddate" /></s:text>
      </s:if>
    </td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.czr')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.czr" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.note')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.note" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcx.bgsj')" /></td>
    <td height="18" bgcolor="#FFFFFF">
      <s:if test="null!=v00302aBean.bgsj">
        <s:text name="app.global.format.date"><s:param value="v00302aBean.bgsj" /></s:text>
      </s:if></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcx.sfbg')" /></td>
    <td height="18" bgcolor="#FFFFFF">
      <s:if test="%{v00302aBean.sfbg}">已变更</s:if><s:else>未变更</s:else>
    </td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcx.bgmc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302aBean.bgmc" /></td>
  </tr>
</table>
</body>
</html>