<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../scripts/WS00001/VIEWWS00001.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src='scripts/easyui/outlook.js'> </script>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<link type="text/css" rel="stylesheet" href="../css/jquery.autocomplete.css" />
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		
		$('#test').datagrid({
			striped: true, 
			height: getGirdHeight(),
			url:'../sjcj/FINDTWS00001.action',
			sortOrder: 'desc',
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
				txtFCSLHFIND : $("#txtFCSLHFIND").val(),
				txtCLHFIND : $("#txtCLHFIND").val(),
				txtFHFIND : $("#txtFHFIND").val()
			},
			frozenColumns:[[
				{title:'提取',field:'edit',width:50,align:'center',formatter:function(value,rec){
					if (rec.fcid!=null)
						//return "<a href=\"javascript:showParamWin('sjcj/ADDT00302XML.action?ddlBGLX=0&ACT=U&FCID=" + rec.fcid + "')\"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
						return "<a href=\"../sjcj/ADDT00302XML.action?ddlBGLX=0&ACT=C&FCID="+ rec.fcid +"\"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>"; 
					else
						return "";
				}}
			]],
			columns:[[		        
	            {title:'<s:property value="%{getText('app.ws.fcslh')}" />',field:'FCSLH',width:100},
	            {title:'<s:property value="%{getText('app.ws.yfczh')}"/>',field:'YFCZH',width:100},
	            {title:'<s:property value="%{getText('app.ws.zrfsflx')}"/>',field:'ZRFSFLX',width:130},
	            {title:'<s:property value="%{getText('app.ws.zrfsfid')}"/>',field:'ZRFSFID',width:150},
	            {title:'<s:property value="%{getText('app.ws.zrfmc')}"/>',field:'ZRFMC',width:150},
	            {title:'<s:property value="%{getText('app.ws.csfsflx')}"/>',field:'CSFSFLX',width:150},
	            {title:'<s:property value="%{getText('app.ws.csfsfid')}"/>',field:'CSFSFID',width:150},
	            {title:'<s:property value="%{getText('app.ws.csfmc')}"/>',field:'CSFMC',width:150},
	            {title:'<s:property value="%{getText('app.ws.clh')}" />',field:'CLH',width:100},
	            {title:'<s:property value="%{getText('app.ws.sjyt')}"/>',field:'SJYT',width:100},
	            {title:'<s:property value="%{getText('app.ws.lfdz')}" />',field:'LFDZ',width:300},
	            {title:'<s:property value="%{getText('app.ws.fh')}" />',field:'DYFH',width:50},
	            {title:'<s:property value="%{getText('app.ws.szlc')}"/>',field:'SZLC',width:50},
	            {title:'<s:property value="%{getText('app.ws.zlc')}"/>',field:'ZLC',width:50},
	            {title:'<s:property value="%{getText('app.ws.jzjg')}"/>',field:'JZJG',width:150},
	            {title:'<s:property value="%{getText('app.ws.fwlx')}"/>',field:'FWLX',width:150},
	            {title:'<s:property value="%{getText('app.ws.jylx')}"/>',field:'JYLX',width:150},
	            {title:'<s:property value="%{getText('app.ws.jzmj')}"/>',field:'JZMJ',align:'right',width:150,formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
	            {title:'<s:property value="%{getText('app.ws.htzj')}"/>',field:'HTZJ',align:'right',width:150,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}},
	            {title:'<s:property value="%{getText('app.ws.jysj')}"/>',field:'JYSJ',width:100,formatter:function(value,rec){
					return formatDate(value);
				}},
	            {title:'<s:property value="%{getText('app.ws.fzrq')}"/>',field:'FZRQ',width:200,formatter:function(value,rec){
					return formatDate(value);
				}},
	            {title:'<s:property value="%{getText('app.ws.df')}"/>',field:'DF',width:100},
	            {title:'<s:property value="%{getText('app.ws.cx')}"/>',field:'CX',width:100},
	            {title:'<s:property value="%{getText('app.ws.cg')}"/>',field:'CG',width:100},
	            {title:'<s:property value="%{getText('app.ws.yjg')}"/>',field:'YJG',width:100,align:'right',width:150,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}},
	            {title:'<s:property value="%{getText('app.ws.pgjg')}"/>',field:'PGJG',width:100,align:'right',width:150,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}},
	            {title:'<s:property value="%{getText('app.ws.sfsyfc')}"/>',field:'sfsyfcmc',width:150},
	            {title:'<s:property value="%{getText('app.ws.note')}"/>',field:'NOTE',width:100}
	          
		    ]],
			pagination:true,
			rownumbers:true,
			
			toolbar:[
				{
					text:'查询',
					iconCls:'icon-search',
					handler:function(){
							$('#w').window('open');	
					}
 				}
 				,
				{
					text:'受理',
					iconCls:'icon-ok',
					handler:function(){
							$("#SLSign").val("XT");
							$('#w1').window('open');
					}
				}

			]
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
			txtFCSLHFIND : $("#txtFCSLHFIND").val(),
			txtCLHFIND : $("#txtCLHFIND").val(),
			txtFHFIND : $("#txtFHFIND").val()
		};
		$('#test').datagrid('reload');		
    };

    		
    
</script>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
     <div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:300px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>
	<div class="ui-widget-content">
	<div class="datagrid-title">
		<span class="datagrid-title-text">				
	          <s:property value="%{getText('app.ws.title')}" />
	    </span>
	</div>

  <div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">
  <form id="findForm" action="#" method="post">
  <input type="hidden" name="ACT" id="ACT" value="<s:property value="ACT" />" />
  <table width="300" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>&nbsp;<s:property value="%{getText('app.ws.fcslh')}"/></td>
    <td>&nbsp;<input type="text" class="txtID" id="txtFCSLHFIND" name="txtFCSLHFIND"  value="<s:property value='txtFCSLH' />" /></td>
  </tr>
  <tr>
  	<td>&nbsp;<s:property value="%{getText('app.ws.clh')}" /></td>
  	<td>&nbsp;<input type="text" id="txtCLHFIND" name="txtCLHFIND" /></td>
  </tr>
  <tr>
  	<td>&nbsp;<s:property value="%{getText('app.ws.fh')}" /></td>
  	<td>&nbsp;<input type="text" id="txtFHFIND" name="txtFHFIND" /></td>
  </tr>
</table> 
</form>
  </div>

<div id="w1" style="width:350px;height:200px;padding:5px;background: #fafafa;">
  	<form id="subXML" action="#" method="post">
  	<input type="hidden" name="SLSign" id="SLSign" />
  	<table width="300" border="0" cellspacing="0" cellpadding="0">
  		<tr>
  			<td>&nbsp;<s:property value="%{getText('app.ws.fcslh')}"/></td>
    		<td>&nbsp;<input type="text" class="txtID" id="txtFCSLH" name="txtFCSLH"  value="<s:property value='txtFCSLH' />" /></td>
  		</tr>
  	</table>
  	</form>
</div>
<div id="w2" style="width:350px;height:200px;padding:5px;background: #fafafa;">
	<input type="hidden" id="isVal" />
	<table width="300" border="0" cellspacing="0" cellpadding="0">
  		<tr>
  			存在重复数据，是否替换？
  		</tr>
  	</table>
</div>
<table id="test"></table>
</div>
    </td>
  </tr>
</table>
</body>
</html>
