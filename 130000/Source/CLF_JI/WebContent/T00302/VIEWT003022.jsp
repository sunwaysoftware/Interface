<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>


<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>



<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});
</script>
<style type="text/css">

.LeftText{
   margin: 3px;
   float: left;
   height: 180px;
   border: 1px solid #A6CBD9;
   background-color: #FFF;
}

.FootText{
   height: 180px;
}
.titlespan
{
 width:50px;
}
.Clear
{
   clear:both;
}
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
	<div class="ui-widget-content">
		<div class="datagrid-title">
			<span class="datagrid-title-text">数据采集导入</span>
		</div>
		<div>
		    <table cellpadding="0" cellspacing="0" style="width:600px">
				<tr>
				<td>
					<form action="../sjcj/SJCJUPLOAD.action" method="post" id="uploadForm" enctype="multipart/form-data">
						<input type="file" name="upload" id="upload" size="50" />
						<input name="btnUpd" type="submit" id="btnUpd" class="button" value="上  传" />
					</form>
				</td>
				</tr>
				<tr>		
				<td ><span style="color:red">*注：导入数据前，请确定数据格式及内容正确！</span><a href="../Date/import_kbsl.xls">模板下载</a></td>
				</tr>
			</table>
		</div>
</div>
    </td>
  </tr>
</table>
</body>
</html>
