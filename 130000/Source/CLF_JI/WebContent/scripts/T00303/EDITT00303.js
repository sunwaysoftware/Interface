$(document).ready(function() {

	//FROM验证信息
	$("#editForm").validate({
		rules: {
			ddlSZQY : {required : true},
			txtZLC: {required: true, number: true, maxlength : 3},
			txtFWTDZL : {required : true},
			txtXQDM : {required: true}
		
		}
	});
	/*// 小区代码
	$("#txtXQTIP").focus(function(){
		var szqy = $("#ddlSZQY").val();
		if (szqy == null || szqy == "") {
			alert('请先选择所在区域！');
		} else {
			$("#hidSelect").val("XQ");
			var xqdm = $("#txtXQDM").val();
			openXQMCDialog(szqy, xqdm, '#infoTreeDIV');
		}
	});
	//小区名称
	$("#txtXQFind").blur(function() {
		var xqdm = $("#txtXQFind").val();
		if (xqdm == null || xqdm == "") {
			$("#txtXQTIP").val("");
		} else {
			var szqy = $("#ddlSZQY").val();
			if (szqy == null || szqy == "") {
				alert('请先选择所在区域！');
				return;
			}
			getXQ(szqy, xqdm, '#txtXQTIP');
		}
	});*/
	// 小区代码
	$("#spXQDM").click(function(){
//		if($("#isExistZT").val()=="true")
//		{
//			return;
//		}
		var szqy = $("#ddlSZQY").val();
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请选择所在区域'});
			$("#ddlSZQY").focus();
		} else {
			$("#hidSelect").val("XQ");
			var xqdm = $("#txtXQDM").val();
			openXQMCDialog(szqy, xqdm, '#infoTreeDIV');
		}
	});
	$("#spXQ").click(function(){
		$("#hidSelect").val("XQMC");
		var szqy = $("#ddlSZQY").val();
		if (szqy == null || szqy == "") {
			alert('请先选择所在区域！');
			return;
		}
		var infoID = $("#txtXQFind").val();
		openXQMCDialog(szqy, infoID, '#infoTreeDIV');
	});

	// 建筑结构
	$("#txtJZJGTIP").focus(function(){
		$("#hidSelect").val("JZJG");
		var infoID = $("#txtJZJG").val();
		openJZJGDialog(infoID, '#infoTreeDIV');		
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
	    	   		var selectValue;
					if ($("#hidSelect").val() == "XQ") {
						var szqy = $("#ddlSZQY").val();
						selectValue = getSelectedXQValue();
						$("#txtXQDM").val(selectValue);
						getXQ(szqy, selectValue, '#txtXQTIP');
					}else if($("#hidSelect").val() == "JZJG"){
						selectValue = getSelectedJZJGValue();
						$("#txtJZJG").val(selectValue);
						getJZJG(selectValue,'#txtJZJGTIP');				
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

	
	//楼房地址自动完成
	$("#txtFWTDZL").autocomplete("FWTDZLFIND.action", {
		delay : 10,
		minChars : 1,
		matchSubset : 1,
		matchContains : 1,
		cacheLength : 10,
		autoFill : false,
		formatItem : function(data, i, total) {
			return data[0];
		},
		formatMatch : function(data, i, total) {
			return data[0];
		},
		formatResult : function(data) {
			return data[0];
		},
		extraParams : {
			'txtZCDZL' : function() {return $("#txtFWTDZL").attr('value');},
			'txtZCDZType' : function() {return 3;}
		}
	});	 
});