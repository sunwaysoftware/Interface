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
<script type="text/javascript" src="../scripts/T00302/VIEWT00302.js"></script>
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
			height:400,
			url:'../sjcj/FINDT00302.action',
			sortOrder: 'desc',
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
				txtFCSLHFind : $("#txtFCSLHFind").val(),
				txtFWTDZLFind : $("#txtFWTDZLFind").val(),
				ACT : $("#ACT").val()
			},
			frozenColumns:[[
				{title:'操作',field:'edit',width:75,align:'center',formatter:function(value,rec){
					if (rec.fcid!=null)
						//return "<a href=ADDT00302.action?ddlBGLX=0&ACT=U&FCID=" + rec.fcid + "><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;<a href=ADDT00302.action?ACT=D&FCID=" + rec.fcid + "><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;<a href=\"javascript:sendDJZXML('" + rec.fcid + "');\" ><img src=\"../images/ico/Cancel.gif\" title=\"传入大集中\" alt=\"传入大集中\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
						return "<a href=ADDT00302.action?ddlBGLX=0&ACT=U&FCID=" + rec.fcid + "><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;<a href=ADDT00302.action?ACT=D&FCID=" + rec.fcid + "><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
					else
						return "";
				}}
			]],
			columns:[[		        
	            {title:'<s:property value="%{getText('app.xtwh.info.szqy')}" />',field:'szqy',width:100},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.fcid')}" />',field:'fcid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show('../sjcj/DETAILT00302.action?FCID=" + value + "',400,420,'市场法房产详细信息'); title='点击查看详细信息' >" + value + "</a>";
				}},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.swid')}" />',field:'swid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show('DETAILT00301.action?SWID=" + encodeURI(rec.cd00301Swid) + "',200,420,'市场法登记详细信息'); title='点击查看详细信息' >" + rec.zjhm + "</a>";
				}},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.nsrmc')}" />',field:'nsrmc',width:120},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.csfzjlx')}" />',field:'csfZjlx',width:120},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.csfnsrmc')}" />',field:'csfnsrmc',width:120},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.csfzjhm')}" />',field:'csfzjhm',width:120},
	           // {title:'<s:property value="%{getText('app.sjcj.t00301.fcslh')}" />',field:'fcslh',width:120},
	            
	            {title:'<s:property value="%{getText('app.xtwh.t00303.zcdzl')}" />',field:'fwtdzl',width:200},
	            {title:'<s:property value="%{getText('app.xtwh.t00303.xqmc')}" />',field:'xqnm',width:200},
	            {title:'<s:property value="%{getText('app.xtwh.info.jzjg')}" />',field:'jzjg',width:120},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.jzmj')}" />',field:'jzmj',align:'right',width:150,formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
	            {title:'<s:property value="%{getText('app.xtwh.info.fwlx')}" />',field:'fwlx',width:150},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.szlc')}" />',field:'szlc',width:80},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.bwjfh')}" />',field:'bwjfh',width:80},
	            {title:'<s:property value="%{getText('app.xtwh.info.jylx')}" />',field:'jylx',width:100},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.jysj')}" />',field:'jysj',width:100,formatter:function(value,rec){
					return formatDate(value);
				}},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.jyjg')}" />',field:'jyjg',align:'right',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}},
	            {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
					return formatDateTime(value);
				}},
				{title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:80}
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
			txtFCIDFind : $("#txtFCIDFind").val(),
			txtSWIDFind : $("#txtSWIDFind").val(),
			txtNSRMCFind : $("#txtNSRMCFind").val(),
			txtFDCDATFind : $("#txtFDCDATFind").val(),
			ddlSZQYFind : $("#ddlSZQYFind").val(),
			txtXQFind : $("#txtXQFind").val(),
			txtFCSLHFind : $("#txtFCSLHFind").val(),
			txtFWTDZLFind : $("#txtFWTDZLFind").val(),
			ACT : $("#ACT").val()
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
				<s:if test='%{ACT=="M"}'>
	              <s:property value="%{getText('app.menu.SJGL.SCSJBG')}" />
				</s:if><s:else>
	              <s:property value="%{getText('app.sjcj.t00302.bg.title')}" />
	            </s:else>
	     </span>
	</div>

  <div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">
  <div id="sxkz" style="display:none;">
  <form id="findForm" action="#" method="post">
  <input type="hidden" name="ACT" id="ACT" value="<s:property value="ACT" />" />
  <table width="300" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>&nbsp;<s:property value="getText('app.sjcj.t00302.fcid')"/></td>
    <td>&nbsp;<input type="text" class="txtID" id="txtFCIDFind" name="txtFCIDFind"/></td>
  </tr>
   <tr>
     <td>&nbsp;<s:property value="getText('app.sjcj.t00301.fcslh')"/></td>
     <td>&nbsp;<input type="text" class="txtFCSLH" id="txtFCSLHFind" name="txtFCSLHFind"/></td>
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
    <td>&nbsp;<s:property value="getText('app.xtwh.info.szqy')"/></td>
    <td>&nbsp;<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/></td>
  </tr>
  <tr>
    <td>&nbsp;<s:property value="getText('app.xtwh.t00303.xqmc')"/></td>
    <td>&nbsp;<span class="txtInfonm"><input name="txtXQTIP" id="txtXQTIP" type="text" readonly="readonly"/><span id="spXQDM"></span></span>
    <input type="hidden" id="txtXQFind" name="txtXQFind" value="<s:property value="txtXQFind" />"/></td>
  </tr>
 
  <!--<tr>
    <td>&nbsp;<s:property value="getText('app.xtwh.t00303.zcdzl')"/></td>
    <td>&nbsp;<input type="text" name="txtFWTDZLFind" id="txtFWTDZLFind"/></td>
  </tr>  
--></table>
</form>
  </div>
   </div>

<table id="test"></table>
<s:if test='%{ACT!="M"}'>
<div>
	<s:url id="urlAdd" action="ADDT00302"><s:param name="ACT"><s:property value="getText('app.global.ctrlmode.create')"/></s:param></s:url>
	<s:a href="%{urlAdd}">
	  <img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>" alt="<s:property value="getText('app.button.add')"/>" /><s:property value="getText('app.button.add')"/>
	</s:a>
</div>
</s:if>
</div>
    </td>
  </tr>
</table>
</body>
</html>
