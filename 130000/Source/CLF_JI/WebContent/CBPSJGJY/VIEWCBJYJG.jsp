<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}" /></title>
<link rel="stylesheet" type="text/css" href="../css/screen.css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/CBPSJGJY/VIEWCBJYJG.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/T12054/T12054TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		
		$('#test').datagrid({		
			striped: true,
			height:400,
			url:'FINDCBJYJG.action',
			sortOrder: 'desc',	
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
				ddlSZQYFind : $("#ddlSZQYFind").val(),
				txtSwidFind : $("#txtSwidFind").val(),		
				txtNsrmcFind : $("#txtNsrmcFind").val(),
				txtBLMIN : $("#txtBLMIN").val(),
				txtBLMAX : $("#txtBLMAX").val(),
				txtLCMIN : $("#txtLCMIN").val(),
				txtLCMAX : $("#txtLCMAX").val(),
				ddlPSBZFind : $("#ddlPSBZFind").val(),
				ddlJZQSFind : $("#ddlJZQSFind").val(),
				ddlLSXSFind : $("#ddlLSXSFind").val(),
				ddlJGXGCFind : $("#ddlJGXGCFind").val()
			},		
			frozenColumns:[[
				{title:'操作',field:'msg',width:40,align:'center',formatter:function(value,rec){
					$("#jzqs").text(formatNumber(rec.jzqs,'#,##0.00')+'%');
	     			$("#lsxs").text(formatNumber(rec.lsxs,'#,##0.00')+'%');
	            	$("#jgxgc").text(formatNumber(rec.jgxgc,'#,##0.00'));
					return "<a href=javascript:DelPSJGJY('"+rec.cjid+"')><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
				}}
            ]],
			columns:[[				
		        {title:'<s:property value="%{getText('app.sjcj.t12004.cjid')}" />',field:'cjid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../psjgjy/SHOWCBSYJYJG.action?CJID=" + rec.cjid + "\',300,650,'cjid'); title='点击查看详细信息' >" + rec.cjid + "</a>";
				}},
				{title:'<s:property value="%{getText('app.psjgjy.bl')}" />',field:'bl',width:80,align:'right'},
				{title:'<s:property value="%{getText('app.psjgjy.lc')}" />',field:'lc',width:80,align:'right'},
				{title:'<s:property value="%{getText('app.sjcj.t12004.mxid')}" />',field:'mxid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../sjcj/DETAILT12004.action?MXID=" + rec.cd12004Mxid + "\',300,420,'mxid'); title='点击查看详细信息' >" + rec.fdcxh + "</a>";
				}},
				{title:'<s:property value="%{getText('app.sjcj.t12004.fcid')}" />',field:'fcid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../sjcj/DETAILT12003.action?FCID=" + rec.cd12003Fcid + "\',300,420,'fcid'); title='点击查看详细信息' >" + rec.fdcxh + "</a>";
				}},
				{title:'<s:property value="%{getText('app.sjcj.t12004.dcid')}" />',field:'dcid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../sjcj/DETAILT12002.action?DCID=" + rec.cd12002Dcid + "\',300,420,'dcid'); title='点击查看详细信息' >" + rec.tdxh + "</a>";
				}},
				{title:'<s:property value="%{getText('app.sjcj.t12001.swid')}" />',field:'swid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../sjcj/DETAILT12001.action?SWID=" + rec.cd12001Swid + "\',300,420,'swid'); title='点击查看详细信息' >" + rec.cd12001Swid + "</a>";
				}},
	            {title:'<s:property value="%{getText('app.sjcj.t12001.nsrmc')}" />',field:'nsrmc',width:180},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.tdyt')}" />',field:'tdyt',width:100},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.tddj')}" />',field:'tddj',width:100},
	            {title:'<s:property value="%{getText('app.psjgjy.cb.fttdmj')}" />',field:'fttdmj',width:180,align:'right',formatter:function(value,rec){return formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.fwyt')}" />',field:'fwyt',width:120},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.jzjg')}" />',field:'jzjg',width:120},
	            {title:'<s:property value="%{getText('app.sjcj.t12003.jcnf')}" />',field:'jcnf',width:100},
	            {title:'<s:property value="%{getText('app.sjcj.t12004.ytjzmj')}" />',field:'ytjzmj',width:150,align:'right',formatter:function(value,rec){return formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjcj.t12004.fcyz')}" />',field:'fcyz',width:150,align:'right',formatter:function(value,rec){return '￥'+formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.pssd')}" />',field:'cd00002Pssd',width:100},
	            {title:'<s:property value="%{getText('app.sjpg.pg20002.pgjg')}" />',field:'pgjg',width:120,align:'right',formatter:function(value,rec){return '￥'+formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="getText('app.sjpg.t10031.upddate')"/>',field:'upddate',width:150,formatter:function(value,rec){
					return formatDateTime(value);
				}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.czr')}" />',field:'cd00002Lrr',width:100},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.note')}" />',field:'note',width:150}
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
				text:'重新检验',
				iconCls:'icon-ok',
				handler:function(){
					$.messager.confirm('系统提示', '您确定要重新检验数据吗?', function(r) {	
			            if (r) {
			            	$("#loading").show();
			            	$('#findForm').submit();
			            }
			        });
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
			ddlSZQYFind : $("#ddlSZQYFind").val(),
			txtSwidFind : $("#txtSwidFind").val(),
			txtNsrmcFind : $("#txtNsrmcFind").val(),
			txtBLMIN : $("#txtBLMIN").val(),
			txtBLMAX : $("#txtBLMAX").val(),
			txtLCMIN : $("#txtLCMIN").val(),
			txtLCMAX : $("#txtLCMAX").val(),
			ddlPSBZFind : $("#ddlPSBZFind").val(),
			ddlJZQSFind : $("#ddlJZQSFind").val(),
			ddlLSXSFind : $("#ddlLSXSFind").val(),
			ddlJGXGCFind : $("#ddlJGXGCFind").val()
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
		<span class="datagrid-title-text"><s:property value="%{getText('app.psjgjy.cb.jyjg.title')}" /></span>
	</div>
    <div id="w" style="width:450px;height:250px;padding:5px;background: #fafafa;">
    <form id="findForm" action="CHECKOUTCBPSJGJY.action" method="post">
	<input type="hidden" name="hidSelect" id="hidSelect" />	
	<input type="hidden" name="txtTDYTFind" id="txtTDYTFind"  value="<s:property value="txtTDYTFind" />" />
	<input type="hidden" name="txtFWYTFind" id="txtFWYTFind"  value="<s:property value="txtFWYTFind" />" />
	<input type="hidden" name="txtJZJGFind" id="txtJZJGFind"  value="<s:property value="txtJZJGFind" />" />
	<input type="hidden" name="txtJcnfbgnFind" id="txtJcnfbgnFind"  value="<s:property value="txtJcnfbgnFind" />" />
	<input type="hidden" name="txtJcnfendFind" id="txtJcnfendFind"  value="<s:property value="txtJcnfendFind" />" />
    <table border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="80"><s:property value="getText('app.xtwh.info.szqy')"/></td>
        <td><sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/></td>
      </tr>
      <tr>
        <td><s:property value="%{getText('app.psjgjy.jybz')}" /></td>
        <td><select name="ddlPSBZFind" id="ddlPSBZFind">
		<option value="">请选择...</option>
		<s:iterator id="v00054Entity" value="v00054List" status="index">
			<s:if test="%{bzbm==ddlPSBZFind}">
				<option selected="selected" value="<s:property value="bzbm" />"><s:property
					value="bzmc" /></option>
			</s:if>
			<s:else>
				<option value="<s:property value="bzbm" />"><s:property
					value="bzmc" /></option>
			</s:else>
		</s:iterator>
	</select> </td>
      </tr>
      <tr>
        <td><s:property value="%{getText('app.psjgjy.jzqs')}" /></td>
        <td><select name="ddlJZQSFind" id="ddlJZQSFind">
		<option <s:if test="%{ddlJZQSFind==2}">selected="selected"</s:if> value="2">未选择</option>
		<option <s:if test="%{ddlJZQSFind==1}">selected="selected"</s:if> value="1">通过</option>
		<option <s:if test="%{ddlJZQSFind==0}">selected="selected"</s:if> value="0">未通过</option>
	</select> </td>
      </tr>
      <tr>
        <td><s:property value="%{getText('app.psjgjy.lsxs')}" /> </td>
        <td><select name="ddlLSXSFind" id="ddlLSXSFind">
		<option <s:if test="%{ddlLSXSFind==2}">selected="selected"</s:if> value="2">未选择</option>
		<option <s:if test="%{ddlLSXSFind==1}">selected="selected"</s:if> value="1">通过</option>
		<option <s:if test="%{ddlLSXSFind==0}">selected="selected"</s:if> value="0">未通过</option>
	</select> </td>
      </tr>
      <tr>
        <td><s:property value="%{getText('app.psjgjy.jgxgc')}" /> </td>
        <td><select name="ddlJGXGCFind" id="ddlJGXGCFind">
		<option <s:if test="%{ddlJGXGCFind==2}">selected="selected"</s:if> value="2">未选择</option>
		<option <s:if test="%{ddlJGXGCFind==1}">selected="selected"</s:if> value="1">通过</option>
		<option <s:if test="%{ddlJGXGCFind==0}">selected="selected"</s:if> value="0">未通过</option>
	</select> </td>
      </tr>
      <tr>
        <td><s:property value="getText('app.psjgjy.bl')"/></td>
        <td><input type="text" id="txtBLMIN" name="txtBLMIN" value="<s:property value="txtBLMIN" />"  class="txtNumber" />
	—
	<input type="text" id="txtBLMAX" name="txtBLMAX" value="<s:property value="txtBLMAX" />"  class="txtNumber" /></td>
      </tr>
      <tr>
        <td><s:property value="getText('app.psjgjy.lc')"/></td>
        <td><input type="text" id="txtLCMIN" name="txtLCMIN" value="<s:property value="txtLCMIN" />"  class="txtNumber" />
	—
	<input type="text" id="txtLCMAX" name="txtLCMAX" value="<s:property value="txtLCMAX" />" class="txtNumber" /></td>
      </tr>
    </table>
    </form>	
     </div>	

<table id="test"></table>
<table border="0" cellspacing="2" cellpadding="0" width="700">
   <tr>
     <td><s:property value="getText('app.xtwh.info.tdyt')"/></td>
     <td><s:property value="getText('app.xtwh.info.fwyt')"/></td>
     <td><s:property value="getText('app.xtwh.info.jzjg')"/></td>
     <td><s:property value="getText('app.psjgjy.cb.jcnf')"/></td>
     <td><s:property value="getText('app.psjgjy.jzqs')"/></td>
     <td><s:property value="getText('app.psjgjy.lsxs')"/></td>
     <td><s:property value="getText('app.psjgjy.jgxgc')"/></td>     
   </tr>
   <tr>
     <td>&nbsp;<s:property value="txtTDYTFind" /></td>
     <td>&nbsp;<s:property value="txtFWYTFind" /></td>
     <td>&nbsp;<s:property value="txtJZJGFind" /></td>
     <td>&nbsp;<s:property value="txtJcnfbgnFind" />-<s:property value="txtJcnfendFind" /></td>
     <td>&nbsp;<span id="jzqs" style="color:green;"></span></td>
     <td>&nbsp;<span id="lsxs" style="color:green;"></span></td>
     <td>&nbsp;<span id="jgxgc" style="color:green;"></span></td>     
   </tr>
</table>
</div>
</td>
  </tr>
</table>
</body>
</html>