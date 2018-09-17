<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/easyui/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/TFC001/VIEWTFC0017.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<script type="text/javascript">
$(function(){
	$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
	$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	$('#test').datagrid({					
		
		striped: true,
		height:400,
		url:'../xtwh/FINDTFC0017.action',
		sortOrder: 'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {
			txtCQRFIND:"",
			txtFCZHFIND:"",
			txtFZRQ_MINFIND : "",
			txtFZRQ_MAXFIND : ""
		},
	
		frozenColumns:[[ 
		                {title:'操作',field:'id',width:35,align:'center',formatter:function(value,rec){
							//return "<a href=ADDT00004.action?ACT=U&pk=" + rec.id + "><img src=\"../images/ico/Edit.gif\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
						   return "<a href=javascript:Show('../xtwh/DETAILTFC003.action?ID=" + rec.id + "',300,420,'税额登记'); title='点击查看详细信息' >详</a>";
	                 }}
			]],
			columns:[[
			       {title:'<s:property value="%{getText('app.xtwh.tfc001.slid')}" />',field:'slid',width:100,formatter:function(value,rec){
			                 return "<a href=javascript:Show('../xtwh/DETAILTFC001.action?SLID=" + rec.slid + "&SSQY=" + rec.ssqy + "',300,420,'税额登记'); title='点击查看详细信息' >"  + value + "</a>";
		                  }},
				  {title:'<s:property value="%{getText('app.xtwh.tfc003.fzrq')}" />',field:'fzrq',width:150,formatter:function(value,rec){
	    				return formatDate(value);
	    			}},
                  {title:'<s:property value="%{getText('app.xtwh.tfc003.fczh')}" />',field:'fczh',width:80},
                  {title:'<s:property value="%{getText('app.xtwh.tfc003.cqr')}" />',field:'cqr',width:80},
                  
                 
                  {title:'<s:property value="%{getText('app.xtwh.tfc003.fczl')}" />',field:'fczl',width:200}
	    ]],
		pagination:true,
		rownumbers:true
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
	
	$('#test').datagrid('options').queryParams = 
    {
		txtCQRFIND: $("#txtCQRFIND").val(),
		txtFCZHFIND: $("#txtFCZHFIND").val(),		
		txtFZRQ_MINFIND : $("#txtFZRQ_MINFIND").val(),
		txtFZRQ_MAXFIND : $("#txtFZRQ_MAXFIND").val()
	};
	$('#test').datagrid('reload');		
};
</script>
</head>
<body>
<table  align="left" cellpadding="0" cellspacing="0" class="table1" >

  <tr>
    <td align="left" valign="top">
	   	<div class="ui-widget-content">
			<div class="datagrid-title">
				<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.tfc0017.title')}" /></span>
			</div>

		<div class="divtop">
				<form id="findForm" action="EXPTFC0017.action" method="post" target="_blank">		
				    <span>产权人</span>					
				    <span>&nbsp;<input id="txtCQRFIND" name="txtCQRFIND" type="text" maxlength="5"/></span>
				    <span>房产证号</span>
				    <span>&nbsp;<input id="txtFCZHFIND" name="txtFCZHFIND" type="text" maxlength="22"/></span>	
				   <span><b>发证日期</b></span>
					<span><input style="width:90px" id="txtFZRQ_MINFIND" name="txtFZRQ_MINFIND" value="<s:property value="txtFZRQ_MINFIND" />" type="text" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})">—<input style="width:90px" id="txtFZRQ_MAXFIND" name="txtFZRQ_MAXFIND" value="<s:property value="txtFZRQ_MAXFIND" />" type="text" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"></span>
				    <br />
					<span><a id="subA" href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></span>
				    <span><a id="subB" href="#" class="easyui-linkbutton" plain="true" iconCls="icon-excel">导出</a></span>
	
				</form>		

		</div>
		<table id="test"></table>		
	</div>
    </td>
  </tr>
</table>
</body>
</html>