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

<script type="text/javascript" src="../scripts/T00322/VIEWT00322.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
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
			url:'../xtwh/FINDT00322.action',
			sortOrder: 'desc',
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
				ddlSZQYFind:$("#ddlSZQYFind").val(), 
				txtXQFind : $("#txtXQFind").val()
			},
			frozenColumns:[[
				{title:'<input type="checkbox" name="chkSelAll" id="chkSelAll" class="rootCheck radio" value="true"/>',field:'checkbox',width:30,align:'center',formatter:function(value,rec){
					return "<input type='checkbox' name='chkSel' id='chkSel' value='"+rec.fcid + "' class='childCheck radio'/>";
				}}
<!--				{title:'操作',field:'edit',width:40,align:'center',formatter:function(value,rec){-->
<!--							return "<a href=\"javascript:showpParentWin('[挂牌数据编辑]','xtwh/ADDT00322.action?ACT=U&LC=" + rec.lc +"&ZCS=" + rec.zcs+"&SZQY=" + rec.cd00001Szqy + "&txtFWLX=" + rec.cd00001Fwlx + "','frameLCXSBG'); \"><img src=\"../images/ico/Edit.gif\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a><a href=\"javascript:DelData('" + rec.lc + ";" + rec.zcs + ";" +rec.cd00001Szqy +";" + rec.cd00002Pssd + ";" + rec.cd00001Fwlx +"')\"><img src=\"../images/ico/Delete.gif\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";-->
<!--						}}-->
			]],
			columns:[[	   
				{title:'<s:property value="%{getText('app.xtwh.info.szqy')}" />',field:'szqy',width:80},
				{title:'<s:property value="%{getText('app.xtwh.t00303.xqmc')}" />',field:'xqdm',width:120},	
				{title:'<s:property value="%{getText('app.xtwh.info.fwlx')}" />',field:'fwlx',width:150},
	            {title:'<s:property value="%{getText('app.xtwh.t00355.lc')}" />',field:'lc',width:80,align:'right'},
	            {title:'<s:property value="%{getText('app.xtwh.t00355.zlc')}" />',field:'zcs',width:80,align:'right'},
	            {title:'<s:property value="%{getText('app.xtwh.t00322.jcnf')}" />',field:'jcnf',width:80,align:'right'},
	            {title:'<s:property value="%{getText('app.xtwh.t00357.jzmj')}" />',field:'jzmj',align:'right',width:120,formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
				{title:'<s:property value="%{getText('app.xtwh.t00322.fwcx')}" />',field:'fwcx',width:120},
				{title:'<s:property value="%{getText('app.xtwh.t00322.fwzx')}" />',field:'fwzx',width:120},
	            {title:'<s:property value="%{getText('app.xtwh.t00322.pgjg')}" />',field:'pgjg',align:'right',width:100,formatter:function(value,rec){
					return '￥' + formatNumber(value,'#,##0.00');
				}},
							
                {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
					return formatDateTime(value);
				}},
				{title:'<s:property value="%{getText('app.xtwh.t00322.jysj')}" />',field:'jysj',width:80,formatter:function(value,rec){
					return formatDate(value);
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
				}}]
		});
		
		$('.rootCheck').click(function(){
			$(".childCheck").each(function(){
				$(this)[0].checked=$('.rootCheck')[0].checked;
			});
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
			ddlSZQYFind:$("#ddlSZQYFind").val(), 
			txtXQFind : $("#txtXQFind").val()
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
			<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00322.title')}" /></span>
		</div>
		
		<div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">
		<div id="sxkz" style="display:none;">
		<form id="findForm" action="../xtwh/EXPV00322.action" method="post" target="_blank">
		<input type="hidden" name="hidSelect" id="hidSelect" />
		<table width="300" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td>&nbsp;<s:property value="getText('app.xtwh.info.szqy')"/></td>
		    <td>&nbsp;<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/></td>
		  </tr>
		  <tr>
             <td>&nbsp;<s:property value="getText('app.xtwh.t00303.xqmc')"/></td>
             <td>&nbsp;<span class="txtInfonm"><input name="txtXQTIP" id="txtXQTIP" type="text" readonly="readonly"/><span id="spXQDM"></span></span>
             <input type="hidden" id="txtXQFind" name="txtXQFind" value="<s:property value="txtXQFind" />"/></td>
          </tr>
		</table>
		</form>
		</div>
		</div>		
		<table id="test"></table>
		<div class="divbottom">
		<div>
		 <table cellpadding="0" cellspacing="0" style="width:600px">
		 <tr>
		     <td>
<!--			<s:url id="urlAdd" action="ADDT00322"><s:param name="ACT">C</s:param></s:url>
			<s:a href="%{urlAdd}">
				<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>" alt="<s:property value="getText('app.button.add')"/>" /><s:property value="getText('app.button.add')"/>
			</s:a>-->
			<a href="javascript:;" title="选择删除" id="selDel"><img src="../images/ico/Delete.gif" title="删除" alt="删除" width="16" height="16" align="absmiddle" />选择删除</a>
			 </td>
			 <td>
			     <form action="../xtwh/GPUPLOAD.action" method="post" id="uploadForm" enctype="multipart/form-data">
						<input type="file" name="upload" id="upload" size="50" />
						<input name="btnUpd" type="submit" id="btnUpd" class="button" value="上  传" />
				</form>
			 </td>
	     </tr>
	     <tr>
				<td></td>
				<td ><span style="color:red">*注：导入数据前，请确定数据格式及内容正确！</span><a href="../Date/import_gpsj1.xls">模板下载</a></td>
				</tr>
	     </table>
		</div>
		<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
			<div id="infoTreeDIV"></div>
		</div>
		</div>
	</div>
    </td>
  </tr>
</table>
</body>
</html>
