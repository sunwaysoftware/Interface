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
<script type="text/javascript" src="../scripts/T00004/VIEWT00004.js"></script>
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
		url:'../xtwh/FINDT00004.action',
		sortOrder: 'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {
			txtJSFIND: "",
			txtXSFIND: ""
		},
	
		frozenColumns:[[ 
					{title:'<input type="checkbox" name="chkSelAll" id="chkSelAll" class="rootCheck radio" value="true"/>',field:'checkbox',width:30,align:'center',formatter:function(value,rec){
					    return "<input type='checkbox' name='chkSel' id='chkSel'  value='"+rec.id+"' class='childCheck radio'/>";
					}},
				  {title:'编辑',field:'edit',width:35,align:'center',formatter:function(value,rec){
					//return "<a href=ADDT00004.action?ACT=U&pk=" + rec.id + "><img src=\"../images/ico/Edit.gif\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
					return "<a href=\"javascript:showpParentWin('[<s:property value="%{getText('app.xtwh.t00004.title')}" />编辑]','xtwh/ADDT00004.action?ACT=U&pk=" + rec.id + "','frame00004BG'); \"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";

				  }},
				  {title:'删除',field:'del',width:35,align:'center',formatter:function(value,rec){
				    return "<a href=ADDT00004.action?ACT=D&pk=" + rec.id  + "><img src=\"../images/ico/Delete.gif\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
				  }}
			]],
			columns:[[
				  {title:'<s:property value="%{getText('app.xtwh.t00004.js')}" />',field:'js',width:120},
                  {title:'<s:property value="%{getText('app.xtwh.t00004.xs')}" />',field:'xs',width:80},
                 
                  {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
    				return formatDateTime(value);
    			}},
                  {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:100}
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
		txtJSFIND: "",
		txtXSFIND: ""
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
				<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00004.title')}" /></span>
			</div>
		<table id="test"></table>
		<div class="divbottom">
			<div>
				<table cellpadding="0" cellspacing="0" class="tablebottom">
					<tr>
						<td><a href="ADDT00004.action?ACT=C" class="easyui-linkbutton" plain="true" iconCls="icon-add"><s:property value="getText('app.button.add')"/></a></td>
					     <td>
							<a id="delSel" href="javascript:;" class="easyui-linkbutton" plain="true" iconCls="icon-delete"><s:property value="getText('app.button.xzdel')"/></a>
						</td>					    
				</table>
			</div>
		</div>
	</div>
    </td>
  </tr>
</table>
</body>
</html>