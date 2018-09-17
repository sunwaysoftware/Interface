<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript"
	src="../scripts/easyui/jquery-1.4.2.min.js"></script>
<script type="text/javascript"
	src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />

<script type="text/javascript"
	src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00003/EDITT00003.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({
			cls : "success",
			html : '<s:property value="actionMessages.get(0)"/>'
		});
		$.notifyBar({
			cls : "error",
			html : '<s:property value="actionErrors.get(0)"/>'
		});
	});
</script>
<style type="text/css">
<!--
.labelA {
	width: 120px;
}
-->
</style>

</head>
<body>
	<table border="0" align="left" cellpadding="0" cellspacing="0"
		class="table1">
		<tr>
			<td align="left" valign="top">
				<div id="tabs"
					class="ui-tabs ui-widget ui-widget-content ui-corner-all">
					<div class="datagrid-title">
						<span class="datagrid-title-text"><s:property
								value="%{getText('app.xtwh.t00003.title')}" /></span>
					</div>
					<div id="INFO" class="divConect">
						<div style="min-height: 400px">
							<form action="EDITT00003.action" method="post" id="editForm"> 
							 <input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00003Bean.upddate"/></s:text>" />
							
								<table width="500" border="0" cellspacing="3" cellpadding="0">
							
									<tr>
										<td><label class="labelA"> <s:property
											value="getText('app.xtwh.t00003.expriydays')" /></label> <input type="text"
											class="txtfocus txtNumber" id="txtEXPIRYDAYS" name="txtEXPIRYDAYS"
											value='<s:property value="t00003Bean.expriyDays" default="0" />'
											<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> min="0"/></td>
										
									</tr>		
								</table>
							</form>
						</div>
						<div class="divbottom">
							<div>
								<a href="#" id="btnUpd" name="btnUpd" class="easyui-linkbutton" plain="true" iconCls="icon-edit"><s:property value="getText('app.button.upd')" /></a>							
							</div>
						</div>
					</div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>