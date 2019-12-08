<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/T00051/EDITT00051.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>



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
            <li><a href="#INFO"><span><s:property value="%{getText('app.xtwh.t00051.title')}" /></span></a></li>                    
        </ul>
		<div id="INFO" class="divConect">
		<div style="min-height:400px">
<form action="EDITT00051.action" method="post" id="editForm">
		<s:if test='%{ACT!="C"}'>
			<input type="hidden" name="txtPSSD" id="txtPSSD" value="<s:text name="app.global.format.date"><s:param value="t00051Bean.cd00002Pssd" /></s:text>" />
		</s:if>
		<input type="hidden" name="ACT" value='<s:property value="ACT"/>' /> 
		<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00051Bean.upddate"/></s:text>" />
		
		<table width="500" border="0" cellspacing="3" cellpadding="0">
			<tr>
				<td><label class="labelA">
						<s:property value="getText('app.xtwh.t00001.pssd')"/>
					</label>
					<input type="text" id="txtPSSD" name="txtPSSD" value="<s:if test="%{null!=t00051Bean.cd00002Pssd}"><s:text name="app.global.format.date"><s:param value="t00051Bean.cd00002Pssd" /></s:text></s:if>" <s:if test='%{ACT!="C"}'>disabled="disabled"</s:if> onfocus="WdatePicker({dateFmt:'yyyy-MM-dd', maxDate:'%y'})" class="Wdatefocus txtfocus" />	
				</td>
			</tr>		
	 		<tr>
	    		<td><label class="labelA">
	        			<s:property value="getText('app.xtwh.info.szqy')"/>
   					</label>
   					<sw:szqy items="szqyList" name="ddlSZQY" id="ddlSZQY" classid="txtfocus" checked="t00051Bean.cd00001Szqy" disabled="ACT" />
				</td>
    		</tr>   
           <tr>
	            <td><label class="labelA">
	                    <s:property	value="%{getText('app.xtwh.info.fwlx')}" />
	                </label>
	                  <span class="txtInfonm txtfocus"><input name="txtFWLXTIP" id="txtFWLXTIP" type="text" value="<s:property value="t00051Bean.fwlx" />" readonly="readonly" <s:if test='%{"C"!=ACT}'>disabled="disabled"</s:if>/><span<s:if test='%{ACT!="D"}'> id="spFWLX"</s:if>></span></span><input type="hidden" id="txtFWLX" name="txtFWLX" value="<s:property value="t00051Bean.cd00001Fwlx" />"/>
	            </td>
       		</tr>    		
           <tr>
	            <td><label class="labelA">
	                    <s:property	value="%{getText('app.xtwh.info.jylx')}" />
	                </label>
	                  <span class="txtInfonm txtfocus"><input name="txtJYLXTIP" id="txtJYLXTIP" type="text" value="<s:property value="t00051Bean.jylx" />" readonly="readonly" <s:if test='%{"C"!=ACT}'>disabled="disabled"</s:if>/><span<s:if test='%{ACT!="D"}'> id="spJYLX"</s:if>></span></span><input type="hidden" id="txtJYLX" name="txtJYLX" value="<s:property value="t00051Bean.cd00001Jylx" />"/>
	            </td>
       		</tr> 
			<tr>
				<td><label class="labelA">
						<s:property value="getText('app.xtwh.t00051.jsbl')"/>
					</label>
					<input type="text" class="txtfocus txtNumber" id="txtJSBL" name="txtJSBL" value="<s:property value="t00051Bean.jsbl" default="0" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />	
				</td>
			</tr>
			<tr>
				<td><label class="labelA">
						<s:property value="getText('app.xtwh.t00051.sl')"/>
					</label>
					<input type="text" class="txtfocus txtNumber" id="txtSL" name="txtSL" value="<s:property value="t00051Bean.sl" default="0" />"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />	
				</td>
			</tr>
			<tr>
				<td><label class="labelA">
						<s:property value="%{getText('app.note')}" />
					</label>
					<textarea name="txtNOTE" id="txtNOTE" cols="20" rows="3" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> ><s:property value="t00051Bean.note" /></textarea>
				</td>
			</tr>
		</table>	
		</form>
		</div>
		<div class="divbottom">
		<div>			
			<a href="javascript:void(0)" id="btnUpd" name="btnUpd" <s:if test='%{ACT=="C"}'>style="display:none"</s:if>><img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" /><s:property value="getText('app.button.upd')"/></a>
		  	<a href="javascript:void(0)" id="btnAdd" name="btnAdd" <s:if test='%{ACT!="C"}'>style="display:none"</s:if>><img src="../images/ico/Update.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.save')"/>" /><s:property value="getText('app.button.save')"/></a>
			<a href="VIEWT00051.action"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
		</div>
     </div>		
</div>
</div>
    </td>
  </tr>
</table>
<input type="hidden" name="hidSelect" id="hidSelect" />
<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
	<div id="infoTreeDIV"></div>
</div>
</body>
</html>
