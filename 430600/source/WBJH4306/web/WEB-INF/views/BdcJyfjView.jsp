<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- content start -->
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf am-u-sm-6 am-u-md-10">
        <strong class="am-text-primary am-text-lg">交易附件信息表</strong> /
        <small>对不动产交易资料附件信息进行管理</small>
    </div>
</div>
<hr>
<form id="findForm" class="am-form am-form-horizontal">
    <div class="am-form-group">
        <div class="am-u-sm-2 am-u-md-1 am-text-right">业务号</div>
        <div class="am-u-sm-3 am-u-md-3">
            <input id="txtYwh" type="text" class="am-form-field am-input-sm">
        </div>
        <div class="am-u-sm-2 am-u-md-2 am-text-right">受理编号</div>
        <div class="am-u-sm-3 am-u-md-3">
            <input type="text" id="txtSlbh" class="am-form-field am-input-sm">
        </div>
        <div class="am-u-sm-2 am-u-md-3">
            <div>
                <button id="btnSearch" class="am-btn am-btn-sm" type="button"><span class="am-icon-search"></span> 查询</button>
                <button id="btnClear" class="am-btn am-btn-sm" type="reset"><span class="am-icon-eraser"></span> 清空</button>
            </div>
        </div>
    </div>
</form>
<hr>
<div class="am-g">
    <div class="am-u-sm-12">
        <table id="myTable" class="am-table am-table-striped am-table-hover table-main"></table>
    </div>
</div>
<!-- content end -->
<script>
    $(document).ready(function () {
        ShowDataTable();
        // 查询
        $("#btnSearch").click(function () {
            var form = $("#findForm");
            form.validate();
            if (!form.valid()) {
                return false;
            }
            //使用ajax 重新请求数据结果  装入 表格对象
            var dt_data = {
                caseno: $('#txtYwh').val(),
                slbh: $('#txtSlbh').val(),
            };
            ShowDataTable(dt_data);
        });
    });

    // Edit data
    function editData(id) {
        showPage("/bdc/fj/crud/" + id);
    };

    function ShowDataTable(dtData) {
        $('#myTable').DataTable({
            "deferRender": true,
            "processing": true,
            "iDisplayLength": 20, //默认显示的记录数
            "bLengthChange": false, //显示数据数量
            "destroy": true,
            "order":[0, "desc"],
            ajax: {
                type: 'POST',
                url: '/bdc/fj/viewlist',
                data: dtData,
                dataSrc: ''
            },
            columns: [
                {title: "业务号", data: "caseno", defaultContent: "--"},
                {title: "受理编号", data: "slbh", defaultContent: "--"},
                {title: "资料名称", data: "materialname", defaultContent: "--"},
                {title: "大小(KB)", data: "filesize", defaultContent: "--", width: "15%"},
            ],
            // 定义操作列
            columnDefs: [{
                targets: 4,
                title: "附件",
                width: "10%",
                render: function (data, type, full) {
                    return "<a href='/upload/bdc/" + encodeURI(full.filepath + "/" + full.filename) + "' target=\"FJ_win\"><span class=\"am-icon-file\"></span></a>";
                }
            }]
        });
    };
</script>