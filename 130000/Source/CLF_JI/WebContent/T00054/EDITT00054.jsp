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
<script type="text/javascript" src="../scripts/T00054/EDITT00054.js"></script>
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
	width: 100px;
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
            <li><a href="#INFO"><span><s:property value="%{getText('app.xtwh.t00054.title')}" /></span></a></li>                    
        </ul>
		<div id="INFO" class="divConect">
		<div style="min-height:400px">
<form action="EDITT00054.action" method="post" id="editForm">
		<input type="hidden" name="ACT" value='<s:property value="ACT"/>' /> 
		<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00054Bean.upddate"/></s:text>" />
		<s:if test='%{ACT!="C"}'>
			<input type="hidden" name="txtBZBM" id="txtBZBM" value="<s:property value="t00054Bean.bzbm"/>" />
			<input type="hidden" name="ddlSZQY" id="ddlSZQY" value="<s:property value="t00054Bean.cd00001Szqy"/>" />
		</s:if>
        <table width="500" border="0" cellspacing="0" cellpadding="2">
          <tr>
            <td valign="top">
            	<table width="100%" border="0" cellspacing="3" cellpadding="0">
            	<tr>
					<td>
		                <label class="labelA"><s:property value="getText('app.xtwh.info.szqy')"/></label>
				       	<sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="t00054Bean.cd00001Szqy" disabled="ACT"/>
					</td>
	         	</tr>
                    <tr>
                        <td><label class="labelA">         	
                                <s:property value="getText('app.xtwh.t00054.bzbm')"/>
                            </label>
                            <input type="text" class="txtfocus txtNumber" id="txtBZBM" name="txtBZBM" value="<s:property value="t00054Bean.bzbm"/>" <s:if test='%{ACT!="C"}'>disabled="disabled"</s:if> />
                        </td>
                    </tr>
                    <tr>
                        <td><label class="labelA">	
                               <s:property value="getText('app.xtwh.t00054.bzmc')"/>
                            </label>
                            <input type="text" class="txtfocus txtNumber" id="txtBZMC" name="txtBZMC" value="<s:property value="t00054Bean.bzmc"/>"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />	
                        </td>
                    </tr>
                    <tr>
                        <td><label class="labelA">         	
                                <s:property value="getText('app.xtwh.t00054.jzqs')"/>
                            </label>
                            <input type="text" class="txtfocus txtNumber" style="width:100px" id="txtJZQSMIN" name="txtJZQSMIN" value="<s:property value="t00054Bean.jzqsMin" default="0" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
                            --
                            <input type="text" class="txtfocus txtNumber" style="width:100px" id="txtJZQSMAX" name="txtJZQSMAX" value="<s:property value="t00054Bean.jzqsMax" default="0" />"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
                        </td>
                    </tr>
                    <tr>
                        <td><label class="labelA">         	
                                <s:property value="getText('app.xtwh.t00054.lsxs')"/>
                            </label>
                            <input type="text" class="txtfocus txtNumber" style="width:100px" id="txtLSXSMIN" name="txtLSXSMIN" value="<s:property value="t00054Bean.lsxsMin" default="0" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
                            --
                            <input type="text" class="txtfocus txtNumber" style="width:100px" id="txtLSXSMAX" name="txtLSXSMAX" value="<s:property value="t00054Bean.lsxsMax" default="0" />"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
                        </td>
                    </tr>
                    <tr>
                        <td><label class="labelA">         	
                                <s:property value="getText('app.xtwh.t00054.jgxgc')"/>
                            </label>
                            <input type="text" class="txtfocus txtNumber" style="width:100px" id="txtJGXGCMIN" name="txtJGXGCMIN" value="<s:property value="t00054Bean.jgxgcMin" default="0" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
                            --
                             <input type="text" class="txtfocus txtNumber" style="width:100px" id="txtJGXGCMAX" name="txtJGXGCMAX" value="<s:property value="t00054Bean.jgxgcMax" default="0" />"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
                        </td>
                    </tr>
                    <tr>
                        <td><label class="labelA">		
                                <s:property value="%{getText('app.note')}" />
                            </label>
                            <textarea name="txtNOTE" id="txtNOTE" cols="26" rows="3"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> ><s:property value="t00054Bean.note" /></textarea>
                        </td>
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
				<a href="javascript:AppSubmit();">
					<img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" /><s:property value="getText('app.button.upd')"/>
				</a>
			</s:if> 
			<s:elseif test='%{ACT=="C"}'>
				<a href="javascript:AppSubmit();">
					<img src="../images/ico/Update.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.save')"/>" /><s:property value="getText('app.button.save')"/>
				</a>
			</s:elseif> 
			<s:elseif test='%{ACT=="D"}'>
				<a href="javascript:AppSubmit();">
					<img src="../images/ico/Delete.gif" width="16" height="16" title="<s:property value="getText('app.button.del')"/>" alt="<s:property value="getText('app.button.del')"/>" /><s:property value="getText('app.button.del')"/>
				</a>
			</s:elseif> 
			<a href="VIEWT00054.action">
				<img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/>
			</a>
		</div>
		</div>
        <script type="text/javascript">getTDYTDiv('<s:property value="t00054Bean.cd00001Tdyt"/>','#INFOTDYTDIV');</script>
</div>
</div>
    </td>
  </tr>
</table>
</body>
</html>
