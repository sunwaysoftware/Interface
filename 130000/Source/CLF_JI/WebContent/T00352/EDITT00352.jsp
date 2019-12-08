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

<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00352/EDITT00352.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00053/T00053TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		<s:if test='%{t00352Bean.cd00001Szqy!=""}'>
        	getXqmcData('<s:property value="t00352Bean.parentdm" />','<s:property value="t00352Bean.xqdm" />','<s:property value="t00352Bean.parentdm" />','<s:property value="ACT"/>');
      	</s:if>  
	});
</script>
<style type="text/css"> 
.labelA {
	width: 80px;
}
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
    <div class="ui-widget-content">
		<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00352.title')}" /></span>
		</div>
		<div id="INFO" class="divConect">
		<div style="min-height:400px">
<form id="editForm" action="EDITT00352.action" method="post">
	<input type="hidden" name="ACT" value="<s:property value="ACT"/>" />
	<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00352Bean.upddate"/></s:text>" />
	<input type="hidden" name="ISEXISTXQNM" id="ISEXISTXQNM" />
	<s:if test='%{ACT!="C"}'>
		<input name="XQDM" type="hidden" id="XQDM" value="<s:property value="t00352Bean.xqdm" />" />
	</s:if>
	<s:if test='%{ACT=="D"}'>
		<input name="ddlSZQY" type="hidden" id="ddlSZQY" value="<s:property value="t00352Bean.cd00001Szqy" />" />
		<input name="txtXQNM" type="hidden" id="txtXQNM" value="<s:property value="t00352Bean.xqnm" />" />
	</s:if>	
	<input type="hidden" name="ISEXISTXQNM" id="ISEXISTXQNM" />
	<table border="0" cellspacing="0" cellpadding="2">
        <tr>
          <td colspan="3" align="center">
          	<s:property value="getText('app.xtwh.info.szqy')"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="t00352Bean.cd00001Szqy" />
          </td>
        </tr>
        <tr>
          <td valign="top">
            <SPAN class="infoBg"><s:property value="getText('app.xtwh.t00352.parent')"/></SPAN>
            <div class="infodiv" id="T00352TreeDIV"></div>
          </td>
        <s:if test='%{ACT=="U"}'>
          <td width="215" valign="top">
            <SPAN class="infoBg"><s:property value="getText('app.xtwh.t00352.parentnm')"/></SPAN>
			<iframe id="IXQL" width="100%" height="305px" frameborder="0" scrolling="no" src="T00352FRAME1.action?XQDM=<s:property value="t00352Bean.xqdm" />&ddlSZQY=<s:property value="t00352Bean.cd00001Szqy" />"></iframe>
          </td>
        </s:if>
        <s:else>
        	<td width="2" valign="top"></td>
        </s:else>
          <td valign="top">
              <SPAN class="infoBg">其它信息</SPAN>
	          <table width="100%" border="0" cellspacing="0" cellpadding="2">
	           <tr>
	              <td><label class="labelA">
	                <s:property	value="%{getText('app.xtwh.t00352.xqdmh')}" />
	                </label>
	                <input name="txtXQDMH"  id="txtXQDMH" type="text" value="<s:property value="t00352Bean.xqdmh" />"<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/></td>
	              </tr>
	            <tr>
	              <td><label class="labelA">
	                <s:property	value="%{getText('app.xtwh.t00352.xqmc')}" />
	                </label>
	                <input name="txtXQNM" class="txtfocus" id="txtXQNM" type="text" value="<s:property value="t00352Bean.xqnm" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
	                </td>
	              </tr>
	            <tr>
	              <td><label class="labelA">
	                <s:property	value="%{getText('app.xtwh.t00352.vieworder')}" />
	                </label>
	                <input name="txtVIEWORDER" class="txtNumber" id="txtVIEWORDER" type="text" value="<s:property value="t00352Bean.vieworder" default="0"/>"<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/></td>
	              </tr>
	            <tr>
	              <td><label class="labelA">
	                <s:property	value="%{getText('app.xtwh.t00352.zldz')}" />
	                </label>
	                <textarea name="txtNOTE" id="txtNOTE"  class="txtfocus" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> ><s:property value="t00352Bean.note" /></textarea></td>
	              </tr>
	            <tr>
	              <td><label class="labelA">
	                <s:property	value="%{getText('app.xtwh.t00352.dzbm')}" />
	                </label>
	                <input name="txtXQBM"  id="txtXQBM" type="text" value="<s:property value="t00352Bean.xqbm" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
	                </td>
	              </tr>
	            <tr>
	              <td><label class="labelA">
	                <s:property	value="%{getText('app.xtwh.t00352.isdir')}" />
	                </label>
	                <input name="rdoISDIR" id="rdoISDIR1" type="radio" class="radio" value="true" <s:if test='%{t00352Bean.isdir}'>checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
					是
	                <input name="rdoISDIR" id="rdoISDIR2" type="radio" class="radio" value="false" <s:if test='%{!t00352Bean.isdir}'>checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
					否</td>
	              </tr>
	            </table>
            </td>
        </tr>
        </table>  
        </form>
        </div>
	<div class="divbottom">	
        <s:if test='%{ACT=="U"}'>
          <a href="javascript:AppSubmit();">
            <img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" /><s:property value="getText('app.button.upd')"/></a>
          </s:if> 
        <s:elseif test='%{ACT=="C"}'>
          <a href="javascript:AppSubmit();">
            <img src="../images/ico/Update.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.save')"/>" /><s:property value="getText('app.button.save')"/></a>
          </s:elseif> 
        <s:elseif test='%{ACT=="D"}'>
          <a href="javascript:AppSubmit();">
            <img src="../images/ico/Delete.gif" width="16" height="16" title="<s:property value="getText('app.button.del')"/>" alt="<s:property value="getText('app.button.del')"/>" /><s:property value="getText('app.button.del')"/></a>
          </s:elseif> 
        <a href="VIEWT00352.action"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
    </div>
</div>
</div>
    </td>
  </tr>
</table>
</body>
</html>
