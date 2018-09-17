<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="../xtwh/FC003IMG.do" method="post" enctype="multipart/form-data">

<input type="file" id="imgFile" name="imgFile">
<input type="submit" value="提交">
</form>


<img alt="显示图片" src="<s:url action='../xtwh/VIEWFC003IMG'><s:param name='id' value='1'></s:param></s:url>"></img>



</body>
</html>