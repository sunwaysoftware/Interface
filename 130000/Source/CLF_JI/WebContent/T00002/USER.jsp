<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div style="width:180px;height:200px;overflow:auto;border: 2px inset #FFFFFF;">
<s:iterator value="tabList" id="userEntity" status="index">
	<span class="qtxz"><input type="checkbox" class="radio" name="chkUSERID" id="chkUSERID" value='<s:property value="userid" />' 
		<s:if test="isuser">checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
	<s:property value="usernm" /></span>
</s:iterator>
</div>