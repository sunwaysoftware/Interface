$(document).ready(function() {
	//添加
	$("#btnAdd").click(function(){
		/*if ($("#editForm").valid())
			AddData();*/
		$("#editForm").submit();
	});	
	
	//更新
	$("#btnUpd").click(function(){
//		if ($("#editForm").valid())
//			UpdData();
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
			txtSYNXMIN: {required: true, number: true},
			txtSYNXMAX: {required: true, number: true,mySYNX:true},
			txtPSSD: {required: true},
			txtXZXS: {required: true, number: true},
			txtFWLX: {required: true}
		},
		messages:{
			txtSYNXMAX:{mySYNX:"<img src='../images/exclamation.gif' align='absmiddle' title='使用年限上限应大于等于使用年限下限'/>"}
		}
	});
	//这里定义了一个名为equal的规则
	//value是指当前校验域的值
	//element是指当前检验的域
	//param是指在rules中设定的参数
	//这三个参数会在进行校验时由系统自动带入
	$.validator.methods.mySYNX = function(value, element, param){
	    //在这里使用上面的三个参数进行校验
		if (value)
		{
			//如果该对象不存在说明是添加。添加时不用判断。
			if (parseInt($("#txtSYNXMIN").val())<=parseInt(value)){
				return true;//如果当前域的值等于指定的参数就通过校验
			}else{
				return false;
			}
				
		}
	};
	
	//根据隐藏域判断点击情况，如果符合，则请求数据填充页面
	$("#txtSYNXMAX").blur(function(){
		var szqy = $("#ddlSZQY").val();
		var fwlx = $("#txtFWLX").val();
		var synxmin = $("#txtSYNXMIN").val();
		var synxmax = $("#txtSYNXMAX").val();
		
 		if (szqy != '' && fwlx !='' && synxmin !='' && synxmax !='') {
		bindInfoValue(szqy,fwlx,synxmin,synxmax);
		}
	});


	// 房屋类型
	$("#spFWLX").click(function(){
		var infoID = $("#txtFWLX").val();
		openFWLXDialog(infoID, '#infoTreeDIV');
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
		    	   var selectValue = getSelectedFWLXValue();
					$("#txtFWLX").val(selectValue);
					getFWLX(selectValue, '#txtFWLXTIP');
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
function bindInfoValue(szqy,fwlx,synxmin,synxmax){
	$.ajax({
		   type: "GET",
		   url: "FINDT00361AJAX.action",
		   cache: false,
		   data: {ddlSZQY:szqy,
		          txtFWLX:fwlx,
		          txtSYNXMIN:synxmin,
		          txtSYNXMAX:synxmax
		          },
		   dataType: "json",
		   success: function(msg){
			   var bean = msg.t00361Bean;
			     var flag = msg.isExists;
			     if (flag) {
			    	 $("#btnAdd").show(); 
			    	 $("#btnUpd").hide();
			    	 $("#ACT").val("C");
			    	 $("#txtXZXS").val("");
			    	 $("#txtLSH").val("");
			    	 $("#txtNOTE").val("");
			    	 //$("#txtNSZDXS").val(0);
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

//后台添加数据
/*function AddData(){
	var czlx = 0;
	if($("#rdoCZLX1:checked").val()==1)
		czlx = 1;		
	$.ajax({
		   type: "GET",
		   cache: false,
		   url: "EDITT00361.action",
		   data: {
					ACT:'C', 
					txtLSH:$("#txtLSH").val(),
					txtSYNXMIN:$("#txtSYNXMIN").val(),
					txtSYNXMAX:$("#txtSYNXMAX").val(),
					txtPSSD:$("#txtPSSD").val(),
					txtXZXS:$("#txtXZXS").val(),
					txtNOTE:$("#txtNOTE").val(), 
					txtCZLX: czlx},
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
		   url: "EDITT00361.action",
		   data: { 
					txtLSH:$("#txtLSH").val(),
					txtSYNXMIN:$("#txtSYNXMIN").val(),
					txtSYNXMAX:$("#txtSYNXMAX").val(),
					txtPSSD:$("#txtPSSD").val(),
					txtXZXS:$("#txtXZXS").val(),
					ACT: $("#ACT").val(), 
					txtNOTE:$("#txtNOTE").val(), 
					txtCZLX: czlx},
		   success: function(msg){
			   $.notifyBar({cls: "success", html: '参数更新成功'});
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   
		   }
	});	
}*/
