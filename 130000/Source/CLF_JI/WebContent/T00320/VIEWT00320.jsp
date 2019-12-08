<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/T00320/VIEWT00320.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<script type="text/javascript">
$(function(){
	$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
	$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	var pgjg;
	if($("#rdoPGJG0:checked").val()==0)
		pgjg = 0;
	if($("#rdoPGJG1:checked").val()==1)
		pgjg = 1;
	
	
	$('#test').datagrid({
		
		striped: true,
		height: getGirdHeight(),
		url:'../sjcj/FINDT00320.action',
		sortOrder: 'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {
			ddlSZQYFind : $("#ddlSZQYFind").val(),
			txtJYSJFind : $("#txtJYSJFind").val(),
			rdoPGJG : pgjg,
			txtZHFind : $("#txtZHFind").val(),
			txtDYFind : $("#txtDYFind").val(),
			txtBWJFHFind : $("#txtBWJFHFind").val(),
			txtZCDZLFind : $("#txtZCDZLFind").val(),
			txtSSGX : $("#txtSSGX").val(),
			txtXQTIP:$("#txtXQTIP").val()
		
		},
		frozenColumns:[[
                  {title:'<input type="checkbox" name="chkSelAll" id="chkSelAll" class="rootCheck radio" value="true"/>',field:'checkbox',width:30,align:'center',formatter:function(value,rec){
                       return "<input type='checkbox' name='chkSel' id='chkSel'  value='"+rec.fcid+"' class='childCheck radio'/>";
                   }},
                   {title:'操作',field:'edit',width:40,align:'center',formatter:function(value,rec){
	   					if (rec.fcid!=null)
	   						return "<a href=ADDT00320.action?ACT=U&TSIGN=320&FCID=" + rec.fcid + "><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a><a href=ADDT00320.action?ACT=D&TSIGN=320&FCID=" + rec.fcid + "><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
	   					else
	   						return "";
	   				}},
                   {title:'估价状态',field:'state',width:60,align:'center',formatter:function(value,rec){
           			if(rec.cwxx > 0){
           				return "<a href='javascript:showWin(\""+rec.fcid+"\");'><img title=\"未通过\" alt='未通过' src='../images/ico/21.gif'/></a>";
                   	}else{
                   		return "";
                       }
       				}}
   		]],
		columns:[[
			     	 {title:'<s:property value="%{getText('app.sjcj.t00320.fcid')}" />',field:'fcid',width:150,formatter:function(value,rec){
						return "<a href=javascript:Show('../sjcj/DETAILT00320.action?FCID=" + value + "',300,420,'全面评估市场法房产详细信息'); title='点击查看详细信息' >" + value + "</a>";
					 }},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.fczh')}" />',field:'fczh', algin:'left', width:150},
					 {title:'<s:property value="%{getText('app.xtwh.t00303.clh')}" />',field:'clh', align:'left', width:150},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.nsrmc')}" />', field:'nsrmc', align:'left', width:100},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.zjlx')}" />', field:'zjlx', align:'left', width:100},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.zjhm')}" />', field:'zjhm', align:'left', width:150},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.lxdh')}" />', field:'lxdh', align:'left', width:150},
		             {title:'<s:property value="%{getText('app.sjcj.t00320.szqy')}" />',field:'szqy', align:'left',width:80},
		             {title:'<s:property value="%{getText('app.sjcj.t00320.xqnm')}" />',field:'xqnm', align:'left',width:180},
		             {title:'<s:property value="%{getText('app.sjcj.t00320.zcdzl')}" />', field:'zcdzl', align:'left',width:150},					
					 {title:'<s:property value="%{getText('app.sjcj.t00320.zh')}" />', field:'zh', align:'left', width:80},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.dyh')}" />', field:'dyh', align:'left', width:80},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.fh')}" />', field:'fh', align:'left', width:80},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.fwlx')}" />',field:'fwlx', align:'left',width:120},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.jcnf')}" />',field:'jcnf', align:'left', width:120},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.jzjg')}" />',field:'jzjg', align:'left',width:120},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.ghyt')}" />',field:'ghyt', align:'left',width:120},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.jylx')}" />',field:'jylx', align:'left', width:120},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.jzmj')}" />',field:'jzmj',align:'right',width:120,formatter:function(value,rec){
							return formatNumber(value,'#,##0.00');
					 }},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.zlc')}" />', field:'zlc', align:'right', width:80},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.szlc')}" />',field:'szlc',align:'right',width:80},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.hdjg')}" />',field:'hdjg',align:'right',width:100,formatter:function(value,rec){
						 return '￥'+formatNumber(value,'#,##0.00');
					 }},
					 {title:'<s:property value="%{getText('app.sjcj.t00320.zhxz')}" />',field:'zhxz', align:'left', width:250},
					 {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',algin:'left', width:120, formatter:function(value, rec){
						 return formatDateTime(value);
					 }},
					 {title:'<s:property value="%{getText('app.czr')}" />',field:'czr', align:'left', width:80},
					 {title:'<s:property value="%{getText('app.note')}" />',field:'note', align:'left', width:250}
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
		}]
	});
	$('.rootCheck').click(function(){
		$(".childCheck").each(function(){
			$(this)[0].checked=$('.rootCheck')[0].checked;
		});
	});
});
function searchDate() {
	var pgjg;
	if($("#rdoPGJG0:checked").val()==0)
		pgjg = 0;
	if($("#rdoPGJG1:checked").val()==1)
		pgjg = 1;
	$('#test').datagrid('options').pageIndex = 1;
	var p = $('#test').datagrid('getPager');
	if (p){
		$(p).pagination({
			pageIndex : 1
		});
	}
	
	$('#test').datagrid('options').queryParams = 
    {
		ddlSZQYFind : $("#ddlSZQYFind").val(),
		txtJYSJFind : $("#txtJYSJFind").val(),
		rdoPGJG : pgjg,
		txtZHFind : $("#txtZHFind").val(),
		txtDYFind : $("#txtDYFind").val(),
		txtBWJFHFind : $("#txtBWJFHFind").val(),
		txtZCDZLFind : $("#txtZCDZLFind").val(),
		txtSSGX : $("#txtSSGX").val(),
		txtXQTIP:$("#txtXQTIP").val()
	};
	$('#test').datagrid('reload');		
};


</script>
<style type="text/css">
.WdatefocusL{
	background:url(../scripts/DatePicker/skin/datePicker.gif) no-repeat right;
}
</style>
</head>
<body>
<table  align="left" cellpadding="0" cellspacing="0" class="table1" >
  <tr>
    <td align="left" valign="top">
	   	<div class="ui-widget-content">
			<div class="datagrid-title">
              <span class="datagrid-title-text"><s:property value="%{getText('app.sjcj.t00320.title')}" /></span>
			</div>
			
			<div id="w" style="width:390px;height:250;padding:5px;background: #fafafa;">
			<div id="sxkz" style="display:none;">
			<form id="editForm" action="EXECPG00320.action" method="post">
			<input type="hidden" id="hidFlag" name="hidFlag" />
			<input type="hidden" id="hidSelect" name="hidSelect" />
			<input type="hidden" id="txtPSSD" name="txtPSSD" />
			<input type="hidden" id="chkSel" name="chkSel" />
			<table width="340" border="0" cellspacing="0" cellpadding="0">
			  <tr>
			    <td>&nbsp;<s:property value="getText('app.xtwh.info.szqy')"/></td>
			    <td>&nbsp;<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/></td>
			  </tr>
			  <tr>
			    <td>&nbsp;<s:property value="getText('app.xtwh.t00303.xqmc')"/></td>
			    <td>&nbsp;<input type="text" name="txtXQTIP" id="txtXQTIP" /></td>
			  </tr>
			  <tr>
			  	<td>&nbsp;<s:property value="getText('app.sjcj.t00320.jysj')" /></td>
			  	<td>&nbsp;<input  name="txtJYSJFind" id="txtJYSJFind" type="text" value=""   onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="WdatefocusL" />
			  			  <span id="pgjgSpan" style="display:none;">
			  			  <input type="radio" class="radio" name="rdoPGJG" id="rdoPGJG1" value="1"  />有价格
					 	  <input type="radio" class="radio" name="rdoPGJG" id="rdoPGJG0" value="0" />无价格
					 	  </span>
				</td>
			  </tr>
			  <tr>
			  	<td>&nbsp;<s:property value="getText('app.sjcj.t00320.zcdzl')" /></td>
			  	<td>&nbsp;<input name="txtZCDZLFind" id="txtZCDZLFind" type="text" /></td>
			  </tr>
			  <tr>
			  	<td>&nbsp;<s:property value="getText('app.sjcj.t00320.zh')" /></td>
			  	<td>&nbsp;<input type="text" name="txtZHFind" id="txtZHFind" /></td>
			  </tr>
			  <tr>
			  	<td>&nbsp;<s:property value="getText('app.sjcj.t00320.dyh')" /></td>
			  	<td>&nbsp;<input type="text" name="txtDYFind" id="txtDYFind" /></td>
			  </tr>
			  <tr>
			  	<td>&nbsp;<s:property value="getText('app.sjcj.t00320.fh')" /></td>
			  	<td>&nbsp;<input type="text" name="txtBWJFHFind" id="txtBWJFHFind" /></td>
			  </tr>
			  <tr>
				<td>&nbsp;<s:property value="getText('app.xtwh.info.ssgx')" /></td>
				<td>&nbsp;<span class="txtInfonm"><input type="text" id="txtSSGXTIP" name="txtSSGXTIP" /><span id="spSSGX"></span></span>
				<input type="hidden" id="txtSSGX" name="txtSSGX" value="<s:property value="txtSSGX"/>" />
				<s:if test='%{txtSSGX != null}'><script type="text/javascript">getSSGX('<s:property value="txtSSGX" />','#txtSSGXTIP')</script></s:if>
				</td>
			  </tr>
			</table>	
			</form>
			</div>
			</div>
			<div id="pssdDiv" style="width:350px;height:220;padding:5px;background: #fafafa;">
			<div id="sxkz2" style="display:none;">
				<table width="300" border="0" cellspacing="0" cellpadding="0">
					<tr>
					  <td colspan="2"><span style="color:red">*注：评估数据前，请选择评税时点！</span></td>
					</tr>
					<tr>
				      <td>&nbsp;<s:property value="getText('app.sjcj.t00320.pssd')"/></td>
				      <td><input  name="txtPSSDT" id="txtPSSDT" type="text" value=""   onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdatefocus" /></td>
				    </tr>
				</table>
			</div>
			</div>
			<table id="test"></table>
		<div class="divbottom">
			<div>
				<table cellpadding="0" cellspacing="0" style="width:650px" class="tablebottom">
					<tr>
						<td>
							<a href="javascript:void(0)" id="pgBtn">
        						<img src="../images/ico/evaluate.gif" width="16" height="16"/><s:property value="getText('app.sjpg.pg00000.button.pg')"/>
      						</a>
						</td>
						<td>
							<a href="javascript:void(0)" id="pgBtnAll">
        						<img src="../images/ico/evaluate.gif" width="16" height="16"/><s:property value="getText('app.sjpg.pg00000.button.pgAll')"/>
      						</a>
						</td>
						<td>
							<a id="delSel" href="javascript:;"><img src="../images/ico/Delete.gif" title="删除" alt="删除" width="16" height="16" />选择删除</a>
						</td>
					     <td>
			                 <form action="../sjcj/QMPGLRUPLOAD.action" method="post" id="uploadForm" enctype="multipart/form-data">
						          <input type="file" name="upload" id="upload" size="50" />
						          <input name="btnUpd" type="submit" id="btnUpd" class="button" value="上  传" />
				            </form>
			             </td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
				        <td ><span style="color:red">*注：导入数据前，请确定数据格式及内容正确！</span><a href="../Date/import_qmpglu.xls" target="_blank">模板下载</a></td>
				    </tr>
				</table>
			</div>
		</div>
		</div>
    </td>
  </tr>
</table>
<div id="dialog"  title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
	<div id="infoTreeDIV"></div>
</div>
</body>
</html>