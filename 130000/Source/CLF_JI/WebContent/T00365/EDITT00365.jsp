<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="../css/screen.css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00365/EDITT00365.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript">
$(function() {
	$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
	$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
});
</script>
<style type="text/css">
	.labelA {
		width: 100px;
	}
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
	<tr>
		<td align="left" valign="top">
		<div class="ui-widget-content">
		<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00365.title')}" /></span>                   
		</div>
		<div style="min-height:400px">
		<form action="EDITT00365.action" method="post" id="editForm">
		    <input type="hidden" name="hidSelect" id="hidSelect" />
		    <input type="hidden" name="txtXZXS" id="txtXZXS"  <s:if test='%{ACT!="C"}'>value='<s:property value="t00365Bean.xzxs"/>'</s:if>/>
			<input type="hidden" name="ACT" id="ACT" value='<s:property value="ACT"/>' />
			<input type="hidden" name="rdoJJF1" id="rdoJJF1" value='<s:property value="rdoJJF1"/>' />
			<input type="hidden" name="txtID" id="txtID" value='<s:property value="t00365Bean.id"/>' />
			<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00365Bean.upddate"/></s:text>" />
			<s:if test='%{ACT=="D"}'><input type="hidden" name="ddlSZQY" value='<s:property value="t00365Bean.cd00001Szqy"/>' /></s:if>
			<div id="dialog"  title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
			   <div id="infoTreeDIV"></div>
		    </div>
			<table width="500" border="0" cellspacing="3" cellpadding="0">
				 <tr>
				<td><label class="labelA"> <s:property value="getText('app.xtwh.info.szqy')" /></label>
					<s:if test='%{ACT == "D"}'>
					 <sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="t00365Bean.cd00001Szqy" disabled="ACT" />
					 </s:if>
					<s:elseif test='%{ACT == "C"}'>
						<sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY"/>
					</s:elseif>
					<s:else>
						<sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="t00365Bean.cd00001Szqy" />
					</s:else>
				 </td>
			</tr>
				
				 <tr>
		        <td><label class="labelA">
					 <s:property value="%{getText('app.xtwh.t00303.xqmc')}" />
		 	         </label>
<!--		    <span class="txtInfonm txtfocus"><input name="txtXQTIP" id="txtXQTIP"  value="<s:property value="v00303Bean.xqnm"/>" type="text" readonly="readonly" <s:if test="%{FINDRTNFLAG}">disabled="disabled"</s:if>/><span<s:if test='%{ACT=="C" && !FINDRTNFLAG}'> id="spXQDM"</s:if>></span></span><input type="hidden" id="txtXQDM" name="txtXQDM" value="<s:property value="v00303Bean.cd00352Xqdm" />"/>-->
		        <span class="txtInfonm txtfocus"><input name="txtXQTIP" id="txtXQTIP" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>  value="<s:property value="t00365Bean.xqnm"/>" type="text" readonly="readonly" /><span<s:if test='%{ACT!="D"}'> id="spXQDM"</s:if>></span></span><input type="hidden" id="txtXQDM" name="txtXQDM" <s:if test='%{ACT != "C"}'>value="<s:property value="t00365Bean.cd00352Xqdm" />"</s:if>/>
		        </td>
	            </tr>
	            
	            <tr>
			     <td><label class="labelA">是否使用间接法</label>
				<input type="radio" class="radio" name="rdoJJF" id="rdoJJF1" value="1" <s:if test='%{1==t00365Bean.xzxs && ACT != "C"}'>checked="checked"</s:if><s:else>checked="checked"</s:else> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>是
				<input type="radio" class="radio" name="rdoJJF" id="rdoJJF0" value="0" <s:if test='%{0==t00365Bean.xzxs && ACT != "C"}'>checked="checked"</s:if><s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />否			
			    </td>
		        </tr>	 
				<tr>
					<td>
					    <label class="labelA"> 
					    <s:property	value="%{getText('app.note')}" /> 
					    </label> 
					   
					 <textarea name="txtNOTE" cols="30" rows="5" id="txtNOTE" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>><s:if test='%{ACT != "C"}'><s:property value="t00365Bean.note" /></s:if></textarea>
					</td>
				</tr>
			</table>
		</form>
		</div>
		<div class="divbottom">
		<div><a href="javascript:void(0)" id="btnUpd" name="btnUpd"
			<s:if test='%{ACT!="U"}'>style="display:none"</s:if>><img
			src="../images/ico/Edit.gif" width="16" height="16"
			title="<s:property value="getText('app.button.upd')"/>"
			alt="<s:property value="getText('app.button.upd')"/>" /><s:property
			value="getText('app.button.upd')" /></a> <a href="javascript:void(0)" id="btnDel"
			name="btnDel" <s:if test='%{ACT!="D"}'>style="display:none"</s:if>><img
			src="../images/ico/Delete.gif" width="16" height="16"
			title="<s:property value="getText('app.button.del')"/>"
			alt="<s:property value="getText('app.button.del')"/>" /><s:property
			value="getText('app.button.del')" /></a> <a href="javascript:void(0)" id="btnAdd"
			name="btnAdd" <s:if test='%{ACT!="C"}'>style="display:none"</s:if>><img
			src="../images/ico/Update.gif" width="16" height="16"
			title="<s:property value="getText('app.button.save')"/>"
			alt="<s:property value="getText('app.button.save')"/>" /><s:property
			value="getText('app.button.save')" /></a> <a href="VIEWT00365.action">
		<img src="../images/ico/Cancel.gif" width="16" height="16"
			title="<s:property value="getText('app.button.back')"/>"
			alt="<s:property value="getText('app.button.back')"/>" /><s:property
			value="getText('app.button.back')" /></a></div>
		</div>
		</div>
		</div>
		</td>
	</tr>
</table>
</body>
</html>