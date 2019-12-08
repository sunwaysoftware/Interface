<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/common.js"></script>
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
      <tr>
         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('app.xtwh.t00357.slid')}" /></td>
<!--         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('代码号')}" /></td>-->
         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('app.xtwh.t00303.xqmc')}" /></td>
         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('座落地址')}" /></td>
         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('app.xtwh.info.jzjg')}" /></td>
         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('app.xtwh.t00357.jzmj')}" /></td>
         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('app.xtwh.info.fwlx')}" /></td>
<!--         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('app.sjcj.t00320.sffs')}" /></td>-->
         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('app.xtwh.t00355.zlc')}" /></td>
         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('app.xtwh.t00357.szlc')}" /></td>
<!--         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('app.sjcj.t12003.jcnf')}" /></td>-->
<!--         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('app.xtwh.info.fwcx')}" /></td>-->
<!--         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('单元')}" /></td>-->
<!--         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('分区位置')}" /></td>-->
         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('app.xtwh.t00357.jysj')}" /></td>
         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('app.xtwh.t00357.pgjg')}" /></td>
<!--         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('单价（元/平方米）')}" /></td>-->
<!--         <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('app.upddate')}" /></td>-->
         
     </tr>

<s:iterator value="tabList" status="index">
     <tr>
         <td height="18" bgcolor="#FFFFFF"><a href="javascript:Show('../xtwh/DETAILT00357.action?SLID=<s:property value="slid" />',400,420,'slidxxxx');" title='点击查看详细信息' ><s:property value="slid" /></a></td>
<!--         <td height="18" bgcolor="#FFFFFF"><s:property value="xqdmh" /></td>-->
         <td height="18" bgcolor="#FFFFFF"><s:property value="xqnm"/></td>
         <td height="18" bgcolor="#FFFFFF"><s:property value="zcdzl"/></td>
         <td height="18" bgcolor="#FFFFFF"><s:property value="jzjg"/></td>
         <td height="18" bgcolor="#FFFFFF" align="right"><s:text name="app.global.format.double"><s:param value="jzmj"/></s:text></td>
         <td height="18" bgcolor="#FFFFFF"><s:property value="fwlx"/></td>
<!--         <td height="18" bgcolor="#FFFFFF" align="center"><s:if test="%{ywdt}">是</s:if><s:else>否</s:else></td>-->
         <td height="18" bgcolor="#FFFFFF" align="center"><s:property value="zlc"/></td>
         <td height="18" bgcolor="#FFFFFF" align="center"><s:property value="szlc"/></td>
<!--         <td height="18" bgcolor="#FFFFFF" align="center"><s:property value="jcsj"/></td>-->
<!--         <td height="18" bgcolor="#FFFFFF"><s:property value="fwcx"/></td>-->
<!--         <td height="18" bgcolor="#FFFFFF"><s:property value="dyh"/></td>-->
<!--         <td height="18" bgcolor="#FFFFFF"><s:property value="fqwz"/></td>-->
         <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.date"><s:param value="jysj" /></s:text></td>
         <td height="18" bgcolor="#FFFFFF" align="right"><s:text name="app.global.format.moneyZh"><s:param value="pgjg"/></s:text></td>
<!--         <td height="18" bgcolor="#FFFFFF" align="right"><s:text name="app.global.format.moneyZh"><s:param value="pfmjg"/></s:text></td>-->
<!--         <td height="18" bgcolor="#FFFFFF"><s:text name="app.global.format.datetime"><s:param value="upddate" /></s:text></td>-->
         
     </tr>
</s:iterator>
</table>
</body>
</html>