$(document).ready(function() {
	
	$("#editSL").click(function(){
		
		editSLInfo();
	});
	
	//文本框的输入格式限制
	$("#txtFZRQEDIT").mask("9999-99-99");
	$("#txtJYSJEDIT").mask("9999-99-99");
	//FROM验证信息
	$("#editForm").validate({
		rules: {
		    txtZRFSFIDEDIT: {required: true, maxlength : 30, myZRFSWID: true},
		    txtCSFSFIDEDIT: {required: true, maxlength : 30, myCSFSWID: true},
		    txtZRFMCEDIT: {required: true, maxlength : 100},
		    txtCSFMCEDIT: {required: true, maxlength : 100},
			txtZRFSFLXEDIT: {required: true},
			txtCSFSFLXEDIT: {required: true},
			txtCLHEDIT: {required: true},
			txtLFDZEDIT: {required: true},
			txtDYFHEDIT: {required: true},
			txtSZLCEDIT: {required: true, number: true, maxlength : 3,min:1,mySZLC:true},
			txtZLCEDIT: {required: true, number: true, maxlength:3},
			txtJZJGTTIP: {required: true},
			txtGHYTTTIP: {required: true},
			txtYFCZHEDIT: {required: true},
			txtJZMJEDIT : {required: true,number: true, min:1, maxlength : 14},
			txtJYJGEDIT : {required: true,number: true, min:1, maxlength : 14},
			txtJYSJEDIT : {required: true,dateISO: true},
			txtJYLXTIP : {required: true},
			txtFWLXTIP : {required: true},
			txtFZRQEDIT : {required: true,dateISO: true},
			txtYJGEDIT : {required: true, number: true},
			txtPGJGEDIT: {required:true,number:true},
			txtLXDH: {maxlength : 13},
			txtYDDH: {maxlength : 11},						
			ddlSZQY: {required: true},
			hidZHXZ: {myZHXZ: true}
		},
		messages:{
			txtSZLCEDIT:{mySZLC:"<img src='../images/exclamation.gif' align='absmiddle' title='你输入的总层数小于所在层数！'/>"},
			txtZRFSFIDEDIT:{myZRFSWID:"<img src='../images/exclamation.gif' align='absmiddle' title='证件号码格式不正确！'/>"},
			txtCSFSFIDEDIT:{myCSFSWID:"<img src='../images/exclamation.gif' align='absmiddle' title='证件号码格式不正确！'/>"},
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
	
	$.validator.methods.myZRFSWID = function(value, element, param){
		//alert($("#txtZJLXNm").val());
	    //在这里使用上面的三个参数进行校验
		if (value)
		{
			//如果该对象不存在说明是添加。添加时不用判断。
			if ($("#txtZJLXNm").val()=="身份证")//身份证
			{	
				if (value.length==15 || value.length==18)
					return true;//如果当前域的值等于指定的参数就通过校验				
			}
			else if ($("#txtZJLXNm").val()=="军官证")//军官证
			{	
				if (value.length==8)
					return true;//如果当前域的值等于指定的参数就通过校验
			}
			else if ($("#txtZJLXNm").val()=="护照")//军官证
			{	
				if (value.length==8)
					return true;//如果当前域的值等于指定的参数就通过校验
			}
			else 
			{
				return true;
			}
		}
	};
	
	$.validator.methods.myCSFSWID = function(value, element, param){
		//alert($("#txtCSFZJLXNm").val());
	    //在这里使用上面的三个参数进行校验
		if (value)
		{
			//如果该对象不存在说明是添加。添加时不用判断。
			if ($("#txtCSFZJLXNm").val()=="身份证")//身份证
			{	
				if (value.length==15 || value.length==18)
					return true;//如果当前域的值等于指定的参数就通过校验				
			}
			else if ($("#txtCSFZJLXNm").val()=="军官证")//军官证
			{	
				if (value.length==8)
					return true;//如果当前域的值等于指定的参数就通过校验
			}
			else if ($("#txtCSFZJLXNm").val()=="护照")//军官证
			{	
				if (value.length==8)
					return true;//如果当前域的值等于指定的参数就通过校验
			}
			else 
			{
				return true;
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

	//证件类型
	$("#spZJLX").click(function(){
		var infoID = $("#txtZJLX").val();
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
			$("#txtZJLX").val("");
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
		var zjlxId = $("#txtCSFZJLXNm").val();
		var flag = isNaN(zjlxId);
		if(zjlxId != ''){
			if (!flag)
				getZJLX(zjlxId, '#txtCSFZJLXNm');
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
					$("#txtZJLX").val(selectValue);
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
				} else if ($("#hidSelect").val() == "JYLX") {
					selectValue = getSelectedJYLXValue();
					$("#txtJYLX").val(selectValue);
					getJYLX(selectValue,'#txtJYLXTIP');
				} else if ($("#hidSelect").val() == "JZJGT") {
					selectValue = getSelectedJZJGValue();
					$("#txtJZJGT").val(selectValue);
					getJZJG(selectValue,'#txtJZJGTTIP');
				} else if ($("#hidSelect").val() == "GHYTT") {
					selectValue =getSelectedGHYTValue();
					$("#txtGHYTT").val(selectValue);
					getGHYT(selectValue,'#txtGHYTTTIP');
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
	var fcid = $("#FCID").val();
	var DF = $("#txtDF").val();
	var CX = $("#txtCX").val();
	var CG = parseFloat($("#txtCG").val());
	if (szqy=="") return;
	//清空综合修正隐藏域
	cleanZhxz();
	$("#loading").show();
	var url = "ZHXZT00302.action";
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
				$("#txtZJLX").val(formatString(bean.cd00001Zjlx));
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


//后台更新数据
function editSLInfo(){
	if (!$("#editForm").valid())
		return;
	$.ajax({
		   type: "POST",
		   cache: false,
		   url: "EDITSL.action",
		   data: { 
					FCID : $("#FCID").val(),
					ddlSZQY : $("#ddlSZQY").val(),
					txtXQDM : $("#txtXQDM").val(),
					txtZLC : $("#txtZLC").val(),
					txtXQTIP: $("#txtXQTIP").val(),
					hidPARENTDM : $("#hidPARENTDM").val(),
					hidZHXZid : $("#hidZHXZid").val(),
					txtZRFMCEDIT : $("#txtZRFMCEDIT").val(),
					txtZRFSFLXEDIT : $("#txtZJLXNm").val(),
					txtZRFSFIDEDIT : $("#txtZRFSFIDEDIT").val(),
					txtCSFMCEDIT : $("#txtCSFMCEDIT").val(),
					txtCSFSFLXEDIT : $("#txtCSFZJLXNm").val(),
					txtCSFSFIDEDIT : $("#txtCSFSFIDEDIT").val(),
					txtCLHEDIT : $("#txtCLHEDIT").val(),
					txtLFDZEDIT : $("#txtLFDZEDIT").val(),
					txtDYFHEDIT : $("#txtDYFHEDIT").val(),
					txtSZLCEDIT : $("#txtSZLCEDIT").val(),
					txtJZJGTTIP : $("#txtJZJGTTIP").val(),
					txtGHYTTTIP : $("#txtGHYTTTIP").val(),
					txtYFCZHEDIT : $("#txtYFCZHEDIT").val(),
					txtJZMJEDIT : $("#txtJZMJEDIT").val(),
					txtJYJGEDIT : $("#txtJYJGEDIT").val(),
					txtJYSJEDIT : $("#txtJYSJEDIT").val(),
					txtJYLXTIP : $("#txtJYLXTIP").val(),
					txtFWLXTIP : $("#txtFWLXTIP").val(),
					txtFZRQEDIT : $("#txtFZRQEDIT").val(),	
					txtYJGEDIT : $("#txtYJGEDIT").val(),
					txtPGJGEDIT: $("#txtPGJGEDIT").val(),
					ACT : 'U'
					},
		   success: function(msg){
			 
//			   $.notifyBar({cls: "success", html: '参数更新成功'});
			  
//			   $.messager.confirm('系统提示', '确定要评税该数据吗?', function(r) {
//		            if (r) {
		            	$("#txtFCID").val($("#FCID").val());
		            	$("#psForm").submit();
//		            }
//		        });
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   
		   }
	});	
}