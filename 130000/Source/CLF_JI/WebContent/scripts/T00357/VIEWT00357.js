$(document).ready(function() {
	/*//查询对话框
	if ($('#makeBZF').length>0)
	{
	  $('#makeBZF').dialog({
		title: "建立标准房",	
        closed: true,
        iconCls:"icon-evaluate",
	       buttons:[{
				text:'建立标准房',
				iconCls:'icon-evaluate',
				handler:function(){
	    	   		makeBZF();
				}
			},{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#makeBZF").dialog('close');
				}
			}]
		});
	};*/

	//FROM验证信息
	$("#uploadForm").validate({
		rules: {
			upload: {required: true}
		}
	});	

	//查询
	$("#selDel").click(function(){
		DelData();
	});
	//模板数据导出
	$("#btnDownload").click(function(){
		window.location="../Date/kbsl.xls";
		
	});		
	// 房屋类型
	$("#spFWLXBZF").click(function(){
		$("#hidSelect").val("FWLXBZF");
		var infoID = $("#txtFWLXFindBZF").val();
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
					if($("#hidSelect").val() == "FWLX"){
						selectValue = getSelectedFWLXValue();
						$("#txtFWLXFind").val(selectValue);
						getFWLX(selectValue, '#txtFWLXNm');
					}if($("#hidSelect").val() == "FWLXBZF"){
						selectValue = getSelectedFWLXValue();
						$("#txtFWLXFindBZF").val(selectValue);
						getFWLX(selectValue, '#txtFWLXNmBZF');
					}if($("#hidSelect").val() == "XQ"){
		    			   var szqy = $("#ddlSZQYFindBZF").val();
							selectValue = getSelectedXQValue();							
							if(null==selectValue) return;
							$("#txtXQFindBZF").val(selectValue);
							getXQ(szqy, selectValue, '#txtXQTIPBZF');
							//根据选择小区带出相关信息					
							//readXQinfoa($("#txtXQFindBZF").val());
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
	
	

//	$("#dialog").dialog({
//		modal: true,
//        shadow: true,
//        closed: true,
//	       buttons:[{
//				text:'选择',
//				iconCls:'icon-ok',
//				handler:function(){
//	    	   var selectValue;
//	    	   		$("#dialog").dialog("close");
//	    	   		var szqy = $("#ddlSZQYFind").val();
//					var selectValue = getSelectedXQValue();
//					$("#txtXQFind").val(selectValue);
//					getXQ(szqy, selectValue, '#txtXQTIP');
//					if($("#hidSelect").val() == "FWLXBZF"){
//						selectValue = getSelectedFWLXValue();
//						$("#txtFWLXFindBZF").val(selectValue);
//						getFWLX(selectValue, '#txtFWLXNmBZF');
//					}if($("#hidSelect").val() == "XQ"){
//		    			   var szqy = $("#ddlSZQYFindBZF").val();
//							selectValue = getSelectedXQValue();
//							if(null==selectValue) return;
//							$("#txtXQFindBZF").val(selectValue);
//							getXQ(szqy, selectValue, '#txtXQTIPBZF');
//							//根据选择小区带出相关信息					
//							//readXQinfoa($("#txtXQFindBZF").val());
//		    		}
//				}
//			},{
//				text:'关闭',
//				iconCls:'icon-cancel',
//				handler:function(){
//					$("#dialog").dialog('close');
//				}
//			}]
//		});	

	$("#ddlSZQYFind").change(function(){
		$("#txtXQFind").val('');
		$("#txtXQTIP").val('');
		getDivXqmcEdit($('#ddlSZQYFind').val(), '', '#T00352Tree');
	});
	$("#ddlSZQYFindBZF").change(function(){
		$("#txtXQFindBZF").val('');
		$("#txtXQTIPBZF").val('');
	});
	// 小区代码
	$("#spXQDMBZF").click(function(){
		var szqy = $("#ddlSZQYFindBZF").val();
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请先选择所在区域' });
			$("#ddlSZQYFindBZF").focus();
		} else {
			$("#hidSelect").val("XQ");
			var xqdm = $("#txtXQFindBZF").val();
			openXQMCDialog(szqy, xqdm, '#infoTreeDIV');
		}
	});
	$("#spXQDM").click(function(){
		var szqy = $("#ddlSZQYFind").val();
		if (szqy == null || szqy == "") {
			$.notifyBar({cls: "warning", html: '请先选择所在区域' });
			$("#ddlSZQYFind").focus();
		} else {
			var infoID = $("#txtXQFind").val();
			openXQMCDialog(szqy, infoID, '#infoTreeDIV');
		}
	});
});


//根据选项，请求action作编辑用
function getXQRdoValue(infoid,infonm){
	//判断点击的单选按钮类型，根据单选按钮类型，为隐藏域赋值
	$("#TIPXQMC").text(infonm);
	$("#XQDM").val(infoid);
	$("#txtXQFind").val(infoid);
	//searchDate();
};


function DelData(){
	/*$("#loading").ajaxStart(
        function()
        {
         $("#loading").show();
        }
    );*/
	var selvalue="";
	$("input[id='chkSel'][type=checkbox]:checked").each(function() { //由于复选框一般选中的是多个,所以可以循环输出
		selvalue = selvalue + $(this).val() + ",";
    });
    if (selvalue=="")
	{
		$.notifyBar({cls:"error", html: '请选择要删除的数据！'});
		return;
	}
	var url = "xtwh/DELSELT00357.action";
	var data = {chkSel : selvalue
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
           },
		   success: function(msg){
        	   $("#loading").hide();
        	   searchDate();
        	 
		   },
		   error: function(){
			   $("#loading").hide();
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});
}
function makeBZF(){
//	alert($("#ddlSZQYFind").val());
//	alert($("#txtXQFind").val());
//	alert($("#txtFWLXFind").val());
	$("#loading").show();
	if(window.confirm('是否确定建立标准房？')){
		$.ajax({
			type: 'POST',
			url: '../xtwh/MAKEBZF.action',
			cache: false,
			data: {
				ddlSZQYFindBZF : $("#ddlSZQYFind").val(),
				txtXQFindBZF : $("#txtXQFind").val(),
				txtFWLXFindBZF : $("#txtFWLXFind").val()
			},
			dataType:'json',
			complete:function(){
				$("#loading").hide();
			},
			success: function(msg){
				$.notifyBar({cls:"success", html: '创建标准房个数为：'+msg.resMsgBZF});
			},
			error: function(){
				$("#loading").hide();
				$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
			}
		});
	}else{
		$("#loading").hide();
		return false;
	}

}
