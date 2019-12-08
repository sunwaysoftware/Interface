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
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00306/EDITT00306.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
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
	
    <div id="tabs" class="ui-widget-content">
        <div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00306.title')}" /></span>
		</div>
		<div id="INFO" class="divConect">
		<div style="min-height:400px">
<form action="EDITT00306.action" method="post" id="editForm">
		<input type="hidden" name="hidSelect" id="hidSelect" />
		<input type="hidden" name="ACT" id="ACT" value='<s:property value="ACT"/>' />
		<input type="hidden" name="id" id="id" value='<s:property value="id"/>' />
		<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="v00306Bean.upddate"/></s:text>" />
        <table width="500" border="0" cellspacing="3" cellpadding="0">
            <tr>
	           <td>
	           <label class="labelA"><s:property value="getText('app.xtwh.info.szqy')"/></label>
	            <s:if test='%{ACT == "D"}'>
					<sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" disabled="disabled" checked="v00306Bean.cd00001Szqy" />
				</s:if>
				<s:elseif test='%{ACT == "C"}'>
					<sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY"  />
				</s:elseif>
				<s:else>
					<sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="v00306Bean.cd00001Szqy" />
				</s:else>
	           </td>
	       </tr>
	       <tr>
		        <td><label class="labelA">
					 <s:property value="%{getText('app.xtwh.t00303.xqmc')}" />
		 	         </label>
		        <span class="txtInfonm txtfocus"><input name="txtXQTIP" id="txtXQTIP" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>  value="<s:property value="v00306Bean.xqnm"/>" type="text" readonly="readonly" /><span<s:if test='%{ACT!="D"}'> id="spXQDM"</s:if>></span></span><input type="hidden" id="txtXQDM" name="txtXQDM" <s:if test='%{ACT != "C"}'> value="<s:property value="v00306Bean.cd00352Xqdm" />"</s:if>/>
		        </td>
	       </tr>
            	<tr>
	            <td>
	                <label class="labelA">
	                	<s:property value="getText('app.xtwh.t00306.lh')"/>
	                </label>
	                <input type="text" class="txtfocus txtNumber" id="txtLH" name="txtLH" <s:if test='%{ACT != "C"}'> value='<s:property value="v00306Bean.lh" default="0" />'</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
	            </td>
          	</tr>
          <!-- <tr>
	            <td>
	                <label class="labelA">
	                	<s:property value="getText('app.xtwh.t00306.zlc')"/>
	                </label>
	                <input type="text" class="txtfocus txtNumber" id="txtZLC" name="txtZLC" <s:if test='%{ACT != "C"}'> value='<s:property value="v00306Bean.zlc" default="0" />'</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
	            </td>
          	</tr>
          	<tr>
	            <td>
	                <label class="labelA">
	                	<s:property value="getText('app.xtwh.t00306.dygs')"/>
	                </label>
	                <input type="text" class="txtfocus txtNumber" id="txtDYGS" name="txtDYGS" <s:if test='%{ACT != "C"}'> value='<s:property value="v00306Bean.dygs" default="0" />'</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
	            </td>
          	</tr> -->	
          	<tr>
	            <td>
	                <label class="labelA">
	                	<s:property value="%{getText('app.xtwh.t00306.note')}" />
	                </label>
	                <textarea class="txtfocus" name="txtNOTE" cols="20" rows="3" id="txtNOTE" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>><s:if test='%{ACT != "C"}'><s:property value="v00306Bean.note" /></s:if></textarea>
	            </td>
          	</tr> 
          	<tr>
	            <td>
	                <label class="labelA">
	                	<s:property value="%{getText('app.xtwh.t00303.clh')}" />
	                </label>
	                <input type="text" id="txtCLH" name="txtCLH" value="<s:if test='%{ACT != "C"}'><s:property value="v00306Bean.clh"/></s:if>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>
	            </td>
          	</tr>            	         	
        </table>
	    <div id="dialog"  title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
			<div id="infoTreeDIV"></div>
		</div>    
    </form>
       	</div>
		<div class="divbottom">
		<div>
			<a href="javascript:void(0)" id="btnUpd" name="btnUpd" <s:if test='%{ACT!="U"}'>style="display:none"</s:if>><img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" /><s:property value="getText('app.button.upd')"/></a>
			<a href="javascript:void(0)" id="btnDel" name="btnDel" <s:if test='%{ACT!="D"}'>style="display:none"</s:if>><img src="../images/ico/Delete.gif" width="16" height="16" title="<s:property value="getText('app.button.del')"/>" alt="<s:property value="getText('app.button.del')"/>" /><s:property value="getText('app.button.del')"/></a>
		  	<a href="javascript:void(0)" id="btnAdd" name="btnAdd" <s:if test='%{ACT!="C"}'>style="display:none"</s:if>><img src="../images/ico/Update.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.save')"/>" /><s:property value="getText('app.button.save')"/></a>
			<a href="VIEWT00306.action">
				<img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
		</div>
		</div>
		</div>
</div>
</div>
    </td>
  </tr>
</table>
</body>
</html>
