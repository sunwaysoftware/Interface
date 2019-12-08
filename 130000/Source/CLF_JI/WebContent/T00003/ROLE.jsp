<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="../scripts/T00003/ROLE.js"></script>
<script type="text/javascript" src="../scripts/simpleTips/jquery.simpleTips-1.0.js"></script>
<link rel="stylesheet" type="text/css" href="../scripts/simpleTips/jquery.simpleTips.css" />
<div style="width:180px;height:200px;overflow:auto;border: 2px inset #FFFFFF;">
<s:iterator value="tabList" id="roleEntity" status="index">
	<span class="qtxz">
	 	<input type="checkbox" class="radio" name="chkROLEID" id="chkROLEID" value='<s:property value="roleid" />' 
	 		<s:if test="isrole">checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
		<span onmouseover="MyTip(this,'<s:property value="roleid" />')" onmouseout="UnTip()"><s:property value="rolenm" /></span>
	</span>
</s:iterator>
</div>