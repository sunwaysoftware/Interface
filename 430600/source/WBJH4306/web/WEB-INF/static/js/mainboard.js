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
