<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />

<script type="text/javascript" src="../scripts/jquery.min.js"></script>

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
    <td align="left" valign="top">
	
	<div class="ui-widget-content">
		<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.databackup.title')}" /></span>
		</div>
<form action="../xtwh/EXECBACKUP.action" method="post">
<table>
	<tr>
		<td>数据备份提示：此项功能是对数据进行<b>完全备份</b>，成功备份的数据将按日期保存在服务器的c:\DbBackup目录内。</td>
	</tr>
	<tr align="center">
		<td><input type="submit" class="button"  value="<s:property value="getText('app.xtwh.databackup.btn.backup')" />"></td>
	</tr>
</table>
</form>
</div>
    </td>
  </tr>
</table>
</body>
</html>