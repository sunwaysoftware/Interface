$(document).ready(function() {
	// 评估
	$('#REPG').click(function() {
		var selvalue="";
		$("input[id='chkSel'][type=checkbox]:checked").each(function() { //由于复选框一般选中的是多个,所以可以循环输出
			selvalue = selvalue + $(this).val() + ",";
	    });
		if (selvalue=="")		
		{
			$.messager.alert('警告信息','请选择要操作的数据！','warning');
			return;
		}
		
		document.getElementById('hidFlag').value = '1';
		$("input[id='chkSel'][type=hidden]").val(selvalue);	
		AppSubmit();
	});
	// 评估所有的
	$('#REPGALL').click(function() {
		$.messager.confirm('系统提示', '您确定要全部重新评估吗?', function(r) {
			if (r) {
				document.getElementById('hidFlag').value = '2';
				AppSubmit();
			}
		});

	});
});

function sendXML(fcid) {
	$("#loading").show();
	$.ajax({
		type : "POST",
		cache : false,
		url : "../sjcj/SENDXMLI.action",
		dataType : "json",
		data : {
			FCID : fcid
		},
		complete : function() {
			$("#loading").hide();
		},
		success : function(msg) {
			if (msg.resSign == '1') {
				$.messager.alert('与金三征管系统对接失败', "具体原因：<br/>"+msg.SLMsg, 'error');
			} else {
				$.notifyBar({
					cls : "success",
					html : "评估数据已经成功传入金三征管系统。"
				});
			}
		},
		error : function() {
			$.notifyBar({
				cls : "error",
				html : '请求已发送，系统无响应'
			});
		}
	});
}
