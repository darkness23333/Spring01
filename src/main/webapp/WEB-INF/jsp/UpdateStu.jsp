<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生</title>
    <link rel="stylesheet" href="/css/bootstrap.css"/>
    <script src="/js/jquery-3.3.1.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<style>
    div{
        padding: 10px;
        margin: 5px;
    }
    button{
        margin: 15px;
    }
</style>
<body>

  <div class="container">
      <form action="/stu/UpdateStu" method="post">
    <div>
      <span>ID：</span>
      <input type="text" name="id" placeholder="id" readonly value="${QStu.id}">
    </div>
    <div>
      <span>姓名：</span>
      <input type="text" name="name" placeholder="姓名" value="${QStu.name}">
  </div>
    <div>
        <span>性别：</span>
        <input type="text" name="sex" placeholder="性别" value="${QStu.sex}">
    </div>
    <div>
        <span>年龄：</span>
        <input type="text" name="age" placeholder="年龄" value="${QStu.age}">
    </div>
    <div>
        <span>班级：</span>
        <input type="text" name="className" placeholder="班级" value="${QStu.className}">
    </div>
      <div>
          <button class="btn btn-danger" onclick="javascript:window.history.back(-1);">返回</button>
          <button type="submit" class="btn btn-info">修改</button>
      </div>
      </form>
  </div>
</body>
</html>
