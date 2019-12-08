$(document).ready(function() {

	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtUSERID: {required: true, maxlength : 18},
			txtUSERNM: {required: true, maxlength : 50},
			txtPSSD: {required: true},
			txtSSGX: {required: true},
			txtUSERIP: {maxlength : 15, myIP:true},
			txtNOTE: {maxlength : 200}
		},
		messages:{
			txtUSERIP:{myIP:"<img src='../images/exclamation.gif' title='你输入的是一个非法的IP地址段！\nIP段为：:xxx.xxx.xxx.xxx（xxx为0-255)!'/>"}
        }
	});
	
	//这里定义了一个名为equal的规则
	//value是指当前校验域的值
	//element是指当前检验的域
	//param是指在rules中设定的参数
	//这三个参数会在进行校验时由系统自动带入
	$.validator.methods.myIP = function(value, element, param){
	    //在这里使用上面的三个参数进行校验    
		if (value)
		{
			//如果该对象不存在说明是添加。添加时不用判断。
			if (checkIP2(value))
				return true;//如果当前域的值等于指定的参数就通过校验		
		}
		else
		{
			return true;
		}
	};

	//判断单选按钮是否选中
	var flag = $("input[id='rdoISLOCKEDT'][type='radio']:checked").val();
	if (flag) {
		$('#lockeddatediv').css('display','block');
	}
	
	$(":radio").click(function(){
		var islocked = $("input[name='rdoISLOCKED'][type='radio']:checked").val();
		if (islocked == 'true') {
			var lockdate = $('#txtLOCKEDDATE').val();
			if (lockdate == "null") {
				$('#txtLOCKEDDATE').val("");
			}
			$('#lockeddatediv').css('display','block');
		}else{
			$('#lockeddatediv').css('display','none');
		}
	});	
	
	$("#dialog").dialog({
		modal: true,
        shadow: true,
        closed: true,
	       buttons:[{
				text:'选择',
				iconCls:'icon-ok',
				handler:function(){
	    	   		$("#dialog").dialog("close");
	    	   		var selectValue = getSelectedSSGXValue();
					$("#txtSSGX").val(selectValue);
					getSSGX(selectValue,'#txtSSGXTIP');
					var userID = $("#txtUSERID").val();
					var ssgx = $("#txtSSGX").val();
					flashRole(userID, ssgx);
				}
			},{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#dialog").dialog('close');
				}
			}]
		});	
	
	// 税收管辖
	$("#spSSGX").click(function(){
		var infoID = $("#txtSSGX").val();
		openSSGXCONDDialog(infoID,'#infoTreeDIV');
	});
});



//刷新权利
function flashRight(userID, ssgx){
	$.ajax({
		  type:'GET',
		  cache: false,
		  url:'FlashRightsByUser.action',
		  data:{USERID: userID, SSGX: ssgx},
		  success:function(res){
			 $('#divRight').html(res);
		  },
		  error:function(){
			 $.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		  }
	});
}


//刷新权利
function flashRole(userID, ssgx){
	$.ajax({
		  type:'GET',
		  cache: false,
		  url:'FlushRolesByUser.action',
		  data:{USERID: userID, SSGX: ssgx},
		  success:function(res){
			 $('#divRole').html(res);
		  },
		  error:function(){
			 $.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		  }
	});
}



