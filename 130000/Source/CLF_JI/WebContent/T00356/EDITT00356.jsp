<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>


<link rel="stylesheet" type="text/css" href="../css/screen.css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/T00356/EDITT00356.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
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
	
    <div class="ui-widget-content">
	<div class="datagrid-title">
		<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00356.title')}" /></span>
	</div>
<form action="EDITT00356.action" method="post" id="editForm">
		<input type="hidden" name="ACT" value='<s:property value="ACT"/>' /> 
		<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00356Bean.upddate"/></s:text>" />
		<s:if test='%{ACT=="D"}'>
		<input type="hidden" name="ddlSZQY" id="ddlSZQY" value='<s:property value="t00356Bean.cd00001Szqy"/>'/>
		<input type="hidden" name="PSSDYM" id="PSSDYM" value='<s:property value="t00356Bean.cd00002Pssd"/>'/>
		</s:if>
		<table width="500" border="0" cellspacing="3" cellpadding="0">
          <tr>
            <td>
            <label class="labelA">
            	<s:property value="getText('app.xtwh.info.szqy')"/>
            </label>
	        <sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="t00356Bean.cd00001Szqy" disabled="ACT"/>
            </td>
          </tr>          
          <tr>
            <td>
            	<label class="labelA">
            		<s:property value="%{getText('app.xtwh.t00001.pssd')}" />
            	</label>
            	<input name="ddlPSSD" id="ddlPSSD" type="text" value="<s:property value="t00356Bean.cd00002Pssd" />" onfocus="WdatePicker({dateFmt:'yyyyMM'})" class="Wdatefocus" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
            </td>
          </tr>
          <!--<tr>
            <td>
            	<label class="labelA">
            		<s:property value="%{getText('app.xtwh.t00001.pssd')}" />
            	</label>
				<select  class="txtfocus" id="ddlPSSD" name="ddlPSSD" >
					<option value="">请选择...</option>
					<s:iterator value="monthList" status="index" id="monthEntity">
						<s:if test="%{t00356Bean.cd00002Pssd==top}">
							<option value="<s:property/>" selected="selected"><s:property/></option>
						</s:if><s:else>
							<option value="<s:property/>"><s:property/></option>
						</s:else>
					</s:iterator>
				</select>
            </td>
          </tr>-->
          <tr>
            <td>
            	<label class="labelA">
            		<s:property value="getText('app.xtwh.t00356.jgzs')"/>
            	 </label>
				<input type="text" class="txtfocus txtNumber" id="txtXZXS" name="txtXZXS" value="<s:property value="t00356Bean.xzxs" default="100" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
            </td>
          </tr>
          <tr>
            <td>
            	<label class="labelA">
            		<s:property value="%{getText('app.note')}" />
            	</label>
				<textarea name="txtNOTE" id="txtNOTE" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> ><s:property value="t00356Bean.note" /></textarea>
            </td>
          </tr>
        </table>
        </form>
		<div class="divbottom">
		<div>
			<a href="javascript:void(0)" id="btnUpd" name="btnUpd" <s:if test='%{ACT!="U"}'>style="display:none"</s:if>><img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" /><s:property value="getText('app.button.upd')"/></a>
			<a href="javascript:void(0)" id="btnDel" name="btnDel" <s:if test='%{ACT!="D"}'>style="display:none"</s:if>><img src="../images/ico/Delete.gif" width="16" height="16" title="<s:property value="getText('app.button.del')"/>" alt="<s:property value="getText('app.button.del')"/>" /><s:property value="getText('app.button.del')"/></a>
		  	<a href="javascript:void(0)" id="btnAdd" name="btnAdd" <s:if test='%{ACT!="C"}'>style="display:none"</s:if>><img src="../images/ico/Update.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.save')"/>" /><s:property value="getText('app.button.save')"/></a>
			<a href="VIEWT00356.action">
				<img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
		</div>
		</div>		
   	</div>
    </td>
  </tr>
</table>
</body>
</html>