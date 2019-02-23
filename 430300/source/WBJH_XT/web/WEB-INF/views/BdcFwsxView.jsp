<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- content start -->
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">房产属性信息</strong> /
        <small>国土不动产交易房产属性信息</small>
    </div>
</div>
<hr>
<form id="findForm" class="am-form am-form-horizontal">
    <div class="am-form-group">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">产生时间</div>
        <div class="am-u-sm-4 am-u-md-3">
            <div class="am-form-icon">
                <i class="am-icon-calendar"></i>
                <input type="text" id="txtCssj" name="cssj" class="am-form-field" required data-am-datepicker readonly>
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
            var dt_data = {cssj : $('#txtCssj').val()};
            ShowDataTable(dt_data);
        });
        $('#txtCssj').datepicker({format: 'yyyy-mm-dd'});
    });

    function ShowDataTable(dtData) {
        $('#myTable').DataTable({
            "deferRender": true,
            "processing": true,
            "iDisplayLength": 20, //默认显示的记录数
            "bLengthChange": false, //显示数据数量
            "destroy": true,
            rowId: 'id',
            ajax: {
                type: 'POST',
                url: '/bdc/fw/viewlist',
                data: dtData,
                dataSrc: ''
            },
            columns: [
                {title: "受理号", data: "ywh"},
                {title: "不动产证号", data: "bdcqzh", defaultContent: "--"},
                {title: "不动产单元号", data: "bdcdyh", defaultContent: "--"},
                {title: "坐落", data: "bsit", defaultContent: "--"},
                {title: "面积", data: "barea", defaultContent: "--"}
            ],
            // 定义操作列
            columnDefs: [{
                targets: 0,
                render: function (data, type, full) {
                    return "<a href=\"javascript:showPage('/bdc/fw/crud/"+full.id+"');\">"+full.ywh+"</a>";
                }
            }]
        });
    };
</script>