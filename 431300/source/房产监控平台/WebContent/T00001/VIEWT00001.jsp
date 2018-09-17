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

<script type="text/javascript" src="../scripts/T00001/VIEWT00001.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });

		$('#test').datagrid({
			
			striped:true,
			height:400,
			url:'xtwh/FINDT00001.action',
			queryParams:{
				ddlROOTIDFind : $("#ddlROOTIDFind").val(),
				txtINFONMFind : $("#txtINFONMFind").val(),
				txtINFOID : ''
			},
			frozenColumns:[[
				{title:'编辑',field:'edit',width:35,align:'center',formatter:function(value,rec){
					return "<a href=\"javascript:showpParentWin('[参数设置编辑]','xtwh/ADDT00001.action?ACT=U&ROOTID=" + rec.rootid + "&INFOID="+rec.infoid+"','frameCSSZBG'); \"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";

					//return "<a href=ADDT00001.action?ACT=U&ROOTID=" + rec.rootid + "&INFOID="+rec.infoid+"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
				}},
				{title:'删除',field:'del',width:35,align:'center',formatter:function(value,rec){
					return "<a href=ADDT00001.action?ACT=D&ROOTID=" + rec.rootid + "&INFOID="+rec.infoid+"><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
				}}
			]],
			columns:[[
				{title:'<s:property value="getText('app.xtwh.t00001.rootid')"/>',field:'rootid',width:100},
				{title:'<s:property value="getText('app.xtwh.t00001.rootnm')"/>',field:'rootnm',width:100},
				{title:'<s:property value="getText('app.xtwh.t00001.parentnm')"/>',field:'parentnm',width:100},
				{title:'<s:property value="getText('app.xtwh.t00001.infoid')"/>',field:'infoid',width:100},
				{title:'<s:property value="getText('app.xtwh.t00001.infonm')"/>',field:'infonm',width:100},
	            {title:'<s:property value="getText('app.xtwh.t00001.isdir')"/>',field:'isdir',width:80,align:'center',formatter:function(value,rec){
					if(value)
	            		 return $("#chkTrue").val();
	            	 else
	            		 return $("#chkFalse").val();
				}},
				{title:'<s:property value="getText('app.upddate')"/>',field:'upddate',width:150,formatter:function(value,rec){
					return formatDateTime(value);
				}},
				{title:'<s:property value="getText('app.czr')"/>',field:'czr',width:100},
				{title:'<s:property value="getText('app.note')"/>',field:'note',width:150}
			]],
			pagination:true,
			rownumbers:true
		})
	});
	function searchDate() {
		$('#test').datagrid('options').pageIndex = 1;
		var p = $('#test').datagrid('getPager');
		if (p){
			$(p).pagination({
				pageIndex : 1
			});
		}
		$('#test').datagrid('options').url='xtwh/FINDT00001.action';
		$('#test').datagrid('options').queryParams = 
	    {
			ddlROOTIDFind : $("#ddlROOTIDFind").val(),
			txtINFONMFind : $("#txtINFONMFind").val(),
			txtINFOID : ''
		};
		$('#test').datagrid('reload');		
	};
</script>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
    <div id="tabs" class="ui-tabs ui-widget ui-widget-content ui-corner-all">
   		<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.menu.CSSZ.CSSZ')}" /></span>
		</div>
			
				<div id="w" style="width:350px;height:200;padding:5px;background: #fafafa;">
				<div id="sxkz" style="display:none;">
				<form id="findForm" action="EXPT00001.action" method="post" target="_blank">
			<input type="hidden" name="chkTrue" id="chkTrue" value="<s:property value="%{getText('app.global.checkbox.true')}" />"/>
			<input type="hidden" name="chkFalse" id="chkFalse" value="<s:property value="%{getText('app.global.checkbox.false')}" />"/>
			    <table width="300" border="0" cellspacing="0" cellpadding="0">
			      <tr>
			        <td>&nbsp;<s:property value="%{getText('app.xtwh.t00001.rootnm')}" /> </td>
			        <td>&nbsp;<select name="ddlROOTIDFind" id="ddlROOTIDFind">
<!--					<option value="">全部</option>-->
					<s:iterator id="InfoEntity" value="objList" status="index">					
						<s:if test="%{ddlROOTIDFind==infoid}">
							<option selected="selected"	value="<s:property value="infoid" />">
							<s:property value="infoid" />：<s:property value="infonm" /></option>
						</s:if>
						<s:else>
							<option value="<s:property value="infoid" />">
							<s:property value="infoid" />：<s:property	value="infonm" /></option>
						</s:else>
					</s:iterator>
				</select><input type="hidden" id="txtROOTIDFind" name="txtROOTIDFind" maxlength="3" size="3" /></td>
			      </tr>
			      <tr>
			        <td>&nbsp;<s:property value="%{getText('app.xtwh.t00001.infonm')}" /> </td>
			        <td>&nbsp;<input type="text" name="txtINFONMFind" id="txtINFONMFind" value="<s:property value='txtINFONMFind' />" /></td>
			      </tr>
			    </table>
			    </form>
			    </div>
				</div>
				<div class="divtop">
                   <span><a id="subA" href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></span>
                   <span><a id="subB" href="#" class="easyui-linkbutton" plain="true" iconCls="icon-excel">导出</a></span>
                </div>
				<table id="test"></table>
			
<div class="divbottom" >
<div>

	<a href="ADDT00001.action?ACT=C" class="easyui-linkbutton" plain="true" iconCls="icon-add"><s:property value="getText('app.button.add')"/></a>
</div>
</div>
</div>
    </td>
  </tr>
</table>
</body>
</html>
