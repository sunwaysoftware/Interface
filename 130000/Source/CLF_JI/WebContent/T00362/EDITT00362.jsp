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
<script type="text/javascript" src="../scripts/T00362/EDITT00362.js"></script>
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
	
    <div id="tabs" class="ui-widget-content">
       	<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00362.title')}"/></span>
		</div>
		<div id="INFO" class="divConect">
		<div style="min-height:400px">
		<form action="EDITT00362.action" method="post" id="editForm">
		<input type="hidden" name="ACT" id="ACT" value='<s:property value="ACT"/>' />
		<input type="hidden" name="txtLSH" id="txtLSH" value='<s:property value="t00362Bean.id"/>'/>
		<input type="hidden" name="txtPSSD" id="txtPSSD" value="<s:property value="%{getText('app.data.xtwh.pssd')}" />" />
		<!--<input type="hidden" name="txtSYNXMIN" id="txtSYNXMIN" value='<s:property value="t00361Bean.synx_min"/>'/>
		<input type="hidden" name="txtSYNXMAX" id="txtSYNXMAX" value='<s:property value="t00361Bean.synx_max"/>'/>-->
		<!--  <input type="hidden" name="txtXZXSS" id="txtXZXSS" value='<s:property value="t00362Bean.xzxs" />'/> -->
		<input type="hidden" name="hidSelect" id="hidSelect" />
		<input type="hidden" name="rdoCZLX1" id="rdoCZLX1" />
		<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00362Bean.upddate"/></s:text>" />
       	<s:if test='%{ACT == "D"}'><input type="hidden" name="ddlSZQY" value='<s:property value="t00362Bean.cd_00001_szqy"/>' /></s:if>
       	<div id="dialog"  title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
			<div id="infoTreeDIV"></div>
		</div>
        <table width="500" border="0" cellspacing="3" cellpadding="0">
			<!--<tr>
				<td>
					<s:if test='%{ACT != "C"}'>
		                <label class="labelA">
							<s:property value="%{getText('app.xtwh.t00361.lsh')}" />
		                </label>
				        <input class="txtfocus txtNumber" name="txtLSH" id="txtLSH" type="text" value='<s:property value="t00362Bean.id"/>' disabled="disabled"/>
			        </s:if>
	            </td>
            </tr>
            --><!--<tr>
            	<td>
            		<label class="labelA">
							<s:property value="%{getText('app.xtwh.t00001.pssd')}" />
					</label>
					<input type="text" id="txtPSSD" name="txtPSSD" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> value="<s:property value="t00362Bean.cd_00002_pssd"/>"  onfocus="WdatePicker({dateFmt:'yyyy'})" class="Wdatefocus" />
				</td>
  			</tr>
            -->
            <tr>
				<td><label class="labelA"> <s:property value="getText('app.xtwh.info.szqy')" /></label>
				<s:if test='%{ACT == "D"}'>
				 <sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="t00362Bean.cd_00001_szqy" disabled="ACT" />
				 </s:if>
				<s:elseif test='%{ACT == "C"}'>
					<sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY"/>
				</s:elseif>
				<s:else>
					<sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="t00362Bean.cd_00001_szqy" />
				</s:else>
				 </td>
			</tr>
            <tr>
				<td><label class="labelA">
					<s:property	value="%{getText('app.xtwh.info.fwlx')}" />
					</label>
			  <span class="txtInfonm txtfocus"><input name="txtFWLXTIP" id="txtFWLXTIP" type="text" class="typeInput" readonly="readonly" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> <s:if test='%{ACT != "C"}'> value="<s:property value="t00362Bean.fwlx" />"</s:if>/><span<s:if test='%{ACT!="D"}'> id="spFWLX"</s:if>></span></span><input type="hidden" id="txtFWLX" name="txtFWLX" <s:if test='%{ACT != "C"}'> value="<s:property value="t00362Bean.cd_00001_fwlx" />"</s:if>/>		
<!--				<span><select class="txtfocus txtSelect" id="txtFWLX" name="txtFWLX" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></select></span>-->
				</td>
			</tr>
            <tr>
				<td>
					<label class="labelA">
						<s:property	value="%{getText('app.xtwh.t00362.jzjg')}" />
					</label>
					<span class="txtInfonm txtfocus"><input name="txtJZJGTTIP" id="txtJZJGTTIP" type="text" value="<s:property value="t00362Bean.jzjg" />" readonly="readonly"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spJZJG"</s:if>></span></span><input type="hidden" id="txtJZJGT" name="txtJZJGT" value="<s:property value="t00362Bean.cd_00001_jzjg" />"/>
<!--	  		<span class="txtInfonm txtfocus"><input name="txtJZJGT" id="txtJZJGT" type="text"   value="<s:property value="t00362Bean.jzjg" />" readonly="readonly" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>  /><span<s:if test='%{ACT!="D"}'> id="spJZJG"</s:if>></span></span><input type="hidden" id="txtJZJG" name="txtJZJG" <s:if test='%{ACT != "C"}'> value="<s:property value="t00362Bean.cd_00001_jzjg" />"</s:if>/>		-->
<!--				    <span><select class="txtfocus txtSelect" id="txtJZJG" name="txtJZJG" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></select></span>-->
				</td>
			</tr>
			
          	<tr>
	            <td>
	                <label class="labelA">
						<s:property value="%{getText('app.xtwh.sywh.xzxs')}" />(%)
	                </label>
	                <input class="txtfocus txtNumber" name="txtXZXS" id="txtXZXS" type="text" <s:if test='%{ACT != "C"}'> value='<s:property value="t00362Bean.xzxs"/>'</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
	            </td>
          	</tr>
          	<!--<tr>
				<td>
					<label class="labelA"><s:property value="%{getText('app.xtwh.t00361.czlx')}" /></label>
					<input type="radio" class="radio" name="rdoCZLX" id="rdoCZLX0" value="0" checked="checked" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/><s:property value="getText('app.xtwh.t00353.yslb.mcl')"/>
					<input type="radio" class="radio" name="rdoCZLX" id="rdoCZLX1" value="1" <s:if test="%{1==t00362Bean.czlx}">checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/><s:property value="getText('app.xtwh.t00353.yslb.DA')" />
				</td>
			</tr>
          	--><!--<tr>
          		<td>
          		<label class="labelA">
					有无电梯
				</label>
		    	<input type="radio" class="radio" name="rdoYWDT" id="rdoYWDT0" value="0" <s:if test="%{0==t00362Bean.ywdt}">checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />无
				<input type="radio" class="radio" name="rdoYWDT" id="rdoYWDT1" value="1" <s:if test="%{1==t00362Bean.ywdt}">checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />有
 				</td>
          	</tr>
         	--><tr>
	            <td>
	                <label class="labelA">
	                	<s:property value="%{getText('app.note')}" />
	                </label>
	                <textarea name="txtNOTE" cols="30" rows="5" id="txtNOTE" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>><s:if test='%{ACT != "C"}'><s:property value="t00362Bean.note" /></s:if></textarea>
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
			    <a href="VIEWT00362.action"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
		</div>
		</div>
		
</div>
</div>
    </td>
  </tr>
</table>
</body>
</html>
