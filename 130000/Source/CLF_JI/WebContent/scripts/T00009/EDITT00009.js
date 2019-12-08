$(document).ready(function() {

	//查询
	$("#btnQuery").click(function(){
		if ($("#txtUSERID").val() == '') {
			$.notifyBar({html: '用户名称不能为空' });
			$("#txtUSERID").focus();
		}else{
			$.ajax({
				  type:'GET',
				  cache: false,
				  url:'IsExists.action',
				  dataType: "json",
				  data:{USERID: $("#txtUSERID").val()},
				  success:function(res){
					  var user = res.t00002Bean;
					  if (user.userid != null){
						  $("#btnReQuery").show();
						  $("#btnQuery").hide();
						  $("#showStatus").html('用户详细信息如下：<br/>用户编号：'+user.userid+'<br/>用户名称：'+user.usernm+'<br/>税收管辖：'+ user.ssgx+'<br/>电话号码：'+user.phone);
						  $("#showStatus").css('display','block');
						  $("#btnAdd").removeAttr("disabled");
						  $("#btnAdd").attr("href","javascript:AppSubmit();");
						  $("#txtUSERID").attr("readOnly","readOnly");
						  
						  var ssgx = $("#hidSSGX").val();
						  var userID = $("#txtUSERID").val();
						  flushRoleAndRight(userID,ssgx);
						  
					  } else{
						  $.notifyBar({html: '该用户不存在' });
						  $("#showStatus").css('display','block');
					  }
				  },
				  error:function(){
					  $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
				  }
			});
		}
	});
	
	//查询
	$("#btnReQuery").click(function(){
		$("#btnAdd").attr("disabled","disabled");
		$("#btnAdd").attr("href","javascript:;");
		$("#btnQuery").show();
		$("#btnReQuery").hide();
		$("#txtUSERID").removeAttr("readOnly");
		$("#txtUSERID").attr("class","txtfocus");
		$("#txtUSERID").val("");
		$("#showStatus").css('display','none');
	});
	
});

function setUserEnable()
{
	$("#btnReQuery").show();
	  $("#btnQuery").hide();						  
	  $("#showStatus").css('display','block');
	  $("#btnAdd").removeAttr("disabled");
	  $("#btnAdd").attr("href","javascript:AppSubmit();");
	  $("#txtUSERID").attr("readOnly","readOnly");
	  $("#txtUSERID").attr("class","txtNoEnable");
}

//根据选项，请求action作编辑用
function getRdoValue(infoid,infotype,infonm){
	//判断点击的单选按钮类型，根据单选按钮类型，为隐藏域赋值
	$("#TIPSSGX").text(infonm);
	$("#hidSSGX").val(infoid);
	
	var ssgxTip = $("#TIPSSGX").text();
	var ssgx = $("#hidSSGX").val();
	var userID = $("#txtUSERID").val();
	
	//根据隐藏域判断点击情况，如果符合，则刷新
	if (ssgx != '' && userID!= '') {
		//flushRoleAndRight(userID,ssgx);
		flushUpdate(ssgx, userID);
	}
};

/**
 * 刷新用户权限和角色
 * @param infoid
 * @param infonm
 * @return
 */
function flushRoleAndRight(userID, ssgx){
	
	
		flashRole(userID, ssgx);
		flashRight(userID, ssgx);
	
};

/**
 * 刷新更新时间
 * @return
 */
function flushUpdate(ssgx, userID){
	// 根据点击情况，判断返回bean是否为空，进一步刷新更新时间
	$.ajax({
		   type: "GET",
		   url: "FINDT00009AJAX.action",
		   cache: false,
		   data: {SSGX: ssgx, USERID: userID },
		   dataType: "json",
		   success: function(msg){
			   var bean = msg.t00009Bean;
		       if (!msg.isExists){
		    	   $("#txtUPDATE").val(formatDateTime(bean.upddate));
		    	  
		       }
		   },
		   error: function(){
			  
		   }
	});	
}