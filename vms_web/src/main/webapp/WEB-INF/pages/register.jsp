<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <style type="text/css">
        body{
            overflow-x:hidden;
        }
        #main{
            width:1200px;
            height:600px;
            margin-left:500px;
        }
    </style>
</head>
<body>

<div id="main">
    <!-- 标题 -->
    <div class="row">
        <div class="col-md-12">
            <h1>注册用户</h1>
        </div>
    </div>

    <form:form modelAttribute="user" id="admin-form" action="/user/register" method="post" class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-1 control-label">账号</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" name="account" placeholder="请输入账号">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">密码</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" name="password" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">用户类型</label>
            <div class="col-sm-3">
                <form:select path="type" items="${type}" cssClass="form-control" placeholder="类型..."/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-3">
                <span id="sp" style="text-align: right;display: block;color: #FD482C;margin-right: 100px;margin-bottom: 4px;">${sessionScope.register_warn}</span>
                <button type="submit" class="btn btn-default">提交</button>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
