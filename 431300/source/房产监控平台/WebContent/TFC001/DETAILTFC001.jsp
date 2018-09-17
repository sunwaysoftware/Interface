<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
/**
 * 彈出窗口
 * @param i_URL 彈出窗口的URL
 * @param i_Height 高度
 * @param i_Width 寬度
 * @param i_Target 窗口名
 */
function Show(i_URL,i_Height,i_Width,i_Target)
{
	var iLeft = (screen.width - i_Width) / 2;
	var iTop = (screen.height - i_Height) / 2;
	var strFeatures = "Top=" + iTop + ",Left=" + iLeft +",Height=" + i_Height + ",Width=" + i_Width + ",status=yes,scrollbars=yes,resizable=yes" ;
	var w1 = window.open(encodeURI(i_URL), i_Target, strFeatures);
	w1.focus();
}
</script>
</head>
<body>
<table width="400" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.slid')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.slid" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.ssqy')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.ssqy" /></td>
  </tr>
    <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.fczh')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.fczh" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.zrfname')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.zrf_name" /></td>
  </tr>
  <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.zrfzjhm')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.zrf_id" /></td>
  </tr> 
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.csfname')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.csf_name" /></td>
  </tr>
  <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.csfzjhm')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.csf_id" /></td>
  </tr>
  
  <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.clh')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.clh" /></td>
  </tr> 
    <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.ghyt')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.ghyt" /></td>
  </tr> 
   <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.lfdz')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.lfdz" /></td>
  </tr> 
   <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.dyfh')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.dyfh" /></td>
  </tr> 
 <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.zlc')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.zlc" /></td>
  </tr> 
   <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.szlc')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.szlc" /></td>
  </tr> 
   <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.jzjg')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.jzjg" /></td>
  </tr> 
   <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.fwlx')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.fwlx" /></td>
  </tr> 
   <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.jylx')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.jylx" /></td>
  </tr>
   <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.jzmj')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2">
  	<s:text name="app.global.format.double"><s:param value="vfc001Bean.jzmj" /></s:text>
  	</td>
  </tr>  
  <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.htzj')" />(元)</td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2">
  	<s:text name="app.global.format.moneyZh"><s:param value="vfc001Bean.htzj" /></s:text>
  	</td>
  </tr>  
  <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.fzrq')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2">	
  		 <s:if test="null!=vfc001Bean.qswsrq">
        <s:text name="app.global.format.date"><s:param value="vfc001Bean.fzrq" /></s:text></s:if>
    </td>
  </tr>  
  <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.jcnf')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.jcnf" /></td>
  </tr>  
  <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.jysj')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2">
  		 <s:if test="null!=vfc001Bean.qswsrq">
        <s:text name="app.global.format.date"><s:param value="vfc001Bean.jysj" /></s:text></s:if>
    </td>
  </tr>  
  <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.cx')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.cx" /></td>
  </tr>  
  <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.df')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.df" /></td>
  </tr> 
  <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.updatetime')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2">
  	 <s:if test="null!=vfc001Bean.qswsrq">
        <s:text name="app.global.format.datetime"><s:param value="vfc001Bean.update" /></s:text></s:if>
    </td>
  </tr>   
    <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.jg')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.jg" /></td>
  </tr> 
    <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.zx')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.zx" /></td>
  </tr> 
    <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.cg')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.cg" /></td>
  </tr> 
    <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.qswsrq')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2">
  	  <s:if test="null!=vfc001Bean.qswsrq">
        <s:text name="app.global.format.date"><s:param value="vfc001Bean.qswsrq" /></s:text>
      </s:if>
   </td>
  </tr> 
    <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.qswsjs')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2">
  	<s:text name="app.global.format.double"><s:param value="vfc001Bean.qswsjs" /></s:text>
  	</td>
  </tr> 
    <tr>
  	<td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.remarks')" /></td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.remarks" /></td>
  </tr> 
</table>
</body>
</html>