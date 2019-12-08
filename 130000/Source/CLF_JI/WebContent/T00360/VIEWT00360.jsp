<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00360/VIEWT00360.js"></script>
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
		height: getGirdHeight(),
		url:'../xtwh/FINDT00360.action',
		sortOrder: 'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {
			ddlSZQYFind : $("#ddlSZQYFind").val()
		},
	
		frozenColumns:[[
					{title:'<input type="checkbox" name="chkSelAll" id="chkSelAll" class="rootCheck radio" value="true"/>',field:'checkbox',width:30,align:'center',formatter:function(value,rec){
					    return "<input type='checkbox' name='chkSel' id='chkSel'  value='"+rec.id+"' class='childCheck radio'/>";
					}},

					{title:'操作',field:'edit',width:40,align:'center',formatter:function(value,rec){
						return "<a href=\"javascript:showpParentWin('[建筑面积修正编辑]','xtwh/ADDT00360.action?ACT=U&pk=" + rec.id +"','frameJZMJXZ'); \"><img src=\"../images/ico/Edit.gif\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a><a href=\"javascript:DelData('" + rec.id  + "')\"><img src=\"../images/ico/Delete.gif\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
					}}
			]],
			columns:[[
				  {title:'<s:property value="%{getText('app.xtwh.info.szqy')}" />',field:'szqy',width:120},
		          {title:'<s:property value="%{getText('app.xtwh.info.fwlx')}" />',field:'fwlx',width:120},
		          {title:'<s:property value="%{getText('app.xtwh.t00360.jzmjmin')}"/>',field:'jzmjMin',align:'right',width:100,formatter:function(value,rec){
						return formatNumber(value,'#,##0.00');
					}},
		          {title:'<s:property value="%{getText('app.xtwh.t00360.jzmjmax')}"/>',field:'jzmjMax',align:'right',width:100,formatter:function(value,rec){
						return formatNumber(value,'#,##0.00');
					}},
		          {title:'<s:property value="%{getText('app.xtwh.t00360.xzxs')}"/>(%)',field:'xzxs',align:'right',width:80,formatter:function(value,rec){
						return formatNumber(value,'#,##0.00');
					}},
		          {title:'<s:property value="%{getText('app.upddate')}"/>',field:'upddate',align:'center', width:150,formatter:function(value,rec){
						return formatDateTime(value);
					}},
		          {title:'<s:property value="%{getText('app.czr')}"/>',field:'czr',width:100},
		          {title:'<s:property value="%{getText('app.note')}"/>',field:'note',width:100}           
	    ]],
		pagination:true,
		rownumbers:true,
		
		toolbar:[
		    {
			    text:'查询',
				iconCls:'icon-search',
				handler:function(){
					$('#w').window('open');	
					$("#sxkz").show();
				}
		    },
			{
				text:'导出',
				iconCls:'icon-excel',
				handler:function(){
					$('#findForm').submit();
				}
			}
		]
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
	$('#test').datagrid('options').queryParams = {
		txtFWLX : $("#txtFWLXFind").val(),
		ddlSZQYFind : $("#ddlSZQYFind").val()
	};
	$('#test').datagrid('reload');		
};
</script>
</head>
<body>
	<table border="0" align="left" cellpadding="0" cellspacing="0"
		class="table1">
		<tr>
			<td align="left" valign="top">
				<div class="ui-widget-content">
					<div class="datagrid-title">
						<span class="datagrid-title-text"><s:property
								value="%{getText('app.xtwh.t00360.title')}" /></span>
					</div>
						<div id="w"
							style="width: 350px; height: 200px; padding: 5px; background: #fafafa;">
							<div id="sxkz" style="display: none;">
								<form id="findForm" action="EXPT00360.action" method="post"
									target="_blank">
									<input type="hidden" name="hidSelect" id="hidSelect" />
									<table width="300" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td>&nbsp;<s:property
													value="getText('app.xtwh.info.szqy')" /></td>
											<td>&nbsp;<sw:szqy items="szqyList" name="ddlSZQYFind"
													id="ddlSZQYFind" display="全部" /></td>
										</tr>
										<tr>
											<td>&nbsp;<s:property
													value="%{getText('app.xtwh.info.fwlx')}" /></td>
											<td>&nbsp;<span class="txtInfonm"><input
													name="txtFWLXNm" id="txtFWLXNm" type="text"
													value="<s:property value="txtFWLXNm" />" /><span
													id="spFWLX"></span></span><input type="hidden" id="txtFWLXFind"
												name="txtFWLXFind"
												value="<s:property value="txtFWLXFind" />" /></td>
										</tr>
									</table>
								</form>
							</div>
						</div>
						<table id="test"></table>
						<div class="divbottom">
							<div>
								<table cellpadding="0" cellspacing="0" class="tablebottom">
									<tr>
										<td><s:url id="urlAdd" action="ADDT00360">
												<s:param name="ACT">C</s:param>
											</s:url><s:a href="%{urlAdd}">
												<img src="../images/ico/Add.gif" width="16" height="16"
													title="<s:property value="getText('app.button.add')"/>"
													alt="<s:property value="getText('app.button.add')"/>" />
												<s:property value="getText('app.button.add')" />
											</s:a><a href="javascript:;" title="选择删除" id="selDel"><img
												src="../images/ico/Delete.gif" title="删除" alt="删除"
												width="16" height="16" align="absmiddle" />选择删除</a></td>
									     <td>
							                 <form action="../xtwh/UPLOADT00360.action" method="post" id="uploadForm" enctype="multipart/form-data">
										          <input type="file" name="upload" id="upload" size="50" />
										          <input name="btnUpd" type="button" id="btnUpd" class="button" value="上  传" />
								            </form>
							             </td>												
									</tr>
									<tr>
									<td>
									</td>
				        			<td><span style="color:red">*注：导入数据前，请确定数据格式及内容正确！</span><a href="../Date/import_mjxz.xls" target="_blank">模板下载</a></td>
				        			</tr>									
								</table>
							</div>
						</div>
					</div>
			</td>
		</tr>
	</table>
	<div id="dialog" title="请选择类型..." icon="icon-ok"
		style="width: 350px; height: 350px; padding: 5px; background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>
</body>
</html>