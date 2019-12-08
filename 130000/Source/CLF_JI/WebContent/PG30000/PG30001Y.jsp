<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="../scripts/PG30000/PG30001Y.js"></script>
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
			url:'../pg/FINDPG30002.action',
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
    			{title:'估价状态',field:'edit',width:80,align:'center',formatter:function(value,rec){
    				 //if(('00000040')==-1){
    	            	//return "<img title=\"估价信息\" alt='估价信息' src='../images/ico/2.gif'/>"; 
   					 //}else{
   						//return "<a href=\"javascript:Show(\'../pg/VIEWT00334.action?ACT=C&txtFCID=" + rec.cd00302Fcid + "\',350,800,'详细信息');\"><img title=\"估价信息\" alt='估价信息' src='../images/ico/2.gif'/></a>&nbsp;<a href=\"javascript:sendPGJG('" + rec.cd00302Fcid + "'><img src=\"../images/ico/Cancel.gif\" title=\"传入大集中\" alt=\"传入大集中\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
   						return "<a href=\"javascript:Show(\'../pg/VIEWT00334.action?ACT=C&txtFCID=" + rec.cd00302Fcid + "\',350,800,'详细信息');\"><img title=\"估价信息\" alt='估价信息' src='../images/ico/2.gif'/></a>";
   					 //}
    			}}
			]],
			columns:[[	    
	            {title:'<s:property value="%{getText('app.sjcj.t00302.fcid')}" />',field:'fcid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../xtwh/DETAILT00305Y.action?FCID=" + rec.cd00302Fcid + "\',300,420,'详细信息'); title='点击查看详细信息' >" + rec.cd00302Fcid + "</a>";
				}},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.swid')}" />',field:'zjhm',width:150},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.nsrmc')}" />',field:'nsrmc',width:150},
	            {title:'<s:property value="%{getText('app.sjpg.pg30002.pgczr')}" />',field:'pgCzr',width:120},
	            {title:'<s:property value="%{getText('app.sjpg.pg30002.pgjg')}" />',align:'right',field:'scpgjg',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}}
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
		<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.sjpg.pg30002.title')}" /></span>                 
  		</div>
       	
       	<div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">	
       	<form id="editForm" action="EXECPG30002.action" method="post">
       	<input type="hidden" id="chkSel" name="chkSel" />
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
              <td>&nbsp;<s:property value="getText('app.sjcj.t00301.fcslh')"/></td>
              <td>&nbsp;<input type="text" class="txtFCSLH" id="txtFCSLHFind" name="txtFCSLHFind"/></td>
          </tr>
        </table>
        </form>
        </div>	
        <div class="divtop">
		状态符号说明：
		<img src="../images/ico/2.gif" title="<s:property value="%{getText('app.sjpg.pg00000.success')}" />" alt="<s:property value="%{getText('app.sjpg.pg00000.success')}" />"/>
		<input type="hidden" id="hidFlag" name="hidFlag" />
		</div>
		<table id="test"></table>
		
		<div class="divbottom">
			<a href="javascript:void(0)" id="REPG">
				<img src="../images/ico/Add.gif" width="16" height="16"/><s:property value="getText('app.sjpg.pg00000.button.rPg')"/>
			</a>
			<a href="javascript:void(0)" id="REPGALL">
				<img src="../images/ico/Add.gif" width="16" height="16"/><s:property value="getText('app.sjpg.pg00000.button.rPgAll')"/>
			</a>
		</div>
</td>
  </tr>
</table>
</body>
</html>