<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<table id="scroll1" class="scroll" cellpadding="0" cellspacing="0" style="width:100%;height:350px">
    <thead>
		<tr>
			<th twidth="40"><input type="checkbox" name="chkSelAll" id="chkSelAll" class="rootCheck radio" value="true"/></th>
			<th twidth="40">No</th>
			<th twidth="150"><s:property value="%{getText('app.sjcj.t00302.fcid')}" /></th>
			<th twidth="150"><s:property value="getText('app.psjgcl.t00041.swid')"/></th>
			<th twidth="150"><s:property value="getText('app.psjgcl.t00041.nsrmc')"/></th>
			<th twidth="150"><s:property value="getText('app.psjgcl.t00041.pgjg')"/></th>
			<th twidth="150"><s:property value="getText('app.psjgcl.t00041.jsze')"/></th>
			<th twidth="150"><s:property value="getText('app.psjgcl.t00041.ynze')"/></th>
		</tr>
    </thead>
	<tbody id="divShow">
		<tr id="rowtemplate">
			<td id="chk"></td>
		    <td id="no"></td>
		    <td id="fcid"></td>
		    <td id="swid"></td>
			<td id="nsrmc"></td>
			<td id="pgjg" align="right"></td>
			<td id="jsze" align="right"></td>
			<td id="ynze" align="right"></td>
		</tr>
	</tbody>
</table>