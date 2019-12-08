$(document).ready(function() {
	

	//FROM验证信息
	$("#findForm").validate({
		rules: {
			ddlSZQYFind : {required: true}
			}
		});		

	//生成标准房（虚拟）
	$("#btnScbzf").click(function(){
		if ($("#findForm").valid()){
			createBzf();
		}
	});

	//导入标准房（真实）
	$("#btnDrbzf").click(function(){
		if ($("#findForm").valid()){
			importBzf();
		}
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
							var szqy = $("#ddlSZQYFind").val();
							var selectValue ;
							if ($("#hidSelect").val() == "XQ") {
								var szqy = $("#ddlSZQYFind").val();
								selectValue = getSelectedXQValue();
								$("#txtXQFind").val(selectValue);
								getXQ(szqy, selectValue, '#txtXQTIP');
							} else if ($("#hidSelect").val() == "FWLX") {
								selectValue = getSelectedFWLXValue();
								$("#txtFWLXFind").val(selectValue);
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

	$("#ddlSZQYFind").change(function(){
		$("#txtXQFind").val('');
		$("#txtXQTIP").val('');
	});
	
	$("#spXQDM").click(function(){
		$("#hidSelect").val("XQ");
		var szqy = $("#ddlSZQYFind").val();
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请先选择所在区域'});
			$("#ddlSZQYFind").focus();
			return;
		}
		var infoID = $("#txtXQFind").val();
		openXQMCDialog(szqy, infoID, '#infoTreeDIV');
	});
	

	// 房屋类型
	$("#spFWLX").click(function(){
		$("#hidSelect").val("FWLX");
		var infoID = $("#txtFWLXFind").val();
		openFWLXDialog(infoID, '#infoTreeDIV');		
	});
	
	//小区模糊查询
	$("#txtXQCX").autocomplete("XQNMFIND.action", {
		delay : 1000,
		minChars : 1,
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
});


//生成标准房
function createBzf(){
	$("#loading").ajaxStart(
        function()
        {
         $("#loading").show();
        }
    );
	var url = "CREATEBZF.action";
	var data = {ddlSZQYFind : $("#ddlSZQYFind").val(),
				txtXQDM : $("#txtXQFind").val(),
				txtFWLX : $("#txtFWLXFind").val()};
	$.ajax({
		   type: "GET",
		   url: url,
		   cache: false,
		   data: data,
		   dataType: "json",
		   complete:function()
           {
				$("#loading").hide();
           },
		   success: function(msg){
        	   $.notifyBar({cls:"success", html: "已经生成"+msg.createSum+"条标准房！"});
		   },
		   error: function(){
			   $("#loading").hide();
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});
}

//导入标准房
function importBzf(){
	$("#loading").ajaxStart(
        function()
        {
         $("#loading").show();
        }
    );
	var url = "IMPORTBZF.action";
	var data = {ddlSZQYFind : $("#ddlSZQYFind").val(),
				txtXQDM : $("#txtXQFind").val(),
				txtFWLX : $("#txtFWLXFind").val()};
	$.ajax({
		   type: "GET",
		   url: url,
		   cache: false,
		   data: data,
		   dataType: "json",
		   complete:function()
           {
				$("#loading").hide();
           },
		   success: function(msg){
        	   $.notifyBar({cls:"success", html: "已经生成"+msg.createSum+"条标准房！"});
		   },
		   error: function(){
			   $("#loading").hide();
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});
}

//根据小区自动完成信息，后台请求楼房信息数据
function bindXQCXINFO(){
	var url = "LOADXQIFBYXQNM.action";
	var data = {XQNM : $("#txtXQCX").val(),	
				ACT : $("#ACT").val()};
	$.ajax({
		type : "POST",
		url : url,
		cache : false,
		data : data,
		dataType: "json",
		complete:function()
        {

        },
		success: function(res){
        	var bean = res.t00352Bean;
        	 $("#ddlSZQYFind").val(bean.cd00001Szqy);
        	 $("#txtXQTIP").val(bean.xqnm);
        	 $("#txtXQFind").val(bean.xqdm); 
		},
		error: function(){
			$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		}
	});
};

