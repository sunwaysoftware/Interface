/**
 * 获取列表数据
 * 
 * @param xqdm,noxqdm,parentdm,ACT
 * @author cheng
 */
function getXqmcData(xqdm, noxqdm, parentdm, ACT) {
	var szqy = $('#ddlSZQY').val();
	if (szqy != '') {
		$.ajax( {
			type : 'GET',
			cache : false,
			url : 'TREET00351CSYDIV.action',
			data : {
				SZQY : szqy,
				XQDM : xqdm,
				NOXQDM : noxqdm,
				PARENTDM : parentdm,
				ACT : ACT
			},
			success : function(res) {
				$('#T00352TreeDIV').html(res);
			},
			error : function() {
				alert('操作失败!');
			}
		});
	} else {
		$('#T00352TreeDIV').html("");
	}
}
$(document).ready(function() {
	$("#rdoXQ").change(function() {
		getSelectedXQValue();
	});
});

// 获取列表选中键
function getSelectedXQValue() {
	if ($("input[name='rdoXQ'][type='radio']:checked").length > 0)
		return $("input[name='rdoXQ'][type='radio']:checked").val();
	else
		return '';
}
// 获取列表选中值
function getSelectedXQName() {
	return $("input[name='rdoXQ'][type='radio']:checked").attr("title");
}

/**
 * 小区名称
 * 
 * @param szqy,
 *            xqdm, obj
 * @return
 */
function openXQMCDialog(szqy, xqdm, pssd, obj) {
	getDivXqmcData(szqy, xqdm, pssd, obj);
	$("#dialog").dialog('open');
}

// 嵌入页面的形式打开数据
function getDivXqmcData(szqy, xqdm, pssd, obj) {
	$(obj).html('');
	$.ajax( {
		type : 'GET',
		url : 'TREET00351CSY.action',
		cache : false,
		data : {
			SZQY : szqy,
			XQDM : xqdm,
			PSSD : pssd
		},
		complete : function() {
			$("#loading").hide();
			$($(obj).find(".expanded")).click(function() {
				var aXQID = $(this).attr("expXQID");
				getDivXqmcData(szqy, aXQID, pssd, obj);
			});
			// 给列表中的单选按钮添加单击事件
			// 判断函数是否存在
			if (typeof (getXQRdoValue) == "function") {
	
				$($(obj).find(".radioXQ")).click(function() {
					getXQRdoValue($(this).val(), $(this).attr("expXQNM"));
				});
				var objChk = $(obj).find(".radioXQ:checked");
				if ($(objChk).length == 1) {
					getXQRdoValue($(objChk).val(), $(objChk).attr("expXQNM"));
				}
			};
		},
		success : function(res) {
			$(obj).html(res);
		},
		error : function() {
			alert('操作失败!');
		}
	});
}

// 取得小区名称导航
function getXQ(szqy, xqdm, objID) {
	$.ajax( {
		type : 'GET',
		url : 'GETXQCSYNAV.action',
		data : {
			SZQY : szqy,
			XQDM : xqdm
		},
		complete : function() {
			$("#loading").hide();
		},
		success : function(res) {
			$(objID).val(res);
		},
		error : function() {
			alert('操作失败!');
		}
	});
}
