$(document).ready(function() {
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtSWID: {maxlength : 30},
			txtNSRMC: {maxlength : 100},
			txtZJLX: {required: true},
			txtXQDM: {required: true},
			ddlSZQY: {required: true},
			txtZCDZL: {required: true},
			txtZLC: {required: true, number: true, maxlength : 3},
			txtCLH: { maxlength : 50},//required: true,
			rdoYWDT: {required: true},
			txtNOTE: {maxlength : 200},
			txtFWLX: {required: true},
			txtJYLX: {required: true},
			txtJZJGT: {required: true},
//			txtFCZH: {required: true},
			txtJZMJ: {required: true, number: true, min:1, maxlength : 14},
			txtSZLC: {required: true, number: true, maxlength : 3, mySZLC:true, min:1},
			txtBWJFH: {required: true, maxlength : 100},
			txtTDSYQMJ: {required: true, number: true, maxlength : 14},
			txtPGJG: {required: true, number: true, min:1, maxlength : 14},
			txtJYSJ: {required: true, dateISO: true},
			txtFDCDAT: {maxlength : 300},
			txtNOTET00357: {maxlength : 200},
			txtDJRQ: {required: true, dateISO: true},
			txtXJXQMC : {required: true},
			hidZHXZ: {myZHXZ: true}
//			txtLH : {required: true},
//			txtDYH : {required: true}
		},
		messages:{
			txtSZLC:{mySZLC:"<img src='../images/exclamation.gif' align='absmiddle' title='你输入的总层数小于所在层数！'/>"},
			txtSWID:{mySWID:"<img src='../images/exclamation.gif' align='absmiddle' title='证件号码格式不正确！'/>"},
			hidZHXZ:{myZHXZ:"<img src='../images/exclamation.gif' align='absmiddle' title='综合修正有些项没有选择！'/>"}
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
				return true;//如果当前域的值等于指定的参数就通过校验
		}
	};
	//这里定义了一个名为equal的规则
	//value是指当前校验域的值
	//element是指当前检验的域
	//param是指在rules中设定的参数
	//这三个参数会在进行校验时由系统自动带入
	$.validator.methods.mySWID = function(value, element, param){
	    //在这里使用上面的三个参数进行校验
		if (value)
		{
			//如果该对象不存在说明是添加。添加时不用判断。			
			var strs = value.split("、");
			for(var i=0; i<strs.length; i++){		
				//如果该对象不存在说明是添加。添加时不用判断。
				if (!checkSFZ($("#txtZJLX").val(), strs[i]))
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
	//税务登记代码
//	$("#txtSWID").blur(function(){
//		var userId = $("#txtSWID").val();
//		if(userId!=""){
//			ReadT12006(userId,"#txtNSRMC");
//		}
//	});	
	

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
				if ($("#hidSelect").val() == "XQ") {
					var szqy = $("#ddlSZQY").val();
					selectValue = getSelectedXQValue();
					$("#txtXQDM").val(selectValue);
					getXQ(szqy, selectValue, '#txtXQTIP');
				} else if ($("#hidSelect").val() == "JZJG") {
					selectValue = getSelectedJZJGValue();
					$("#txtJZJG").val(selectValue);
					getJZJG(selectValue,'#txtJZJGTIP');
				} else if ($("#hidSelect").val() == "FWLX") {
					selectValue = getSelectedFWLXValue();
					$("#txtFWLX").val(selectValue);
					getFWLX(selectValue, '#txtFWLXTIP');
					var szqy = $("#ddlSZQY").val();
					var id = $("#SLID").val();
					setParentIds(szqy);
				} else if ($("#hidSelect").val() == "JYLX") {
					selectValue = getSelectedJYLXValue();
					$("#txtJYLX").val(selectValue);
					getJYLX(selectValue,'#txtJYLXTIP');
				} else if ($("#hidSelect").val() == "JZJGT") {
					selectValue = getSelectedJZJGValue();
					$("#txtJZJGT").val(selectValue);
					getJZJG(selectValue,'#txtJZJGTTIP');
				}else if($("#hidSelect").val() == "QTXZ"){
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
//				else if($("#hidSelect").val() == "QTXZ"){
//					var selectValue = getSelectedQTXZValue();
//					var displayValue = getSelectedQTXZName();
//					var szqy = $("#hidQTXZ").val();
//					if (szqy.search(selectValue)==-1) {
//						$("#ddlQTXZ").append(
//								"<span class=\"qtxz\">" + displayValue
//										+ " <a href=\"javascript:;\" QTXZ=\"" + selectValue
//										+ "\" onclick=\"qtxzClick(this);\">[删]</a></span>");
//						$("#hidQTXZ").val($("#hidQTXZ").val() + selectValue +',');
//					}else{
//						alert("已选择！");
//					}
//				}
			}
        },{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				$("#dialog").dialog('close');
			}
		}]
	});	

//	$("#ddlSZQY").change(function(){
//		alert(0);
//	});
//		
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
	
});



//其它修正
function qtxzClick(obj) {
	var qtxz = $("#hidQTXZ").val();
	var selectQtxz = $(obj).attr("QTXZ")+',';
	$("#hidQTXZ").val(qtxz.replace(selectQtxz, ''));
	$(obj).parent().remove();
	
	var parentqtxz = $("#hidPARENTQTXZ").val();
	var parentselectQtxz = $(obj).attr("PANENTQTXZ") + ',';
	$("#hidPARENTQTXZ").val(parentqtxz.replace(parentselectQtxz, ''));
};


//根据所在区域设置父类型隐藏域
function setZhxz(szqy,fwlx){
//	alert("setParentIds: "+szqy);
	var fcid = $("#SLID").val();
	if (szqy=="") return;
	//清空综合修正隐藏域
	cleanZhxz();
	$("#loading").show();
	var url = "ZHXZT00357.action";
		var data = {ddlSZQY : szqy,
				SLID : fcid,
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

//格式化部位及房号
function defineBWJFH(obj){
//	var bwjfhLength = $(obj).val().length;
//	if(bwjfhLength == 1){
//		$(obj).val($(obj).val()+"-");
//	}
//	$(obj).val($(obj).val().toUpperCase());
}