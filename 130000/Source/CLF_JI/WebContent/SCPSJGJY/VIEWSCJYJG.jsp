<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}" /></title>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<link href="../css/jquery.autocomplete.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/SCPSJGJY/VIEWSCJYJG.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		binddata();
		BindData();
	});
	function BindData(){
		var url = "../psjgjy/FINDSCPSJGJYCHECKOUT.action";
		var data = {
				ddlSZQYFind: $("#ddlSZQYFind").val(),
				txtXQFind : $("#txtXQFind").val(),
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
		$.ajax({
			   type: "GET",
			   url: url,
			   cache: false,
			   data: data,
			   dataType: "json",
			   complete:function()                                                    
	           {
					$("#loading").hide();
	           },
	           success: function(msg){
	  		     var data = msg.tabList;
	               $.each(data, function(i, n){ 
	              	 $("#jzqs").text(formatNumber(n.jzqs,'#,##0.00')+'%');
	       			 $("#lsxs").text(formatNumber(n.lsxs,'#,##0.00')+'%');
	              	 $("#jgxgc").text(formatNumber(n.jgxgc,'#,##0.00'));
	                 });             
	  		   },
	  		   error: function(){
	  			   $("#loading").hide();
	  			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
	  		   }
		});	
	}
	function binddata(){
		$('#test').datagrid({					
			striped: true,
			height:400,
			url:'../psjgjy/FINDSCPSJGJYCHECKOUT.action',
			sortOrder: 'desc',
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
				ddlSZQYFind: $("#ddlSZQYFind").val(),
				txtXQFind : $("#txtXQFind").val(),
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
			    			{title:'操作',field:'edit',width:30,align:'center',formatter:function(value,rec){
			        				return "<a href=javascript:DelPSJGJY('"+rec.cjid+"')><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
			    			}}
						]],
			columns:[[	
	            {title:'采集编码',field:'cjid',width:150,formatter:function(value,rec){
	            	return "<a href=javascript:Show(\'../psjgjy/SHOWSCJYJG.action?CJID=" + rec.cjid + "\',300,650,'cjid'); title='点击查看详细信息' >" + rec.cjid + "</a>";
	            }},
	            {title:'比率(%)',field:'bl',width:80,formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
	            {title:'离差',field:'lc',width:80,formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.fcid')}" />',field:'fcid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../sjcj/DETAILT00302.action?FCID=" + rec.cd00302Fcid + "\',300,420,'市场法房产详细信息'); title='点击查看详细信息' >" + rec.cd00302Fcid + "</a>";
				}},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.swid')}" />',field:'cd00301Swid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../sjcj/DETAILT00301.action?SWID=" + rec.cd00301Swid + "\',300,420,'市场法登记详细信息'); title='点击查看详细信息' >" + rec.zjhm + "</a>";
				}},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.nsrmc')}" />',field:'nsrmc',width:120},
	            {title:'<s:property value="%{getText('app.xtwh.t00303.xqmc')}" />',field:'xqnm',width:200},
	            {title:'<s:property value="%{getText('app.xtwh.info.fwlx')}" />',field:'fwlx',width:150},
	            {title:'<s:property value="%{getText('app.xtwh.info.jylx')}" />',field:'jylx',width:80},
	            {title:'<s:property value="%{getText('app.xtwh.info.jzjg')}" />',field:'jzjg',width:150},
	            {title:'<s:property value="%{getText('app.xtwh.t00302.szlc')}" />',field:'szlc',width:80},
	            {title:'总楼层',field:'zlc',width:80},
	            {title:'<s:property value="%{getText('app.xtwh.t00302.jzmj')}" />',field:'jzmj',align:'right',width:100,formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
				{title:'交易价格（元）',field:'jyjg',align:'right',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}},
	            {title:'大厅估价（元）',field:'dtgj',align:'right',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}},
				{title:'容积率',field:'rjl',width:80,formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
	            {title:'<s:property value="%{getText('app.xtwh.t00357.jysj')}" />',field:'jysj',width:80,formatter:function(value,rec){
					return formatDate(value);
				}},
				{title:'评估结果（元）',field:'pgjg',width:80,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}},
	            {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
					return formatDateTime(value);
				}},
	            {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:100},
	            {title:'<s:property value="%{getText('app.note')}" />',field:'note',width:150}
		    ]],
			pagination:true,
			rownumbers:true	,
			
			toolbar:[{
				text:'查询',
				iconCls:'icon-search',
				handler:function(){
						$('#w').window('open');	
				}
			}]		
		});
	};
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
			ddlSZQYFind: $("#ddlSZQYFind").val(),
			txtXQFind : $("#txtXQFind").val(),
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

<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
}
-->
</style>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
    	<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.psjgjy.sc.title')}" /></span>                 
  		</div>
		
        <div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">	
        <form id="editForm" action="CHECKOUTSCPSJGJY.action" method="post">
        <input type="hidden" id="hidFlag" name="hidFlag" />
		<input type="hidden" id="hidSelect" name="hidSelect" />
        <table width="300" border="0" cellspacing="0" cellpadding="0">
          <tr>
        <td width="80"><s:property value="getText('app.xtwh.info.szqy')"/></td>
        <td><sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/></td>
      </tr>
      <tr>
        <td><s:property value="getText('app.xtwh.t00303.xqmc')"/></td>
        <td><input type="hidden" class="txtCode" id="txtXQFind" name="txtXQFind" value="<s:property value="txtXQFind" />"/>
    <span class="txtInfonm"><input name="txtXQTIP" id="txtXQTIP" type="text" readonly="readonly"/><span id="spXQ"></span></span>
    </td>
      </tr>
      <tr>
        <td><s:property value="%{getText('app.psjgjy.jybz')}" /> </td>
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
        <td><input type="text" id="txtBLMIN" name="txtBLMIN" value="<s:property value="txtBLMIN" />" class="txtNumber" />
	—
	<input type="text" id="txtBLMAX" name="txtBLMAX" value="<s:property value="txtBLMAX" />" class="txtNumber" /></td>
      </tr>
      <tr>
        <td><s:property value="getText('app.psjgjy.lc')"/></td>
        <td><input type="text" id="txtLCMIN" name="txtLCMIN" value="<s:property value="txtLCMIN" />" class="txtNumber" />
	—
	<input type="text" id="txtLCMAX" name="txtLCMAX" value="<s:property value="txtLCMAX" />" class="txtNumber" /></td>
      </tr>
        </table>
        
        </form>
        </div>
		<!--<input name="btnSearch" type="button" id="btnSearch" class="button" value="<s:property value="getText('app.button.search')"/>" /><input name="btnConditions" type="button" title="显示搜索条件" id="btnConditions" class="button" value="↓" />	-->
		
		  <table id="test"></table>
	
    <div>
	<s:property value="getText('app.psjgjy.jzqs')"/><span id="jzqs" style="color:green;"></span>&nbsp;&nbsp;
	<s:property value="getText('app.psjgjy.lsxs')"/><span id="lsxs" style="color:green;"></span>&nbsp;&nbsp;
	<s:property value="getText('app.psjgjy.jgxgc')"/><span id="jgxgc" style="color:green;"></span>&nbsp;&nbsp;
	</div>
    <div class="divbottom">
      <a href="javascript:void(0)" onClick="document.getElementById('hidFlag').value='1';AppSubmit();">
        <img src="../images/ico/Add.gif" width="16" height="16"/>重新检验
      </a>
      <!--<a href="javascript:void(0)" onClick="document.getElementById('hidFlag').value='2';AppSubmit();">
        <img src="../images/ico/Add.gif" width="16" height="16"/>全部检验
      </a>
    --></div>
  </td>
  </tr>
</table>
</body>
</html>