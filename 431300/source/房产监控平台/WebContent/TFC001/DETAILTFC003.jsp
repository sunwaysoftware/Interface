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
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.slid')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tfc003Bean.slid" /></td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.tdsyqx1')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">    
     <s:if test="null!=tfc003Bean.tdsyqx1">
        <s:text name="app.global.format.date"><s:param value="tfc003Bean.tdsyqx1" /></s:text>
        </s:if>
    </td>
  </tr>
  <tr>
   <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.fczh')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tfc003Bean.fczh" /></td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.tdsyqx2')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">
      <s:if test="null!=tfc003Bean.tdsyqx2">
        <s:text name="app.global.format.date"><s:param value="tfc003Bean.tdsyqx2" /></s:text>
        </s:if>
    </td>
  </tr>
   <tr>
   <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.cqr')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tfc003Bean.cqr" /></td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.fwdjrq')" /></td>
      <td height="18" bgcolor="#FFFFFF" colspan="2">
       <s:if test="null!=tfc003Bean.fwdjrq">
        <s:text name="app.global.format.date"><s:param value="tfc003Bean.fwdjrq" /></s:text>
        </s:if>
    </td>
  </tr>
 <tr>
   <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.fczl')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tfc003Bean.fczl" /></td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.fwzh')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tfc003Bean.fwzh" /></td>
  </tr>
   <tr>
   <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.tdqsxz')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tfc003Bean.tdqsxz" /></td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.fwbwh')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tfc003Bean.fwbwh" /></td>
  </tr>
   <tr>
   <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.tdsyqqdfs')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tfc003Bean.tdsyqqdfs" /></td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.fwjzmj')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">    
    <s:text name="app.global.format.double"><s:param value="tfc003Bean.fwjzmj" /></s:text>
  	</td>
  </tr>
   <tr>
   <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.tdyt')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tfc003Bean.tdyt" /></td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.fwjzlx')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tfc003Bean.fwjzlx" /></td>
  </tr>
   <tr>
   <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.tdzdh')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tfc003Bean.tdzdh" /></td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.fwty')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tfc003Bean.fwty" /></td>
  </tr>  
   <tr>
   <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.tdzdmj')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">
      <s:text name="app.global.format.double"><s:param value="tfc003Bean.tdzdmj" /></s:text>
  	</td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.fwzcs')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tfc003Bean.fwzcs" /></td>
  </tr>
   <tr>
   <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.tdsyqmj')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"> 
     <s:text name="app.global.format.double"><s:param value="tfc003Bean.tdsyqmj" /></s:text>
  	</td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.fwjgrq')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">
     <s:if test="null!=tfc003Bean.fwjgrq">
        <s:text name="app.global.format.date"><s:param value="tfc003Bean.fwjgrq" /></s:text>
        </s:if>
    </td>
  </tr>
   <tr>
   <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.qzdymj')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">
     <s:text name="app.global.format.double"><s:param value="tfc003Bean.qzdymj" /></s:text>
  	</td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.fzdw')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tfc003Bean.fzdw" /></td>
  </tr>
     <tr>
   <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.qzftmj')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">
 <s:text name="app.global.format.double"><s:param value="tfc003Bean.qzftmj" /></s:text>
  	</td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc003.fzrq')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">
     <s:if test="null!=tfc003Bean.fzrq">
        <s:text name="app.global.format.date"><s:param value="tfc003Bean.fzrq" /></s:text>
        </s:if>
    </td>
  </tr>
</table>
</body>
</html>