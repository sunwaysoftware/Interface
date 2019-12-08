<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00010/EDITT00010.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>





<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });

		getUser('<s:property value="t00003Bean.roleid" />','<s:property value="txtSSGXFind" />','<s:property value="ACT"/>');
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
       		<div class="datagrid-title"><span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00003.title')}" /></span></div>

		<div id="INFO" class="divConect">		
<form id="editForm" action="EDITT00010.action" method="post">
	<input type="hidden" name="ACT" value="<s:property value="ACT"/>" />
	<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00003Bean.upddate"/></s:text>" />
	<input type="hidden" name="ISADMIN" id="ISADMIN" value="<s:property value="ISADMIN"/>" />  
	 
	<s:if test='%{ACT!="C"}'>
		<input name="txtROLEID" type="hidden" id="txtROLEID" value="<s:property value="t00003Bean.roleid" />" />
	</s:if>
	<s:if test='%{ACT=="D"}'>
		<input name="txtROLENM" type="hidden" id="txtROLENM" value="<s:property value="t00003Bean.rolenm" />" />
	</s:if>
      		<table width="200" border="0" cellspacing="3" cellpadding="0">
			 <tr>
	   		 <td valign="top">
			<fieldset>
                <legend>基本信息</legend>
                    <table width="200" border="0" cellspacing="2" cellpadding="0">
					<tr>
			    		<td><label class="labelA">	
								<s:property value="%{getText('app.xtwh.t00003.rolenm')}" />
							</label>
							<s:property value="t00003Bean.rolenm" />
						</td>
					</tr>
					<tr>
			    		<td><label class="labelA">	
								<s:property value="%{getText('app.note')}" />
							</label>
							<s:property value="t00003Bean.note" />
						</td>
					</tr>			
				</table>
			</fieldset>
			</td>
			</tr>
			<tr>
	   		 <td valign="top">
				<fieldset style="width:200px"><legend>用户信息</legend>
                    <table width="100%" border="0" cellspacing="2" cellpadding="0">                    
                    <tr>
						<td>
							<s:property value="getText('app.xtwh.info.ssgx')" />					
							<input type="hidden" class="txtCode" id="txtSSGXFind" name="txtSSGXFind" value="<s:property value="txtSSGXFind" />"/>
	  						<span class="txtInfonm"><input type="text" id="txtSSGXTIP" name="txtSSGXTIP" readonly="readonly"/><span id="spSSGX"></span></span>
						</td>
					</tr>
                    <tr>
                    <td>
					<div id="divUser"></div>
						</td>
					</tr>
				</table>
				</fieldset>		
				</td>
			</tr>
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
		<a href="VIEWT00003.action">
			<img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/>
		</a>
	</div>
	</div>	
	<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>			
</div>
</div>
    </td>
  </tr>
</table>
</body>
</html>
