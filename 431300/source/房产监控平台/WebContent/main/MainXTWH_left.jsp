<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/templateLeft.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- InstanceBeginEditable name="doctitle" -->
<title><s:property value="%{getText('app.menu')}" /></title>
<!-- InstanceEndEditable -->
<!--[if ie]>
<style type="text/css" media="screen">
	.menu a {zoom:1;}
</style>
<![endif]-->
<link href="../css/screen.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../scripts/togglemenu.js"></script>
<!-- InstanceBeginEditable name="head" -->
<style type="text/css">
<!--
body {
	background-color: #eaedf2;
}
-->
</style><!-- InstanceEndEditable -->
</head>
<body>
<!-- InstanceBeginEditable name="body" -->
      <ul class="menu">
       <li><a href="#" class="rootMenu">常规设置</a>
         <ul>
           <s:if test="%{userRole.contains('00000027')}">
           <li><a href="../xtwh/VIEWT00012.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00012.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00012.title')}" /></a></li>
           <li><a href="../xtwh/VIEWT00013.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00013.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00013.title')}" /></a></li>
           <li><a href="../xtwh/VIEWT00055.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00055.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00055.title')}" /></a></li>
           </s:if>
         </ul>
       </li>
       <li><a href="#" class="rootMenu">数据输入</a>
         <ul>
           <s:if test="%{userRole.contains('00000028')}">
           <li><a href="../xtwh/VIEWT00001.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00001.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00001.title')}" /></a></li>
           <li><a href="../xtwh/ADDT00052.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00052.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00052.title')}" /></a></li>
           <li><a href="../xtwh/VIEWT00352.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00352.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00352.title')}" /></a></li>
           <li><a href="../xtwh/CONFIRMT00352.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t003521.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t003521.title')}" /></a></li>
           <li><a href="../xtwh/VIEWT00303.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00303.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00303.title')}" /></a></li>
           </s:if>
         </ul>
       </li>
       <li><a href="#" class="rootMenu">估价参数</a>
         <ul>
           <s:if test="%{userRole.contains('00000029')}">
          	   <li><a href="../xtwh/VIEWT00359.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00359.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00359.title')}" /></a></li>
           	   <li><a href="../xtwh/VIEWT00353.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00353.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00353.title')}" /></a></li>
               <li><a href="../xtwh/VIEWT00355.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00355.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00355.title')}" /></a></li>
               <li><a href="../xtwh/VIEWT00356.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00356.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00356.title')}" /></a></li>
<!--               <li><a href="../xtwh/VIEWT00053.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00053.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00053.title')}" /></a></li>-->
			   <li><a href="../xtwh/VIEWT003840YY.action" target="mainFrame" title="<s:property value="%{getText('app.sjsh.t00384.gjdb')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.sjsh.t00384.gjdb')}" /></a></li>
           </s:if>
         </ul>
       </li>
       <li><a href="#" class="rootMenu">可比数据</a>
           	 <ul>
               <s:if test="%{userRole.contains('00000032')}">
				<li><a href="../xtwh/VIEWT00357.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00357.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00357.title')}" /></a></li>
				<li><a href="../xtwh/VIEWT00351.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00351.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00351.title')}" /></a></li>
				<li><a href="../xtwh/VIEWT00351CSSAME.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.bzfcs.title.samearea')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.bzfcs.title.samearea')}" /></a></li>
				<li><a href="../xtwh/VIEWT00351CSDIFF.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.bzfcs.title.diffarea')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.bzfcs.title.diffarea')}" /></a></li>
				<li><a href="../xtwh/FindSCBZSLKGXBZ.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.bzfjgzs.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.bzfjgzs.title')}" /></a></li>
				<li><a href="../xtwh/VIEWT00304.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00304.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00304.title')}" /></a></li>
				</s:if>
             </ul>
        </li>
       <li><a href="#" class="rootMenu">税款计算维护</a>
         <ul>
           <s:if test="%{userRole.contains('00000033')}">
           <li><a href="../xtwh/VIEWT00051.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00051.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00051.title')}" /></a></li>
           </s:if>
         </ul>
       </li> 
       <li><a href="#" class="rootMenu">数据备份</a>
       	<ul>
       		<s:if test="%{userRole.contains('00000039')}">
       		<li><a href="../xtwh/VIEWBACKUP.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.databackup.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.databackup.title')}" /></a></li>
       		</s:if>
       	</ul>
       </li>
       <li><a href="#" class="rootMenu">系统人员与权限维护</a>
         <ul>
           <s:if test="%{ISADMIN==2 || userRole.contains('00000035')}">
           <li><a href="../xtwh/VIEWT00002.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00002.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00002.title')}" /></a></li>
           <li><a href="../xtwh/VIEWT00003.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00003.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00003.title')}" /></a></li>
           <li><a href="../xtwh/VIEWT00004.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00004.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00004.title')}" /></a></li>
           <li><a href="../xtwh/VIEWT00009.action" target="mainFrame" title="<s:property value="%{getText('app.xtwh.t00009.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.xtwh.t00009.title')}" /></a></li>
           </s:if>
         </ul>
       </li>
     </ul>       
      <!-- InstanceEndEditable -->
</body>
<!-- InstanceEnd --></html>
