<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<link rel="stylesheet" type="text/css" href="../css/screen.css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/T00001/VIEWT00001.js"></script>
<script type="text/javascript"	src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });				
		
		
		$('#test').datagrid({			
			striped: true,
			height: getGirdHeight(),
			url:'xtwh/FINDT00001.action',
			sortName: '',
			sortOrder: 'desc',
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
			ddlROOTIDFind : $("#ddlROOTIDFind").val(),
			txtINFONMFind : $("#txtINFONMFind").val()
			},	
			frozenColumns:[[
							{title:'操作',field:'edit',width:50,align:'center',formatter:function(value,rec){
								return "<a href=\"javascript:showpParentWin('[参数基本信息数据编辑]','xtwh/ADDT00001.action?ACT=U&ROOTID=" + rec.rootid + "&INFOID="+rec.infoid+"','frameCSJBBG'); \"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a><a href=ADDT00001.action?ACT=D&ROOTID=" + rec.rootid + "&INFOID="+rec.infoid+"><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
							}}
			 ]],
			 columns:[[	
							{title:'<s:property value="getText('app.xtwh.t00001.rootid')"/>',field:'rootid',width:80},
				            {title:'<s:property value="%{getText('app.xtwh.t00001.rootnm')}" />',field:'rootnm',width:100},
				            {title:'<s:property value="%{getText('app.xtwh.t00001.infoid')}" />',field:'infoid',width:100},
				            {title:'<s:property value="getText('app.xtwh.t00001.infonm')"/>',field:'infonm',width:150},
				            {title:'<s:property value="%{getText('app.xtwh.t00001.parentnm')}" />',field:'parentnm',width:180},	            
				            {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){return formatDateTime(value);}},
				            {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:80},
				            {title:'<s:property value="%{getText('app.xtwh.t00001.isdir')}" />',field:'isdir',width:80,formatter:function(value,rec){if(value)return '是';else return '否';}},
				            {title:'<s:property value="%{getText('app.note')}" />',field:'note',width:150}
			]],
			pagination:true,
			rownumbers:true,			
			toolbar:[{
				text:'查询',
				iconCls:'icon-search',
				handler:function(){
					$('#w').window('open');	
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
			ddlROOTIDFind : $("#ddlROOTIDFind").val(),
			txtINFONMFind : $("#txtINFONMFind").val()
		};
		$('#test').datagrid('reload');   
		
    };
</script>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0"
	class="table1">
	<tr>
		<td align="left" valign="top">
		<div class="ui-widget-content">
		<div class="datagrid-title"><span class="datagrid-title-text"><s:property
			value="%{getText('app.xtwh.t00001.title')}" /></span></div>
		
		<div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">
		<form id="findForm" action="EXPT00001.action" method="post" target="_blank">
		<table width="300" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>&nbsp;<s:property
					value="%{getText('app.xtwh.t00001.rootnm')}" /></td>
				<td><input type="hidden" id="txtROOTIDFind"
					name="txtROOTIDFind" maxlength="3" size="3" /> <select
					name="ddlROOTIDFind" id="ddlROOTIDFind">
					<option value="">全部</option>
					<s:iterator id="InfoEntity" value="objList" status="index">
						<s:if test="%{ddlROOTIDFind==infoid}">
							<option selected="selected" value="<s:property value="infoid" />">
							<s:property value="infoid" />：<s:property value="infonm" /></option>
						</s:if>
						<s:else>
							<option value="<s:property value="infoid" />"><s:property
								value="infoid" />：<s:property value="infonm" /></option>
						</s:else>
					</s:iterator>
				</select></td>
			</tr>
			<tr>
				<td>&nbsp;<s:property
					value="%{getText('app.xtwh.t00001.infonm')}" /></td>
				<td><input type="text" name="txtINFONMFind" id="txtINFONMFind"
					value="<s:property value='txtINFONMFind' />" /></td>
			</tr>
		</table>
		</form>		
		</div>
		
		<table id="test"></table>
		<div class="divbottom">
		<div><s:url id="urlAdd" action="ADDT00001">
			<s:param name="ACT">C</s:param>
		</s:url> <s:a href="%{urlAdd}">
			<img src="../images/ico/Add.gif" width="16" height="16"
				title="<s:property value="getText('app.button.add')"/>"
				alt="<s:property value="getText('app.button.add')"/>" />
			<s:property value="getText('app.button.add')" />
		</s:a></div>
		</div>
		</div>
		</td>
	</tr>
</table>
</body>

</html>
