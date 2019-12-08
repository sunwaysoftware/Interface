<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>


<script type="text/javascript" src="../scripts/T00012/VIEWT00012.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>


<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		
	});
</script>
<style type="text/css">
.labelA {
	width: 170px;
}
</style>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
	<div class="ui-widget-content">
		<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00012.title')}" /></span>
		</div>    
		<table width="100%" border="0" cellspacing="2" cellpadding="0">
	 <tr>
	    <td width="300" valign="top">
	                     当前税收管辖：<a href="javascript:void(0)" onclick="GetData('<s:property value="SSGXId"/>')"><s:property value="SSGXNm"/></a>
	        <fieldset>
			<legend>【下级税收管辖】</legend>
				<div id="ddlQTXZ" style="width:200px;height:330px;overflow:auto;border: 0px inset #FFFFFF;">
					<ul id="ssgxTree"></ul>
				</div>
			</fieldset>
		</td>
		<td>	
            <form id="editForm" action="EDITT00012.action" method="post">
            <fieldset>
			<legend>【日志设置】</legend>
            <input type="hidden" name="SSGXId" id="SSGXId" value='<s:property value="SSGXId" />' />
            <input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00012Bean.upddate"/></s:text>" />
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
	      		<tr>
		    		<td><label class="labelA">
							<s:property value="%{getText('app.xtwh.t00012.islogadd')}" />
						</label>
						<input name="rdoISLOGADD" id="rdoISLOGADDF" type="radio" class="radio" value="false" checked="checked" />
						否
						<input name="rdoISLOGADD" id="rdoISLOGADDT" type="radio" class="radio" value="true" <s:if test='%{t00012Bean.islogadd==true}'>checked="checked"</s:if> />
						是</td>
				</tr>
				<tr>
	    			<td><label class="labelA">
							<s:property value="%{getText('app.xtwh.t00012.islogupd')}" />
						</label>
						<input name="rdoISLOGUPD" id="rdoISLOGUPDF" type="radio" class="radio" value="false" checked="checked"/>
						否
						<input name="rdoISLOGUPD" id="rdoISLOGUPDT" type="radio" class="radio" value="true" <s:if test='%{t00012Bean.islogupd==true}'>checked="checked"</s:if> />
						是</td>
				</tr>
				<tr>
	    			<td><label class="labelA">
							<s:property value="%{getText('app.xtwh.t00012.islogdel')}" />
						</label>
						<input name="rdoISLOGDEL" id="rdoISLOGDELF" type="radio" class="radio" value="false" checked="checked" />
						否
						<input name="rdoISLOGDEL" id="rdoISLOGDELT" type="radio" class="radio" value="true" <s:if test='%{true==t00012Bean.islogdel}'>checked="checked"</s:if> />
						是</td>
				</tr>
				<tr>
	    			<td><label class="labelA">
							<s:property value="%{getText('app.xtwh.t00012.islogpg')}" />
						</label>
						<input name="rdoISLOGPG" id="rdoISLOGPGF" type="radio" class="radio" value="false" checked="checked" />
						否
						<input name="rdoISLOGPG" id="rdoISLOGPGT" type="radio" class="radio" value="true" <s:if test='%{true==t00012Bean.islogpg}'>checked="checked"</s:if> />
						是</td>
				</tr>
				<tr>
	    			<td>
	    			<div style="display: none;"><label class="labelA">
							<s:property value="%{getText('app.xtwh.t00012.islogsh')}" />
						</label>
						<input name="rdoISLOGSH" id="rdoISLOGSHF" type="radio" class="radio" value="false" checked="checked" />
						否
						<input name="rdoISLOGSH" id="rdoISLOGSHT" type="radio" class="radio" value="true" <s:if test='%{true==t00012Bean.islogsh}'>checked="checked"</s:if> />
						是</div></td>
				</tr>
				<tr>
	    			<td><label class="labelA">
							<s:property value="%{getText('app.xtwh.t00012.isloggpg')}" />
						</label>
						<input name="rdoISLOGGPG" id="rdoISLOGGPGF" type="radio" class="radio" value="false" checked="checked" />
						否
						<input name="rdoISLOGGPG" id="rdoISLOGGPGT" type="radio" class="radio" value="true" <s:if test='%{true==t00012Bean.isloggpg}'>checked="checked"</s:if> />
						是</td>
				</tr>
				<tr>
	    			<td><div style="display: none;"><label class="labelA">
							<s:property value="%{getText('app.xtwh.t00012.islogss')}" />
						</label>
						<input name="rdoISLOGSS" id="rdoISLOGSSF" type="radio" class="radio" value="false" checked="checked" />
						否
						<input name="rdoISLOGSS" id="rdoISLOGSST" type="radio" class="radio" value="true" <s:if test='%{true==t00012Bean.islogss}'>checked="checked"</s:if>/>
						是</div></td>
				</tr>
				<tr>
	    			<td><label class="labelA">
							<s:property value="%{getText('app.xtwh.t00012.islogdy')}" />
						</label>
						<input name="rdoISLOGDY" id="rdoISLOGDYF" type="radio" class="radio" value="false" checked="checked" />
						否
						<input name="rdoISLOGDY" id="rdoISLOGDYT" type="radio" class="radio" value="true" <s:if test='%{true==t00012Bean.islogdy}'>checked="checked"</s:if>/>
						是</td>
				</tr>
				<tr>
	    			<td>
			</table>
			</fieldset>
			<fieldset>
				<legend>【房产接口】</legend>
				<table>
					<tr>
		    			<td><label class="labelA"><s:property value="%{getText('app.xtwh.t00012.FCJKDZ')}" /></label>
		    			    <input  name="txtFCJKDZ" id="txtFCJKDZ" type="text"  value='<s:property value="t00012Bean.fcjkdz"/>' style="width:200;"/>
		    			</td>
	    			</tr>
					<tr>
		    			<td><label class="labelA"><s:property value="%{getText('app.xtwh.t00012.FCBMBM')}" /></label>
		    			    <input  name="txtFCBM" id="txtFCBM" type="text"  value='<s:property value="t00012Bean.fcbmbm"/>' style="width:200;"/>
		    			</td>
	    			</tr>	    			
	    		</table>
	    	</fieldset>
			<fieldset>
				<legend>【征管接口】</legend>	    	
	    		<table>
	    			<tr>
		    			<td><label class="labelA"><s:property value="%{getText('app.xtwh.t00012.CHANNEL_PWD')}" /></label>
		    			    <input  name="txtCHANNEL_PWD" id="txtCHANNEL_PWD" type="text"  value='<s:property value="t00012Bean.channel_Pwd"/>' style="width:200;"/>
		    			</td>
	    			</tr>
	    			<tr>
		    			<td><label class="labelA"><s:property value="%{getText('app.xtwh.t00012.CHANNEL_ACC')}" /></label>
		    			    <input  name="txtCHANNEL_ACC" id="txtCHANNEL_ACC" type="text"  value='<s:property value="t00012Bean.channel_Acc"/>' style="width:200;"/>
		    			</td>
	    			</tr>
	    			<tr>
		    			<td><label class="labelA"><s:property value="%{getText('app.xtwh.t00012.CHANNEL_CODE')}" /></label>
		    			    <input  name="txtCHANNEL_CODE" id="txtCHANNEL_CODE" type="text"  value='<s:property value="t00012Bean.channel_Code"/>' style="width:200;"/>
		    			</td>
	    			</tr>
	    			<tr>
		    			<td><label class="labelA"><s:property value="%{getText('app.xtwh.t00012.WBMBM')}" /></label>
		    			    <input  name="txtWBMBM" id="txtWBMBM" type="text"  value='<s:property value="t00012Bean.wbmbm"/>' style="width:200;"/>
		    			</td>
	    			</tr>
				</table>
			</fieldset>
			
			<table>
				<tr>
	    			<td><label class="labelA">
							<s:property value="%{getText('app.note')}" />
						</label>
						<textarea name="txtNOTE" id="txtNOTE" cols="30" rows="3"><s:property value="t00012Bean.note" /></textarea></td>
				</tr>
			</table>
			</form>
			</td>
			</tr>
		    </table>  
    		<div class="divbottom">
	    		<a href="javascript:AppSubmit();">
            	<img src="../images/ico/Update.gif" width="16" height="16" title="保存记录" alt="保存记录" />保存记录</a>
    		</div>
    </div>
    </td>
  </tr>
</table>
</body>
</html>
