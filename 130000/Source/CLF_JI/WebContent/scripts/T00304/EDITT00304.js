$(document).ready(function() {

	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtSWID: {required: true, maxlength : 30},
			txtNSRMC: {required: true, maxlength : 50},
			ddlSZQY: {required: true},
			txtXQDM: {required: true, maxlength : 15},
			txtFWTDZL: {required: true, maxlength : 200},
			txtZLC: {required: true, number: true, maxlength : 3, min:1},
			rdoYWDT: {required: true},
			txtNOTE: {maxlength : 200},
			txtFWLX: {required: true, maxlength : 15},
			txtJYLX: {required: true, maxlength : 15},
			txtJZJG: {required: true, maxlength : 15},
//			txtFWCX: {required: true, maxlength : 15},
//			txtCGZK: {required: true, maxlength : 15},
			txtJZMJ: {required: true, number: true, min:1, maxlength : 14},
			txtSZLC: {required: true, number: true, maxlength : 3, mySZLC:true, min:1},
			//txtBWJFH: {maxlength : 100},
			txtTDSYQMJ: {required: true, number: true, maxlength : 14},
//			txtRJL: {required: true, number: true, maxlength : 16},
			txtJYJG: {required: true, number: true, maxlength : 14},
			txtDTGJ: {required: true, number: true, maxlength : 14},
			txtJYSJ: {required: true, dateISO: true},
			txtZBJG: {required: true, number: true, min:1, maxlength : 14},
			txtFDCDAT: {maxlength : 300},
			txtNOTET00302: {maxlength : 200},
			txtGPSJ:{required: true}
		},
		messages:{
			txtSZLC:{mySZLC:"<img src='../images/exclamation.gif' align='absmiddle' title='你输入的所在层数大于总层数！'/>"}
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

	// 小区代码
	$("#spXQDM").click(function(){
		var szqy = $("#ddlSZQY").val();
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请选择所在区域'});
			$("#ddlSZQY").focus();
		} else {
			$("#hidSelect").val("XQ");
			var xqdm = $("#txtXQDM").val();
			openXQMCDialog(szqy, xqdm, '#infoTreeDIV');
		}
	});

	// 房屋类型
	$("#spFWLX").click(function(){
		$("#hidSelect").val("FWLX");
		var infoID = $("#txtFWLX").val();
		openFWLXDialog(infoID, '#infoTreeDIV');		
	});

	// 交易类型
	$("#spJYLX").click(function(){
		$("#hidSelect").val("JYLX");
		var infoID = $("#txtJYLX").val();
		openJYLXDialog(infoID, '#infoTreeDIV');		
	});

	// 建筑结构
	$("#spJZJG").click(function(){
		$("#hidSelect").val("JZJG");
		var infoID = $("#txtJZJG").val();
		openJZJGDialog(infoID, '#infoTreeDIV');		
	});

	// 房屋朝向
	$("#spFWCX").click(function(){
		$("#hidSelect").val("FWCX");
		var infoID = $("#txtFWCX").val();
		openFWCXDialog(infoID, '#infoTreeDIV');		
	});

	// 采光状况
	$("#spCGZK").click(function(){
		$("#hidSelect").val("CGZK");
		var infoID = $("#txtCGZK").val();
		openCGZKDialog(infoID, '#infoTreeDIV');		
	});	
	
	/*
	// 其它修正
	$("#btnAddQTXZ").click(function(){
		var szqy = $("#ddlSZQY").val();
		var xzlx = $("#hidXZLX").val();
		if (szqy == null || szqy == "") {			
			$.notifyBar({html: '请选择所在区域'});
			$("#ddlSZQY").focus();
		} else {
			$("#hidSelect").val("QTXZ");
			openQTXZDialog(szqy, xzlx, '', "#infoTreeDIV");
		}
	});
	 */
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
				} else if ($("#hidSelect").val() == "JYLX") {
					selectValue = getSelectedJYLXValue();
					$("#txtJYLX").val(selectValue);
					getJYLX(selectValue,'#txtJYLXTIP');
				} else if ($("#hidSelect").val() == "FWCX") {
					selectValue = getSelectedFWCXValue();
					$("#txtFWCX").val(selectValue);
					getFWCX(selectValue,'#txtFWCXTIP');
				} else if ($("#hidSelect").val() == "CGZK") {
					selectValue = getSelectedCGZKValue();
					$("#txtCGZK").val(selectValue);
					getCGZK(selectValue,'#txtCGZKTIP');
				}/*else if($("#hidSelect").val() == "QTXZ"){
					var selectValue = getSelectedQTXZValue();
					var displayValue = getSelectedQTXZName();
					var szqy = $("#hidQTXZ").val();
					if (szqy.search(selectValue)==-1) {
						$("#ddlQTXZ").append(
								"<span class=\"qtxz\">" + displayValue
										+ " <a href=\"javascript:;\" QTXZ=\"" + selectValue
										+ "\" onclick=\"qtxzClick(this);\">[删]</a></span>");
						$("#hidQTXZ").val($("#hidQTXZ").val() + selectValue +',');
					}else{
						alert("已选择！");
					}
				}*/
			}
	       },{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#dialog").dialog('close');
				}
			}]
		});	


	// 判断房地产档案图是否已存在
	$("#txtFDCDAT").blur(function() {
		var info = $("#txtFDCDAT").val();
		if(info=="") return;
		
		var url = "FINDFDCDAT.action";
		var data = {FCID : $("#FCID").val(),
					txtFDCDAT: info};
		$.ajax( {
			type : "GET",
			url : url,
			cache : false,
			data : data,
			dataType : "json",
			success : function(msg) {
				var data = msg.forward;
				if(data){
					$("#lblFDCDAT").html("房地产档案图已存在");
				}else{
					$("#lblFDCDAT").html("");
				}
			},
			error : function() {
				$("#lblFDCDAT").val("");
			}
		});
	});
});
/*
//其它修正
function qtxzClick(obj) {
	var qtxz = $("#hidQTXZ").val();
	var selectQtxz = $(obj).attr("QTXZ")+',';
	$("#hidQTXZ").val(qtxz.replace(selectQtxz, ''));
	$(obj).parent().remove();
};*/