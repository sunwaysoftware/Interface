$(document).ready(function() {

	//$("#txtJYSJ").mask("9999-99-99");
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtXQDM: {required: true},
			ddlSZQY: {required: true},
			//txtZCDZL: {required: true},
			txtZLC: {required: true, number: true, maxlength : 3},
			//txtCLH: {required: true, number: true, maxlength : 50},
			txtJCNF: {required: true,number: true, maxlength : 4},
			//rdoYWDT: {required: true},
			txtNOTE: {maxlength : 200},
			txtFWLX: {required: true, maxlength : 15},
			txtJZJGT: {required: true},
			//txtSZLC: {required: true, number: true, maxlength : 3,  min:1,mySZLC:true},
			txtBWJFH: {required: true, maxlength : 100},
			txtSZLC: {required: true, number: true, maxlength : 3},
			txtPFMJG: {required: true, number: true, min:1, maxlength : 14},
			txtJYSJ: {required: true, dateISO: true},
			txtNOTET00351: {maxlength : 200}
			//hidZHXZ: {myZHXZ: true}
			},
			messages:{
				txtSZLC:{mySZLC:"<img src='../images/exclamation.gif' align='absmiddle' title='你输入的总层数小于所在层数！'/>"},
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
					{
				//alert($("#rdoYWDT1:checked").val());
//					if (parseInt(value)>=9&&$("#rdoYWDT1:checked").val()!="true")
//					{
//					return false;//如果当前域的值等于指定的参数就通过校验
//					}
					return true;//如果当前域的值等于指定的参数就通过校验
				}
			
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
				} else if ($("#hidSelect").val() == "JYLX") {
					selectValue = getSelectedJYLXValue();
					$("#txtJYLX").val(selectValue);
					getJYLX(selectValue,'#txtJYLXTIP');
				} else if ($("#hidSelect").val() == "JZJGT") {
					selectValue = getSelectedJZJGValue();
					$("#txtJZJGT").val(selectValue);
					getJZJG(selectValue,'#txtJZJGTTIP');
				} else if ($("#hidSelect").val() == "FWCX") {
					selectValue = getSelectedFWCXValue();
					$("#txtFWCX").val(selectValue);
					getFWCX(selectValue,'#txtFWCXTIP');
				} else if ($("#hidSelect").val() == "CGZK") {
					selectValue = getSelectedCGZKValue();
					$("#txtCGZK").val(selectValue);
					getCGZK(selectValue,'#txtCGZKTIP');
				} else if ($("#hidSelect").val() == "JTZK") {
					selectValue = getSelectedJTZKValue();
					$("#txtJTZKId").val(selectValue);
					getJTZK(selectValue,'#txtJTZKNm');
				} else if ($("#hidSelect").val() == "WYZK") {
					selectValue = getSelectedWYZKValue();
					$("#txtWYZKId").val(selectValue);
					getWYZK(selectValue,'#txtWYZKNm');
				} else if ($("#hidSelect").val() == "ZXZK") {
					selectValue = getSelectedZXZKValue();
					$("#txtZXZKId").val(selectValue);
					getZXZK(selectValue,'#txtZXZKNm');
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
	/*var fcid = $("#SLID").val();
	if (szqy=="") return;
	//清空综合修正隐藏域
	cleanZhxz();
	$("#loading").show();
	var url = "ZHXZT00351.action";
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
		});*/
}


