//显示权利
function getRight(userID,ACT){
	$.ajax({
		  type:'GET',
		  cache: false,
		  url:'LoadRightsByUser.action',
		  data:'USERID=' + userID +'&ACT='+ACT,
		  success:function(res){
			 $('#divRight').html(res);
		  },
		  error:function(){
			 $.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		  }
	});
}

//显示用户组层
function getRole(userID,ACT){
	$.ajax({
		  type:'GET',
		  cache: false,
		  url:'LoadRolesByUser.action',
		  data:'USERID=' + userID +'&ACT='+ACT,
		  success:function(res){
			 $('#divRole').html(res);
		  },
		  error:function(){
			 $.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		  }
	});
}