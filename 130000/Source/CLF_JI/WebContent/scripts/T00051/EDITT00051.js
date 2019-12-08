$(document).ready(function() {
	//添加
	$("#btnAdd").click(function(){
		if ($("#editForm").valid())
			AddData();
	});	
	
	//更新
	$("#btnUpd").click(function(){
		if ($("#editForm").valid())
			UpdData();
	});
	
	$("#ddlSZQY").change(function(){
		getInfoIfExist();
	});
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			ddlSZQY: {required: true},
			txtPSSD: {required: true},
			txtJSBL: {required: true, number: true},
			txtSL: {required: true, number: true}
		}
	});
	
	// 房屋类型
	$("#spFWLX").click(function(){
		$("#hidSelect").val("FWLX");
		var infoID = $("#txtFWLX").val();
		openFWLXDialog(infoID, '#infoTreeDIV');
	});

	// 交易类型
	$("#spJYLX").click(function(){
		$("#hidSelect").val("JYLX");
		var infoID = $("#txtJYLX").val();
		openJYLXDialog(infoID, '#infoTreeDIV');
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
            	if ($("#hidSelect").val() != "QTXZ")
            		$("#dialog").dialog("close");
				var selectValue;
				if ($("#hidSelect").val() == "FWLX") {
					selectValue = getSelectedFWLXValue();
					$("#txtFWLX").val(selectValue);
					getFWLX(selectValue, '#txtFWLXTIP');
				}else if ($("#hidSelect").val() == "JYLX") {
					selectValue = getSelectedJYLXValue();
					$("#txtJYLX").val(selectValue);
					getJYLX(selectValue, '#txtJYLXTIP');
				}
				getInfoIfExist();
			}
	       },{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#dialog").dialog('close');
				}
			}]
		});	
	
});

/**
 * 如果主键条件满足，则发送后台取得数据
 * @return
 */
function getInfoIfExist(){
	var szqy = $("#ddlSZQY").val();
	if (szqy != '') {
		bindInfoValue(szqy);
	}
}

/**
 * 根据下拉列表，后台请求数据
 * @param szqy
 * @return
 */
function bindInfoValue(szqy){
	$.ajax({
		   type: "GET",
		   url: "FINDT00051AJAX.action",
		   cache: false,
		   data: {ddlSZQY: szqy,
					txtFWLX : $("#txtFWLX").val(),
					txtJYLX: $("#txtJYLX").val(),
					txtPSSD:$("#txtPSSD").val()},
		   dataType: "json",
		   success: function(msg){
			   var bean = msg.t00051Bean;
			     var flag = msg.isExists;
			     if (flag) {
			    	 $("#btnAdd").show(); 
			    	 $("#btnUpd").hide();
			    	 $("#txtJSBL").val(0);
			    	 $("#txtSL").val(0);
			    	 $("#txtNOTE").val('');
//			    	 $("#txtFWLX").val('');
//					 $("#txtJYLX").val('');
//			    	 $("#txtFWLXTIP").val('');
//			    	 $("#txtJYLXTIP").val('');
			    	 $.notifyBar({html: '参数不存在，请输入' });
			     }else{
			    	 $("#btnUpd").show();
			   		 $("#btnAdd").hide(); 
			   		 $("#txtJSBL").val(bean.jsbl);
			   		 $("#txtPSSD").val(formatDate(bean.cd00002Pssd));
			    	 $("#txtSL").val(bean.sl);
			    	 $("#txtNOTE").val(formatString(bean.note));
			    	 $("#txtFWLX").val(bean.cd00001Fwlx);
					 $("#txtJYLX").val(bean.cd00001Jylx);
			    	 $("#txtFWLXTIP").val(bean.fwlx);
			    	 $("#txtJYLXTIP").val(bean.jylx);
			    	 $("#txtUPDATE").val(formatDateTime(bean.upddate));
			    	 $.notifyBar({html: '参数已存在，请更新' });
				 }
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}

//后台添加数据
function AddData(){
	$.ajax({
		   type: "GET",
		   cache: false,
		   url: "EDITT00051.action",
		   data: {ddlSZQY:$("#ddlSZQY").val(), 
					txtPSSD:$("#txtPSSD").val(), 
					txtFWLX:$("#txtFWLX").val(),
					txtJYLX:$("#txtJYLX").val(),
					ACT:'C', 
					txtJSBL:$("#txtJSBL").val(), 
					txtSL:$("#txtSL").val(), 
					txtNOTE:$("#txtNOTE").val()},
		   success: function(msg){
			   $.notifyBar({cls: "success", html: '参数创建成功'});
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}

//后台更新数据
function UpdData(){
	$.ajax({
		   type: "GET",
		   cache: false,
		   url: "EDITT00051.action",
		   data: {ddlSZQY:$("#ddlSZQY").val(), 
					ACT:'U',
					txtPSSD:$("#txtPSSD").val(), 
					txtFWLX:$("#txtFWLX").val(),
					txtJYLX:$("#txtJYLX").val(),
					txtJSBL:$("#txtJSBL").val(), 
					txtSL:$("#txtSL").val(), 
					txtNOTE:$("#txtNOTE").val(), 
					txtUPDATE:$("#txtUPDATE").val() },
		   success: function(msg){
			   $.notifyBar({cls: "success", html: '参数更新成功'});
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}
