$(document).ready(function() {
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			 txtDJZ_QS: {required: true, number: true, maxlength : 14, min:0},
			 txtDJZ_YYS: {required: true, number: true, maxlength : 14, min:0},
			 txtDJZ_CJS: {required: true, number: true, maxlength : 14, min:0},
			 txtDJZ_DFJYS: {required: true, number: true, maxlength : 14, min:0},
			 txtDJZ_GRSDS:{required: true, number: true, maxlength : 14, min:0},
			 txtDJZ_YHS: {required: true, number: true, maxlength : 14, min:0},
			 txtDJZ_TDZZS: {required: true, number: true, maxlength : 14, min:0},
			 txtMSZCYJ: {required: true}
		}
	
	});
	
	//添加
	$("#btnAdd").click(function(){
		if($("#editForm").valid())
			$("#editForm").submit();
	});	
	
	//更新
	$("#btnUpd").click(function(){
		if($("#editForm").valid())
			$("#editForm").submit();
	});
	
	//删除
	$("#btnDel").click(function(){
		$("#editForm").submit();
	});	
	
	
});
