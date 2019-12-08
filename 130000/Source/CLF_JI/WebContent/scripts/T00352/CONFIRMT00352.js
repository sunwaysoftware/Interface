$(document).ready(function() {

	//FROM验证信息
	$("#editForm").validate({
		rules: {
			ddlSZQY: {required: true}
		}
	});

	$("#ddlSZQY").change(function(){
		$("#editForm").attr("action","CONFIRMT00352.action");
		$("#editForm").submit();
	});
});
