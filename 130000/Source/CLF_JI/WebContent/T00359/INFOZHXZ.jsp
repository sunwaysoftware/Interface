<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="zhxzList" id="zhxzEntity" status="index" >
	<s:property value="infonm"/>	
		<input type="checkbox" class="radio" id="chkZHXZ" name="chkZHXZ" value="<s:property value="infoid"/>"
			<s:iterator value="tabList" id="tabEntity" status="index" >
				<s:if test="%{#tabEntity.cd00001Infoid == #zhxzEntity.infoid}">
					checked="checked"
				</s:if>
			</s:iterator>/><br/>
</s:iterator>
				
