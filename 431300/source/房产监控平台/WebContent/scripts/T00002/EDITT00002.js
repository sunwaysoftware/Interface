$(document).ready(function() {

	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtUSERID: {required: true, maxlength : 18},
			txtUSERNM: {required: true, maxlength : 50},
			txtPSSD: {required: true},
			txtNOTE: {maxlength : 200},
			txtSSGX: {required: true}
		}
	});
	

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
	    		   var selectValue = getSelectedSSGXValue();
					$("#txtSSGX").val(selectValue);
					getSSGX(selectValue,'#txtSSGXTIP');
					var userID = $("#txtUSERID").val();
					var ssgx = $("#txtSSGX").val();
					if("U" != $("#ACT").val()){
						flashRole(userID, ssgx);
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
	
	
	$("#spSSGX").click(function(){
		var infoID = $("#txtSSGX").val();
		//openSSGXDialog(infoID,"#infoTreeDIV");
		openSSGXCONDDialog(infoID,"#infoTreeDIV");
	});
	
	$("#txtUSERID").blur(function(){
		if($("#txtUSERID").val().length >= 9){
			if("D" != $("#ACT").val() && null != $("#txtUSERID").val() && "" != $("#txtUSERID").val()){
				useridIsExist();
			}
		}else
		{
			$("#txtUSERSpan").html('');
		}
	});
});


//显示非管理员角色层信息
function getRoleNotAdmin(userID,ACT){
	$.ajax({
		  type:'GET',
		  cache: false,
		  url:'LoadRolesByUserNotAdmin.action',
		  data:'USERID=' + userID +'&ACT='+ACT,
		  success:function(res){
			 $('#divRole').html(res);
		  },
		  error:function(){
			  $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		  }
	});
}

//更新时验证主键是否存在
function useridIsExist(){
	$.ajax({
		type : 'POST',
		cache : false,
		url : 'validateUserIdIsExist.action',
	    data : {
				txtUSERID : $("#txtUSERID").val()
				},
	    dataType : 'json',
		success : function(msg){
					var sign = msg.resSign;
					if(sign == "0"){
						//$.messager.alert('验证',msg.resMsg,'info');
						$("#txtUSERSpan").html('<img src=\"../images/success.gif\" />该编码可用');
					}else if(sign == "1" && ($("#txtUSERID").val() != $("#txtUSERIDOLD").val())){
						$("#txtUSERID").val("");
						//$.messager.alert('验证',msg.resMsg,'error');
						$("#txtUSERSpan").html('<img src=\"../images/msgERROR.gif\" />该编码已存在');
					}else if(sign == "2"){
						$.notifyBar({cls:"error", html: msg.resMsg});
					}
				},
		error : function(){
					$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
				}
	});
}
