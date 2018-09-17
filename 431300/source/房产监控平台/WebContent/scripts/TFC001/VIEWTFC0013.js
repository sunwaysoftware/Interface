$(document).ready(function() {
	
	
	//查询
	$("#subA").click(function(){
		searchDate();
	});
	
	$("#subB").click(function(){
		$("#findForm").submit();
	});
	
	//受理对话框
	if ($('#w2').length>0)
	{
	  $('#w2').dialog({
		title: "错误数据处理",	
        closed: true,
        iconCls:"icon-search",
	       buttons:[{
				text:'处理',
				iconCls:'icon-ok',
				handler:function(){
					var url = "../xtwh/UPDTFC0013.action";
					var data = {txtSLID : $("#SLID").val(),txtSSQY:$("#SSQY").val(),txtREMARKS:$("#txtREMARKS").val()};
					$.ajax({
						   type: "POST",
						   url: url,
						   cache: false,
						   data: data,
						   dataType: "json",
						   complete:function() {							   
							   $("#w2").dialog('close');
				         },
						   success: function(msg){
						     var data = msg.bgFlag;
						     if(data)
						 		$.notifyBar({cls: "success", html: '数据修改操作成功执行完毕!'});
						     else
						    	$.notifyBar({cls: "warning", html: '数据修改操作失败，请重试' });
						    //重新读取数
						     searchDate();
						   },
						   error: function(){
							   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
						   }
					});	
	    	   		
				}
			},
			{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#w2").dialog('close');
				}
			}]
		});
	};

});
//修改
function procesErrorData(slid,ssqy){
	$("#SLID").val(slid);
	$("#SSQY").val(ssqy);
	$("#txtREMARKS").val("");
	$('#w2').window('open');	
	
}

