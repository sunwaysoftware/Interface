<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- content start -->
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">完税信息</strong> /
        <small>不动产交易完税信息管理</small>
    </div>
</div>
<hr>
<form id="editForm" class="am-form">
    ${method}
    <input type="hidden" name="id" id="txtId" value="${vo.id}">
    <div class="am-tabs am-margin" data-am-tabs>
        <ul class="am-tabs-nav am-nav am-nav-tabs">
            <li class="am-active"><a href="#tab1">基本信息</a></li>
            <li><a href="#tab2">税额信息</a></li>
        </ul>
        <div class="am-tabs-bd">
            <div class="am-tab-panel am-fade am-in am-active" id="tab1">
                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        业务号
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input name="ywh" type="text" class="am-input-sm" value="${vo.ywh}" required placeholder="请输入业务号" >
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        税款所属期
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input id="txtSksssq" name="sksssq" type="text" class="am-input-sm" value="${vo.sksssq}" data-am-datepicker>
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        原票证号
                    </div>
                    <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
                        <input name="ypzh" type="text" class="am-input-sm" value="${vo.ypzh}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        计税价格
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input name="jsjg" type="number" class="am-input-sm" value="${vo.jsjg}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        完税日期
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.wsrq}" id="txtWsrq" name="wsrq" data-am-datepicker required>
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        发票号码
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.fphm}" name="fphm">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        评估编号
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.pgid}" name="pgid">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        评估价格
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.pgjg}" name="pgjg">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        转让方税票
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.zrfsphm}" name="zrfsphm">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        承受方税票
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.csfsphm}" name="csfsphm">
                    </div>
                </div>

                <div class="am-g am-margin-top-sm">
                    <div class="am-u-sm-12 am-u-md-2 am-text-right">
                        税收减免
                    </div>
                    <div class="am-u-sm-12 am-u-md-10">
                        <textarea rows="5" placeholder="税收减免情况说明" name="ssjm">${vo.ssjm}</textarea>
                    </div>
                </div>
            </div>

            <div class="am-tab-panel am-fade" id="tab2">
                <div class="am-g am-margin-top-sm">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        增值税
                    </div>
                    <div class="am-u-sm-8 am-u-md-4 am-u-end">
                        <input type="number" class="am-input-sm" value="${vo.seZzs}" name="seZzs">
                    </div>
                </div>

                <div class="am-g am-margin-top-sm">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        城建税
                    </div>
                    <div class="am-u-sm-8 am-u-md-4 am-u-end">
                        <input type="number" class="am-input-sm" value="${vo.seCjs}" name="seCjs">
                    </div>
                </div>

                <div class="am-g am-margin-top-sm">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        教育费及附加
                    </div>
                    <div class="am-u-sm-8 am-u-md-4 am-u-end">
                        <input type="number" class="am-input-sm" value="${vo.seDfjys}" name="seDfjys">
                    </div>
                </div>

                <div class="am-g am-margin-top-sm">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        土地增值税
                    </div>
                    <div class="am-u-sm-8 am-u-md-4 am-u-end">
                        <input type="number" class="am-input-sm" value="${vo.seTdzzs}" name="seTdzzs">
                    </div>
                </div>

                <div class="am-g am-margin-top-sm">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        个人所得税
                    </div>
                    <div class="am-u-sm-8 am-u-md-4 am-u-end">
                        <input type="number" class="am-input-sm" value="${vo.seGrsds}" name="seGrsds">
                    </div>
                </div>

                <div class="am-g am-margin-top-sm">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        契税
                    </div>
                    <div class="am-u-sm-8 am-u-md-4 am-u-end">
                        <input type="number" class="am-input-sm" value="${vo.seQs}" name="seQs">
                    </div>
                </div>

                <div class="am-g am-margin-top-sm">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        印花税
                    </div>
                    <div class="am-u-sm-8 am-u-md-4 am-u-end">
                        <input type="number" class="am-input-sm" value="${vo.seYhs}" name="seYhs">
                    </div>
                </div>
            </div>
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
                sksssq: {date: true},
                wsrq: {date: true},
                pgjg: {number: true}
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
                url: "/tax/ws/crud",//url
                data: form.serialize(),
                success: function (result) {
                    if (result == true) {
                        $.growl.notice({ message: "<spring:message code='app.msg.save.ok'/>" });
                    } else {
                        $.growl.error({ message: "<spring:message code='app.msg.save.ng'/>" });
                    }
                },
                error: function (err) {
                    if (err.status == 403) {
                        $.growl.warning({ message: "<spring:message code='app.msg.nopermit'/>" });
                    } else {
                        $.growl.error({ message: err.status + "\n" + err.statusText });
                    }
                }
            });
        });
        // 返回列表
        $("#btnBack").click(function () {
            showPage('/tax/ws/view');
        });

        $('#txtWsrq').datepicker({format: 'yyyy-mm-dd'});
        $('#txtSksssq').datepicker({format: 'yyyy-mm-dd'});
    });
</script>