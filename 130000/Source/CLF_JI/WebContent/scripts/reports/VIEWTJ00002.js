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

    //FROM验证信息
    $("#findForm").validate({
        rules: {
            txtRDSJMinFind: {required: true},
            txtRDSJMaxFind: {required: true}
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
            text: '税额组成'
        },
        tooltip: {
            formatter: function () {
                return '<b>' + this.point.name + '</b>: ' + this.y + '万元';
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
                        return '<b>' + this.point.name + '</b>: ' + this.y + '万元';
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
        url: "FINDTJ00002.action",
        dataType: "json",
        data: {
            txtRDSJMinFind: $("#txtRDSJMinFind").val(),
            txtRDSJMaxFind: $("#txtRDSJMaxFind").val()
        },
        success: function (data) {
            options.series[0].data = data;
            chart = new Highcharts.Chart(options);
        }
    });
}
;
