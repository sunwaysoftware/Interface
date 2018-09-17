$(document).ready(function() {
	if($("#ACT").val() == "C"){
		getInfoData($("#ddlROOTID").val(),$("#ddlROOTID").val(),null,'C');
		getMaxInfoId($("#ddlROOTID").val());
	}
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			ddlROOTID: {required: true},
			txtINFOID: {required: true},
			txtINFONM: {required: true},
			txtNOTE: {maxlength : 200},
			rdoPARENT: {required: true}
		}
	});
});

//提交表单
function AppSubmit(){
	$("#editForm").submit();
};

