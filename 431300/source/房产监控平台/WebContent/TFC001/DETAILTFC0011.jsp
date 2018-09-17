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
  	<td height="18" bgcolor="#EBEADB">中止反馈信息</td>
  	<td height="18" bgcolor="#FFFFFF" colspan="2"><s:property value="vfc001Bean.remarks1" /></td>
  </tr> 
</table>
</body>
</html>