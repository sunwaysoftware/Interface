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
<script type="text/javascript" src="../scripts/V00302A/VIEWV00302A.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>

<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<link href="../css/jquery.autocomplete.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>


<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });

		$('#test').datagrid({
			striped: true,
			url:'../sjcx/FINDV00302A.action',
			sortName: '',
			sortOrder: 'desc',
			height:400,
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams :
			{
				txtFCIDFind : $("#txtFCIDFind").val(),
				txtSWIDFind : $("#txtSWIDFind").val(),
				txtNSRMCFind : $("#txtNSRMCFind").val(),
				txtFDCDATFind : $("#txtFDCDATFind").val(),
				ddlSZQYFind : $("#ddlSZQYFind").val(),
				txtXQFind : $("#txtXQFind").val(),
				txtFWTDZLFind : $("#txtFWTDZLFind").val(),
				pageIndex : $("#pageindex").val()
				},
			frozenColumns:[[
				{title:'操作',field:'detail',width:100,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../sjcx/VIEWV00301AFRAME.action?CZH=" + rec.czh + "\',600,800,'czh');><img src=\"../images/info.gif\" title=\"详细\" alt=\"详细\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
				}}
			]],
			columns:[[		
	            {title:'<s:property value="%{getText('app.xtwh.info.szqy')}" />',field:'szqy',width:100},

	            {title:'<s:property value="%{getText('app.sjcj.t00302.fcid')}" />',field:'fcid',width:150,formatter:function(value,rec){
  			            return "<a href=javascript:Show('DETAILV00302A.action?FCID=" + encodeURI(rec.fcid) + "',200,420,'市场法登记详细信息'); title='点击查看详细信息' >" + rec.fcid + "</a>";
  			            }},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.swid')}" />',field:'cd00301aSwid',width:150},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.nsrmc')}" />',field:'nsrmc',width:120},
	            {title:'<s:property value="%{getText('app.xtwh.t00303.xqmc')}" />',field:'xqnm',width:100},
	            {title:'<s:property value="%{getText('app.xtwh.t00303.zcdzl')}" />',field:'fwtdzl',width:150},
	            {title:'<s:property value="%{getText('app.xtwh.info.fwlx')}" />',field:'fwlx',width:80},
	            {title:'<s:property value="%{getText('app.xtwh.info.jylx')}" />',field:'jylx',width:80},
	            {title:'<s:property value="%{getText('app.xtwh.info.jzjg')}" />',field:'jzjg',width:120},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.jzmj')}" />',field:'jzmj',width:100,align:'right'},
	            {title:'<s:property value="%{getText('app.xtwh.info.fwcx')}" />',field:'fwcx',width:80},
	            {title:'<s:property value="%{getText('app.xtwh.info.cgzk')}" />',field:'cgzk',width:80},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.szlc')}" />',field:'szlc',width:80,align:'right'},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.bwjfh')}" />',field:'bwjfh',width:80},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.jyjg')}" />',field:'jyjg',width:100,align:'right'},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.dtgj')}" />',field:'dtgj',width:100,align:'right'},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.tdsyqmj')}" />',field:'tdsyqmj',width:100,align:'right'},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.rjl')}" />',field:'rjl',width:80,align:'right'},
	            {title:'<s:property value="getText('app.sjcj.t00302.jysj')"/>',field:'jysj',width:100},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.fdcdat')}" />',field:'fdcdat',width:120},
	            {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){return formatDateTime(value);}},
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
			txtFCIDFind : $("#txtFCIDFind").val(),
			txtSWIDFind : $("#txtSWIDFind").val(),
			txtNSRMCFind : $("#txtNSRMCFind").val(),
			txtFDCDATFind : $("#txtFDCDATFind").val(),
			ddlSZQYFind : $("#ddlSZQYFind").val(),
			txtXQFind : $("#txtXQFind").val(),
			txtFWTDZLFind : $("#txtFWTDZLFind").val(),
			pageIndex : $("#pageindex").val()
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
		<span class="datagrid-title-text"><s:property value="%{getText('app.sjcx.v00302A.title')}" /></span>
	</div>

<div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">
<form id="findForm" action="#" method="post">
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>&nbsp;<s:property value="getText('app.sjcj.t00302.fcid')"/></td>
    <td>&nbsp;<input type="text" class="txtID" id="txtFCIDFind" name="txtFCIDFind"/></td>
  </tr>
  <tr>
    <td>&nbsp;<s:property value="getText('app.sjcj.t00301.swid')"/></td>
    <td>&nbsp;<input type="text" class="txtID" id="txtSWIDFind" name="txtSWIDFind"/></td>
  </tr>
  <tr>
    <td>&nbsp;<s:property value="getText('app.sjcj.t00301.nsrmc')"/></td>
    <td>&nbsp;<input type="text" class="txtNSRMC" id="txtNSRMCFind" name="txtNSRMCFind"/></td>
  </tr>
  <tr>
    <td>&nbsp;<s:property value="getText('app.sjcj.t00302.fdcdat')"/></td>
    <td>&nbsp;<input type="text" class="txtID" id="txtFDCDATFind" name="txtFDCDATFind"/></td>
  </tr>
  <tr>
    <td>&nbsp;<s:property value="getText('app.xtwh.info.szqy')"/></td>
    <td>&nbsp;<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/></td>
  </tr>
  <tr>
    <td>&nbsp;<s:property value="getText('app.xtwh.t00303.xqmc')"/></td>
    <td>&nbsp;<input type="hidden" class="txtCode" id="txtXQFind" name="txtXQFind" value="<s:property value="txtXQFind" />"/>
    <input name="txtXQTIP" class="txtInfonm" id="txtXQTIP" type="text" readonly="readonly"/>
    </td>
  </tr>
  <tr>
    <td>&nbsp;<s:property value="getText('app.xtwh.t00303.zcdzl')"/></td>
    <td>&nbsp;<input type="text" id="txtFWTDZLFind" name="txtFWTDZLFind" value="<s:property value="txtFWTDZLFind"/>" /></td>
  </tr>
</table>
</form>
</div>
  	
  <div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
    <div id="infoTreeDIV"></div>
  </div>


<table id="test"></table>
</div>
    </td>
  </tr>
</table>
</body>
</html>
