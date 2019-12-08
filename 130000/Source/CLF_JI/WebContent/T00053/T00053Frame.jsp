<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/T00053/T00053TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00053/T00053Frame.js"></script>


<style type="text/css">
<!--
body {
	background-color: #FCFDFD;
}
-->
</style>
</head>
<body>
<div class="infodiv" id="T00053Frame"></div>
  <s:if test='%{t00053Bean.cd00001Szqy!=""}'>
    <script type="text/javascript">
    getDivQtxzEdit('<s:property value="t00053Bean.cd00001Szqy" />','<s:property value="t00053Bean.xzlx" />','<s:property value="t00053Bean.qtxzid" />','#T00053Frame');
    </script>
  </s:if>
</body>
</html>
