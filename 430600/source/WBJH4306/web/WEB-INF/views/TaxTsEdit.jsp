<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- content start -->
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">退税信息</strong> /
        <small>对税务退税信息进行管理</small>
    </div>
</div>
<hr>
<form id="editForm" class="am-form">
    ${method}
    <input type="hidden" name="id" id="txtId" value="${vo.id}">
    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            业务编号
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <input type="text" class="am-input-sm" id="txtYwh" name="ywh" value="${vo.ywh}" required>
        </div>
        <div class="am-hide-sm-only am-u-md-6">*必填，不可重复</div>
    </div>

    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            纳税人识别号
        </div>
        <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
            <input type="text" class="am-input-sm" id="txtNsrsbh" name="nsrsbh" value="${vo.nsrsbh}">
        </div>
    </div>

    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            纳税人名称
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <input type="text" class="am-input-sm" id="txtNsrmc" name="nsrmc" value="${vo.nsrmc}">
        </div>
        <div class="am-hide-sm-only am-u-md-6">选填</div>
    </div>

    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            税务机关
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <input type="text" class="am-input-sm" id="txtSwjg" name="swjg" value="${vo.swjg}">
        </div>
        <div class="am-hide-sm-only am-u-md-6">选填</div>
    </div>
    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            退税时间
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <div class="am-input-group am-datepicker-date am-input-group-sm" data-am-datepicker="{format: 'yyyy-mm-dd'}">
                <input id="txtTssj" name="tssj" type="text" class="am-form-field am-input-sm" value="${vo.tssj}" readonly required>
                <span class="am-input-group-btn am-datepicker-add-on">
                    <button id="btnDate" class="am-btn am-btn-sm" type="button"><span class="am-icon-calendar"></span></button>
                </span>
            </div>
        </div>
        <div class="am-hide-sm-only am-u-md-6">选填</div>
    </div>
    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            退税金额
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <input type="number" class="am-input-sm" id="txtTsje" name="tsje" value="${vo.tsje}">
        </div>
        <div class="am-hide-sm-only am-u-md-6">选填</div>
    </div>
    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            经办人
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <input type="text" class="am-input-sm" id="txtJbr" name="jbr" value="${vo.jbr}">
        </div>
        <div class="am-hide-sm-only am-u-md-6">选填</div>
    </div>
    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            退税原因
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <textarea rows="5" class="am-input-sm" placeholder="退税原因情况说明" name="tsyy">${vo.tsyy}</textarea>
        </div>
        <div class="am-hide-sm-only am-u-md-6">选填</div>
    </div>
</form>
<div class="am-margin">
    <a id="btnSub" class="am-btn am-btn-primary am-btn-xs"><span class="am-icon-save"></span> <spring:message code="app.page.btn.save"/></a>
    <a id="btnBack" class="am-btn am-btn-warning am-btn-xs"><span class="am-icon-reply"></span> <spring:message code="app.page.btn.back"/></a>
</div>
<!-- content end -->
<script>
    $(document).ready(function () {
        // FORM验证
        $("#editForm").validate({
            rules: {
                tssj: {date: true},
                tsje: {number: true}
            }
        });

        $("#btnSub").click(function () {
            var form = $("#editForm");
            form.validate();
            if (!form.valid()) {
                return false;
            }
            // 提交表单
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/tax/ts/crud",//url
                data: form.serialize(),
                success: function (result) {
                    if (result == true) {
                        $.growl.notice({message: "<spring:message code='app.msg.save.ok'/>"});
                    } else {
                        $.growl.error({message: "<spring:message code='app.msg.save.ng'/>"});
                    }
                },
                error: function (err) {
                    if (err.status == 403) {
                        $.growl.warning({message: "<spring:message code='app.msg.nopermit'/>"});
                    } else {
                        $.growl.error({message: err.status + "\n" + err.statusText});
                    }
                }
            });
        });
        // 返回列表
        $("#btnBack").click(function () {
            showPage('/tax/ts/view');
        });

        $('#btnDate').datepicker().on('changeDate.datepicker.amui', function (event) {
            $('#txtTssj').val($('#btnDate').data('date'));
        });
    });
</script>