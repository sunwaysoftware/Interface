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
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/COPYPARAM/PARAMCOPYWSZQY.js"></script>



<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});    
</script>
<style type="text/css">
<!--
.labelA {
	width: 110px;
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
            <li><a href="#INFO"><span><s:property value="TITLENAME"/>参数复制</span></a></li>                    
        </ul>
		<div id="INFO" class="divConect">
		<div style="min-height:400px">
<form id="editForm" action='<s:property value="ACTIONNAME"/>.action' method="post">
	<input name="url" id="url" type="hidden" value="<s:property value="URL"/>" />
	
	<table width="100%" border="0" cellspacing="3" cellpadding="0">
			
			<tr>
				<td>
					<label class="labelA"><s:property value="%{getText('app.xtwh.t00001.pssd')}" /></label>
				    <select name="ddlPSSD" id="ddlPSSD" class="txtfocus">
				   	 	<option value="">请选择...</option>
					</select> 
				</td>
			</tr>			
			<tr>
				<td>
					<label class="labelA"><s:property value="getText('app.xtwh.t00001.pssd')"/>(YYYY)</label>
					<input type="text" name="txtPSSD" id="txtPSSD" onfocus="WdatePicker({dateFmt:'yyyy'})" class="Wdatefocus txtDateTime" />
				</td>
			</tr>
	</table>
	</form>
	</div>
	<div class="divbottom">
	<a href="javascript:AppSubmit1();"><img
				src="../images/ico/Edit.gif" width="16" height="16" title="复制" alt="复制" />复制</a>
	<a href='<s:property value="HREFNAME"/>.action'><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
	</div>
</div>
</div>
    </td>
  </tr>
</table>
</body>
</html>
