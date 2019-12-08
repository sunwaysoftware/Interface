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
							var selectValue = getSelectedFWCXValue();
							$("#txtFWCXFind").val(selectValue);
							getFWCX(selectValue,'#txtFWCXTIP');
						}
	       },{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#dialog").dialog('close');
				}
			}]
		});	
	
	$("#txtFWCXFind").blur(function(){
		var infoID = $("#txtFWCXFind").val();
		getFWCX(infoID,'#txtFWCXTIP');
	});
	
	$("#btnFWCX").click(function(){
		var infoID = $("#txtFWCXFind").val();
		openFWCXDialog(infoID,"#infoTreeDIV");
	});
	
});



