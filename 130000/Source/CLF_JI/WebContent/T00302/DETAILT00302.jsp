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
<%--   <tr>
    <td height="18" bgcolor="#EBEADB" style="width: 100px; "><s:property value="getText('app.sjcj.t00302.htbh')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.htbh" /></td>
  </tr> --%>
  <tr>
    <td height="18" bgcolor="#EBEADB" style="width: 100px; "><s:property value="getText('app.sjcj.t00302.fcid')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.fcid" /></td>
  </tr>
   <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.fczh')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.fczh" /></td>
  </tr>
  <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.fcslh')" /></td>
  	<td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.fcslh" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00055.zjlx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.zjlx" /></td>
  </tr>
<!--   <tr> -->
<!--     <td height="18" bgcolor="#EBEADB">纳税识别号（转）</td> -->
<%--     <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.sbh_zr" /></td>   --%>
<!--   </tr> -->
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.swid')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.zjhm" /></td>
  </tr>  
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.nsrmc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.nsrmc" /></td>
  </tr>  
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.csfzjlx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.csfZjlx" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.csfzjhm')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.csfzjhm" /></td>
  </tr>  
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.csfnsrmc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.csfnsrmc" /></td>
  </tr>
<%--   <tr>
    <td height="18" bgcolor="#EBEADB">纳税识别号（承）</td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.sbh_cs" /></td>  
  </tr>   --%>
<!--  <tr>-->
<!--    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.fcslh')" /></td>-->
<!--    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.fcslh" /></td>-->
<!--  </tr>-->  
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.xqdm')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.cd00352Xqdm" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.szqy')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.szqy" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.xqmc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.xqnm" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.zcdzl')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.fwtdzl" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.clh')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.clh" /></td>
  </tr>
  <!--<tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.ywdt')" /></td>
    <td height="18" bgcolor="#FFFFFF">
      <s:if test="%{v00302Bean.ywdt==1}">有</s:if><s:else>无</s:else>
    </td>
  </tr>-->
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.szlc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.szlc" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.zlc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.zlc" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.fwlx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.fwlx" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.jylx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.jylx" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.jzjg')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.jzjg" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcx.v003025.zhxz')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.zhxz" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.jzmj')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.double"><s:param value="v00302Bean.jzmj" /></s:text></td>
  </tr>  
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.lh')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.lh" /></td>
  </tr>
   <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.dyh')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.dyh" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.bwjfh')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.bwjfh" /></td>
  </tr><!--
   <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.fcslh')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.fcslh" /></td>
  </tr>
 
  --><tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.jyjg')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.moneyZh"><s:param value="v00302Bean.jyjg" /></s:text></td>
  </tr>
  <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.yjg')" /></td>
  	<td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.moneyZh"><s:param value="v00302Bean.yjg" /></s:text></td>
  </tr>
  <!--<tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.sbpgjg')" /></td>
  	<td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.moneyZh"><s:param value="v00302Bean.sbpgjg" /></s:text></td>
  </tr>  
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.tdsyqmj')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.double"><s:param value="v00302Bean.tdsyqmj" /></s:text></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.rjl')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.double"><s:param value="v00302Bean.rjl" /></s:text></td>
  </tr>
  -->
   <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('建成年份')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.jcsj" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00302.jysj')" /></td>
    <td height="18" bgcolor="#FFFFFF">
      <s:if test="null!=v00302Bean.jysj">
        <s:text name="app.global.format.date"><s:param value="v00302Bean.jysj" /></s:text>
      </s:if>
    </td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('发证日期')" /></td>
    <td height="18" bgcolor="#FFFFFF">
      <s:if test="null!=v00302Bean.djrq">
        <s:text name="app.global.format.date"><s:param value="v00302Bean.djrq" /></s:text>
      </s:if>
    </td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.ssgx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.ssgx" /></td>
  </tr> 
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.upddate')" /></td>
    <td height="18" bgcolor="#FFFFFF">
      <s:if test="null!=v00302Bean.upddate">
        <s:text name="app.global.format.datetime"><s:param value="v00302Bean.upddate" /></s:text>
      </s:if>
    </td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.czr')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00302Bean.czr" /></td>
  </tr>
  
</table>
</body>
</html>