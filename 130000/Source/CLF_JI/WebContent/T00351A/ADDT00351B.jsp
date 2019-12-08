<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>
<link rel="stylesheet" type="text/css" href="../css/screen.css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/T00351A/ADDT00351A.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		
		$('#test').datagrid({					
			striped: true,
			height:200,
			url:'../xtwh/FINDT00351A.action',
			sortOrder: 'desc',
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
				SLID : $("#SLID").val()
			},
			frozenColumns:[[
				{title:'操作',field:'edit',width:40,align:'center',formatter:function(value,rec){
							return "<a href=EDITT00351A.action?FLAG=D&DSLID=" + rec.slid + "&SLID=" + rec.cd00351Slid + "><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
						}}
			]],
			columns:[[	   
	            {title:'<s:property value="%{getText('app.xtwh.t00351.jysj')}" />',field:'jysj',width:100,formatter:function(value,rec){
					return formatDate(value);
				}},
	            {title:'<s:property value="%{getText('app.xtwh.t00351.pfmjg')}" />',field:'pfmjg',width:180,align:'right',formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
	            {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
					return formatDateTime(value);
				}},
	            {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:80},
	            {title:'<s:property value="%{getText('app.note')}" />',field:'note',width:150}
		    ]],
			pagination:true,
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
		//$('#test').datagrid('options').url='../sjcj/FINDT12001.action';
		$('#test').datagrid('options').queryParams = 
	    {
			SLID : $("#SLID").val()
		};
		$('#test').datagrid('reload');		
	};
</script>
<style type="text/css">
<!--
.labelA {
	width:140px;
}
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
	
	<table id="test"></table>
<form id="editForm" action="EDITT00351A.action" method="post">
<input type="hidden" name="SLID" id="SLID" value="<s:property value="SLID"/>" />
<input type="hidden" name="ACT" id="ACT" value="<s:property value="ACT"/>" />
<s:if test='%{ACT!="D"}'>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td><label class="labelA">
 				<s:property value="getText('app.xtwh.t00351.jysj')"/>
			</label>
			<input name="txtJYSJ" id="txtJYSJ" type="text" onfocus="WdatePicker({date:'#F{$dp.$D(\'txtJYSJ\',null);}'})" class="Wdatefocus"/>
		</td>
	</tr>
	<tr>
		<td><label class="labelA">
  				<s:property value="getText('app.xtwh.t00351.pfmjg')"/>
			</label>
   			<input name="txtPFMJG" class="txtfocus txtNumber" id="txtPFMJG" type="text" value="<s:property value="tBean.pfmjg" default="0" />" />
		</td>
	</tr>
	<tr>
		<td><label class="labelA">
  				<s:property value="getText('app.note')"/>
			</label>
   			<textarea name="txtNOTET00351A" id="txtNOTET00351A"></textarea>
		</td>
	</tr>
</table>
<a href="javascript:AppSubmit();"><img src="../images/ico/Update.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.save')"/>" /><s:property value="getText('app.button.save')"/></a>
</s:if>
</form>
    </td>
  </tr>
</table>
</body>
</html>
