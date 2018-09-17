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
	
	checkDate();
	
	$("#rdoMSSIGN0").click(function(){
		checkDate();
	});
	
	$("#rdoMSSIGN1").click(function(){
		checkDate();
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

function checkDate()
{
	if($("#rdoMSSIGN0")[0].checked){
		$("#txtDJZ_QS").attr("disabled", false);
		$("#txtDJZ_QS").val("0");
		$("#txtDJZ_YYS").attr("disabled", false);
		$("#txtDJZ_YYS").val("0");
		$("#txtDJZ_CJS").attr("disabled", false);
		$("#txtDJZ_CJS").val("0");
		$("#txtDJZ_DFJYS").attr("disabled", false);
		$("#txtDJZ_DFJYS").val("0");
		$("#txtDJZ_GRSDS").attr("disabled", false);
		$("#txtDJZ_GRSDS").val("0");
		$("#txtDJZ_YHS").attr("disabled", false);
		$("#txtDJZ_YHS").val("0");
		$("#txtDJZ_TDZZS").attr("disabled", false);
		$("#txtDJZ_TDZZS").val("0");
		$("#txtFPHM").attr("disabled", false);
		$("#txtQSSPHM").attr("disabled", false);
		$("#txtDFGSSPHM").attr("disabled", false);
		$("#txtMSZCYJ").attr("disabled", true);
		
	}else if($("#rdoMSSIGN1:checked").val()==1){		
		$("#txtDJZ_QS").attr("disabled", true);
		$("#txtDJZ_QS").val("0");
		$("#txtDJZ_YYS").attr("disabled", true);
		$("#txtDJZ_YYS").val("0");
		$("#txtDJZ_CJS").attr("disabled", true);
		$("#txtDJZ_CJS").val("0");
		$("#txtDJZ_DFJYS").attr("disabled", true);
		$("#txtDJZ_DFJYS").val("0");
		$("#txtDJZ_GRSDS").attr("disabled", true);
		$("#txtDJZ_GRSDS").val("0");
		$("#txtDJZ_YHS").attr("disabled", true);
		$("#txtDJZ_YHS").val("0");
		$("#txtDJZ_TDZZS").attr("disabled", true);
		$("#txtDJZ_TDZZS").val("0");
		$("#txtFPHM").attr("disabled", true);
		$("#txtQSSPHM").attr("disabled", true);
		$("#txtDFGSSPHM").attr("disabled", true);
		$("#txtMSZCYJ").attr("disabled", false);
	}
}
