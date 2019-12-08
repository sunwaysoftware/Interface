$(document).ready(function() {

	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtSWID: {required: true, maxlength : 30},
			txtNSRMC: {required: true, maxlength : 100},
			txtZJLXId: {required: true, maxlength : 15},
			txtZZ: {required: true, maxlength : 200},
			txtLXDH: {maxlength : 13},
			txtYDDH: {maxlength : 11},
			txtNOTE: {maxlength : 200},
			txtBGSJ: {required: true}
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
	    	   $("#dialog").dialog("close");
				var selectValue = getSelectedZJLXValue();
				if ($("#hidSelect").val() == "ZJLX") {
					$("#txtZJLXId").val(selectValue);
					getZJLX(selectValue,'#txtZJLXNm');					
				}else{
					//alert("aaaaaaaaaaaaaaaaaaaaaa");
				}
			}
        },{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				$("#dialog").dialog('close');
			}
		}]
	});		

	//税务登记代码
	$("#txtSWID").blur(function(){
		var userId = $("#txtSWID").val();
		var userNm = $("#txtNSRMC").val();
		if(userId!="" && userNm==""){
			ReadT12006(userId);
		}
	});

//	// 座落地址自動提示
//	$("#txtZZ").autocomplete("ZZFIND.action", {
//		delay : 10,
//		minChars : 1,
//		matchSubset : 1,
//		matchContains : 1,
//		cacheLength : 10,
//		autoFill : false,
//		formatItem : function(data, i, total) {
//			return data[0];
//		},
//		formatMatch : function(data, i, total) {
//			return data[0];
//		},
//		formatResult : function(data) {
//			return data[0];
//		},
//		extraParams : {
//			'ZZ' : function() {
//				return $("#txtZZ").attr('value');
//			}
//		}
//	});
});
