$(document).ready(function() {
	
	
	$("#btnUpd").click(function(){
		if($("#uploadForm").valid()){
			$("#loading").show();
			$("#uploadForm").submit();
		}
	});
	
	$("#delSel").click(function(){
		DelSelData();
	});
	
	$('.rootCheck').click(function(){
		$(".childCheck").each(function(){
			$(this)[0].checked=$('.rootCheck')[0].checked;
		});
	});
	
	
	//FROM验证信息
	$("#uploadForm").validate({
		rules: {
			upload: {required: true}
		}
	});
	//查询
	$("#subA").click(function(){
		searchDate();
	});
	
	$("#subB").click(function(){
		$("#findForm").submit();
	});
	
	

});

function DelSelData(){
	var selvalue="";
	$("input[id='chkSel'][type=checkbox]:checked").each(function() { //由于复选框一般选中的是多个,所以可以循环输出
		selvalue = selvalue + $(this).val() + ",";
    });
	if (selvalue=="")
	{
		$.notifyBar({cls:"error", html: '请选择要删除的数据！'});
		return;
	}
	DelData(selvalue);
}

function DelData(value){
	
	$("#loading").show();
	var url = "xtwh/DELSELT00004.action";
	var data = {chkDel : value
			};
			
	$.ajax({
		   type: "POST",
		   url: url,
		   cache: false,
		   data: data,
		   dataType: "json",
		   complete:function()
           {
				$("#loading").hide();
				
           },
		   success: function(msg){
        	   $.notifyBar({cls:"warning", html: msg.msgDel});
        	   searchDate();
        	   var selvalue="";
	       	   $("input[id='chkSelAll'][type=checkbox]:checked").each(function() { //由于复选框一般选中的是多个,所以可以循环输出
	       			selvalue = selvalue + $(this).val() + ",";
	       	   });
	       	   if (selvalue!="")
	       	   {
	       			$("#chkSelAll").attr("checked",false);
	       	   }
		   },
		   error: function(){
			   $("#loading").hide();
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});
}


