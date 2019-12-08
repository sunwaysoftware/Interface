<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<link type="text/css" href="../css/screen.css" rel="stylesheet" />
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/T00384/VIEWT00384.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(function() {
	$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
	$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });

	$('#test').datagrid({
		striped: true,
		height: getGirdHeight(),
		url:'../xtwh/VIEWT003842.action',
		sortOrder: 'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {			
			fcId : '<s:property value="txtSWIDFind" />'
		},
		frozenColumns:[[
			{title:'操作',field:'edit',width:50,align:'center',formatter:function(value,rec){
				return "<img title=\"未通过\" alt='未通过' src='../images/warning.gif'/>";
			}}
		]],
		columns:[[	 
            {title:'<s:property value="%{getText('app.sjsh.t12084.shyy')}" />',field:'shyy',width:100},
            {title:'<s:property value="%{getText('app.sjsh.t12084.bxsh')}" />',field:'shmc',width:150}
	    ]],	
		rownumbers:true
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
		fcId : '<s:property value="txtSWIDFind" />'
	};
	$('#test').datagrid('reload');		
};
</script>
<style type="text/css">
<!--
.bg {
	background-color: #999;
}
-->
</style>

</head>
<body>
<input type="hidden" name="txtSWID" id="txtSWID" value="<s:property value="txtSWIDFind" />" />

<fieldset>
	<legend>【未过原因】<s:property value="%{getText('app.sjcj.t00302.fcid')}" />：<span id="fcid"></span></legend>
	<table id="test" width="400px"></table>	
</fieldset>
</body>
</html>