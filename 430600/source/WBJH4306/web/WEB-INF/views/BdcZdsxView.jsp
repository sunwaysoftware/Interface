<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- content start -->
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">宗地属性信息</strong> /
        <small>国土不动产交易宗地属性信息</small>
    </div>
</div>
<hr>
<form id="findForm" class="am-form am-form-horizontal">
    <div class="am-form-group">
        <div class="am-u-sm-2 am-u-md-2 am-text-right">使用权期限</div>
        <div class="am-u-sm-3 am-u-md-3">
            <div class="am-input-group am-datepicker-date am-input-group-sm" data-am-datepicker="{format: 'yyyy-mm-dd'}">
                <input id="txtQssj" type="text" class="am-form-field am-input-sm" readonly placeholder="开始时间">
                <span class="am-input-group-btn am-datepicker-add-on">
                    <button id="btnDateQssj" class="am-btn am-btn-sm" type="button"><span class="am-icon-calendar"></span> </button>
                </span>
            </div>
        </div>
        <div class="am-u-sm-3 am-u-md-3">
            <div class="am-input-group am-datepicker-date am-input-group-sm" data-am-datepicker="{format: 'yyyy-mm-dd'}">
                <input id="txtJssj" type="text" class="am-form-field am-input-sm" readonly placeholder="结束时间">
                <span class="am-input-group-btn am-datepicker-add-on">
                    <button id="btnDateJssj" class="am-btn am-btn-sm" type="button"><span class="am-icon-calendar"></span> </button>
                </span>
            </div>
        </div>
        <div class="am-u-sm-4 am-u-md-4">
            <button id="btnSearch" class="am-btn am-btn-sm" type="button"><span class="am-icon-search"></span>
                查询
            </button>
        </div>
    </div>
    <div class="am-form-group">
        <div class="am-u-sm-2 am-u-md-2 am-text-right">权利人</div>
        <div class="am-u-sm-3 am-u-md-3">
            <input type="text" id="txtQlr" name="qlr" class="am-form-field am-input-sm">
        </div>
        <div class="am-u-sm-3 am-u-md-3">
        </div>
        <div class="am-u-sm-4 am-u-md-4">
            <div>
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
        // 查询
        $("#btnSearch").click(function () {
            var form = $("#findForm");
            form.validate();
            if (!form.valid()) {
                return false;
            }
            //重新请求数据结果装入表格对象
            var dt_data = {
                syqqssj: $('#txtQssj').val(),
                syqjssj: $('#txtJssj').val(),
                qlr: $('#txtQlr').val()
            };
            ShowDataTable(dt_data);
        });
        $('#btnDateQssj').datepicker().on('changeDate.datepicker.amui', function (event) {
            $('#txtQssj').val($('#btnDateQssj').data('date'));
        });
        $('#btnDateJssj').datepicker().on('changeDate.datepicker.amui', function (event) {
            $('#txtJssj').val($('#btnDateJssj').data('date'));
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
                url: '/bdc/zd/viewlist',
                data: dtData,
                dataSrc: ''
            },
            columns: [
                {title: "业务号", data: "ywh", defaultContent: "--"},
                {title: "宗地代码", data: "zddm", defaultContent: "--"},
                {title: "宗地号", data: "zdh", defaultContent: "--"},
                {title: "地籍号", data: "djh", defaultContent: "--"},
                {title: "宗地面积", data: "zdmj", defaultContent: "--"}
            ],
            // 定义操作列
            columnDefs: [{
                targets: 5,
                render: function (data, type, full) {
                    return "<div class=\"am-btn-toolbar\"><div class=\"am-btn-group am-btn-group-xs\">" +
                        "<button onclick=\"showPage('/bdc/zd/crud/" + full.id + "')\" class=\"am-btn am-btn-default am-btn-xs am-text-secondary\">" +
                        "<span class=\"am-icon-newspaper-o\"></span> 查看</button></div></div>";
                }
            }]
        });
    };
</script>