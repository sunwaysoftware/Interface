<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/screen.css" />
<link rel="stylesheet" type="text/css"
	href="../scripts/simpleTips/jquery.simpleTips.css" />
<link rel="stylesheet" type="text/css"
	href="../scripts/swfupload/css/default.css" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript"
	src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript"
	src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript"
	src="../scripts/simpleTips/jquery.simpleTips-1.0.js"></script>

<script type="text/javascript" src="../scripts/swfupload/swfupload.js"></script>
<script type="text/javascript"
	src="../scripts/swfupload/swfupload.queue.js"></script>
<script type="text/javascript" src="../scripts/T00352F/fileprogress.js"></script>
<script type="text/javascript" src="../scripts/T00352F/ADDT00352F.js"></script>

<script type="text/javascript">
$(function() {
	$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
	$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	
	$('#test').datagrid({
		striped:true,
		height:280,
		url:'../sjcj/FINDT00352F.action',
		sortOrder:'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答!','error');
		},
		queryParams:{
			txtXQDM : $("#txtXQDM").val(),
			txtXQDMHM : $("#txtXQDMHM").val()
		},
		frozenColumns:[[
			{title:'操作',field:'delete',width:35, align:'center',formatter:function(value,rec){
				//return "<a href=EDITT00352F.action?ACT="+ $("#ACT").val() +"&txtXQDM="+ rec.cd00352xqdm +"&txtZPID=" + rec.zpid + "><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
				return "<a href=\"javascript:;\" onClick=\"delPhoto('"+$('#ACT').val()+"','"+rec.cd00352xqdm+"','"+rec.zpid+"')\" ><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
			}}
		]],
		columns:[[
		    {title:'<s:property value="%{getText('app.xtwh.t00352.xqmc')}" />',field:'xqnm',width:150},
		    {title:'<s:property value="%{getText('app.sjcj.t00352f.zp')}" />', field:'zpljMin',align:'center',width:40,formatter:function(value,rec){
		    	var tip = "";
				return "<a target=\"_blank\" class=\"thumb\" name=\"leaf\" href=\"" + rec.zpLjdownLoad + "\"><img src=\"../images/ico/light.gif\" onmouseover=\"MyTip(this,'<img src="+rec.zpljMin + "\>')\" onmouseout=\"UnTip()\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
			}},		   
		    {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
				return formatDateTime(value);
			}},
			{title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:100},
			{title:'<s:property value="%{getText('app.note')}" />',field:'note',width:150}
		]],
		//pagination:true,
		rownumbers:true
	});
});
</script>

</head>
<body>
	<table border="0" align="left" cellpadding="0" cellspacing="0"
		class="table1">
		<tr>
			<td align="left" valign="top">
				<div class="ui-widget-content">
					<div class="datagrid-title">
						<span class="datagrid-title-text">添加图片</span>
					</div>
					<form id="editForm" action="ADDT00352F.action" method="post"
						enctype="multipart/form-data">
						<input type="hidden" id="ACT" name="ACT"
							value="<s:property value="ACT" />" /> <input type="hidden"
							id="txtXQDM" name="txtXQDM"
							value="<s:property value="txtXQDM" />" /> <input type="hidden"
							id="txtXQDMHM" name="txtXQDMHM"
							value="<s:property value="txtXQDMHM" />" />
						<div>
							<div style="padding-left: 5px;">
								<span id="spanButtonPlaceholder"></span> <input id="btnCancel"
									type="button" value="Cancel Uploads"
									onclick="cancelQueue(upload);" disabled="disabled"
									style="margin-left: 2px; height: 22px; font-size: 8pt;" /> <br />
							</div>
							<div class="fieldset flash" id="fsUploadProgress">
								<span class="legend">上传列表</span>
							</div>
						</div>
					</form>
					<form id="delForm" action="DELPHOTOBYXQ.action" method="post">
						<input type="button" id="btnReload" value="刷新表格数据" /> <input
							type="hidden" id="txtXQDMDEL" name="txtXQDMDEL"
							value="<s:property value="txtXQDM" />" /> <input type="hidden"
							id="txtXQDMHMDEL" name="txtXQDMHMDEL"
							value="<s:property value="txtXQDMHM" />" /> <input type="submit"
							name="delBtn" class="button" value='删除该小区图片' />
					</form>
					<table id="test"></table>
					<form id="delSimplePhotoForm" action="" method="post"></form>
				</div>
			</td>
		</tr>
	</table>

</body>
</html>
