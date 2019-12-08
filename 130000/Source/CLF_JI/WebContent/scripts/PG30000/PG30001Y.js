$(document).ready(function() {
	//评估
	$('#REPG').click(function()
	{ 	
		var selvalue="";
		$("input[id='chkSel'][type=checkbox]:checked").each(function() { //由于复选框一般选中的是多个,所以可以循环输出
			selvalue = selvalue + $(this).val() + ",";
	    });
		if (selvalue=="")		
		{
			$.messager.alert('警告信息','请选择要操作的数据！','warning');
			return;
		}
			
		document.getElementById('hidFlag').value='1';
		$("input[id='chkSel'][type=hidden]").val(selvalue);	
		AppSubmit();
	});
	//评估所有的
	$('#REPGALL').click(function()
	{ 			
		$.messager.confirm('系统提示', '您确定要全部重新评估吗?', function(r) {
            if (r) {
            	document.getElementById('hidFlag').value='2';
        		AppSubmit();
            }
        });	
		
	});
});


//数据变更
function execInfoBg(fcid){
	if(!window.confirm("数据变更操作，将把数据退回到初始状态，是否确认操作？")) return;
	
	var url = "../pg/EXECINFOBG.action";
	var data = {FCID : fcid};
	$.ajax({
		   type: "GET",
		   url: url,
		   cache: false,
		   data: data,
		   dataType: "json",
		   complete:function() {
				$("#loading").hide();
           },
		   success: function(msg){
		     var data = msg.bgFlag;
		     if(data)
		 		$.notifyBar({cls: "success", html: '数据变更操作成功执行完毕，请通知录入人员进行数据修改'});
		     else
		    	$.notifyBar({cls: "warning", html: '数据变更操作失败，请重试' });
		    //重新读取数
		     BindData();
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
	
}



function sendPGJG(fcid){
	$.ajax({
		type : "POST",
		cache : false,
		url : "../sjcj/DJZPGJGXML.action",
		dataType : "json",
		data : {
			FCID : fcid
		},
		success : function(msg){
			var bean = msg.t00370Bean;
			if(bean.result_code == '0'){
				$.notifyBar({cls: "success", html: bean.result_info});
			}else if(bean.result_code == '1'){
				$.messager.alert('错误信息',bean.result_info,'error');
			}else if(msg.resSign == '1'){
				$.messager.alert('错误信息','与接口连接失败','error');
			}
		},
		error : function(msg){
			$.notifyBar({cls: "error", html: '请求已发送，系统无响应'});
		}
	});
}





