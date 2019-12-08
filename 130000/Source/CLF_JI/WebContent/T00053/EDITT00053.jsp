<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00053/EDITT00053.js"></script>
<script type="text/javascript" src="../scripts/T00053/T00053TREEDIV.js"></script>



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
	        <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
	            <li><a href="#INFO"><span><s:property value="%{getText('app.xtwh.t00053.title')}" /></span></a></li>
	        </ul>
		<div id="INFO" class="divConect">
		<div style="min-height:400px">
<form id="editForm" action="EDITT00053.action" method="post">
	<input type="hidden" name="ACT" value="<s:property value="ACT"/>" />
	<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00053Bean.upddate"/></s:text>" />
	<s:if test='%{ACT!="C"}'>
		<input name="QTXZID" type="hidden" id="QTXZID" value="<s:property value="t00053Bean.qtxzid" />" />
		<input name="ddlSZQY" type="hidden" id="ddlSZQY" value="<s:property value="t00053Bean.cd00001Szqy" />" />
		<input name="ddlXZLX" type="hidden" id="ddlXZLX" value="<s:property value="t00053Bean.xzlx" />" />
	</s:if>
	<table border="0" cellspacing="0" cellpadding="2">
      <tr>
        <td colspan="2" align="center">
        	<s:property value="getText('app.xtwh.info.szqy')"/>&nbsp;&nbsp;&nbsp;&nbsp;
	        <sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="t00053Bean.cd00001Szqy" disabled="ACT" />
        </td>
        </tr>
      <tr>
        <td valign="top">
        	<s:property value="getText('app.xtwh.t00053.xzlx')"/>
              <select name="ddlXZLX" class="txtfocus" id="ddlXZLX" <s:if test='%{ACT!="C"}'>disabled="disabled"</s:if> >
                <option value="">请选择...</option>
                <s:iterator id="XzlxEntity" value="xzlxList" status="index">
                  <s:if test="%{xzlx==t00053Bean.xzlx}">
                    <option selected="selected" value="<s:property value="xzlx" />"><s:property value="xzmc" /></option>
                  </s:if>
                  <s:else>
                    <option value="<s:property value="xzlx" />"><s:property value="xzmc" /></option>
                  </s:else>
                </s:iterator>
              </select>
              <br/>
              <s:property value="getText('app.xtwh.t00053.parent')"/>
              <div id="T00053TreeDIV" class="infodiv"></div>
        </td>
        <s:if test='%{ACT=="U"}'>
          <td width="220" valign="top">
            <s:property value="getText('app.xtwh.t00053.parentnm')"/>
			<iframe id="IQTXZL" width="100%" height="320px" frameborder="0" scrolling="no" src="T00053FRAME1.action?QTXZID=<s:property value="t00053Bean.qtxzid" />&ddlSZQY=<s:property value="t00053Bean.cd00001Szqy" />&ddlXZLX=<s:property value="t00053Bean.xzlx" />"></iframe>
          </td>
        </s:if>
        <td valign="top">
        <table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>
				<td><label class="labelA">
						<s:property	value="%{getText('app.xtwh.t00053.dxmc')}" />
					</label>
	  				<input name="txtQTXZNM" class="txtfocus" id="txtQTXZNM" type="text" value="<s:property value="t00053Bean.qtxznm" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /></td>
	 		</tr>
	        <tr>
				<td><label class="labelA">
						<s:property	value="%{getText('app.xtwh.t00053.xzxs')}" />
					</label>
	  				<input name="txtXZXS" class="txtfocus txtNumber" id="txtXZXS" type="text" value="<s:property value="t00053Bean.xzxs" default="0"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /></td>
	  		</tr>
	        <tr>
				<td><label class="labelA">
						<s:property	value="%{getText('app.xtwh.t00053.vieworder')}" />
					</label>
	  				<input name="txtVIEWORDER" class="txtNumber" id="txtVIEWORDER" type="text" value="<s:property value="t00053Bean.vieworder" default="0"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /></td>
	  		</tr>
	  		<tr>
				<td><label class="labelA">
						<s:property	value="%{getText('app.xtwh.t00053.isdir')}" />
					</label>
					<input name="rdoISDIR" id="rdoISDIR2" type="radio" class="radio" value="false" checked="checked"
					<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>  />
					否
					<input name="rdoISDIR" id="rdoISDIR1" type="radio" class="radio" value="true"
					<s:if test='%{t00053Bean.isdir}'>checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
					是
				</td>
			</tr>
			<tr>
				<td>
					<label class="labelA"><s:property value="getText('app.xtwh.t00353.yslb')"/></label>
					<input type="radio" class="radio" name="rdoCZLX" id="rdoCZLX0" value="0" checked="checked" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/><s:property value="getText('app.xtwh.t00353.yslb.mcl')"/>
					<input type="radio" class="radio" name="rdoCZLX" id="rdoCZLX1" value="1" <s:if test="%{1==t00053Bean.czlx}">checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/><s:property value="getText('app.xtwh.t00353.yslb.DA')"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class="labelA">修正类型</label>
					<input type="radio" class="radio" name="rdoJGLX" id="rdoJGLX0" value="0" checked="checked" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>平方米
					<input type="radio" class="radio" name="rdoJGLX" id="rdoJGLX1" value="1" <s:if test="%{1==t00053Bean.jglx}">checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>结果
				</td>
			</tr>
	        <tr>
				<td><label class="labelA">
						<s:property	value="%{getText('app.note')}" />
					</label>
					<textarea name="txtNOTE" id="txtNOTE" cols="20" rows="3" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> ><s:property value="t00053Bean.note" /></textarea></td>
			</tr>	        
		</table>
        </td>
      </tr>
    </table>
    </form>
    </div>
	<div class="divbottom">
	<div>
		<s:if test='%{ACT=="U"}'>
				<a href="javascript:AppSubmit();"><img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" /><s:property value="getText('app.button.upd')"/></a>
        </s:if>
        <s:elseif test='%{ACT=="C"}'>
            <a href="javascript:AppSubmit();"><img src="../images/ico/Update.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.save')"/>" /><s:property value="getText('app.button.save')"/></a>
        </s:elseif>
        <s:elseif test='%{ACT=="D"}'>
            <a href="javascript:AppSubmit();"><img src="../images/ico/Delete.gif" width="16" height="16" title="<s:property value="getText('app.button.del')"/>" alt="<s:property value="getText('app.button.del')"/>" /><s:property value="getText('app.button.del')"/></a>
        </s:elseif>
		<a href="VIEWT00053.action"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
    </div>
   	</div>
    <s:if test='%{ACT!="C"}'>
	      <script type="text/javascript">getQtxzData('<s:property value="t00053Bean.parentid" />','<s:property value="t00053Bean.qtxzid" />','<s:property value="t00053Bean.parentid" />','<s:property value="ACT"/>');</script>
	</s:if>
    <s:else>
	      <script type="text/javascript">
	        getQtxzDataBySzqy('<s:property value="t00053Bean.cd00001Szqy" />','<s:property value="t00053Bean.xzlx" />','<s:property value="t00053Bean.parentid" />');
	      </script>
	</s:else>
	</div>
</div>
    </td>
  </tr>
</table>
</body>
</html>
