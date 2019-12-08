<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/chart/charts.js"></script>
<script type="text/javascript" src="../scripts/chart/modules/exporting.js"></script>	
<script type="text/javascript" src="../scripts/reports/VIEWBB00004.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<script type="text/javascript">
$(function() {
	$.notifyBar( {
		cls : "success",
		html : '<s:property value="actionMessages.get(0)"/>'
	});
	$.notifyBar( {
		cls : "error",
		html : '<s:property value="actionErrors.get(0)"/>'
	});
	<s:if test='%{txtSSGX != null && txtSSGX !=""}'>
	getSSGX('<s:property value="txtSSGX" />','#txtSSGXTIP');
	</s:if>
});
</script>
</head>
<body>
<div class="ui-widget-content">
	<div class="datagrid-title">
		<span class="datagrid-title-text">
				<s:property value="%{getText('app.cxtj.bb00004.title')}" />
	     </span>
	</div>	
	<div id="bb" style="width:400px;height:200px;padding:5px;background: #fafafa;">
		<div id="sxkz" style="display:none;">
			<form id="findForm" action="FINDBB00004.action" method="post">
			<input type="hidden" name="hidSelect" id="hidSelect" />
			<input type="hidden" name="sign" id="sign" />
			<table width="350" border="0" cellspacing="0" cellpadding="0">
			<tr>
					<td><s:property value="getText('app.xtwh.info.ssgx')" /></td>
					<td><span class="txtInfonm"><input type="text" id="txtSSGXTIP" name="txtSSGXTIP" /><span id="spSSGX"></span></span>
					<input type="hidden" id="txtSSGX" name="txtSSGX" value="<s:property value="txtSSGX"/>" />
					
					</td>
				</tr>			
		    	<tr>
					<td>年份</td>
					<td><input id="txtPSSDFind" name="txtPSSDFind" value="<s:property value="txtPSSDFind"/>"  onfocus="WdatePicker({dateFmt:'yyyy'})" class="Wdatefocus"/></td>
				</tr>				
				<tr>
					<td><s:property value="getText('app.sjcj.t00302.jyjg')" /></td>
					<td><input type="text" id="txtJYJGMinFind" name="txtJYJGMinFind" class="txtNumber" value="<s:property value="txtJYJGMinFind"/>" />-<input type="text" id="txtJYJGMaxFind" class="txtNumber" name="txtJYJGMaxFind" value="<s:property value="txtJYJGMaxFind"/>" /></td>
				</tr>	
				
			</table>
			</form>						
		</div>		
	</div>
	<div class="divtop">
		<span><a id="subA" href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></span>
  	</div>
	<div id="appChart" style="width: 100%; height: 400px; margin: 0 auto;"></div>
</div>
<div id="dialog"  title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
<div id="infoTreeDIV"></div>
</div>
<div id="msg"></div>
</body>
</html>
