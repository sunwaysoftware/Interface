<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="scripts/jquery.min.js"></script>
<script type="text/javascript">
function flashpage()
{
	$("#bottomFrame").attr("src","main/HOMEFrame.action");
	$("#bottomFrame")[0].contentWindow.location.reload();	   
};
</script>
</head>
<frameset rows="75,*" id="Pz_frame" cols="*" framespacing="0" frameborder="no" border="0">
  <frame src="TOPSSGXLIST.action" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
  <frame src="main/HOMEFrame.action" name="bottomFrame" scrolling="auto" noresize="noresize" id="bottomFrame" title="mainFrame" />
</frameset>
<noframes><body>
</body></noframes>
</html>
