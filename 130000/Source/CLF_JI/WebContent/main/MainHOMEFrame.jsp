<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
</head>
<frameset id="Pz_Leftframe" rows="*" cols="*" framespacing="0" frameborder="no" border="0">
  <frame src="../main/HOMEMAIN.action" name="mainFrame" scrolling="auto" noresize="noresize" id="mainFrame" title="<s:property value="%{getText('app.menuMain')}" />" />
</frameset>
<noframes><body>
</body></noframes>
</html>
