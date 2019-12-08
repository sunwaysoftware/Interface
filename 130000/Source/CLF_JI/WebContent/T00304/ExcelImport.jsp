<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:property value="%{getText('AppTitle')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<link href="../css/screen.css" rel="stylesheet" type="text/css"/>


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

	<div id="tabs" class="ui-widget-content">
        <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
            <li><a href="#INFO"><span><!-- InstanceBeginEditable name="title" -->数据上传 </span></a></li>                    
        </ul>
	<div id="INFO" class="divConect">
	<div style="min-height:400px">
<form action="../sjcj/IMPORT.action" method="post" id="editForm" enctype="multipart/form-data">
	<input type="hidden" name="txtFilePath" value="<s:property value="fileServerPath" />" />
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
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
		<a href="../xtwh/VIEWT00304.action"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
	</div>
	</div>
</div>
</div>
</td>
	</tr>
</table>
</body>
</html>