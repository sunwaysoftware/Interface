<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/PG30000G/PG30001G.js"></script>
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
			url:'../pg/FINDPG30002.action',
			sortOrder: 'desc',
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
				txtSWIDFind : $("#txtSWIDFind").val(),
				txtNSRMCFind : $("#txtNSRMCFind").val()
			},
			frozenColumns:[[
    			{title:'操作',field:'checkbox',width:40,align:'center',formatter:function(value,rec){        				
        				if(rec.gzCount<0)
                    		return "<a href=VIEWT00331.action?ACT=C&txtFCID=" + rec.cd00302Fcid + "><img src=\"../images/ico/22.gif\" title=\"已个案评估\" alt=\"已个案评估\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
                    	else if(rec.gzCount>0)	
                    		return "<a href=VIEWT00331.action?ACT=C&txtFCID=" + rec.cd00302Fcid + "><img src=\"../images/ico/23.gif\" title=\"曾经个案评估\" alt=\"曾经个案评估\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
                    	else
                    		return "<a href=VIEWT00331.action?ACT=C&txtFCID=" + rec.cd00302Fcid + "><img src=\"../images/ico/2.gif\" title=\"已估价\" alt=\"已估价\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
    			}},
				{title:'详情',field:'editt',width:40,align:'center',formatter:function(value,rec){
					return "<a href=\"javascript:Show(\'../pg/VIEWT00334.action?ACT=C&txtFCID=" + rec.cd00302Fcid + "\',350,800,'详细信息');\"><img title=\"估价信息\" alt='估价信息' src='../images/msgINFO.gif'/></a>";
			}}    			
			]],
			columns:[[	    
	            {title:'<s:property value="%{getText('app.sjcj.t00302.fcid')}" />',field:'fcid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../xtwh/DETAILT00305Y.action?FCID=" + rec.cd00302Fcid + "\',300,420,'详细信息'); title='点击查看详细信息' >" + rec.cd00302Fcid + "</a>";
				}},			
	            {title:'<s:property value="%{getText('app.sjcj.t00301.swid')}" />',field:'cd00301Swid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../sjcj/DETAILT00301.action?SWID=" + encodeURI(rec.cd00301Swid) + "\',300,420,'登记详细信息'); title='点击查看详细信息' >" + rec.zjhm + "</a>";
				}},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.nsrmc')}" />',field:'nsrmc',width:150},
	            {title:'估价结果',align:'right',field:'pgjg',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}},
	            {title:'个案评估结果',field:'gbpgjg',align:'right',width:120,formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
	            {title:'<s:property value="%{getText('app.sjpg.pg30002.pgczr')}" />',field:'pgCzr',width:120}
		
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
			txtSWIDFind : $("#txtSWIDFind").val(),
			txtNSRMCFind : $("#txtNSRMCFind").val()
		};
		$('#test').datagrid('reload');		
	};
</script>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
    <div class="datagrid-title">
	<span class="datagrid-title-text"><s:property value="%{getText('app.sjpg.pg30000g.title')}" /></span>                 
	</div>
	
	<div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">	
	<form id="findForm" action="#" method="post">
    <table width="300" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;<s:property value="getText('app.sjcj.t00301.swid')"/></td>
        <td>&nbsp;<input type="text" class="txtID" id="txtSWIDFind" name="txtSWIDFind" value="<s:property value="txtSWIDFind"/>" /></td>
      </tr>
      <tr>
        <td>&nbsp;<s:property value="getText('app.sjcj.t00301.nsrmc')"/></td>
        <td>&nbsp;<input type="text" class="txtNSRMC" id="txtNSRMCFind" name="txtNSRMCFind" value="<s:property value="txtNSRMCFind"/>" />	</td>
      </tr>
    </table>
    </form>
    </div>
	<!--<input name="btnSearch" type="button" id="btnSearch" class="button" value="<s:property value="getText('app.button.search')"/>" /><input name="btnConditions" type="button" title="显示搜索条件" id="btnConditions" class="button" value="↓" />-->
	<table id="test"></table>

    </td>
  </tr>
</table>
</body>
</html>