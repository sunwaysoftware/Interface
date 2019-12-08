var chart;
var options;
$(document).ready(function() {
	
	//初始加载数据
	LoadDataOnFirst();
	
	$("#subA").click(function(){
		$("#sign").val("1");
		$("#bb").window('open');
		$("#sxkz").show();	
	});
	
/*	$("#parA").click(function(){
		$("#bb").window('open');
		$("#sxkz").show();
	});*/

	//FROM验证信息
	$("#findForm").validate({
		rules: {
			txtPSSDFind: {required: true}
		}
	});
	
	// 税收管辖
	$("#spSSGX").click(function(){
		$("#hidSelect").val("SSGX");
		var infoID = $("#txtSSGX").val();
		openSSGXCONDDialog(infoID, '#infoTreeDIV');
	});
	
	//弹出对话框
	$("#dialog").dialog({
		modal: true,
        shadow: true,
        closed: true,
	       buttons:[{
				text:'选择',
				iconCls:'icon-ok',
				handler:function() {
	    	   $("#dialog").dialog("close");
							var selectValue;
							
							if ($("#hidSelect").val() == "SSGX") {
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
			defaultSeriesType : "bar",
			plotBackgroundColor : null,
			plotBorderWidth : null,
			plotShadow : false
		},
		title : {
			text : '交易量统计图'
		},
		tooltip : {
			formatter : function() {
				return '<b>' + this.point.name + '</b>: ' + this.y + '笔';
			}
		},
		xAxis: {
			categories: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
		},
		yAxis: {
			title: {
				text: '笔',
				align : 'high'
			}
		},		
		plotOptions : {
			bar: {
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
		series : [{
			name: "交易个数",
			data: []
		}]
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
		url : "FINDBB00004.action",
		dataType : "json",
		data : {
			sign : $("#sign").val(),
			txtSSGX : $("#txtSSGX").val(),
			txtPSSDFind : $("#txtPSSDFind").val(),
			txtJYJGMinFind : $("#txtJYJGMinFind").val(),
			txtJYJGMaxFind : $("#txtJYJGMaxFind").val()
		},
		success : function(data) {
			options.series[0].data = data;
			chart = new Highcharts.Chart(options);
		}
	});	
};

function LoadDataOnFirst(){
	$("#sign").val(1);
	searchData();
}
