<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}" /></title>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>

<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00351CS/VIEWT00351SAME.js"></script>

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
		<div id="tabs"
			class="ui-widget-content">
		<ul
			class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
			<li><a href="#INFO"><span><s:property
				value="%{getText('app.xtwh.bzfcs.title.samearea')}" /></span></a></li>
		</ul>
		<div id="INFO" class="divConect">
<form id="editForm" action="EXECVIEWT00351CSSAME.action" method="post">
<input type="hidden" name="hidSelect" id="hidSelect" />
<table width="600" border="0" cellspacing="2" cellpadding="0">
	<tr>
		<td>
			<table width="100%" border="0" cellspacing="2" cellpadding="0">
				<tr>
					<td><s:property value="%{getText('app.xtwh.t00001.pssd')}" /></td>
					<td><input name="txtPSSD" id="txtPSSD" type="text" value="" onfocus="WdatePicker({dateFmt:'yyyy-MM'})" class="Wdatefocus"/></td>
					<td><s:property value="getText('app.xtwh.info.szqy')" /></td>
					<td><sw:szqy items="szqyList" name="ddlSZQY" id="ddlSZQY" classid="txtfocus" display="请选择" /></td>
					<td><s:property value="getText('app.xtwh.t00303.xqmc')" /></td>
					<td>
						<span class="txtInfonm"><input name="txtXQMCNM" id="txtXQMCNM" type="text" value="<s:property value='txtXQMCNM'/>" /><span<s:if test='%{ACT!="D"}'> id="spXQMC"</s:if>></span></span><input name="txtXQMC" id="txtXQMC" type="hidden" value="<s:property value='txtXQMC'/>"/>
					</td>
				</tr>
				<tr>
					<td><s:property value="%{getText('app.xtwh.info.fwlx')}" /></td>
					<td>
						<span class="txtInfonm"><input name="txtFWLXNM" id="txtFWLXNM" type="text" value="<s:property value='txtFWLXNM'/>"/><span<s:if test='%{ACT!="D"}'> id="spFWLX"</s:if>></span></span><input name="txtFWLX" id="txtFWLX" type="hidden" value="<s:property value='txtFWLX'/>"/>
					</td>
					<td><s:property value="%{getText('app.xtwh.info.jzjg')}" /></td>
					<td>
						<span class="txtInfonm"><input name="txtJZJGNM" id="txtJZJGNM" type="text" value="<s:property value='txtJZJGNM'/>"/><span<s:if test='%{ACT!="D"}'> id="spJZJG"</s:if>></span></span><input name="txtJZJG" id="txtJZJG" type="hidden" value="<s:property value='txtJZJG'/>"/>
					</td>
					<td><s:property value="%{getText('app.xtwh.info.jylx')}" /></td>
					<td>
						<span class="txtInfonm"><input name="txtJYLXNM" id="txtJYLXNM" type="text" value="<s:property value='txtJYLXNM'/>"/><span<s:if test='%{ACT!="D"}'> id="spJYLX"</s:if>></span></span><input name="txtJYLX" id="txtJYLX" type="hidden" value="<s:property value='txtJYLX'/>"/>
					</td>
				</tr>
				<tr>
					<td><s:property value="%{getText('app.xtwh.t00303.ywdt')}" /></td>
					<td>
						<select id="rdoYWDT" name="rdoYWDT">
							<option value="">全部</option>
							<option value="0">无</option>
							<option value="1">有</option>
						</select>
					</td>
					<td>
						<input name="btnSearch" type="button" id="btnSearch" class="button"
						value="<s:property value="getText('app.button.search')"/>" />
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<input type="hidden" id="hidFlag" name="hidFlag" />
<table id="scroll1" class="scroll" cellpadding="0" cellspacing="0" style="width: 100%; height: 300px">
	<thead>
		<tr>
			<th twidth="50">No</th>
			<th twidth="50">操作</th>
			<th twidth="150"><s:property value="%{getText('app.xtwh.t00351.slid')}" /></th>
			<th twidth="100"><s:property value="%{getText('app.xtwh.t00303.xqmc')}" /></th>						
			<th twidth="200"><s:property value="%{getText('app.xtwh.t00303.zcdzl')}" /></th>					
			<th twidth="100"><s:property value="%{getText('app.xtwh.info.jylx')}" /></th>
			<th twidth="150"><s:property value="%{getText('app.xtwh.info.fwlx')}" /></th>
			<th twidth="120"><s:property value="%{getText('app.xtwh.info.jzjg')}" /></th>						
			<th twidth="100"><s:property value="%{getText('app.xtwh.bzfcs.col.slcount')}" /></th>
			<th twidth="100"><s:property value="%{getText('app.xtwh.bzfcs.col.bzcount')}" /></th>
		</tr>
	</thead>
	<tbody id="divShow">
		<tr id="rowtemplate">
			<td id="no" align="center"></td>
			<td id="chk" align="center"></td>
			<td id="slid" align="center"></td>
			<td id="xqnm"></td>	
			<td id="zldz"></td>						
			<td id="jylx"></td>
			<td id="fwlx"></td>
			<td id="jzjg"></td>					
			<td id="slcnt"></td>
			<td id="bzcnt"></td>
		</tr>
	</tbody>
</table>
挂牌数据权重<input id="txtGPQZ" name="txtGPQZ" type="text" style="width: 50px;" value="20"  class="txtfocus"/>%&nbsp;&nbsp;&nbsp;&nbsp;挂牌数据下浮<input id="txtGPXF" name="txtGPXF" type="text"  style="width: 50px;" value="90" class="txtfocus"/>%
</form>

<div class="divbottom">
	<a href="javascript:document.getElementById('hidFlag').value='1';AppSubmit();">
		<img src="../images/ico/Add.gif" width="16" height="16"/><s:property value="getText('app.xtwh.bzfcs.btn.select')"/>
	</a>
	<a href="javascript:document.getElementById('hidFlag').value='2';AppSubmit();">
		<img src="../images/ico/Add.gif" width="16" height="16"/><s:property value="getText('app.xtwh.bzfcs.btn.selectAll')"/>
	</a>
</div>
<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
	<div id="infoTreeDIV"></div>
</div>
</div>
	</div>
	</tr>
</table>
</body>
</html>