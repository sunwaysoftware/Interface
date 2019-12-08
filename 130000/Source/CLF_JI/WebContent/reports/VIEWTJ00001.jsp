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
<script type="text/javascript" src="../scripts/reports/VIEWTJ00001.js"></script>
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
</head>
<body>
<table cellpadding="0" cellspacing="1" width="100%">
<tr>
	<td align="left" valign="top">
		<div class="ui-widget-content">
			<div class="datagrid-title">
				<span class="datagrid-title-text">
						<s:property value="%{getText('app.cxtj.tj00001.title')}" />
			     </span>
			</div> 
		
	      <div class="divtop">
	      <form id="findForm">
	      <span>统计时间</span>
	      <input id="txtRdsjBgn" value="<s:property value="txtRdsjBgn"/>" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdatefocus" />--
	      <input id="txtRdsjEnd" value="<s:property value="txtRdsjEnd"/>" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdatefocus"/>
				<span><a id="subA" href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></span>
				<span><a id="subB" href="VIEWTJ00001XLS.do" class="easyui-linkbutton" plain="true" iconCls="icon-excel" target="_blank">Excel格式导出</a></span>
				<span><a id="subC" href="VIEWTJ00001PDF.do" class="easyui-linkbutton" plain="true" iconCls="icon-print" target="_blank">PDF格式打印</a></span>
				<span class="txtRed">单位：万元</span>
		  </form>
		  </div>		  
		<table id="tab" class="easyui-datagrid"></table>
	</div>
	</td>
</tr>
</table>
</body>
</html>
