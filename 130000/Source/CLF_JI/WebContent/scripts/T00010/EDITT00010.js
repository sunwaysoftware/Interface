$(document).ready(function() {
	
	$("#spSSGX").click(function(){
		var infoID = $("#txtSSGXFind").val();
		if ($("#ISADMIN").val()=="true")
		{
			openSSGXDialog(infoID,"#infoTreeDIV");
		}
		else
		{
			openSSGXCONDDialog(infoID,"#infoTreeDIV");
		}
		
	});
	
	$("#dialog").dialog({
		modal: true,
        shadow: true,
        closed: true,
	       buttons:[{
				text:'选择',
				iconCls:'icon-ok',
				handler:function(){
					$("#dialog").dialog("close");
							var selectValue = getSelectedSSGXValue();
							$("#txtSSGXFind").val(selectValue);
							getSSGX(selectValue,'#txtSSGXTIP');
							getUser($("#txtROLEID").val(),selectValue,$("#ACT").val());
						}
	       },{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#dialog").dialog('close');
				}
			}]
		});	
});
//显示用户层
function getUser(roleID,ssgx,ACT){
	$.ajax({
		  type:'GET',
		  cache: false,
		  url:'LoadUsersByRole.action',
		  data :{
				ROLEID: roleID,
				ACT: ACT,
				txtSSGXFind : ssgx
		  },
		  success:function(res){
			 $('#divUser').html(res);
		  },
		  error:function(){
			 $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		  }
	});
}

