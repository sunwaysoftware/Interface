$(document).ready(function() {

	//查询
	$("#subA").click(function(){
		$('#w').window('open');	
		$("#sxkz").show();
	});
//导出
$("#subB").click(function(){
		$("#findForm").submit();
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
					$("#txtSSGXFind").val(selectValue);
					getSSGX(selectValue,'#txtSSGXTIP');
				}
			},{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#dialog").dialog('close');
				}
			}]
		});	
	
	
	
	$("#spSSGX").click(function(){
		var infoID = $("#txtSSGXFind").val();
		if ($("#ISADMIN").val()=="true")
		{
			openSSGXDialog(infoID,"#infoTreeDIV");
		}
		else
		{
			openSSGXCONDDialog(infoID,"#infoTreeDIV");
		}
		
	});
	
	/*$("#txtSSGXTIP").keydown(function(event){
		if (event.keyCode=='46')
		  {
			$("#txtSSGXTIP").val("");
			$("#txtSSGXFind").val("");
		  }
	});*/
	
	//税收管辖退格清除内容
	$("#txtSSGXTIP").blur(function(){
		
		var id = $("#txtSSGXTIP").val();
		var flag = isNaN(id);
		
		if(id == '' && !flag){
			
			$("#txtSSGXTIP").val("");
			$("#txtSSGX").val("");
			$("#txtSSGXFind").val("");
		}
	});
	
});

//添加房产信息
function editUser(userID){
	showpParentWin('[用户管理编辑]','xtwh/ADDT00002.action?ACT=U&USERID=' + encodeURI(userID),'frame00002BG');
}

/**
 * 删除用户
 * @param userID
 * @return
 */
function DeleteUser(userID){
	$.messager.confirm('用户删除', '您确定要删除该' + userID + '用户吗?', function(r) {
        if (r) {
        	$("#findForm").attr("action","EDITT00002.action?ACT=D&txtUSERID="+encodeURI(userID));
        	$("#findForm").attr("target","");
        	$("#findForm").attr("method","POST");
        	$("#findForm").submit();
        }
    });	
}

/**
 * 初始化密码
 * @param userID
 * @return
 */
function InitPwd(userID){
	 $.messager.confirm('修改密码', '您确定要初始化' + userID + '密码吗?', function(r) {
        if (r) {
        	$.ajax({
  			  type:'GET',
  			  cache: false,
  			  url:'InitPWD.action',
  			  data:'USERID=' + userID ,
  			  success:function(res){
  				$.notifyBar({cls:"success", html: '初始化'+userID+'的密码成功'});
  			  },
  			  complete:function()                                                    
  	           {
  					$("#loading").hide();
  	           },
  			  error:function(){
  				 $.messager.alert('错误信息','请求已发送，服务器无应答！','error');
  			  }
        	});
        }
    });		
}