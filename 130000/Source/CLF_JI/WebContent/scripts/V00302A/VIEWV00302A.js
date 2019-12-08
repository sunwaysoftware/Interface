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

	$("#ddlSZQYFind").change(function(){
		$("#txtXQFind").val('');
		$("#txtXQTIP").val('');
	});
	
	$("#spXQDM").click(function(){
		var szqy = $("#ddlSZQYFind").val();
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请先选择所在区域' });
			$("#ddlSZQYFind").focus();
			return;
		}
		var infoID = $("#txtXQFind").val();
		openXQMCDialog(szqy, infoID, '#infoTreeDIV');
	});

	// 座落地址自動提示
	$("#txtFWTDZLFind").autocomplete("FWTDZLFIND.action", {
		delay : 1000,
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
			'ddlSZQY' : function() {
				return $("#ddlSZQYFind").attr('value');
			},
			'XQDM' : function() {
				return $("#txtXQFind").attr('value');
			},
			'FWTDZL' : function() {
				return $("#txtFWTDZLFind").attr('value');
			}
		}
	});
});

