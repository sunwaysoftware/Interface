$(document).ready(function() {

	// 小区代码
	$("#spXQDM").click(XQDMclick);
	
	
	//小区模糊查询
	$("#txtXQCX").autocomplete("XQNMFIND.action", {
		max: 20,    //列表里的条目数
		width: 400,
		delay : 1000,
		minChars : 2,
		matchSubset : 1,
		matchContains : 1,
		cacheLength : 10,
		autoFill : false,
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
			'XQNM' : function() {if($("#isClocktZT").val()==0){return $("#txtXQCX").attr('value')}else{return '被锁定状态'};}
		}
	});
	
	//小区自动完成，选择后事件
	 $("#txtXQCX").result(function(event, data, formatted){
		 XQCXblur();
	 }); 
	 
	 $("#txtXQCX").blur(XQCXblur);	

	//楼房地址自动完成
//	 if($("#isClocktZT").val()==0){
		$("#txtZCDZL").autocomplete("FWTDZLFIND.action", {
			max: 20,    //列表里的条目数
			width: 400,
			delay : 1000,
			minChars : 2,
			matchSubset : 1,
			matchContains : 1,
			cacheLength : 0,
			autoFill : false,
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
			
				'txtZCDZL' : function() { if($("#isClocktZT").val()==0){return $("#txtZCDZL").attr('value')};},
				'ddlSZQY' : function() {if($("#isClocktZT").val()==0){return $("#ddlSZQY").attr('value')};},
				'txtZCDZType' : function() {return 3;}
			
			}
			 
		});	 
//	 };
//	 if($("#isClocktZT").val()==0){
			//楼号自动匹配
			$("#txtLH").autocomplete("LHDZFIND.action", {
				delay : 1000,
				minChars : 1,
				matchSubset : 1,
				matchContains : 1,
				cacheLength : 0,
				autoFill : false,
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
					'txtZCDZL' : function() {if($("#isClocktZT").val()==0){return $("#txtZCDZL").attr('value')};},
					'ddlSZQY' : function() {if($("#isClocktZT").val()==0){return $("#ddlSZQY").attr('value')};},
					'txtLH' : function() {if($("#isClocktZT").val()==0){return $("#txtLH").attr('value')};},
					'txtZCDZType' : function() {if($("#isClocktZT").val()==0){return 3};}
				}
			});	 
//		};
		//单元号自动匹配
//		 if($("#isClocktZT").val()==0){
			$("#txtDyh").autocomplete("DYHDZFIND.action", {
				delay : 1000,
				minChars : 1,
				matchSubset : 1,
				matchContains : 1,
				cacheLength : 0,
				autoFill : false,
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
					'txtZCDZL' : function() {if($("#isClocktZT").val()==0){return $("#txtZCDZL").attr('value')};},
					'ddlSZQY' : function() {if($("#isClocktZT").val()==0){return $("#ddlSZQY").attr('value')};},
					'txtLH' : function() {if($("#isClocktZT").val()==0){return $("#txtLH").attr('value')};},
					'txtDyh' : function() {if($("#isClocktZT").val()==0){return $("#txtDyh").attr('value')};},
					'txtZCDZType' : function() {if($("#isClocktZT").val()==0){return 3};}
				}
			});		
//		};
//		 if($("#isClocktZT").val()==0){
		//房号自动匹配
			$("#txtBWJFH").autocomplete("FHDZFIND.action", {
				delay : 1000,
				minChars : 1,
				matchSubset : 1,
				matchContains : 1,
				cacheLength : 0,
				autoFill : false,
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
					'txtZCDZL' : function() {if($("#isClocktZT").val()==0){return $("#txtZCDZL").attr('value')};},
					'ddlSZQY' : function() {if($("#isClocktZT").val()==0){return $("#ddlSZQY").attr('value')};},
					'txtLH' : function() {if($("#isClocktZT").val()==0){return $("#txtLH").attr('value')};},
					'txtDyh' : function() {if($("#isClocktZT").val()==0){return $("#txtDyh").attr('value')};},
					'txtBWJFH' : function() {if($("#isClocktZT").val()==0){return $("#txtBWJFH").attr('value')};}
					
				}
			});
//		};
		

});


function XQCXblur(){
	var xqnm = $("#txtXQCX").val();
	if (xqnm != "") {			
		var xqnmbat = $("#txtXQCX").attr("BAT");
		if (xqnmbat == xqnm)
		{
			return;
		}
		bindXQCXINFO();
				
	}
	else
	{
		$("#txtXQCX").attr("BAT","");
	}
}

function XQDMclick(){
	if($("#isExistQmpg").val()==1)
	{
		return;
	}
	var szqy = $("#ddlSZQY").val();
	if (szqy == null || szqy == "") {
		$.notifyBar({html: '请先选择所在区域' });
		$("#ddlSZQY").focus();
	} else {
		$("#hidSelect").val("XQ");
		var xqdm = $("#txtXQDM").val();
		openXQMCDialog(szqy, xqdm, '#infoTreeDIV');
	}
}


/**
 * 根据录入信息，后台请求楼房信息数据
 */
function bindLFXXValue(zcdzl,czl,objID,act){
	 $("#loading").show();
	$.ajax({
		type : "POST",
		url : "FINDT00303AJAX.action",
		cache : false,
		data : {txtZCDZL : zcdzl,	
				txtCLH : czl,	
				ACT : act,
				FROMCJ: $("#FROMCJ").val()
		},
		complete:function(){
			$("#loading").hide();
        },
		success: function(myMsg){
        	var obj=myMsg.v00303Bean;
        	if (obj.cd00001Szqy==null) return; 
        	
			//当房产得到数据时通过测量号没有找到时会出问题
			if (parseInt($("#tempZLC").val())>0)
			{
				$("#txtZLC").val($("#tempZLC").val());
			}
			$("#txtXQDM").val(obj.cd00352Xqdm);
			$("#txtXQTIP").val(obj.xqnm);
			$("#ddlSZQY").val(obj.cd00001Szqy);			
			setParentIds(obj.cd00001Szqy);

		},
		error: function(){
			$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		}
	});
};

/**
 * 绑定小区文本框事件(作用是当选择新建小区时，新建小区查询控件可用)
 * @param obj
 * @return
 */
function bingXQChange(obj){
//	alert("bingXQChange: "+$("#txtXQTIP").val() );
	$(obj).bind("propertychange",function(){
		setXjxq();
	
	});
	
	
}



//根据所在区域设置父类型隐藏域
function setParentIds(szqy){
	//alert("setParentIds: "+fwlx);
	var fwlx = $("#txtFWLX").val();
	if (szqy==""|| fwlx=="") return;
	
	setZhxz(szqy,fwlx);
	var url = "LOADPARENTBYSZQY.action";
		var data = {SZQY : szqy,FWLX:fwlx};		
		$.ajax({
			type: "GET",
			url: url,
			cache: false,
			data: data,
			dataType: "json",
			success: function(myMsg){
				var bean = myMsg.PARENTID;				
				$("#hidZHXZ").val(strIsEmpty(bean));
			},
			error: function(){
				$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
			}
		});
}
//根据所在区域设置父类型隐藏域
function setParentIdsQM(szqy){
	//alert("setParentIds: "+fwlx);
	var fwlx = $("#txtFWLX").val();
	if (szqy==""|| fwlx=="") return;
	
	setQMZhxz(szqy,fwlx);
	var url = "LOADPARENTBYSZQY.action";
		var data = {SZQY : szqy,FWLX:fwlx};		
		$.ajax({
			type: "GET",
			url: url,
			cache: false,
			data: data,
			dataType: "json",
			success: function(myMsg){
				var bean = myMsg.PARENTID;				
				$("#hidZHXZ").val(strIsEmpty(bean));
			},
			error: function(){
				$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
			}
		});
}

function setXjxq()
{
	//判断是否为新建小区，如果是则让新建小区名称可编辑
	var isFind = $("#txtXQTIP").val().indexOf("新建小区");
//	alert("bind: "+isFind);
	if(isFind != -1){
		 $("#xqcxDIV").show();   
//		$("#txtXJXQMC").attr("class","txtfocus");
		$("#txtXJXQMC").removeAttr("disabled");
	}else{
		 $("#xqcxDIV").hide();   
//		$("#txtXJXQMC").attr("class","txtNumber1");
		$("#txtXJXQMC").attr("disabled","disabled");
	}
}

////根据小区代码读取相关信息，包含所在大区代码，以及小区状态等
//function readXQinfo(xqdm){
////	alert("setParentdm: "+xqdm);
//	if (xqdm=="")
//		{
//		$("#hidPARENTDM").val("");
//		$("#hidXQZT").val("");
//		return;
//		}
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
//				$("#hidPARENTDM").val(bean.parentdm);
//				$("#hidXQZT").val(bean.xqzt);
//			},
//			error: function(){
//				$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
//			}
//		});
//}


//根据小区自动完成信息，后台请求楼房信息数据
function bindXQCXINFO(){
	$("#loading").show();
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
        	if (bean.cd00001Szqy == null)
    		{        		
        		$("#txtXQTIP").val("");
           	 	$("#txtXQDM").val("");
    		}
        	else
        	{
	        	 $("#ddlSZQY").val(bean.cd00001Szqy);
	        	//清空综合修正隐藏域
	        	 var szqy = $("#ddlSZQY").val();
	     		 setParentIds(szqy);
	     		 //readXQinfo(bean.xqdm);
	        	 $("#txtXQTIP").val(bean.xqnm);
	        	 $("#txtXQDM").val(bean.xqdm);
	        	//得到照片
				//showFcPic();
        	}
        	$("#txtXQCX").attr("BAT",$("#txtXQCX").val());
		},
		error: function(){
			$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		}
	});
};

//清空综合修正隐藏域
function cleanZhxz(){
	$("#hidQTXZ").val('');
	$("#hidPARENTQTXZ").val('');
	$("#hidZHXZ").val('');	
}
function ShowXQXX(){
	if($("#txtXQDM").val()!=''){
		 // $("#pic").dialog('open');
		 // $("#ipic").attr("src","../sjcj/DETAILT00352FC.action?txtXQDM="+$("#txtXQDM").val());
		  //window.location.href="../sjcj/DETAILT00352FC.action?txtXQDM="+$("#txtXQDM").val();
		  window.parent.addTabflash('小区图片','sjcj/DETAILT00352FC.action?txtXQDM='+$("#txtXQDM").val(),'mainFrameframe00352');
	}
	else{
		$.notifyBar({html: '请选择小区'});
	}
	
}

