$(document).ready(function() {
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtPSSD: {required: true},
			ddlPSSD: {required: true}
		}
	});	
	
	var url = $('#url').val();

		$.ajax( {
			type :'GET',
			url :'ViewPSSDDDLNOSZQY.action',
			cache: false,
			data :{
					URL: url
					
				  },
			success : function(res) {
				$('#ddlPSSD').html('<option value="">请选择...</option>' + res);
			},
			error : function() {
				$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
			}
		});		
});

function AppSubmit1(){
	var flag = confirm('确定要进行复制吗?');
	if (flag) {
		$('#editForm').submit();
	}
}