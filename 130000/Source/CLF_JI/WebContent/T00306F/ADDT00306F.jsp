<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/T00306F/ADDT00306F.js"></script>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/simpleTips/jquery.simpleTips-1.0.js"></script>
<link rel="stylesheet" type="text/css" href="../scripts/simpleTips/jquery.simpleTips.css" />
<script type="text/javascript">
$(function() {
	$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
	$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });

	$('#test').datagrid({
		striped:true,
		height:280,
		url:'../xtwh/FINDT00306F.action',
		sortOrder:'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答!','error');
		},
		queryParams:{
			CD00306ID : $("#CD00306ID").val()
		},
		frozenColumns:[[
			{title:'操作',field:'delete',width:35, align:'center',formatter:function(value,rec){
				//return "<a href=EDITT00306F.action?CD00306ID="+$("#CD00306ID").val()+"&ACT="+ $("#ACT").val() +"&txtXQDM="+ rec.cd00352Xqdm +"&txtZPID=" + rec.zpid + "><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
				return "<a href=\"javascript:;\" onClick=\"delPhoto('"+$('#CD00306ID').val()+"','"+$('#ACT').val()+"','"+rec.cd00352Xqdm+"','"+rec.zpid+"')\" ><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
			}}
		]],
		columns:[[
		    {title:'<s:property value="%{getText('app.xtwh.t00352.xqmc')}" />',field:'xqnm',width:100},
		    {title:'<s:property value="%{getText('app.sjcj.t00352f.zp')}" />', field:'zpljMin',align:'center',width:40,formatter:function(value,rec){
		    	var tip = "";
				return "<a target=\"_blank\" class=\"thumb\" name=\"leaf\" href=\""+rec.zpljDownLoad+"\"><img src=\"../images/ico/light.gif\" onmouseover=\"MyTip(this,'<img src="+rec.zpljMin + "\>')\" onmouseout=\"UnTip()\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
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
function searchDate(){
	$('#test').datagrid('options').pageIndex = 1;
	var p = $('#test').datagrid('getPager');
	if (p){
		$(p).pagination({
			pageIndex : 1
		});
	}
	
	$('#test').datagrid('options').queryParams = 
    {
		CD00306ID : $("#CD00306ID").val()
	};
	$('#test').datagrid('reload');		
}
</script>

<style type="text/css">
<!--
.labelA {
width:140px;
}
body {
background-color: #FFFFFF;
}
-->
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1" >
<tr>
<td align="left" valign="top">
		<div class="ui-widget-content">
		<div class="datagrid-title">
			<span class="datagrid-title-text">添加图片</span>
		</div>
		<form id="editForm" action="ADDT00306F.action" method="post" enctype="multipart/form-data">
		<input type="hidden" id="ACT" name="ACT" value="<s:property value="ACT" />" />
		<input type="hidden" id="txtXQDM" name="txtXQDM" value="<s:property value="txtXQDM" />" />
		<input type="hidden" id="txtXQDMHM" name="txtXQDMHM" value="<s:property value="txtXQDMHM" />" />
		<input type="hidden" id="CD00306ID" name="CD00306ID" value="<s:property value="CD00306ID" />" />
		<input type="hidden" id="txtZPID" name="txtZPID" value="<s:property value="txtZPID" />" />
		<input type="hidden" id="txtZPLX" name="txtZPLX" value="1" />
		<table width="500" border="0" cellspacing="3" cellpadding="0">
		<tr>
		    <td><label class="labelA">	
					<s:property value="getText('app.sjcj.t00352f.fileUpl')"/>
				</label>
			<input type='file' id='txtFile' name='txtFile' <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />&nbsp;<input type="submit" name="upBtn" class="button" value='单个图片上传'/></td>
		</tr>
		<tr>
			<td><label class="labelA">
					<s:property value="getText('app.note')"/>
				</label>
				<textarea id="txtNote" name="txtNote" rows="3" cols="25" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></textarea></td>
		</tr>
		</table>
		</form>
		<form id="delForm" action="DELPHOTOBYLF.action" method="post">
			<input type="hidden" id="txtXQDMDEL" name="txtXQDMDEL" value="<s:property value="txtXQDM" />" />
			<input type="hidden" id="txtXQDMHMDEL" name="txtXQDMHMDEL" value="<s:property value="txtXQDMHM" />" />
			<input type="hidden" id="CD00306IDDEL" name="CD00306IDDEL" value="<s:property value="CD00306ID" />" />
			<input type="submit" name="delBtn" class="button" value='删除该楼图片'/>
		</form>
			
		<table id="test"></table>
		<form id="delSimplePhotoForm" action="" method="post"></form>
	</div>
	
</td>
</tr>
</table>

</body>
</html>
