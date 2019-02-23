<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- content start -->
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">用户信息</strong> /
        <small>对系统用户信息进行管理</small>
    </div>
</div>
<hr>
<form id="editForm" class="am-form am-form-horizontal">
    ${method}
    <div class="am-form-group">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">系统账号</div>
        <div class="am-u-sm-8 am-u-md-10">
            <input type="text" id="txtUsername" name="username" placeholder="输入登录系统账号" required minlength="3" value="${vo.username}" ${statusYHW}>
        </div>
    </div>

    <div class="am-form-group">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">登录密码</div>
        <div class="am-u-sm-8 am-u-md-10">
            <input type="password" id="txtPassword1" name="password" placeholder="输入登录密码" required minlength="5" value="${vo.password}">
        </div>
    </div>

    <div class="am-form-group">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">重输密码</div>
        <div class="am-u-sm-8 am-u-md-10">
            <input type="password" id="txtPassword2" name="password2" placeholder="重新输入密码" required value="${vo.password}">
        </div>
    </div>
<%
    String role_guest=null;
    String role_user=null;
    String role_admin=null;
%>
<c:forEach items="${vo.roles}" var="r" varStatus="i">
    <c:if test="${r.authority=='ROLE_GUEST'}"><% role_guest="checked"; %></c:if>
    <c:if test="${r.authority=='ROLE_USER'}"><% role_user="checked"; %></c:if>
    <c:if test="${r.authority=='ROLE_ADMIN'}"><% role_admin="checked"; %></c:if>
</c:forEach>
    <div class="am-form-group">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">权限</div>
        <div class="am-u-sm-8 am-u-md-10">
            <label class="am-checkbox-inline">
                <input type="checkbox" name="authority" value="ROLE_GUEST" <%=role_guest%>>查询浏览【ROLE_GUEST】
            </label>
            <label class="am-checkbox-inline">
                <input type="checkbox" name="authority" value="ROLE_USER" <%=role_user%>>数据操作【ROLE_USER】
            </label>
            <label class="am-checkbox-inline">
                <input type="checkbox" name="authority" value="ROLE_ADMIN" <%=role_admin%>>系统管理【ROLE_ADMIN】
            </label>
        </div>
    </div>

    <div class="am-form-group">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">状态</div>
        <div class="am-u-sm-8 am-u-md-10">
            <label class="am-radio-inline">
                <input type="radio" name="enabled" id="option1" value="1" <c:if test="${vo.enabled==1}">checked</c:if>> 正常
            </label>
            <label class="am-radio-inline">
                <input type="radio" name="enabled" id="option2" value="0" <c:if test="${vo.enabled==0}">checked</c:if>> 锁定
            </label>
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
                password2: {
                    equalTo: "#txtPassword1"
                }
            },messages:{
                password2: {
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
                url: "/sys/users/crud",
                data: form.serialize(),
                success: function (result) {
                    if (result == true) {
                        $.growl.notice({ message: "数据保存成功！" });
                    } else {
                        $.growl.error({ message: "数据保存失败！" });
                    }
                    showPage('/sys/users/view');
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
        // 返回列表
        $("#btnBack").click(function () {
            showPage('/sys/users/view');
        });
    });
</script>