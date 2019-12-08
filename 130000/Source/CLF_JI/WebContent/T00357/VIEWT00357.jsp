<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/T00357/VIEWT00357.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<link type="text/css" rel="stylesheet" href="../css/jquery.autocomplete.css" />
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00303/T00303DIV.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>


<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		
		binddata();

		$('.rootCheck').click(function(){
			$(".childCheck").each(function(){
				$(this)[0].checked=$('.rootCheck')[0].checked;
			});
		});	
	});
	function binddata(){
		$('#test').datagrid({					
			striped: true,
			height: getGirdHeight(),
			url:'../xtwh/FINDT00357.action',
			sortOrder: 'desc',
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
				txtSLIDFind : $("#txtSLIDFind").val(),
				txtSWIDFind : $("#txtSWIDFind").val(),
				txtNSRMCFind : $("#txtNSRMCFind").val(),
				txtFDCDATFind : $("#txtFDCDATFind").val(),
				ddlSZQYFind : $("#ddlSZQYFind").val(),
				txtXQFind : $("#txtXQFind").val(),
				txtZCDZL : $("#txtZCDZL").val()
			},
			frozenColumns:[[
			    {title:'<input type="checkbox" name="chkSelAll" id="chkSelAll" class="rootCheck radio" value="true"/>',field:'checkbox',width:30,align:'center',formatter:function(value,rec){
				return "<input type='checkbox' name='chkSel' id='chkSel' value='"+ rec.slid +"' class='childCheck radio'/>";
			}},
    			{title:'操作',field:'edit',width:60,align:'center',formatter:function(value,rec){
    				//if (rec.cd00301Swid!=null)
    					return "<a href=\"javascript:showpParentWin('[可比实例库数据编辑]','xtwh/ADDT00357.action?ACT=U&SLID=" + encodeURI(rec.slid) + "','frameKBSLKBG'); \"><img src=\"../images/ico/Edit.gif\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;<a href=ADDT00357.action?ACT=D&SLID=" + encodeURI(rec.slid) + "><img src=\"../images/ico/Delete.gif\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
    				//else
    				//	return "";
    			}}
			]],
			columns:[[	   
	            {title:'<s:property value="%{getText('app.xtwh.t00357.slid')}" />',field:'slid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../xtwh/DETAILT00357.action?SLID=" + encodeURI(rec.slid) + "\',300,420,'00357'); title='点击查看详细信息' >" + rec.slid + "</a>";
				}},
	            {title:'<s:property value="%{getText('app.xtwh.info.szqy')}" />',field:'szqy',width:100},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.swid')}" />',field:'cd00301Swid',width:150},
	            {title:'<s:property value="%{getText('app.sjcj.t00301.nsrmc')}" />',field:'nsrmc',width:80},
	            {title:'<s:property value="%{getText('app.xtwh.t00303.xqmc')}" />',field:'xqnm',width:150,formatter:function(value,rec){
					return "<span title='" + value + "'>" + value + "</span>";
				}},
	            {title:'<s:property value="%{getText('app.xtwh.t00303.zcdzl')}" />',field:'zcdzl',width:200,formatter:function(value,rec){
					return "<span title='" + value + "'>" + value + "</span>";
				}},
	            {title:'<s:property value="%{getText('app.xtwh.info.jzjg')}" />',field:'jzjg',width:100},
	            {title:'<s:property value="%{getText('app.xtwh.t00357.jzmj')}" />',field:'jzmj',align:'right',width:120,formatter:function(value,rec){
					return formatNumber(value,'#,##0.00');
				}},
	            {title:'<s:property value="%{getText('app.xtwh.info.fwlx')}" />',field:'fwlx',width:150},
	            {title:'<s:property value="%{getText('app.xtwh.t00357.szlc')}" />',field:'szlc',width:80},
	            {title:'<s:property value="%{getText('app.xtwh.info.jylx')}" />',field:'jylx',width:120},
	            {title:'<s:property value="%{getText('app.xtwh.t00357.jysj')}" />',field:'jysj',width:80,formatter:function(value,rec){
					return formatDate(value);
				}},
	            {title:'<s:property value="%{getText('app.xtwh.t00357.pgjg')}" />',align:'right',field:'pgjg',width:100,formatter:function(value,rec){
					return '￥'+formatNumber(value * rec.jzmj,'#,##0.00');
				}},
				{title:'<s:property value="%{getText('app.xtwh.t00357.pgjg_dj')}" />',align:'right',field:'pgjgdj',width:120,formatter:function(value,rec){
					return '￥'+formatNumber(rec.pgjg,'#,##0.00');
				}},
	           // {title:'<s:property value="%{getText('app.xtwh.t00357.fdcdat')}" />',field:'fdcdat',width:120},
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
						$("#sxkz").show();
				}
			},{
				text:'导出',
				iconCls:'icon-excel',
				handler:function(){
				$('#findForm').submit();
				}	
			}/*,{
				text:'创建标准房',
				iconCls:'icon-evaluate',
				handler:function(){
					makeBZF();
				}
			}*/]	
				
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
		    txtSLIDFind : $("#txtSLIDFind").val(),
			txtSWIDFind : $("#txtSWIDFind").val(),
			txtNSRMCFind : $("#txtNSRMCFind").val(),
			txtFDCDATFind : $("#txtFDCDATFind").val(),
			ddlSZQYFind : $("#ddlSZQYFind").val(),
			txtXQFind : $("#txtXQFind").val(),
			txtZCDZL : $("#txtZCDZL").val()
		};
		$('#test').datagrid('reload');		
	};
</script>
<style type="text/css">
.LeftText{
   margin: 3px;
   float: left;
   height: 180px;
   border: 1px solid #A6CBD9;
   background-color: #FFF;
}

.FootText{
   height: 180px;
}
.titlespan
{
 width:50px;
}
.Clear
{
   clear:both;
}
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
    <div class="ui-widget-content">
		<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00357.title')}" /></span>                 
  		</div><!--
  	    <div id="makeBZF" style="width:300px;height:200;padding:5px;background: #fafafa;">
				<div id="sxkzBZF" style="display:none;">
					<table width="200" border="0" cellspacing="2" cellpadding="0">
						<tr>
							<td><span class="titlespan"><s:property value="getText('app.xtwh.info.szqy')" /></span></td>
							<td><sw:szqy items="szqyList" name="ddlSZQYFindBZF" id="ddlSZQYFindBZF" display="全部"/></td>
						</tr>
						<tr>
						    <td><s:property value="getText('app.xtwh.t00303.xqmc')"/></td>
						    <td><span class="txtInfonm"><input name="txtXQTIPBZF" id="txtXQTIPBZF" type="text" /><span id="spXQDMBZF"></span></span>
						    <input type="hidden" id="txtXQFindBZF" name="txtXQFindBZF" value="<s:property value="txtXQFindBZF" />"/></td>
						</tr>
						<tr>
							<td><s:property	value="%{getText('app.xtwh.info.fwlx')}" /></td>
							<td><span class="txtInfonm"><input name="txtFWLXNmBZF" id="txtFWLXNmBZF" type="text" value="<s:property value="txtFWLXNmBZF" />" /><span id="spFWLXBZF"></span></span><input type="hidden" id="txtFWLXFindBZF" name="txtFWLXFindBZF" value="<s:property value="txtFWLXFindBZF" />"/></td>
						</tr>
					</table>
				</div>
				</div>
				--><div id="w" style="width:350px;height:450px;padding:5px;background: #fafafa;">	
				<div id="sxkz" style="display:none;">
					<form id="findForm" action="../sjcx/EXPV00357.action" method="post" target="_blank">
					<input type="hidden" name="txtXQFind" id="txtXQFind" />
					<input type="hidden" name="hidSelect" id="hidSelect" />
					<input type="hidden" id="txtFDCDATFind" name="txtFDCDATFind"/>					
					  <div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
							<div id="infoTreeDIV"></div>
						</div> 
					  <table width="220" height="437" border="0" cellspacing="2" cellpadding="0">
						<tr>
						  <td><span class="titlespan"><s:property value="%{getText('app.xtwh.t00357.slid')}" /></span></td>
						  <td><input type="text" class="txtID" id="txtSLIDFind" name="txtSLIDFind"/></td>
						</tr>
						<tr>
						  <td><s:property value="getText('app.sjcj.t00301.swid')"/></td>
						   <td><input type="text" class="txtID" id="txtSWIDFind" name="txtSWIDFind"/></td>
						</tr>
						<tr>
						  <td><span class="titlespan"><s:property value="getText('app.sjcj.t00301.nsrmc')"/></span></td>
						   <td><input type="text" class="txtNSRMC" id="txtNSRMCFind" name="txtNSRMCFind"/></td>
						</tr>
					    <!--
						<tr>
						  <td>&nbsp;<s:property value="getText('app.xtwh.t00357.fdcdat')"/>
						  <td>&nbsp;<input type="text" id="txtFDCDATFind" name="txtFDCDATFind"/></td>
						</tr>
						-->
						<tr>
						  <td><span class="titlespan"><s:property value="getText('app.xtwh.info.szqy')"/></span></td>
						      <td><sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/></td>
						</tr>	
						<tr>
							<td><span class="titlespan"><s:property value="%{getText('app.xtwh.t00303.zcdzl')}" /></span></td>
							 <td><input name="txtZCDZL" id="txtZCDZL" type="text"/></td>
						</tr>
						<tr>
						  <td colspan="2"><span class="titlespan"><s:property value="getText('app.xtwh.t00303.xqmc')"/></span>
						   <div class="infodivbz" id="T00352Tree"></div></td>
						</tr>
					</table>  
					</form>
					</div>
					</div>
					
				<table id="test"></table>
				<!-- 
				<div>
					<s:url id="urlAdd" action="ADDT00357"><s:param name="ACT">C</s:param></s:url>
					<s:a href="%{urlAdd}">
						<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>" alt="<s:property value="getText('app.button.add')"/>" /><s:property value="getText('app.button.add')"/>
					</s:a>
				</div> -->
				<div class="divbottom">
				    <table cellpadding="0" cellspacing="0" style="width:600px">
						<tr>
						<td>
							<s:url id="urlAdd" action="ADDT00357"><s:param name="ACT">C</s:param></s:url>
							<s:a href="%{urlAdd}">
								<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>" alt="<s:property value="getText('app.button.add')"/>" /><s:property value="getText('app.button.add')"/>
							</s:a>
							<a href="javascript:DelData();" title="选择删除" id="selDel"><img src="../images/ico/Delete.gif" title="删除" alt="删除" width="16" height="16" align="absmiddle" />选择删除</a>
						</td>
						<td>
							<form action="../xtwh/KBSLKUPLOAD.action" method="post" id="uploadForm" enctype="multipart/form-data">
								<input type="file" name="upload" id="upload" size="50" />
								<input name="btnUpd" type="submit" id="btnUpd" class="button" value="上  传" />
							</form>
						</td>
						</tr>
						<tr>
						<td></td>
						<td ><span style="color:red">*注：导入数据前，请确定数据格式及内容正确！</span><a href="../Date/import_kbsl.xls">模板下载</a></td>
						</tr>
					</table>
				</div>			
	</div>
    </td>
  </tr>
</table>
</body>
</html>
