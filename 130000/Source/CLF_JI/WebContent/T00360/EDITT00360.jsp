<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00360/EDITT00360.js"></script>

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
	width: 80px;
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
					class="ui-widget-content">

					<div class="datagrid-title">
						<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00360.title')}"/></span>
					</div>
					<div id="INFO" class="divConect">
						<div style="min-height: 400px">
							<form action="EDITT00360.action" method="post" id="editForm">
								<input type="hidden" name="ACT" id="ACT"
									value='<s:property value="ACT"/>' /> <input type="hidden"
									name="txtID" id="txtID"
									value='<s:property value="t00360Bean.id"/>' /> <input
									type="hidden" name="txtUPDATE" id="txtUPDATE"
									value="<s:text name="app.global.format.datetime"><s:param value="t00360Bean.upddate"/></s:text>" />
								<s:if test='%{ACT!="C"}'>
									<input type="hidden" name="ddlSZQY"
										value='<s:property value="t00360Bean.cd00001Szqy"/>' />
								</s:if>
								<table width="500" border="0" cellspacing="3" cellpadding="0">
									<tr>
										<td><label class="labelA"> <s:property
													value="getText('app.xtwh.info.szqy')" />
										</label> <sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus"
												id="ddlSZQY" checked="t00360Bean.cd00001Szqy" disabled="ACT" /></td>
									</tr>
									<tr>
										<td><label class="labelA"> <s:property
													value="%{getText('app.xtwh.info.fwlx')}" />
										</label> <span class="txtInfonm txtfocus"><input
												name="txtFWLXTIP" id="txtFWLXTIP" type="text"
												<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>
												readonly="readonly"
												<s:if test='%{ACT != "C"}'> value="<s:property value="t00360Bean.fwlx" />"</s:if>
												class="typeInput" /><span
												<s:if test='%{ACT!="D"}'> id="spFWLX"</s:if>></span></span><input
											type="hidden" id="txtFWLX" name="txtFWLX"
											<s:if test='%{ACT != "C"}'> value="<s:property value="t00360Bean.cd00001Fwlx" />"</s:if> />
										</td>
									</tr>
									<tr>
										<td><label class="labelA"> <s:property
													value="getText('app.xtwh.t00360.jzmjmin')" /></label> <input
											type="text" class="easyui-numberbox txtfocus txtNumber"
											id="txtJZMJMIN" name="txtJZMJMIN"
											value='<s:property value="t00360Bean.jzmjMin" default="0" />'
											<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>
											precision="2" min="0" /></td>
									</tr>
									<tr>
										<td><label class="labelA"> <s:property
													value="getText('app.xtwh.t00360.jzmjmax')" />
										</label> <input type="text"
											class="easyui-numberbox txtfocus txtNumber" id="txtJZMJMAX"
											name="txtJZMJMAX"
											value='<s:property value="t00360Bean.jzmjMax" default="0" />'
											<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>
											precision="2" min="0" /></td>
									</tr>
									<tr>
										<td><label class="labelA"> <s:property
													value="getText('app.xtwh.sywh.xzxs')" />
										</label> <input type="text"
											class="easyui-numberbox txtfocus txtNumber" id="txtXZXS"
											name="txtXZXS"
											value="<s:property value="t00360Bean.xzxs" default="0" />"
											<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>
											precision="2" /></td>
									</tr>
									<tr>
										<td><label class="labelA"> <s:property
													value="%{getText('app.note')}" />
										</label><textarea name="txtNOTE" cols="20" rows="3" id="txtNOTE"
												<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>><s:property value="t00360Bean.note" /></textarea></td>
									</tr>
								</table>
							</form>
						</div>
						<div class="divbottom">
							<div>
								<a href="javascript:void(0)" id="btnUpd" name="btnUpd"
									<s:if test='%{ACT!="U"}'>style="display:none"</s:if>><img
									src="../images/ico/Edit.gif" width="16" height="16"
									title="<s:property value="getText('app.button.upd')"/>"
									alt="<s:property value="getText('app.button.upd')"/>" />
								<s:property value="getText('app.button.upd')" /></a><a href="javascript:void(0)"
									id="btnDel" name="btnDel"
									<s:if test='%{ACT!="D"}'>style="display:none"</s:if>><img
									src="../images/ico/Delete.gif" width="16" height="16"
									title="<s:property value="getText('app.button.del')"/>"
									alt="<s:property value="getText('app.button.del')"/>" />
								<s:property value="getText('app.button.del')" /></a><a href="javascript:void(0)"
									id="btnAdd" name="btnAdd"
									<s:if test='%{ACT!="C"}'>style="display:none"</s:if>><img
									src="../images/ico/Update.gif" width="16" height="16"
									title="<s:property value="getText('app.button.save')"/>"
									alt="<s:property value="getText('app.button.save')"/>" />
								<s:property value="getText('app.button.save')" /></a> <a
									href="VIEWT00360.action"><img
									src="../images/ico/Cancel.gif" width="16" height="16"
									title="<s:property value="getText('app.button.back')"/>"
									alt="<s:property value="getText('app.button.back')"/>" />
								<s:property value="getText('app.button.back')" /></a>
							</div>
						</div>
					</div>
				</div>
			</td>
		</tr>
	</table>
	<div id="dialog" title="请选择类型..." icon="icon-ok"
		style="width: 350px; height: 350px; padding: 5px; background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>
</body>
</html>