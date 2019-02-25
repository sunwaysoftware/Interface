<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- content start -->
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf am-u-sm-6 am-u-md-10">
        <strong class="am-text-primary am-text-lg">审核信息</strong> /
        <small>对税务审核退税信息进行管理</small>
    </div>
    <div class="am-u-sm-6 am-u-md-2">
        <div class="am-btn-toolbar">
            <div class="am-btn-group am-btn-group-xs">
                <a href="javascript:showPage('/tax/sh/crud/0');" class="am-btn am-btn-primary am-round am-btn-xs">
                    <span class="am-icon-plus"></span> 新增</a>
            </div>
        </div>
    </div>
</div>
<hr>
<form id="findForm" class="am-form am-form-horizontal">
    <div class="am-form-group">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">审核时间</div>
        <div class="am-u-sm-4 am-u-md-3">
            <div class="am-form-icon">
                <i class="am-icon-calendar"></i>
                <input type="text" class="am-form-field" id="txtShsj" name="shsj" required data-am-datepicker readonly>
            </div>
        </div>
        <div class="am-u-sm-4 am-u-md-7">
            <div>
                <button id="btnSearch" class="am-btn am-btn-default" type="button"><span class="am-icon-search"></span> 查询</button>
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
                    url: "/tax/sh/crud/" + obj.target.id,
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
            var dt_data = {shsj : $('#txtShsj').val()};
            ShowDataTable(dt_data);
        });

        $('#txtShsj').datepicker({format: 'yyyy-mm-dd'});
    });

    // Edit data
    function editData(id) {
        showPage("/tax/sh/crud/" + id);
    };

    function ShowDataTable(dtData) {
        $('#myTable').DataTable({
            "deferRender": true,
            "processing": true,
            "iDisplayLength": 20, //默认显示的记录数
            "bLengthChange": false, //显示数据数量
            "destroy": true,
            ajax: {
                type: 'POST',
                url: '/tax/sh/viewlist',
                data: dtData,
                dataSrc: ''
            },
            columns: [
                {title: "受理号", data: "ywh"},
                {title: "审核人", data: "shr"},
                {title: "审核意见", data: "shyj"},
                {title: "审核时间", data: "shsj"},
            ],
            // 定义操作列
            columnDefs: [{
                targets: 4,
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