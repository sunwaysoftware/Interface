$(document).ready(function() {
	//
	
	$("#findForm").validate({
		rules: {
			txtJZMJMINFind: {number: true, maxlength : 15},
			txtJZMJMAXFind: {number: true, maxlength : 15},
			txtJYJGMINFind: {number: true, maxlength : 15},
			txtJYJGMAXFind: {number: true, maxlength : 15},
			txtJYSJMINFind: {dateISO: true},
			txtJYSJMAXFind: {dateISO: true}
		}
	});	
	
	// 房屋类型
	$("#spFWLX").click(function(){
		$("#hidSelect").val("FWLX");
		var infoID = $("#txtFWLXFind").val();
		openFWLXDialog(infoID, '#infoTreeDIV');
	});

	// 交易类型
	$("#spJYLX").click(function(){
		$("#hidSelect").val("JYLX");
		var infoID = $("#txtJYLXFind").val();
		openJYLXDialog(infoID, '#infoTreeDIV');
	});

	// 建筑结构
	$("#spJZJG").click(function(){
		$("#hidSelect").val("JZJG");
		var infoID = $("#txtJZJGFind").val();
		openJZJGDialog(infoID, '#infoTreeDIV');
	});
	
	// 税收管辖
	$("#spSSGX").click(function(){
		$("#hidSelect").val("SSGX");
		var infoID = $("#txtSSGX").val();
		openSSGXCONDDialog(infoID, '#infoTreeDIV');
	});
	
	//弹出对话框
	$("#dialog").dialog({
		modal: true,
        shadow: true,
        closed: true,
	       buttons:[{
				text:'选择',
				iconCls:'icon-ok',
				handler:function() {
					$("#dialog").dialog("close");
							var selectValue;
							if ($("#hidSelect").val() == "XQ") {
								var szqy = $("#ddlSZQYFind").val();
								var selectValue = getSelectedXQValue();
								$("#txtXQFind").val(selectValue);
								getXQ(szqy, selectValue, '#txtXQTIP');
							} else if ($("#hidSelect").val() == "JZJG") {
								selectValue = getSelectedJZJGValue();
								$("#txtJZJGFind").val(selectValue);
								getJZJG(selectValue,'#txtJZJGNm');
							} else if ($("#hidSelect").val() == "FWLX") {
								selectValue = getSelectedFWLXValue();
								$("#txtFWLXFind").val(selectValue);
								getFWLX(selectValue, '#txtFWLXNm');
							} else if ($("#hidSelect").val() == "JYLX") {
								selectValue = getSelectedJYLXValue();
								$("#txtJYLXFind").val(selectValue);
								getJYLX(selectValue,'#txtJYLXNm');
							} else if ($("#hidSelect").val() == "SSGX") {
								selectValue = getSelectedSSGXValue();
								$("#txtSSGX").val(selectValue);
								getSSGX(selectValue,'#txtSSGXTIP');
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

	$("#ddlSZQYFind").change(function(){
		$("#txtXQFind").val('');
		$("#txtXQTIP").val('');
	});
	
	/*$("#spXQDM").click(function(){
		var szqy = $("#ddlSZQYFind").val();
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请先选择所在区域' });
			$("#ddlSZQYFind").focus();
			return;
		}
		$("#hidSelect").val("XQ");
		var infoID = $("#txtXQFind").val();
		openXQMCDialog(szqy, infoID, '#infoTreeDIV');
	});
	*/
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
	
//	//信息导出
//	$("#btnExportV003025").click(function(){
//		window.location.href="../sjcx/EXPV003025.action?txtFCIDFind"+$("#txtFCIDFind").val()+"txtSWIDFind"+$("#txtSWIDFind").val()+"txtNSRMCFind"+$("#txtNSRMCFind").val()+"txtZCDZLFind"+$("#txtZCDZLFind").val()+"ddlSZQYFind"+$("#ddlSZQYFind").val()+"ddlSCZTFind"+$("#ddlSCZTFind").val()+"txtXQTIP"+$("#txtXQTIP").val()+"txtFWLXNm"+$("#txtFWLXNm").val()+"txtJZJGNm"+$("#txtJZJGNm").val()+"txtJYLXNm"+$("#txtJYLXNm").val()+"txtJZMJMINFind"+$("#txtJZMJMINFind").val()+"txtJZMJMAXFind"+$("#txtJZMJMAXFind").val()+"txtJYJGMINFind"+$("#txtJYJGMINFind").val()+"txtJYJGMAXFind"+$("#txtJYJGMAXFind").val()+"txtJYSJMINFind"+$("#txtJYSJMINFind").val()+"txtJYSJMAXFind"+$("#txtJYSJMAXFind").val()+"txtDJRQFind"+$("#txtDJRQFind").val()+"txtSZLCFind"+$("#txtSZLCFind").val()+"txtLHFind"+$("#txtLHFind").val()+"txtFCZHFind"+$("#txtFCZHFind").val()+"txtZCDZBMFind"+$("#txtZCDZBMFind").val()+"ddlSCZTFind"+$("ddlSCZTFind").val()+"&pageIndex=1";
//	});
});

