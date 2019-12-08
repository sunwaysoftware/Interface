<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<link type="text/css" rel="stylesheet" href="../css/screen.css"/>
</head>
<body>
请选择将要上传的数据文件：
<form action="EXECFILEUPLOAD.action" method="post" enctype="multipart/form-data">
	<input type="file" name="upload" id="upload" size="50" />
	<input name="btnUpload" type="submit" id="btnUpload" class="button" value="数据上传" />
</form>
</body>
</html>