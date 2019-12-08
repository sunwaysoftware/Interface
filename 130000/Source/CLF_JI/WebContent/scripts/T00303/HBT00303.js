$(document).ready(function() {

	//FROM验证信息
	$("#editForm").validate({
		rules: {
			rdoUnite: {required: true}
		}
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

	$("#uniteSEL").click(function(){
		var uniteId = $("input[name='rdoUnite'][type='radio']:checked").val();
		if(uniteId == null){
			$.notifyBar({html:'请选择合并基准项'});
			return;
		}
		FindLFXX(uniteId,"#T00303DIV");
	});
});

/**
 * 根据选中项目，后台请求楼房信息数据
 */
function FindLFXX(lfid, objID){
	$.ajax({
		type : "GET",
		url : "FINDLFXX.action",
		cache : false,
		data : {LFID : lfid},
		dataType: "json",
		success: function(res){
			var bean = res.t00303Bean;
			$("#ddlSZQY").val(bean.cd00001Szqy);
			$("#disZCDZL").val(bean.zcdzl);
			$("#txtZCDZL").val(bean.zcdzl);
			$("#txtZCDZBM").val(bean.zcdzbm);
			bindLFXXValue(bean.zcdzl,"", "#T00303DIV");
		},
		error: function(){
			$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		}
	});
};