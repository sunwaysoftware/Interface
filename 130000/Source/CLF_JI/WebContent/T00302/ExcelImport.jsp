<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:property value="%{getText('AppTitle')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../scripts/WS00001/VIEWWS00001.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src='scripts/easyui/outlook.js'> </script>
<link type="text/css" rel="stylesheet" href="../css/jquery.autocomplete.css" />

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
			<span class="datagrid-title-text">数据上传</span>
		</div>
	<div id="INFO" class="divConect">
	<div style="min-height:400px">
<form action="../sjcj/SJCJIMPORT.action" method="post" id="editForm" enctype="multipart/form-data">
	<input type="hidden" name="txtFilePath" value="<s:property value="fileServerPath" />" />
	<table width="800" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			<label>文件已上传至服务器</label>
			<input type="text" name="txtFilePath" value="<s:property value="fileServerPath" />" disabled="disabled" size="50" />
			</td>
		</tr>
	</table>
</form>
	</div>
	<div class="divbottom">
	<div>
		<a href="javascript:void(0)" onclick="AppSubmit();"><img src="../images/ico/upload.png" width="16" height="16" title="数据导入" alt="数据导入" />数据导入</a>
		<a href="../sjcj/VIEWT003022.action"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
	</div>
	</div>
</div>
</div>
</td>
	</tr>
</table>
</body>
</html>