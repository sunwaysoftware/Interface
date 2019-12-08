$(document).ready(function() {
	//FROM验证信息
	$("#uploadForm").validate({
		rules: {
			upload: {required: true}
		}
	});
	//FROM验证信息
	$("#editForm").validate({
		rules: {
		txtCSJYSJ: {required: true},
		txtCSYF : {required:true,number: true}
		}
	});
	// 房屋类型
	$("#spFWLX").click(function(){
		$("#hidSelect").val("FWLX");
		var infoID = $("#txtFWLX").val();
		openFWLXDialog(infoID, '#infoTreeDIV');
	});

	//查询
		$("#subA").click(function(){
			$('#w').window('open');	
			$("#sxkz").show();
		});
	//导出
	$("#subB").click(function(){
		var bzfjg = -1;
		 if($("#rdoYWJG0:checked").val()==0)
			 bzfjg = 0;
		 if($("#rdoYWJG1:checked").val()==1)
			 bzfjg = 1;
		 
		 $("#txtCSYFE").val($("#txtCSYF").val());
		 $("#txtSZQYE").val($("#ddlSZQYFind").val());
		 $("#txtXQNME").val($("#txtXQCX").val());
		 $("#txtFWLXE").val($("#txtFWLX").val());
		 $("#txtBZFJG").val(bzfjg);
			$("#findForm").submit();
		});
	//输入房屋类型代码获得类型
	$("#txtFWLXTIP").blur(function(){
		var fwlxId = $("#txtFWLXTIP").val();
		var flag = isNaN(fwlxId);
		if(fwlxId != '' && !flag){
			getFWLX(fwlxId, '#txtFWLXTIP');
			
		}
	});
	//$("table.scroll").grid();
	//查询
	$("#btnSearch").click(function(){
		$("#pageindex").val(1);
		BindData();
	});	
	
	$('.rootCheck').click(function(){ 		
		$(".childCheck").each(function(){	
			$(this)[0].checked=$('.rootCheck')[0].checked;
		});			
	});
	$("#ddlSZQYFind").change(function(){
		$("#txtXQFind").val("");
		getDivXqmcData($('#ddlSZQYFind').val(), '', '#T00352Tree');
	});

	$("#dialog").dialog({
		modal: true,
        shadow: true,
        closed: true,
	       buttons:[{
				text:'选择',
				iconCls:'icon-ok',
				handler:function(){	 
	    	  
	    		   $("#dialog").dialog("close");
	    		   if ($("#hidSelect").val() == "FWLX") {
						selectValue = getSelectedFWLXValue();
						$("#txtFWLX").val(selectValue);
						getFWLX(selectValue, '#txtFWLXTIP');
						//isDisplayDiv(selectValue);
						//validateZLC(selectValue,$("#txtZLC").val());
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
	// 所在区域
	$("#ddlSZQY").change(function(){
		var szqy = $("#ddlSZQY").val();
		//清空综合修正隐藏域
		cleanZhxz();
		setParentIds(szqy);
	});

	// 小区代码
	$("#spXQDM").click(function(){
		var szqy = $("#ddlSZQY").val();
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请先选择所在区域' });
			$("#ddlSZQY").focus();
		} else {
			$("#hidSelect").val("XQ");
			var xqdm = $("#txtXQDM").val();
			openXQMCDialog(szqy, xqdm, '#infoTreeDIV');
		}
	});
	//小区模糊查询
	$("#txtXQCX").autocomplete("XQNMFIND.action", {
		delay : 1000,
		minChars : 1,
		matchSubset : 1,
		matchContains : 1,
		cacheLength : 10,
		autoFill : false,
		max: 20,
		scroll: true,
	    scrollHeight: 180,
	    
		formatItem : function(data, i, total) {
			return data[0];
		},
		formatMatch : function(data, i, total) {
			return data[0];
		},
		formatResult : function(data) {
			return data[0];
		},
		extraParams : {
			'XQNM' : function() {return $("#txtXQCX").attr('value');}
		}
	});
	//小区自动完成，选择后事件
	 $("#txtXQCX").result(function(event, data, formatted){
      	var xqnm = $("#txtXQCX").val();
		if (xqnm != "") {
			bindXQCXINFO();
		}
   });
	//提交导出信息
	 $("#btnExportT00351CSN").click(function(){
		 var bzfjg = -1;
		 if($("#rdoYWJG0:checked").val()==0)
			 bzfjg = 0;
		 if($("#rdoYWJG1:checked").val()==1)
			 bzfjg = 1;
		 
		 $("#txtCSYFE").val($("#txtCSYF").val());
		 $("#txtSZQYE").val($("#ddlSZQYFind").val());
		 $("#txtXQNME").val($("#txtXQCX").val());
		 $("#txtFWLXE").val($("#txtFWLX").val());
		 $("#txtBZFJG").val(bzfjg);
		 $("#expForm").submit();
	 });
	 
	//房屋类型退格清除内容
		$("#txtFWLXTIP").blur(function(){
			var id = $("#txtFWLXTIP").val();
			var flag = isNaN(id);
			
			if(id == '' && !flag){
				
				$("#txtFWLXTIP").val("");
				$("#txtFWLX").val("");
			}
		});
});



function MyTip(obj,arg)
{    
	var tips = $(obj).attr("TIPS");
	if (tips===undefined)
	{		
		var data = {pageIndex : 1,SLID : arg};
		$.ajax({
			   type: "GET",
			   url: "../xtwh/VIEWBZFJG.action",
			   cache: false,
			   data: data,
			   dataType: "json",
			   complete:function()                                                    
	           {
	        	   Tip(obj,'&nbsp&nbsp基准时点&nbsp&nbsp&nbsp&nbsp&nbsp价格&nbsp&nbsp',tips);
	       		   return true;	 
					
	           },
			   success: function(msg){				
			     var data = msg.tabList;
			     tips = '';
		         $.each(data, function(i, n){ 	
		        	 tips = tips  +formatDate(n.jysj) +'&nbsp&nbsp'+n.pfmjg + '<br/>';
		          });
		         $(obj).attr("TIPS",tips);
			   },
			   error: function(){
				   
			   }
		});	
	}
	else
	{
		Tip(obj,'&nbsp&nbsp基准时点&nbsp&nbsp&nbsp&nbsp&nbsp价格&nbsp&nbsp',tips);
		return true;	 
	}
}


//数据变更
function execInfoBg(fcid){
	if(!window.confirm("数据变更操作，将把数据退回到初始状态，是否确认操作？")) return;
	
	var url = "../pg/EXECINFOBG.action";
	var data = {FCID : fcid};
	$.ajax({
		   type: "GET",
		   url: url,
		   cache: false,
		   data: data,
		   dataType: "json",
		   complete:function() {
				$("#loading").hide();
           },
		   success: function(msg){
		     var data = msg.bgFlag;
		     if(data)
		 		$.notifyBar({cls: "success", html: '数据变更操作成功执行完毕，请通知录入人员进行数据修改'});
		     else
		    	$.notifyBar({cls: "warning", html: '数据变更操作失败，请重试' });
		    //重新读取数
		     BindData();
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
	
}
//根据选项，请求action作编辑用
function getXQRdoValue(infoid,infonm){
	//判断点击的单选按钮类型，根据单选按钮类型，为隐藏域赋值
	$("#TIPXQMC").text(infonm);
	$("#XQDM").val(infoid);
	$("#txtXQFind").val(infoid);
	$("#pageindex").val(1);
	//BindData();
};
/**
 * 根据录入信息，后台请求楼房信息数据
 
function bindLFXXValue(zcdzl, objID){
	$.ajax({
		type : "GET",
		url : "FINDT00303AJAX.action",
		cache : false,
		data : {txtZCDZL : zcdzl,	
				ACT : $("#ACT").val(),
				FROMCJ: $("#FROMCJ").val()},
		complete:function()
        {
        },
		success: function(res){
			$(objID).html(res);
			setParentIds($(objID).find("#ddlSZQY").val());
			if($("#FROMCJ").val()){
				//重新初始化页面时，为小区名称文本框增加改变事件
				bingXQChange($(objID).find("#txtXQTIP"));
			}
		},
		error: function(){
			$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		}
	});
};
*/
//根据小区自动完成信息，后台请求楼房信息数据
function bindXQCXINFO(){
	var url = "LOADXQIFBYXQNM.action";
	var data = {XQNM : $("#txtXQCX").val(),	
				ACT : $("#ACT").val(),
				FROMCJ: $("#FROMCJ").val()};
	$.ajax({
		type : "POST",
		url : url,
		cache : false,
		data : data,
		dataType: "json",
		complete:function()
        {
		$("#loading").hide();
        },
		success: function(res){
        	var bean = res.t00352Bean;
 //       	 $("#ddlSZQYFind").val(bean.cd00001Szqy);
 //       	 $("#txtXQFind").val(bean.xqdm);
//        	//清空综合修正隐藏域
//        	 var szqy = $("#ddlSZQY").val();
//     		 cleanZhxz();
//     		 setParentIds(szqy);
//     		
//        	 $("#txtXQTIP").val(formatString(bean.xqnm));
//        	 $("#txtXQDM").val(formatString(bean.xqdm)); 
//        	 $("#txtJCNF").val(formatString(bean.jcnf));
		},
		error: function(){
			$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		}
	});
};








