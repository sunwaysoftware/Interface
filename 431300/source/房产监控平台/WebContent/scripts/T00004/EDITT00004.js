$(document).ready(function() {
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtJS: {required: true},	
			txtXS: {required: true}		
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
