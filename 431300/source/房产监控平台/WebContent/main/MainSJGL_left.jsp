<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
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
<!-- InstanceEndEditable -->
<style type="text/css">
<!--
body {
	background-color: #eaedf2;
}
-->
</style></head>
<body>
<!-- InstanceBeginEditable name="body" -->
      <ul class="menu">
       <li><a href="#" class="rootMenu" title="<s:property value="%{getText('app.menu.SJGL.SJCJ')}" />"><s:property value="%{getText('app.menu.SJGL.SJCJ')}" /></a>
         <ul>
      		<s:if test="%{userRole.contains('00000002')}">
      		<li><a href="../sjcj/ADDT00302.action?ACT=C" target="mainFrame" title="<s:property value="%{getText('app.menu.SJGL.SCSJCJ')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.menu.SJGL.SCSJCJ')}" /></a></li>
      		</s:if>
         </ul>
       </li>
       <!-- 
       <li><a href="#" class="rootMenu" title="<s:property value="%{getText('app.menu.SJGL.SJSH')}" />"><s:property value="%{getText('app.menu.SJGL.SJSH')}" /></a>
         <ul>
           <s:if test="%{userRole.contains('00000005')}">
           <li><a href="../SH30000/SH30001.jsp" target="mainFrame" title="<s:property value="%{getText('app.sjsh.sh30000.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.sjsh.sh30000.title')}" /></a></li>
           </s:if>
         </ul>
       </li>
        -->
       <li><a href="#" class="rootMenu" title="<s:property value="%{getText('app.menu.SJGL.SJBG')}" />"><s:property value="%{getText('app.menu.SJGL.SJBG')}" /></a>
         <ul>
           <s:if test="%{userRole.contains('00000007')}">
           <li><a href="../sjcj/VIEWT00302.action?ACT=M" target="mainFrame" title="<s:property value="getText('app.menu.SJGL.SCSJBG')"/>"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="getText('app.menu.SJGL.SCSJBG')"/></a></li>
           </s:if>
         </ul>
       </li>
     </ul>       
      <!-- InstanceEndEditable -->
</body>
<!-- InstanceEnd --></html>
