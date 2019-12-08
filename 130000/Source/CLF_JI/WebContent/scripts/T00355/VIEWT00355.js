$(document).ready(function() {
	//FROM验证信息
	$("#uploadForm").validate({
		rules: {
			upload: {required: true}
		}
	});	
	
	//查询
	$("#selDel").click(function(){
		DelSelData();

	});
	// 房屋类型
	$("#spFWLX").click(function(){
		$("#hidSelect").val("FWLX");
		var infoID = $("#txtFWLX").val();
		openFWLXDialog(infoID, '#infoTreeDIV');
	});
	
	//输入房屋类型代码获得类型
	$("#txtFWLXTIP").blur(function(){
		var fwlxId = $("#txtFWLXTIP").val();
		var flag = isNaN(fwlxId);
		if(fwlxId != '' && !flag){
			getFWLX(fwlxId, '#txtFWLXTIP');
			
		}
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
	    	   		if ($("#hidSelect").val() != "QTXZ")
	    	   			$("#dialog").dialog("close");
				var selectValue;
				if ($("#hidSelect").val() == "FWLX") {
					selectValue = getSelectedFWLXValue();
					$("#txtFWLX").val(selectValue);
					getFWLX(selectValue, '#txtFWLXTIP');
				
				}else if($("#hidSelect").val() == "QTXZ"){
					//节点父id
					var parentID = getSelectedCGZKparentID();
					//节点父Nm
					var parentNM = getSelectedCGZKparentNM();
					//节点id
					var selectValue = getSelectedCGZKValue();
					//节点Name
					var displayValue = getSelectedCGZKName();
					//隐藏域（父类已选择id字符串）
					var parentQtxzs = $("#hidPARENTQTXZ").val();
					//隐藏域（子类类已选择id字符串）
					var qtxzs = $("#hidQTXZ").val();
					//隐藏域（全部父类id）
					var zhxzlx = $("#hidZHXZ").val();
					//此处为限定，在大类下只能选择一个子类
					if (qtxzs.search(selectValue)==-1 && parentQtxzs.search(parentID)==-1) {
						$("#ddlQTXZ").append(
								"<span class=\"qtxz\">" + parentNM+ ":" +displayValue
										+ " <a href=\"javascript:;\"  PANENTQTXZ=\"" + parentID+ "\" QTXZ=\"" + selectValue+ "\" onclick=\"qtxzClick(this);\">[删]</a></span>");
						$("#hidQTXZ").val($("#hidQTXZ").val() + selectValue +',');
						$("#hidPARENTQTXZ").val($("#hidPARENTQTXZ").val() + parentID +',');
						
					}else{
						$.notifyBar({html: '已选择' });
					}
					}				
				}
			},{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#dialog").dialog('close');
				}
			}]
		});	
	//
	
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
	var url = "xtwh/DELSELT00355.action";
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


