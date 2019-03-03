<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- content start -->
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf am-u-sm-6 am-u-md-10">
        <strong class="am-text-primary am-text-lg">用户信息</strong> /
        <small>对系统用户信息进行管理</small>
    </div>
    <div class="am-u-sm-6 am-u-md-2">
        <div class="am-btn-toolbar">
            <div class="am-btn-group am-btn-group-xs">
                <a href="javascript:showPage('/sys/users/crud/0');" class="am-btn am-btn-primary am-round am-btn-xs">
                    <span class="am-icon-plus"></span> 新增</a>
            </div>
        </div>
    </div>
</div>
<hr>
<div class="am-g">
    <div class="am-u-sm-12">
        <table id="myTable" class="am-table am-table-striped am-table-hover table-main"></table>
    </div>
</div>
<!-- content end -->
<script>
    $(document).ready(function () {
        $('#myTable').DataTable({
            "deferRender": true,
            "processing": true,
            "iDisplayLength": 20, //默认显示的记录数
            "bLengthChange": false, //显示数据数量
            ajax: {
                url: '/sys/users/viewlist',
                dataSrc: ''
            },
            columns: [
                {title: "账号", data: "username", defaultContent: "--"},
                {title: "密码", data: "password", defaultContent: "--"},
                {title: "拥有权限", data: "roles[].authority", defaultContent: "--"}
            ],
            // 定义操作列
            columnDefs: [{
                targets: 3,
                title: "状态",
                render: function (data, type, row) {
                    var strRtn;
                    if(1==row.enabled){
                        strRtn = "<span class=\"am-icon-unlock\" title='正常'></span>";
                    }else {
                        strRtn = "<span class=\"am-icon-lock\" title='锁定'></span>";
                    }
                    return strRtn;
                }
            }, {
                targets: 4,
                title: "操作",
                render: function (data, type, row) {
                    return "<div class=\"am-btn-toolbar\"><div class=\"am-btn-group am-btn-group-xs\">" +
                        "<button onclick=\"editData('" + row.username + "')\" class=\"am-btn am-btn-default am-btn-xs am-text-secondary\"><span class=\"am-icon-pencil-square-o\"></span> 编辑</button>" +
                        "<button id=\"" + row.username + "\" class=\"am-btn am-btn-default am-btn-xs am-text-danger \"><span class=\"am-icon-trash-o\"></span> 删除</button>" +
                        "</div></div>";
                }
            }]
        });

        // 初始化刪除按钮
        $('#myTable tbody').on('click', 'button.am-text-danger', function (obj) {
            var dt = $('#myTable').DataTable();
            var tr = $(this).parents('tr');
            if (confirm("确定要删除该条数据？")) {
                $.ajax({
                    type: 'POST',
                    url: "/sys/users/crud/" + obj.target.id,
                    data: {
                        _method: 'DELETE'
                    },
                    success: function (data) {
                        dt.row(tr).remove().draw();
                        $.growl.notice({ message: "数据删除成功！" });
                    },
                    error: function (err) {
                        if (err.status == 403) {
                            $.growl.warning({ message: "由于您权限不足，本次访问被限制。" });
                        } else {
                            $.growl.error({ message: err.status + "\n" + err.statusText });
                        }
                    }
                });
            }
        });
    });

    // Edit data
    function editData(id) {
        showPage("/sys/users/crud/" + id);
    };
</script>