var chart;
var options;
$(document).ready(function() {
	//初始加载数据
	LoadDataOnFirst();
	
	$("#subA").click(function(){
		$("#sign").val(1);
		$("#bb").window('open');
		$("#sxkz").show();	
	});
/*	
	$("#parA").click(function(){
		
	});*/
	
	//FROM验证信息
	$("#findForm").validate({
		rules: {
			txtPSSDFind: {required: true}
		}
	});
	
		// 房屋类型
	$("#spFWLX").click(function(){
		$("#hidSelect").val("FWLX");
		var infoID = $("#txtFWLXFind").val();
		openFWLXDialog(infoID, '#infoTreeDIV');
	});

	// 交易类型
	$("#spJYLX").click(function(){
		$("#hidSelect").val("JYLX");
		var infoID = $("#txtJYLXFind").val();
		openJYLXDialog(infoID, '#infoTreeDIV');
	});

	// 建筑结构
	$("#spJZJG").click(function(){
		$("#hidSelect").val("JZJG");
		var infoID = $("#txtJZJGFind").val();
		openJZJGDialog(infoID, '#infoTreeDIV');
	});
	
	// 税收管辖
	$("#spSSGX").click(function(){
		$("#hidSelect").val("SSGX");
		var infoID = $("#txtSSGX").val();
		openSSGXCONDDialog(infoID, '#infoTreeDIV');
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
							if ($("#hidSelect").val() == "XQ") {
								var szqy = $("#ddlSZQYFind").val();
								var selectValue = getSelectedXQValue();
								$("#txtXQFind").val(selectValue);
								getXQ(szqy, selectValue, '#txtXQTIP');
							} else if ($("#hidSelect").val() == "JZJG") {
								selectValue = getSelectedJZJGValue();
								$("#txtJZJGFind").val(selectValue);
								getJZJG(selectValue,'#txtJZJGNm');
							} else if ($("#hidSelect").val() == "FWLX") {
								selectValue = getSelectedFWLXValue();
								$("#txtFWLXFind").val(selectValue);
								getFWLX(selectValue, '#txtFWLXNm');
							} else if ($("#hidSelect").val() == "JYLX") {
								selectValue = getSelectedJYLXValue();
								$("#txtJYLXFind").val(selectValue);
								getJYLX(selectValue,'#txtJYLXNm');
							} else if ($("#hidSelect").val() == "SSGX") {
								selectValue = getSelectedSSGXValue();
								$("#txtSSGX").val(selectValue);
								getSSGX(selectValue,'#txtSSGXTIP');
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
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请先选择所在区域' });
			$("#ddlSZQYFind").focus();
			return;
		}
		$("#hidSelect").val("XQ");
		var infoID = $("#txtXQFind").val();
		openXQMCDialog(szqy, infoID, '#infoTreeDIV');
	});
	
	
	//小区名称退格清除内容
	$("#txtXQTIP").blur(function(){
		var id = $("#txtXQTIP").val();
		var flag = isNaN(id);
		
		if(id == '' && !flag){
			
			$("#txtXQTIP").val("");
			$("#txtXQFind").val("");
		}
	});
	//房屋类型退格清除内容
	$("#txtFWLXNm").blur(function(){
		var id = $("#txtFWLXNm").val();
		var flag = isNaN(id);
		
		if(id == '' && !flag){
			
			$("#txtFWLXNm").val("");
			$("#txtFWLXFind").val("");
		}
	});
	//建筑结构退格清除内容
	$("#txtJZJGNm").blur(function(){
		var id = $("#txtJZJGNm").val();
		var flag = isNaN(id);
		
		if(id == '' && !flag){
			
			$("#txtJZJGNm").val("");
			$("#txtJZJGFind").val("");
		}
	});
	//交易类型退格清除内容
	$("#txtJYLXNm").blur(function(){
		var id = $("#txtJYLXNm").val();
		var flag = isNaN(id);
		
		if(id == '' && !flag){
			
			$("#txtJYLXNm").val("");
			$("#txtJYLXFind").val("");
		}
	});
	//税收管辖退格清除内容
	$("#txtSSGXTIP").blur(function(){
		var id = $("#txtSSGXTIP").val();
		var flag = isNaN(id);
		
		if(id == '' && !flag){
			
			$("#txtSSGXTIP").val("");
			$("#txtSSGX").val("");
		}
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
function searchData() {
	$.ajax({
		type : "POST",
		url : "FINDBB00003.action",
		dataType : "json",
		data : {
			sign : $("#sign").val(),
			txtSSGX : $("#txtSSGX").val(),
			txtPSSDFind : $("#txtPSSDFind").val(),
			ddlSZQYFind : $("#ddlSZQYFind").val(),
			txtSWIDFind : $("#txtSWIDFind").val(),
			txtZJLXFind : $("#txtZJLXFind").val(),
			txtNSRMCFind : $("#txtNSRMCFind").val(),
			txtZCDZLFind : $("#txtZCDZLFind").val(),
			txtZCDZBMFind : $("#txtZCDZBMFind").val(),
			txtXQFind : $("#txtXQFind").val(),
			txtFCZHFind : $("#txtFCZHFind").val(),
			txtJZJGFind : strIsEmpty($("#txtJZJGFind").val()),
			txtSZLCFind : $("#txtSZLCFind").val(),
			txtJYLXFind : strIsEmpty($("#txtJYLXFind").val()),
			txtJZMJMINFind : $("#txtJZMJMINFind").val(),
			txtJZMJMAXFind : $("#txtJZMJMAXFind").val(),
			txtFWLXFind : strIsEmpty($("#txtFWLXFind").val()),
			txtJYJGMINFind : $("#txtJYJGMINFind").val(),
			txtJYJGMAXFind : $("#txtJYJGMAXFind").val(),
			txtDJRQFind : $("#txtDJRQFind").val()
		},
		success : function(data) {
			options.series = data;
			chart = null;
			chart = new Highcharts.Chart(options);
		}
	});	
};

function LoadDataOnFirst(){
	$("#sign").val(1);
	searchData();
}
