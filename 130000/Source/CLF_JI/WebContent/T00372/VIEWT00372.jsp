<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#sub").click(function(){

		$.ajax({
			type : 'POST',
			cache : false,
			url : 'TEST00372.action',
			data : {testTxt : $("#testTxt").val()},
			dataType : 'json',
			success : function(msg){
						$("#resTxt").val(msg.testTxt);
					},
			error : function(){

					}
		});
	});

	$("#res").click(function(){
		$("#testTxt").val("");
		$("#resTxt").val("");
	});
});
</script>
</head>
<body>
	<table>
		<tr>
			<td>
				输入窗口：
				<br />
				<textarea style="width:500px;height:500px" id="testTxt"></textarea>
				<br />
				<input type="button" id="sub" value="发送"/>
			</td>
			<td>
				返回结果：
				<br />
				<textarea style="width:500px;height:500px" id="resTxt"></textarea>
				<br />
				<input type="button" id="res" value="重置"/>
			</td>
		</tr>
	</table>
	
</body>
</html>