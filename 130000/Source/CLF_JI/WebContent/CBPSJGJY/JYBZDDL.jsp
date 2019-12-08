<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="v00054List" status="index">
	<option value="<s:property value="bzbm" />">
		<s:property	value="bzmc" />
	</option>
</s:iterator>
