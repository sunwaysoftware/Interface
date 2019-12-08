$(document).ready(function() {
	
	$("#btnUpd").click(function(){
		if($("#uploadForm").valid()){
			$("#loading").show();
			$("#uploadForm").submit();
		}
	});
	
	//FROM验证信息
	$("#uploadForm").validate({
		rules: {
			upload: {required: true}
		}
	});
	
	$("#selDel").click(function(){
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

	
	// 建筑结构
	$("#spJZJG").click(function(){
		$("#hidSelect").val("JZJG");
		var infoID = $("#txtJZJGFind").val();
		openJZJGDialog(infoID, '#infoTreeDIV');
	});
	
	// 房屋类型
	$("#spFWLX").click(function(){
		$("#hidSelect").val("FWLX");
		var infoID = $("#txtFWLXFind").val();
		openFWLXDialog(infoID, '#infoTreeDIV');
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
					var selectValue;
					if ($("#hidSelect").val() == "JZJG") {
						selectValue = getSelectedJZJGValue();
						$("#txtJZJGFind").val(selectValue);
						getJZJG(selectValue,'#txtJZJGNm');
					}else if($("#hidSelect").val() == "FWLX"){
						selectValue = getSelectedFWLXValue();
						$("#txtFWLXFind").val(selectValue);
						getFWLX(selectValue, '#txtFWLXNm');
					}else{
						$.notifyBar({html: '已选择' });
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
	
	//房屋类型退格清除内容
	$("#txtFWLXNm").blur(function(){
		var id = $("#txtFWLXNm").val();
		var flag = isNaN(id);
		
		if(id == '' && !flag){
			
			$("#txtFWLXNm").val("");
			$("#txtFWLXFind").val("");
		}
	});
	//建筑结构退格清除内容
	$("#txtJZJGNm").blur(function(){
		var id = $("#txtJZJGNm").val();
		var flag = isNaN(id);
		
		if(id == '' && !flag){
			
			$("#txtJZJGNm").val("");
			$("#txtJZJGFind").val("");
		}
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

	$("#delSel").click(function(){
		DelSelData();
	});
	
	$("#loading").show();
	var url = "xtwh/DELSELT00362.action";
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

	$("#delSel").click(function(){
		DelSelData();
	});
	
	$("#loading").show();
	var url = "xtwh/DELSELT00361.action";
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
	var url = "xtwh/DELSELT00362.action";
	var data = {chkSel : value
			};
			
	$.ajax({
		   type: "POST",
		   url: url,
		   cache: false,
		   data: data,
		   dataType: "html",
		   complete:function()
           {
				$("#loading").hide();
				$.notifyBar({cls:"success", html: '已成功删除'});
           },
		   success: function(msg){
        	   searchDate();
		   },
		   error: function(){
			   $("#loading").hide();
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});
}