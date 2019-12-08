<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/T00002/VIEWT00002.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
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
			height: getGirdHeight(),
			url:'xtwh/FINDT00002.action',
			sortName: '',
			sortOrder: 'desc',	
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
			txtUSERIDFind : $("#txtUSERIDFind").val(),
			txtUSERNMFind : $("#txtUSERNMFind").val(),
			txtSSGXFind : $("#txtSSGXFind").val()
			},		
			frozenColumns:[[
				{title:'操作',field:'edit',align:'center',width:60,formatter:function(value,rec){
					var ISADMIN = false;
					<s:if test="%{ISADMIN}">
					ISADMIN = true;
					</s:if>
					if ('<s:property value="curUSERID"/>' != rec.userid) {
	            		 if (!ISADMIN && rec.isAdmin) {
	            			 return "&nbsp;";
	            		 } else {
	            			 return "<a href=javascript:InitPwd('"+rec.userid+"')><img src=\"../images/ico/initpssd.gif\" title=\"初始化密码\" alt=\"初始化密码\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a><a href=\"javascript:editUser('" + rec.userid +"');\"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a><a href=\"javascript:;\" onclick=\"DeleteUser('" + rec.userid +"')\"><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
	            		 }
					 } else {
						 return "<a href=javascript:InitPwd('"+rec.userid+"')><img src=\"../images/ico/initpssd.gif\" title=\"初始化密码\" alt=\"初始化密码\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a><a href=\"javascript:editUser('" + rec.userid +"');\"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
					 }
					
				}}
			]],
			columns:[[		
				{title:'<s:property value="getText('app.xtwh.t00002.userid')"/>',field:'userid',width:80,formatter:function(value,rec){
            		return "<a href=javascript:Show(\'DETAILT00002.action?pageIndex=1&USERID=" + rec.userid + "\',300,420,'userid'); title='点击查看详细信息' >" + rec.userid + "</a>";
           		 
				}},        
	            {title:'<s:property value="getText('app.xtwh.t00002.usernm')"/>',field:'usernm',width:150},
	            {title:'<s:property value="%{getText('app.xtwh.t00002.userip')}" />',field:'userip',width:120},
	            {title:'<s:property value="%{getText('app.xtwh.info.ssgx')}" />',field:'ssgx',width:120},
	            {title:'<s:property value="getText('app.xtwh.t00002.phone')"/>',field:'phone',width:100},
	            {title:'<s:property value="%{getText('app.xtwh.t00002.isadmin')}" />',field:'isAdmin',width:100,align:'center',formatter:function(value,rec){
	            	if(value)
	            		 return $("#chkTrue").val();
	            	 else
	            		 return $("#chkFalse").val();;
				}},
	            {title:'<s:property value="%{getText('app.xtwh.t00002.islocked')}" />',field:'islockedout',width:80,align:'center',formatter:function(value,rec){
					if(value)
	            		 return $("#chkTrue").val();
	            	 else
	            		 return $("#chkFalse").val();;
				}},
	            {title:'<s:property value="%{getText('app.xtwh.t00002.failedcount')}" />',field:'failedpwdattemptcount',width:100,align:'right'},
	            {title:'<s:property value="getText('app.xtwh.t00002.lastlockedoutdate')"/>',field:'lastlockedoutdate',width:150,formatter:function(value,rec){
					return formatDateTime(value);
				}},
	            {title:'<s:property value="%{getText('app.xtwh.t00002.lastlogindate')}" />',field:'lastlogindate',width:150,formatter:function(value,rec){
		            return formatDateTime(value);
				}},
	            {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:100},
	            {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
					return formatDateTime(value);
				}}
		        ]],
			pagination:true,
			rownumbers:true,
			
			toolbar:[{
				text:'查询',
				iconCls:'icon-search',
				handler:function(){
					$('#w').window('open');	
					}
				},{
					text:'导出',
					iconCls:'icon-excel',
					handler:function(){					   
						$('#findForm').submit();	
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
		
		$('#test').datagrid('options').queryParams = 
	    {
			txtUSERIDFind : $("#txtUSERIDFind").val(),
			txtUSERNMFind : $("#txtUSERNMFind").val(),
			txtSSGXFind : $("#txtSSGXFind").val()
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

    <div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">
    <form id="findForm" action="EXPT00002.action" method="post" target="_blank">
	<input type="hidden" name="chkTrue" id="chkTrue" value="<s:property value="%{getText('app.global.checkbox.true')}" />"/>
	<input type="hidden" name="chkFalse" id="chkFalse" value="<s:property value="%{getText('app.global.checkbox.false')}" />"/>
	<input type="hidden" name="ISADMIN" id="ISADMIN" value="<s:property value="ISADMIN"/>" /> 
	<input type="hidden" name="hidSelect" id="hidSelect" />
	    <table border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="70"><s:property value="getText('app.xtwh.t00002.userid')"/></td>
	        <td><input type="text" id="txtUSERIDFind" name="txtUSERIDFind" /></td>
	      </tr>
	      <tr>
	        <td><s:property value="getText('app.xtwh.t00002.usernm')"/></td>
	        <td><input type="text" name="txtUSERNMFind" id="txtUSERNMFind" value="<s:property value="txtUSERNMFind" />" /></td>
	      </tr>
	      <tr>
	        <td><s:property value="getText('app.xtwh.info.ssgx')" /></td>
	        <td><input type="hidden"  id="txtSSGXFind" name="txtSSGXFind" value="<s:property value="txtSSGXFind" />"/>
		  <span class="txtInfonm"><input type="text" id="txtSSGXTIP" name="txtSSGXTIP" /><span id="spSSGX"></span></span>
		  <s:if test='%{txtSSGXFind != null}'><script type="text/javascript">getSSGX('<s:property value="txtSSGXFind" />','#txtSSGXTIP')</script></s:if>
		  </td>
	      </tr>
	    </table>
	    </form>
	</div>	
	<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>	
	

<table id="test"></table>
<div class="divbottom">
<div>
	<s:url id="urlAdd" action="ADDT00002"><s:param name="ACT">C</s:param></s:url>
	<s:a href="%{urlAdd}">
		<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>" alt="<s:property value="getText('app.button.add')"/>" /><s:property value="getText('app.button.add')"/>
	</s:a>
</div>
</div>
</div>
</td>
  </tr>
</table>

</body>
</html>
