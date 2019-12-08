<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/templateLeft.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<title><s:property value="%{getText('app.menu')}" /></title>

<!--[if ie]>
<style type="text/css" media="screen">
	.menu a {zoom:1;}
</style>
<![endif]-->
<link href="../css/screen.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../scripts/togglemenu.js"></script>

<style type="text/css">
<!--
body {
	background-color: #eaedf2;
}
-->
</style>
</head>
<body>

    <ul class="menu">
      <li><a href="javascript:void(0)" class="rootMenu" title="<s:property value="%{getText('app.menu.FDCPG.SJPG')}" />"><s:property value="%{getText('app.menu.FDCPG.SJPG')}" /></a>
         <ul>
	       <s:if test="%{userRole.contains('00000010')}">
	       <li><a href="../PG30000/PG30001.jsp" target="mainFrame" title="<s:property value="%{getText('app.sjpg.pg30000.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.sjpg.pg30000.title')}" /></a></li>
	       </s:if>
	     </ul>
	   </li>
	   <li><a href="javascript:void(0)" class="rootMenu" title="<s:property value="%{getText('app.menu.FDCPG.SJGPG')}" />"><s:property value="%{getText('app.menu.FDCPG.SJGPG')}" /></a>
         <ul>
	       <s:if test="%{userRole.contains('00000013')}">
	       <li><a href="../pg/VIEWPG30001G.action" target="mainFrame" title="<s:property value="%{getText('app.sjpg.pg30000g.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.sjpg.pg30000g.title')}" /></a></li>
	       </s:if>  
       	</ul>
      </li> 
      <li><a href="javascript:void(0)" class="rootMenu" title="<s:property value="%{getText('app.menu.JSRDCL')}" />"><s:property value="%{getText('app.menu.JSRDCL')}" /></a>
         <ul>
	       <li><a href="../pg/VIEWT00390.action" target="mainFrame" title="<s:property value="%{getText('app.jsrdcl.title')}" />"><img src="../images/ico/cur.gif" width="6" height="9" align="absmiddle"><s:property value="%{getText('app.jsrdcl.title')}" /></a></li>
       	</ul>      	
      </li>    
	</ul>       
      
</body>
</html>
