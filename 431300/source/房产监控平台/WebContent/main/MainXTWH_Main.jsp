<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/template.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title><s:property value="%{getText('app.global.title')}" /></title>
<!-- InstanceEndEditable -->
<script type="text/javascript" src="../scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<!-- InstanceBeginEditable name="head" -->
<style type="text/css">
body {
	background-color: #FFFFFF;
}
</style>
<!-- InstanceEndEditable -->
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	<!-- InstanceBeginEditable name="body" -->
    <div style="padding-left:30px;padding-right:30px">
    <fieldset>
		<legend>功能导航</legend>
				<h3><img src="../images/ico/cj.gif" width="24" height="24" style="padding-right:5px"/>常规设置</h3>
		<s:if test="%{userRole.contains('00000027')}">
			<blockquote>
				<img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00012.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00012.title')}" />"><s:property value="%{getText('app.xtwh.t00012.title')}" /></a>&nbsp;&nbsp;
			    <img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00013.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00013.title')}"/>"><s:property value="%{getText('app.xtwh.t00013.title')}"/></a>&nbsp;&nbsp;
			    <img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00055.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00055.title')}"/>"><s:property value="%{getText('app.xtwh.t00055.title')}"/></a>&nbsp;&nbsp;
			</blockquote>
		</s:if>
		 	 	<h3><img src="../images/ico/cj.gif" alt="" width="24" height="24" style="padding-right:5px"/>数据输入</h3>
	 	<s:if test="%{userRole.contains('00000028')}"> 	
	 	 	<blockquote>
				<img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00001.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00001.title')}" />"><s:property value="%{getText('app.xtwh.t00001.title')}" /></a>&nbsp;&nbsp;
			    <img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/ADDT00052.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00052.title')}" />"><s:property value="%{getText('app.xtwh.t00052.title')}" /></a>&nbsp;&nbsp;
				<img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00352.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00352.title')}" />"><s:property value="%{getText('app.xtwh.t00352.title')}" /></a>&nbsp;&nbsp;
				<img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/CONFIRMT00352.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t003521.title')}" />"><s:property value="%{getText('app.xtwh.t003521.title')}" /></a>&nbsp;&nbsp;
				<img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00303.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00303.title')}" />"><s:property value="%{getText('app.xtwh.t00303.title')}" /></a>
			</blockquote>
		</s:if>
				<h3><img src="../images/ico/cj.gif" alt="" width="24" height="24" style="padding-right:5px"/>估价参数</h3>
			<s:if test="%{userRole.contains('00000029')}">
			<blockquote>
				<img src="../images/ico/xx.gif" alt="" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00359.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00359.title')}" />"><s:property value="%{getText('app.xtwh.t00359.title')}" /></a>&nbsp;&nbsp;
				<img src="../images/ico/xx.gif" alt="" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00353.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00353.title')}" />"><s:property value="%{getText('app.xtwh.t00353.title')}" /></a>&nbsp;&nbsp;
				<img src="../images/ico/xx.gif" alt="" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00355.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00355.title')}" />"><s:property value="%{getText('app.xtwh.t00355.title')}" /></a>&nbsp;&nbsp;
				<img src="../images/ico/xx.gif" alt="" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00356.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00356.title')}" />"><s:property value="%{getText('app.xtwh.t00356.title')}" /></a>&nbsp;&nbsp;
<!--				<img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00053.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00053.title')}" />"><s:property value="%{getText('app.xtwh.t00053.title')}" /></a>-->
				<img src="../images/ico/xx.gif" alt="" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT003840YY.action" target="mainFrame" title="<s:property value="%{getText('app.sjsh.t00384.gjdb')}" />"><s:property value="%{getText('app.sjsh.t00384.gjdb')}" /></a>&nbsp;&nbsp;
			</blockquote>
			</s:if>
			
				<h3><img src="../images/ico/cj.gif" alt="" width="24" height="24" style="padding-right:5px"/>可比数据</h3>
			<s:if test="%{userRole.contains('00000032')}">
			  <blockquote>
			  	<img src="../images/ico/xx.gif" alt="" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00357.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00357.title')}" />"><s:property value="%{getText('app.xtwh.t00357.title')}" /></a>&nbsp;&nbsp;
				<img src="../images/ico/xx.gif" alt="" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00351.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00351.title')}" />"><s:property value="%{getText('app.xtwh.t00351.title')}" /></a>&nbsp;&nbsp;				
				<img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00351CSSAME.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.bzfcs.title.samearea')}" />"><s:property value="%{getText('app.xtwh.bzfcs.title.samearea')}" /></a>&nbsp;&nbsp;
			    <img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00351CSDIFF.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.bzfcs.title.diffarea')}"/>"><s:property value="%{getText('app.xtwh.bzfcs.title.diffarea')}"/></a>&nbsp;&nbsp;
				<img src="../images/ico/xx.gif" alt="" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/FindSCBZSLKGXBZ.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.bzfjgzs.title')}" />"><s:property value="%{getText('app.xtwh.bzfjgzs.title')}" /></a>
			  	<img src="../images/ico/xx.gif" alt="" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00304.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00304.title')}" />"><s:property value="%{getText('app.xtwh.t00304.title')}" /></a>&nbsp;&nbsp;
			  </blockquote>
			</s:if>
			<s:if test="%{userRole.contains('00000038')}">
				</s:if>
				<h3><img src="../images/ico/cj.gif" alt="" width="24" height="24" style="padding-right:5px"/>税款计算维护</h3>
			<s:if test="%{userRole.contains('00000033')}">
			<blockquote>
				<img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00051.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00051.title')}" />"><s:property value="%{getText('app.xtwh.t00051.title')}" /></a>
		    </blockquote>
		    </s:if>	
			<h3><img src="../images/ico/cj.gif" alt="" width="24" height="24" style="padding-right:5px"/>数据备份</h3>
			<s:if test="%{userRole.contains('00000039')}">
				<blockquote>
				<img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWBACKUP.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.databackup.title')}" />"><s:property value="%{getText('app.xtwh.databackup.title')}" /></a>
		    	</blockquote>
		    </s:if>
				<h3><img src="../images/ico/cj.gif" alt="" width="24" height="24" style="padding-right:5px"/>系统人员与权限维护</h3>
			<s:if test="%{ISADMIN==2 || userRole.contains('00000035')}">
			<blockquote>
				<img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00002.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00002.title')}" />"><s:property value="%{getText('app.xtwh.t00002.title')}" /></a>&nbsp;&nbsp;
			    <img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00003.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00003.title')}" />"><s:property value="%{getText('app.xtwh.t00003.title')}" /></a>&nbsp;&nbsp;
			    <img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00004.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00004.title')}" />"><s:property value="%{getText('app.xtwh.t00004.title')}" /></a>&nbsp;&nbsp;
			    <img src="../images/ico/xx.gif" width="16" height="16" style="padding-right:5px"/><a href="../xtwh/VIEWT00009.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00009.title')}" />"><s:property value="%{getText('app.xtwh.t00009.title')}" /></a>
		    </blockquote>
		    </s:if>
	    </fieldset>
   	  </div>
    <!-- InstanceEndEditable --></td>
  </tr>
</table>
</body>
<!-- InstanceEnd --></html>
