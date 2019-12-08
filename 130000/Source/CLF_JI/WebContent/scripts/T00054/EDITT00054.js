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
		var fwytTip = $("#TIPTDYT").text();
		var tdyt = $("#TDYT").val();
		var szqy = $("#ddlSZQY").val();
		var rjl = $("#txtRJL").val();
		//根据隐藏域判断点击情况，如果符合，则请求数据填充页面
		if (fwytTip != '' && szqy != '' && rjl !='') {
			bindInfoValue(tdyt,szqy,rjl);
		}
	});
	
	$("#txtRJL").blur(function(){
		var fwytTip = $("#TIPTDYT").text();
		var tdyt = $("#TDYT").val();
		var szqy = $("#ddlSZQY").val();
		var rjl = $("#txtRJL").val();
		//根据隐藏域判断点击情况，如果符合，则请求数据填充页面
		if (fwytTip != '' && szqy != '' && rjl !='') {
			bindInfoValue(tdyt,szqy,rjl);
		}
	});
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtBZBM: {required: true, maxlength : 2},
			txtBZMC: {required: true, maxlength: 50},
			txtJZQSMIN: {required: true, number: true},
			txtJZQSMAX: {required: true, number: true},
			txtLSXSMIN: {required: true, number: true},
			txtLSXSMAX: {required: true, number: true},
			txtJGXGCMIN: {required: true, number: true},
			txtJGXGCMAX: {required: true, number: true}
		}
	});
});

//根据选项，请求action作编辑用
function getRdoValue(infoid,infotype,infonm){
	//判断点击的单选按钮类型，根据单选按钮类型，为隐藏域赋值
	$("#TIPTDYT").text(infonm);
	$("#TDYT").val(infoid);
		
	var fwytTip = $("#TIPTDYT").text();
	var tdyt = $("#TDYT").val();
	var szqy = $("#ddlSZQY").val();
	var rjl = $("#txtRJL").val();
	//根据隐藏域判断点击情况，如果符合，则请求数据填充页面
	if (fwytTip != '' && szqy != '' && rjl !='') {
		bindInfoValue(tdyt,szqy,rjl);
	}
};

/**
 * 根据单选按钮，后台请求数据
 * @param fwyt
 * @param infoid
 * @param rootid
 * @param szqy
 * @return
 */
function bindInfoValue(tdyt,szqy,rjl){
	$.ajax({
		   type: "GET",
		   url: "FINDT10054AJAX.action",
		   cache: false,
		   data: {TDYT: tdyt,ddlSZQY: szqy, txtRJL: rjl },
		   dataType: "json",
		   success: function(msg){
			   var bean = msg.t10054Bean;
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
		   url: "EDITT10054.action",
		   data: {TDYT: $("#TDYT").val(), ddlSZQY: $("#ddlSZQY").val(), ACT: 'C', txtRJL: $("#txtRJL").val(), txtXZXS: $("#txtXZXS").val(), txtNOTE: $("#txtNOTE").val()},
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
		   url: "EDITT10054.action",
		   data: {TDYT: $("#TDYT").val(), ddlSZQY: $("#ddlSZQY").val(), ACT: 'U', txtRJL: $("#txtRJL").val(), txtXZXS: $("#txtXZXS").val(), txtNOTE: $("#txtNOTE").val(), txtUPDATE: $("#txtUPDATE").val()},
		   success: function(msg){
			   $.notifyBar({cls: "success", html: '参数更新成功'});
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}
