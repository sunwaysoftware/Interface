$(document).ready(function() {

	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtROLENM: {required: true, maxlength : 50},
			txtNOTE: {maxlength : 200}
		}
	});
});

//显示用户层
function getUser(roleID,ACT){
	$.ajax({
		  type:'GET',
		  cache: false,
		  url:'LoadUsersByRole.action',
		  data:'ROLEID=' + roleID +'&ACT='+ACT,
		  success:function(res){
			 $('#divUser').html(res);
		  },
		  error:function(){
			  $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		  }
	});
}

//显示权限
function getRight(roleID,ACT){
	$.ajax({
		  type:'GET',
		  cache: false,
		  url:'LoadRightsByRole.action',
		  data:'ROLEID=' + roleID +'&ACT='+ACT,
		  success:function(res){
			 $('#divRight').html(res);
		  },
		  error:function(){
			  $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		  }
	});
}
