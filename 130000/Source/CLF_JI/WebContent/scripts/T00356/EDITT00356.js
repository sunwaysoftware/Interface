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
	
	//删除
	$("#btnDel").click(function(){
		$("#editForm").submit();
	});
	
	//szqy更新
	$("#ddlSZQY").change(function(){
		var szqy = $("#ddlSZQY").val();
		var pssdym = $("#ddlPSSD").val();
		if (szqy != '' && pssdym !='') 
			bindInfoValue(szqy,pssdym);
	});
	
	//pssd更新
	$("#ddlPSSD").blur(function(){
		var szqy = $("#ddlSZQY").val();
		var pssdym = $("#ddlPSSD").val();
		if (szqy != '' && pssdym !='') 
			bindInfoValue(szqy,pssdym);
	});
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			ddlPSSD: {required: true},
			ddlSZQY: {required: true},
			txtXZXS: {required: true, number: true}
		}
	});
});

/**
 * 根据所在区域按钮，后台请求数据
 * @param fwcx
 * @param infoid
 * @param rootid
 * @param szqy
 * @return
 */
function bindInfoValue(szqy, pssdym){
	$.ajax({
		   type: "GET",
		   url: "FINDT00356AJAX.action",
		   cache: false,
		   data: {ddlSZQY:szqy ,PSSDYM:pssdym},
		   dataType: "json",
		   success: function(msg){
		     var bean = msg.t00356Bean;
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
		   url: "EDITT00356.action",
		   data: {ddlSZQY:$("#ddlSZQY").val(), ACT:'C', txtXZXS:$("#txtXZXS").val(), txtNOTE:$("#txtNOTE").val(),PSSDYM: $("#ddlPSSD").val()},
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
		   url: "EDITT00356.action",
		   data: {ddlSZQY:$("#ddlSZQY").val(), ACT:'U', txtXZXS:$("#txtXZXS").val(), txtNOTE:$("#txtNOTE").val(),PSSDYM: $("#ddlPSSD").val(), txtUPDATE:$("#txtUPDATE").val() },
		   success: function(msg){
			   $.notifyBar({cls: "success", html: '参数更新成功'});
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}
