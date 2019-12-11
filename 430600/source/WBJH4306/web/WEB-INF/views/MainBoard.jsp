<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<% String appPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>
<!doctype html>
<html class="no-js fixed-layout">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><spring:message code="app.title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta name="apple-mobile-web-app-title" content="Sunway"/>
    <link href="/favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" href="/static/assets/css/amazeui.css"/>
    <link rel="stylesheet" href="/static/assets/css/amazeui.datatables.css"/>
    <link rel="stylesheet" href="/static/assets/css/jquery.growl.css">
    <link rel="stylesheet" href="/static/assets/css/admin.css">
</head>
<body>

<!--[if lte IE 9]>
<p style="color:red;">您正在使用<strong>过时</strong>的浏览器，本系统暂不支持。 请<a href="https://support.microsoft.com/en-us/help/17621/internet-explorer-downloads/" target="_blank">升级浏览器</a>以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand">
        <img src="/static/img/tax.png" height="50" width="50">
        <strong><spring:message code="app.customer"/></strong>
        <small><spring:message code="app.title"/></small>
    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
            <li class="am-dropdown" data-am-dropdown>
                <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                    <span class="am-icon-users"></span> ${loginName}<span class="am-icon-caret-down"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="javascript:;" id="appPwd"><span class="am-icon-cog"></span> 设置</a></li>
                </ul>
            </li>
            <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span
                    class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
        </ul>
    </div>
</header>

<div class="am-cf admin-main">
    <!-- sidebar start -->
    <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
        <div class="am-offcanvas-bar admin-offcanvas-bar">
            <ul class="am-list admin-sidebar-list">
                <li><a href="/main/view"><span class="am-icon-home"></span>首页</a></li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span
                            class="am-icon-university"></span>
                        税务数据<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
                        <li><a href="javascript:showPage('/tax/ws/view');"><span class="am-icon-file-text"></span>
                            完税信息<span
                                    class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
                        <li><a href="javascript:showPage('/tax/sh/view');"><span class="am-icon-briefcase"></span> 审核资料</a>
                        </li>
                        <li><a href="javascript:showPage('/tax/ts/view');"><span class="am-icon-recycle"></span>
                            退税信息</a></li>
                        <li><a href="javascript:showPage('/tax/fj/view');"><span class="am-icon-wpforms"></span>
                            税票附件</a>
                        </li>
                    </ul>
                </li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-file"></span>
                        不动产数据<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
                        <li><a href="javascript:showPage('/bdc/fw/view');" class="am-cf"><span
                                class="am-icon-building"></span> 房屋属性<span
                                class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
                        <li><a href="javascript:showPage('/bdc/zd/view');"><span class="am-icon-map"></span> 宗地属性</a>
                        </li>
                        <li><a href="javascript:showPage('/bdc/cq/view');"><span
                                class="am-icon-plug"></span> 产权信息</a></li>
                       <li><a href="javascript:showPage('/bdc/fj/view');"><span
                                class="am-icon-folder-open"></span> 交易附件</a></li>
                    </ul>
                </li>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="javascript:showPage('/sys/users/view');"><span class="am-icon-user"></span> 用户信息</a>
                    </li>
                </security:authorize>
                <li><a href="/logout"><span class="am-icon-sign-out"></span> 注销</a></li>
            </ul>

            <div class="am-panel am-panel-default admin-sidebar-panel">
                <div class="am-panel-bd">
                    <p><span class="am-icon-bookmark"></span>公告</p>
                    <security:authorize access="isAuthenticated()">
                        <p>欢迎您：<security:authentication property="principal.username" var="username"/>${username}
                            ，您拥有以下权限：</p>
                    </security:authorize>
                    <p>
                        <security:authorize access="hasRole('ROLE_GUEST')">
                    <li>查询浏览</li>
                    </security:authorize>
                    <security:authorize access="hasRole('ROLE_USER')">
                        <li>数据操作</li>
                    </security:authorize>
                    <security:authorize access="hasRole('ROLE_ADMIN')">
                        <li>系统管理</li>
                    </security:authorize>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <!-- sidebar end -->

    <!-- content start -->
    <div class="admin-content">
        <div id="viewMain" class="admin-content-body">
            <div class="am-cf am-padding">
                <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong> /
                    <small>一些常用模块</small>
                </div>
            </div>

            <div class="am-g">
                <div class="am-u-sm-12">
                    <canvas id="appChart"></canvas>
                </div>
            </div>

            <ul class="am-avg-sm-1 am-avg-md-4 am-margin am-padding am-text-center admin-content-list">
                <li><a href="javascript:showPage('/tax/ws/view');">
                    <span class="am-icon-btn am-icon-file-text"></span><br/>完税信息</a>
                </li>
                <li><a href="javascript:showPage('/tax/sh/view');">
                    <span class="am-icon-btn am-icon-briefcase"></span><br/>审核资料</a>
                </li>
                <li><a href="javascript:showPage('/tax/ts/view');">
                    <span class="am-icon-btn am-icon-recycle"></span><br/>退税信息</a>
                </li>
                <li><a href="javascript:showPage('/tax/fj/view');">
                    <span class="am-icon-btn am-icon-wpforms"></span><br/>税票附件</a>
                </li>
            </ul>
            <ul class="am-avg-sm-1 am-avg-md-4 am-margin am-padding am-text-center admin-content-list ">
                <li><a href="javascript:showPage('/bdc/fw/view');">
                    <span class="am-icon-btn am-icon-building"></span><br/>房屋属性</a>
                </li>
                <li><a href="javascript:showPage('/bdc/zd/view');">
                    <span class="am-icon-btn am-icon-map"></span><br/>宗地属性</a>
                </li>
                <li><a href="javascript:showPage('/bdc/cq/view');">
                    <span class="am-icon-btn am-icon-plug"></span><br/>产权信息</a>
                </li>
                <li><a href="javascript:showPage('/sys/users/view');">
                    <span class="am-icon-btn am-icon-user"></span><br/>用户信息</a>
                </li>
            </ul>
        </div>

        <footer class="admin-content-footer">
            <hr>
            <p style="text-align: center"><spring:message code="app.footer"/></p>
        </footer>
    </div>
    <!-- content end -->
</div>
<div class="am-modal am-modal-prompt" tabindex="-1" id="appPrompt">
    <div id="appMsg" class="am-modal-dialog">
    </div>
</div>
<script src="/static/assets/js/jquery-3.3.1.min.js"></script>
<script src="/static/assets/js/jquery.validate.min.js"></script>
<script src="/static/assets/js/jquery.validate.msg_zh.min.js"></script>
<script src="/static/assets/js/amazeui.ie8polyfill.min.js"></script>
<script src="/static/assets/js/amazeui.js"></script>
<script src="/static/assets/js/amazeui.widgets.helper.js"></script>
<script src="/static/assets/js/amazeui.datatables.js"></script>
<script src="/static/assets/js/jquery.growl.js"></script>
<script src="/static/assets/js/Chart.min.js"></script>
<script src="/static/js/mainboard.js"></script>
<script>
    $(document).ready(function () {
        var json = ${chartData};
        console.log("数据：" + json);
        var chartjsData = [];
        for (var i = 0; i < json.length; i++) {
            chartjsData.push(json[i].data);
        }
        var chartjslabel = [];
        for (var i = 0; i < json.length; i++) {
            chartjslabel.push(json[i].label);
        }
        var ctx = document.getElementById("appChart").getContext('2d');
        var myChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: chartjslabel,
                datasets: [{
                    label: '不动产交易量走势',
                    data: chartjsData,
                    backgroundColor: ["rgba(255, 99, 132, 0.2)"],
                    borderColor: ["rgb(255, 99, 132)"],
                    borderWidth: 1
                }]
            }
        });
    });
</script>
</body>
</html>