<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>


<script type="text/javascript" src="../scripts/V00301A/VIEWV00301AFRAME.js"></script>

</head>
<body>
	<div id="tabs" class="tabs" style="display:none">
        <ul>
            <li><a href="#DJ"><span>登记信息</span></a></li>
            <li><a href="#FC"><span>房产信息</span></a></li>
        </ul>
		<div id="DJ">
        	<iframe id="IDJ" width="100%" height="500px" frameborder="0" scrolling="no" CZH='<s:property value="CZH" />'></iframe>
        </div>
		<div id="FC">
        	<iframe id="IFC" width="100%" height="500px" frameborder="0" scrolling="no" CZH='<s:property value="CZH" />'></iframe>
        </div>
    </div>
</body>
</html>