<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">修改密码</strong> /
        <small>修改用户登录密码，修改后请牢记</small>
    </div>
</div>
<hr>
<form id="editForm" class="am-form am-form-horizontal">
    <input type="hidden" name="username" value="${userid}">
    <div class="am-form-group">
        <div class="am-u-sm-4 am-u-md-3 am-text-right">原密码</div>
        <div class="am-u-sm-8 am-u-md-9">
            <input type="password" id="txtOldPwd" name="password" placeholder="输入原密码" required>
        </div>
    </div>
    <div class="am-form-group">
        <div class="am-u-sm-4 am-u-md-3 am-text-right">新密码</div>
        <div class="am-u-sm-8 am-u-md-9">
            <input type="password" id="txtNewPwd1" name="newPwd" placeholder="输入新密码" required minlength="5">
        </div>
    </div>
    <div class="am-form-group">
        <div class="am-u-sm-4 am-u-md-3 am-text-right">重输密码</div>
        <div class="am-u-sm-8 am-u-md-9">
            <input type="password" id="txtNewPwd2" name="newPwd2" placeholder="确认新密码">
        </div>
    </div>
</form>
<div class="am-modal-footer">
    <span class="am-modal-btn" data-am-modal-cancel>取消</span>
    <span id="btnSub" class="am-modal-btn">提交</span>
</div>
<script>
    $(document).ready(function () {
        // FORM验证
        $("#editForm").validate({
            rules: {
                newPwd2: {
                    equalTo: "#txtNewPwd1"
                }
            },messages:{
                newPwd2: {
                    equalTo: "两次密码输入不一致"
                }
            }
        });

        $("#btnSub").click(function () {
            var form = $("#editForm");
            form.validate();
            if(!form.valid()){
                return false;
            }
            // 提交
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/pwd/crud",
                data: form.serialize(),
                success: function (result) {
                    if (result == true) {
                        $.growl.notice({ message: "密码更新成功！" });
                    } else {
                        $.growl.error({ message: "密码更新失败！" });
                    }
                    $('#appPrompt').modal('close');
                },
                error: function (err) {
                    if (err.status == 403) {
                        $.growl.warning({ message: "由于您权限不足，本次访问被限制。" });
                    } else {
                        $.growl.error({ message: err.status + "\n" + err.statusText });
                    }
                }
            });
        });
    });
</script>