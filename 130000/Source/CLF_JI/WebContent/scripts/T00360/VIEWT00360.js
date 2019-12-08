$(document).ready(function() {

	$("#btnUpd").click(function(){
		if($("#uploadForm").valid()){
			$("#loading").show();
			$("#uploadForm").submit();
		}
	});
	
	$("#selDel").click(function() {
		DelSelData();
	});

	$('.rootCheck').click(function() {
		$(".childCheck").each(function() {
			$(this)[0].checked = $('.rootCheck')[0].checked;
		});
	});

	// 查询
	$("#subA").click(function() {
		searchDate();
	});

	$("#subB").click(function() {
		$("#findForm").submit();
	});

	// 房屋类型
	$("#spFWLX").click(function() {
		$("#hidSelect").val("FWLX");
		var infoID = $("#txtFWLXFind").val();
		openFWLXDialog(infoID, '#infoTreeDIV');
	});

	// 弹出对话框
	$("#dialog").dialog({
		modal : true,
		shadow : true,
		closed : true,
		buttons : [ {
			text : '选择',
			iconCls : 'icon-ok',
			handler : function() {
				$("#dialog").dialog("close");
				var selectValue = getSelectedFWLXValue();
				$("#txtFWLXFind").val(selectValue);
				getFWLX(selectValue, '#txtFWLXNm');
			}
		}, {
			text : '关闭',
			iconCls : 'icon-cancel',
			handler : function() {
				$("#dialog").dialog('close');
			}
		} ]
	});

	// 房屋类型退格清除内容
	$("#txtFWLXNm").blur(function() {
		var id = $("#txtFWLXNm").val();
		var flag = isNaN(id);

		if (id == '' && !flag) {
			$("#txtFWLXNm").val("");
			$("#txtFWLXFind").val("");
		}
	});

});

function DelSelData() {
	var selvalue = "";
	$("input[id='chkSel'][type=checkbox]:checked").each(function() { // 由于复选框一般选中的是多个,所以可以循环输出
		selvalue = selvalue + $(this).val() + ",";
	});
	if (selvalue == "") {
		$.notifyBar({
			cls : "error",
			html : '请选择要删除的数据！'
		});
		return;
	}
	DelData(selvalue);
}

function DelData(value) {

	$("#delSel").click(function() {
		DelSelData();
	});

	$("#loading").show();
	var url = "xtwh/DELSELT00360.action";
	var data = {
		chkDel : value
	};

	$.ajax({
		type : "POST",
		url : url,
		cache : false,
		data : data,
		dataType : "json",
		complete : function() {
			$("#loading").hide();

		},
		success : function(msg) {
			$.notifyBar({
				cls : "warning",
				html : msg.msgDel
			});
			searchDate();
			var selvalue = "";
			// 由于复选框一般选中的是多个,所以可以循环输出
			$("input[id='chkSelAll'][type=checkbox]:checked").each(function() { 
				selvalue = selvalue + $(this).val() + ",";
			});
			if (selvalue != "") {
				$("#chkSelAll").attr("checked", false);
			}
		},
		error : function() {
			$("#loading").hide();
			$.notifyBar({
				cls : "error",
				html : '请求已发送，服务器无应答'
			});
		}
	});
}
