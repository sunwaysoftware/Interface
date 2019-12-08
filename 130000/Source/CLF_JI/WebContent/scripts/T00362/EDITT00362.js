$(document).ready(function() {
	$("#txtJZJGT").change(function(){
		findByJzjg();
	});
	//添加
	$("#btnAdd").click(function(){
		$("#editForm").submit();
	});	
	
	//更新
	$("#btnUpd").click(function(){
		$("#editForm").submit();
	});
	
	//删除
	$("#btnDel").click(function(){
		$("#editForm").submit();
	});
	
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			ddlSZQY: {required: true},
			//txtPSSD: {required: true, number: true},
			txtJZJGT: {required: true},
			txtFWLX: {required: true},
			txtXZXS: {required: true, number: true},
			rdoCZLX: {required: true}
		}
	});

     
//	// 建筑结构
//	$("#spJZJG").click(function(){
//		$("#hidSelect").val("JZJG");
//		var infoID = $("#txtJZJG").val();
//		openJZJGDialog(infoID, '#infoTreeDIV');
//	});
	// 建筑结构
	$("#spJZJG").click(function(){
		$("#hidSelect").val("JZJGT");
		var infoID = $("#txtJZJGT").val();
		openJZJGDialog(infoID, '#infoTreeDIV');
	});

	
	// 房屋类型
	$("#spFWLX").click(function(){
		$("#hidSelect").val("FWLX");
		var infoID = $("#txtFWLX").val();
		openFWLXDialog(infoID, '#infoTreeDIV');
	});
	
//	//输入房屋类型代码获得类型
//	$("#txtFWLXTIP").blur(function(){
//		var fwlxId = $("#txtFWLXTIP").val();
//		var flag = isNaN(fwlxId);
//		if(fwlxId != '' && !flag){
//			getFWLX(fwlxId, '#txtFWLXTIP');
//			
//		}
//	});
	
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
					if($("#hidSelect").val() == "JZJGT") {
						selectValue = getSelectedJZJGValue();
						$("#txtJZJGT").val(selectValue);
						getJZJG(selectValue,'#txtJZJGTTIP');
						findByJzjg();
					}else if($("#hidSelect").val() == "FWLX"){
						selectValue = getSelectedFWLXValue();
						$("#txtFWLX").val(selectValue);
						getFWLX(selectValue, '#txtFWLXTIP');
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
	function bindInfoValue(szqy,fwlx,jzjg){
		$.ajax({
			   type: "GET",
			   url: "FINDT00362AJAX.action",
			   cache: false,
			   data: {ddlSZQY:szqy,
			          txtFWLX:fwlx,
			          txtJZJGT:jzjg
			          },
			   dataType: "json",
			   success: function(msg){
				   var bean = msg.t00362Bean;
				     var flag = msg.isExists;
				     if (flag) {
				    	 $("#btnAdd").show(); 
				    	 $("#btnUpd").hide();
				    	 $("#ACT").val("C");
				    	 $("#txtXZXS").val("");
				    	 $("#txtLSH").val("");
				    	 $("#txtNOTE").val("");
				    	// $("#txtNSZDXS").val(0);
				    	 $.notifyBar({html: '参数不存在，请输入' });
				     }else{
				    	 $("#btnUpd").show();
				   		 $("#btnAdd").hide(); 
				   		 $("#ACT").val("U");
				   		 $("#txtXZXS").val(bean.xzxs);
				   		 $("#txtLSH").val(bean.id);
				   		 $("#txtUPDATE").val(formatDateTime(bean.upddate));
				   		 if(bean.note != '' && bean.note != null && bean.note != 'null'){
				   			$("#txtNOTE").val(bean.note);
				   		 }
				   		 $.notifyBar({html: '参数已存在，请更新' });
					 }
			   },
			   error: function(){
				   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
			   }
		});	
	}

function findByJzjg(){
	 var szqy = $("#ddlSZQY").val();
     var fwlx = $("#txtFWLX").val();
     var jzjg = $("#txtJZJGT").val();
   if (szqy != '' && fwlx !='' && jzjg !='') {
      bindInfoValue(szqy,fwlx,jzjg);
      }
}