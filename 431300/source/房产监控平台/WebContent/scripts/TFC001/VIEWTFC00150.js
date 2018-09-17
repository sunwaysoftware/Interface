$(document).ready(function() {	

	$("#btnUpd").click(function(){
		if($("#uploadForm").valid()){
			$("#loading").show();
			$("#uploadForm").submit();
		}
	});
	
	$('.rootCheck').click(function(){
		$(".childCheck").each(function(){
			$(this)[0].checked=$('.rootCheck')[0].checked;
		});
	});
	
	
	//FROM验证信息
	$("#uploadForm").validate({
		rules: {
			upload: {required: true}
		}
	});
	//查询
	$("#subA").click(function(){
		searchDate();
	});
	
	$("#subB").click(function(){
		$("#findForm").submit();
	});
	
	

});

//审核
function auditService(slid,ssqy){
	if(!window.confirm("完税认定审核操作，是否确认操作？")) return;
	
	var url = "../xtwh/UPDTFC0021.action";
	var data = {txtSLID : slid,txtSSQY:ssqy};
	$.ajax({
		   type: "GET",
		   url: url,
		   cache: false,
		   data: data,
		   dataType: "json",
		   complete:function() {
				$("#loading").hide();
         },
		   success: function(msg){
		     var data = msg.bgFlag;
		     if(data)
		 		$.notifyBar({cls: "success", html: msg.resMsg});
		     else
		    	$.notifyBar({cls: "warning", html: msg.resMsg });
		    //重新读取数
		     searchDate();
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
	
}

