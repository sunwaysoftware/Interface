<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00390/VIEWT00391.js"></script>
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
			height: getGirdHeight(),
			url:'../pg/FINDT00391.action',
			sortOrder: 'desc',
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
				txtSWIDFind : $("#txtSWIDFind").val(),
				txtNSRMCFind : $("#txtNSRMCFind").val(),
				txtFCSLHFind : $("#txtFCSLHFind").val()
			},
			frozenColumns:[[
				{title:'<input type="checkbox" name="chkSelAll" id="chkSelAll" class="rootCheck radio" value="true"/>',field:'checkbox',width:30,align:'center',formatter:function(value,rec){
					return "<input type='checkbox' name='chkSel' id='chkSel' value='"+ rec.cd00302Fcid +"' class='childCheck radio'/>";
				}},
    			{title:'操作',field:'edit',width:40,align:'center',formatter:function(value,rec){
    				 if(rec.isCqts==1)//估价值过期
                		return "<img title=\"估价值已过期\" alt='过期' src='../images/ico/print_f.gif'/>";
                	 else
                		return "<a href=\"../pg/EXECT00391.action?FCID="+rec.cd00302Fcid+"\" target=\"_blank\"><img title=\"存量房交易价格申报评估结果通知单\" alt='打印' src='../images/ico/print.gif'/></a>";
                }}
			]],
			columns:[[	
				{title:'传入金税三期',field:'crdjz',width:90,align:'center',formatter:function(value,rec){
					if (rec.scdjzzt==0)
						{
						return "<a href=\"javascript:sendXML('" + rec.cd00302Fcid + "')\"><img src=\"../images/ico/Cancel.gif\" title=\"传入金税三期\" alt=\"传入金税三期\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
						}
					else
						{
						return "<a href=\"javascript:sendXML('" + rec.cd00302Fcid + "')\"><img src=\"../images/ico/Cancel1.gif\" title=\"传入金税三期\" alt=\"传入金税三期\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
						}             		
                }},     
	            {title:'<s:property value="%{getText('app.sjcj.t00302.fcid')}" />',field:'fcid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../xtwh/DETAILT00305Y.action?FCID=" + rec.cd00302Fcid + "\',300,420,'详细信息'); title='点击查看详细信息' >" + rec.cd00302Fcid + "</a>";
				}},		                
	            {title:'<s:property value="%{getText('app.sjcj.t00301.swid')}" />',field:'zjhm',width:150},
	            {title:'估价结果',align:'right',field:'pgjg',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.nsrmc')}" />',field:'nsrmc',width:150},
	            {title:'<s:property value="%{getText('app.sjpg.pg30002.pgczr')}" />',field:'pgCzr',width:120}
		    ]],
			pagination:true,
			rownumbers:true,			
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
			txtSWIDFind : $("#txtSWIDFind").val(),
			txtNSRMCFind : $("#txtNSRMCFind").val(),
			txtFCSLHFind : $("#txtFCSLHFind").val()
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
		<div class="ui-widget-content">
		<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.jsrdcl.qstzd.title')}" /></span>                 
  		</div>	
  		
		<div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">	
		<form id="editForm" action="EXECPG30002.action" method="post">	
		<input type="hidden" id="hidFlag" name="hidFlag" />	
		<input type="hidden" id="chkSel" name="chkSel" />	
		<table width="300" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>&nbsp;<s:property value="getText('app.sjcj.t00301.swid')" /></td>
				<td>&nbsp;<input type="text" class="txtID" id="txtSWIDFind"
					name="txtSWIDFind" value="<s:property value="txtSWIDFind"/>" /></td>
			</tr>
			<tr>
				<td>&nbsp;<s:property value="getText('app.sjcj.t00301.nsrmc')" /></td>
				<td>&nbsp;<input type="text" class="txtNSRMC" id="txtNSRMCFind"
					name="txtNSRMCFind" value="<s:property value="txtNSRMCFind"/>" /></td>
			</tr>
			<tr>
		          <td>&nbsp;<s:property value="getText('app.sjcj.t00301.fcslh')"/></td>
		          <td>&nbsp;<input type="text" class="txtFCSLH" id="txtFCSLHFind" name="txtFCSLHFind"/></td>
		      </tr>
		</table>
		</form>
		</div>
		<table id="test"></table>
		
		
		<div class="divbottom">
			<a href="javascript:void(0)" id="REPG">
				<img src="../images/ico/evaluate.gif" align="absmiddle" width="16" height="16"/><s:property value="getText('app.sjpg.pg00000.button.rPg')"/>
			</a>
			<a href="javascript:void(0)" id="REPGALL">
				<img src="../images/ico/evaluate.gif" align="absmiddle" width="16" height="16"/><s:property value="getText('app.sjpg.pg00000.button.rPgAll')"/>
			</a>
		</div>
		</div>
		</td>
	</tr>
</table>
</body>
</html>