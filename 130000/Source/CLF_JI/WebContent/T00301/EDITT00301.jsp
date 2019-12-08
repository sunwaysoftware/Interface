<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00301/EDITT00301.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});    
</script>
<style type="text/css">
<!--
.labelA {
	width:120px;
}
body {
	background-color: #FFFFFF;
}
-->
</style>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
<form action="EDITT00301.action" method="post" id="editForm">
	<input type="hidden" name="ACT" id="ACT" value="<s:property value="ACT"/>"/>
	<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00301Bean.upddate"/></s:text>" />
	<input type="hidden" name="hidSelect" id="hidSelect" />
	<input type="hidden" name="forward" id="forward" />
	<input type="hidden" name="txtSWID" id="txtSWID" value="<s:property value="t00301Bean.swid"/>" />
	<s:if test='%{ACT!="C"}'>
		<input type="hidden" name="txtSWIDOLD" id="txtSWIDOLD" value="<s:property value="t00301Bean.swid"/>" />
	</s:if>
		<table width="400" border="0" cellspacing="3" cellpadding="0">
		  <tr>
   		 <td>
		<fieldset>
			<legend>【基本信息】</legend>
			<table width="100%" border="0" cellspacing="2" cellpadding="0">	
			<tr>
    			<td><label class="labelA">			
						<s:property value="getText('app.sjcj.t00301.nsrmc')"/>
					</label>
					<input type="text" class="txtfocus" id="txtNSRMC" name="txtNSRMC" value="<s:property value="t00301Bean.nsrmc"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
				</td>
			</tr>		
      		<tr>
	    		<td><label class="labelA">	
						<s:property value="getText('app.sjcj.t00301.swid')"/>
					</label>
					<input type="text" class="txtfocus" id="txtSWID" name="txtSWID" value="<s:property value="t00301Bean.zjhm"/>" <s:if test='%{ACT=="C"}'>disabled="disabled"</s:if> />
				</td>
			</tr>
			<tr>
    			<td><label class="labelA">
						<s:property value="getText('app.xtwh.info.zjlx')"/>
					</label>
					<span class="txtInfonm txtfocus"><input type="text" id="txtZJLXNm" name="txtZJLXNm" value="<s:property value="t00301Bean.zjlx"/>" readonly="readonly" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spZJLX"</s:if>></span></span><input type="hidden" id="txtZJLXId" name="txtZJLXId" value="<s:property value="t00301Bean.cd00001Zjlx"/>"/>					
				</td>
			</tr>
			<!--
			<tr>
    			<td><label class="labelA">
						<s:property value="getText('app.sjcj.t00301.zz')"/>
					</label>
					<input type="text" class="txtFWZLDZ txtfocus" id="txtZZ" name="txtZZ" value="<s:property value="t00301Bean.zz"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
				</td>
			</tr>
			-->
			<tr>
    			<td><label class="labelA">
						<s:property value="getText('app.sjcj.t00301.lxdh')"/>
					</label>
					<input type="text" id="txtLXDH" name="txtLXDH" value="<s:property value="t00301Bean.lxdh"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
				</td>
			</tr>
			
			
			
			
 		</table>
	</fieldset>
	<fieldset>
		<legend>【备注】</legend>
			<table width="100%" border="0" cellspacing="2" cellpadding="0">
				<tr>
					<td>
					&nbsp;
						<textarea id="txtNOTE" name="txtNOTE" cols="43" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>><s:property value="t00301Bean.note"/></textarea>
					</td>
				</tr>
			</table>
	</fieldset>	
		</td>
	</tr>
</table>	
</form>
<div class="divbottom">
	<s:if test='%{ACT=="U"}'>
		<a href="javascript:AppSubmit();">
			<img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" />
			<s:property value="getText('app.button.upd')"/>
		</a>
	</s:if>
</div>
<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:150px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
</div>
    </td>
  </tr>
</table>
<s:if test='%{forward}'>
	<script language="javascript">
		window.parent.addFCXX('<s:property value="SWID" />');
	</script>
</s:if>
</body>
</html>
