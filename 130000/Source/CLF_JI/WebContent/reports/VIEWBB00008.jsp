<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/reports/VIEWBB00008.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});
</script>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
    <div class="ui-widget-content">
	<div class="datagrid-title">
		<span class="datagrid-title-text">
				<s:property value="%{getText('app.cxtj.bb00007.title')}" />
	     </span>
	</div>    
<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>
		<td>
			<div style="background:#efefef;">				
				<div id="bb" style="width:450px;height:250px;padding:5px;background: #fafafa;">
				<div id="sxkz" style="display:none;">
					<form id="findForm" action="EXPBB00008.action" method="post">
					<input type="hidden" name="hidSelect" id="hidSelect" />
						<table width="400" border="0" cellspacing="0" cellpadding="0">
							<tr>
							    <td>&nbsp;年月份从</td>
							    <td><input type="text" id="txtPSSDMIN" name="txtPSSDMIN" value="<s:property value="txtPSSDMIN"/>" onfocus="WdatePicker({dateFmt:'yyyyMM'})" class="Wdate"/></td>
							    <td>到</td>
								<td><input type="text" id="txtPSSDMAX" name="txtPSSDMAX" value="<s:property value="txtPSSDMAX"/>" onfocus="WdatePicker({dateFmt:'yyyyMM'})" class="Wdate"/></td>
							</tr>
							<tr>
								 <td>&nbsp;<s:property value="getText('app.xtwh.info.ssgx')" /></td>
								 <td><span class="txtInfonm"><input type="text" id="txtSSGXTIP" name="txtSSGXTIP" value="<s:property value="txtSSGXTIP"/>" readonly="readonly"/><span id="spSSGX"></span></span>
								 <input type="hidden" id="txtSSGX" name="txtSSGX" value="<s:property value="txtSSGX"/>">
								 <s:if test="%{null != txtSSGX && '' != txtSSGX}"><script type="text/javascript">getSSGX('<s:property value="txtSSGX" />','#txtSSGXTIP');</script></s:if>
								</td>
						    </tr>
						</table>
					</form>	
				</div>
				</div>					
			</div>
			<div class="divtop">
				<span><a id="subA" href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></span><a id="expA" href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="icon-excel">导出</a>
		  	</div>
			<table id="tab" class="easyui-datagrid" style="height:350px"></table>
			
		</td>
	</tr>
</table>
</div>
<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
	<div id="infoTreeDIV"></div>
</div> 
  </td>
  </tr>
</table>
</body>
</html>
