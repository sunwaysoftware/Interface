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

	//所在区域
	$("#ddlSZQYFind").change(function(){
		$("#txtXQFind").val('');
		$("#txtXQTIP").val('');
	});

	//小区
//	$("#spXQDM").click(function(){
//		if($("#isExistZT").val=="false")
//		{
//			var szqy = $("#ddlSZQYFind").val();
//			if (szqy == null || szqy == "") {
//				$.notifyBar({html: '请先选择所在区域' });
//				$("#ddlSZQYFind").focus();
//				return;
//			}
//			var infoID = $("#txtXQFind").val();
//			openXQMCDialog(szqy, infoID, '#infoTreeDIV');
//		}
//	
//	});
});
