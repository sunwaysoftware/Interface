<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/T00002/EDITT00002.js"></script>
<script type="text/javascript" src="../scripts/T00002/fun.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/simpleTips/jquery.simpleTips-1.0.js"></script>
<link rel="stylesheet" type="text/css" href="../scripts/simpleTips/jquery.simpleTips.css" />
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		getRole('<s:property value="t00002Bean.userid" />','<s:property value="ACT"/>');
		getRight('<s:property value="t00002Bean.userid" />','<s:property value="ACT"/>');
		<s:if test='%{ACT=="C"}'>
		getSSGX('<s:property value="SSGX"/>','#txtSSGXTIP');
		</s:if>
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
			<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00002.title')}" /></span>
		</div>
<form id="editForm" action="EDITT00002.action" method="post">
	<input type="hidden" name="ACT" value="<s:property value="ACT"/>" /> 
	<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00002Bean.upddate"/></s:text>" />
	
	<s:if test='%{ACT!="C"}'>
		<input name="txtUSERID" type="hidden" id="txtUSERID" value="<s:property value="t00002Bean.userid" />" />
		<input name="txtSSGX" type="hidden" id="txtSSGX" value="<s:property value="t00002Bean.cd00001Ssgx" />" />
		<input name="txtSSGXFind" type="hidden" id="txtSSGXFind" value="<s:property value="t00002Bean.cd00001Ssgx" />" />
	</s:if>
		<table width="750" border="0" cellspacing="3" cellpadding="0">
		 <tr>
   		 <td valign="top">
		<fieldset>
                <legend>【基本信息】</legend>
            <table width="350" border="0" cellspacing="2" cellpadding="0">		
				<tr>
					<td><label class="labelA">
							<s:property value="getText('app.xtwh.info.ssgx')" />
						</label>						
						<span class="txtInfonm txtfocus"><input type="text" id="txtSSGXTIP" name="txtSSGXTIP" readonly="readonly" value="<s:property value="t00002Bean.ssgx"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spSSGX"</s:if>></span></span><input type="hidden" id="txtSSGX" name="txtSSGX"  <s:if test='%{ACT!="C"}'>disabled="disabled"</s:if> <s:if test='%{ACT=="C"}'>value="<s:property value="SSGX"/>"</s:if><s:else>value="<s:property value="t00002Bean.cd00001Ssgx"/>"</s:else> />
					</td>
				</tr>
      		<tr>
	    		<td><label class="labelA">		    		
						<s:property value="%{getText('app.xtwh.t00002.userid')}" />
					</label>
					<input name="txtUSERID" class="txtfocus" id="txtUSERID" type="text" 
					value="<s:property value="t00002Bean.userid" />" <s:if test='%{ACT!="C"}'>disabled="disabled"</s:if> />
				</td>
			</tr>
			<tr>
	    		<td><label class="labelA">				
						<s:property value="%{getText('app.xtwh.t00002.usernm')}" />
					</label>
					<input name="txtUSERNM" class="txtfocus" id="txtUSERNM" type="text" 
					value="<s:property value="t00002Bean.usernm" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
				</td>
			</tr>
			<s:if test='%{ACT=="C"}'>
			<tr>
	    		<td><label class="labelA">				
						<s:property value="%{getText('app.xtwh.t00002.userpwd')}" />
					</label>
					<span style="color:red;">123456</span>
				</td>
			</tr>
			</s:if>
			<tr>
	    		<td><label class="labelA">
						<s:property value="%{getText('app.xtwh.t00002.phone')}" />
					</label>
					<input name="txtPHONE" id="txtPHONE" type="text" 
					value="<s:property value="t00002Bean.phone" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
				</td>
			</tr>
			<tr>
	    		<td><label class="labelA">	
						<s:property value="%{getText('app.xtwh.t00002.userip')}" />
					</label>
						<input name="txtUSERIP" id="txtUSERIP" type="text" 
						value="<s:property value="t00002Bean.userip" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
				</td>
			</tr>
			<tr>
	    		<td><label class="labelA">
						<s:property value="%{getText('app.note')}" />
					</label>
					<textarea name="txtNOTE" id="txtNOTE" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> ><s:property value="t00002Bean.note" /></textarea>
				</td>
			</tr>
			<tr>
	    		<td><label class="labelA">		
						<s:property value="%{getText('app.xtwh.t00002.islocked')}" />
					</label>
					<input name="rdoISLOCKED" id="rdoISLOCKEDT" type="radio" class="radio" value="true"
					<s:if test='%{t00002Bean.islockedout}'>checked="checked"</s:if> 
					<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
					是
					<input name="rdoISLOCKED" id="rdoISLOCKEDF" type="radio" class="radio" value="false"
					<s:if test='%{null==t00002Bean || !t00002Bean.islockedout}'>checked="checked"</s:if>
					<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
					否
				</td>
			</tr>
			<tr>
	    		<td>
	    			<div id="lockeddatediv"  style="display:none;">
		    			<label class="labelA">		
							<s:property value="%{getText('app.xtwh.t00002.lastlockedoutdate')}" />
						</label>
						<input name="txtLOCKEDDATE" class="txtfocus" id="txtLOCKEDDATE" type="text" onfocus="WdatePicker({enableKeyboard:false,dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate" value="<s:text name="app.global.format.datetime"><s:param value="t00002Bean.lastlockedoutdate" /></s:text>" />
					</div>
				</td>
			</tr>
			<s:if test='%{ISADMIN}'>
				<tr>
		    		<td><label class="labelA">		
							<s:property value="%{getText('app.xtwh.t00002.isadmin')}" />
						</label>
						<input name="rdoISADMIN" id="rdoISADMIN" type="radio" class="radio" value="true"
						<s:if test='%{t00002Bean.isadmin}'>checked="checked"</s:if> 
						<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
						是
						<input name="rdoISADMIN" id="rdoISADMIN" type="radio" class="radio" value="false"
						<s:if test='%{null==t00002Bean || !t00002Bean.isadmin}'>checked="checked"</s:if>
						<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
						否
					</td>
				</tr>
			</s:if>						
		</table>
		</fieldset>
		</td>
		<td valign="top">
		<fieldset style="width:200px"><legend>【角色信息】</legend>
                    <table width="100%" border="0" cellspacing="2" cellpadding="0">
                    <tr>
                    <td>
			<div id="divRole"></div>
			</td>
			</tr>
			</table>
			</fieldset>
			</td>
			<!-- 
		<td valign="top">
		<fieldset style="width:200px"><legend>权限信息</legend>
                    <table width="100%" border="0" cellspacing="2" cellpadding="0">
                    <tr>
                    <td>
			<div id="divRight"></div>
			</td>
			</tr>
			</table>
			</fieldset>
			</td>
		</tr>
		 -->
		</table>
		</form>
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
		<a href="VIEWT00002.action?txtSSGXFind=<s:property value="t00002Bean.cd00001Ssgx" />">
			<img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/>
		</a>
	</div>	
	</div>
	<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>
	
</div>
    </td>
  </tr>
</table>
</body>
</html>
