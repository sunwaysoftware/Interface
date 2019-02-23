(function ($) {
    'use strict';

    $(function () {
        var $fullText = $('.admin-fullText');
        $('#admin-fullscreen').on('click', function () {
            $.AMUI.fullscreen.toggle();
        });

        $(document).on($.AMUI.fullscreen.raw.fullscreenchange, function () {
            $fullText.text($.AMUI.fullscreen.isFullscreen ? '退出全屏' : '开启全屏');
        });
    });

    // Change user password
    $('#appPwd').on('click', function () {
        $('#appMsg').load("/pwd/view");
        $('#appPrompt').modal();
    });
})(jQuery);

function showPage(url) {
    $('#viewMain').load(url, function (response, status, xhr) {
        if (status == "error") {
            if (xhr.status == 403) {
                $.growl.warning({message: "由于您权限不足，本次访问被限制。\n【" + xhr.status + " " + xhr.statusText + "】"});
            } else {
                $.growl.error({message: xhr.status + "\n" + xhr.statusText});
            }
        }

    });
};

function showChart(data) {
    var ctx = document.getElementById("appChart").getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ["01月", "02月", "03月", "04月", "05月", "06月", "07月", "08月", "09月", "10月", "11月", "12月"],
            datasets: [{
                label: '不动产交易量走势',
                data: data,
                backgroundColor: ["rgba(255, 99, 132, 0.2)"],
                borderColor: ["rgb(255, 99, 132)"],
                borderWidth: 1
            }]
        }
    });
}