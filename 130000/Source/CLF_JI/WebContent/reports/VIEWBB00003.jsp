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
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/chart/charts.js"></script>
<script type="text/javascript" src="../scripts/chart/modules/exporting.js"></script>	
<script type="text/javascript" src="../scripts/reports/VIEWBB00003.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<script type="text/javascript">
$(function() {
	$.notifyBar( {
		cls : "success",
		html : '<s:property value="actionMessages.get(0)"/>'
	});
	$.notifyBar( {
		cls : "error",
		html : '<s:property value="actionErrors.get(0)"/>'
	});
	<s:if test='%{txtSSGX != null && txtSSGX !=""}'>
		getSSGX('<s:property value="txtSSGX" />','#txtSSGXTIP');
	</s:if>
	<s:if test='%{txtXQFind != null && txtXQFind !=""}'>
		getXQ('<s:property value="ddlSZQYFind"/>','<s:property value="txtXQFind" />','#txtXQTIP');
	</s:if>	
	<s:if test='%{txtFWLXFind != null && txtFWLXFind !=""}'>
		getFWLX('<s:property value="txtFWLXFind" />','#txtFWLXNm');
	</s:if>	
	<s:if test='%{txtJZJGFind != null && txtJZJGFind !=""}'>
		getJZJG('<s:property value="txtJZJGFind" />','#txtJZJGNm');
	</s:if>
	<s:if test='%{txtJYLXFind != null && txtJYLXFind !=""}'>
		getJYLX('<s:property value="txtJYLXFind" />','#txtJYLXNm');
	</s:if>

});
</script>
</head>
<body>
<div class="ui-widget-content">
	<div class="datagrid-title">
		<span class="datagrid-title-text">
				<s:property value="%{getText('app.cxtj.bb00003.title')}" />
	     </span>
	</div>   
		
	<div id="bb" style="width:550px;height:280px;padding:5px;background: #fafafa;">
		<div id="sxkz" style="display:none;">
			<form id="findForm" action="FINDBB00003.action" method="post">
				<input type="hidden" name="hidSelect" id="hidSelect" />
				<input type="hidden" name="sign" id="sign" value='<s:property value="sign" />' />
				<table width="500" border="0" cellspacing="0" cellpadding="0">
				 <tr>
					<td>&nbsp;<s:property value="getText('app.xtwh.info.ssgx')" /></td>
						<td>&nbsp;<span class="txtInfonm"><input type="text" id="txtSSGXTIP" name="txtSSGXTIP" /><span id="spSSGX"></span></span>
						<input type="hidden" id="txtSSGX" name="txtSSGX" value="<s:property value="txtSSGX"/>" />
						</td>
				    <td>&nbsp;<s:property value="getText('app.sjcj.t00301.swid')"/></td>
				    <td>&nbsp;<input type="text" class="txtID" id="txtSWIDFind" name="txtSWIDFind"  value="<s:property value="txtSWIDFind" />"/></td>
				  </tr>	
				 <tr>
				    <td>&nbsp;年份</td>
					<td>&nbsp;<input id="txtPSSDFind" name="txtPSSDFind" value="<s:property value="txtPSSDFind"/>"  onfocus="WdatePicker({dateFmt:'yyyy'})" class="Wdatefocus"/></td>
				    <td>&nbsp;<s:property value="getText('app.xtwh.info.szqy')"/></td>
					<td>&nbsp;<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"  checked="ddlSZQYFind"/></td>
				  </tr>	
				
				  <tr>
				    <td>&nbsp;<s:property value="getText('app.sjcj.t00301.nsrmc')"/></td>
				    <td>&nbsp;<input type="text" class="txtNSRMC" id="txtNSRMCFind" name="txtNSRMCFind" value="<s:property value="txtNSRMCFind" />"/></td>
				    <td>&nbsp;<s:property value="%{getText('app.xtwh.t00303.zcdzl')}" /></td>
					<td>&nbsp;<input name="txtZCDZLFind" id="txtZCDZLFind" type="text" value="<s:property value="txtZCDZLFind" />"/></td>
				  </tr>
				  <tr>
				    <td>&nbsp;<s:property value="getText('app.xtwh.t00303.xqmc')"/></td>
				    <td>&nbsp;<span class="txtInfonm"><input name="txtXQTIP" id="txtXQTIP" type="text"  value="<s:property value="txtXQTIP" />"/><span<s:if test='%{ACT!="D"}'> id="spXQDM"</s:if>></span></span>
				    <input type="hidden" id="txtXQFind" name="txtXQFind" value="<s:property value="txtXQFind" />"/></td>
				 	<td>&nbsp;<s:property	value="%{getText('app.xtwh.info.fwlx')}" /></td>
					<td>&nbsp;<span class="txtInfonm"><input name="txtFWLXNm" id="txtFWLXNm" type="text" value="<s:property value="txtFWLXNm" />" /><span id="spFWLX"></span></span>
					<input type="hidden" id="txtFWLXFind" name="txtFWLXFind" value="<s:property value="txtFWLXFind" />"/></td>
				  </tr>
					   <tr>
					    <td>&nbsp;<s:property	value="%{getText('app.xtwh.info.jzjg')}" /></td>
					    <td>&nbsp;<span class="txtInfonm"><input name="txtJZJGNm" id="txtJZJGNm" type="text" value="<s:property value='txtJZJGNm'/>" /><span id="spJZJG"></span></span>
					    <input type="hidden" id="txtJZJGFind" name="txtJZJGFind" value="<s:property value="txtJZJGFind" />"/></td>
					    <td>&nbsp;<s:property value="%{getText('app.xtwh.info.jylx')}" /></td>
					    <td>&nbsp;<span class="txtInfonm"><input name="txtJYLXNm" id="txtJYLXNm" type="text" value="<s:property value="txtJYLXNm" />" /><span id="spJYLX"></span></span><input type="hidden" id="txtJYLXFind" name="txtJYLXFind" value="<s:property value="txtJYLXFind" />"/></td>
					  </tr>
					  <tr>
					    <td>&nbsp;<s:property value="getText('app.sjcj.t00302.jzmj')"/></td>
					    <td>&nbsp;<input type="text" class="txtNumber" id="txtJZMJMINFind" name="txtJZMJMINFind" value="<s:property value="txtJZMJMINFind"/>" /></td>
					    <td>&nbsp;————</td>
						<td>&nbsp;<input type="text" class="txtNumber" id="txtJZMJMAXFind"  name="txtJZMJMAXFind" value="<s:property value="txtJZMJMAXFind"/>" /></td>
					  </tr>
					   <tr>
					    <td>&nbsp;<s:property value="getText('app.sjcj.t00302.jyjg')"/>(元)</td>
					    <td>&nbsp;<input type="text" class="txtNumber" id="txtJYJGMINFind" name="txtJYJGMINFind" value="<s:property value="txtJYJGMINFind"/>" /></td>
					    <td>&nbsp;————</td>
						<td>&nbsp;<input type="text" class="txtNumber" id="txtJYJGMAXFind"  name="txtJYJGMAXFind" value="<s:property value="txtJYJGMAXFind"/>" /></td>
					  </tr>
					   <tr>
					    <td>&nbsp;<s:property value="getText('app.sjcj.t00302.djrq')"/></td>
						<td>&nbsp;<input type="text" id="txtDJRQFind"  name="txtDJRQFind" value="<s:property value="txtDJRQFind"/>" onfocus="WdatePicker({maxDate:'%y-%M-%d'})" class="Wdate"/></td>
					    <td>&nbsp;<s:property value="getText('app.sjcj.t00302.szlc')"/> </td>
					    <td>&nbsp;<input type="text" id="txtSZLCFind" name="txtSZLCFind" value="<s:property value="txtSZLCFind"/>" /></td>
					  </tr>
					  <tr>
						
					    <td>&nbsp;<s:property value="getText('app.sjcj.t00302.fczh')"/></td>
						<td>&nbsp;<input type="text" id="txtFCZHFind"  name="txtFCZHFind" value="<s:property value="txtFCZHFind"/>" /></td>
					  </tr>	
				</table>
			</form>	
		</div>				
	</div>	
	<div class="divtop">
		<span><a id="subA" href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></span>
    </div>
	<div id="appChart" style="width: 100%; height: 400px; margin: 0 auto;"></div>
</div>
<div id="dialog"  title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
    <div id="infoTreeDIV"></div>
</div>
<div id="msg"></div>
</body>
</html>
