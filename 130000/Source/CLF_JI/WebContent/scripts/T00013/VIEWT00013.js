$(document).ready(function() {
	// 税收管辖
	$("#spSSGX").click(function(){
		$("#hidSelect").val("SSGX");
		var infoID = $("#txtSSGX").val();
		openSSGXCONDDialog(infoID, '#infoTreeDIV');
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
	
	//税收管辖退格清除内容
	$("#txtSSGXTIP").blur(function(){
		var id = $("#txtSSGXTIP").val();
		var flag = isNaN(id);
		
		if(id == '' && !flag){
			
			$("#txtSSGXTIP").val("");
			$("#txtSSGX").val("");
		}
	});
});

function BindData(){

	$("#loading").ajaxStart(
        function()
        {
        	$("#loading").show();
        }
    );
	var url = "xtwh/FINDT00013.action";
	var data = {txtLOGTYPEFind: $("#txtLOGTYPEFind").val(), txtTABLENAMEFind: $("#txtTABLENAMEFind").val(), txtCZRFind: $("#txtCZRFind").val(), pageIndex: $("#pageindex").val()};
	$.ajax({
		   type: "GET",
		   url: url,
		   cache: false,
		   data: data,
		   dataType: "json",
		   complete:function()                                                    
           {
				$("#loading").hide();
           },
		   success: function(msg){
		     var data = msg.operList;
		     var row = $("#rowtemplate").clone();
		     $("#divShow").html("");
		     row.appendTo("#divShow");
             $.each(data, function(i, n){ 
            	 var tmprow = row.clone();
            	 tmprow.attr("id","");
            	 tmprow.find("#no").text(formatString(n.recordIndex));
            	 tmprow.find("#tablename").text(formatString(n.tablename));
            	 tmprow.find("#tablekey").text(formatString(n.tablekey));
            	 tmprow.find("#logtypename").text(formatString(n.logtypename));
            	 tmprow.find("#upddate").text(formatDateTime(n.upddate));
            	 tmprow.find("#czr").text(formatString(n.czr));
            	 tmprow.find("#note").text(formatString(n.note));
            	 tmprow.find("#cd00002Czr").text(formatString(n.cd00002Czr));
            	 tmprow.appendTo("#divShow");//添加到模板的容器中    
            	 tmprow=null;
               });             
             row=null;
             $("#pageindex").val(msg.pageIndex);
             $("#pagecount").text(msg.pageCount);
             $("#rowcount").text(msg.rowCount);
             SetButtonState();
		   },
		   error: function(){
			   $("#loading").hide();
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
	
}


