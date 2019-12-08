<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});
</script>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td height="100" align="left" valign="top">
	
    <form action="#" method="post" id="PssdForm">
       <s:property value="getText('app.xtwh.t00001.pssd')"/>:<input type="text" name="txtPSSD" id="txtPSSD" onfocus="WdatePicker({enableKeyboard:false})" class="Wdatefocus" value="<s:property value="t00002Bean.pssdymd" />"/>
       <input type="submit" name="btnSET" id="btnSET" value="设置" class="button"/>
    </form>
    </td>
  </tr>
</table>
</body>
</html>
