$(document).ready(function() {	
    if($("#FCIDD").val() != undefined){
	if($("#FCIDD").val() != ''){
		var a=$("#FCIDD").val();
		// alert(a);
		bindInfoValue(a);
	}
    }
    
    
  //未通过对话框
	if ($('#wc').length>0)
	{
	  $('#wc').dialog({
		title: "未通过信息",	
        closed: true,
        iconCls:"icon-search",
	       buttons:[{
				text:'查看未通过信息',
				iconCls:'icon-search',
				handler:function(){
	    	   showWin($("#FCIDD").val());
				}
			},{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#wc").dialog('close');
				}
			}]
		});
	};
	  
	  //已通过对话框
		if ($('#ww').length>0)
		{
		  $('#ww').dialog({
			title: "已通过信息",	
	        closed: true,
	        iconCls:"",
		       buttons:[{
					text:'传入金税三期',
					iconCls:'',
					handler:function(){
					sendDJZXML($("#FCIDD").val());
					}
				},{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						$("#ww").dialog('close');
					}
				}]
			});
		};
    
	$("#subBtn").click(function(){
		$("#s").window("open");
	});
	
	//查询对话框
	if ($('#s').length>0)
	{
	  $('#s').dialog({
		title: "确认数据",	
        closed: true,
        iconCls:"icon-ok",
	       buttons:[{
				text:'确认',
				iconCls:'icon-ok',
				handler:function(){
	    	   		$("#actCount").val("0");
	    	   		subData();
	    	   		$("#s").dialog('close');
				}
			},{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#s").dialog('close');
				}
			}]
		});
	};
	
	//受理对话框
	if ($('#w2').length>0)
	{
	  $('#w2').dialog({
		title: "确认数据",	
        closed: true,
        iconCls:"icon-ok",
	       buttons:[{
				text:'确认',
				iconCls:'icon-ok',
				handler:function(){			
	    	   		$("#actCount").val("1");
	    	   		subData();
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
	if ($('#pic').length>0)
	{
	  $('#pic').dialog({
			title: "选择图片",	
	        closed: true,
	        iconCls:"icon-ok",
		       buttons:[{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						$("#pic").dialog('close');
					}
				}]
			});
	};
	showYJG();
	
	//文本框的输入格式限制
	$("#txtDJRQ").mask("9999-99-99");
	$("#txtJYSJ").mask("9999-99-99");	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
//			txtZJHM: {required: true, maxlength : 300, myZJHM: true},
//		    txtNSRMC: {required: true, maxlength : 100},
		    txtZJLX: {required: true},
			txtLXDH: {maxlength : 13},
			txtXQDM: {required: true},
			ddlSZQY: {required: true},
			txtZCDZL: {required: true},
			txtZLC: {required: true, number: true, maxlength : 3},
			txtCLH: {required: true, maxlength : 50},
			txtNOTE: {maxlength : 200},
			txtFWLX: {required: true},
			txtGHYT: {required: true},
			txtJYLX: {required: true},
			txtJZJG: {required: true},
//			txtFCZH: {required: true},
		    txtJZMJ: {required: true, number: true, min:1, maxlength : 14},
			txtFH: {required: true, maxlength : 100},
			txtHDJG: {required: true, number: true, maxlength : 14, min:0},
			hidZHXZ: {myZHXZ: true}
		
		},
		messages:{
			txtZJHM:{myZJHM:"<img src='../images/exclamation.gif' align='absmiddle' title='证件号码格式不正确！'/>"},
			txtSZLC:{mySZLC:"<img src='../images/exclamation.gif' align='absmiddle' title='你输入的总层数小于所在层数！'/>"},
//			txtZLC:{myZLC:"<img src='../images/exclamation.gif' align='absmiddle' title='房屋类型与总楼层不匹配！'/>"},
			txtSWID:{mySWID:"<img src='../images/exclamation.gif' align='absmiddle' title='证件号码格式不正确！'/>"},
			hidZHXZ:{myZHXZ:"<img src='../images/exclamation.gif' align='absmiddle' title='综合修正有些项没有选择！'/>"},
			txtCSFZJHM:{myCSFZJHM:"<img src='../images/exclamation.gif' align='absmiddle' title='证件号码格式不正确！'/>"}
        }
	});	
	
	//这里定义了一个名为equal的规则
	//value是指当前校验域的值
	//element是指当前检验的域
	//param是指在rules中设定的参数
	//这三个参数会在进行校验时由系统自动带入
	$.validator.methods.mySZLC = function(value, element, param){
	    //在这里使用上面的三个参数进行校验
		if (value)
		{			
			//如果该对象不存在说明是添加。添加时不用判断。
			if (parseInt($("#txtZLC").val())>=parseInt(value))
				{
					return true;//如果当前域的值等于指定的参数就通过校验
				}
			
		}
	};
	
		//这里定义了一个名为equal的规则
	//value是指当前校验域的值
	//element是指当前检验的域
	//param是指在rules中设定的参数
	//这三个参数会在进行校验时由系统自动带入
	$.validator.methods.myZLC = function(value, element, param){
	    //在这里使用上面的三个参数进行校验
		if (value)
		{			
			//如果该对象不存在说明是添加。添加时不用判断。
		   //高层
		   if ($("#txtFWLX").val()==INFO_FWLX_03)
		   {
			   if (parseInt($("#txtZLC").val())>9)
				{
					return true;//如果当前域的值等于指定的参数就通过校验
				}
		   }//多层
		   else if ($("#txtFWLX").val()!=INFO_FWLX_07)
		   {
			   if (parseInt($("#txtZLC").val())<=9)
				{
					return true;//如果当前域的值等于指定的参数就通过校验
				}
		   }//非住宅
		   else
		   {
			   return true;
		   }
			
		}
	};
	
	$.validator.methods.mySWID = function(value, element, param){
	    //在这里使用上面的三个参数进行校验
		if (value)
		{
			if ($("#ACT").val()=="U")
			{
				return true;
			}
			var strs = value.split("、");
			for(var i=0; i<strs.length; i++){		
				//如果该对象不存在说明是添加。添加时不用判断。
				if (!checkSFZ($("#txtZJLXId").val(), strs[i]))
					{
					return false;
					}
			}
			return true;
		}
	};
	$.validator.methods.myZJHM = function(value, element, param){
	    //在这里使用上面的三个参数进行校验
		if (value)
		{		
			var strs = value.split("、");
			for(var i=0; i<strs.length; i++){
				//如果该对象不存在说明是添加。添加时不用判断。
				if (!checkSFZ($("#txtZJLXId").val(), strs[i]))
					{
					return false;
					}
			}
			return true;
		}
	};
	$.validator.methods.myCSFZJHM = function(value, element, param){
	    //在这里使用上面的三个参数进行校验
		if (value)
		{
			//如果该对象不存在说明是添加。添加时不用判断。			
			var strs = value.split("、");
			for(var i=0; i<strs.length; i++){		
				//如果该对象不存在说明是添加。添加时不用判断。
				if (!checkSFZ($("#txtCSFZJLX").val(), strs[i]))
					{
					return false;
					}
			}
			return true;
		}
	};
	$.validator.methods.myZHXZ = function(value, element, param){
		//在这里使用上面的三个参数进行校验
		var zhxz = $("#hidZHXZ").val();
		
		if (value)
		{
			//这里对数组循环判断
			var sValue = "";
			var sPValue = "";
			var TypeID = $(".ZHXZ option:selected");
			for(var i=0;i<TypeID.length;i++){            
				sValue = sValue + TypeID[i].value + ',';//这里得到复选框选中项的值
				sPValue = sPValue + $(TypeID[i]).attr("parentid") + ',';				
	        } 
			
			
			var zhxzList = zhxz.split(",") ;
			//var tmpI = true;
			for(var i=0; i<zhxzList.length; i++){
				if(sPValue.search(zhxzList[i] + ',')==-1){
					//alert("综合信息有些类型没有选择！");
					return false;
				}
			}
			$("#hidZHXZid").val(sValue);
			return true;
			
		}
		else
		{
			if (zhxz=="" || zhxz==null)
				return true;
		}
	};	

	//证件类型
	$("#spZJLX").click(function(){
		var infoID = $("#txtZJLXId").val();
		$("#hidSelect").val("ZJLX");
		openZJLXDialog(infoID, '#infoTreeDIV');
	});

	//输入证件类型代码获得类型
	$("#txtZJLXNm").blur(function(){
		var zjlxId = $("#txtZJLXNm").val();
		var flag = isNaN(zjlxId);
		if(zjlxId != ''){
			if (!flag)
				getZJLX(zjlxId, '#txtZJLXNm');
		}
		else
		{
			$("#txtZJLXId").val("");
		}
	});
	
	//承受房证件类型
	$("#spCSFZJLX").click(function(){
		var infoID = $("#txtCSFZJLX").val();
		$("#hidSelect").val("CSFZJLX");
		openZJLXDialog(infoID, '#infoTreeDIV');
	});

	//输入承受方证件类型代码获得类型
	$("#txtCSFZJLXNm").blur(function(){
		var csfzjlxId = $("#txtCSFZJLXNm").val();
		var flag = isNaN(csfzjlxId);
		if(csfzjlxId != ''){
			if (!flag)
				getZJLX(csfzjlxId, '#txtCSFZJLXNm');
		}
		else
		{
			$("#txtCSFZJLX").val("");
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
	
	// 交易类型
	$("#spJYLX").click(function(){
		$("#hidSelect").val("JYLX");
		var infoID = $("#txtJYLX").val();
		openJYLXDialog(infoID, '#infoTreeDIV');
	});

	//输入交易类型代码获得类型
	$("#txtJYLXTIP").blur(function(){
		var jylxId = $("#txtJYLXTIP").val();
		var flag = isNaN(jylxId);
		if(jylxId != ''){
			if (!flag)
				getJYLX(jylxId, '#txtJYLXTIP');
		}
		else
		{
			$("#txtJYLX").val("");
		}
	});
	
	// 建筑结构
	$("#spJZJG").click(function(){
		$("#hidSelect").val("JZJGT");
		var infoID = $("#txtJZJGT").val();
		openJZJGDialog(infoID, '#infoTreeDIV');
	});
	
	//输入建筑结构代码获得类型
	$("#txtJZJGTTIP").blur(function(){
		var jzjgId = $("#txtJZJGTTIP").val();
		var flag = isNaN(jzjgId);
		if(jzjgId != ''){
			if (!flag)
			getJZJG(jzjgId, '#txtJZJGTTIP');			
		}
		else
		{
			$("#txtJZJGT").val("");
		}
	});
	// 规划用途
	$("#spGHYT").click(function(){
		$("#hidSelect").val("GHYTT");
		var infoID = $("#txtGHYTT").val();
		openGHYTDialog(infoID, '#infoTreeDIV');
		//openSEZLDialog(infoID, '#infoTreeDIV');
	});
	
	//输入规划用途代码获得类型
	$("#txtGHYTTTIP").blur(function(){
		var ghytId = $("#txtGHYTTTIP").val();
		var flag = isNaN(ghytId);
		if(ghytId != ''){
			if (!flag)
			getGHYT(ghytId, '#txtGHYTTTIP');
			
		}
		else
		{
			$("#txtGHYTT").val("");
		}
	});
	// 综合修正
	$("#btnAddQTXZ").click(function(){
		var szqy = $("#ddlSZQY").val();
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请先选择所在区域' });
			$("#ddlSZQY").focus();
		} else {
			$("#hidSelect").val("QTXZ");
			openCGZKDialog('', "#infoTreeDIV");
		}
	});
	
	// 所在区域
	$("#ddlSZQY").change(function(){
		var szqy = $(this).val();
		setParentIds(szqy);
	});
	
	//绑定小区文本框改变事件
	bingXQChange("#txtXQTIP");
	
	
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
				if ($("#hidSelect").val() == "ZJLX") {
					selectValue = getSelectedZJLXValue();
					$("#txtZJLXId").val(selectValue);
					getZJLX(selectValue,'#txtZJLXNm');
					//选择证件类型后，验证证件号码是否有效
//					var zjlx =  $("#txtZJLX").val();
//					validateZjlxYxws(zjlx, "#txtSWID");
				}else if($("#hidSelect").val() == "CSFZJLX"){
					selectValue = getSelectedZJLXValue();
					$("#txtCSFZJLX").val(selectValue);
					getZJLX(selectValue,'#txtCSFZJLXNm');
				} else if ($("#hidSelect").val() == "XQ") {
					var szqy = $("#ddlSZQY").val();
					selectValue = getSelectedXQValue();
					$("#txtXQDM").val(selectValue);
					getXQ(szqy, selectValue, '#txtXQTIP');
					//根据选择小区带出相关信息
					//readXQinfo($("#txtXQDM").val());
				} else if ($("#hidSelect").val() == "JZJG") {
					selectValue = getSelectedJZJGValue();
					$("#txtJZJG").val(selectValue);
					getJZJG(selectValue,'#txtJZJGTIP');
				} else if ($("#hidSelect").val() == "FWLX") {
					selectValue = getSelectedFWLXValue();
					$("#txtFWLX").val(selectValue);
					getFWLX(selectValue, '#txtFWLXTIP');
					var szqy = $("#ddlSZQY").val();
					setParentIds(szqy);
					showYJG();
				} else if ($("#hidSelect").val() == "JYLX") {
					selectValue = getSelectedJYLXValue();
					$("#txtJYLX").val(selectValue);
					getJYLX(selectValue,'#txtJYLXTIP');
					showYJG();
				} else if ($("#hidSelect").val() == "JZJGT") {
					selectValue = getSelectedJZJGValue();
					$("#txtJZJGT").val(selectValue);
					getJZJG(selectValue,'#txtJZJGTTIP');
				} else if ($("#hidSelect").val() == "GHYTT") {
					selectValue =getSelectedGHYTValue();
					$("#txtGHYTT").val(selectValue);
					getGHYT(selectValue,'#txtGHYTTTIP');
					
					showYJG();
					//getSEZL(selectValue,'#txtGHYTTTIP');
				} else if($("#hidSelect").val() == "QTXZ"){
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

	//房产证号判断
	$("#txtFCZH").blur(function(){
		var fczh = $("#txtFCZH").val();
		if(fczh != '' && fczh != '无'){
			isExistFczh(fczh);
		}
	});
	
	//通过地址查询pgt00320表中的数据
	$("#sechQMSj").click(function(){
		
	});
		
	
});

	

//其它修正
function qtxzClick(obj) {
	var qtxz = $("#hidQTXZ").val();
	var selectQtxz = $(obj).attr("QTXZ") + ',';
	$("#hidQTXZ").val(qtxz.replace(selectQtxz, ''));
	$(obj).parent().remove();
	
	var parentqtxz = $("#hidPARENTQTXZ").val();
	var parentselectQtxz = $(obj).attr("PANENTQTXZ") + ',';
	$("#hidPARENTQTXZ").val(parentqtxz.replace(parentselectQtxz, ''));
};

//根据所在区域设置父类型隐藏域
function setZhxz(szqy,fwlx){
//	alert("setParentIds: "+szqy);	
	var DF = $("#txtDF").val();
	var CX = $("#txtCX").val();
	var CG = $("#txtCG").val();
	var fcid = $("#FCID").val();
	if (szqy=="") return;
	//清空综合修正隐藏域
	cleanZhxz();
	$("#loading").show();
	var url = "ZHXZT00320.action";
		var data = {ddlSZQY : szqy,
				FCID : fcid,
				txtFWLX: fwlx};		
		$.ajax({
			type: "POST",
			url: url,
			cache: false,
			data: data,
			dataType: "json",
			success: function(myMsg){				
				$("#tt1").html("");
				var data = myMsg.qtxzList;
				$.each(data, function(i, n){
					if (n.qtxznm == DF)
					{n.isId=true;}
					if (n.qtxznm == CX)
					{n.isId=true;}
					if (n.qtxznm == CG)
					{n.isId=true;}	
					addZHXZ(n.cd00053Qtxzid,n.parentId,n.qtxznm,n.isDir,n.isId);
				});
			},
			complete:function()
	        {
				$("#loading").hide();
	        },
			error: function(){
				$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
			}
		});
}

//判断房产证号是否存在
function isExistFczh(FCZH){
	var url = "ISEXISTFCZH.action";
	var data = {FCZH : FCZH};

	$.ajax({
		type: "GET",
		url: url,
		cache: false,
		data: data,
		dataType: "json",
		success: function(myMsg){
			var msg = myMsg.ISEXISTFCZH;
			var bean = myMsg.v00302Bean;
			if(msg){
//				$.notifyBar({cls:"warning", html: '房产证号已存在，请确认！'});
				$("#ISEXISTFCZH").val(true);
				$("#txtSWID").val(formatString(bean.zjhm));
				$("#txtNSRMC").val(formatString(bean.nsrmc));
				$("#txtZJLXNm").val(formatString(bean.zjlx));
				$("#txtZJLXId").val(formatString(bean.cd00001Zjlx));
				$("#txtLXDH").val(formatString(bean.lxdh));
				$("#txtBWJFH").val(formatString(bean.bwjfh));
				$("#txtSZLC").val(formatString(bean.szlc));
				$("#txtJZMJ").val(formatString(bean.jzmj));
				$("#txtJYJG").val(formatString(bean.jyjg));
				$("#txtJZJGTTIP").val(formatString(bean.jzjg));
				$("#txtJYLXTIP").val(formatString(bean.jylx));
				$("#txtFWLXTIP").val(formatString(bean.fwlx));
				$("#txtDJRQ").val(formatDate(bean.djrq));
				$("#txtJZJGT").val(formatString(bean.cd00001Jzjg));
				$("#txtJYLX").val(formatString(bean.cd00001Jylx));
				$("#txtFWLX").val(formatString(bean.cd00001Fwlx));				
				$("#txtZCDZL").val(formatString(bean.fwtdzl));
				$("#txtBWJFH").blur();
				$("#txtZCDZL").blur();
			}else{
				$("#ISEXISTFCZH").val(false);
			}
		},
		error: function(){
			$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		}
	});
}

//格式化部位及房号
function defineBWJFH(obj){
//	var bwjfhLength = $(obj).val().length;
//	if(bwjfhLength == 1){
//		$(obj).val($(obj).val()+"-");
//	}
//	$(obj).val($(obj).val().toUpperCase());
}

//根据二手房和住宅显示原价格
function showYJG(){
	//$("#divYJG").hide();
	$("#divSBPGJG").hide();
	//$("#txtYJG").attr("disabled","disabled");
	$("#txtSBPGJG").attr("disabled","disabled");
//	if(($("#txtGHYTT").val() == "01")  && ($("#txtJYLX").val() == "012")){
//		$("#txtYJG").removeAttr("disabled");
//		$("#divYJG").show();		
//	}
	if(($("#txtFWLX").val() == INFO_FWLX_07)){
		$("#txtSBPGJG").removeAttr("disabled");
		$("#divSBPGJG").show();
	}
	
}

function subData(){
	
	$.ajax({
		type : 'POST',
		url : 'EDITT003711.action',
		cache : false,
		data : {
				FCIDSUB : $("#FCIDSUB").val(),
				INFOMSGSUB : $("#INFOMSGSUB").val(),
				actCount : $("#actCount").val(),
				OINSID : $("#OINSID").val()
		},
		dataType : 'json',
		success : function(resMsg){
			if(resMsg.resSign == "warning"){
				$.notifyBar({cls : 'warning', html : resMsg.resMsg});
				$("#w2").window('open');
			}else if(resMsg.resSign == "success"){
				$.notifyBar({cls : 'success', html : resMsg.resMsg});
				t = setTimeout('showWindow()',2000);
				
			}else if(resMsg.resSign == "error"){
				$.notifyBar({cls : 'error', html : resMsg.resMsg});
			}
			
		},
		error : function(){
			$.notifyBar({cls : 'error', html : '请求已发送，系统无响应'});
		}
	});
}

function showWindow(){
	window.location.href="../WS00001/VIEWWS00001.jsp";
	clearTimeout(t);
}

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

//function gjData(fcid){
//	$.ajax({
//		type : "POST",
//		url : "../xtwh/FINDT00351BZFCSY.action",
//		dataType : "json",
//		data : {
//
//			txtMONTHFind : $("#txtMONTHFind").val(),
//			txtYWJG : ywjg			
//		},
//		complete:function(){
//			$("#r").hide();
//        },
//		success: function(res){
//        	var beans = res.tabList;
//        	var sum = beans.length;
//        	var cntS = 0; cntF = 0;
//        	$.each(beans, function(i, b){ 
//            	$.ajax({
//            		type : "POST",
//            		url : "EXEV00351JSON.action",
//            		dataType : "json",
//            		data : {
//            			hidFlag : 1,
//            			chkSelTemp : b.slid,
//            			txtMONTHFind : $("#txtCSYF").val(),
//            			txtCSJYSJ : $("#txtCSJYSJ").val()
//            		},
//            		complete:function(){
//            			$('#p').progressbar('setValue', Math.floor(100*(cntS+cntF)/sum));
//            			if(cntS+cntF == sum){
//            				alert(测算执行完毕);
//            			}
//                    },
//            		success: function(data){
//            			cntS++;
//            		},
//            		error: function(aa,bb,cc){
//            			cntF++;
//            			//$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
//            		}
//            	});	        		
//        	});
//		},
//		error: function(aa,bb,cc){
//			$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
//		}
//	});	
//	
//};

/**
 * 录入数据直接评估
 * @param fwcx
 * @param infoid
 * @param rootid
 * @param szqy
 * @return
 */
function bindInfoValue(fcid){
	$.ajax({
		   type: "GET",
		   url: "../pg/EXECPG300011.action",
		   cache: false,
		   data: {hidFlag  : 1,
		          chkSel : fcid
		          },
		   dataType: "json",
		   success: function(rec){
              var bean= rec.v00302Bean;
               if(bean.bResult == 1){
            	   alert("评估已通过,点击确定进行打印通知单与传入金税三期操作！");
            	   $('#ww').window('open');	
				  
            	   
               }else{
            	   alert("评估未通过,点击确定查看原因！");
            	   $("#wc").window("open");
               }
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}
/**
 * 打印通知单
 * @param fwcx
 * @param infoid
 * @param rootid
 * @param szqy
 * @return
 */
function bindInfo(fcid){
	$.ajax({
		   type: "POST",
		   url: "../pg/EXECT00391.action",
		   cache: false,
		   data: {
		          FCID : fcid
		          },
		   dataType: "json",
		   success: function(rec){
//              var bean= rec.bf00000List;
//               if(bean.Fcid == fcid){
//            	   $.messager.alert('正确信息','打印通知单成功，可以进行完税确认','error');
//               }
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}

function sendDJZXML(fcid){
	$("#loading").show();
	$.ajax({
		type : "POST",
		cache : false,
		url : "../sjcj/SENDXMLI.action",
		dataType : "json",
		data : {
			FCID : fcid
		},
		complete:function()
        {
			$("#loading").hide();
        },
		success : function(msg){
			var bean = msg.t00370Bean;
			if (msg.resSign == '1')
			{
				$.messager.alert('错误信息','与接口连接失败','error');
			}
			else
			{
				if(bean.result_code == '0'){
					//$.notifyBar({cls: "success", html: bean.result_info});
					sendPGJG(fcid);
				}else{
					$.messager.alert('错误信息',bean.result_info,'error');
				}
			}			
		},
		error : function(){
			$.notifyBar({cls: "error", html: '请求已发送，系统无响应'});
		}
	});
}

function sendPGJG(fcid){
	$("#loading").show();
	$.ajax({
		type : "POST",
		cache : false,
		url : "../sjcj/DJZPGJGXML.action",
		dataType : "json",
		data : {
			FCID : fcid
		},
		complete:function()
        {
			$("#loading").hide();
        },
		success : function(msg){
			var bean = msg.t00370Bean;
			if(msg.resSign == '1'){
				$.messager.alert('错误信息','与接口连接失败','error');
			}
			else
			{
				if(bean.result_code == '0'){
					$.notifyBar({cls: "success", html: bean.result_info});
				}else{
					$.messager.alert('错误信息',bean.result_info,'error');
				}
			}			
		},
		error : function(msg){
			$.notifyBar({cls: "error", html: '请求已发送，系统无响应'});
		}
	});
}

function showWin(value){
	Show("../pg/FINDSCPGNGMX.action?txtSWIDFind="+value, 330, 400, value);
}

function sendDJZXML(zcdzl){
	$.ajax({
		type : "POST",
		cache : false,
		url : "../sjcj/FindPgtgSJ.action",
		dataType : "json",
		data : {
			txtZCDZL : zcdzl
		},
		success : function(msg){
			var bean = msg.t00370Bean;
			if (msg.resSign == '1')
			{
				$.messager.alert('错误信息','与接口连接失败','error');
			}
			else
			{
				if(bean.result_code == '0'){
					//$.notifyBar({cls: "success", html: bean.result_info});
					sendPGJG(fcid);
				}else{
					$.messager.alert('错误信息',bean.result_info,'error');
				}
			}			
		},
		error : function(){
			$.notifyBar({cls: "error", html: '请求已发送，系统无响应'});
		}
	});
}
//判断全面评估数据是否存在
function isExistQmpg(){
	var url = "ISEXISTQMPG.action";
	var data = {ddlSZQYFind : $("#ddlSZQY").val(),
				zcdzl : $("#txtZCDZL").val(),
				txtLH : $("#txtLH").val(),
				txtDYH : $("#txtDyh").val(),
				txtFH : $("#txtBWJFH").val()};
	$.ajax({
		type: "GET",
		url: url,
		cache: false,
		data: data,
		dataType: "json",
		success: function(myMsg){
			var msg = myMsg.ISEXISTQMPG;
			var bean = myMsg.v00302Bean;
			if(msg){
//				$.notifyBar({cls:"warning", html: '房产证号已存在，请确认！'});
				$("#ISEXISTFCZH").val(true);
				$("#txtSWID").val(formatString(bean.zjhm));
				$("#txtNSRMC").val(formatString(bean.nsrmc));
				$("#txtZJLXNm").val(formatString(bean.zjlx));
				$("#txtZJLXId").val(formatString(bean.cd00001Zjlx));
				$("#txtLXDH").val(formatString(bean.lxdh));
				$("#txtBWJFH").val(formatString(bean.bwjfh));
				$("#txtSZLC").val(formatString(bean.szlc));
				$("#txtJZMJ").val(formatString(bean.jzmj));
				$("#txtJYJG").val(formatString(bean.jyjg));
				$("#txtJZJGTTIP").val(formatString(bean.jzjg));
				$("#txtJYLXTIP").val(formatString(bean.jylx));
				$("#txtFWLXTIP").val(formatString(bean.fwlx));
				$("#txtDJRQ").val(formatDate(bean.djrq));
				$("#txtJZJGT").val(formatString(bean.cd00001Jzjg));
				$("#txtJYLX").val(formatString(bean.cd00001Jylx));
				$("#txtFWLX").val(formatString(bean.cd00001Fwlx));				
				$("#txtZCDZL").val(formatString(bean.fwtdzl));
				$("#txtBWJFH").blur();
				$("#txtZCDZL").blur();
			}else{
				$("#ISEXISTQMPG").val(false);
			}
		},
		error: function(){
			$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		}
	});
}