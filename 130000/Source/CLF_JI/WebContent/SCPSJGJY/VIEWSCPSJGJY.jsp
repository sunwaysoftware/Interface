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
<script type="text/javascript" src="../scripts/SCPSJGJY/VIEWSCPSJGJY.js"></script>
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
	});
	function binddata(){
		$('#test').datagrid({					
			striped: true,
			height:400,
			url:'../psjgjy/FINDSCPSJGJY.action',
			sortOrder: 'desc',
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
				txtSwidFind : $("#txtSWIDFind").val(),
				txtNsrmcFind : $("#txtNSRMCFind").val(),
				ddlSZQYFind : $("#ddlSZQYFind").val(),
				txtXQDMFind : $("#txtXQFind").val(),
				txtFWLXFind : $("#txtFWLXFind").val(),
				txtJZJGFind : $("#txtJZJGFind").val(),
				txtJcnfbgnFind : $("#txtJYSJMINFind").val(),
				txtJcnfendFind : $("#txtJYSJMAXFind").val(),
				txtJZMJMINFind : $("#txtJZMJMINFind").val(),
				txtJZMJMAXFind : $("#txtJZMJMAXFind").val()
			},
			frozenColumns:[[
			    			{title:'<input type="checkbox" name="chkSelAll" id="chkSelAll" class="rootCheck radio" value="true"/>',field:'checkbox',width:30,align:'center',formatter:function(value,rec){
			        				return "<input type='checkbox' name='chkSel' id='chkSel' value='"+ rec.fcid +"' class='childCheck radio'/>";
			    			}}
						]],
			columns:[[	    
	            {title:'<s:property value="%{getText('app.sjcj.t00302.fcid')}" />',field:'fcid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../sjcj/DETAILT00302.action?FCID=" + rec.cd00302Fcid + "\',300,420,'市场法房产详细信息'); title='点击查看详细信息' >" + rec.cd00302Fcid + "</a>";
				}},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.swid')}" />',field:'cd00301Swid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../sjcj/DETAILT00301.action?SWID=" + encodeURI(rec.cd00301Swid) + "\',300,420,'市场法登记详细信息'); title='点击查看详细信息' >" + rec.zjhm + "</a>";
				}},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.nsrmc')}" />',field:'nsrmc',width:120},
	            {title:'<s:property value="%{getText('app.xtwh.t00357.pgjg')}" />',align:'right',field:'pgjg',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}},
				{title:'评税时点',field:'cd00002Pssdy',width:80,formatter:function(value,rec){
					return formatDate(value);
				}},
				{title:'平方米均价价格（元/平方米）',align:'right',field:'pfmjg',width:150,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}}, 
	            {title:'<s:property value="%{getText('app.xtwh.t00357.jysj')}" />',field:'jysj',width:80,formatter:function(value,rec){
					return formatDate(value);
				}},
	            {title:'<s:property value="%{getText('app.xtwh.t00303.xqmc')}" />',field:'xqdm',width:200},
	            {title:'<s:property value="%{getText('app.xtwh.info.fwlx')}" />',field:'fwlx',width:150},
	            {title:'<s:property value="%{getText('app.xtwh.info.jylx')}" />',field:'jylx',width:80},
	            {title:'<s:property value="%{getText('app.xtwh.info.jzjg')}" />',field:'jzjg',width:150},
	            {title:'<s:property value="%{getText('app.xtwh.t00357.szlc')}" />',field:'szlc',width:80},
	            {title:'总楼层',field:'zlc',width:80},
	            {title:'<s:property value="%{getText('app.xtwh.t00357.jzmj')}" />',field:'jzmj',align:'right',width:100,formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
				{title:'个案评估结果',field:'gbpgjg',align:'right',width:120,formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
	            {title:'市场评税结果',field:'scpgjg',align:'right',width:120,formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
				{title:'市场评税操作人',field:'scpgczr',width:100},
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
		$('.rootCheck').click(function(){ 		
			$(".childCheck").each(function(){	
				$(this)[0].checked=$('.rootCheck')[0].checked;
			});			
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
			txtSwidFind : $("#txtSWIDFind").val(),
			txtNsrmcFind : $("#txtNSRMCFind").val(),
			ddlSZQYFind : $("#ddlSZQYFind").val(),
			txtXQDMFind : $("#txtXQFind").val(),
			txtFWLXFind : $("#txtFWLXFind").val(),
			txtJZJGFind : $("#txtJZJGFind").val(),
			txtJcnfbgnFind : $("#txtJYSJMINFind").val(),
			txtJcnfendFind : $("#txtJYSJMAXFind").val(),
			txtJZMJMINFind : $("#txtJZMJMINFind").val(),
			txtJZMJMAXFind : $("#txtJZMJMAXFind").val()
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
        <form id="editForm" action="CHOISESCPSJGJY.action" method="post">
		<input type="hidden" id="hidFlag" name="hidFlag" />
		<input type="hidden" id="hidSelect" name="hidSelect" />
        <table width="300" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;<s:property value="getText('app.sjcj.t00301.swid')"/></td>
            <td>&nbsp;<input type="text" class="txtID" id="txtSWIDFind" name="txtSWIDFind" value="<s:property value="txtSWIDFind"/>" /></td>
          </tr>
          <tr>
            <td>&nbsp;<s:property value="getText('app.sjcj.t00301.nsrmc')"/></td>
            <td>&nbsp;<input type="text" class="txtNSRMC" id="txtNSRMCFind" name="txtNSRMCFind" value="<s:property value="txtNSRMCFind"/>" /></td>
          </tr>
          <tr>
          	<td>&nbsp;<s:property value="getText('app.xtwh.info.szqy')"/></td>
    		<td>&nbsp;<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/></td>
          </tr>
          <tr>
          	<td>&nbsp;<s:property value="getText('app.xtwh.t00303.xqmc')"/></td>
    		<td>&nbsp;<span class="txtInfonm"><input name="txtXQTIP" id="txtXQTIP" type="text" readonly="readonly"/><span id="spXQDM"></span></span><input type="hidden" id="txtXQFind" name="txtXQFind" value="<s:property value="txtXQFind" />"/></td>
          </tr>
          <tr>
          	<td>&nbsp;<s:property	value="%{getText('app.xtwh.info.fwlx')}" /></td>
			<td>&nbsp;<span class="txtInfonm"><input name="txtFWLXNm" id="txtFWLXNm" type="text" value="<s:property value="txtFWLXNm" />" readonly="readonly"/><span id="spFWLX"></span></span><input type="hidden" id="txtFWLXFind" name="txtFWLXFind" value="<s:property value="txtFWLXFind" />"/></td>
          </tr>
          <tr>
          	<td>&nbsp;<s:property	value="%{getText('app.xtwh.info.jzjg')}" /></td>
    		<td>&nbsp;<span class="txtInfonm"><input name="txtJZJGNm" id="txtJZJGNm" type="text" value="<s:property value='txtJZJGNm'/>" readonly="readonly"/><span id="spJZJG"></span></span><input type="hidden" id="txtJZJGFind" name="txtJZJGFind" value="<s:property value="txtJZJGFind" />"/></td>
          </tr>
          <tr>
		    <td>&nbsp;<s:property value="getText('app.sjcj.t00302.jysj')"/></td>
		    <td>&nbsp;<input type="text" id="txtJYSJMINFind" name="txtJYSJMINFind" value="<s:property value="txtJYSJMINFind"/>" onfocus="WdatePicker({maxDate:'%y-%M-%d'})" class="Wdate"/></td>
		  </tr>
		  <tr>
		    <td>&nbsp;————</td>
			<td>&nbsp;<input type="text" id="txtJYSJMAXFind"  name="txtJYSJMAXFind" value="<s:property value="txtJYSJMAXFind"/>" onfocus="WdatePicker({maxDate:'%y-%M-%d'})" class="Wdate"/></td>
		  </tr>
		  <tr>
		    <td>&nbsp;建筑面积</td>
		    <td>&nbsp;<input type="text" id="txtJZMJMINFind" name="txtJZMJMINFind" value="<s:property value="txtJYSJMINFind"/>" /></td>
		  </tr>
		  <tr>
		    <td>&nbsp;————</td>
			<td>&nbsp;<input type="text" id="txtJZMJMAXFind"  name="txtJZMJMAXFind" value="<s:property value="txtJYSJMAXFind"/>" /></td>
		  </tr>
        </table>
        </form>
        </div>	    
    <table id="test"></table>
    <div class="divbottom">
      <a href="javascript:void(0)" onClick="document.getElementById('hidFlag').value='1';AppSubmit();">
        <img src="../images/ico/Add.gif" width="16" height="16"/>检验
      </a>
      <!--<a href="javascript:void(0)" onClick="document.getElementById('hidFlag').value='2';AppSubmit();">
        <img src="../images/ico/Add.gif" width="16" height="16"/>全部检验
      </a>
    -->
    <div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>
    </div>
  </td>
  </tr>
</table>
</body>
</html>