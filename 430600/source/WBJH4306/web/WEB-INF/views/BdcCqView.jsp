<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- content start -->
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">产权信息</strong> /
        <small>国土不动产产权信息管理</small>
    </div>
</div>
<hr>
<form id="findForm" class="am-form am-form-horizontal">
    <div class="am-form-group">
        <div class="am-u-sm-2 am-u-md-2 am-text-right">申请登记时间</div>
        <div class="am-u-sm-3 am-u-md-3">
            <div class="am-input-group am-datepicker-date am-input-group-sm" data-am-datepicker="{format: 'yyyy-mm-dd'}">
                <input id="txtCssj" type="text" class="am-form-field am-input-sm" readonly>
                <span class="am-input-group-btn am-datepicker-add-on">
                    <button id="btnDate" class="am-btn am-btn-sm" type="button"><span class="am-icon-calendar"></span></button>
                </span>
            </div>
        </div>
        <div class="am-u-sm-2 am-u-md-1 am-text-right">权利人</div>
        <div class="am-u-sm-3 am-u-md-3">
            <input type="text" id="txtQlr" name="qlr" class="am-form-field am-input-sm">
        </div>
        <div class="am-u-sm-2 am-u-md-3">
            <div>
                <button id="btnSearch" class="am-btn am-btn-sm" type="button"><span class="am-icon-search"></span>
                    查询
                </button>
                <button id="btnClear" class="am-btn am-btn-sm" type="reset"><span class="am-icon-eraser"></span>
                    清空
                </button>
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
        // 表格加载数据
        ShowDataTable();
        $('#btnDate').datepicker().on('changeDate.datepicker.amui', function (event) {
            $('#txtCssj').val($('#btnDate').data('date'));
        });
        // 查询
        $("#btnSearch").click(function () {
            var form = $("#findForm");
            form.validate();
            if (!form.valid()) {
                return false;
            }
            //重新请求数据结果装入表格对象
            var dt_data = {
                cssj: $('#txtCssj').val(),
                qlr: $('#txtQlr').val()
            };
            ShowDataTable(dt_data);
        });
    });

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
                url: '/bdc/cq/viewlist',
                data: dtData,
                dataSrc: ''
            },
            columns: [
                {title: "业务号", data: "ywh"},
                {title: "发证日期", data: "fzrq", defaultContent: "--"},
                {title: "不动产证号", data: "bdcqzh", defaultContent: "--"},
                {title: "原不动产证号", data: "ybdcqzh", defaultContent: "--"},
                {title: "交易价格", data: "jyjg", defaultContent: "--"},
            ],
            // 定义操作列
            columnDefs: [{
                targets: 5,
                title: "操作",
                render: function (data, type, full) {
                    return "<div class=\"am-btn-toolbar\"><div class=\"am-btn-group am-btn-group-xs\">" +
                        "<button onclick=\"showPage('/bdc/cq/crud/" + full.id + "')\" class=\"am-btn am-btn-default am-btn-xs am-text-secondary\">" +
                        "<span class=\"am-icon-newspaper-o\"></span> 查看</button></div></div>";
                }
            }]
        });
    };
</script>