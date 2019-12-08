<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}"/></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/T00306/VIEWT00306.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<script type="text/javascript">
$(function(){
	$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
	$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	
	
	$('#test').datagrid({					
		striped: true,
		height: getGirdHeight(),
		url:'../xtwh/FINDT00306.action',
		sortOrder: 'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {
			ddlSZQYFind: $("#ddlSZQYFind").val(),
			txtZCDZL: $("#txtZCDZL").val(),
			txtXQTIP: $("#txtXQTIP").val()
		},
	
		frozenColumns:[[ 
				  {title:'操作',field:'edit',width:40,align:'center',formatter:function(value,rec){
						return "<a href=\"javascript:showpParentWin('[楼房信息编辑]','xtwh/ADDT00306.action?ACT=U&id=" + rec.id + "','frameLFXXBG'); \"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a><a href=ADDT00306.action?ACT=D&id=" + rec.id  + "><img src=\"../images/ico/Delete.gif\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";

						//return "<a href=ADDT00306.action?ACT=U&id=" + rec.id + "><img src=\"../images/ico/Edit.gif\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
				  }},
				  {title:'<s:property value="%{getText('app.xtwh.t00306.zp')}" />',field:'photo',width:35,align:'center',formatter:function(value,rec){
				 	return "<a href='javascript:void(0)' onclick='Show(\"../xtwh/VIEWT00306F.action?txtXQDMHM="+rec.xqdmhm+"&CD00306ID="+ rec.id +"&txtXQDM=" + rec.cd00352Xqdm + "\", 425, 520,\"XQZPSC\")' ><img src=\"../images/ico/light.gif\" title=\"添加图片\" alt=\"添加图片\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
				  }}
			]],
			columns:[[
                  {title:'<s:property value="%{getText('app.xtwh.t00306.szqy')}" />',field:'szqy',width:120},
<!--                  {title:'<s:property value="%{getText('app.xtwh.t00306.dmh')}" />',field:'xqdmhm',width:80},-->
                  {title:'<s:property value="%{getText('app.xtwh.t00306.xqnm')}" />',field:'xqnm',width:120},
                  {title:'<s:property value="%{getText('app.xtwh.t00303.clh')}" />',field:'clh',width:150},
                  {title:'<s:property value="%{getText('app.xtwh.t00306.note')}" />',field:'note',width:250},
                  {title:'<s:property value="%{getText('app.xtwh.t00306.lh')}" />',field:'lh',width:80},
                  //{title:'<s:property value="%{getText('app.xtwh.t00306.zlc')}" />',field:'zlc',width:80},
                  //{title:'<s:property value="%{getText('app.xtwh.t00306.dygs')}" />',field:'dygs',width:80},
                  {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
      				return formatDateTime(value);
      			  }},
      			  {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:100}
          	    ]],
		pagination:true,
		rownumbers:true,

		toolbar:[{
			text:'查询',
			iconCls:'icon-search',
			handler:function(){
				$('#w').window('open');	
				$("#sxkz").show();
			}},{
				text:'导出',
				iconCls:'icon-excel',
				handler:function(){
					$('#findForm').submit();
				}	
		}]
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
		ddlSZQYFind: $("#ddlSZQYFind").val(),
		txtZCDZL: $("#txtZCDZL").val(),
		txtXQTIP: $("#txtXQTIP").val()
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
				<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00306.title')}" /></span>
			</div>
				<div id="w" style="width:350px;height:200;padding:5px;background: #fafafa;">
				<div id="sxkz" style="display:none;">
				<form id="findForm" action="EXPT00306.action" method="post" target="_blank">
				<input type="hidden" name="hidSelect" id="hidSelect" />
					 <table width="300" border="0" cellspacing="0" cellpadding="0">
						  <tr>
						    <td>&nbsp;<s:property value="getText('app.xtwh.info.szqy')"/></td>
						    <td>&nbsp;<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/></td>
						  </tr>
						  <tr>
					        <td>&nbsp;<s:property value="getText('app.xtwh.t00303.xqmc')"/></td>
					        <td>&nbsp;<input name="txtXQTIP" id="txtXQTIP" type="text"/></td>
					      </tr>
						  <tr>
							<td>&nbsp;<s:property value="%{getText('app.xtwh.t00303.zcdzl')}" /></td>
							<td>&nbsp;<input name="txtZCDZL" id="txtZCDZL" type="text"/></td>
						</tr>
						</table>
				</form>	
				</div>
				</div>
				<div class="divtop">
                </div>
				<table id="test"></table>
		<div class="divbottom">
			<div>
				<table cellpadding="0" cellspacing="0" class="tablebottom">
					<tr>
						<td>
							<a href="ADDT00306.action?ACT=C">
        						<img src="../images/ico/Add.gif" width="16" height="16"/><s:property value="getText('app.button.add')"/>
      						</a>
						</td>
					    <td>
							<!-- <a id="delSel" href="javascript:;" class="easyui-linkbutton" plain="true" iconCls="icon-delete"><s:property value="getText('app.button.xzdel')"/></a> -->
						</td>
					     <td>
			                 <form action="../xtwh/LFXXUPLOAD.action" method="post" id="uploadForm" enctype="multipart/form-data">
						          <input type="file" name="upload" id="upload" size="50" />
						          <input name="btnUpd" type="button" id="btnUpd" class="button" value="上  传" />
				            </form>
			             </td>
					</tr>
					   <tr>
						<td></td>
						<td></td>
				       <td ><span style="color:red">*注：导入数据前，请确定数据格式及内容正确！</span><a href="../Date/import_lfxx.xls" target="_blank">模板下载</a></td>
				    </tr>
				</table>
			</div>
		</div>
		</div>
    </td>
  </tr>
</table>
</body>
</html>