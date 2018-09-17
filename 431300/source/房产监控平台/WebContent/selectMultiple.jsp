<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/screen.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/selectMultiple.js"></script>

<title>Insert title here</title>
</head>
<body>
<form method="post" action="./LOGIN.action" onsubmit="selectItem();">

	<select	multiple name="fromBox" id="fromBox">
		<option value="3">Finland</option>
		<option value="4">France</option>
		<option value="6">Mexico</option>
		<option value="1">Norway</option>
		<option value="5">Spain</option>
		<option value="2">United Kingdom</option>
	</select> 
	<select multiple name="toBox" id="toBox">
	<option value="12">Canada</option>
	<option value="13">Germany</option>
	<option value="11">United States</option>
	</select>
	
	<input type="submit" value="Alert" />
</form>

<script type="text/javascript">
	createMovableOptions("fromBox", "toBox", 500, 300, 'Available countries', 'Selected countries');
	function selectItem()
	{
		var obj = document.getElementById('toBox');
		for(var no=0;no<obj.options.length;no++){
			obj.options[no].selected = true;
		}
	} 
	function aClick(){
		selectItem();
	}
</script>

<p>
You move elements by clicking on the buttons or by double clicking on select box items
</p>
<p>
Note:this is the select multiple control demo!
</p>
</body>
</html>