$(document).ready(function() {
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			ddlSZQY: {required: true},
			ddlPSSD: {required: true},
			txtPSSD: {required: true}
		}
	});
	$('#ddlPSSD').click(function(){
		if ($('#ddlSZQY').val() == '') {
			$.notifyBar({html:'请先选择所在区域'});
		}
	});
	//
	$('#ddlSZQY').change( function() {
		var url = $('#url').val();
		var szqy = $('#ddlSZQY').val();
		$("#loading").show();
			$.ajax( {
				type :'GET',
				url :'ViewPSSDDDL.action',
				cache: false,
				data :{
						URL: url,
						ddlSZQY: szqy
					  },
			  complete:function()
		        {
					$("#loading").hide();
		        },	  
				success : function(res) {
					$('#ddlPSSD').html('<option value="">请选择...</option>' + res);
				},
				error : function() {
					$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
				}
			});
		});
});

function AppSubmit1(){
	var flag = confirm('确定要进行复制吗?');
	if (flag) {
		$('#editForm').submit();
	}
}