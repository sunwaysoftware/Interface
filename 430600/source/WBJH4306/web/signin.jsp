<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String err = request.getParameter("error");%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>不动产交易涉税信息管理平台</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link href="/favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" href="/static/assets/css/amazeui.css"/>
    <style>
        .header {
            text-align: center;
            background: #0066FF;
            color: #fff;
        }
        .header h1 {
            font-size: 250%;
            color: #ffffff;
            margin-top: 30px;
        }
        .text {
            position:relative;
        }
        span {
            text-shadow:
            0 -1px 0 #858585,
            0 1px 10px rgba(0,0,0,.6),
            0 6px 1px rgba(0,0,0,.1),
            0 0 5px rgba(0,0,0,.2),
            0 1px 3px rgba(0,0,0,.3),
            0 3px 5px rgba(0,0,0,.2),
            0 7px 10px rgba(0,0,0,.25),
            0 15px 10px rgba(0,0,0,.2),
            0 25px 15px rgba(0,0,0,.15);
        }
    </style>
</head>
<body>
<div class="header">
    <div class="am-g">
        <h1 class="text"><span>国家税务总局岳阳市税务局</span></h1>
        <h1 class="text"><span>不 动 产 交 易 涉 税 信 息 管 理 平 台</span></h1>
    </div>
    <hr/>
</div>

<div class="am-g">
    <div class="am-u-lg-4 am-u-md-6 am-u-sm-centered">
        <% if (err != null) { %>
        <div class="am-alert am-alert-warning" data-am-alert>
            登录失败，请重新确认账号和密码后重试！
        </div>
        <% } %>
        <br>
        <form id="frmLogin" method="post" class="am-form" action="j_spring_security_check">
            <label for="userid">账号:</label>
            <input type="text" name="j_username" id="userid" placeholder="输入帐号" required  />
            <br>
            <label for="password">密码:</label>
            <input type="password" name="j_password" id="password" placeholder="输入密码" required/>
            <br><br>
            <div class="">
                <input type="submit" name="" value="登 录" class="am-btn am-btn-block am-btn-primary" />
            </div>
        </form>
        <hr>
        <p style="text-align: center;">&copy; 2019-2021 丹东三伟软件科技有限公司 技术支持</p>
    </div>
</div>
</body>
</html>