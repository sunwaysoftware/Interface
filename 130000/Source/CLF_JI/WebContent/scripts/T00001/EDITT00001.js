$(document).ready(function() {
	
	$("#txtROOTID").blur(function(){
		$("#ddlROOTID").val($("#txtROOTID").val());
		var infoID = $("#txtROOTID").val();
		var rootID = $("#txtROOTID").val();
		
		getInfoData(infoID,infoID,null,'C');
		getMaxInfoId(rootID);
	});
	
	$("#ddlROOTID").change(function(){
		$("#txtROOTID").val($("#ddlROOTID").val());		
		var infoID = $("#ddlROOTID").val();
		var rootID = $("#ddlROOTID").val();
		
		getInfoData(infoID,infoID,null,'C');
		getMaxInfoId(rootID);
	});	
	
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