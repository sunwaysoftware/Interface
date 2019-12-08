<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}" /></title>
<link rel="stylesheet" type="text/css" href="../css/screen.css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/T00331/INFOT00331.js"></script>
</head>
<body>
<input type="hidden" name="chkTrue" id="chkTrue" value="<s:property value="%{getText('app.global.checkbox.true')}" />"/>
<input type="hidden" name="chkFalse" id="chkFalse" value="<s:property value="%{getText('app.global.checkbox.false')}" />"/>
<input type="hidden" id="txtSWID" name="txtSWID" value="<s:property value="txtSWID"/>" >
<table id="scroll1" class="scroll" cellpadding="0" cellspacing="0" style="width:100%;height:350px">
    <thead>
		<tr>
			<th twidth="40">No</th>
			<th twidth="60">操作</th>
			<th twidth="130"><s:property value="getText('app.sjpg.t00331.fcid')"/></th>
			<th twidth="150"><s:property value="getText('app.sjpg.t00331.swid')"/></th>
			<th twidth="150"><s:property value="getText('app.sjpg.t00331.nsrmc')"/></th>
			<th twidth="150"><s:property value="getText('app.sjpg.t00331.pssdy')"/></th>
			<th twidth="120"><s:property value="getText('app.sjpg.t00331.pgjg')"/></th>
			<th twidth="120"><s:property value="getText('app.sjpg.t10031.gbpgjg')"/></th>
			<th twidth="150"><s:property value="getText('app.sjpg.t00331.pfmjg')"/></th>
			<th twidth="180"><s:property value="getText('app.sjpg.t00331.jysj')"/></th>
			<th twidth="150"><s:property value="getText('app.sjpg.t00331.lcxz')"/></th>
			<th twidth="150"><s:property value="getText('app.sjpg.t00331.lfid')"/></th>
			<th twidth="150"><s:property value="getText('app.sjpg.t00331.xqdm')"/></th>
			<th twidth="150"><s:property value="getText('app.sjpg.t00331.szlc')"/></th>
			<th twidth="150"><s:property value="getText('app.sjpg.t00331.zlc')"/></th>
			<th twidth="150"><s:property value="getText('app.sjpg.t00331.ywdt')"/></th>
			<th twidth="150"><s:property value="getText('app.sjpg.t00331.jzmj')"/></th>
			<th twidth="150"><s:property value="getText('app.sjpg.t00331.pgczr')"/></th>
		</tr>
    </thead>
	<tbody id="divShow">
		<tr id="rowtemplate">
		    <td id="no" align="center"></td>
			<td id="msg" align="center"></td>
			<td id="fcid" align="center"></td>
			<td id="swid"></td>
			<td id="nsrmc"></td>
			<td id="pssd" align="center"></td>
			<td align="right" id="pgjg"></td>
			<td align="right" id="gbpgjg"></td>
			<td align="right" id="pfmjg"></td>
			<td id="jysj" align="center"></td>
			<td align="right" id="lcxz"></td>
			<td id="lfid" align="center"></td>
			<td id="xqdm"></td>
			<td align="right" id="szlc"></td>
			<td align="right" id="zlc"></td>
			<td id="ywdt" align="center"></td>
			<td align="right" id="jzmj"></td>
			<td id="pgczr"></td>
		</tr>
	</tbody>
</table>

</body>
</html>