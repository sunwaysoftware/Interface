<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/easyui/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00001/EDITT00001.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>

<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
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
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
		 <div id="tabs" class="ui-tabs ui-widget ui-widget-content ui-corner-all">
        <div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.menu.CSSZ.CSSZ')}" /></span>
		</div>
		<div id="INFO" class="divConect">
		<div style="min-height:400px">
		<form id="editForm" action="EDITT00001.action" method="post">
			<input type="hidden" name="ACT" value="<s:property value="ACT"/>" />
			<s:if test='%{ACT!="C"}'>
				<input name="ddlROOTID" type="hidden" id="ddlROOTNM" value="<s:property value="t00001Dao.rootid" />" />
				<input name="txtINFOID" type="hidden" id="txtINFOID" value="<s:property value="t00001Dao.infoid" />" />
			</s:if>
		<table width="450" border="0" cellspacing="0" cellpadding="2">
			<tr>
				<td colspan="2" align="center">
				<s:property value="%{getText('app.xtwh.t00001.rootnm')}" />&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="hidden" id="txtROOTID" name="txtROOTID" class="txtfocus" maxlength="3" size="3" value="<s:property value="t00001Dao.rootid" />"
					<s:if test='%{ACT!="C"}'>disabled="disabled"</s:if> />
					<select name="ddlROOTID" id="ddlROOTID" class="txtfocus" <s:if test='%{ACT!="C"}'>disabled="disabled"</s:if>>
						<option value="">请选择...</option>
						<s:iterator value="objList" status="index">
							<s:if test="%{infoid==t00001Dao.rootid}">
								<option <s:if test='%{ACT != "C"}'>selected="selected"</s:if> value="<s:property value="infoid" />">
								<s:property value="infoid" />：<s:property value="infonm" /></option>
							</s:if>
							<s:else>
								<option value="<s:property value="infoid" />"><s:property
									value="infoid" />：<s:property value="infonm" /></option>
							</s:else>
						</s:iterator>
					</select>
				</td>
			</tr>
			<tr>
				<td class="infoBg">
					所在父节点
				</td>
				<td class="infoBg">
					其它信息
				</td>
			</tr>
			<tr>
				<td>
					<div class="infodiv" id="infoTreeDIV"></div>
				</td>
				<td valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td valign="middle">
								<label class="labelA">
									<s:property value="%{getText('app.xtwh.t00001.infoid')}" />
								</label>
								<input name="txtINFOID" type="text" class="txtfocus" id="txtINFOID" <s:if test='%{ACT!="C"}'> value="<s:property value="t00001Dao.infoid" />"</s:if> <s:if test='%{ACT!="C"}'>disabled="disabled"</s:if> />
							</td>
						</tr>
						<tr>
							<td valign="middle">
								<label class="labelA">
									<s:property value="%{getText('app.xtwh.t00001.infonm')}" />
								</label>
								<input name="txtINFONM" type="text" class="txtfocus" id="txtINFONM" <s:if test='%{ACT != "C"}'>value="<s:property value="t00001Dao.infonm" />"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
							</td>
						</tr>
						
						<tr>
							<td valign="middle">
							<div style="display:none;">
								<label class="labelA">
									<s:property value="%{getText('app.xtwh.t00001.vieworder')}" />
								</label>
								<input name="txtVIEWORDER" type="text" class="txtNumber" id="txtVIEWORDER" value="<s:property value="t00001Dao.vieworder" default="0" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
								</div>
								</td>
						</tr>
						
						<tr>
							<td>
<!--							<div style="display:none;">-->
								<label class="labelA">
									<s:property value="%{getText('app.xtwh.t00001.isdir')}" />
								</label>
								<input name="rdoISDIR" id="rdoISDIR" type="radio" class="radio" value="true"  <s:if test='%{t00001Dao.isdir && ACT != "C"}'>checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
								是
								<input name="rdoISDIR" id="rdoISDIR" type="radio" class="radio" value="false"  <s:if test='%{(null==t00001Dao||!t00001Dao.isdir) && ACT != "C" }'>checked="checked"</s:if><s:elseif test='%{ACT == "C"}'>checked="checked"</s:elseif> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
								否
<!--								</div>-->
							</td>
						</tr>
						
			            <tr>
			              <td><label class="labelA">
			                <s:property	value="%{getText('app.note')}" />
			                </label>
			                <textarea name="txtNOTE" id="txtNOTE" cols="30" rows="5" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> ><s:if test='%{ACT != "C"}'><s:property value="t00001Dao.note" /></s:if></textarea></td>
		              	</tr>
					</table>
				</td>
			</tr>
		</table>
		</form>
		</div>
        <div class="divbottom">
		<div><s:if test='%{ACT=="U"}'>
			<a href="javascript:AppSubmit();" class="easyui-linkbutton" plain="true" iconCls="icon-edit"><s:property value="getText('app.button.upd')" />
            </a>
		</s:if> <s:elseif test='%{ACT=="C"}'>
			<a href="javascript:AppSubmit();" class="easyui-linkbutton" plain="true" iconCls="icon-save"><s:property value="getText('app.button.save')" />
            </a>
		</s:elseif> <s:elseif test='%{ACT=="D"}'>
			<a href="javascript:AppSubmit();" class="easyui-linkbutton" plain="true" iconCls="icon-delete"><s:property value="getText('app.button.del')" />
            </a>
		</s:elseif>
        <a href="VIEWT00001.action" class="easyui-linkbutton" plain="true" iconCls="icon-back"><s:property value="getText('app.button.back')" />
        </a>
        </div>
        </div>
    <!-- 执行JavaScript脚本 --> <s:if test='%{ACT!="C"}'>
			<script type="text/javascript">
	getInfoData('<s:property value="t00001Dao.rootid" />',
			'<s:property value="t00001Dao.parentid" />',
			'<s:property value="t00001Dao.parentid" />',
			'<s:property value="t00001Dao.infoid" />',
			'<s:property value="ACT" />');
			</script>
		</s:if>
		</div>
	</div>
		</td>
  </tr>
</table>
</body>
</html>
