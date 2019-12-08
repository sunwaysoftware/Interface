<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}" /></title>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src='../scripts/easyui/outlook.js'> </script>
<script type="text/javascript" src="../scripts/T00384/VIEWT003840.js"></script>
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
		url:'../xtwh/VIEWT003840.action',
		sortOrder: 'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {			
			ddlSZQY:''
		},
		frozenColumns:[[
			{title:'操作',field:'edit',width:50,align:'center',formatter:function(value,rec){
				if(rec.openWinUrl!="")
					return "<a href='javascript:showParamWin(\""+rec.openWinUrl+"\");'><img title=\"未通过\" alt='未通过' src='../images/warning.gif'/></a>";
				else
					return "<img title=\"未通过\" alt='未通过' src='../images/warning.gif'/>";
			}}
		]],
		columns:[[	 
            {title:'<s:property value="%{getText('app.sjsh.t12084.shyy')}" />',field:'shyy',width:200},
            {title:'<s:property value="%{getText('app.sjsh.t12084.bxsh')}" />',field:'shmc',width:150}
	    ]],
		rownumbers:true,		
		toolbar:[{
			text:'查询',
			iconCls:'icon-search',
			handler:function(){
				$('#w').window('open');	
				$("#sxkz").show();
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
		ddlSZQY:$("#ddlSZQY").val()
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
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
     <div class="ui-widget-content">
		<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.sjsh.t00384.gjdb')}" /></span>
		</div>				
		
		<div id="w" style="width:350px;height:200;padding:5px;background: #fafafa;">
		<div id="sxkz" style="display:none;">
		<form id="findForm" action="#" method="post">
			<s:property value="getText('app.xtwh.info.szqy')"/>
			<sw:szqy items="szqyList" name="ddlSZQY" id="ddlSZQY" display="全部"/>
		</form>	
		</div>
		</div>			
		
		<table id="test" width="400px"></table>			
		</div>
  </td>
</tr>
</table>
</body>
</html>