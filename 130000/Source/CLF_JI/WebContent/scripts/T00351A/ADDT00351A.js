$(document).ready(function() {
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtPFMJG: {required: true, number: true, min:1, maxlength : 14},
			txtJYSJ: {required: true, dateISO: true},
			txtNOTET00351A: {maxlength : 200}
		}
	});	
});
