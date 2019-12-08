$(document).ready(function() {
	
	if($("#txtFWLX").val() != null){
		getCGZKDiv($("#CGZK").val(),'#INFOCGZKDIV',$("#txtFWLX").val());
	}
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

	/*$("#ddlSZQY").change(function(){
		getCGZKDiv('','#INFOCGZKDIV');
		
	});*/
	$("#ddlSZQY").change(function(){
		var fwlx = $("#txtFWLX").val();
		if (fwlx!="")
			getCGZKDiv('','#INFOCGZKDIV',fwlx);
	});
//	//估价时点失去焦点
//	$("#txtPSSD").blur(function(){
//		var cgzkTip = $("#TIPCGZK").text();
//		var cgzk = $("#CGZK").val();
//		var szqy = $("#ddlSZQY").val();
//		var pssd = $("#txtPSSD").val();
//		//根据隐藏域判断点击情况，如果符合，则请求数据填充页面
//		if (cgzkTip != '' && szqy!= '' && pssd!='') {
//			bindInfoValue(pssd,  cgzk, szqy);
//		}
//	});
	// 房屋类型
	$("#spFWLX").click(function(){
		$("#hidSelect").val("FWLX");
		var infoID = $("#txtFWLX").val();
		openFWLXDialog(infoID, '#infoTreeDIV');
	});
		
	//输入房屋类型代码获得类型
	$("#txtFWLXTIP").blur(function(){
		var fwlxId = $("#txtFWLXTIP").val();
		var flag = isNaN(fwlxId);
		if(fwlxId != ''){
			if (!flag)
			getFWLX(fwlxId, '#txtFWLXTIP');
			
		}
		else
		{
			$("#txtFWLX").val("");
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
	    	   		if ($("#hidSelect").val() != "QTXZ")
	            		$("#dialog").dialog("close");
					var selectValue;
					if ($("#hidSelect").val() == "FWLX") {
						selectValue = getSelectedFWLXValue();
						$("#txtFWLX").val(selectValue);
						getFWLX(selectValue, '#txtFWLXTIP');
						getCGZKDiv('','#INFOCGZKDIV',selectValue);
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
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			CGZK: {required: true},
			ddlSZQY: {required: true},
			txtFWLX: {required: true},
			txtXZXS: {required: true, number: true},
			txtPSSD: {required: true, number: true}
		}
	});
});

//根据选项，请求action作编辑用
function getRdoValue(infoid,infotype,infonm){
	//判断点击的单选按钮类型，根据单选按钮类型，为隐藏域赋值
	//$("#TIPCGZK").text(infonm);
	$("#CGZK").val(infoid);
//	alert("infoNM: "+infonm+" , cgzkID: "+infoid);	
	var cgzkTip = infonm;//$("#TIPCGZK").text();
	var cgzk = $("#CGZK").val();
	var szqy = $("#ddlSZQY").val();
	var pssd = $("#txtPSSD").val();
	var fwlx = $("#txtFWLX").val();
	//根据隐藏域判断点击情况，如果符合，则请求数据填充页面
	if (cgzkTip != '' && szqy!= '' && pssd!=''&& fwlx!='') {
		bindInfoValue(pssd, cgzk, szqy, fwlx);
	}
}

/**
 * 根据单选按钮，后台请求数据
 * @param cgzk
 * @param infoid
 * @param rootid
 * @param szqy
 * @return
 */
function bindInfoValue(pssd, cgzk, szqy,fwlx){
//	alert("method: bindinfoValue \n parem{ pssd: "+pssd+", cgzk: "+cgzk+"szqy: "+szqy+"}");
	$.ajax({
		   type: "GET",
		   url: "FINDT00353AJAX.action",
		   cache: false,
		   data: {INFOID: cgzk, ddlSZQY: szqy, PSSD: pssd,FWLX:fwlx},
		   dataType: "json",
		   success: function(msg){
				var bean = msg.t00353Bean;
			     var flag = msg.isExists;
			     if (flag) {
			    	 $("#btnAdd").show(); 
			    	 $("#btnUpd").hide();
			    	 $("#txtXZXS").val(0);
			    	 $("#txtNOTE").val('');
			    	 $.notifyBar({html: '参数不存在，请输入' });
			     }else{
			    	 $("#btnUpd").show();
			   		 $("#btnAdd").hide(); 
			   		 $("#txtXZXS").val(bean.xzxs);
			    	 $("#txtNOTE").val(formatString(bean.note));
			    	 $("#txtUPDATE").val(formatDateTime(bean.upddate));
			   		 $.notifyBar({html: '参数已存在，请更新'});
				 }
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}
//后台添加数据
function AddData(){
	var czlx = 0;
	if($("#rdoCZLX1:checked").val()==1)
		czlx = 1;
	$.ajax({
		   type: "GET",
		   cache: false,
		   url: "EDITT00353.action",
		   data: {txtPSSD:$("#txtPSSD").val(), 
					ROOT:$("#txtROOT").val(),
					INFOID:$("#CGZK").val(), 
					ddlSZQY:$("#ddlSZQY").val(), 
					txtFWLX:$("#txtFWLX").val(),
					ACT:'C', 
					txtXZXS:$("#txtXZXS").val(), 
					txtCZLX:czlx, 
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
	var czlx = 0;
	if($("#rdoCZLX1:checked").val()==1)
		czlx = 1;	
	$.ajax({
		   type: "GET",
		   cache: false,
		   url: "EDITT00353.action",
		   data: {txtPSSD:$("#txtPSSD").val(),
					ROOT:$("#txtROOT").val(),
					INFOID:$("#CGZK").val(), 
					ddlSZQY:$("#ddlSZQY").val(), 
					txtFWLX:$("#txtFWLX").val(),
					ACT:'U', 
					txtXZXS: $("#txtXZXS").val(), 
					txtNOTE: $("#txtNOTE").val(), 
					txtCZLX: czlx, 
					txtUPDATE: $("#txtUPDATE").val() },
		   success: function(msg){
						$.notifyBar({cls: "success", html: '参数更新成功'});
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}

