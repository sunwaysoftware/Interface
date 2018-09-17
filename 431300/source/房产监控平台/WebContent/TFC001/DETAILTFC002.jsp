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
<table width="500" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
  <tr>
    <td height="18" width="100" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.slid')" /></td>
    <td height="18" width="150" bgcolor="#FFFFFF" colspan="2"><s:property value="tFc002Bean.slid" /></td>
    <td height="18" width="100" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc001.ssqy')" /></td>
    <td height="18" width="150" bgcolor="#FFFFFF" colspan="2"><s:property value="tFc002Bean.ssqy" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc002.djz_qs')" />(元)</td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">    
    <s:text name="app.global.format.moneyZh"><s:param value="tFc002Bean.djz_qs" /></s:text>
  	</td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc002.djz_yys')" />(元)</td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">    
    <s:text name="app.global.format.moneyZh"><s:param value="tFc002Bean.djz_yys" /></s:text>
  	</td>
  </tr>
   <tr>
   <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc002.djz_cjs')" />(元)</td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">    
    <s:text name="app.global.format.moneyZh"><s:param value="tFc002Bean.djz_cjs" /></s:text>
  	</td>
  	 <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc002.djz_dfjys')" />(元)</td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">    
    <s:text name="app.global.format.moneyZh"><s:param value="tFc002Bean.djz_dfjys" /></s:text>
  	</td>
  </tr>
 <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc002.djz_grsds')" />(元)</td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">    
    <s:text name="app.global.format.moneyZh"><s:param value="tFc002Bean.djz_grsds" /></s:text>
  	</td>
  	  <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc002.djz_yhs')" />(元)</td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">    
    <s:text name="app.global.format.moneyZh"><s:param value="tFc002Bean.djz_yhs" /></s:text>
  	</td>
  </tr>
   <tr>
   <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc002.fphm')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tFc002Bean.fphm" /></td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc002.qssphm')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tFc002Bean.qssphm" /></td>
  </tr>
   <tr>
   <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc002.dfgssphm')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tFc002Bean.Qssphm" /></td>
     <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc002.updatetime')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">
     <s:if test="null!=tFc002Bean.updatetime">
        <s:text name="app.global.format.datetime"><s:param value="tFc002Bean.updatetime" /></s:text>
        </s:if>
    </td>
  </tr>
   <tr>   
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc002.ms_sign')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">
     <s:if test="tFc002Bean.ms_sign==0">
       正常
   </s:if>
   <s:elseif test="tFc002Bean.ms_sign==1">
     免税
   </s:elseif></td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc002.ms_zcyj')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tFc002Bean.ms_zcyj" /></td>
  </tr>
   <tr>
   <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc002.pgid')" /></td>
    <td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="tFc002Bean.pgid" /></td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.tfc002.pgjg')" />(元)</td>
    <td height="18" bgcolor="#FFFFFF" colspan="2">    
    <s:text name="app.global.format.moneyZh"><s:param value="tFc002Bean.pgjg" /></s:text>
  	</td>
  </tr>
</table>
</body>
</html>