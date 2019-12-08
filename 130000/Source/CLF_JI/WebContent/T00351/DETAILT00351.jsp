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
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00351.slid')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.slid" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.szqy')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.szqy" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.xqmc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.xqnm" /></td>
  </tr>  
<!--  <tr>-->
<!--    <td height="18" width="100" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.clh')" /></td>-->
<!--    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.clh" /></td>-->
<!--  </tr>-->
<!--  <tr>-->
<!--    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.zcdzl')" /></td>-->
<!--    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.fwtdzl" /></td>-->
<!--  </tr>  -->
<!--  <tr>-->
<!--    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00351.szlc')" /></td>-->
<!--    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.szlc" /></td>-->
<!--  </tr>-->
<!--  <tr>-->
<!--    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.zlc')" /></td>-->
<!--    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.zlc" /></td>-->
<!--  </tr>-->
<!--  <tr>-->
<!--    <td height="18" width="100" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.jylx')" /></td>-->
<!--    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.jylx" /></td>-->
<!--  </tr>-->
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.fwlx')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.fwlx" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.jzjg')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.jzjg" /></td>
  </tr>
<%--  <tr>--%>
<%--    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.fwcx')" /></td>--%>
<%--    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.fwcx" /></td>--%>
<%--  </tr>--%>
<%--  <tr>--%>
<%--    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.info.cgzk')" /></td>--%>
<%--    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.cgzk" /></td>--%>
<%--  </tr>--%>
  
  <!--  
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00352.xqbm')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.xqbm" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00303.ywdt')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:if test='%{"1"==v00351Bean.ywdt}'>有</s:if><s:else>无</s:else></td>
  </tr>
  -->
  <!--
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00351.jysj')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.date"><s:param value="v00351Bean.jysj" /></s:text></td>
  </tr>
  
   -->
<!--   <tr>-->
<!--    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcx.v003025.zhxz')" /></td>-->
<!--    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.zhxz" /></td>-->
<!--  </tr>-->
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('建成年份')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.jcsj" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.upddate')" /></td>
    <td height="18" bgcolor="#FFFFFF">
      <s:if test="null!=v00351Bean.upddate">
        <s:text name="app.global.format.datetime"><s:param value="v00351Bean.upddate" /></s:text>
      </s:if>
    </td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.czr')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.czr" /></td>
  </tr>
  <tr>
 
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.note')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00351Bean.note" /></td>
  </tr>
  <tr>
    <tr>
	    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00351.jysj')" /></td>
	     <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00351.pfmjg')" /></td>
	</tr>
    <s:iterator value="tabListA" status="index"> 
   
	<tr>
	    <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.date"><s:param value="jysj" /></s:text></td>
	    <td height="18" bgcolor="#FFFFFF">￥<s:property value="pfmjg" /></td>  
   </tr>
   </s:iterator>
   </tr>	
</table>
</body>
</html>