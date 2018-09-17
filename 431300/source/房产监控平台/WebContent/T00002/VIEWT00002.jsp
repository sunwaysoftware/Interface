<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/easyui/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/T00002/VIEWT00002.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(function() {
	$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
	$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });

	<s:if test='%{ISADMIN}'>
	getSSGX('<s:property value="txtSSGXFind"/>','#txtSSGXTIP');
	</s:if>	
	
	$('#test').datagrid({
		
		striped: true,
		height:400,
		url:'xtwh/FINDT00002.action',
		sortName: '',
		sortOrder: 'desc',	
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {
		txtUSERIDFind : $("#txtUSERIDFind").val(),
		txtUSERNMFind : $("#txtUSERNMFind").val()
		},		
		frozenColumns:[[
			{title:'初始化',field:'resetPW',align:'center',width:50,formatter:function(value,rec){
				var ISADMIN = false;
				<s:if test="%{ISADMIN}">
				ISADMIN = true;
				</s:if>
				if ('<s:property value="curUSERID"/>' != rec.userid) {
            		 if (!ISADMIN && rec.isAdmin) {
            			 return "&nbsp;";
            		 } else {
            			 return "<a href=javascript:InitPwd('"+rec.userid+"')><img src=\"../images/ico/initpssd.gif\" title=\"初始化密码\" alt=\"初始化密码\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
            		 }
				 } else {
					 return "<a href=javascript:InitPwd('"+rec.userid+"')><img src=\"../images/ico/initpssd.gif\" title=\"初始化密码\" alt=\"初始化密码\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
				 }
				
			}},
			{title:'编辑',field:'edit',align:'center',width:35,formatter:function(value,rec){
				var ISADMIN = false;
				<s:if test="%{ISADMIN}">
				ISADMIN = true;
				</s:if>
				if ('<s:property value="curUSERID"/>' != rec.userid) {
            		 if (!ISADMIN && rec.isAdmin) {
            			 return "&nbsp;";
            		 } else {
            			 return "<a href=\"javascript:editUser('" + rec.userid +"');\"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
            		 }
				 } else {
					 return "<a href=\"javascript:;\" onclick=\"editUser('" + rec.userid +"')\"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
				 }
				
			}},
			{title:'删除',field:'del',align:'center',width:35,formatter:function(value,rec){
				var ISADMIN = false;
				<s:if test="%{ISADMIN}">
				ISADMIN = true;
				</s:if>
				if ('<s:property value="curUSERID"/>' != rec.userid) {
            		 if (!ISADMIN && rec.isAdmin) {
            			 return "&nbsp;";
            		 } else {
            			 return "<a href=\"javascript:;\" onclick=\"DeleteUser('" + rec.userid +"')\"><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
            		 }
				 } else {
					 return "";
				 }
				
			}}
		]],
		columns:[[		
			{title:'<s:property value="getText('app.xtwh.t00002.userid')"/>',field:'userid',width:120},        
            {title:'<s:property value="getText('app.xtwh.t00002.usernm')"/>',field:'usernm',width:150},
            {title:'<s:property value="%{getText('app.xtwh.t00002.qx')}" />',field:'qxid',width:120,formatter:function(value,rec){
			       if(value==1)
				      return "用户管理";
			       else if(value=2)
			    	   return "查看信息";
			       else if(value=3)
			    	   return "发给房产税款信息";
			       else
			    	   return "";
			}},
            {title:'<s:property value="%{getText('app.xtwh.info.ssgx')}" />',field:'ssgx',width:200},           
			{title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
				return formatDateTime(value);
			}},
            {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:100}
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
	
	$('#test').datagrid('options').queryParams = 
    {
		txtUSERIDFind : $("#txtUSERIDFind").val(),
		txtUSERNMFind : $("#txtUSERNMFind").val()
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
	<div class="datagrid-title"><span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00002.title')}" /></span></div>
<form id="findForm" action="EXPT00002.action" method="post" target="_blank">
<input type="hidden" name="hidSelect" id="hidSelect" />
<input type="hidden" name="chkTrue" id="chkTrue" value="<s:property value="%{getText('app.global.checkbox.true')}" />"/>
<input type="hidden" name="chkFalse" id="chkFalse" value="<s:property value="%{getText('app.global.checkbox.false')}" />"/>
<input type="hidden" name="ISADMIN" id="ISADMIN" value="<s:property value="ISADMIN"/>" /> 
<input type="hidden" name="curUSERID" id="curUSERID" value='<s:property value="curUSERID" />' />
<div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">
<div id="sxkz" style="display:none;">
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
        <td>&nbsp;<s:property value="getText('app.xtwh.t00002.userid')"/></td>
        <td>&nbsp;<input type="text" id="txtUSERIDFind" name="txtUSERIDFind" /></td>
      </tr>
      <tr>
        <td>&nbsp;<s:property value="getText('app.xtwh.t00002.usernm')"/></td>
        <td>&nbsp;<input type="text" name="txtUSERNMFind" id="txtUSERNMFind" value="<s:property value="txtUSERNMFind" />" /></td>
      </tr> 
</table>
</div>	
</div>
<div class="divtop">
   <span><a id="subA" href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></span>
  </div>


<table id="test"></table>
<div id="dialog"  title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
			<div id="infoTreeDIV"></div>
		</div>	
</form>

<div class="divbottom">
<div>
<table cellpadding="0" cellspacing="0" style="width:600px">
	<tr>
	<td><a href="ADDT00002.action?ACT=C" class="easyui-linkbutton" plain="true" iconCls="icon-add"><s:property value="getText('app.button.add')"/></a></td>
</tr>
</table>
</div>
</div>
</div>
</td>
</tr>
</table>

</body>
</html>
