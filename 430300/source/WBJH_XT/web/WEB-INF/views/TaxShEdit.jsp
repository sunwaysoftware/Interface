<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- content start -->
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">审核信息</strong> /
        <small>对税务审核退税信息进行管理</small>
    </div>
</div>
<hr>
<form id="editForm" class="am-form am-form-inline">
    ${method}
    <input type="hidden" name="id" id="txtId" value="${vo.id}">
    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            业务编号
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <input type="text" class="am-input-sm" id="txtYwh" name="ywh" value="${vo.ywh}" required>
        </div>
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            税票号码
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <input type="text" class="am-input-sm" id="txtSphm" name="sphm" value="${vo.sphm}">
        </div>
    </div>
    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            缴税费单位
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <input type="text" class="am-input-sm" id="txtJsdw" name="jsdw" value="${vo.jsdw}">
        </div>
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            缴税费总额
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <input type="number" class="am-input-sm" id="txtJsfje" name="jsfje" value="${vo.jsfje}">
        </div>
    </div>
    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            税务机关
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <input type="text" class="am-input-sm" id="txtSwjg" name="swjg" value="${vo.swjg}">
        </div>
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            经办人
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <input type="text" class="am-input-sm" id="txtJbr" name="jbr" value="${vo.jbr}">
        </div>
    </div>
    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            是否完税
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <select class="am-input-sm" id="txtSfws" name="sfws">
                <option value="0">未完税</option>
                <option value="1">已完税</option>
            </select>
        </div>
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            完税时间
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <div class="am-form-icon">
                <i class="am-icon-calendar"></i>
                <input type="date" class="am-form-field am-input-sm" id="txtWssj" name="wssj" value="${vo.wssj}">
            </div>
        </div>
    </div>
    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            审核意见
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <input type="text" class="am-input-sm" id="txtShyj" name="shyj" value="${vo.shyj}" required>
        </div>
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            审核时间
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <div class="am-form-icon">
                <i class="am-icon-calendar"></i>
                <input type="text" class="am-form-field am-input-sm" id="txtShsj" name="shsj" value="${vo.shsj}" required>
            </div>
        </div>
    </div>
    <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            审核人
        </div>
        <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
            <input type="text" class="am-input-sm" id="txtShr" name="shr" value="${vo.shr}" required>
        </div>
        <div class="am-u-sm-4 am-u-md-2 am-text-right">
            审核结果
        </div>
        <div class="am-u-sm-8 am-u-md-4">
            <select class="am-input-sm" id="txtShjg" name="dictShjg.id" required>
                <c:forEach items="${shjgList}" var="jg">
                    <option value="${jg.id}">${jg.taxNm}</option>
                </c:forEach>
            </select>
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
                shsj: {date: true},
                wssj: {date: true},
                jsfje: {number: true}
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
                url: "/tax/sh/crud",//url
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
            showPage('/tax/sh/view');
        });

        $('#txtShsj').datepicker({format: 'yyyy-mm-dd'});
        $('#txtWssj').datepicker({format: 'yyyy-mm-dd'});
        $("#txtSfws").val("${vo.sfws}");
        $("#txtShjg").val("${vo.dictShjg.id}");
    });
</script>