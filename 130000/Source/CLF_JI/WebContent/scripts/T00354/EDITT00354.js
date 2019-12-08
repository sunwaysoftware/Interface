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
		var fwcxTip = $("#TIPFWCX").text();
		var fwcx = $("#FWCX").val();
		var szqy = $("#ddlSZQY").val();
		var pssd = $("#txtPSSD").val();
		
		//根据隐藏域判断点击情况，如果符合，则请求数据填充页面
		if (fwcxTip != '' && szqy != '' && pssd!='') {
			bindInfoValue(pssd,fwcx,szqy);
		}
	});
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			FWCX: {required: true},
			ddlSZQY: {required: true},
			txtXZXS: {required: true, number: true},
			txtPSSD: {required: true, number: true}
		}
	});
});

//根据选项，请求action作编辑用
function getRdoValue(infoid,infotype,infonm){
	//判断点击的单选按钮类型，根据单选按钮类型，为隐藏域赋值
	$("#TIPFWCX").text(infonm);
	$("#FWCX").val(infoid);
		
	var fwcxTip = $("#TIPFWCX").text();
	var fwcx = $("#FWCX").val();
	var szqy = $("#ddlSZQY").val();
	var pssd = $("#txtPSSD").val();
	
	//根据隐藏域判断点击情况，如果符合，则请求数据填充页面
	if (fwcxTip != '' && szqy != '' && pssd!='') {
		bindInfoValue(pssd,fwcx,szqy);
	}
};

/**
 * 根据单选按钮，后台请求数据
 * @param fwcx
 * @param infoid
 * @param rootid
 * @param szqy
 * @return
 */
function bindInfoValue(pssd,fwcx,szqy){
	$.ajax({
		   type: "GET",
		   url: "FINDT00354AJAX.action",
		   cache: false,
		   data: {FWCX: fwcx, ddlSZQY: szqy, PSSD: pssd},
		   dataType: "json",
		   success: function(msg){
			var bean = msg.t00354Bean;
		     var flag = msg.isExists;
		     if (flag) {
		    	 $("#btnAdd").show(); 
		    	 $("#btnUpd").hide();
		    	 $("#txtXZXS").val(0);
		    	 $("#txtNOTE").val('');
		    	 $("#showStatus").html("请输入！");
		     }else{
		    	 $("#btnUpd").show();
		   		 $("#btnAdd").hide(); 
		   		 $("#txtXZXS").val(bean.xzxs);
		    	 $("#txtNOTE").val(formatString(bean.note));
		    	 $("#txtUPDATE").val(formatDateTime(bean.upddate));
		   		 $("#showStatus").html("请更新！");	
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
		   url: "EDITT00354.action",
		   data: {txtPSSD:$("#txtPSSD").val(), FWCX:$("#FWCX").val(), ddlSZQY:$("#ddlSZQY").val(), ACT:'C', txtXZXS:$("#txtXZXS").val(), txtNOTE:$("#txtNOTE").val()},
		   success: function(msg){
			$("#showStatus").html("插入成功！");
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
		   url: "EDITT00354.action",
		   data: {txtPSSD:$("#txtPSSD").val(), FWCX:$("#FWCX").val(), ddlSZQY:$("#ddlSZQY").val(), ACT:'U', txtXZXS:$("#txtXZXS").val(), txtNOTE:$("#txtNOTE").val(), txtUPDATE:$("#txtUPDATE").val() },
		   success: function(msg){
			$("#showStatus").html("更新成功！");
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}
