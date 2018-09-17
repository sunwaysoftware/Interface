$(document).ready(function() {
	$("#tabs").tabs();
	
	//FROM验证信息
	$("#XGMMForm").validate({
		rules: {
			txtUSEROLDPWD: {required: true},
			txtUSERNEWPWD1: {required: true},
			txtUSERNEWPWD2: {required: true}
		}
	});
	//FROM验证信息
	$("#GXSZForm").validate({
		rules: {
			txtPSSD: {required: true},
			txtPAGECOUNT: {required: true, number: true, min:10, max:100}
		}
	});
	
	//弹窗后，用户设置每页显示条数，估价时点
	$("#btnSET").click(function(){
		if (!$("#GXSZForm").valid()) return;
		var pssd = $("#txtPSSD").val();
		var pagecount = $("#txtPAGECOUNT").val();
		var ddlssgx1 = $("#ddlSSGX1").val();
		if (pagecount >9 && pagecount< 100) {
			$.ajax({
				  type:'GET',
				  cache: false,
				  url:'../xtwh/SettingPersonal.action',
				  data : {txtPAGECOUNT : pagecount, txtPSSD : pssd, ddlSSGX1 : ddlssgx1},
				  success:function(res){
					  $.notifyBar({cls: "success", html: '设置成功' });
				  },
				  complete:function()                                                    
		           {
						$("#loading").hide();
		           },
				  error:function(){
		        	   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
				  }
			});
		}else{
			$.notifyBar({html: '请输入10至100间的数字' });
		}
		
	});
	
	
	//弹窗后，更新密码
	$("#btnUpdPwd").click(function(){
		if (!$("#XGMMForm").valid()) return;
		var oldpwd = $("#txtUSEROLDPWD").val();
		var newpwd1 = $("#txtUSERNEWPWD1").val();
		var newpwd2 = $("#txtUSERNEWPWD2").val();
		//判断两次输入新密码是否相同
		if (newpwd1 == newpwd2) {
			$.ajax({
				  type:'GET',
				  cache: false,
				  url:'../xtwh/ChangePWD.action',
				  data:{txtOLDUSERPWD: oldpwd, txtNEWUSERPWD:newpwd1},
				  success:function(res){
					  $.notifyBar({cls: "success", html: res});
				  },
				  complete:function()                                                    
		           {
						$("#loading").hide();
		           },
				  error:function(){
		        	   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
				  }
			});
		}else{
			$.notifyBar({html: '两次输入的新密码不相同' });
		}
	});
	
});
