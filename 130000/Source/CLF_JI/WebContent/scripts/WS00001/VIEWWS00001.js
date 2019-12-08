$(document).ready(function() {	
	
	$("#dialog").dialog({
		modal: true,
        shadow: true,
        closed: true,
	       buttons:[{
				text:'选择',
				iconCls:'icon-ok',
				handler:function(){
	    	   		$("#dialog").dialog("close");
	    	   		var szqy = $("#ddlSZQYFind").val();
					var selectValue = getSelectedXQValue();
					if(null==selectValue) return;
					$("#txtXQFind").val(selectValue);
					getXQ(szqy, selectValue, '#txtXQTIP');
				}
			},{
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
		var szqy = $("#ddlSZQYFind").val();
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请先选择所在区域' });
			$("#ddlSZQYFind").focus();
			return;
		}
		var infoID = $("#txtXQFind").val();
		openXQMCDialog(szqy, infoID, '#infoTreeDIV');
	});
	
	
	//受理对话框
	if ($('#w1').length>0)
	{
	  $('#w1').dialog({
		title: "受理数据",	
        closed: true,
        iconCls:"icon-search",
	       buttons:[{
				text:'受理',
				iconCls:'icon-ok',
				handler:function(){
					if ($("#txtFCSLH").val()=="")
					{
						$.messager.alert('错误信息','受理号为空,请填写！','error');
						return;
					}
	    	   		subXML();
	    	   		$("#w1").dialog('close');
				}
			},{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#w1").dialog('close');
				}
			}]
		});
	};
	
	
	//受理对话框
	if ($('#w2').length>0)
	{
	  $('#w2').dialog({
		title: "受理数据",	
        closed: true,
        iconCls:"icon-search",
	       buttons:[{
				text:'受理',
				iconCls:'icon-ok',
				handler:function(){					
	    	   		$("#isVal").val("ok");
	    	   		subXML();
	    	   		$("#isVal").val("");
	    	   		$("#w2").dialog('close');
				}
			},{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#w2").dialog('close');
				}
			}]
		});
	};
});

function showParamWin(value){

	var randomnumber=Math.floor(Math.random()*100000);
	window.parent.addTabflash('补充采集信息',encodeURI(value+ "&rand="+randomnumber),'FrameBCSJ');

}

function subXML() {
	$("#loading").show();
	$.ajax({
		   type: "GET",
		   cache: false,
		   url: "FINDVxml.action",
		   dataType: "json",
		   data: {
			SLSign : $("#SLSign").val(),
			txtFCSLH : $("#txtFCSLH").val(),
			isVal : $("#isVal").val()
				},
				complete:function()
		        {
					$("#loading").hide();
		        },
		        success: function(msg){
					if(msg.txtSLSIGN == true){
						$.messager.confirm('系统提示', '该数据已被采集，您确定要覆盖数据吗?', function(r) {
				            if (r) {
				            	$("#isVal").val("ok");
				    	   		subXML();
				    	   		$("#isVal").val("");
				    	   		$("#w2").dialog('close');
				            }
				        });
					}else{
						if(msg.txtRes == "1"){							
							$.messager.confirm('系统提示', '受理号为空,请填写！', function(r) {
					            if (r) {
					            	
					            }
					        });
						}else if(msg.txtRes == "2"){
							$.messager.alert('无法连接房产服务器接口',msg.SLMsg,'error');
						}else if(msg.txtRes == "3"){
							$.messager.alert('错误信息','受理号不存在，请核实！','error');
						}else if(msg.txtRes == "-1"){
							$.messager.alert('错误信息',msg.pgt00352xml.errorMessage,'error');
						}else if(msg.txtRes == "4"){
							$.messager.alert('提示信息',msg.SLMsg,'warning');
						}else if(msg.txtRes == "5"){
							$.messager.alert('房产接口错误',msg.SLMsg,'error');							
						}else{
							$("#txtFCSLHFIND").val(msg.txtFCSLH);
							$("#SLSign").val("");
							$.notifyBar({cls: "success", html: '该受理数据已插入！'});
						}
						searchDate();
					}				
		   },
		   error: function(){
			   $.notifyBar({cls: "success", html: '请求已发送，系统无应答！'});
		   }
	});
};
