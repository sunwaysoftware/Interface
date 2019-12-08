<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00390/VIEWT00392.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		
		binddata();
	});
	function binddata(){
		$('#test').datagrid({					
			striped: true,
			height: getGirdHeight(),
			url:'../pg/FINDT00392.action',
			sortOrder: 'desc',
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
				txtSWIDFind : $("#txtSWIDFind").val(),
				txtNSRMCFind : $("#txtNSRMCFind").val(),
				FCID : $("#txtFCIDFind").val()
			},
			frozenColumns:[[
    			{title:'操作',field:'edit',width:40,align:'center',formatter:function(value,rec){
    				return "<a href=\"javascript:printRD('" + rec.cd00302Fcid +"','"+rec.fcslh+"','"+rec.pgjg+"')\"><img title=\"交税认定\" alt='交税认定' src='../images/ico/zi.gif'/></a>"
    				//return "<a target=\"_blank\" href=javascript:Show(\'../xtwh/VIEWT003701.action?SWID=" + encodeURI(rec.cd00301Swid) + "\',300,420,'税种选择'); title='点击查看详细信息' ><img title=\"存量房交易价格申报评估结果通知单\" alt='打印' src='../images/ico/zi.gif'/></a>";
    				//return "<a target=\"_blank\" href=\" ../xtwh/VIEWT003701.action?czzt=000&txtFCID="+encodeURI(rec.cd00302Fcid)+"\">123<a>";
    				}}
    				]],
			columns:[[	    
	            {title:'<s:property value="%{getText('app.sjcj.t00302.fcid')}" />',field:'fcid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../xtwh/DETAILT00305Y.action?FCID=" + rec.cd00302Fcid + "\',300,420,'详细信息'); title='点击查看详细信息' >" + rec.cd00302Fcid + "</a>";
				}},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.swid')}" />',field:'zjhm',width:150},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.nsrmc')}" />',field:'nsrmc',width:150},
	            {title:'<s:property value="%{getText('app.sjpg.pg30002.pgczr')}" />',field:'pgCzr',width:120},
	            {title:'<s:property value="%{getText('app.xtwh.t00357.pgjg')}" />',align:'right',field:'pgjg',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}}
		    ]],
			pagination:true,
			rownumbers:true	,
			
			toolbar:[{
				text:'查询',
				iconCls:'icon-search',
				handler:function(){
						$('#w').window('open');	
				}
			}]		
		});
	};
	function searchDate() {
		$('#test').datagrid('options').pageIndex = 1;
		var p = $('#test').datagrid('getPager');
		if (p){
			$(p).pagination({
				pageIndex : 1
			});
		}
		//$('#test').datagrid('options').url='../sjcj/FINDT12001.action';
		$('#test').datagrid('options').queryParams = 
	    {	
			txtSWIDFind : $("#txtSWIDFind").val(),
			txtNSRMCFind : $("#txtNSRMCFind").val(),
			FCID : $("#txtFCIDFind").val()
		};
		$('#test').datagrid('reload');		
	};
</script>
<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
}
-->
</style>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
	<tr>
		<td align="left" valign="top">
		<div id="w2" style="width:520px;height:430px;padding:5px;background: #fafafa;">
		<iframe id="IGPG" width="100%" height="330px" frameborder="0" scrolling="no" ></iframe>
		</div>
		<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.jsrdcl.rdcl.title')}" /></span>                 
  		</div>
		
		<div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">	
		<form id="editForm" action="EXECSS30001.action" method="post">
		<input type="hidden" id="hidFlag" name="hidFlag" />
		<table width="300" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>&nbsp;<s:property value="getText('app.sjcj.t00301.swid')" /></td>
				<td>&nbsp;<input type="text" class="txtID" id="txtSWIDFind"
					name="txtSWIDFind" value="<s:property value="txtSWIDFind"/>" /></td>
			</tr>
			<tr>
				<td>&nbsp;<s:property value="getText('app.sjcj.t00301.nsrmc')" /></td>
				<td>&nbsp;<input type="text" class="txtNSRMC" id="txtNSRMCFind"
					name="txtNSRMCFind" value="<s:property value="txtNSRMCFind"/>" /></td>
			</tr>
			<tr>
		          <td>&nbsp;<s:property value="getText('app.sjcj.t00302.fcid')"/></td>
		          <td>&nbsp;<input type="text" class="txtFCID" id="txtFCIDFind" name="txtFCIDFind"/></td>
		    </tr>
		</table>
		</form>
		</div>	
		
		<table id="test"></table>		
		
		</td>
	</tr>
</table>
</body>
</html>