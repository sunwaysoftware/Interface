<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/T00004/VIEWT00004.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>


<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		
		$('#test').datagrid({
			striped: true,
			url:'xtwh/FINDT00004.action',
			sortName: '',
			sortOrder: 'desc',
			height: getGirdHeight(),
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
			txtRIGHTNMFind: $("#txtRIGHTNMFind").val()
			},
			columns:[[		
	            {title:'<s:property value="%{getText('app.xtwh.t00004.rightid')}" />',field:'rightid',width:100},
	            {title:'<s:property value="%{getText('app.xtwh.t00004.rightnm')}" />',field:'rightnm',width:300},
	            {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){return formatDateTime(value);}},
	            {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:100},
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
			txtRIGHTNMFind: $("#txtRIGHTNMFind").val()
		};
		$('#test').datagrid('reload');   
		
    };  
</script>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
<div class="ui-widget-content">
		<div class="datagrid-title"><span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00004.title')}" /></span></div>

<div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">
<form id="findForm" action="#" method="post">
	<s:property value="getText('app.xtwh.t00004.rightnm')"/>
	<input type="text" id="txtRIGHTNMFind" name="txtRIGHTNMFind" />
</form>
</div>
<table id="test"></table>
</div>
    </td>
  </tr>
</table>
</body>
</html>
