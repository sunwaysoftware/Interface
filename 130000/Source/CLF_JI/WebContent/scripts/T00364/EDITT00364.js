$(document).ready(function() {
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			ddlSZQY: {required: true},
			txtXZXS: {required: true, number: true},
			txtPGXZXS: {required: true, number: true}
		}
	});
	
	//添加
	$("#btnAdd").click(function(){
		if($("#editForm").valid())
			$("#editForm").submit();
	});	
	
	//更新
	$("#btnUpd").click(function(){
		if($("#editForm").valid())
			$("#editForm").submit();
	});
	
	//删除
	$("#btnDel").click(function(){
		$("#editForm").submit();
	});	
	
	//根据隐藏域判断点击情况，如果符合，则请求数据填充页面
	$("#ddlSZQY").change(function(){
		var szqy = $("#ddlSZQY").val();
		if (szqy != '') {
			bindInfoValue(szqy);
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
function bindInfoValue(szqy){
	$.ajax({
		   type: "GET",
		   url: "FINDT00364AJAX.action",
		   cache: false,
		   data: {ddlSZQY:szqy},
		   dataType: "json",
		   success: function(msg){
			   var bean = msg.t00364Bean;
			     var flag = msg.isExists;
			     if (flag) {
			    	 $("#btnAdd").show(); 
			    	 $("#btnUpd").hide();
			    	 $("#ACT").val("C");
			    	 $("#txtXZXS").val(0);
			    	 $("#txtPGXZXS").val(0);
			    	 $("#txtNOTE").val('');
			    	 $.notifyBar({html: '参数不存在，请输入' });
			     }else{
			    	 $("#btnUpd").show();
			   		 $("#btnAdd").hide(); 
			   		 $("#ACT").val("U");
			   		 //alert(bean.upddate);
			   		 $("#txtXZXS").val(bean.xzxs);
			   		 $("#txtPGXZXS").val(bean.pgxzxs);
			   		 $("#txtUPDATE").val(formatDateTime(bean.upddate));
			   		 //alert($("#txtUPDATE").val());
			    	 $("#txtNOTE").val(formatString(bean.note));
			   		 $.notifyBar({html: '参数已存在，请更新' });
				 }
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}