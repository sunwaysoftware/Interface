$(document).ready(function() {
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			//txtQTXZNM:{required: true, maxlength : 200},
			//txtXZXS:{required: true, number: true},
			txtGAJG:{required: true, number: true},
			txtNOTE:{required: true, maxlength : 200}
		}
	});
	
	$("#btnDle").click(function(){
		$("#txtGAJG").val(0);
		$("#txtNOTE").val("");
		Delete();
	});
});

function Delete() {
	$.ajax({
		   type: "GET",
		   cache: false,
		   url: "EDITT00333.action",
		   data: {ACT: 'D',
			   	  txtFCID :$("#txtFCID").val()},
		   success: function(msg){
			   $.notifyBar({cls: "success", html: '删除成功'});
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});
}
