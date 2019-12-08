<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/T00351/VIEWT00351.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00053/T00053TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<link type="text/css" rel="stylesheet" href="../css/jquery.autocomplete.css" />
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
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
		url:'../xtwh/FINDT00351.action',
		sortOrder: 'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {
			ddlSZQYFind : $("#ddlSZQYFind").val(),
			txtXQFind : $("#txtXQFind").val(),
			txtSLIDFind : $("#txtSLIDFind").val(),
			txtZCDZL : $("#txtZCDZL").val(),
			txtFWLX : $("#txtFWLX").val(),
			txtJYSJFind : $("#txtJYSJFind").val()
		},
		frozenColumns:[[
       		{title:'<input type="checkbox" name="chkSelAll" id="chkSelAll" class="rootCheck radio" value="true"/>',field:'checkbox',width:30,align:'center',formatter:function(value,rec){
				return "<input type='checkbox' name='chkSel' id='chkSel' value='"+ rec.slid +"' class='childCheck radio'/>";
			}},
   			{title:'操作',field:'edit',width:50,align:'center',formatter:function(value,rec){
   					return "<a href=\"javascript:showpParentWin('[标准房数据编辑]','xtwh/ADDT00351.action?ACT=U&SLID=" + encodeURI(rec.slid)+ "','frameBZFBG'); \"><img src=\"../images/ico/Edit.gif\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;<a href=ADDT00351.action?ACT=D&SLID=" + encodeURI(rec.slid) + "><img src=\"../images/ico/Delete.gif\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
   			}}
		]],
		columns:[[	    
            {title:'<s:property value="%{getText('app.xtwh.t00351.slid')}" />',field:'slid',width:150,formatter:function(value,rec){
   					return "<a href=javascript:Show(\'../xtwh/DETAILT00351.action?SLID=" + rec.slid + "\',300,420,'00351'); title='点击查看详细信息' >" + rec.slid + "</a>";
   			}},
            {title:'<s:property value="%{getText('app.xtwh.info.szqy')}" />',field:'szqy',width:120},
            {title:'<s:property value="%{getText('app.xtwh.t00303.xqmc')}" />',field:'xqnm',width:120},
<!--            {title:'<s:property value="%{getText('app.xtwh.t00303.zcdzl')}" />',field:'fwtdzl',width:200},-->
            {title:'<s:property value="%{getText('app.xtwh.info.jzjg')}" />',field:'jzjg',width:120},
            {title:'<s:property value="%{getText('app.xtwh.info.fwlx')}" />',field:'fwlx',width:150},
<!--            {title:'<s:property value="%{getText('app.xtwh.t00351.szlc')}" />',field:'szlc',width:80},-->
            {title:'<s:property value="%{getText('app.xtwh.t00351.jcsj')}" />',field:'jcsj',width:120,align:'right'},
            {title:'<s:property value="%{getText('app.xtwh.t00351.jysj')}" />',field:'jysj',width:100,formatter:function(value,rec){
				return formatDate(value);
			}},
			{title:'<s:property value="%{getText('app.xtwh.t00351.zxpfmjg')}" />(元/平方米)',field:'dypfmjg',width:160,align:'right',formatter:function(value,rec){
	             return '￥'+formatNumber(value,'#,##0.00');
            }},
            {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
				return formatDateTime(value);
			}},
            {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:80},
            {title:'<s:property value="%{getText('app.note')}" />',field:'note',width:150}
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
		},{
			text:'导出',
			iconCls:'icon-excel',
			handler:function(){
				
					$('#findForm').submit();	
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
		ddlSZQYFind : $("#ddlSZQYFind").val(),
		txtXQFind : $("#txtXQFind").val(),
		txtSLIDFind : $("#txtSLIDFind").val(),
		txtZCDZL : $("#txtZCDZL").val(),
		txtFWLX : $("#txtFWLX").val(),
		txtJYSJFind : $("#txtJYSJFind").val()
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
		<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00351.title')}" /></span>                   
    </div>
    
      <div id="w" style="width:350px;height:450px;padding:5px;background: #fafafa;">
				<div id="sxkz" style="display:none;">
					<form id="findForm" action="../sjcx/EXPV00351.action" method="post" target="_blank">
					<input type="hidden" name="txtXQFind" id="txtXQFind" />					
						<table width="270" border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td><span class="titlespan"><s:property value="getText('app.xtwh.t00351.slid')" /></span>
								<input type="text" name="txtSLIDFind" id="txtSLIDFind" value="" /></td>
							</tr>
							<tr>
								<td><span class="titlespan"><s:property value="getText('app.xtwh.info.szqy')" /></span>
								<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部" /></td>
							</tr>			
							<tr>
								<td><span class="titlespan"><s:property value="%{getText('小区名称')}" /></span>
							    <input type="text" id="txtZCDZL" name="txtZCDZL" value="" /></td>
							</tr>
							<tr>
                                <td><span class="titlespan"><s:property value="getText('app.sjcj.t00302.jysj')"/></span>
                                <input type="text" id="txtJYSJFind" name="txtJYSJFind" value="<s:property value="txtJYSJFind"/>" onfocus="WdatePicker({maxDate:'%y-%M-%d'})" class="Wdate"/></td>
                                
                            </tr>
							<tr>
								<td valign="top"><span class="titlespan"><s:property value="getText('app.xtwh.t00303.xqmc')" /></span>
								<div class="infodivbz" id="T00352Tree"></div></td>
							</tr>
							
						</table>
						</form>	
			</div>	
			</div>
			
			<table id="test"></table>
			<div class="divbottom">
				<table cellpadding="0" cellspacing="0" style="width:100%">
					<tr>
						<td>
							<s:url id="urlAdd" action="ADDT00351">
							<s:param name="ACT">C</s:param>
							</s:url> 
							<s:a href="%{urlAdd}"><img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>" alt="<s:property value="getText('app.button.add')"/>" />
								<s:property value="getText('app.button.add')" />
							</s:a>
							<a href="javascript:DelData();" title="选择删除" id="selDel"><img src="../images/ico/Delete.gif" title="删除" alt="删除" width="16" height="16" align="absmiddle" />选择删除</a>
							<!-- <a href="VIEWT00351BZF.action"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.xtwh.t00351.scbzf.f')"/>" alt="<s:property value="getText('app.xtwh.t00351.scbzf')"/>" /><s:property value="getText('app.xtwh.t00351.scbzf')"/></a> -->
						</td>
						<td>
						<form action="../xtwh/BZFJGUPLOAD.action" method="post" id="uploadForm" enctype="multipart/form-data">
							<input type="file" name="upload" id="upload" size="50" />
							<input name="btnSearch" type="submit" id="btnSearch" class="button" value="上  传" />
						</form>
						<span style="color:red">*注：导入数据前，请确定数据格式及内容正确，单次导入上限为1000条数据！</span><a href="../Date/import_bzf.xls" target="_blank">模板下载</a>
						</td>
					</tr>
				</table>
				</div>
		</div>
		</td>
	</tr>
</table>
</body>

</html>
