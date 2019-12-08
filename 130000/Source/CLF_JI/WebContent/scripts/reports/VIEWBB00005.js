var chart;
var options;
$(document).ready(function () {

    //初始加载数据
    searchData();

    //查询
    $("#subA").click(function () {
        $("#bb").window('open');
        $("#sxkz").show();
//		searchData();	
    });

    /*//条件
     $("#parA").click(function(){
     $("#bb").window('open');
     $("#sxkz").show();
     });*/

    //FROM验证信息
    $("#findForm").validate({
        rules: {
            txtJYSJMinFind: {required: true},
            txtJYSJMaxFind: {required: true}
        }
    });

    // 税收管辖
    $("#spSSGX").click(function () {
        $("#hidSelect").val("SSGX");
        var infoID = $("#txtSSGX").val();
        openSSGXCONDDialog(infoID, '#infoTreeDIV');
    });

    //弹出对话框
    $("#dialog").dialog({
        modal: true,
        shadow: true,
        closed: true,
        buttons: [{
                text: '选择',
                iconCls: 'icon-ok',
                handler: function () {
                    $("#dialog").dialog("close");
                    var selectValue;

                    if ($("#hidSelect").val() == "SSGX") {
                        selectValue = getSelectedSSGXValue();
                        $("#txtSSGX").val(selectValue);
                        getSSGX(selectValue, '#txtSSGXTIP');
                    }
                }
            }, {
                text: '关闭',
                iconCls: 'icon-cancel',
                handler: function () {
                    $("#dialog").dialog('close');
                }
            }]
    });

    //税收管辖退格清除内容
    $("#txtSSGXTIP").blur(function () {
        var id = $("#txtSSGXTIP").val();
        var flag = isNaN(id);

        if (id == '' && !flag) {

            $("#txtSSGXTIP").val("");
            $("#txtSSGX").val("");
        }
    });

    //初始化图表
    options = {
        chart: {
            renderTo: "appChart",
            defaultSeriesType: "pie",
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '评估个数对比图'
        },
        tooltip: {
            formatter: function () {
                return '<b>' + this.point.name + '</b>: ' + this.y + '笔';
            }
        },
        plotOptions: {
            pie: {
                showInLegend: true,
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    //color: '#000000',
                    //connectorColor: '#000000',
                    formatter: function () {
                        return '<b>' + this.point.name + '</b>: ' + this.y + ' 笔';
                    }
                }
            }
        },
        exporting: {
            type: 'image/png',
            filename: 'chart',
            enabled: true,
            enableImages: true,
            url: 'report/ExportChart.action', // 固定不变
            width: 800
        },
        series: [{
                data: []
            }]
    };

    // 错误提示
    $("#msg").ajaxError(function (event, request, settings, msg) {
        $(this).append("<li>出错页面:" + settings.url + "</li>");
        $(this).append("<li>错误信息:" + msg + "</li>");
    });

});

// 查询数据
function searchData() {
    $.ajax({
        type: "POST",
        url: "FINDBB00005.action",
        dataType: "json",
        data: {
            txtSSGX: $("#txtSSGX").val(),
            txtJYSJMinFind: $("#txtJYSJMinFind").val(),
            txtJYSJMaxFind: $("#txtJYSJMaxFind").val()
        },
        success: function (data) {
            options.series[0].data = data;
            chart = new Highcharts.Chart(options);
        }
    });
}
;
