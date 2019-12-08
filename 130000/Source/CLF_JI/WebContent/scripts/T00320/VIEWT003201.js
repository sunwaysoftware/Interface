$(document).ready(function() {	
	
	$("#delSel").click(function(){
		DelSelData();
	});
	
	$("#txtJYSJFind").blur(function(){
		if(null != $("#txtJYSJFind").val() && "" != $("#txtJYSJFind").val()){
			$("#pgjgSpan").show();
			$("#rdoPGJG1").attr("checked",true);
		}else{
			$("#pgjgSpan").hide();
			$("#rdoPGJG0").attr("checked",false);
			$("#rdoPGJG1").attr("checked",false);
		}
	});

	$("#pgBtn").click(function(){
		document.getElementById('hidFlag').value='1';
		var selvalue="";
		$("input[id='chkSel'][type=checkbox]:checked").each(function() { //由于复选框一般选中的是多个,所以可以循环输出
			selvalue = selvalue + $(this).val() + ",";
	    });
		if (selvalue=="")
		{
			$.messager.alert('估价','未选择需要估价数据','warning');
			return;
		}

		if($("#txtPSSDT").val() == "" || $("#txtPSSDT").val() == null){
			$("#pssdDiv").window("open");
			$("#sxkz2").show();
		}else{
			$("#txtPSSD").val($("#txtPSSDT").val());
			$("input[id='chkSel'][type=hidden]").val(selvalue);	
			AppSubmit();
		}
		
	});
	
	$("#pgBtnAll").click(function(){
		document.getElementById('hidFlag').value='2';
		if(isNaN($("#txtPSSDT").val())){
			$("#txtPSSD").val($("#txtPSSDT").val());
			AppSubmit();
		}else{
			$("#pssdDiv").window("open");
			$("#sxkz2").show();
		}
	});

	$('.rootCheck').click(function(){
		$(".childCheck").each(function(){
			$(this)[0].checked=$('.rootCheck')[0].checked;
		});
	});
	
	
	//查询对话框
	if ($('#pssdDiv').length>0)
	{
	  $('#pssdDiv').dialog({
		title: "全面评估",	
        closed: true,
        iconCls:"icon-ok",
	       buttons:[{
				text:'确定',
				iconCls:'icon-ok',
				handler:function(){
	    	   		$("#pssdDiv").dialog('close');
				}
			},{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#pssdDiv").dialog('close');
				}
			}]
		});
	};
	
	
	
	
	// 税收管辖
	$("#spSSGX").click(function(){
		$("#hidSelect").val("SSGX");
		var infoID = $("#txtSSGX").val();
		openSSGXCONDDialog(infoID, '#infoTreeDIV');
	});
	$("#dialog").dialog({
		modal: true,
        shadow: true,
        closed: true,
	       buttons:[{
				text:'选择',
				iconCls:'icon-ok',
				handler:function(){	 
	    	   	   var selectValue;
	    		   $("#dialog").dialog("close");
	    		   if($("#hidSelect").val() == "XQ"){
	    			   var szqy = $("#ddlSZQYFind").val();
						selectValue = getSelectedXQValue();
						if(null==selectValue) return;
						$("#txtXQFind").val(selectValue);
						getXQ(szqy, selectValue, '#txtXQTIP');
						//根据选择小区带出相关信息					
						//readXQinfoa($("#txtXQFind").val());
	    		   }else if ($("#hidSelect").val() == "SSGX") {
						selectValue = getSelectedSSGXValue();
						$("#txtSSGX").val(selectValue);
						getSSGX(selectValue,'#txtSSGXTIP');
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


	//所在区域
	$("#ddlSZQYFind").change(function(){
		$("#txtXQFind").val('');
		$("#txtXQTIP").val('');
	});

	//小区
	$("#spXQDM").click(function(){
		$("#hidSelect").val("XQ");
		var szqy = $("#ddlSZQYFind").val();
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请先选择所在区域' });
			$("#ddlSZQYFind").focus();
			return;
		}
		var infoID = $("#txtXQFind").val();
		openXQMCDialog(szqy, infoID, '#infoTreeDIV');
	});
	
	// 税收管辖
	$("#spSSGX").click(function(){
		$("#hidSelect").val("SSGX");
		var infoID = $("#txtSSGX").val();
		openSSGXCONDDialog(infoID, '#infoTreeDIV');
	});
	
	//小区名称退格清除内容
	$("#txtXQTIP").blur(function(){
		
		var xqtpid = $("#txtXQTIP").val();
		var flag = isNaN(xqtpid);
		
		if(xqtpid == '' && !flag){
			$("#txtXQTIP").val("");
			$("#txtXQFind").val("");
		}
	});
	
	//税收管辖退格清除内容
	$("#txtSSGXTIP").blur(function(){
		var ssgxtipId = $("#txtSSGXTIP").val();
		var flag = isNaN(ssgxtipId);
		
		if(ssgxtipId == '' && !flag){
			
			$("#txtSSGXTIP").val("");
			$("#txtSSGX").val("");
		}
	});
});


////根据小区代码读取相关信息，包含所在大区代码，以及小区状态等
//function readXQinfoa(xqdm){
////	alert("setParentdm: "+xqdm);
//	var url = "LOADPARENTDM.action";
//		var data = {XQDM : xqdm};		
//		
//		$.ajax({
//			type: "GET",
//			url: url,
//			cache: false,
//			data: data,
//			dataType: "json",
//			success: function(myMsg){
//				var bean = myMsg.t00352Bean;
////				$("#hidPARENTDM").val(bean.parentdm);
//				
//				if (bean.parentdm=='0')
//					{
//					alert("请选择片区下的小区！");
//					$("#txtXQDM").val("");
//					$("#txtXQTIP").val("");
//					}
//				/*$("#hidXQZT").val(bean.xqzt);
//				if (bean.jcnf != '' || bean.jcnf != null) {
////					alert(0);
//					$("#txtJCNF").val(formatString(bean.jcnf));
//				}*/
//				
//			},
//			error: function(){
//				$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
//			}
//		});
//}
/**
 * 彈出窗口
 * @param value 稅務ID
 * @return
 */
function showWin(value){
	Show("../pg/FINDQMPGXX.action?txtSWIDFind="+value, 330, 400, value);
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
	var url = "sjcj/DELSELT00320.action";
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
