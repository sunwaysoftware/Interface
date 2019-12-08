$(document).ready(function() {
	
	//使用间接法传值
	
	
	$("#rdoJJF1").click(function(){
		var txtXZXS=1;
		if($("#rdoJJF1:checked").val()==1){
			txtXZXS = 1;	
			$("#txtXZXS").val(txtXZXS);
		}else{
			istrue = 0;	
			$("#txtXZXS").val(txtXZXS);
		} 
	});
	$("#rdoJJF0").click(function(){
		var txtXZXS=1;
		if($("#rdoJJF1:checked").val()==1){
			txtXZXS = 1;	
			$("#txtXZXS").val(txtXZXS);
		}else{
			txtXZXS = 0;	
			$("#txtXZXS").val(txtXZXS);
		} 
	});
	
	
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			ddlSZQY: {required: true},
	        txtXQDM: {required: true}
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
		var xqdm = $("#txtXQDM").val();
		if (xqdm != '') {
			bindInfoValue(xqdm);
		}
	});
	//小区代码
	$("#spXQDM").click(function(){
		
		var szqy = $("#ddlSZQY").val();
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请先选择所在区域' });
			$("#ddlSZQY").focus();
		} else {
			$("#hidSelect").val("XQ");
			var xqdm = $("#txtXQDM").val();
			openXQMCDialog(szqy, xqdm, '#infoTreeDIV');
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
			     if ($("#hidSelect").val() == "XQ"){
	    			   var szqy = $("#ddlSZQYFind").val();
						selectValue = getSelectedXQValue();
						if(null==selectValue) return;
						$("#txtXQDM").val(selectValue);
						getXQ(szqy, selectValue, '#txtXQTIP');
						bindInfoValue($("#txtXQDM").val());
					
				}else{
					$.notifyBar({html: '已选择' });
				}
				}
	       		},
				{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#dialog").dialog('close');
					}
			
				}]
	       
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
function bindInfoValue(xqdm){

	$.ajax({
		   type: "GET",
		   url: "FINDT00365AJAX.action",
		   cache: false,
		   data: {txtXQDM:xqdm},
		   dataType: "json",
		   success: function(msg){
			   var bean = msg.t00365Bean;
			     var flag = msg.isExists;
			     if (flag) {
			    	 $("#btnAdd").show(); 
			    	 $("#btnUpd").hide();
			    	 $("#ACT").val("C");
			    	 $("#txtNOTE").val('');
			    	 $("#rdoJJF1").attr("checked", "checked");
		   			 $("#rdoJJF0").remove("checked");
			    	 $.notifyBar({html: '参数不存在，请输入' });
			     }else{
			    	 $("#btnUpd").show();
			   		 $("#btnAdd").hide(); 
			   		 $("#ACT").val("U");
			   		 $("#txtXZXS").val(bean.xzxs);
			   		 if(bean.xzxs == 1){
			   			 $("#rdoJJF1").attr("checked", "checked");
			   			 $("#rdoJJF0").remove("checked");
			   		 }else if(bean.xzxs == 0){
			   			 $("#rdoJJF0").attr("checked", "checked");
			   			 $("#rdoJJF1").remove("checked");
			   		 }
			   		 $("#txtUPDATE").val(formatDateTime(bean.upddate));
			    	 $("#txtNOTE").val(formatString(bean.note));
			   		 $.notifyBar({html: '参数已存在，请更新' });
				 }
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}