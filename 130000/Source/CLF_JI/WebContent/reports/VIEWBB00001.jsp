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
<script type="text/javascript" src="../scripts/reports/VIEWBB00001.js"></script>
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
});
</script>
<s:if test='%{txtSSGX != null && txtSSGX !=""}'>
	<script type="text/javascript">
		getSSGX('<s:property value="txtSSGX" />','#txtSSGXTIP');
	</script>
</s:if>
</head>
<body>
<table  cellpadding="0" cellspacing="1" width="100%">
<tr>
	<td align="left" valign="top">
		<div class="ui-widget-content">
			<div class="datagrid-title">
				<span class="datagrid-title-text">
						<s:property value="%{getText('app.cxtj.bb00001.title')}" />
			     </span>
			</div> 
			<div id="bb" style="width:350px;height:360px;padding:5px;background: #fafafa;">
				<div id="sxkz" style="display:none;">
				<input type="hidden" name="hidSelect" id="hidSelect" />
				<table width="300" border="0" cellspacing="0" cellpadding="0">
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
						<td><s:property value="getText('app.xtwh.info.fwlx')" /></td>
						<td>
							<div  style="overflow:scroll;height:100px;">
							<s:iterator value="fwlxList" id="fwlxListId">
								<input name="ddlFWLX" id="ddlFWLX"  type="checkbox" class="checkbox radio"
									<s:iterator value="ddlFwlxList" id="ddlFwlxListId" >
										<s:if test='%{#ddlFwlxListId == #fwlxListId.infoid}'>checked="checked"</s:if>
									</s:iterator>
								value="<s:property value="infoid"/>"/><s:property value="infonm" /><br/>
							</s:iterator>
							</div>
						</td>
					</tr>
				
				</table>
				</div>
			</div>
	      <div class="divtop">
				<span><a id="subA" href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></span>
		  </div>
		<table id="tab"></table>

	</div>
	<div id="dialog"  title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div> 
	</td>
</tr>
</table>
</body>
</html>
