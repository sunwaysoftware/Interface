$(document).ready(function() {
	
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtYXWS: {required: true, maxlength : 2, number: true},
			txtZJLXId: {required: true}
		}
	});
	
	//证件类型
	$("#spZJLX").click(function(){
		var infoID = $("#txtZJLXId").val();
		$("#hidSelect").val("ZJLX");
		openZJLXDialog(infoID, '#infoTreeDIV');
	});
	
	//弹出对话框
	$("#dialog").dialog({
		modal: true,
        shadow: true,
        closed: true,
	       buttons:[{
				text:'选择',
				iconCls:'icon-ok',
				handler:function(){ 
				var selectValue = getSelectedZJLXValue();
				$("#txtZJLXId").val(selectValue);
				getZJLX(selectValue,'#txtZJLXNm');
				$("#dialog").dialog("close");
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
