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

<script type="text/javascript" src="../scripts/ChartBzslk.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/chart/charts.js"></script>
<script type="text/javascript" src="../scripts/chart/modules/exporting.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		
		binddata();
		function binddata(){
			$('#test').datagrid({
				striped: true,
				height:250,
				url:'../xtwh/FindSCBZSLKGXBZ.action',
				sortOrder: 'desc',
				onLoadError:function(){
					$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
				},
				queryParams : 
			    {
					ddlSZQYFind : $("#ddlSZQYFind").val(),
					txtXQFind : $("#txtXQFind").val(),
					txtFWLX : $("#txtFWLX").val(),
					txtNF : $("#txtNF").val()
					
				},
				frozenColumns:[[
	    			{title:'<s:property value="%{getText('app.xtwh.bzsjgzs.sjfl')}" />',field:'rowTitle',width:150}
				]],				
				columns:[[
		            {title:'<s:property value="%{getText('app.xtwh.bzsjgzs.january')}" />',field:'month1Je',align:'right',width:100,formatter:function(value,rec){
						return '￥'+formatNumber(value,'#,##0.00');
					}},
					{title:'<s:property value="%{getText('app.xtwh.bzsjgzs.february')}" />',field:'month2Je',align:'right',width:100,formatter:function(value,rec){
						return '￥'+formatNumber(value,'#,##0.00');
					}},
					{title:'<s:property value="%{getText('app.xtwh.bzsjgzs.march')}" />',field:'month3Je',align:'right',width:100,formatter:function(value,rec){
						return '￥'+formatNumber(value,'#,##0.00');
					}},
					{title:'<s:property value="%{getText('app.xtwh.bzsjgzs.april')}" />',field:'month4Je',align:'right',width:100,formatter:function(value,rec){
						return '￥'+formatNumber(value,'#,##0.00');
					}},
					{title:'<s:property value="%{getText('app.xtwh.bzsjgzs.may')}" />',field:'month5Je',align:'right',width:100,formatter:function(value,rec){
						return '￥'+formatNumber(value,'#,##0.00');
					}},
					{title:'<s:property value="%{getText('app.xtwh.bzsjgzs.june')}" />',field:'month6Je',align:'right',width:100,formatter:function(value,rec){
						return '￥'+formatNumber(value,'#,##0.00');
					}},
					{title:'<s:property value="%{getText('app.xtwh.bzsjgzs.july')}" />',field:'month7Je',align:'right',width:100,formatter:function(value,rec){
						return '￥'+formatNumber(value,'#,##0.00');
					}},
					{title:'<s:property value="%{getText('app.xtwh.bzsjgzs.august')}" />',field:'month8Je',align:'right',width:100,formatter:function(value,rec){
						return '￥'+formatNumber(value,'#,##0.00');
					}},
					{title:'<s:property value="%{getText('app.xtwh.bzsjgzs.september')}" />',field:'month9Je',align:'right',width:100,formatter:function(value,rec){
						return '￥'+formatNumber(value,'#,##0.00');
					}},
					{title:'<s:property value="%{getText('app.xtwh.bzsjgzs.october')}" />',field:'month10Je',align:'right',width:100,formatter:function(value,rec){
						return '￥'+formatNumber(value,'#,##0.00');
					}},
					{title:'<s:property value="%{getText('app.xtwh.bzsjgzs.november')}" />',field:'month11Je',align:'right',width:100,formatter:function(value,rec){
						return '￥'+formatNumber(value,'#,##0.00');
					}},
					{title:'<s:property value="%{getText('app.xtwh.bzsjgzs.december')}" />',field:'month12Je',align:'right',width:100,formatter:function(value,rec){
						return '￥'+formatNumber(value,'#,##0.00');
					}}
			    ]],
				rownumbers:true,				
				toolbar:[{
					text:'查询',
					iconCls:'icon-search',
					handler:function(){
							$('#w').window('open');							
							$('#sxkz').show();
					}
				},{
					text:'查看统计图',
					iconCls:'icon-reload',
					handler:function(){
						$('#sxkz').show();
						$('#sxkz').show();
						searchChar();
						}
				}]
			});	
		};		
	});   
	function searchDate() {
		if(!$("#findForm").valid())
		{				
			return;
		}
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
			ddlSZQYFind : $("#ddlSZQYFind").val(),
			txtXQFind : $("#txtXQFind").val(),
			txtFWLX : $("#txtFWLX").val(),
			txtNF : $("#txtNF").val()
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
	<div class="datagrid-title">
		<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.bzfjgzs.title')}" /></span>                    
        </div>
        <div>				
						
			<div id="w" style="width:350px;height:250px;padding:5px;background: #fafafa;">
				<div id="sxkz" style="display:none;">
				<form id="findForm" action="FindSCBZSLKGXBZ.action" method="post">
				<input type="hidden" name="hidSelect" id="hidSelect" />
				<input type="hidden" name="hidSelectXQ" id="hidSelectXQ" />	
						<table width="300" border="0" cellspacing="0" cellpadding="0">
						  <tr>
						    <td>&nbsp;<s:property value="getText('app.xtwh.info.szqy')"/></td>
						    <td>&nbsp;<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" checked="ddlSZQYFind" display="全部"/>
							 </td>   
						  </tr>
						  <tr>
						    <td>&nbsp;<s:property value="getText('app.xtwh.t00303.xqmc')"/></td>
						    <td>&nbsp;<span class="txtInfonm"><input name="txtXQTIP" id="txtXQTIP" type="text" readonly="readonly" value="<s:property value="txtXQTIP"/>"/><span<s:if test='%{ACT!="D"}'> id="spXQDM"</s:if>></span></span>
							    <input type="hidden" id="txtXQFind" name="txtXQFind" value="<s:property value="txtXQFind" />"/>
							 </td>   
						  </tr>
						<tr>
						  <td>&nbsp;<s:property	value="%{getText('app.xtwh.info.fwlx')}" /></td>
    					  <td>&nbsp;<span class="txtInfonm"><input name="txtFWLXTIP" id="txtFWLXTIP" type="text" value="<s:property value="txtFWLXTIP" />" readonly="readonly" /><span id="spFWLX"></span></span><input type="hidden" id="txtFWLX" name="txtFWLX" value="<s:property value="txtFWLX" />"/></td>
						</tr>
						<tr>
						  <td>&nbsp;<s:property	value="%{getText('app.xtwh.chart.nf')}" /></td>
    					  <td>&nbsp;<input name="txtNF" id="txtNF" type="text" class="txtNumber txtfocus" value="<s:property value="SysDate" />"/>						  
						  </td>
						</tr>
						</table>
						</form>	
					</div>
				</div>					
			</div>
	<table id="test"></table>
<!-- <form id="updateform" action="UpdateSCBZSLKGXBZ.action" method="post">
	<input type="hidden" id="txtSZQYUP" name="txtSZQYUP" />
	<input type="hidden" id="txtFWLXUP" name="txtFWLXUP" />
	<input type="hidden" id="txtXQUP" name="txtXQUP" />
	挂牌数据权重比
		<input type="text" name="txtGPSJQZB" id="txtGPSJQZB" style="width:40px" class="txtNumber" value="100"/>%
	<s:property value="%{getText('app.xtwh.bzsjgzs.updmonth')}" />
		<input type="text" class="Wdatefocus" name="txtMONTHFind" id="txtMONTHFind" value="<s:property value="txtMONTHFind" />" onfocus="WdatePicker({dateFmt:'yyyyMM',onpicked: function(){getZzl();}})" />
	<s:property value="%{getText('app.xtwh.bzsjgzs.zzl')}" />	
	    <input type="text" name="txtCZLUpd" id="txtCZLUpd" style="width:80px" class="txtNumber txtfocus" value="0" />%
		<input name="btnUpdate" type="button" class="button" id="btnUpdate"	value="更新" />
		
</form> -->
<div id="appChart" style="width: 100%; height: 400px; margin: 0 auto;"></div>
    <div id="msg"></div>
</div>
<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
	  <div id="infoTreeDIV"></div>
	</div>
</td>
  </tr>
</table>
</body>
</html>
