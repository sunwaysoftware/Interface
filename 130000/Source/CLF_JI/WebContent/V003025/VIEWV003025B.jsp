<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/V003025/VIEWV003025.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="../css/screen.css"/>
<link href="../css/jquery.autocomplete.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	
		
		$('#test').datagrid({
			striped: true,
			height: getGirdHeight(),
			sortOrder: 'desc',				
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {	
				txtFCIDFind : $("#txtFCIDFind").val(),
				txtSWIDFind : $("#txtSWIDFind").val(),
				txtNSRMCFind : $("#txtNSRMCFind").val(),
				txtZCDZLFind : $("#txtZCDZLFind").val(),
				ddlSZQYFind : $("#ddlSZQYFind").val(),
				txtXQFind : $("#txtXQFind").val(),
				txtFWLXFind : $("#txtFWLXFind").val(),
				txtJZJGFind : $("#txtJZJGFind").val(),
				txtJYLXFind : $("#txtJYLXFind").val(),
				txtJZMJMINFind : $("#txtJZMJMINFind").val(),
				txtJZMJMAXFind : $("#txtJZMJMAXFind").val(),
				txtJYJGMINFind : $("#txtJYJGMINFind").val(),
				txtJYJGMAXFind : $("#txtJYJGMAXFind").val(),
				txtJYSJMINFind : $("#txtJYSJMINFind").val(),
				txtJYSJMAXFind : $("#txtJYSJMAXFind").val(),
				txtDJRQFind : $("#txtDJRQFind").val(),
				txtSZLCFind : $("#txtSZLCFind").val(),
				txtFCSLHFind : $("#txtFCSLHFind").val(),
				txtLHFind : $("#txtLHFind").val(),
				txtFCZHFind : $("#txtFCZHFind").val(),
				txtUPDDATES : $("#txtUPDDATES").val(),
				txtUPDDATEE : $("#txtUPDDATEE").val(),
				txtUPDDATRD : $("#txtUPDDATRD").val(),
				txtUPDDATEERD : $("#txtUPDDATEERD").val(),
				txtCZRFind : $("#txtCZRFind").val(),
				ddlSCZTFind : $("#ddlSCZTFind").val(),
				txtSSGX : $("#txtSSGX").val()
			},
			columns:[[				
		        {title:'<s:property value="%{getText('app.xtwh.info.szqy')}" />',field:'szqy',width:80},		
				{title:'<s:property value="%{getText('app.sjcj.t00302.fcid')}" />',field:'fcid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../sjcj/DETAILT00302B.action?FCID=" + rec.fcid + "\',400,420,'市场法房产详细信息'); title='点击查看详细信息' >" + rec.fcid + "</a>";
				}},
				{title:'<s:property value="%{getText('app.xtwh.t00370.szxx')}" />',field:'szxx',width:120,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../xtwh/DETAILT00370B.action?FCID=" + rec.fcid + "\',200,420,'点击查看缴税信息'); title='点击查看缴税信息'>点击查看缴税信息</a>";
				}},
				{title:'<s:property value="%{getText('app.sjcj.t00301.swid')}" />',field:'zjhm',width:120},
				
				{title:'<s:property value="%{getText('app.sjcj.t00301.nsrmc')}" />',field:'nsrmc',width:120},
				{title:'<s:property value="%{getText('app.xtwh.info.ssgx')}" />',field:'ssgx',width:150},
				{title:'<s:property value="%{getText('app.xtwh.t00303.zcdzl')}" />',field:'fwtdzl',width:180},
				{title:'<s:property value="%{getText('app.xtwh.t00303.xqmc')}" />',field:'xqnm',width:150},
				{title:'<s:property value="%{getText('app.xtwh.info.jzjg')}" />',field:'jzjg',width:120},
				{title:'<s:property value="%{getText('app.sjcj.t00302.jzmj')}" />',field:'jzmj',width:100,align:'right',formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
				{title:'<s:property value="%{getText('app.sjcj.t00302.fczh')}" />',field:'fczh',width:80},
				{title:'<s:property value="%{getText('app.sjcj.t00302.djrq')}" />',field:'djrq',width:100,formatter:function(value,rec){
					return formatDate(value);
				}},	
				{title:'<s:property value="%{getText('app.sjcj.t00302.szlc')}" />',field:'szlc',width:80},
				{title:'<s:property value="%{getText('app.xtwh.t00303.zlc')}" />',field:'zlc',width:80},
				{title:'<s:property value="%{getText('app.xtwh.info.fwlx')}" />',field:'fwlx',width:150},				
				{title:'<s:property value="%{getText('app.sjcj.t00302.bwjfh')}" />',field:'bwjfh',width:80},
				{title:'<s:property value="%{getText('app.xtwh.info.jylx')}" />',field:'jylx',width:150},	
				{title:'<s:property value="%{getText('app.sjcj.t00302.jysj')}" />',field:'jysj',width:100,formatter:function(value,rec){
					return formatDate(value);
				}},		
	            {title:'<s:property value="%{getText('app.sjcj.t00302.jyjg')}" />',field:'jyjg',align:'right',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}},
				{title:'<s:property value="%{getText('app.sjcj.t00302.jyjg_dj')}" />',field:'jyjgdj',align:'right',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(rec.jyjg / rec.jzmj,'#,##0.00');
				}},
				{title:'<s:property value="%{getText('app.sjcx.v003015.pgjg')}" />',field:'pgjg',align:'right',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}},
				{title:'<s:property value="%{getText('app.sjcx.v003015.pgjg_dj')}" />',field:'pgjgdj',align:'right',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(rec.pgjg / rec.jzmj,'#,##0.00');
				}},
				{title:'<s:property value="%{getText('app.sjcx.v003015.gbpgjg')}" />',field:'gbpgjg',align:'right',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}},
				{title:'<s:property value="%{getText('app.sjcx.v003015.gbpgjg_dj')}" />',field:'gbpgjgdj',align:'right',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(rec.gbpgjg / rec.jzmj,'#,##0.00');
				}},
				{title:'<s:property value="%{getText('app.sjcx.v003025.scpgjg')}" />',field:'scpgjg',align:'right',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}},
				{title:'<s:property value="%{getText('app.sjcx.v003025.scpgjg_dj')}" />',field:'scpgjgdj',align:'right',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(rec.scpgjg / rec.jzmj,'#,##0.00');
				}},
				{title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:130,formatter:function(value,rec){
					return formatDateTime(value);
				}},
				{title:'<s:property value="%{getText('app.czr')}" />',width:100,field:'czr'}
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
				iconCls:'icon-Excel',
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
			txtFCIDFind : $("#txtFCIDFind").val(),
			txtSWIDFind : $("#txtSWIDFind").val(),
			txtNSRMCFind : $("#txtNSRMCFind").val(),
			txtZCDZLFind : $("#txtZCDZLFind").val(),
			ddlSZQYFind : $("#ddlSZQYFind").val(),
			txtXQFind : $("#txtXQFind").val(),
			txtFWLXFind : $("#txtFWLXFind").val(),
			txtJZJGFind : $("#txtJZJGFind").val(),
			txtJYLXFind : $("#txtJYLXFind").val(),
			txtJZMJMINFind : $("#txtJZMJMINFind").val(),
			txtJZMJMAXFind : $("#txtJZMJMAXFind").val(),
			txtJYJGMINFind : $("#txtJYJGMINFind").val(),
			txtJYJGMAXFind : $("#txtJYJGMAXFind").val(),
			txtJYSJMINFind : $("#txtJYSJMINFind").val(),
			txtJYSJMAXFind : $("#txtJYSJMAXFind").val(),
			txtDJRQFind : $("#txtDJRQFind").val(),
			txtSZLCFind : $("#txtSZLCFind").val(),
			txtLHFind : $("#txtLHFind").val(),
			txtFCZHFind : $("#txtFCZHFind").val(),
			txtFCSLHFind : $("#txtFCSLHFind").val(),
			ddlSCZTFind : $("#ddlSCZTFind").val(),
			txtUPDDATES : $("#txtUPDDATES").val(),
			txtUPDDATEE : $("#txtUPDDATEE").val(),
			
			txtUPDDATRD : $("#txtUPDDATRD").val(),
			txtUPDDATEERD : $("#txtUPDDATEERD").val(),
			
			txtCZRFind : $("#txtCZRFind").val(),
			txtSSGX : $("#txtSSGX").val()
		};
		$('#test').datagrid('options').url='../sjcx/FINDV003025B.action';
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
		<span class="datagrid-title-text"><s:property value="%{getText('app.sjcx.v003025B.title')}" /></span>
	</div>
<div id="w" style="width:550px;height:350px;padding:5px;background: #fafafa;">
<div id="sxkz" style="display:none;">
<form id="findForm" action="EXPV003025B.action" method="post" target="_blank">
<input type="hidden" name="hidSelect" id="hidSelect" />
<table width="500" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>&nbsp;<s:property value="getText('app.sjcj.t00302.fcid')"/></td>
    <td>&nbsp;<input type="text" class="txtID" id="txtFCIDFind" name="txtFCIDFind"/></td>
    <td>&nbsp;<s:property value="getText('app.sjcj.t00301.swid')"/></td>
    <td>&nbsp;<input type="text" class="txtID" id="txtSWIDFind" name="txtSWIDFind"/></td>
  </tr>
  <tr>
    <td>&nbsp;<s:property value="getText('app.sjcj.t00301.nsrmc')"/></td>
    <td>&nbsp;<input type="text" class="txtNSRMC" id="txtNSRMCFind" name="txtNSRMCFind"/></td>
    <td>&nbsp;<s:property value="%{getText('app.xtwh.t00303.zcdzl')}" /></td>
	<td>&nbsp;<input name="txtZCDZLFind" id="txtZCDZLFind" type="text"/></td>
  </tr>
  <tr>
   <td>&nbsp;<s:property value="getText('app.xtwh.info.szqy')"/></td>
    <td>&nbsp;<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/></td>
  	<td>&nbsp;
  		<s:property value="getText('app.sjcx.v003015.sczt')"/>
  	</td>
    <td>&nbsp;<select name="ddlSCZTFind" id="ddlSCZTFind" />
		      <jsp:include page="../common/status.jsp"></jsp:include>
		    </select>
	</td>
  </tr>
   <tr>
    <td>&nbsp;<s:property value="getText('app.xtwh.t00303.xqmc')"/></td>
    <td>&nbsp;<input type="text" id="txtXQFind" name="txtXQFind" value="<s:property value="txtXQFind" />"/></td>
 	<td>&nbsp;<s:property	value="%{getText('app.xtwh.info.fwlx')}" /></td>
	<td>&nbsp;<span class="txtInfonm"><input name="txtFWLXNm" id="txtFWLXNm" type="text" value="<s:property value="txtFWLXNm" />" readonly="readonly"/><span id="spFWLX"></span></span><input type="hidden" id="txtFWLXFind" name="txtFWLXFind" value="<s:property value="txtFWLXFind" />"/></td>
  </tr>
   <tr>
    <td>&nbsp;<s:property	value="%{getText('app.xtwh.info.jzjg')}" /></td>
    <td>&nbsp;<span class="txtInfonm"><input name="txtJZJGNm" id="txtJZJGNm" type="text" value="<s:property value='txtJZJGNm'/>" readonly="readonly"/><span id="spJZJG"></span></span><input type="hidden" id="txtJZJGFind" name="txtJZJGFind" value="<s:property value="txtJZJGFind" />"/></td>
    <td>&nbsp;<s:property value="%{getText('app.xtwh.info.jylx')}" /></td>
    <td>&nbsp;<span class="txtInfonm"><input name="txtJYLXNm" id="txtJYLXNm" type="text" value="<s:property value="txtJYLXNm" />" readonly="readonly"/><span id="spJYLX"></span></span><input type="hidden" id="txtJYLXFind" name="txtJYLXFind" value="<s:property value="txtJYLXFind" />"/></td>
  </tr>
  <tr>
    <td>&nbsp;<s:property value="getText('app.sjcj.t00302.jzmj')"/></td>
    <td>&nbsp;<input type="text" class="txtNumber" id="txtJZMJMINFind" name="txtJZMJMINFind" value="<s:property value="txtJZMJMINFind"/>" /></td>
    <td>&nbsp;————</td>
	<td>&nbsp;<input type="text" class="txtNumber" id="txtJZMJMAXFind"  name="txtJZMJMAXFind" value="<s:property value="txtJZMJMAXFind"/>" /></td>
  </tr>
   <tr>
    <td>&nbsp;<s:property value="getText('app.sjcj.t00302.jyjg')"/></td>
    <td>&nbsp;<input type="text" class="txtNumber" id="txtJYJGMINFind" name="txtJYJGMINFind" value="<s:property value="txtJYJGMINFind"/>" /></td>
    <td>&nbsp;————</td>
	<td>&nbsp;<input type="text" class="txtNumber" id="txtJYJGMAXFind"  name="txtJYJGMAXFind" value="<s:property value="txtJYJGMAXFind"/>" /></td>
  </tr>
   <tr>
    <td>&nbsp;<s:property value="getText('app.sjcj.t00302.jysj')"/></td>
    <td>&nbsp;<input type="text" id="txtJYSJMINFind" name="txtJYSJMINFind" value="<s:property value="txtJYSJMINFind"/>" onfocus="WdatePicker({maxDate:'%y-%M-%d'})" class="Wdate"/></td>
    <td>&nbsp;————</td>
	<td>&nbsp;<input type="text" id="txtJYSJMAXFind"  name="txtJYSJMAXFind" value="<s:property value="txtJYSJMAXFind"/>" onfocus="WdatePicker({maxDate:'%y-%M-%d'})" class="Wdate"/></td>
  </tr>
  <tr>
    <td>&nbsp;<s:property value="getText('app.sjcj.t00302.djrq')"/></td>
	<td>&nbsp;<input type="text" id="txtDJRQFind"  name="txtDJRQFind" value="<s:property value="txtDJRQFind"/>" onfocus="WdatePicker({maxDate:'%y-%M-%d'})" class="Wdate"/></td>
    <td>&nbsp;<s:property value="getText('app.sjcj.t00302.szlc')"/> </td>
    <td>&nbsp;<input type="text" id="txtSZLCFind" name="txtSZLCFind" value="<s:property value="txtSZLCFind"/>" /></td>
  </tr>
  <tr>	
    <td>&nbsp;<s:property value="getText('app.sjcj.t00302.fczh')"/></td>
	<td>&nbsp;<input type="text" id="txtFCZHFind"  name="txtFCZHFind" value="<s:property value="txtFCZHFind"/>" /></td>
  	<td>&nbsp;<s:property value="getText('app.xtwh.info.ssgx')" /></td>
	<td>&nbsp;<span class="txtInfonm"><input type="text" id="txtSSGXTIP" name="txtSSGXTIP" readonly="readonly"/><span id="spSSGX"></span></span>
	<input type="hidden" id="txtSSGX" name="txtSSGX"  value="<s:property value="txtSSGX"/>" />
	</td>
  </tr>
  <tr>
	<td>&nbsp;<s:property value="getText('app.czr')"/></td>
	<td>&nbsp;<input type="text" id="txtCZRFind"  name="txtCZRFind" value="<s:property value="txtCZRFind"/>" /></td>
  	<td>&nbsp;<s:property value="getText('app.sjcj.t00301.fcslh')"/></td>
    <td>&nbsp;<input type="text" class="txtFCSLH" id="txtFCSLHFind" name="txtFCSLHFind"/></td>
  </tr>
  <tr>
  	<td>&nbsp;<s:property value="%{getText('app.sjcx.v003025.gxqj')}" /></td>
  	<td>&nbsp;<input type="text" id="txtUPDDATES" name="txtUPDDATES" onfocus="WdatePicker({maxDate:'%y-%M-%d'})" class="Wdate"/></td>
  	<td>&nbsp;————</td>
  	<td>&nbsp;<input type="text" id="txtUPDDATEE" name="txtUPDDATEE" onfocus="WdatePicker({maxDate:'%y-%M-%d'})" class="Wdate"/></td>
  </tr>
   <tr>
  	<td>&nbsp;<s:property value="%{getText('app.sjcx.v003025.rdsj')}" /></td>
  	<td>&nbsp;<input type="text" id="txtUPDDATRD" name="txtUPDDATRD" onfocus="WdatePicker({maxDate:'%y-%M-%d'})" class="Wdate"/></td>
  	<td>&nbsp;————</td>
  	<td>&nbsp;<input type="text" id="txtUPDDATEERD" name="txtUPDDATEERD" onfocus="WdatePicker({maxDate:'%y-%M-%d'})" class="Wdate"/></td>
  </tr>
</table> 
</form>
    </div>
     </div>
	<table id="test"></table>
</div>
<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
	<div id="infoTreeDIV"></div>
</div> 
    </td>
  </tr>
</table>
</body>
</html>
