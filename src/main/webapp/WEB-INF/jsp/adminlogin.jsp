<%--
  Created by IntelliJ IDEA.
  User: fenzx
  Date: 2019/6/4
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="/css/bootstrap.css"/>
    <script src="/js/jquery-3.3.1.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/dataTables.bootstrap-1.10.13.js"></script>
</head>
<style>
    div{
        margin: 5px;
        padding: 5px;
    }
</style>
<body>
<form action="/admin/login" method="post">
<div class="container">
    <div><h1>管理员登录/注册</h1></div>
    <div>
        <span>用户名：</span>
        <input type="text" name="adminName">
    </div>
    <div>
        <span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
        <input type="password" name="adminPassword">
    </div>
    <div>
        <input type="checkbox" name="loginToken" value="loginToken">
        <span>五天免登录</span>
    </div>

    <div>
        <button type="submit" class="btn btn-info" id="login">登录</button>
       <%-- <button type="submit" class="btn btn-success" id="register">注册</button>--%>
    </div>

</div>
</form>

</body>
</html>
