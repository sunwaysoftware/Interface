$(document).ready(function() {
	
//	$( "#txtCSJYSJ" ).datepicker({
//		changeMonth: true,
//		changeYear: true
//	});
	
	// 添加
	$("#tjLink").click(function() {
		var b = false;
		$(".childCheck").each(function() {
			if ($(this)[0].checked) {
				b = true;
			}
		});
		if (!b) {
			alert('请选择要测算的数据！');
			return;
		}
		$("#hidFlag").val(1);
		var selvalue="";
		$("input[id='chkSell'][type=checkbox]:checked").each(function() { //由于复选框一般选中的是多个,所以可以循环输出
			selvalue = selvalue + $(this).val() + ",";
	    });
		$("#chkSelTemp").val(selvalue);
		$("#txtMONTHFind").val($("#txtCSYF").val());
		$("#txtCJAL").val();
//		var c = parseInt($("#txtCJAL").val());
//		var g = parseInt($("#txtGPAL").val());
//		var y = parseInt($("#txtYSF").val());
//		var z = parseInt($("#txtZJ").val());
//		if(c + g + y + z !=100){
//			alert('权重比数据总和为100%！');
//			return;
//		}
		$("#editForm").attr("action", "EXEV00351.action");
		$("#editForm").submit();
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
		txtCSYF : {required:true, number:true},
		txtCJAL : {required:true,number:true},
		txtGPAL : {required:true,number:true},
		txtYSF : {required:true,number:true},
		txtZJ : {required:true,number:true}
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
		if(fwlxId != '' && !flag){
			getFWLX(fwlxId, '#txtFWLXTIP');
			
		}
	});
//	$("table.scroll").grid();
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

	//房屋类型退格清除内容
		$("#txtFWLXTIP").blur(function(){
			var id = $("#txtFWLXTIP").val();
			var flag = isNaN(id);
			
			if(id == '' && !flag){
				
				$("#txtFWLXTIP").val("");
				$("#txtFWLX").val("");
			}
		});
	 //提交导出信息
/*	 $("#btnExportT00351CSY").click(function(){
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
	 });*/
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
		        	 tips = tips + formatDate(n.jysj)+'&nbsp&nbsp'+n.pfmjg + '<br/>';
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
//	BindData();
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
		type : "GET",
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
  //      	 $("#ddlSZQYFind").val(bean.cd00001Szqy);
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



function allCS(){
	var ywjg = -1;
	if($("#rdoYWJG0:checked").val()==0)
		ywjg = 0;
	if($("#rdoYWJG1:checked").val()==1)
		ywjg = 1;
	document.getElementById('hidFlag').value='2';
	$("#txtMONTHFind").val($("#txtCSYF").val());
//	$("#txtXQFind").val($("#txtXQFind").val());
//	$("#txtSLIDFind").val($("txtSLIDFind").val());
	$("#txtZCDZL").val($("#txtXQCX").val());
	$("#txtFWLXCS").val($("#txtFWLX").val());
	$("#ddlSZQYCS").val($("#ddlSZQYFind").val());
	$("#txtYWJG").val(ywjg);
	AppSubmit();
}

function csAllData(){
	if (!$("#editForm").valid()) return;
	
	var ywjg = -1;
	if($("#rdoYWJG0:checked").val()==0)
		ywjg = 0;
	if($("#rdoYWJG1:checked").val()==1)
		ywjg = 1;
	$("#r").show();
	$.ajax({
		type : "POST",
		url : "../xtwh/FINDT00351BZFCSY.action",
		dataType : "json",
		data : {
			pageIndex : 1,
			pageSize : -1,
			ddlSZQYFind : $("#ddlSZQYFind").val(),
			txtXQFind : $("#txtXQFind").val(),
			txtZCDZL : $("#txtXQCX").val(),
			txtFWLX : $("#txtFWLX").val(),
			txtCSYF : $("#txtCSYF").val(),
			txtSLIDFind : $("#txtSLIDFind").val(),
			txtMONTHFind : $("#txtMONTHFind").val(),
			rdoYWJG : ywjg			
		},
		complete:function(){
			$("#r").hide();
        },
		success: function(res){
        	var beans = res.tabList;
        	var sum = beans.length;
        	var cntS = 0; cntF = 0;
        	$.each(beans, function(i, b){ 
            	$.ajax({
            		type : "POST",
            		url : "EXEV00351JSON.action",
            		dataType : "json",
            		data : {
            			hidFlag : 1,
            			chkSelTemp : b.slid,
            			txtMONTHFind : $("#txtCSYF").val(),
            			txtCSJYSJ : $("#txtCSJYSJ").val(),
            			txtCJAL : $("#txtCJAL").val(),
            			txtGPAL : $("#txtGPAL").val(),
            			txtYSF : $("#txtYSF").val(),
            			txtZJ : $("#txtZJ").val()
            		},
            		complete:function(){
            			$('#p').progressbar('setValue', Math.floor(100*(cntS+cntF)/sum));
            			if(cntS+cntF == sum){
            				alert("测算执行完毕");
            			}
                    },
            		success: function(data){
            			cntS++;
            		},
            		error: function(aa,bb,cc){
            			cntF++;
            			//$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
            		}
            	});	        		
        	});
		},
		error: function(aa,bb,cc){
			$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		}
	});	
	
};
