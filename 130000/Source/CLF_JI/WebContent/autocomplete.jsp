<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="dataList" status="dex">
		<s:set name="index" value="#dex.getIndex()"/>
		<s:property value="dataList.get(#index)"/>
</s:iterator>