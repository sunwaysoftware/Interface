<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/T00013/EDITT00013.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>



<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});
</script>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
   <div class="ui-widget-content">
		<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00013.title')}" /></span>                 
  		</div>	
		<div id="INFO" class="divConect">
		<div style="min-height:400px">
<form action="EDITT00013.action" method="post" id="editForm">
		<input type="hidden" name="ACT" value="D" />
		<table width="500" border="0" cellspacing="2" cellpadding="0">
		    <tr>
				<td>
					<label class="labelA"><s:property value="%{getText('app.xtwh.t00013.startdate')}" /></label>
					<input name="txtSTARTDATE" id="txtSTARTDATE" type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'txtENDDATE\',null);}'})" class="Wdate" />
				</td>
         	</tr>
         	<tr>
				<td>
					<label class="labelA"><s:property value="%{getText('app.xtwh.t00013.enddate')}" /></label>
					<input name="txtENDDATE" id="txtENDDATE" type="text"  onfocus="WdatePicker({minDate:'#F{$dp.$D(\'txtENDDATE\',null);}'})" class="Wdate" />
				</td>
         	</tr>
         	<tr>
				<td>
					<label class="labelA"><s:property value="%{getText('app.xtwh.t00013.logtype')}" /></label>
					<select name="txtLOGTYPE" id="txtLOGTYPE">
					<option>全部</option>
					<s:iterator value="czList" status="step">
					<option value="<s:property value="logType"/>"><s:property value="logTypeName"/></option>
					</s:iterator>
					</select>
				</td>
         	</tr>
         	<tr>
				<td>
					<label class="labelA"><s:property value="%{getText('app.xtwh.t00013.tablename')}" /></label>
					<input name="txtTABLENAME" id="txtTABLENAME" type="text" />
				</td>
         	</tr>
        </table>
    </form>
     </div>
		<div class="divbottom">
		<a href="javascript:AppSubmit();">
		<img src="../images/ico/Delete.gif" width="16" height="16" title="<s:property value="getText('app.button.del')"/>" alt="<s:property value="getText('app.button.del')"/>" /><s:property value="getText('app.button.del')"/></a>
		<a href="VIEWT00013.action"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
		</div>
	</div>
	</div>
    </td>
  </tr>
</table>
</body>
</html>
