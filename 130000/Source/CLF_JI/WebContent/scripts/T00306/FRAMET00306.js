$(document).ready(function(){
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtFCZH: {required: true}, 
			txtSWID: {required: true, maxlength : 21, myZJLX: true},
			txtNSRMC: {required: true, maxlength : 100},
			txtCSFSWID: {required: true, maxlength : 21, myCSFZJLX: true},
			txtCSFNSRMC: {required: true, maxlength : 100},
			txtZJLX: {required: true},
			txtCSFZJLX: {required: true},
			txtLXDH: {required: true, maxlength : 13},
			txtJYSJ: {required: true},
			txtJYLX: {required: true},
			txtDJRQ: {required: true},
			txtJYJG: {required: true}
		},
		messages:{
			txtSWID:{myZJLX:"<img src='../images/exclamation.gif' align='absmiddle' title='证件位数错误！'/>"},
			txtCSFSWID:{myCSFZJLX:"<img src='../images/exclamation.gif' align='absmiddle' title='证件位数错误！'/>"}
        }
	});
	
	$.validator.methods.myZJLX = function(value, element, param){
	    //在这里使用上面的三个参数进行校验
		if (value)
		{
			var zjyxws = $("#txtSWID").val().length;
			var yxws = $("#txtYXWS").val();
			if (yxws=="" || yxws=="0")
			{
				return true;
			}
			if (parseInt(yxws)==parseInt(zjyxws))
			{
				return true;
			}
		}

	};

	//这三个参数会在进行校验时由系统自动带入
	$.validator.methods.myCSFZJLX = function(value, element, param){
	    //在这里使用上面的三个参数进行校验
		if (value)
		{
			var zjyxws = $("#txtCSFSWID").val().length;
			var yxws = $("#txtCSFYXWS").val();
			if (yxws=="" || yxws=="0" )
			{
				return true;
			}
			if (parseInt(yxws)==parseInt(zjyxws))
			{
				return true;
			}
		}
	};

	//查询对话框
	if ($('#frame').length>0)
	{
	  $('#frame').dialog({
		title: "房屋信息",	
	    closed: true,
	    iconCls:"icon-search",
	       buttons:[{
				text:'打印',
				iconCls:'icon-print',
				handler:function(){
	    	   		printTZD();
				}
			},{
				text:'编辑',
				iconCls:'icon-edit',
				handler:function(){
					window.parent.addTabflash("房产编辑 ","sjcj/ADDT00302.action?ACT=C&FCID="+$("#FCIDE").val()+"",'LFBJ');
				}
			},{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#frame").dialog('close');
				}
			}]
		});
	};
	
	
	//证件类型
	$("#spZJLX").click(function(){
		var infoID = $("#txtZJLX").val();
		$("#hidSelect").val("ZJLX");
		openZJLXDialog(infoID, '#infoTreeDIV');
	});
	
	
	//承受方证件类型
	$("#spCSFZJLX").click(function(){
		var infoID = $("#txtCSFZJLX").val();
		$("#hidSelect").val("CSFZJLX");
		openZJLXDialog(infoID, '#infoTreeDIV');
	});
	
	// 交易类型
	$("#spJYLX").click(function(){
		$("#hidSelect").val("JYLX");
		var infoID = $("#txtJYLX").val();
		openJYLXDialog(infoID, '#infoTreeDIV');
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
				if ($("#hidSelect").val() == "ZJLX") {
					selectValue = getSelectedZJLXValue();
					$("#txtZJLX").val(selectValue);
					getZJLX(selectValue,'#txtZJLXNm');
					validateZjlx();
				} else if($("#hidSelect").val() == "CSFZJLX"){
					selectValue = getSelectedZJLXValue();
					$("#txtCSFZJLX").val(selectValue);
					getZJLX(selectValue,'#txtCSFZJLXNm');
					validateCsfZjlx();	
				}else if ($("#hidSelect").val() == "JYLX") {
					selectValue = getSelectedJYLXValue();
					$("#txtJYLX").val(selectValue);
					getJYLX(selectValue,'#txtJYLXTIP');
				}}
	       		},
				{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#dialog").dialog('close');
					}
			
				}]
	       
		});
	
});

function openDial(fcid){
	$("#FCIDE").val(fcid);
	$("#txtFCID").val(fcid);//为打印时做准备
	$("#ifrLFXX").attr("src", "../sjcj/DETAILT00320FC.action?FCID="+fcid+"");
	$("#frame").window("open");
}

function MyTip(obj,arg)
{    
	
	var tips = $(obj).attr("Tips");
	if (tips===undefined)
	{		
		var data = {FCID : arg};
		$.ajax({
			   type: "GET",
			   url: "../sjcj/DETAILT00320FC.action",
			   cache: false,
			   data: data,
			   complete:function()                                                    
	           {
					Tip(obj,'楼房信息',tips,400);
					return true;					
	           },
			   success: function(msg){	
		         $(obj).attr("Tips",msg);
			   },
			   error: function(){
				   
			   }
		});
	}
	else
	{	
		Tip(obj,'楼房信息',tips,400);
		return true;  
	}
}

function saveData(dy, szlc){
	window.parent.addTabflash("房产录入 ","sjcj/ADDT00302.action?ACT=C&LFID="+$("#LFIDE").val()+"&DY="+dy+"&SZLC="+szlc+"",'LFLR');
}

//验证证件类型有效位数
function validateZjlx(){
	$("#txtSWID").watermark({remove:true});
	var zjlxid = $("#txtZJLX").val();
	if(zjlxid != '' ){
		var url = "ISYXWS.action";
		var data = {txtZJLXId : zjlxid};
		$.ajax({
			type: "GET",
			url: url,
			cache: false,
			data: data,
			dataType: "json",
			success: function(myMsg){
				$("#txtYXWS").val(myMsg.isYXWS);
				if (myMsg.isYXWS!=0)
				{
					$("#txtSWID").watermark("有效位数为：" + myMsg.isYXWS + "位");
				}
				
			},
			error: function(){
				$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
			}
		});
	}
}

//设置证件默认类型
function validateCsfZjlx(){
	$("#txtCSFSWID").watermark({remove:true});
	var zjlxid = $("#txtCSFZJLX").val();
	if(zjlxid != ''){
		var url = "ISYXWS.action";
		var data = {txtZJLXId : zjlxid};
		$.ajax({
			type: "GET",
			url: url,
			cache: false,
			data: data,
			dataType: "json",
			success: function(myMsg){
				$("#txtCSFYXWS").val(myMsg.isYXWS);	
				if (myMsg.isYXWS!=0)
				{
					$("#txtCSFSWID").watermark("有效位数为：" + myMsg.isYXWS + "位");
				}
			},
			error: function(){
				$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
			}
		});
	}
}

function printTZD(){
	if($("#editForm").valid()){
		$("#loading").show();
		if(window.confirm('是否确定打印该楼房信息？')){
			$.ajax({
				type: 'POST',
				url: '../sjcj/EXECUTETZD.action',
				cache: false,
				data: {
						txtFCID: $("#txtFCID").val(),
						txtFCZH: $("#txtFCZH").val(),
						txtSWID: $("#txtSWID").val(),
						txtNSRMC: $("#txtNSRMC").val(),
						txtCSFSWID: $("#txtCSFSWID").val(),
						txtCSFNSRMC: $("#txtCSFNSRMC").val(),
						txtZJLX: $("#txtZJLX").val(),
						txtCSFZJLX: $("#txtCSFZJLX").val(),
						txtLXDH: $("#txtLXDH").val(),
						txtJYSJ: $("#txtJYSJ").val(),
						txtDJRQ: $("#txtDJRQ").val(),
						txtJYLX: $("#txtJYLX").val(),
						txtJYJG: $("#txtJYJG").val(),
						txtNOTE: $("#txtNOTE").val()
					},
				dataType: 'json',
				success: function(myMsg){
					$("#loading").hide();
					fcid = myMsg.resMsg;
					sign = myMsg.resSign;
					if("0" == sign){
						$.messager.alert('错误信息','打印时出错，信息如下：'+fcid,'error');
					}else if("1" == sign){
						$("#FCID").val(fcid);
						$("#printForm").attr("action", "../pg/EXECT00391.action");
						$("#printForm").attr("target", "_blank");
						$("#printForm").submit();
						$.messager.alert('信息','打印成功','success');
					}
				},
				error: function(){
					$("#loading").hide();
				}
			});
		}else{
			$("#loading").hide();
			return false;
		}
	}
}

