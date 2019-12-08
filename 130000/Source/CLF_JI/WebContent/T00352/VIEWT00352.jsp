<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<link rel="stylesheet" type="text/css" href="../css/screen.css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/T00352/VIEWT00352.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(function() {
	$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
	$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	
	
	$('#test').datagrid({					
		striped: true,
		height: getGirdHeight(),
		url:'../xtwh/FINDT00352.action',
		sortOrder: 'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {
			ddlSZQYFind : $("#ddlSZQYFind").val(),
			txtXqnmFind : $("#txtXqnmFind").val(),
			txtXqIdFind : $("#txtXqIdFind").val(),
			txtXqDzFind : $("#txtXqDzFind").val()
		},
		frozenColumns:[[
			{title:'操作',field:'edit',width:50,align:'center',formatter:function(value,rec){
				if (rec.xqdm!=null)
					return "<a href=\"javascript:showpParentWin('[估价分区数据编辑]','xtwh/ADDT00352.action?ACT=U&XQDM=" + rec.xqdm + "','frameGJFQBG'); \"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a><a href=ADDT00352.action?ACT=D&XQDM=" + rec.xqdm + "><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
				else
					return "";
			}},
			{title:'<s:property value="%{getText('app.xtwh.t00352.photo')}" />',field:'photo',width:35,align:'center',formatter:function(value,rec){
				return "<a href='javascript:void(0)' onclick='Show(\"../sjcj/VIEWT00352F.action?txtXQDMHM="+rec.xqdmhm+"&txtXQDM=" + rec.xqdm + "\", 425, 520,\"XQZPSC\")' ><img src=\"../images/ico/light.gif\" title=\"添加图片\" alt=\"添加图片\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
			}}
		]],
		columns:[[	    
            {title:'<s:property value="%{getText('app.xtwh.info.szqy')}" />',field:'szqy',width:120},
            {title:'<s:property value="%{getText('app.xtwh.t00303.dqmc')}" />',field:'parentnm',width:150},
            {title:'<s:property value="%{getText('app.xtwh.t00352.xqdmh')}" />',field:'xqdmh',width:100},
            {title:'<s:property value="%{getText('app.xtwh.t00352.xqmc')}" />',field:'xqnm',width:220},
            {title:'<s:property value="%{getText('app.xtwh.t00352.zldz')}" />',field:'note',width:250},
            {title:'<s:property value="%{getText('app.xtwh.t00352.dzbm')}" />',field:'xqbm',width:220},
            {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:80},
            {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
				return formatDateTime(value);
			}}
	    ]],
		pagination:true,
		rownumbers:true,
		
		toolbar:[{
			text:'查询',
			iconCls:'icon-search',
			handler:function(){
				$('#w').window('open');	
				$("#sxkz").show();
				}
			},{
				text:'导出',
				iconCls:'icon-excel',
				handler:function(){					   
					$('#findForm').submit();	
					}
			}]
	});
});

function searchDate() {
	$('#test').datagrid('options').pageIndex = 1;
	var p = $('#test').datagrid('getPager');
	if (p){
		$(p).pagination({
			pageIndex : 1
		});
	}

	$('#test').datagrid('options').queryParams = 
    {
		ddlSZQYFind : $("#ddlSZQYFind").val(),
		txtXqnmFind : $("#txtXqnmFind").val(),
		txtXqIdFind : $("#txtXqIdFind").val(),
		txtXqDzFind : $("#txtXqDzFind").val()
	};
	$('#test').datagrid('reload');		
};
</script>
<style type="text/css">
<!--

-->
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
	<div class="ui-widget-content">
	<div class="datagrid-title">
		<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00352.title')}" /></span>
	</div>
	<div id="w" style="width:350px;height:437;padding:5px;background: #fafafa;">
	<div id="sxkz" style="display:none;">
	<form id="findForm" action="../sjcx/EXPV00352.action" method="post" target="_blank">
	<input type="hidden" name="txtXqIdFind" id="txtXqIdFind" />
	<table  width="300" border="0" cellspacing="2" cellpadding="0">
		<tr>
			<td><s:property value="getText('app.xtwh.info.szqy')" /><sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部" /></td>
		</tr>
		<tr>
			<td><s:property value="getText('app.xtwh.t00352.xqmc')" /><input type="text" id="txtXqnmFind" name="txtXqnmFind" value="<s:property value="txtXqnmFind"/>" /></td>
		</tr>
		<tr>
			<td><s:property value="getText('app.xtwh.t00352.dzbm')" /><input type="text" id="txtXqDzFind" name="txtXqDzFind" value="<s:property value="txtXqDzFind"/>" /></td>
		</tr>
		<tr>
			<td valign="top"><s:property value="getText('app.xtwh.t00303.xqmc')" />
			<div class="infodiv" id="T00352Tree"></div>
			</td>
		</tr>
	</table>
	</form>
	</div>
	</div>
	<table id="test"></table>
	<div class="divbottom">
		<table cellpadding="0" cellspacing="0" style="width: 600px">
			<tr>
				<td><s:url id="urlAdd" action="ADDT00352">
					<s:param name="ACT">C</s:param>
				</s:url> <s:a href="%{urlAdd}">
					<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>" alt="<s:property value="getText('app.button.add')"/>" /><s:property value="getText('app.button.add')" />
				</s:a></td>
				<td>
				<form action="../xtwh/PGFQUPLOAD.action" method="post" id="uploadForm" enctype="multipart/form-data">
					<input type="file" name="upload" id="upload" size="50" /> 
					<input name="btnSearch" type="submit" id="btnSearch" class="button" value="上  传" />
				</form>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><span style="color: red">*注：导入数据前，请确定数据格式及内容正确！<a href="../Date/import_gjfq.xls">模板下载</a></span></td>
			</tr>
		</table>
	</div>	
</div>
    </td>
  </tr>
</table>
</body>

</html>