<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/jquery.autocomplete.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="../scripts/T00303/VIEWT00303.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
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
		height:400,
		url:'../xtwh/FINDT00303.action',
		sortOrder: 'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {
			ddlSZQYFind : $("#ddlSZQYFind").val(),
			txtXQFind : $("#txtXQFind").val(),
			txtFWTDZLFind : $("#txtZCDZL").val()
		},
		frozenColumns:[[
			{title:'操作',field:'edit',width:60,align:'center',formatter:function(value,rec){
				if (rec.lfid!=null)
					return "<a href=\"javascript:showpParentWin('[楼房普查数据编辑]','xtwh/ADDT00303.action?ACT=U&LFID=" + rec.lfid +"','frameLFPCBG'); \"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a><a href=ADDT00303.action?ACT=D&LFID=" + rec.lfid +"><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
				else
					return "";
			}}
		]],
		columns:[[	
            {title:'<s:property value="%{getText('app.xtwh.info.szqy')}" />',field:'szqy',width:100},
            {title:'<s:property value="%{getText('app.xtwh.t00303.clh')}" />',field:'clh',width:100},
            {title:'<s:property value="%{getText('app.sjpg.t00331.fwtdzl')}" />',field:'fwtdzl',width:200},
            {title:'<s:property value="%{getText('app.xtwh.t00303.xqmc')}" />',field:'xqnm',width:200},
            {title:'<s:property value="%{getText('app.xtwh.t00303.zlc')}" />',field:'zlc',width:80},
            {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
				return formatDateTime(value);
			}},
            {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:80},
            {title:'<s:property value="%{getText('app.note')}" />',field:'note',width:120}
	    ]],
		pagination:true,
		rownumbers:true,		
		toolbar:[{
			text:'查询',
			iconCls:'icon-search',
			handler:function(){
					$('#w').window('open');	
					$("#sxkz").show();
					}
			},{
				text:'导出',
				iconCls:'icon-excel',
				handler:function(){
				$('#findForm').submit();
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
	//$('#test').datagrid('options').url='../sjcj/FINDT12001.action';
	$('#test').datagrid('options').queryParams = 
    {
		ddlSZQYFind : $("#ddlSZQYFind").val(),
		txtXQFind : $("#txtXQFind").val(),
		txtFWTDZLFind : $("#txtZCDZL").val()
	};
	$('#test').datagrid('reload');		
};
</script>
<style type="text/css"><!--

.LeftText{
   margin: 3px;
   float: left;
   height: 180px;
   border: 1px solid #A6CBD9;
   background-color: #FFF;
}

.FootText{
   height: 180px;
}
.titlespan
{
 width:50px;
}
.Clear
{
   clear:both;
}
--></style>

</head>
<body>
<div class="ui-widget-content">
<div class="datagrid-title">
	<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00303.title')}" /></span>                 
</div>
</div>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
	
		<div id="w" style="width:350px;height:437px;padding:5px;background: #fafafa;">
		<div id="sxkz" style="display:none;">
		<form id="findForm" action="../sjcx/EXPV00303.action" method="post" target="_blank">
		<input type="hidden" name="txtXqIdFind" id="txtXQFind" />
		<input type="hidden" name="chkTrue" id="chkTrue" value="<s:property value="%{getText('app.global.checkbox.true')}" />"/>
		<input type="hidden" name="chkFalse" id="chkFalse" value="<s:property value="%{getText('app.global.checkbox.false')}" />"/>
		<input type="hidden" name="ACT" id="ACT">
		<table  width="300" border="0" cellspacing="2" cellpadding="0">
			<tr>
				<td><s:property value="getText('app.xtwh.info.szqy')" /><sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部" /></td>
			</tr>
			<tr>
			    <td><span class="titlespan"><s:property value="getText('app.xtwh.t00303.zcdzl')"/></span>
			    <input type="text" name="txtZCDZL" id="txtZCDZL"/></td>
			</tr> 
			<tr>
				<td valign="top"><s:property value="getText('app.xtwh.t00303.xqmc')" />
				<div class="infodiv" id="T00352Tree"></div>
				</td>
			</tr>
		</table>
		</form>
		</div>
		</div>
		
	</td> 
  	 <td valign="top">
  		<form id="findForm" action="#" method="post">				
		<table id="test"></table>				
		</form>	
		<div>
		<table cellpadding="0" cellspacing="0" style="width:600px">
				<tr>
				<td>
			<s:url id="urlAdd" action="ADDT00303"><s:param name="ACT">C</s:param></s:url>
			<s:a href="%{urlAdd}">
				<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>" alt="<s:property value="getText('app.button.add')"/>" /><s:property value="getText('app.button.add')"/>
			</s:a>
			<!-- <a href="javascript:void(0)" id="lfxxhb"><img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.xtwh.t00303.hb')"/>" alt="<s:property value="getText('app.xtwh.t00303.hb')"/>" /><s:property value="getText('app.xtwh.t00303.hb')"/></a> -->
			</td>
			<td>
				<form action="../sjcj/LFPCUPLOAD.action" method="post" id="uploadForm" enctype="multipart/form-data">
						<input type="file" name="upload" id="upload" size="50" />
						<input name="btnSearch" type="submit" id="btnSearch" class="button" value="上  传" />
					</form>
			</td>
			</tr>
			<tr>
				<td></td>
				<td ><span style="color:red">*注：导入数据前，请确定数据格式及内容正确！<a href="../Date/import_lfpc.xls">模板下载</a></span></td>
				</tr>
			</table>
		</div>
    
    </td>
  </tr>
</table>
</body>
</html>
