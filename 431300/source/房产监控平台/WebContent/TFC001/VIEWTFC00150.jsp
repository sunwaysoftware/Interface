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
<script type="text/javascript" src="../scripts/TFC001/VIEWTFC00150.js"></script>
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
		url:'../xtwh/FINDTFC00150.action',
		sortOrder: 'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {
			txtZRF_NAMEFIND:"",
			txtCSF_NAMEFIND:"",
			txtSLIDFIND: "",
			txtJYSJ_MINFIND : "",
			txtJYSJ_MAXFIND : ""
		},
	
		frozenColumns:[[ 		      
				 {title:'审核',field:'status_zz',width:50,align:'center',formatter:function(value,rec){					
					return "<a href=\"javascript:auditService('" + rec.slid + "','" + rec.ssqy+"')\"><img src=\"../images/ico/examine.gif\" title=\"审核\" alt=\"审核\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
				 }}
			]],
			columns:[[
			       {title:'<s:property value="%{getText('app.xtwh.tfc001.slid')}" />',field:'slid',width:100,formatter:function(value,rec){
			                 return "<a href=javascript:Show('../xtwh/DETAILTFC001.action?SLID=" + rec.slid + "&SSQY=" + rec.ssqy + "',300,420,'税额登记'); title='点击查看详细信息' >"  + value + "</a>";
		                  }},                  
				  {title:'<s:property value="%{getText('app.xtwh.tfc001.jysj')}" />',field:'jysj',width:150,formatter:function(value,rec){
	    				return formatDate(value);
	    			}},
                  {title:'<s:property value="%{getText('app.xtwh.tfc001.zrfname')}" />',field:'zrf_name',width:120},
                  {title:'<s:property value="%{getText('app.xtwh.tfc001.csfname')}" />',field:'csf_name',width:120},              
                 
                  {title:'<s:property value="%{getText('app.xtwh.tfc001.lfdz')}" />',field:'lfdz',width:200}
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
		txtZRF_NAMEFIND: $("#txtZRF_NAMEFIND").val(),
		txtCSF_NAMEFIND: $("#txtCSF_NAMEFIND").val(),		
		txtSLIDFIND: $("#txtSLIDFIND").val(),
		txtJYSJ_MINFIND : $("#txtJYSJ_MINFIND").val(),
		txtJYSJ_MAXFIND : $("#txtJYSJ_MAXFIND").val()
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
				<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.tfc00150.title')}" /></span>
			</div>

		<div class="divtop">
				<form id="findForm" action="#" method="post" target="_blank">		
				<input type="hidden" name="hidSelect" id="hidSelect" />	   
					 <span>转让方名称</span>					
				    <span>&nbsp;<input id="txtZRF_NAMEFIND" name="txtZRF_NAMEFIND" type="text" maxlength="5"/></span>
				    <span>受让方名称</span>
				    <span>&nbsp;<input id="txtCSF_NAMEFIND" name="txtCSF_NAMEFIND" type="text" maxlength="22"/></span>	
				    <span><s:property value="getText('app.xtwh.tfc001.slid')"/></span>
				    <span>&nbsp;<input id="txtSLIDFIND" name="txtSLIDFIND" type="text" maxlength="22"/></span>	
				   <span>交易日期</span>
					<span><input style="width:90px" id="txtJYSJ_MINFIND" name="txtJYSJ_MINFIND" value="<s:property value="txtJYSJ_MINFIND" />" type="text" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})">—<input style="width:90px" id="txtJYSJ_MAXFIND" name="txtJYSJ_MAXFIND" value="<s:property value="txtJYSJ_MAXFIND" />" type="text" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"></span>
					<span><a id="subA" href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></span>
				  
				</form>		

		</div>
		<table id="test"></table>		
	</div>
    </td>
  </tr>
</table>
</body>
</html>