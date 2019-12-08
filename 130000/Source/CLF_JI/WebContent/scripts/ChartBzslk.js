var chart;
var options;
$(document).ready(function() {	
	
	$("#btnUpdate").click(function(){		
		$("#txtSZQYUP").val($("#ddlSZQYFind").val());
		$("#txtFWLXUP").val($("#txtFWLX").val());
		$("#txtXQUP").val($("#txtXQFind").val());
		if ($("#txtSZQYUP").val()=="")
		{
			$.notifyBar({html: '请先选择所在区域' });
			return;
		}
		//alert($("#txtSZQYUP").val());
		$("#updateform").submit();
	});

	//FROM验证信息
	$("#updateform").validate({
		rules: {
			txtGPSJQZB: {required: true, number: true, maxlength: 3, max: 100},
			txtMONTHFind: {required: true},
			txtCZLUpd: {required: true, number: true},
			txtSZQYUP:{required:true}
		}
	});
	
	//FROM验证信息
	$("#findForm").validate({
		rules: {			
			txtNF: {required: true, number: true}
		}
	});	
	
	// 房屋类型
	$("#spFWLX").click(function(){
		$("#hidSelect").val("FWLX");
		var infoID = $("#txtFWLXFind").val();
		openFWLXDialog(infoID, '#infoTreeDIV');
	});
	
	//输入房屋类型代码获得类型
/*	$("#txtFWLXTIP").blur(function(){
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
	});*/
	
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
					if ($("#hidSelectXQ").val() == "XQ") {
						var szqy = $("#ddlSZQYFind").val();
						selectValue = getSelectedXQValue();
						if(null==selectValue) return;
						$("#txtXQFind").val(selectValue);
						getXQ(szqy, selectValue, '#txtXQTIP');
                    } else if ($("#hidSelect").val() == "FWLX") {
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

	$("#ddlSZQYFind").change(function(){
		$("#txtXQFind").val('');
		$("#txtXQTIP").val('');
	});

	$("#spXQDM").click(function(){
		var szqy = $("#ddlSZQYFind").val();
		$("#hidSelectXQ").val("XQ");
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请先选择所在区域' });
			$("#ddlSZQYFind").focus();
			return;
		}
		var infoID = $("#txtXQFind").val();
		openXQMCDialog(szqy, infoID, '#infoTreeDIV');
	});
	
	//初始化图表
	options = {
		chart : {
			renderTo : "appChart",
			defaultSeriesType : "line",
			plotBackgroundColor : null,
			plotBorderWidth : null,
			plotShadow : false
		},
		title : {
			text : '价格走势分析图'
		},
		tooltip : {
			formatter : function() {
				return '<b>' + this.series.name + '</b>: ' + this.y + '元';
			}
		},
		xAxis: {
			categories: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
		},
		yAxis: {
			title: {
				text: '价格'
			}
		},		
		plotOptions : {
			line: {
				allowPointSelect: true,
				cursor: 'pointer',
				dataLabels: {
					enabled: true,
					formatter: function() {
						return this.y;
					}
				}
			}
		},
		exporting: {
			type: 'image/png',
			filename: 'chart',
			enabled: true,
			enableImages: true,
			url: 'report/ExportChart.action',// 固定不变
			width: 800
		},
		series : []
	};
	
	// 错误提示
	$("#msg").ajaxError(function(event, request, settings, msg) {
		$(this).append("<li>出错页面:" + settings.url + "</li>");
		$(this).append("<li>错误信息:" + msg + "</li>");
	});	

});

// 查询数据
function searchChar() {
	$("#sign").val(1);
	$("#loading").show();
	$.ajax({
		type : "POST",
		url : "ChartSCBZSLKGXBZ.action",
		dataType : "json",
		complete:function() {
			$("#loading").hide();
	   	},
		data : {
			ddlSZQYFind : $("#ddlSZQYFind").val(),
			txtXQFind : $("#txtXQFind").val(),
			txtFWLX : $("#txtFWLX").val(),
			txtNF : $("#txtNF").val()
		},
		success : function(data) {
			options.series = data;
			chart = new Highcharts.Chart(options);
		}
	});	
};

//增长率
function getZzl(){
	var m = $("#txtMONTHFind").val();
	var gpqz = $("#txtGPSJQZB").val();
	var szqy = $("#ddlSZQYFind").val();
	if(m=="" || szqy==""){
		return;
	}
	var url = "../xtwh/READZZL.action";
	var data = {txtMONTHFind : m,
				txtGPSJQZB: gpqz,
				ddlSZQYFind:szqy,
				txtXQFind:$("#txtXQFind").val()};		
	$.ajax({
		type: "GET",
		url: url,
		cache: false,
		data: data,
		dataType: "json",
		success: function(myMsg){
			var msg = myMsg.zzl;
			$("#txtCZLUpd").val(msg);
		},
		error: function(){
			$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		}
	});		
}

