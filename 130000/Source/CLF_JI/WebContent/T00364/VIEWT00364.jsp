<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<link rel="stylesheet" type="text/css" href="../css/screen.css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/T00364/VIEWT00364.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
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
			url:'../xtwh/FINDT00364.action',
			sortOrder: 'desc',
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
				ddlSZQYFind:$("#ddlSZQYFind").val()
			},
			frozenColumns:[[
				{title:'操作',field:'edit',width:70,align:'center',formatter:function(value,rec){
					return "<a href=\"javascript:showpParentWin('[分区估价值数据编辑]','xtwh/ADDT00364.action?ACT=U&SZQY=" + rec.cd00001Szqy +"','framePGZBG'); \"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;<a href=ADDT00364.action?ACT=D&&SZQY=" + rec.cd00001Szqy +"><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
					
					}}
			]],
			columns:[[	      
				{title:'<s:property value="%{getText('app.xtwh.info.szqy')}" />',field:'szqy',width:80},
	            {title:'<s:property value="%{getText('app.xtwh.t00364.xzxs')}" />',field:'xzxs',width:120,align:'right',formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
				{title:'<s:property value="%{getText('app.xtwh.t00364.pgxzxs')}" />',field:'pgxzxs',width:120,align:'right',formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},	
	            {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
					return formatDateTime(value);
				}},
	            {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:80},
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
		
		$('.rootCheck').click(function(){
			$(".childCheck").each(function(){
				$(this)[0].checked=$('.rootCheck')[0].checked;
			});
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
		//$('#test').datagrid('options').url='../sjcj/FINDT12001.action';
		$('#test').datagrid('options').queryParams = 
	    {
			ddlSZQYFind:$("#ddlSZQYFind").val()
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
			<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00364.title')}" /></span>
		</div>
		<div id="INFO" class="divConect">
		
		<div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">
		<form id="findForm" action="#" method="post">
		<input type="hidden" name="hidSelect" id="hidSelect" />
		<table width="300" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td>&nbsp;<s:property value="getText('app.xtwh.info.szqy')"/></td>
		    <td>&nbsp;<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/></td>
		  </tr>
		</table>
		</form>
		</div>
		
		<table id="test"></table>
		<div class="divbottom">
		<div>
			<s:url id="urlAdd" action="ADDT00364"><s:param name="ACT">C</s:param></s:url>
			<s:a href="%{urlAdd}">
				<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>" alt="<s:property value="getText('app.button.add')"/>" /><s:property value="getText('app.button.add')"/>
			</s:a>
		</div>
		
		</div>
	</div>
	</div>
    </td>
  </tr>
</table>
</body>
</html>