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

<script type="text/javascript" src="../scripts/T00353/VIEWT00353.js"></script>
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
			url:'../xtwh/FINDT00353.action',
			sortOrder: 'desc',
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
				ROOT: '000',
				INFOID:$("#infoId").val(),
				ddlSZQYFind: $("#ddlSZQYFind").val(), 
				txtPSSDFind: $("#txtPSSDFind").val()
			},
			frozenColumns:[[
				{title:'操作',field:'edit',width:40,align:'center',formatter:function(value,rec){
							return "<a href=\"javascript:showpParentWin('[市场法综合修正编辑]','xtwh/ADDT00353.action?ACT=U&ROOT=" + rec.cd00001Root + "&INFOID=" + rec.cd00001Infoid +"&SZQY=" + rec.cd00001Szqy + "&txtFWLX=" + rec.cd00001Fwlx +"','frameZHXZBG'); \"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a><a href=\"javascript:DelData('"+rec.cd00001Root+"' , '"+rec.cd00001Infoid+"' , '"+rec.cd00001Szqy+"' , '"+rec.cd00001Fwlx+"')\"><img src=\"../images/ico/Delete.gif\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
				}}
			]],
			columns:[[	      
	            {title:'<s:property value="%{getText('app.xtwh.info.szqy')}" />',field:'szqy',width:80},
	            {title:'<s:property value="%{getText('app.xtwh.t00001.rootnm')}" />',field:'infoNm',width:120},
	            {title:'<s:property value="%{getText('app.xtwh.info.fwlx')}" />',field:'fwlx',width:150},
	            {title:'<s:property value="%{getText('app.xtwh.sywh.xzxs')}" />(%)',field:'xzxs',width:80, align:'right' ,formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
				{title:'<s:property value="%{getText('app.xtwh.t00353.yslb')}" />',field:'czlx',width:80,formatter:function(value,rec){
					if (value==0)
						return "<s:property value="getText('app.xtwh.t00353.yslb.mcl')"/>";
					else
						return "<s:property value="getText('app.xtwh.t00353.yslb.DA')" />";

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
						$("#sxkz").show();
				}},
			    {
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
			ROOT: '000',
			INFOID:$("#infoId").val(),
			ddlSZQYFind: $("#ddlSZQYFind").val(), 
			txtPSSDFind: $("#txtPSSDFind").val()
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
		<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00353.title')}" /></span>                    
    </div>
	
	<div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">
	<div id="sxkz" style="display:none;">
	<form id="findForm" action="EXPV00353.action" method="post" target="_blank">
	<table border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td>&nbsp;<s:property value="getText('app.xtwh.info.szqy')"/></td>
	    <td>&nbsp;<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/></td>
	  </tr>
	  <!--<tr>
	    <td>&nbsp;<s:property value="getText('app.xtwh.info.cgzk')"/></td>
	    <td>&nbsp;<input type="hidden" class="txtCode" id="txtCGZKFind" name="txtCGZKFind" value="<s:property value="txtCGZKFind" />"/>	
		<input name="txtCGZKTIP" class="txtInfonm" id="txtCGZKTIP" type="text" readonly="readonly"/>
		</td>
	  </tr>-->
	</table>
	</form>
	</div>
	</div>
	<div id="dialog" title="请选择小区...">
		<div id="infoTreeDIV"></div>
	</div>
	
	<table id="test"></table>
	<div class="divbottom">
	<div>
		<table cellpadding="0" cellspacing="0" style="width:600px">
		 <tr>
		     <td>
			<s:url id="urlAdd" action="ADDT00353"><s:param name="ACT">C</s:param></s:url>
			<s:a href="%{urlAdd}">
				<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>" alt="<s:property value="getText('app.button.add')"/>" /><s:property value="getText('app.button.add')"/>
			</s:a>
			
			 </td>
			 <td>
			     <form action="../xtwh/ZHXZUPLOAD.action" method="post" id="uploadForm" enctype="multipart/form-data">
						<input type="file" name="upload" id="upload" size="50" />
						<input name="btnUpd" type="submit" id="btnUpd" class="button" value="上  传" />
				</form>
			 </td>
	     </tr>
	     <tr>
				<td></td>
				<td ><span style="color:red">*注：导入数据前，请确定数据格式及内容正确！</span><a href="../Date/import_zhxz.xls">模板下载</a></td>
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
