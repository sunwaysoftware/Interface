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
<form action="" method="post">
<table>
<tr>
	<td>文件以上传至服务器：</td>
	<td><input type="text" name="txtFilePath" id="txtFilePath" readonly="readonly" size="50" value="<s:property value="filePath" />"/></td>
</tr>
<tr>
	<td>
		<s:property value="getText('app.xtwh.fileupload.table')"/>
	</td>
	<td>
		<select>
			<option value="">请选择</option>
			<option value="1">参数基本信息</option>
			<option value="303">楼房普查数据(幢)</option>
		</select>	
	</td>
</tr>
<tr>
	<td align="right" colspan="2"><input type="submit" value="导入数据" class="button" /></td>
</tr>
</table>
</form>
</body>
</html>