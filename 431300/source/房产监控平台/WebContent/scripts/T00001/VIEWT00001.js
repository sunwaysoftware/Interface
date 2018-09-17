$(document).ready(function() {

	//查询
		$("#subA").click(function(){
			$('#w').window('open');	
			$("#sxkz").show();
		});
	//导出
	$("#subB").click(function(){
			$("#findForm").submit();
		});
	//对象编号
	$("#txtROOTIDFind").blur(function(){
		$("#ddlROOTIDFind").val($("#txtROOTIDFind").val());
	});
	
	$("#ddlROOTIDFind").change(function(){
		$("#txtROOTIDFind").val($("#ddlROOTIDFind").val());;
	});

	
	
	
	
});




