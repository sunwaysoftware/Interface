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
<script type="text/javascript" src="../scripts/PG30000/PG30001W.js"></script>
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
			url:'../pg/FINDPG30001.action',
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
        				return "<input type='checkbox' name='chkSel' id='chkSel' value='"+ rec.fcid +"' class='childCheck radio'/>";
    			}}
    			,
    			{title:'操作',field:'editt',width:40,align:'center',formatter:function(value,rec){
					if (rec.fcid!=null)
						//return "<a href=ADDT00302.action?ddlBGLX=0&ACT=U&FCID=" + rec.fcid + "><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;<a href=ADDT00302.action?ACT=D&FCID=" + rec.fcid + "><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;<a href=\"javascript:sendDJZXML('" + rec.fcid + "');\" ><img src=\"../images/ico/Cancel.gif\" title=\"传入大集中\" alt=\"传入大集中\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
						//return "<a href=../sjcj/ADDT00302.action?ddlBGLX=0&ACT=U&FCID=" + rec.fcid + "><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a><a href=../sjcj/ADDT00302.action?ACT=D&FCID=" + rec.fcid + "><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
						return "<a href=\"javascript:showpParentWin('[房产评估编辑]','sjcj/ADDT00302.action?ddlBGLX=0&ACT=U&FCID=" + rec.fcid + "','frameLCXSBG'); \"><img src=\"../images/ico/Edit.gif\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a><a href=../sjcj/ADDT00302.action?ACT=D&FCID=" + rec.fcid + "><img src=\"../images/ico/Delete.gif\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
					else
						return "";
				}},
    			{title:'估价状态',field:'edit',width:60,align:'center',formatter:function(value,rec){
        			if(rec.isInfo){
        				return "<a href='javascript:showWin(\""+rec.fcid+"\");'><img title=\"未通过\" alt='未通过' src='../images/ico/21.gif'/></a>";
                	}else{
                		return "<img title=\"待估价\" alt='待估价' src='../images/ico/1.gif'/>";
                    }
    			}}
			]],
			columns:[[	    
	            {title:'<s:property value="%{getText('app.sjcj.t00302.fcid')}" />',field:'fcid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../xtwh/DETAILT00305Y.action?FCID=" + rec.fcid + "\',300,420,'详细信息'); title='点击查看详细信息' >" + rec.fcid + "</a>";
				}},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.swid')}" />',field:'zjhm',width:150},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.nsrmc')}" />',field:'nsrmc',width:80},
	            {title:'<s:property value="%{getText('app.xtwh.info.szqy')}" />',field:'szqy',width:100},
	            {title:'<s:property value="%{getText('app.xtwh.t00303.xqmc')}" />',field:'xqnm',width:120},
	            {title:'<s:property value="%{getText('app.xtwh.info.jzjg')}" />',field:'jzjg',width:100},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.jzmj')}" />',field:'jzmj',align:'right',width:120,formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
	            {title:'<s:property value="%{getText('app.xtwh.info.fwlx')}" />',field:'fwlx',width:150},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.szlc')}" />',field:'szlc',width:80},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.bwjfh')}" />',field:'bwjfh',width:80},
	            {title:'<s:property value="%{getText('app.xtwh.info.jylx')}" />',field:'jylx',width:120},
<!--	            {title:'<s:property value="%{getText('app.sjcj.t00302.fdcdat')}" />',field:'fdcdat',width:120},-->
	            {title:'<s:property value="%{getText('app.sjcj.t00302.jysj')}" />',field:'jysj',width:80,formatter:function(value,rec){
					return formatDate(value);
				}},
	            {title:'<s:property value="%{getText('app.sjcj.t00302.jyjg')}" />',align:'right',field:'jyjg',width:100,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}},
	            {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
					return formatDateTime(value);
				}},
	            {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:80},
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
			<span class="datagrid-title-text"><s:property value="%{getText('app.sjpg.pg30001.title')}" /></span>                 
  		</div>  		
       	<div id="w" style="width:350px;height:200px;padding:5px;background: #fafafa;">
       	<form id="editForm" action="EXECPG30001.action" method="post">
       	<input type="hidden" id="chkSel" name="chkSel" />	
       	<input type="hidden" id="hidFlag" name="hidFlag" />
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
			<img src="../images/ico/1.gif" title="<s:property value="%{getText('app.sjpg.pg00000.unknown')}" />" alt="<s:property value="%{getText('app.sjpg.pg00000.unknown')}" />"/>
			<img src="../images/ico/21.gif" title="<s:property value="%{getText('app.sjpg.pg00000.warning')}" />" alt="<s:property value="%{getText('app.sjpg.pg00000.warning')}" />"/>
			
		</div>
		<table id="test"></table>      	
    <div class="divbottom">
      <a href="javascript:void(0)" id="PG">
        <img src="../images/ico/evaluate.gif" align="absmiddle" width="16" height="16"/><s:property value="getText('app.sjpg.pg00000.button.pg')"/>
      </a>
      <a href="javascript:void(0)" id="PGALL">
        <img src="../images/ico/evaluate.gif" align="absmiddle" width="16" height="16"/><s:property value="getText('app.sjpg.pg00000.button.pgAll')"/>
      </a>
    </div>
    </div>	
  </td>
  </tr>
</table>
</body>
</html>