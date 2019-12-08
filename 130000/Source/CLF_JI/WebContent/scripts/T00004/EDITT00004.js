//显示用户层
function getUser(rightID,ACT){
	$.ajax({
		  type:'GET',
		  cache: false,
		  url:'LoadUsersByRight.action',
		  data:'RIGHTID=' + rightID +'&ACT='+ACT,
		  success:function(res){
			 $('#divUser').html(res);
		  },
		  error:function(){
			 $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		  }
	});
}

//显示用户组
function getRole(rightID,ACT){
	$.ajax({
		  type:'GET',
		  cache: false,
		  url:'LoadRolesByRight.action',
		  data:'RIGHTID=' + rightID +'&ACT='+ACT,
		  success:function(res){
			 $('#divRole').html(res);
		  },
		  error:function(){
			 $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		  }
	});
}


function AppSubmit(){
	$("#editForm").submit();
};