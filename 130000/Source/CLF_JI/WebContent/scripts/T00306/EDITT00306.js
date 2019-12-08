$(document).ready(function() {
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			ddlSZQY: {required: true},
			txtLH: {required: true},
			txtZLC: {required: true, number: true},
			txtDYGS: {required: true, number: true},
			txtXQDM: {required: true},
			txtCLH : {maxlength : 50},
			txtNOTE : {required : true}
		}
	});
	//根据隐藏域判断点击情况，如果符合，则请求数据填充页面
/*	$("#txtJZMJMAX").blur(function(){
		var szqy = $("#ddlSZQY").val();
		var fwlx = $("#txtFWLX").val();
		var jzmjmin = $("#txtJZMJMIN").val();
		var jzmjmax = $("#txtJZMJMAX").val();
		var xqnm   =$("#txtXQDM").val();
		
 		if (szqy != '' && fwlx !='' && jzmjmin !='' && jzmjmax !=''&& xqnm !='') {
		bindInfoValue(szqy,fwlx,jzmjmin,jzmjmax,xqnm);
		}
	});*/
	
	
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
/*function bindInfoValue(szqy,fwlx,jzmjmin,jzmjmax,xqnm){
	$.ajax({
		   type: "GET",
		   url: "FINDT00360AJAXA.action",
		   cache: false,
		   data: {ddlSZQY:szqy,
		          txtFWLX:fwlx,
		          txtJZMJMIN:jzmjmin,
		          txtJZMJMAX:jzmjmax,
		          txtXQDM :xqnm
		          },
		   dataType: "json",
		   success: function(msg){
			   var bean = msg.t00360Bean;
			     var flag = msg.isExists;
			     if (flag) {
			    	 $("#btnAdd").show(); 
			    	 $("#btnUpd").hide();
			    	 $("#ACT").val("C");
			    	 $("#txtXZXS").val("");
			    	 $("#txtID").val("");
			    	 $("#txtNOTE").val("");
			    	// $("#txtLSH").val("");
			    	 //$("#txtNSZDXS").val(0);
			    	 $.notifyBar({html: '参数不存在，请输入' });
			     }else{
			    	 $("#btnUpd").show();
			   		 $("#btnAdd").hide(); 
			   		 $("#ACT").val("U");
			   		 $("#txtXZXS").val(bean.xzxs);
			   		 $("#txtID").val(bean.id);
			   		 $("#txtUPDATE").val(formatDateTime(bean.upddate));
			   		 $("#txtNOTE").val(formatString(bean.note));
			   		 $.notifyBar({html: '参数已存在，请更新' });
				 }
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}*/