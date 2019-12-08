<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>



<script type="text/javascript" src="../scripts/T00301/VIEWT00300BG.js"></script>


</head>
<body>
<table border="0" align="center" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
    <div id="tabs" class="tabs" style="display:none">
        <ul>
            <li><a href="#DJXX"><span><s:property value="%{getText('app.sjcj.t00301.bg.title')}" /></span></a></li>
            <li><a href="#FCXX"><span><s:property value="%{getText('app.sjcj.t00302.bg.title')}" /></span></a></li> 
        </ul>
		<div id="DJXX">
        	<iframe id="IDJXX" width="100%" height="530px" frameborder="0" scrolling="no"></iframe>
        </div>
        <div id="FCXX">
        	<iframe id="IFCXX" width="100%" height="600px" frameborder="0" scrolling="no"></iframe>
        </div>
    </div>
    </td>
  </tr>
</table>
</body>
</html>