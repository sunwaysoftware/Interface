$(document).ready(function() {
	
	getDate();
	
	$("#ddlSZQY").change(function(){
		getDate();
	});
	
	$("#aUpdate").click(function(){
		$("#editForm").attr("action","EDITT00359.action");
		$("#editForm").submit();
	});
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
		    txtFWLX: {required: true},
			ddlSZQY: {required: true}
		}
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
		if(fwlxId != ''){
			if (!flag)
			getFWLX(fwlxId, '#txtFWLXTIP');			
		}
		else
		{
			$("#txtFWLX").val("");
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
						
						getDate();
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
	$("#checkedAll").click(function() {  
		if ($(this).attr("checked") == true) 
		{ 
			$("[name='chkZHXZ']").attr("checked",'true');//全选
		} 
		else {  
			$("[name='chkZHXZ']").removeAttr("checked");//取消全选
		} 
	});
	
});

function getDate(){
	var szqy = $("#ddlSZQY").val();
	var fwlx = $("#txtFWLX").val();
	if ((szqy=="" && fwlx!="") || (szqy!="" && fwlx=="")) return;
	$("#loading").show();
	$.ajax({
		  type:'GET',
		  cache: false,
		  url:'FINDT00359.action',
		  data:{ddlSZQY:szqy,txtFWLX:fwlx},
		  complete:function()                                                    
          {
				$("#loading").hide();
          },
		  success:function(res){
				 $('#Zhxz').html(res);
		  },
		  error:function(){
			 alert('操作失败!');
		  }
	});
	
}
