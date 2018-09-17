<%@ page contentType="text/html; charset=utf-8" language="java" isErrorPage="true" %>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table border="0" cellspacing="0" cellpadding="0">
			<tr>
		   		 <td>
					<img src="../images/ico/err000.png" width="80" height="80">
				</td>
				<td>
					<s:actionerror cssStyle="color:red;"/>
				</td>
			</tr>
		</table>
</div>
</body>
</html>