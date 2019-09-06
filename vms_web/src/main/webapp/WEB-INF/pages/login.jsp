<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>欢迎使用京武智疫苗管理系统</title>
    <meta name="keywords" content="HTML5 Bootstrap 3 Admin Template UI Theme" />
    <meta name="description" content="AbsoluteAdmin - A Responsive HTML5 Admin UI Framework">
    <meta name="author" content="AbsoluteAdmin">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../../assets/skin/default_skin/css/theme.css">
    <link rel="stylesheet" type="text/css" href="../../assets/admin-tools/admin-forms/css/admin-forms.css">
    <link rel="shortcut icon" href="../../assets/img/favicon.ico">
</head>
<body class="external-page external-alt sb-l-c sb-r-c">
<div id="main" class="animated fadeIn">
    <section id="content_wrapper">
        <section id="content">
            <div class="admin-form theme-info mw500" id="login">
                <div class="content-header">
                    <h1> 京武疫苗系统</h1>
                    <p class="lead">欢迎使用京武智能疫苗管理系统</p>
                </div>
                <div class="panel mt30 mb25">
                    <form:form method="post" action="/user/login" id="contact">
                        <div class="panel-body bg-light p25 pb15">
                            <div class="section">
                                <label for="account" class="field-label text-muted fs18 mb10">账号</label>
                                <label for="account" class="field prepend-icon">
                                    <input type="text" name="account" id="account" class="gui-input" placeholder="请输入账号...">
                                    <label for="account" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="section">
                                <label for="password" class="field-label text-muted fs18 mb10">密码</label>
                                <label for="password" class="field prepend-icon">
                                    <input type="password" name="password" id="password" class="gui-input" placeholder="请输入密码...">
                                    <label for="password" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="panel-footer clearfix">
                            <a><button type="button" onclick="window.location.href='/user/to_register'" class="button btn-primary mr10 pull-left">注册</button></a>
                            <span id="sp" style="text-align: right;display: block;color: #FD482C;margin-right: 100px;margin-bottom: 4px;">${sessionScope.error}</span>
                            <button type="submit" class="button btn-primary mr10 pull-right">登录</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </section>
    </section>
</div>
　
<script src="../../vendor/jquery/jquery-1.11.1.min.js"></script>
<script src="../../vendor/jquery/jquery_ui/jquery-ui.min.js"></script>
<script src="../../assets/js/utility/utility.js"></script>
<script src="../../assets/js/demo/demo.js"></script>
<script src="../../assets/js/main.js"></script>
</body>
</html>
