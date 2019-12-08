<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>


<link rel="stylesheet" type="text/css" href="../css/screen.css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/T00356/VIEWT00356.js"></script>
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
		url:'../xtwh/FINDT00356.action',
		sortOrder: 'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {
			ddlSZQYFind: $("#ddlSZQYFind").val()
		},
		frozenColumns:[[
			{title:'操作',field:'edit',width:50,align:'center',formatter:function(value,rec){
					return "<a href=\"javascript:showpParentWin('[交易价格指数数据编辑]','xtwh/ADDT00356.action?ACT=U&SZQY=" + rec.cd00001Szqy +"&PSSDYM="+rec.cd00002Pssd+"','frameJYJGZSSBG'); \"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;<a href=ADDT00356.action?ACT=D&&SZQY=" + rec.cd00001Szqy +"&PSSDYM="+rec.cd00002Pssd+"><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
			}}
		]],
		columns:[[	 
            {title:'<s:property value="%{getText('app.xtwh.t00001.pssd')}" />',field:'cd00002Pssd',width:80},
            {title:'<s:property value="%{getText('app.xtwh.info.szqy')}" />',field:'szqy',width:80},
            {title:'<s:property value="%{getText('app.xtwh.t00356.jgzs')}" />',field:'xzxs',align:'right',width:120,formatter:function(value,rec){
				return formatNumber(value,'#,##0.00')
			}},
            {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
				return formatDateTime(value);
			}},
            {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:150},
            {title:'<s:property value="%{getText('app.note')}" />',field:'note',width:150}
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

	$('#test').datagrid('options').queryParams = 
    {
		ddlSZQYFind: $("#ddlSZQYFind").val()
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
		<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00356.title')}" /></span>
	</div>

<div id="w" style="width:350px;height:200;padding:5px;background: #fafafa;">
<div id="sxkz" style="display:none;">
<form id="findForm" action="../sjcx/EXPV00356.action" method="post" target="_blank">
	<s:property value="getText('app.xtwh.info.szqy')"/>
	<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/>
</form>
</div>
</div>
	<!--<input name="btnSearch" type="button" id="btnSearch" class="button" value="<s:property value="getText('app.button.search')"/>" /><input name="btnConditions" type="button" title="显示搜索条件" id="btnConditions" class="button" value="↓" />-->
	<table id="test"></table>

<div class="divbottom">
<div>
    <table cellpadding="0" cellspacing="0" style="width:600px">
		<tr>
		<td>
			<s:url id="urlAdd" action="ADDT00356"><s:param name="ACT">C</s:param></s:url>
			<s:a href="%{urlAdd}">
				<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>" alt="<s:property value="getText('app.button.add')"/>" /><s:property value="getText('app.button.add')"/>
			</s:a>
			<!-- 
			<a href="VIEWT00356COPY.action">
		 	    <img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.copy')"/>" alt="<s:property value="getText('app.button.copy')"/>" /><s:property value="getText('app.button.copy')"/>
		    </a> -->
		</td>
		<td>
			<form action="../xtwh/JYJGZSLOAD.action" method="post" id="uploadForm" enctype="multipart/form-data">
				<input type="file" name="upload" id="upload" size="50" />
				<input name="btnUpd" type="submit" id="btnUpd" class="button" value="上  传" />
			</form>
		</td>
		</tr>
		<tr>
		<td></td>
		<td ><span style="color:red">*注：导入数据前，请确定数据格式及内容正确！</span><a href="../Date/import_jyjgzs.xls">模板下载</a></td>
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
