$(document).ready(function() {
	//添加
	$("#btnAdd").click(function(){
		if ($("#editForm").valid())
			AddData();
	});	
	//更新
	$("#btnUpd").click(function(){
		if ($("#editForm").valid())
			UpdData();
	});
	
	//删除
	$("#btnDel").click(function(){
		$("#editForm").submit();
	});
	//根据隐藏域判断点击情况，如果符合，则请求数据填充页面
	$("#ddlSZQY").change(function(){
		var szqy = $("#ddlSZQY").val();
		var lc = $("#txtLC").val();
		var zcs = $("#txtZCS").val();
		var pssd = $("#txtPSSD").val();
		var fwlx = $("#txtFWLX").val();
		//var ywdt=0;
		//if($("#rdoYWDT1:checked").val()==1)
		//	ywdt = 1;
		if (szqy != '' && lc != '' && lc != '0' && zcs != '' && zcs != '0' && pssd!='') {
			bindInfoValue(pssd,lc,zcs,szqy,fwlx);
		}
		
	});
	// 房屋类型
	$("#spFWLX").click(function(){
		$("#hidSelect").val("FWLX");
		var infoID = $("#txtFWLX").val();
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
	    	   		if ($("#hidSelect").val() != "QTXZ")
	            		$("#dialog").dialog("close");
					var selectValue;
					if ($("#hidSelect").val() == "FWLX") {
						selectValue = getSelectedFWLXValue();
						$("#txtFWLX").val(selectValue);
						getFWLX(selectValue, '#txtFWLXTIP');
						
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
	//根据隐藏域判断点击情况，如果符合，则请求数据填充页面
	$("#txtLC").blur(function(){
		var szqy = $("#ddlSZQY").val();
		var lc = $("#txtLC").val();
		var zcs = $("#txtZCS").val();
		var pssd = $("#txtPSSD").val();
		var fwlx = $("#txtFWLX").val();
		//var ywdt=0;
		//if($("#rdoYWDT1:checked").val()==1)
		//	ywdt = 1;
		if (szqy != '' && lc != '' && zcs != '' && pssd!='') {
			bindInfoValue(pssd,lc,zcs,szqy,fwlx);
		}
	});
	
	//根据隐藏域判断点击情况，如果符合，则请求数据填充页面
	$("#txtZCS").blur(function(){
		var szqy = $("#ddlSZQY").val();
		var lc = $("#txtLC").val();
		var zcs = $("#txtZCS").val();
		var pssd = $("#txtPSSD").val();
		var fwlx = $("#txtFWLX").val();
		//var ywdt=0;
		//if($("#rdoYWDT1:checked").val()==1)
		//	ywdt = 1;
		if (szqy != '' && lc != '' && zcs != '' && pssd!='') {
			bindInfoValue(pssd,lc,zcs,szqy,fwlx);
		}
	});
	
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			ddlSZQY: {required: true},
			txtLC: {required: true, number: true},
			txtZCS: {required: true, number: true,myZcs:true},
			txtXZXS: {required: true, number: true},
			txtPSSD: {required: true, number: true},
			txtFWLX: {required: true}
			
		},
		messages:{
			txtZCS:{myZcs:""}
		}
		
		
	});
	
	
});
//判断房屋类型与总楼层，所在楼层与总楼层是否符合要求
$.validator.methods.myZcs = function(value, element, param){
    //在这里使用上面的三个参数进行校验
	if (value)
	{			
		$("#TipZcs").html("");
	
	if (parseInt($("#txtLC").val())>parseInt(value))
			{
				$("#TipZcs").html("<img src='../images/exclamation.gif' align='absmiddle' title='总楼层小于所在楼层'/>");
				return false;//如果当前域的值等于指定的参数就没通过校验
			}
	else if(($("#txtFWLX").val()=='01'||$("#txtFWLX").val()=='02')&& parseInt(value)>8)
	{
		$("#TipZcs").html("<img src='../images/exclamation.gif' align='absmiddle' title='总楼层应小于等于8层'/>");
		return false;//如果当前域的值等于指定的参数就没通过校验
	}
	else return true;////如果当前域的值等于指定的参数就通过校验
		
	}
};

/**
 * 根据所在区域按钮，后台请求数据
 * @param fwcx
 * @param infoid
 * @param rootid
 * @param szqy
 * @return
 */
function bindInfoValue(pssd,lc,zcs,szqy,fwlx){
	$("#loading").show();
	$.ajax({
		   type: "GET",
		   url: "FINDT00355AJAX.action",
		   cache: false,
		   data: {txtLC:lc, txtZCS:zcs, ddlSZQY:szqy, PSSD: pssd,txtFWLX:fwlx},
		   dataType: "json",
		   complete:function()                                                    
           {
				$("#loading").hide();
           },
		   success: function(msg){
			   var bean = msg.t00355Bean;
			     var flag = msg.isExists;
			     if (flag) {
			    	 $("#btnAdd").show(); 
			    	 $("#btnUpd").hide();
			    	 $("#txtLC").val(bean.lc);
			    	 $("#txtZCS").val(bean.zcs);
			    	 $("#txtXZXS").val(0);
			    	 $("#txtNOTE").val('');
			    	 $.notifyBar({html: '参数不存在，请输入' });
			     }else{
			    	 $("#btnUpd").show();
			   		 $("#btnAdd").hide(); 
			   		 $("#txtLC").val(bean.lc);
			    	 $("#txtZCS").val(bean.zcs);
			   		 $("#txtXZXS").val(bean.xzxs);
			    	 $("#txtNOTE").val(formatString(bean.note));
			    	 $("#txtUPDATE").val(formatDateTime(bean.upddate));
			   		 $.notifyBar({html: '参数已存在，请更新' });
				 }
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}
//后台添加数据
function AddData(){
	var czlx = 0;
	if($("#rdoCZLX1:checked").val()==1)
		czlx = 1;	
//	var ywdt=0;
//	if($("#rdoYWDT1:checked").val()==1)
//		ywdt = 1;
	$.ajax({
		   type: "GET",
		   cache: false,
		   url: "EDITT00355.action",
		   data: {txtPSSD:$("#txtPSSD").val(), 
					txtLC:$("#txtLC").val(), 
					txtZCS:$("#txtZCS").val(), 
					ddlSZQY:$("#ddlSZQY").val(), 
					ACT:'C', 
					rdoCZLX: czlx,
					txtXZXS:$("#txtXZXS").val(), 
					txtFWLX : $("#txtFWLX").val(),
					//rdoYWDT: ywdt,
					txtNOTE:$("#txtNOTE").val()},
		   success: function(msg){
			   $.notifyBar({cls: "success", html: '参数创建成功'});
			   $("#ddlSZQY").val("");
			   $("#txtFWLX").val("");
			   $("#txtFWLXTIP").val("");
			   $("#txtZCS").val(0); 
			   $("#txtLC").val(0);
			   $("#txtXZXS").val(0);
			   $("#txtNOTE").val("");
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}
//后台更新数据
function UpdData(){
	var czlx = 0;
	if($("#rdoCZLX1:checked").val()==1)
		czlx = 1;
//	var ywdt=0;
//	if($("#rdoYWDT1:checked").val()==1)
//		ywdt = 1;
	$.ajax({
		   type: "GET",
		   cache: false,
		   url: "EDITT00355.action",
		   data: {txtPSSD:$("#txtPSSD").val(), 
					txtLC:$("#txtLC").val(), 
					txtZCS:$("#txtZCS").val(), 
					ddlSZQY:$("#ddlSZQY").val(), 
					ACT: 'U', 
					txtXZXS:$("#txtXZXS").val(), 
					txtNOTE:$("#txtNOTE").val(), 
					txtFWLX : $("#txtFWLX").val(),
					rdoCZLX: czlx,
					//rdoYWDT: ywdt,
					txtUPDATE:$("#txtUPDATE").val()},
		   success: function(msg){
			   $.notifyBar({cls: "success", html: '参数更新成功'});
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}