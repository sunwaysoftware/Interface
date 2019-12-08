$(document).ready(function() {
	//添加
	$("#ddlSSGX").change(function(){		
		$.ajax({
			   type: "GET",
			   cache: false,
			   url: "FLASHSESSION.action",
			   data: {ddlSSGX: $("#ddlSSGX").val()},
			   success: function(){
				   window.parent.flashpage();
			   },
			   error: function(){
				   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
			   }
		});			
	});	
	
});

/**
 * 
 * @return
 */
function showSetting(){
	Show("xtwh/VIEWSETTING.action", 300, 450, "VIEWSETTING");
}