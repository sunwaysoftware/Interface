<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- content start -->
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf am-u-sm-6 am-u-md-10">
        <strong class="am-text-primary am-text-lg">涉税资料信息表</strong> /
        <small>对不动产交易中涉税务资料电子档信息进行管理</small>
    </div>
    <div class="am-u-sm-6 am-u-md-2">
        <div class="am-btn-toolbar">
            <div class="am-btn-group am-btn-group-xs">
                <a href="javascript:showPage('/tax/fj/crud/0');" class="am-btn am-btn-primary am-round am-btn-xs">
                    <span class="am-icon-plus"></span> 新增</a>
            </div>
        </div>
    </div>
</div>
<hr>
<form id="findForm" class="am-form am-form-horizontal">
    <div class="am-form-group">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">税票日期</div>
        <div class="am-u-sm-4 am-u-md-3">
            <div class="am-input-group am-datepicker-date am-input-group-sm" data-am-datepicker="{format: 'yyyy-mm-dd'}">
                <input id="txtSprq" type="text" class="am-form-field am-input-sm" readonly>
                <span class="am-input-group-btn am-datepicker-add-on">
                    <button id="btnDate" class="am-btn am-btn-sm" type="button"><span class="am-icon-calendar"></span></button>
                </span>
            </div>
        </div>
        <div class="am-u-sm-4 am-u-md-7">
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

        // 初始化刪除按钮
        $('#myTable tbody').on('click', 'button.am-text-danger', function (obj) {
            var tr = $(this).parents('tr');
            if (confirm("确定要删除该条数据？")) {
                $.ajax({
                    type: 'POST',
                    url: "/tax/fj/crud/" + obj.target.id,
                    data: {
                        _method: 'DELETE'
                    },
                    success: function (data) {
                        $('#myTable').DataTable().row(tr).remove().draw();
                        $.growl.notice({message: "<spring:message code='app.msg.del.ok'/>"});
                    },
                    error: function (xhr) {
                        if (xhr.status == 403) {
                            $.growl.warning({message: "<spring:message code='app.msg.nopermit'/>"});
                        } else {
                            $.growl.error({message: xhr.status + "\n" + xhr.statusText});
                        }
                    }
                });
            }
        });
        // 查询
        $("#btnSearch").click(function () {
            var form = $("#findForm");
            form.validate();
            if (!form.valid()) {
                return false;
            }
            //使用ajax 重新请求数据结果  装入 表格对象
            var dt_data = {sprq: $('#txtSprq').val()};
            ShowDataTable(dt_data);
        });

        $('#btnDate').datepicker().on('changeDate.datepicker.amui', function (event) {
            $('#txtSprq').val($('#btnDate').data('date'));
        });
    });

    // Edit data
    function editData(id) {
        showPage("/tax/fj/crud/" + id);
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
                url: '/tax/fj/viewlist',
                data: dtData,
                dataSrc: ''
            },
            columns: [
                {title: "业务号", data: "ywh", defaultContent: "--"},
                {title: "税票号码", data: "splx", defaultContent: "--"},
                {title: "税票日期", data: "sprq", defaultContent: "--"},
                {title: "备注", data: "bz", defaultContent: "--", width: "20%"},
            ],
            // 定义操作列
            columnDefs: [{
                targets: 4,
                title: "扫描件",
                render: function (data, type, full) {
                    return "<a href='/upload/tax/" + encodeURI(full.ljdz) + "' target=\"FJ_win\"><span class=\"am-icon-file\"></span></a>";
                }
            }, {
                targets: 5,
                title: "操作",
                render: function (data, type, full) {
                    return "<div class=\"am-btn-toolbar\"><div class=\"am-btn-group am-btn-group-xs\">" +
                        "<button onclick=\"editData('" + full.id + "')\" class=\"am-btn am-btn-default am-btn-xs am-text-secondary\"><span class=\"am-icon-pencil-square-o\"></span> 编辑</button>" +
                        "<button id=\"" + full.id + "\" class=\"am-btn am-btn-default am-btn-xs am-text-danger \"><span class=\"am-icon-trash-o\"></span> 删除</button>" +
                        "</div></div>";
                }
            }]
        });
    };
</script>