<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- content start -->
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">税票附件信息表</strong> /
        <small>对税务税票附件信息进行管理</small>
    </div>
</div>
<hr>
<form id="editForm" class="am-form am-form-inline" enctype="multipart/form-data">
    ${method}
    <input type="hidden" name="id" value="${vo.id}">
    <input type="hidden" name="ljdz" value="${vo.ljdz}">
    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            业务编号
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <input type="text" class="am-input-sm" id="txtYwh" name="ywh" value="${vo.ywh}" required>
        </div>
        <div class="am-hide-sm-only am-u-md-6 am-text-danger">*必填</div>
    </div>
    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            税票号码
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <input type="text" class="am-input-sm" id="txtSplx" name="splx" value="${vo.splx}" required>
        </div>
        <div class="am-hide-sm-only am-u-md-6 am-text-danger">*必填</div>
    </div>
    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            税票日期
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <div class="am-form-icon">
                <i class="am-icon-calendar"></i>
                <input type="text" class="am-form-field am-input-sm" id="txtSprq" name="sprq" value="${vo.sprq}"
                       required>
            </div>
        </div>
        <div class="am-hide-sm-only am-u-md-6 am-text-danger">*必填</div>
    </div>
    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            选择扫描件
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <input type="file" class="am-input-sm" id="txtLjdz" name="file">
        </div>
        <div class="am-hide-sm-only am-u-md-6 am-text-danger">文件小于10m</div>
    </div>
    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            备注
        </div>
        <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
            <textarea rows="5" class="am-input-sm" placeholder="附件情况说明" name="bz">${vo.bz}</textarea>
        </div>
    </div>
</form>
<div class="am-margin">
    <a id="btnSub" class="am-btn am-btn-primary am-btn-xs"><spring:message code="app.page.btn.save"/></a>
    <a id="btnBack" class="am-btn am-btn-warning am-btn-xs"><spring:message code="app.page.btn.back"/></a>
</div>
<!-- content end -->
<script>
    $(document).ready(function () {
        // FORM验证
        $("#editForm").validate({
            rules: {
                sprq: {date: true},
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
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/tax/fj/crud",
                data: new FormData(form[0]), // form.serialize(), 无法序列化二进制文件，这里采用formData上传
                contentType: false,//必不可缺
                processData: false,//必不可缺
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
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#btnBack").click();
                }
            });
        });
        // 返回列表
        $("#btnBack").click(function () {
            showPage('/tax/fj/view');
        });

        $('#txtSprq').datepicker({format: 'yyyy-mm-dd'});
    });
</script>