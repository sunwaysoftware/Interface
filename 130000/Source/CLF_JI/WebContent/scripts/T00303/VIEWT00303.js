$(document).ready(function() {
	$("#ddlSZQYFind").change(function(){
		$("#txtXqnmFind").val("");
		$("#txtXQFind").val("");
		getDivXqmcData($('#ddlSZQYFind').val(), '', '#T00352Tree');
	});
	
	// 座落地址自動提示
	$("#txtFWTDZLFind").autocomplete("FWTDZLFIND.action", {
		delay : 1000,
		minChars : 1,
		matchSubset : 1,
		matchContains : 1,
		cacheLength : 10,
		autoFill : true,
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

	// checkbox
	$(".rootCheck").click(function() {
		$(".childCheck").each(function() {
			$(this)[0].checked = $(".rootCheck")[0].checked;
		});
	});
	// 楼房信息合并
	$("#lfxxhb").click(function() {
		var b = false;
		$(".childCheck").each(function() {
			if ($(this)[0].checked) {
				b = true;
			}
		});
		if (!b) {
			alert('请选择要合并的数据！');
			return;
		}
		$("#findForm").attr("action", "HBINITT00303.action");
		$("#findForm").submit();
	});
});

//根据选项，请求action作编辑用
function getXQRdoValue(infoid,infonm){
	//判断点击的单选按钮类型，根据单选按钮类型，为隐藏域赋值
	$("#txtXqnmFind").val(infonm);
	$("#txtXQFind").val(infoid);
	searchDate();
};