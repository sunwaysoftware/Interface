<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00013/VIEWT00013.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
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
			url:'../xtwh/FINDT00013.action',
			sortOrder: 'desc',
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
				txtLOGTYPEFind: $("#txtLOGTYPEFind").val(), 
				txtTABLENAMEFind: $("#txtTABLENAMEFind").val(), 
				txtCZRFind: $("#txtCZRFind").val(),
				txtSSGX : $("#txtSSGX").val()
			},		
			columns:[[	 
	             {title:'<s:property value="%{getText('app.xtwh.t00013.tablename')}" />',field:'tablename',width:150},
	            {title:'<s:property value="%{getText('app.xtwh.t00013.tablekey')}" />',field:'tablekey',width:180},
	            {title:'<s:property value="%{getText('app.xtwh.t00013.logtypename')}" />',field:'logtypename',width:150},
	            {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
					return formatDateTime(value);
				}},
	            {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:80},
	            {title:'<s:property value="%{getText('app.xtwh.t00013.czr')}" />',field:'cd00002Czr',width:80},
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
			txtLOGTYPEFind: $("#txtLOGTYPEFind").val(), 
			txtTABLENAMEFind: $("#txtTABLENAMEFind").val(), 
			txtCZRFind: $("#txtCZRFind").val(),
			txtSSGX : $("#txtSSGX").val()
		};
		$('#test').datagrid('reload');		
	};
</script>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
    <div class="ui-widget-content">
		<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00013.title')}" /></span>                 
  		</div>	
	
   <div id="w" style="width:350px;height:250px;padding:5px;background: #fafafa;">	
   <form id="findForm" action="#" method="post">
    <table width="300" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;<s:property value="getText('app.xtwh.t00013.logtype')"/></td>
        <td>&nbsp;<select id="txtLOGTYPEFind" name="txtLOGTYPEFind">
			<option>全部</option>
			<s:iterator value="czList" status="step">
			<option value="<s:property value="logType"/>"><s:property value="logTypeName"/></option>
			</s:iterator>
			</select></td>
      </tr>
      <tr>
        <td>&nbsp;<s:property value="getText('app.xtwh.t00013.tablename')"/></td>
        <td>&nbsp;<input type="text" id="txtTABLENAMEFind" name="txtTABLENAMEFind" value="<s:property value="txtTABLENAMEFind" />"/></td>
      </tr>
      <tr>
        <td>&nbsp;<s:property value="getText('app.xtwh.t00013.czr')"/></td>
        <td>&nbsp;<input type="text" id="txtCZRFind" name="txtCZRFind" value="<s:property value="txtCZRFind" />" /></td>
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
		<!--<input name="btnSearch" type="button" id="btnSearch" class="button" value="<s:property value="getText('app.button.search')"/>" /><input name="btnConditions" type="button" title="显示搜索条件" id="btnConditions" class="button" value="↓" />-->
	
	<table id="test"></table>
	<div class="divbottom">
	<a href="ADDT00013.action">
			<img src="../images/ico/Delete.gif" width="16" height="16" title="<s:property value="getText('app.button.del')"/>" alt="<s:property value="getText('app.button.del')"/>" /><s:property value="getText('app.button.del')"/></a>
		</div>
    </div>
    <div id="dialog"  title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
				<div id="infoTreeDIV"></div>
			</div>
    </td>
  </tr>
</table>
</body>
</html>
