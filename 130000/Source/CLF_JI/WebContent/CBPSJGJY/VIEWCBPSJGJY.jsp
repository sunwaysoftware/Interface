<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}" /></title>

<link rel="stylesheet" type="text/css" href="../css/screen.css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/CBPSJGJY/VIEWCBPSJGJY.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });

		$('#w').window('close');
		$('#test').datagrid({		
			striped: true,
			height:400,
			url:'FINDCBPSJGJY.action',
			sortOrder: 'desc',
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
				txtSwidFind : $("#txtSwidFind").val(),
				txtNsrmcFind : $("#txtNsrmcFind").val(),
				txtTDYTFind : $("#txtTDYTFind").val(),
				txtFWYTFind : $("#txtFWYTFind").val(),
				txtJZJGFind : $("#txtJZJGFind").val(),
				txtJcnfbgnFind : $("#txtJcnfbgnFind").val(),
				txtJcnfendFind : $("#txtJcnfendFind").val()
			},			
			columns:[[				
				{title:'<s:property value="%{getText('app.sjpg.t10031.mxid')}" />',field:'mxid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../sjcj/DETAILT12004.action?MXID=" + rec.cd12004Mxid + "\',300,420,'mxid'); title='点击查看详细信息' >" + rec.fdcxh + "</a>";
				}},
				{title:'<s:property value="%{getText('app.sjcj.t12001.swid')}" />',field:'swid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../sjcj/DETAILT12001.action?SWID=" + rec.cd12001Swid + "\',300,420,'swid'); title='点击查看详细信息' >" + rec.cd12001Swid + "</a>";
				}},
				{title:'<s:property value="%{getText('app.sjpg.t10031.nsrmc')}" />',field:'nsrmc',width:180},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.fcpgjg')}" />',field:'fcpgjg',width:120,align:'right',formatter:function(value,rec){return '￥'+formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.dcpgjg')}" />',field:'dcpgjg',width:120,align:'right',formatter:function(value,rec){return '￥'+formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.pgjg')}" />',field:'pgjg',width:120,align:'right',formatter:function(value,rec){return '￥'+formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.pssd')}" />',field:'cd00002Pssdy',width:100},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.cxl')}" />',field:'cxl',width:80,align:'right',formatter:function(value,rec){return formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.czl')}" />',field:'czl',width:80,align:'right',formatter:function(value,rec){return formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.ysynx')}" />',field:'ysynx',width:100,align:'right'},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.jjnynx')}" />',field:'jjnynx',width:100,align:'right'},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.jazj')}" />',field:'jazj',width:100,align:'right',formatter:function(value,rec){return '￥'+formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.jjbbl')}" />',field:'jjbbl',width:100,align:'right',formatter:function(value,rec){return formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="getText('app.sjpg.t10031.jzmj')"/>',field:'jzmj',width:80,align:'right',formatter:function(value,rec){return formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.rjlxs')}" />',field:'rjlxs',width:80,align:'right',formatter:function(value,rec){return formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.psss')}" />',field:'psss',width:120,align:'right',formatter:function(value,rec){return formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.dj')}" />',field:'dj',width:100,align:'right',formatter:function(value,rec){return '￥'+formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.gyttdmj')}" />',field:'gyttdmj',width:120,align:'right',formatter:function(value,rec){return formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.cqf')}" />',field:'cqf',width:100,align:'right',formatter:function(value,rec){return '￥'+formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.tdyt')}" />',field:'tdyt',width:120},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.gbrjl')}" />',field:'gbrjl',width:100,align:'right',formatter:function(value,rec){return formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.szqy')}" />',field:'szqy',width:150},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.tddj')}" />',field:'tddj',width:150},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.fwyt')}" />',field:'fwyt',width:150},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.jzjg')}" />',field:'jzjg',width:120},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
					return formatDateTime(value);
				}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.czr')}" />',field:'czr',width:120},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.note')}" />',field:'note',width:150},	           
	            {title:'<s:property value="%{getText('app.sjpg.t10031.gbdcpgjg')}" />',field:'gbdcpgjg',width:150,align:'right',formatter:function(value,rec){return '￥'+formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.gbdcxzxs')}" />',field:'gbdcxzxs',width:150,align:'right',formatter:function(value,rec){return formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="getText('app.sjpg.t10031.gbfcpgjg')"/>',field:'gbfcpgjg',width:150,align:'right',formatter:function(value,rec){return '￥'+formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.gbfcxzxs')}" />',field:'gbfcxzxs',width:150,align:'right',formatter:function(value,rec){return formatNumber(value,'#,##0.00');}},
	            {title:'<s:property value="%{getText('app.sjpg.t10031.gbpgjg')}" />',field:'gbpgjg',width:150,align:'right',formatter:function(value,rec){return '￥'+formatNumber(value,'#,##0.00');}}
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
				text:'检  验',
				iconCls:'icon-ok',
				handler:function(){
					$.messager.confirm('系统提示', '您确定要检验数据吗?', function(r) {	
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
			txtSwidFind : $("#txtSwidFind").val(),
			txtNsrmcFind : $("#txtNsrmcFind").val(),
			txtTDYTFind : $("#txtTDYTFind").val(),
			txtFWYTFind : $("#txtFWYTFind").val(),
			txtJZJGFind : $("#txtJZJGFind").val(),
			txtJcnfbgnFind : $("#txtJcnfbgnFind").val(),
			txtJcnfendFind : $("#txtJcnfendFind").val()
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
		<span class="datagrid-title-text"><s:property value="%{getText('app.psjgjy.cb.title')}" /></span>
	</div>
	<div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">
	<form id="findForm" action="CHECKOUTCBJY.action" method="post">
	<input type="hidden" name="hidSelect" id="hidSelect" />
    <table border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="80"><s:property value="getText('app.sjcj.t12001.swid')"/></td>
        <td><input type="text" id="txtSwidFind" name="txtSwidFind" value="<s:property value="txtSwidFind" />" /></td>
      </tr>
      <tr>
        <td><s:property value="getText('app.sjcj.t12001.nsrmc')"/></td>
        <td><input type="text" name="txtNsrmcFind" id="txtNsrmcFind" value="<s:property value="txtNsrmcFind" />" /></td>
      </tr>
      <tr>
        <td><s:property value="getText('app.xtwh.info.tdyt')"/></td>
        <td><input type="hidden" class="txtCode" id="txtTDYTFind" name="txtTDYTFind" value="<s:property value="txtTDYTFind" />"/>	
			<span class="txtInfonm"><input name="txtTDYTTIP" id="txtTDYTTIP" type="text" readonly="readonly"/><span id="spTDYT"></span></span>
		</td>
      </tr>
      <tr>
        <td><s:property value="getText('app.xtwh.info.fwyt')"/></td>
        <td><input type="hidden" class="txtCode" id="txtFWYTFind" name="txtFWYTFind" value="<s:property value="txtFWYTFind" />"/>	
	<span class="txtInfonm"><input name="txtFWYTTIP" id="txtFWYTTIP" type="text" readonly="readonly"/><span id="spFWYT"></span></span>
	</td>
      </tr>
      <tr>
        <td><s:property value="getText('app.xtwh.info.jzjg')"/></td>
        <td><input type="hidden" class="txtCode" id="txtJZJGFind" name="txtJZJGFind" value="<s:property value="txtJZJGFind" />"/>
	<span class="txtInfonm"><input name="txtJZJGTIP" id="txtJZJGTIP" type="text" readonly="readonly"/><span id="spJZJG"></span></span>
	</td>
      </tr>
      <tr>
        <td><s:property value="getText('app.psjgjy.cb.jcnf')"/></td>
        <td><input type="text" class="Wdate" name="txtJcnfbgnFind" id="txtJcnfbgnFind" value="<s:property value="txtJcnfbgnFind" />" onfocus="WdatePicker({enableKeyboard:false,dateFmt:'yyyy'})" />
	——
	<input type="text" class="Wdate" name="txtJcnfendFind" id="txtJcnfendFind" value="<s:property value="txtJcnfendFind" />" onfocus="WdatePicker({enableKeyboard:false,dateFmt:'yyyy'})" /></td>
      </tr>
    </table>
    </form>
	</div>		

	<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>
<table id="test"></table>
</div>
</td>
  </tr>
</table>
</body>
</html>