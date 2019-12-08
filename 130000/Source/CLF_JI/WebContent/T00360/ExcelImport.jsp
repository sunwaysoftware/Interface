<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:property value="%{getText('AppTitle')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>	
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });

		$("#uploadBtn").click(function(){
			$("#uploadBtn").hide();
			$("#imgUpload").show();
			$("#editForm").submit();
		});
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
	<form action="../xtwh/IMPORT00360.action" method="post" id="editForm" enctype="multipart/form-data">
		<input type="hidden" name="txtFilePath" value="<s:property value="fileServerPath" />" />
		<table width="700" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
				<label>文件已上传至服务器</label>
				<input type="text" name="txtFilePath" value="<s:property value="fileServerPath" />" disabled="disabled" size="50" />
				</td>
			</tr>
		</table>
	</form>
		<div class="divbottom">
		<div>
		    <span id="imgUpload" style="display:none"><img src="../scripts/easyui/themes/default/images/pagination_loading.gif"/>正在上传数据...</span>
		<a href="javascript:void(0)" id="uploadBtn"  plain="true" iconCls="icon-upload"><img src="../images/ico/upload.png" width="16" height="16" title="数据导入" alt="数据导入" />数据导入</a>
		<a href="../xtwh/VIEWT00360.action"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
		</div>
		</div>
	</div>
</td>
	</tr>
</table>
</body>
</html>