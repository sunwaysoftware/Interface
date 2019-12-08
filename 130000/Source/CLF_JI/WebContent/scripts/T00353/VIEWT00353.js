$(document).ready(function() {
	
	
	$("#dialog").dialog({
		modal: true,
        shadow: true,
        closed: true,
	       buttons:[{
				text:'选择',
				iconCls:'icon-ok',
				handler:function(){
	    	   		$("#dialog").dialog("close");
	    	   		var szqy = $("#ddlSZQYFind").val();
					var selectValue = getSelectedXQValue();
					if(null==selectValue) return;
					$("#txtXQFind").val(selectValue);
					getXQ(szqy, selectValue, '#txtXQTIP');
				}
			},{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#dialog").dialog('close');
				}
			}]
		});
	$("#txtCGZKFind").blur(function(){
		var infoID = $("#txtCGZKFind").val();
		getCGZK(infoID,'#txtCGZKTIP');
	});
	
	$("#btnCGZK").click(function(){
		var infoID = $("#txtCGZKFind").val();
		openCGZKDialog(infoID,"#infoTreeDIV");
	});
	
});

function DelData(root,infoid,szqy,fwlx){
	
	$("#loading").show();
	var url = "xtwh/DELSELT00353.action";
			
	$.ajax({
		   type: "POST",
		   url: url,
		   cache: false,
		   data: {
		      ROOT : root,
		    INFOID : infoid,
		   ddlSZQY : szqy,
		   txtFWLX : fwlx
				},
		   dataType: "html",
		   complete:function()
           {
				$("#loading").hide();
				$.notifyBar({cls:"success", html: '已成功删除'});
           },
		   success: function(msg){
        	   searchDate();  
           },
		   error: function(){
			   $("#loading").hide();
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});
}

