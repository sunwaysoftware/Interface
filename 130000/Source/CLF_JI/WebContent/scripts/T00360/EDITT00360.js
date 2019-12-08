$(document).ready(function() {
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			ddlSZQY: {required: true},
			txtLC: {required: true, number: true},
			txtZCS: {required: true, number: true},
			txtXZXS: {required: true, number: true},
			txtPSSD: {required: true, number: true}
		}
	});
	
	//添加
	$("#btnAdd").click(function(){
		if($("#editForm").valid())
			$("#editForm").submit();
	});	
	
	//更新
	$("#btnUpd").click(function(){
		if($("#editForm").valid())
			$("#editForm").submit();
	});
	
	//删除
	$("#btnDel").click(function(){
		$("#editForm").submit();
	});	
	
	// 房屋类型
	$("#spFWLX").click(function(){
		var infoID = $("#txtFWLX").val();
		openFWLXDialog(infoID, '#infoTreeDIV');
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
			    	$("#dialog").dialog("close");
			    	var selectValue = getSelectedFWLXValue();
					$("#txtFWLX").val(selectValue);
					getFWLX(selectValue, '#txtFWLXTIP');
				}},	{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#dialog").dialog('close');
					}
				}]
		});	
});