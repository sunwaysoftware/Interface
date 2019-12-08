<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="scripts/jquery.min.js"></script>
<script type="text/javascript" src="scripts/jquery.validate.js"></script>
<script type="text/javascript" src="scripts/messages_cn1.js"></script>
<script language="javascript" type="text/javascript">
$(document).ready(function() {

	//FROM验证信息
	$("#sessionForm").validate({
		rules: {
			ddlSSGX: {required: true}
		}
	});
});
</script>
</head>
<body>
<s:actionmessage/><s:actionerror/>
THIS IS THE SELECT SSGX PAGE.——税收管辖选择页面<hr/>
<form action="SETSESSION.action" id="sessionForm" method="post">
<select name="ddlSSGX" id="ddlSSGX" size="10" style="color:blue; width:300px">
	<s:iterator value="ssgxList" status="index" id="ssgxEntity">
		<option value='<s:property value="cd00001Ssgx"/>'><s:property value="ssgx"/></option>
	</s:iterator>
</select>
<input type="submit" name="btnSSGX" id="btnSSGX" value="选择"/>
</form>
</body>
</html>