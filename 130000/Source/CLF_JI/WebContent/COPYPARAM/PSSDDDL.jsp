<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="pssdList" status="index">
		<option value="<s:property value="pssds" />">
			<s:property	value="pssds" />
		</option>
</s:iterator>
